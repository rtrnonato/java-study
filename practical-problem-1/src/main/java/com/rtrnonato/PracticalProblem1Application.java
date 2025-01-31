package com.rtrnonato;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticalProblem1Application {

	public static void main(String[] args) {
		SpringApplication.run(PracticalProblem1Application.class, args);
		/**
		 * Cenário 
		 * Uma empresa de e-commerce precisa de um sistema para calcular
		 * descontos progressivos para seus clientes. O desconto depende do valor total
		 * da compra conforme as regras abaixo:
		 * 
		 * Compras abaixo de R$100,00: sem desconto 
		 * Compras entre R$100,00 e R$500,00: 5% de desconto 
		 * Compras entre R$500,01 e R$1000,00: 10% de desconto 
		 * Compras acima de R$1000,00: 15% de desconto
		 *
		 * Além disso, se o cliente for VIP, ele recebe um bônus extra de 5% de
		 * desconto, independentemente do valor da compra.
		 * 
		 * Tarefa
         * Implemente um método chamado calculateDiscount(double totalPurchase, boolean isVIP) que:
         * Receba o valor total da compra e se o cliente é VIP.
         * Calcule e retorne o valor final da compra com o desconto aplicado.
         * 
		 */
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Digite o valor total da compra: ");
			double totalPurchase = sc.nextDouble();
			System.out.println("O cliente é VIP? (true/false): ");
			boolean isVIP = sc.nextBoolean();

			System.out.println("O valor final da compra com desconto é: " + calculateDiscount(totalPurchase, isVIP));
		} catch (InputMismatchException e) {
            System.out.println("Erro ao calcular o desconto: " + e.getMessage());
		}
	}
	
   public static double calculateDiscount(double totalPurchase, boolean isVIP) {
	   double valueFinal = 0.0;
	   if (totalPurchase < 100) {
		   valueFinal = totalPurchase;		   
	   } else if (totalPurchase >= 100 && totalPurchase <= 500) {
		   valueFinal = totalPurchase - (totalPurchase * 0.05);
	   } else if (totalPurchase >500.01 && totalPurchase <= 1000) {
		   valueFinal = totalPurchase - (totalPurchase * 0.10);
	   } else if (totalPurchase > 1000) {
		   valueFinal = totalPurchase - (totalPurchase * 0.15);
	   }
	   
	   if (isVIP) {
		   return valueFinal - (valueFinal * 0.05);
	   } else {
		   return valueFinal;
	   }
   }
}
