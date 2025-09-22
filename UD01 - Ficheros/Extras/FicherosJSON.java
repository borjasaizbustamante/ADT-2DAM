package ficheros;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class FicherosJSON {

	private void doRead2() {

		try {

			FileReader reader = new FileReader("JSONExample.json");

			// Parse the JSON into a JsonArray
			JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

			// Iterate the list to get each "student"
			System.out.println("Students: ");
			for (JsonElement jsonElement : jsonArray) {
				
				// Each element is a JsonObject
				JsonObject obj = jsonElement.getAsJsonObject();
				
				// We get the attributes
				int id = obj.get("id").getAsInt();
				String name = obj.get("name").getAsString();
				String surname = obj.get("surname").getAsString();
				String asignature = obj.get("asignature").getAsString();
				
				System.out.printf("ID: %d, Name: %s %s, Asignature: %s%n",
	                    id, name, surname, asignature);
			}

		} catch (Exception e) {
			System.out.println("An error occurred.");
		}
	}

	private void doRead() {

		// The gson
		Gson gson = null;
		try {
			// The builder
			gson = new GsonBuilder().setPrettyPrinting().create();

			FileReader reader = new FileReader("JSONExample.json");

			// what type of token are we reading? An Student
			Type listType = new TypeToken<List<Student>>() {
			}.getType();
			List<Student> loadedStudents = gson.fromJson(reader, listType);

			System.out.println("Students: ");
			for (Student student : loadedStudents) {
				System.out.println(student);
			}
		} catch (Exception e) {
			System.out.println("An error occurred.");
		}
	}

	private void doWrite() {

		// The List of Students
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Juan", "Torres", "ADT"));
		students.add(new Student(2, "Ana", "Perez", "PMDM"));
		students.add(new Student(3, "Luis", "Martín", "PSP"));

		// The gson
		Gson gson = null;
		try {
			// The builder
			gson = new GsonBuilder().setPrettyPrinting().create();

			FileWriter writer = new FileWriter("JSONExample.json");

			// Just dump the list
			gson.toJson(students, writer);
			writer.flush();
		} catch (Exception e) {
			System.out.println("An error occurred.");
		}
	}

	public static void main(String[] args) {
		FicherosJSON ficherosJSON = new FicherosJSON();
		//ficherosJSON.doRead();
		//ficherosJSON.doRead2();
		ficherosJSON.doWrite();
	}
}
