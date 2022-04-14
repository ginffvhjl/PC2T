package pc2t.cv07;

import java.util.HashMap;
import java.util.*;

public class Databaze {
	public Databaze() {
		database = new HashMap<>();
	}
	// Deklarace Map s klíčem a objektem Student
	private Map<String, Student> database;

	public void setStudent(String name, int year, float gpa) {
		// Vložení klíče a hodnoty do mapy (jestliže klíč v mapě je, přepíše se hodnota) - hodnota je objekt studenta, který je zde tvořen
		database.put(name, new Student(year, gpa));
	}

	public boolean setGPA(String name, float gpa) throws CustomException {
		if (database.containsKey(name)) {
			database.get(name).writeGPA(gpa);
			return true;
		}
		else {
			System.out.println("Student neexistuje");
			return false;
		}
	}
	// Vypsání studenta, jestliže existuje
	public Boolean getStudent(String name) throws CustomException {
		// Jestliže mapa obsahuje klíč, vrací true
		if (database.containsKey(name)) {
			try {
				// get(name) vrací hodnotu odpovídající zadanému klíči
				System.out.println("\nJméno: "+name+"\nRok narození: "+database.get(name).getYear()+"\nPrůměr: "+database.get(name).getGpa());
			}
			catch (CustomException e) {
				System.out.println("\nJméno: "+name+"\nRok narození: "+database.get(name).getYear()+"\nPrůměr: NEZADÁN");
			}
			return true;
		}
		else {
			System.out.println("Student neexistuje");
			return false;
		}
	}
	// Vypsání množiny obsahující všechny klíče
	public void printDatabase() {
		System.out.println(database.keySet());
	}
	// Vrácení hodnoty odpovídající klíči a smazání jejího záznamu
	public void deleteStudent(String name) {
		database.remove(name);
	}
}