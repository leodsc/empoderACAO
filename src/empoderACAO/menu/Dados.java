package empoderACAO.menu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Dados {
	private static ArrayList<String> banco = new ArrayList<String>();
	private static String userName = System.getProperty("user.name");
	private static String local = "C:\\Users\\" + userName +"\\dados.txt";

	private static String[] listaEstados = {"AC", "AL", "AM"};
	private static String[] listaHospitais = {
			"Hospital da Fundação Hospitalar Estadual do Acre (Unacon com Serviço de Radioterapia)",
			"Centro Hospitalar Manoel André / Chama (Unacon com Radioterapia)",
			"Hospital de Clínicas Dr. Alberto Lima (Unacon)"
			};
	private static HashMap<String, String> hospitais = new HashMap<String, String>();

	public static HashMap<String, String> construirHash() {
		for (int i = 0; i < listaEstados.length; i++) {
			hospitais.put(listaEstados[i], listaHospitais[i]);
		}
		
		return hospitais;
	}
	
	public static void criarBanco() throws IOException {
		File file = new File(local);
		file.createNewFile();
		System.out.println("Novo arquivo do banco de dados criado!");
	}
	
	public static void ler() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(Dados.local));
		while (br.readLine() != null ) {
			System.out.println(br.readLine());
		}
		br.close();
	}
	
	public static void carregar() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(Dados.local));
		while (br.readLine() != null) {
			getBanco().add(br.readLine());
		}
	}
	
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
