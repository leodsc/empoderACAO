package empoderACAO.menu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * Classe Dados.
 */
public abstract class Dados {
	
	/** estrutura que armazena cada usuário que fez o teste. */
	private static ArrayList<String> banco = new ArrayList<String>();
	
	/** nome do usuário no sistema. */
	private static String userName = System.getProperty("user.name");
	
	/** registra local em que deve se encontrar o arquivo txt. */
	private static String local = "C:\\Users\\" + userName +"\\dados.txt";

	/** lista de todos os estados brasileiros. */
	private static String[] listaEstados = {
			"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", 
			"PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"
			};
	
	/** lista de hospitais dos respectivos estados. */
	private static String[] listaHospitais = {
			"Hospital da Fundação Hospitalar Estadual do Acre (Unacon com Serviço de Radioterapia)",
			"Centro Hospitalar Manoel André / Chama (Unacon com Radioterapia)",
			"Hospital de Clínicas Dr. Alberto Lima (Unacon)",
			"Hospital da Fundação Centro de Controle de Oncologia/Cecon (Unacon com serviços de Radioterapia, Hematologia e Oncologia Pediátrica)",
			"Hospital Dom Pedro de Alcântara/Santa Casa de Misericórdia de Feira de Santana (Unacon com serviços de Radioterapia e Hematologia)",
			"Hospital e Maternidade São Vicente de Paulo (Unacon com serviço de Radioterapia e Hematologia)",
			"Hospital de Apoio Abrace (CACON com serviço de oncologia pediátrica)",
			"Hospital Evangélico de Cachoeiro de Itapemirim (Unacon com serviços de Radioterapia e de Hematologia)",
			"Hospital Evangélico Anápolis/Fundação James Fanstone (Unacon com serviço de Radioterapia)",
			"Hospital Regional de Caxias Dr. Everaldo Ferreira Aragão (Unacon)",
			"Hospital Geral Universitário/Associação de Proteção à Maternidade e à Infância Cuiabá (Unacon com serviço de Hematologia)",
			"Hospital Universitário Maria Aparecida Pedrossian/UFMS (Unacon com serviço de Radioterapia)",
			"Casa de Caridade de Alfenas Nossa Sra. do Perpétuo Socorro (Unacon com serviços de Radioterapia e Hematologia)",
			"Hospital Ofir Loyola (Cacon serviço de Oncologia Pediátrica)",
			"Hospital da Fundação Assistência da Paraíba/FAP (Unacon com serviço de Radioterapia)",
			"Hospital Regional João de Freitas/Associação Norte Paranaense de Combate ao Câncer ao Câncer (Unacon com Serviço de Hematologia)",
			"Hospital Memorial de Arcoverde (Unacon)",
			"Hospital São Marcos/Sociedade Piauiense Combate ao Câncer (Cacon com serviço de Oncologia Pediátrica)",
			"Santa Casa de Misericórdia de Barra Mansa (Unacon com Serviços de Radioterapia e Hematologia)",
			"Hospital do Coração de Natal (Unacon)",
			"Santa Casa de Caridade de Bagé (Unacon)",
			"Hospital Regional de Cacoal HRC (Unacon com serviço de Radioterapia)",
			"Hospital Geral de Roraima/HGR (Unacon)",
			"Hospital Santa Isabel/Sociedade Divina Providência (Unacon com serviço de Radioterapia)",
			"Hospital Sagrado Coração de Jesus/Santa Casa de Misericórdia de Araçatuba (Unacon com serviços de Radioterapia e de Hematologia)",
			"Hospital de Cirurgia/Fundação de Beneficência Hospital de Cirurgia (Unacon com serviço de radioterapia)",
			"Hospital de Referência de Araguaína (Unacon com serviço de radioterapia)"
			};
	
	/** Hashmap que mapeia cada estado com seu respectivo hospital. */
	private static HashMap<String, String> hospitais = new HashMap<String, String>();

	/**
	 * Constrói hash.
	 * cria hash dos hospitais passando por cada estado e hospital
	 * @return o hash map
	 */
	public static HashMap<String, String> construirHash() {
		for (int i = 0; i < listaEstados.length; i++) {
			hospitais.put(listaEstados[i], listaHospitais[i]);
		}
		
		return hospitais;
	}
	
	/**
	 * Cria o banco caso ele não exista.
	 *
	 * @throws IOException IOException caso ocorra um problema no arquivo txt
	 */
	public static void criarBanco() throws IOException {
		File file = new File(local);
		file.createNewFile();
		System.out.println("Novo arquivo do banco de dados criado!");
	}
	
	/**
	 * Ler.
	 *
	 * @throws IOException IOException caso ocorra um problema no arquivo txt.
	 */
	public static void ler() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(Dados.local));
		while (br.readLine() != null ) {
			System.out.println(br.readLine());
		}
		br.close();
	}
	
	/**
	 * Carregar.
	 *
	 * @throws IOException IOException caso ocorra um problema no arquivo txt.
	 */
	public static void carregar() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(Dados.local));
		while (br.readLine() != null) {
			getBanco().add(br.readLine());
		}
	}
	
	/**
	 * Registra um novo usuário no banco de dados txt.
	 *
	 * @param usuario
	 * @throws IOException caso ocorra um problema no arquivo txt. 
	 */
	public static void registrar(Usuario usuario) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(Dados.local, true));
		bw.append("Nome: " + usuario.getNome());
		bw.append(" Estado: " + usuario.getEstado());
		bw.append(" Sexo: " + usuario.getSexo());
		bw.append(" Idade: " + usuario.getIdade());
		bw.append("\n");
		bw.close();
	}

	public static ArrayList<String> getBanco() {
		return banco;
	}
}
