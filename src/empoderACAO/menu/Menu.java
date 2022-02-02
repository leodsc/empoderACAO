package empoderACAO.menu;

import java.util.Scanner;
import java.util.HashMap;

public class Menu {
	char decisao;
	private Scanner sc = new Scanner(System.in);
	private HashMap<String, String> listaHospitais = Dados.construirHash();

	public void comeco() {

		System.out.println("===========================");
		System.out.println("\tEMPODERACAO");
		System.out.println("===========================");
		
		System.out.println("Olá, vamos nos conectar.");
		System.out.println("Você aceita o nosso termo?");
		System.out.println("Termo:\nDeclaramos, para os devidos fins, que concordamos com as "
				+ "informações a seguir e afirmo estar ciente que este aplicativo\nreferencia a "
			+ "busca por um prognóstico. Necessário ser maior de 18 anos.");
		
		System.out.println("Você aceita o temos? Digite S para sim ou N para não");

		decisao = sc.next().charAt(0); 
		sc.nextLine(); // comer o caracter '\n'

		if (decisao == 'S' || decisao == 's') {
			System.out.printf("Digite a sua idade: ");
			int idade = sc.nextInt();

			if (idade < 18) {
				terminarPrograma("menor de 18 anos");
			}

			System.out.printf("Digite o seu sexo:\n Digite M para masculino ou F para feminino ");
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
		System.out.println("Programa fechando......... " + motivo);
		System.exit(0);
	}
	
	public void mostrarHospitalMaisProximo(Usuario usuario) {
		System.out.printf(usuario.getNome() + ", indicamos que procure o Hospital de referência no seu estado: ");
		String estado = usuario.getEstado();
		System.out.println(listaHospitais.get(estado));
	}
}
