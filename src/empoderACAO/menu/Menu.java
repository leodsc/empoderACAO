package empoderACAO.menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	char decisao;
	private Scanner sc = new Scanner(System.in);
	private HashMap<String, String> listaHospitais = Dados.construirHash();

	public void comeco() throws IOException {

		try {
			Dados.carregar();
		} catch (FileNotFoundException e) {
			Dados.criarBanco();
		}
		mostrarLogo();
		
		System.out.println("Olá, vamos nos conectar.");
		System.out.println("Você aceita o nosso termo?");
		System.out.println("Termo:\nDeclaramos, para os devidos fins, que concordamos com as "
				+ "informações a seguir e afirmo estar ciente que este aplicativo\nreferencia a "
			+ "busca por um prognóstico. Necessário ser maior de 18 anos.");
		
		System.out.println("Você aceita o temos? Digite S para sim ou N para não");

		decisao = sc.next().charAt(0); 
		sc.nextLine(); // comer o caracter '\n'

		if (decisao == 'S' || decisao == 's') {
			int idade = 0;
			char sexo = 'a';
			String nome = "l";
			String estado = "l";

			try {
				System.out.printf("Digite a sua idade: ");
				idade = sc.nextInt();
			} catch (InputMismatchException e) {
				terminarPrograma("Apenas números são aceitos nesse campo!");
			}

			if (idade < 18) {
				terminarPrograma("menor de 18 anos");
			}

			System.out.printf("Digite o seu sexo:\n Digite M para masculino ou F para feminino ");

			try {
				sexo = sc.next().charAt(0);
			} catch(InputMismatchException e) {
				terminarPrograma("Apenas UMA letra é aceita nesse campo!");
			}
			
			if (sexo != 'M') {
				terminarPrograma("você é homem, rs"); // ARRUMAR
			}
			
			try {
				System.out.printf("Digite o seu nome: ");
				nome = sc.nextLine();
				System.out.printf("Digite o seu estado: ");
				estado = sc.nextLine();
			} catch(InputMismatchException e) {
				terminarPrograma("Apenas letras são aceitas nesses campos!");
			}

			Usuario usuario = new Usuario(nome, sexo, estado, idade);
			Dados.registrar(usuario);
			boolean deveProcurarHospital = fazerPerguntas();
			if (deveProcurarHospital) {
				mostrarHospitalMaisProximo(usuario);
			} else {
				System.out.println("Indique o nosso aplicativo para amigos ou parentes,"
						+ " isso poderá mudar a vida de quem você ama.");
			}
		} else {
			terminarPrograma("não aceitou os termos");
		}
	}
	
	public boolean fazerPerguntas() {
		String[] perguntas = new String[4];
		perguntas[0] = "Teve algum caso na família de câncer de mama?[Digite 1 para \"SIM\" 2 para \"NÃO\"]";
		perguntas[1] = "Você já fez o autoexame? [Digite 1 para \"SIM\" 2 para \"NÃO\"]";
		perguntas[2] = "Você já sentiu algum desconforto ou dor nas mamas? [Digite 1 para \"SIM\" 2 para \"NÃO\"]";
		perguntas[3] = "Você já sentiu algum caroço anormal em seu seio? [Digite 1 para \"SIM\" 2 para \"NÃO\"]";

		for (String s: perguntas) {
			System.out.println(s);
			int resposta = sc.nextInt();
			if (resposta == 1) {
				System.out.println("Indicamos que procure o hospital de referência no seu estado.");
				return true;
			}
		}
		return false;
	}
	
	public void terminarPrograma(String motivo) {
		System.out.println("Indique o nosso aplicativo para amigos ou parentes, "
				+ "isso poderá mudar a vida de quem você ama.");
		System.out.println("Total de pessoas que fizeram o teste: " + Dados.getBanco().size());
		System.out.println("Programa fechando......... " + motivo);
		System.exit(0);
	}
	
	public void mostrarHospitalMaisProximo(Usuario usuario) {
		System.out.printf(usuario.getNome() + ", indicamos que procure o Hospital de referência no seu estado: ");
		String estado = usuario.getEstado();
		System.out.println(listaHospitais.get(estado));
	}
	
	public void mostrarLogo() {
			System.out.println("8 8888888888            ,8.       ,8.          8 888888888o       ,o888888o.     ");
			System.out.println("8 8888                 ,888.     ,888.         8 8888    `88.  . 8888     `88.   ");
			System.out.println("8 8888                .`8888.   .`8888.        8 8888     `88 ,8 8888       `8b  ");
			System.out.println("8 8888               ,8.`8888. ,8.`8888.       8 8888     ,88 88 8888        `8b ");
			System.out.println("8 888888888888      ,8'8.`8888,8^8.`8888.      8 8888.   ,88' 88 8888         88 ");
			System.out.println("8 8888             ,8' `8.`8888' `8.`8888.     8 888888888P'  88 8888         88 ");
			System.out.println("8 8888            ,8'   `8.`88'   `8.`8888.    8 8888         88 8888        ,8P ");
			System.out.println("8 8888           ,8'     `8.`'     `8.`8888.   8 8888         `8 8888       ,8P  ");
			System.out.println("8 8888          ,8'       `8        `8.`8888.  8 8888          ` 8888     ,88'   ");
			System.out.println("8 888888888888 ,8'         `         `8.`8888. 8 8888             `8888888P'     ");
			System.out.println();																
			System.out.println("8 888888888o.      8 8888888888   8 888888888o.                                  ");
			System.out.println("8 8888    `^888.   8 8888         8 8888    `88.                                 ");
			System.out.println("8 8888        `88. 8 8888         8 8888     `88                                 ");
			System.out.println("8 8888         `88 8 8888         8 8888     ,88                                 ");
			System.out.println("8 8888          88 8 888888888888 8 8888.   ,88'                                 ");
			System.out.println("8 8888          88 8 8888         8 888888888P'                                  ");
			System.out.println("8 8888         ,88 8 8888         8 8888`8b                                      ");
			System.out.println("8 8888        ,88' 8 8888         8 8888 `8b.                                    ");
			System.out.println("8 8888    ,o88P'   8 8888         8 8888   `8b.                                  ");
			System.out.println("8 888888888P'      8 888888888888 8 8888     `88.                                ");
			System.out.println();								
			System.out.println(".8.           ,o888888o.           .8.           ,o888888o.             ");
			System.out.println(".888.         8888     `88.        .888.       . 8888     `88.           ");
			System.out.println(":88888.     ,8 8888       `8.      :88888.     ,8 8888       `8b          ");
			System.out.println(". `88888.    88 8888               . `88888.    88 8888        `8b         ");
			System.out.println(".8. `88888.   88 8888              .8. `88888.   88 8888         88         ");
			System.out.println(".8`8. `88888.  88 8888             .8`8. `88888.  88 8888         88         ");
			System.out.println(".8' `8. `88888. 88 8888            .8' `8. `88888. 88 8888        ,8P         ");
			System.out.println(".8'   `8. `88888.`8 8888       .8' .8'   `8. `88888.`8 8888       ,8P          ");
			System.out.println(".888888888. `88888.  8888     ,88' .888888888. `88888.` 8888     ,88'           ");
			System.out.println(".8'       `8. `88888.  `8888888P'  .8'       `8. `88888.  `8888888P'             ");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
	}
}
