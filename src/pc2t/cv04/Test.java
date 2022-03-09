package pc2t.cv04;

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
		Scanner sc=new Scanner(System.in);
		Databaze mojeDatabaze=new Databaze(1);
		int idx;
		float prumer;
		int volba;
		boolean run=true;
		while(run)
		{
			System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("1 .. vytvoreni nove databaze");
			System.out.println("2 .. vlozeni noveho studenta");
			System.out.println("3 .. nastaveni prumeru studenta");
			System.out.println("4 .. vypis informace o studentovi");
			System.out.println("0 .. ukonceni aplikace");
			volba=pouzeCelaCisla(sc);
			switch(volba)
			{
				case 1:
					System.out.printf("\nZadejte pocet studentu: ");
					mojeDatabaze=new Databaze(pouzeCelaCisla(sc));
					break;
				case 2:
					// TODO kontrola String a int
					// Kontrola, jestli nedošlo k naplnění array
					try {
						mojeDatabaze.setStudent();
					}
					catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("\nDatabáze je již plná.");
						System.out.println("Došlo k výjimce "+e.toString());
					}
					break;
				case 3:
					System.out.printf("\nZadejte index a prumer studenta: ");
					idx=pouzeCelaCisla(sc);
					prumer = checkForNum(sc);
					try {
						mojeDatabaze.setPrumer(idx, prumer);
					}
					// Kotrola indexu
					catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("\nZvolený index je mimo rozsah databáze.");
						System.out.println("Nastala výjimka "+e.toString());
					}
					// Kontrola existence položky s tímto indexem
					catch (NullPointerException e) {
						System.out.println("\nZvolená položka neexistuje.");
						System.out.println("Nastala výjimka "+e.toString());
					}
					// Kontrola hodnoty průměru
					catch (CustomException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.printf("\nZadejte index studenta: ");
					idx=pouzeCelaCisla(sc);
					try {
						Student info = mojeDatabaze.getStudent(idx);
						System.out.println("\nJméno: "+info.getJmeno()+"\nRok narození: "+info.getRocnik()+"\nPrůměr: "+info.getStudijniPrumer()+"\n");
					}
					// Kontrola průměru
					catch (CustomException e) {
						Student info = mojeDatabaze.getStudent(idx);
						System.out.println("\nJméno: "+info.getJmeno()+"\nRok narození: "+info.getRocnik()+"\nPrůměr nezadán.");
						System.out.println("\nNastala výjimka "+e.toString()+"\n");
					}
					// Kontrola indexu
					catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("\nZvolený index je mimo rozsah databáze.");
						System.out.println("Nastala výjimka "+e.toString()+"\n");
					}
					// Kontrola existence položky
					catch (NullPointerException e) {
						System.out.println("\nZadaná položka neexituje.");
						System.out.println("Nastala výjimka "+e.toString()+"\n");
					}
					break;
				case 0:
					run=false;
					break;
			}
			
		}
	}

}
