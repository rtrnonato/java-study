package com.rtrnonato.menuonline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import entities.Employee;

@SpringBootApplication
public class StreamExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamExerciseApplication.class, args);

		/*
		 * Fazer um programa para ler os dados (nome, email e salário) de funcionários a
		 * partir de um arquivo em formato .csv. Em seguida mostrar, em ordem
		 * alfabética, o email dos funcionários cujo salário seja superior a um dado
		 * valor fornecido pelo usuário. Mostrar também a soma dos salários dos
		 * funcionários cujo nome começa com a letra 'M'.
		 */

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter full file path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Employee> list = new ArrayList<>();

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}

			System.out.println("Enter salary ");
			Double salary = sc.nextDouble();

			List<Employee> filterSalary = list.stream()
					.filter(n -> n.getSalary() > salary)
					.sorted(Comparator.comparing(Employee::getEmail))
					.collect(Collectors.toList());

			System.out.println("Email of people whose salary is more than " + salary + " : " + filterSalary.toString());

			Double sumSalary = list.stream()
					.filter(n -> n.getName().charAt(0) == 'M')
					.map(n -> n.getSalary())
					.reduce(0.0, Double::sum);

			System.out.println("Sum of salary of people whose name starts with 'M': " + sumSalary);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}

}
