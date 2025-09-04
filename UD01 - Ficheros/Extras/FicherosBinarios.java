package ficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FicherosBinarios {

	public void writeBinaryFile() {
		String texto = "Información a almacenar";
		File file = null;
		FileOutputStream output = null;
		try {
			// Create a File
			file = new File("example.txt");

			// Create a FileOutputStream
			output = new FileOutputStream(file);

			// Turn the info into bytes...
			byte[] bytes = texto.getBytes();

			// Write all info
			output.write(bytes);
		} catch (Exception e) {
			System.out.println("An error occurred.");
		} finally {
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
		try {
			// Create a File
			file = new File("example.txt");

			// Create a FileInputStream
			input = new FileInputStream(file);

			// Loop to read a bytes until the end of file
			int i = 0;
			while ((i = input.read()) != -1) {
				System.out.println(i);
			}
		} catch (Exception e) {
			System.out.println("An error occurred.");
		} finally {
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
