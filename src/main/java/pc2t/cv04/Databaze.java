package pc2t.cv04;

import java.util.Scanner;

public class Databaze {
	public Databaze(int pocetPrvku)
	{
		prvkyDatabaze=new Student[pocetPrvku];
		sc=new Scanner(System.in);
	}

	// Setter pro nastavení jména a roku narození studenta
	public void setStudent()
	{
		System.out.println("\nZadejte jmeno studenta, rok narozeni:");
		String jmeno=sc.next();
		// Kontrola, že je rok celé číslo
		int rok=Test.pouzeCelaCisla(sc);
		prvkyDatabaze[posledniStudent++]=new Student(jmeno,rok);
	}
	// Getter pro prvky databáze
	public Student getStudent(int idx)
	{
		return prvkyDatabaze[idx];
	}
	// Setter pro průměr; předávání CustomException
	public void setPrumer(int idx, float prumer) throws CustomException {
		prvkyDatabaze[idx].setStudijniPrumer(prumer);
	}
	
	private Scanner sc;
	private Student [] prvkyDatabaze;
	private int posledniStudent;
}