package pc2t.cv07;

import java.util.HashMap;
import java.util.*;

public class Databaze {
	// Vytvoření objektu Hashmap
	public Databaze() {
		database = new HashMap<>();
	}
	// Deklarace Map s klíčem a objektem Student
	private Map<String, Student> database;

	// Zápis studenta do Hashmap a tvorba objektu studenta
	public void setStudent(String name, int year, float gpa) {
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
		if (database.containsKey(name)) {
			try {
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

	public void printDatabase() {
		System.out.println(database.keySet());
	}

	public void deleteStudent(String name) {
		database.remove(name);
	}
}