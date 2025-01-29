package com.rtrnonato;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataTypesAndConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataTypesAndConversionApplication.class, args);
		/* Escreva um método chamado convertToBinary que receba um número inteiro positivo como entrada e retorne a sua representação binária em forma de string.
		 * 
		 * Exemplo:
		 * Entrada: 5  
		 * Saída: "101"
		 * 
		 * public String convertToBinary(int number) {
		 *   // TODO: Implementar
		 * }
		 * 
		 */

		try (Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Enter of number positive and integer: ");
			if (!sc.hasNextInt()) { // Valida se a entrada é um inteiro
                System.out.println("Error: Please enter a valid integer.");
                return;
            }
			
			int number = sc.nextInt();
			
			 // Valida se o número é positivo
            if (number < 0) {
                System.out.println("Error: Please enter a positive integer.");
            } else {
                System.out.println("Binary = " + convertToBinary(number));
            }
          		
		} catch (InputMismatchException e) {
			System.out.println("Error: Invalid input. Please enter a valid integer.");
		}
		
	}
	public static String convertToBinary (int number) {
		return Integer.toBinaryString(number);
	}
}
