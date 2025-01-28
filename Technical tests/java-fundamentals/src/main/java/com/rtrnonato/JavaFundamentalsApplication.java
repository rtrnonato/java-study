package com.rtrnonato;

import java.util.List;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaFundamentalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaFundamentalsApplication.class, args);

		/*
		 * Questão-1 
		 * Escreva um método em Java chamado isPalindrome que receba uma
		 * string como entrada e retorne true se a string for um palíndromo (ou seja,
		 * lida da mesma forma de trás pa
		 * a frente). Ignore espaços e diferenças entre
		 * maiúsculas e minúsculas.
		 * 
		 * public boolean isPalindrome(String input) { 
		 *    TODO:Implementar 
		 * } 
		 * 
		 */
		
		System.out.println(isPalindrome("A man a plan a canal Panama")); // true
		System.out.println(isPalindrome("racecar")); // true
		System.out.println(isPalindrome("hello")); // false
		System.out.println(isPalindrome("Was it a car or a cat I saw")); // true
		System.out.println(isPalindrome("12321")); // true
		System.out.println(isPalindrome("12345")); // false
		}
	
	public static boolean isPalindrome(String input) {
		// Limpar a entrada: remover espaços e converter para letras minúsculas.
		String sanitized = input.replaceAll("\\s+","").toLowerCase();
		
		// Verificar se a string é igual ao seu reverso
		int left = 0;
	    int right = sanitized.length() - 1;
		
	    while (left < right) {
			if (sanitized.charAt(left) != sanitized.charAt(right)) {
				return false;
			}
			left++;
            right--;
		}
		
	    return true;
	}
}