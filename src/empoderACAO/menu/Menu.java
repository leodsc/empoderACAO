package empoderACAO.menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/*
 * Menu classe que armazena o menu do programa
 */
public class Menu {
	
	/** verifica se o usuario aceitou os termos de uso. */
	char aceitaTermo;
	
	/** Scanner que captura os dados do usuário. */
	private Scanner sc = new Scanner(System.in);
	
	/** Cria um hashmap que permite mapear os estados com cada hospital referencia. */
	private HashMap<String, String> listaHospitais = Dados.construirHash();

	/**
	 * Comeco.
	 *
	 * @throws IOException IOException caso ocorra um problema no arquivo txt.
	 * @throws InterruptedException thread sleep
	 */
	// funcao que inicia o menu
	/**
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void comeco() throws IOException, InterruptedException {

		// bloco try que evita erro caso o arquivo não exista no sistema
		try {
			Dados.carregar();
		} catch (FileNotFoundException e) {
			Dados.criarBanco();
		}
		mostrarLogo();
		
		System.out.println("Olá, vamos nos conectar.");
		Thread.sleep(1500);
		System.out.println();
		System.out.println("Você aceita o nosso termo?");
		Thread.sleep(2000);
		System.out.println("Termo:\nDeclaramos, para os devidos fins, que concordamos com as "
				+ "informações a seguir e afirmo estar ciente que este aplicativo\nreferencia a "
			+ "busca por um prognóstico. Necessário ser maior de 18 anos.");
		
		System.out.println("Você aceita o temos? Digite S para sim ou N para não");

		aceitaTermo = sc.next().charAt(0); 
		sc.nextLine(); // comer o caracter '\n'

		if (aceitaTermo == 'S' || aceitaTermo == 's') {
			int idade = 0;
			char sexo = 'a';
			String nome = "l";
			String estado = "l";

			try {
				System.out.printf("Digite a sua idade: \n");
				idade = sc.nextInt();
				System.out.println("=================================");
			} catch (InputMismatchException e) {
				terminarPrograma("Apenas números são aceitos nesse campo!");
			}

			if (idade < 18) {
				terminarPrograma("menor de 18 anos");
			}

			System.out.printf("Digite o seu sexo, M para masculino ou F para feminino ");
			System.out.println();

			try {
				sexo = sc.next().charAt(0);
				System.out.println("=================================");
			} catch(InputMismatchException e) {
				terminarPrograma("Apenas UMA letra é aceita nesse campo!");
			}
			
			if (sexo != 'F' && sexo != 'f') {
				terminarPrograma("você é homem, rs"); // ARRUMAR
			}
			
			try {
				System.out.printf("Digite o seu nome: ");
				System.out.println();
				sc.nextLine();
				nome = sc.nextLine();
				System.out.println("=================================");
				System.out.printf("Digite o seu estado: ");
				System.out.println();
				estado = sc.nextLine().toUpperCase();
				System.out.println("=================================");
			} catch(InputMismatchException e) {
				terminarPrograma("Apenas letras são aceitas nesses campos!");
			}

			Usuario usuario = new Usuario(nome, sexo, estado, idade);
			
			// registra um novo usuario
			Dados.registrar(usuario);
			// se responder sim para alguma pergunta, recomendar ir ao hospital
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
	
	/**
	 * Faz as 4 perguntas sobre o câncer para o usuário.
	 *
	 * @return true, se bem sucedido 
	 */
	public boolean fazerPerguntas() {
		String[] perguntas = new String[4];
		perguntas[0] = "Teve algum caso na família de câncer de mama?[Digite 1 para \"SIM\" 2 para \"NÃO\"]";
		perguntas[1] = "Você já fez o autoexame? [Digite 1 para \"SIM\" 2 para \"NÃO\"]";
		perguntas[2] = "Você já sentiu algum desconforto ou dor nas mamas? [Digite 1 para \"SIM\" 2 para \"NÃO\"]";
		perguntas[3] = "Você já sentiu algum caroço anormal em seu seio? [Digite 1 para \"SIM\" 2 para \"NÃO\"]";

		for (String pergunta: perguntas) {
			System.out.println(pergunta);
			try {
				int resposta = sc.nextInt();
				if (resposta == 1) {
					return true;
				} else if (resposta > 2) {
					terminarPrograma("Você digitou um valor inválido.");
				}
			} catch(InputMismatchException e) {
				terminarPrograma("Por favor, digite um valor válido.");
			} 
		}
		return false;
	}
	
	/**
	 * Termina o programa.
	 *
	 * @param motivo por que o programa terminou, vazio se ocorreu o procedimento normal
	 */
	public void terminarPrograma(String motivo) {
		System.out.println("Indique o nosso aplicativo para amigos ou parentes, "
				+ "isso poderá mudar a vida de quem você ama.");
		System.out.println("Total de pessoas que fizeram o teste: " + Dados.getBanco().size());
		System.out.println("Programa fechando......... " + motivo);
		System.exit(0);
	}
	
	/**
	 * Mostrar hospital mais proximo.
	 *
	 * @param usuario estrutura que armazena os dados do usuario utilizando o programa
	 * @throws InterruptedException 
	 */
	public void mostrarHospitalMaisProximo(Usuario usuario) throws InterruptedException {
		String estado = usuario.getEstado();
		System.out.println("Você conhece o Auto Exame de Mamas? \n\nA recomendação atual para prevenção");
		System.out.println("do Câncer de Mama é a realização do auto exame uma vez por mês, ");
		Thread.sleep(4000);
		System.out.println("assim você consegue reconhecer caso houver alguma diferença ou desconforto nos seus seios. \n");
		System.out.println("Veja mais sobre como realizar o auto exame abaixo:\r\n");
		Thread.sleep(5000);
		System.out.println("- Em pé (pode ser durante o banho):\r\n");
		System.out.println("- Levante seu braço esquerdo e apoie-o sobre a cabeça;\r\n");
		System.out.println("- Com a mão direita esticada, examine a mama esquerda;\r\n");
		System.out.println("- Divida o seio em faixas e analise devagar cada uma dessas faixas. ...\r\n");
		System.out.println("- Sinta a mama;\r\n");
		System.out.println("- Faça movimentos circulares, de cima para baixo;\r\n");
		System.out.println("- Repita os movimentos na outra mama.\r\n");
		Thread.sleep(15000);
		System.out.println("Indicamos o " + listaHospitais.get(estado));
		System.out.println("Agradecemos imensamente por ter usado nosso programa! \nEsperamos que juntos podermos ajudar quem amamos e prevenir os casos de Câncer de Mama no Brasil.\r\n");
		terminarPrograma("");
	}
	
	/**
	 * Mostra logo.
	 */
	public void mostrarLogo() {
		System.out.println("███████╗███╗   ███╗██████╗  ██████╗ ██████╗ ███████╗██████╗ ");
		System.out.println("██╔════╝████╗ ████║██╔══██╗██╔═══██╗██╔══██╗██╔════╝██╔══██╗");
		System.out.println("█████╗  ██╔████╔██║██████╔╝██║   ██║██║  ██║█████╗  ██████╔╝");
		System.out.println("██╔══╝  ██║╚██╔╝██║██╔═══╝ ██║   ██║██║  ██║██╔══╝  ██╔══██╗");
		System.out.println("███████╗██║ ╚═╝ ██║██║     ╚██████╔╝██████╔╝███████╗██║  ██║");
		System.out.println("╚══════╝╚═╝     ╚═╝╚═╝      ╚═════╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝");
		System.out.println();
		System.out.println("█████╗  ██████╗ █████╗  ██████╗                            ");
		System.out.println("██╔══██╗██╔════╝██╔══██╗██╔═══██╗                           ");
		System.out.println("███████║██║     ███████║██║   ██║                           ");
		System.out.println("██╔══██║██║     ██╔══██║██║   ██║                           ");
		System.out.println("██║  ██║╚██████╗██║  ██║╚██████╔╝                           ");
		System.out.println("╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝ ╚═════╝ ");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
}
