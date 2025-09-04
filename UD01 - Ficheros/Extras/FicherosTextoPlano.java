package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FicherosTextoPlano {

	public void writeFile() {
		String cesta[] = { "Peras", "Manzanas", "Plátanos" };
		File file = null;
		FileWriter writer = null;
		try {
			// Create a File
			file = new File("example.txt");

			// Create a FileWriter
			writer = new FileWriter(file);

			// Loop and write the text
			for (int i = 0; i < cesta.length; i++) {
				writer.write(cesta[i]);
				writer.write("\n");
			}
		} catch (Exception e) {
			System.out.println("An error occurred.");
		} finally {
			// Close the writer
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				// Nothing to do here...
			}
		}
	}

	public void readFile() {
		File file = null;
		FileReader reader = null;
		try {
			// Create a File
			file = new File("example.txt");

			// Create a FileWriter
			reader = new FileReader(file);

			// Loop to read a single character until
			// file is empty (-1)
			int i = 0;
			while ((i = reader.read()) != -1) {
				System.out.println((char) i + "==>" + i);
			}
		} catch (Exception e) {
			System.out.println("An error occurred.");
		} finally {
			// Close the reader
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				// Nothing to do here...
			}
		}
	}

	public void writeFileBuffered() {
		String cesta[] = { "Peras", "Manzanas", "Plátanos" };
		File file = null;
		FileWriter writer = null;
		BufferedWriter buffer = null;
		try {
			// Create a File
			file = new File("example.txt");

			// Create a FileWriter
			writer = new FileWriter(file);

			// Create a BufferedWriter
			buffer = new BufferedWriter(writer);

			// Loop and write the text
			for (int i = 0; i < cesta.length; i++) {
				buffer.write("Contenido cesta " + i + ": " + cesta[i]);
				buffer.newLine();
			}
		} catch (Exception e) {
			System.out.println("An error occurred.");
		} finally {
			// Close the buffer
			try {
				if (buffer != null)
					buffer.close();
			} catch (IOException e) {
				// Nothing to do here...
			}

			// Close the writer
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				// Nothing to do here...
			}
		}
	}

	public void readFileBuffered() {
		File file = null;
		FileReader reader = null;
		BufferedReader buffer = null;
		try {
			// Create a File
			file = new File("example.txt");

			// Create a FileWriter
			reader = new FileReader(file);

			// Create a BufferedWriter
			buffer = new BufferedReader(reader);

			// Loop to read a row
			String linea;
			while ((linea = buffer.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (Exception e) {
			System.out.println("An error occurred.");
		} finally {
			// Close the reader
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				// Nothing to do here...
			}
		}
	}
}