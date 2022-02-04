package empoderACAO.menu;

import java.io.IOException;

// TODO: Auto-generated Javadoc
/*
 * @author Daniela Goulart
 * @author Erika Kuo
 * @author Leonardo Carvalho
 * @author Lucas Silva
 * @author Luiz Gustavo
 * @author Vanessa Navarro
 * @author Victor Costa
 * @since 03-02-2022
 */

/**
 * Class principal que roda o programa
 */
public class Main {
	
	/**
	 * O método main
	 *
	 * @throws IOException caso ocorra um problema no arquivo txt.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		Menu menu = new Menu();
		menu.comeco();
	}
}
