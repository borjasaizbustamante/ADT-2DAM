package ficheros;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FicherosBinariosAleatorios {

	String apellido[] = { "FERNANDEZ", "GIL", "LOPEZ" };
	Double salario[] = { 1000.45, 2400.60, 3000.0 };

	public void writeFile() {
		File file = null;
		RandomAccessFile randomAccessFile = null;
		StringBuffer buffer = null;
		try {
			// Create a File
			file = new File("example.txt");

			// Create a
			randomAccessFile = new RandomAccessFile(file, "rw");

			// Let's write the file...
			int n = apellido.length;
			for (int i = 0; i < n; i++) {
				// We use this as a fake ID
				randomAccessFile.writeInt(i + 1);

				// 10 Characters
				buffer = new StringBuffer(apellido[i]);
				buffer.setLength(10);
				randomAccessFile.writeChars(buffer.toString());

				// The money
				randomAccessFile.writeDouble(salario[i]);
			}
		} catch (Exception e) {
			System.out.println("An error occurred.");
		} finally {
			// Close the RandomAccessFile
			try {
				if (randomAccessFile != null)
					randomAccessFile.close();
			} catch (IOException e) {
				// Nothing to do here...
			}
		}
	}

	public void writeFileEnd() {
		File file = null;
		RandomAccessFile randomAccessFile = null;
		StringBuffer buffer = null;
		try {
			// Create a File
			file = new File("example.txt");

			// Create a
			randomAccessFile = new RandomAccessFile(file, "rw");

			// Let's write the file...
			int id = 4;
			long posicion = (id - 1) * 32;
			randomAccessFile.seek(posicion);

			// We use this as a fake ID
			randomAccessFile.writeInt(id);

			// 10 Characters
			buffer = new StringBuffer("GONZALEZ");
			buffer.setLength(10);
			randomAccessFile.writeChars(buffer.toString());

			// The money
			randomAccessFile.writeDouble(1230.87);

		} catch (Exception e) {
			System.out.println("An error occurred.");
		} finally {
			// Close the RandomAccessFile
			try {
				if (randomAccessFile != null)
					randomAccessFile.close();
			} catch (IOException e) {
				// Nothing to do here...
			}
		}
	}

	public void readFile() {
		File file = null;
		RandomAccessFile randomAccessFile = null;
		try {
			file = new File("example.txt");
			randomAccessFile = new RandomAccessFile(file, "r");

			// Loop to read a bytes until the end of file
			int posicion = 0;
			for (;;) {
				randomAccessFile.seek(posicion);
				// Fake ID
				int id = randomAccessFile.readInt();

				// 10 Characters
				char surname[] = new char[10];
				for (int i = 0; i < surname.length; i++) {
					char aux = randomAccessFile.readChar();
					surname[i] = aux;
				}
				String apellidos = new String(surname);

				// The money
				Double salario = randomAccessFile.readDouble();

				System.out.printf("ID: %s, Apellido: %s, Salario: %.2f %n", id, apellidos.trim(), salario);

				// Next position
				posicion = posicion + 32;

				// End of file?
				if (randomAccessFile.getFilePointer() == randomAccessFile.length())
					break;
			}
		} catch (Exception e) {
			System.out.println("An error occurred.");
		} finally {
			// Close the reader
			try {
				if (randomAccessFile != null)
					randomAccessFile.close();
			} catch (IOException e) {
				// Nothing to do here...
			}
		}
	}

	public void readFileEnd(int registro) {
		File file = null;
		RandomAccessFile randomAccessFile = null;
		try {
			file = new File("example.txt");
			randomAccessFile = new RandomAccessFile(file, "r");

			// Loop to read a bytes until the end of file
			int posicion = (registro - 1) * 32;

			if (posicion >= file.length()) {
				System.out.printf("Registro %d no existe", registro);
			} else {
				randomAccessFile.seek(posicion);
				// Fake ID
				int id = randomAccessFile.readInt();

				// 10 Characters
				char surname[] = new char[10];
				for (int i = 0; i < surname.length; i++) {
					char aux = randomAccessFile.readChar();
					surname[i] = aux;
				}
				String apellidos = new String(surname);

				// The money
				Double salario = randomAccessFile.readDouble();

				System.out.printf("ID: %s, Apellido: %s, Salario: %.2f %n", id, apellidos.trim(), salario);
			}
		} catch (Exception e) {
			System.out.println("An error occurred.");
		} finally {
			// Close the reader
			try {
				if (randomAccessFile != null)
					randomAccessFile.close();
			} catch (IOException e) {
				// Nothing to do here...
			}
		}
	}
}
