package pc2t.cv07;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Test {

	public static int pouzeCelaCisla(Scanner sc) 
	{
		int cislo = 0;
		try {
			cislo = sc.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("\nNastala vyjimka typu "+e.toString());
			System.out.printf("Zadejte prosím celé číslo: ");
			sc.nextLine();
			cislo = pouzeCelaCisla(sc);
		}
		return cislo;
	}

	// Kontrola zadání čísla - funguje stejně jako pouzeCelaCisla
	public static float checkForNum(Scanner sc) {
		float number = 0;
		try {
			number = sc.nextFloat();
		}
		catch (InputMismatchException e) {
			System.out.println("Nastal chyba typu "+e.toString());
			System.out.printf("Zadejte prosím číslo: ");
			sc.nextLine();
			number = checkForNum(sc);
		}
		return number;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Databaze mojeDatabaze = new Databaze();
		String name;
		int year;
		float gpa;
		int volba;
		boolean run=true;
		while(run)
		{
			System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("1 .. vytvoreni nove databaze");
			System.out.println("2 .. vlozeni noveho studenta");
			System.out.println("3 .. nastaveni prumeru studenta");
			System.out.println("4 .. vypis informace o studentovi");
			System.out.println("5 .. vypsat jmena studentu v databazi");
			System.out.println("6 .. odtsranit studenta");
			System.out.println("0 .. ukonceni aplikace");
			volba=pouzeCelaCisla(sc);
			switch(volba)
			{
				case 1:
					mojeDatabaze=new Databaze();
					break;
				case 2:
					// TODO kontrola String a int
					// Kontrola, jestli nedošlo k naplnění array
					System.out.printf("Zadejte jméno studenta: ");
					sc.nextLine();
					name = sc.nextLine();
					System.out.printf("Zadejte rok narození: ");
					year = pouzeCelaCisla(sc);
					System.out.println();
					gpa = 0;
					mojeDatabaze.setStudent(name, year, gpa);
					break;
				case 3:
					System.out.printf("\nZadejte jméno studenta: ");
					sc.nextLine();
					name = sc.nextLine();
					System.out.printf("Zadejte průměr studenta: ");
					gpa = checkForNum(sc);
					try {
						mojeDatabaze.setGPA(name, gpa);
					}
					// Kontrola hodnoty průměru
					catch (CustomException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
					break;
				case 4:
					System.out.printf("\nZadejte jméno studenta: ");
					sc.nextLine();
					name = sc.nextLine();
					try {
						System.out.println(mojeDatabaze.getStudent(name));
					}

					catch (CustomException e) {
						e.printStackTrace();
					}
					System.out.println();
					break;
				case 5:
					mojeDatabaze.printDatabase();
					System.out.println();
					break;
				case 6:
					System.out.printf("Zadejte jméno studenta: ");
					sc.nextLine();
					name = sc.nextLine();
					mojeDatabaze.deleteStudent(name);
					System.out.println();
					break;
				case 0:
					run=false;
					break;
			}
		}
	}
}
