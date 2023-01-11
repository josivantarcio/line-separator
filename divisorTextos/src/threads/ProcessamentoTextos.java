package threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import entidades.Idioma;

public class ProcessamentoTextos extends Thread {

	private ConcurrentLinkedQueue<Idioma> idiomas = new ConcurrentLinkedQueue<>();

	public void adicionarLinhas(Idioma idioma) {
		idiomas.add(idioma);
	}

	@Override
	public void run() {
		System.out.println("Aguarde...");
		boolean process = true;
		while (process) {
			Iterator iteracao = idiomas.iterator();
			/* Leitura do arquivo */

			synchronized (iteracao) {

				while (iteracao.hasNext()) {
					Idioma idioma = (Idioma) iteracao.next();
					File entrada = new File(idioma.getCaminhoEntrada());

					try {
						Scanner scan = new Scanner(entrada);

						int i = 0;
						String texto = scan.nextLine() + "\n";

						while (scan.hasNext()) {
							if (i % 2 != 0) {

								texto += scan.nextLine() + "\n";

								Thread.sleep(100);
							} else {
								scan.nextLine();
							}
							i++;

						}

						idioma.setEnglish(texto);
						scan.close();

					} catch (FileNotFoundException e) {
						try {
							entrada.createNewFile();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					/* Gravar arquivo */
					try {
						FileWriter escrever = new FileWriter(idioma.getCaminhoSaida());
						escrever.write(idioma.getEnglish() + "\n");
						escrever.flush();
						escrever.close();
						System.out.println("FIM");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					process = false;
				}
			}
		}
	}
}
