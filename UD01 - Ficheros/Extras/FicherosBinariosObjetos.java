package ficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FicherosBinariosObjetos {

	public void writeBinaryFile(Mensaje mensaje) {
		File file = null;
		FileOutputStream outputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			// Create a File
			file = new File("example.dat");

			// Create a FileOutputStream
			outputStream = new FileOutputStream(file);

			// Create a ObjectOutputStream
			objectOutputStream = new ObjectOutputStream(outputStream);

			// Write all info
			objectOutputStream.writeObject(mensaje);

		} catch (Exception e) {
			System.out.println("An error occurred.");
		} finally {
			// Close the ObjectOutputStream
			try {
				if (objectOutputStream != null)
					objectOutputStream.close();
			} catch (IOException e) {
				// Nothing to do here...
			}
			// Close the FileOutputStream
			try {
				if (outputStream != null)
					outputStream.close();
			} catch (IOException e) {
				// Nothing to do here...
			}
		}
	}

	public void readBinaryFile() {
		File file = null;
		FileInputStream inputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			// Create a File
			file = new File("example.dat");

			// Create a FileInputStream
			inputStream = new FileInputStream(file);

			// Create a ObjectInputStream
			objectInputStream = new ObjectInputStream(inputStream);

			// Loop to read
			while (inputStream.getChannel().position() 
					< inputStream.getChannel().size()) {
				Mensaje mensaje = (Mensaje) objectInputStream.readObject();
				System.out.println(mensaje.toString());
			}
		} catch (Exception e) {
			System.out.println("An error occurred.");
		} finally {
			// Close the ObjectInputStream
			try {
				if (objectInputStream != null)
					objectInputStream.close();
			} catch (IOException e) {
				// Nothing to do here...
			}
			// Close the FileInputStream
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				// Nothing to do here...
			}
		}
	}

	public static void main(String[] args) {
		FicherosBinariosObjetos ficherosBinarios = new FicherosBinariosObjetos();
		Mensaje mensaje = new Mensaje();
		mensaje.setId(1);
		mensaje.setEmisor("Ana");
		mensaje.setReceptor("Juan");
		mensaje.setMensaje("Mensaje de prueba");
		ficherosBinarios.readBinaryFile();
	}
}
