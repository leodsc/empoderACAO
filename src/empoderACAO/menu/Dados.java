package empoderACAO.menu;

import java.util.HashMap;

public abstract class Dados {
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
}
