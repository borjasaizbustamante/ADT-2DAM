package ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FicherosBinariosPrimitivos {

	private String cesta[] = { "Peras", "Manzanas", "Plátanos" };
	private int cantidad[] = { 10, 4, 3 };

	public void writeBinaryFile() {
		File file = null;
		FileOutputStream output = null;
		DataOutputStream outputStream = null;
		try {
			// Create a File
			file = new File("example.txt");

			// Create a FileOutputStream
			output = new FileOutputStream(file);

			// Create a DataOutputStream
			outputStream = new DataOutputStream(output);

			// Write all info
			for (int i = 0; i < cesta.length; i++) {
				outputStream.writeUTF(cesta[i]); // inserta nombre
				outputStream.writeInt(cantidad[i]); // inserta edad
			}

		} catch (Exception e) {
			System.out.println("An error occurred.");
		} finally {
			// Close the DataOutputStream
			try {
				if (outputStream != null)
					outputStream.close();
			} catch (IOException e) {
				// Nothing to do here...
			}
			// Close the FileOutputStream
			try {
				if (output != null)
					output.close();
			} catch (IOException e) {
				// Nothing to do here...
			}
		}
	}

	public void readBinaryFile() {
		File file = null;
		FileInputStream input = null;
		DataInputStream inputStream = null;
		try {
			// Create a File
			file = new File("example.txt");

			// Create a FileInputStream
			input = new FileInputStream(file);

			// Create a DataOutputStream
			inputStream = new DataInputStream(input);
			
			// Loop to read a bytes until the end of file
			while (input.getChannel().position() < input.getChannel().size()) { 
				String producto = inputStream.readUTF(); 
				int cant = inputStream.readInt(); 
				System.out.println("Producto: " + producto + ", cant: " + cant);

			}
		} catch (Exception e) {
			System.out.println("An error occurred.");
		} finally {
			// Close the DataInputStream
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				// Nothing to do here...
			}
			// Close the reader
			try {
				if (input != null)
					input.close();
			} catch (IOException e) {
				// Nothing to do here...
			}
		}
	}
}
