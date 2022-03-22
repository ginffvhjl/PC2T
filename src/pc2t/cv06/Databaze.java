package pc2t.cv06;

import java.io.*;
import java.util.Scanner;

public class Databaze {

	private Scanner sc;
	private Student[] prvkyDatabaze;
	private int posledniStudent;

	public Databaze(int pocetPrvku)
	{
		prvkyDatabaze=new Student[pocetPrvku];
		sc=new Scanner(System.in);
	}

	// Setter pro nastavení jména a roku narození studenta
	public void setStudent(String name, int year) {
		prvkyDatabaze[posledniStudent++]=new Student(name, year);
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

	public void printDatabase() {
		try {
			for (int i = 0; i < prvkyDatabaze.length; i++) {
				try {
					System.out.println("Jméno: " + prvkyDatabaze[i].getJmeno() + ", rok narození: " + prvkyDatabaze[i].getRocnik() + ", studijní průměr: " + prvkyDatabaze[i].getStudijniPrumer());
				}
				catch (CustomException e) {
					System.out.println("Jméno: " + prvkyDatabaze[i].getJmeno() + ", rok narození: " + prvkyDatabaze[i].getRocnik() + ", studijní průměr: NEZADÁN");
				}
			}
		}
		catch (NullPointerException e) {
			System.out.println("\nDatabáze je prázdná.\n");
		}
	}

	public void saveToFile(String file) {
		// TODO místo vytváření souboru přejmenovat existující soubor
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			for (int i = 0; prvkyDatabaze.length > i; i++) {
				try {
					bw.append(prvkyDatabaze[i].getJmeno() + ";" + prvkyDatabaze[i].getRocnik() + ";" + prvkyDatabaze[i].getStudijniPrumer()+"\n");
				}
				catch (CustomException e) {
					bw.append(prvkyDatabaze[i].getJmeno() + ";" + prvkyDatabaze[i].getRocnik()+"\n");
				}
			}
		}
		catch (IOException e) {
			System.out.printf("Výjimka typu: "+ file.toString());
		}
	}

	/*public void readFromFile (String file) throws CustomException {
		this.;
	}*/
	public void readFromFile(String file, Databaze mojeDatabaze) throws CustomException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));

		for(int i = 0; i < prvkyDatabaze.length; i++) {
			String line = br.readLine();
			String[] pole = line.split(";");
			int year = Integer.parseInt(pole[1]);
			float average = Float.parseFloat(pole[2]);
			mojeDatabaze.setStudent(pole[0], year);
			mojeDatabaze.setPrumer(i,average);
		}

		/*String name;
		int year;
		float average;
		try (Scanner load = new Scanner(new FileReader(file))) {
			int i = 0;
			while (load.hasNext()) {
				name = load.next();
				year = load.nextInt();
				try {
					average = load.nextFloat();
					mojeDatabaze.setPrumer(i,average);
				}
				catch (CustomException e){
					continue;
				}
				mojeDatabaze.setStudent(name, year);

				i++;
			}
		}
		catch (IOException e) {
			System.out.printf("Výjimka typu "+e.toString());
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.printf("Není známá velikost datbáze nebo je počet studentů větší než velikost databáze");
		}*/
	}
}
