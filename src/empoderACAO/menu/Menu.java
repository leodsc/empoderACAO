package empoderACAO.menu;

import java.util.Scanner;

public class Menu {
	char decisao;

	public void comeco() {
		Scanner sc = new Scanner(System.in);

		System.out.println("===========================");
		System.out.println("\tEMPODERACAO");
		System.out.println("===========================");
		
		System.out.println("Olá, vamos nos conectar.");
		System.out.println("Você aceita o nosso termo?");
		System.out.println("Termo:\nDeclaramos, para os devidos fins, que concordamos com as "
				+ "informações a seguir e afirmo estar ciente que este aplicativo\nreferencia a"
			+ "busca por um prognóstico. Necessário ser maior de 17 anos.");
		
		System.out.println("Você aceita o temos? Digite S para sim ou N para não");

		decisao = sc.next().charAt(0); 
		sc.nextLine(); // comer o caracter '\n'

		if (decisao == 'S' || decisao == 's') {
			System.out.printf("Digite a sua idade: ");
			int idade = sc.nextInt();

			if (idade < 18) {
				terminarPrograma("menor de 18 anos");
			}

			System.out.printf("Digite o seu sexo: Digite M para masculino ou F para feminino");
			char sexo = sc.next().charAt(0);
			
			if (sexo == 'M') {
				terminarPrograma("você é homem, rs"); // ARRUMAR
			}

			System.out.printf("Digite o seu nome: ");
			String nome = sc.nextLine();
			sc.nextLine();
			System.out.printf("Digite o seu estado: ");
			String estado = sc.nextLine();

			Usuario usuario = new Usuario(nome, sexo, estado, idade);
			
		} else {
			terminarPrograma("não aceitou os termos");
		}
	}
	
	public void terminarPrograma(String motivo) {
		System.out.println("Indique o nosso aplicativo para amigos ou parentes, "
				+ "isso poderá mudar a vida de quem você ama.");
		System.out.println("Programa fechando......... " + motivo);
		System.exit(0);
	}
}
