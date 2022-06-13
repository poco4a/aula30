
package agenda.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Vector;

import agenda.Evento;
import agenda.utils.PeriodicidadeEnum;

public class AgendaIO {
	private final String DIRETORIO = "C:\\Users\\lucio\\Desktop\\";
	private final String ARQUIVO = "eventos.txt";

	public void gravarEvento(Evento evento) throws Exception {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
					DIRETORIO, ARQUIVO), true));
			writer.write(evento.toString(), 0, evento.toString().length());
			writer.newLine();
			writer.close();

		} catch (FileNotFoundException fnfe) {
			throw new Exception("Não encontrou o arquivo");

		} catch (Exception ex) {
			throw new Exception("Exceção na gravação do arquivo");

		}
	}

	public Vector<Vector<Object>> getEventos() throws Exception {
		Vector<Vector<Object>> lista = new Vector<Vector<Object>>();

		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(
									DIRETORIO+ARQUIVO),"UTF-8"));  //Leitura de acentos
			String linha = reader.readLine();
			while (linha != null) {
				Vector<Object> vetor = new Vector<>();
				String[] tokens = linha.split("\\|");
				
				for(String i : tokens)
					System.out.println("("+i+")");
				
				vetor.add(tokens[0]);
				vetor.add(tokens[1]);
				vetor.add(PeriodicidadeEnum.valueOf(tokens[2]));
				vetor.add(tokens[3]);
				vetor.add(tokens[4].equals("1") ? "LIGADO" : "DESLIGADO");

				lista.add(vetor);
				linha = reader.readLine();
			}

			reader.close();

		} catch (FileNotFoundException fnfe) {
			throw new Exception("Não encontrou o arquivo");

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Exceção na leitura do arquivo");

		}
		return lista;
	}
}

