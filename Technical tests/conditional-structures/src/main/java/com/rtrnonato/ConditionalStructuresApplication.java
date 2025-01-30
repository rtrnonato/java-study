package com.rtrnonato;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConditionalStructuresApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConditionalStructuresApplication.class, args);

		/**
		 * Implemente um método chamado fizzBuzz que receba um número inteiro positivo e
		 * retorne:
		 * 
		 * "Fizz" se o número for divisível por 3. 
		 * "Buzz" se o número for divisível por 5.
		 * "FizzBuzz" se o número for divisível por ambos. 
		 * O próprio número (como string) caso contrário. 
		 * Exemplo:
		 * 
		 * Entrada: 15 
		 * Saída: "FizzBuzz" 
		 * public String fizzBuzz(int number) { // TODO: Implementar }
		 */
		
		try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a positive integer: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Error: Please enter a valid integer.");
                return;
            }
            
             int number = scanner.nextInt();
             
            if (number <= 0) {
                System.out.println("Error: Please enter a positive integer.");
            } else {
                System.out.println("Output: " + fizzBuzz(number)); 
			}
		} catch (InputMismatchException e) {
			System.out.println("Error: Invalid input. Please enter a valid integer.");
		}
	}

	public static String fizzBuzz(int number) {
		if (number % 3 == 0 && number % 5 == 0) {
			return "FizzBuzz";
		} else if (number % 3 == 0) {
			return "Fizz";
		} else if (number % 5 == 0) {
			return "Buzz";
		}
		return String.valueOf(number);
	}
}