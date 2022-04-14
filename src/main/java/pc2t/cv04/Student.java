package pc2t.cv04;

public class Student {
	public Student(String jmeno, int rocnik) {
		this.jmeno = jmeno;
		this.rocnik = rocnik;
	}
	
	public String getJmeno() {
		return jmeno;
	}
	
	public int getRocnik() {
		return rocnik;
	}
	
	public float getStudijniPrumer() throws CustomException {
		if (this.studijniPrumer == 0) {
			throw new CustomException();
		}
		else {
			return studijniPrumer;
		}
	}

	public void setStudijniPrumer(float studijniPrumer) throws CustomException {
		if (studijniPrumer >= 1 && studijniPrumer <= 5) {
			this.studijniPrumer = studijniPrumer;
		}
		else {
			throw new CustomException(studijniPrumer);
		}
	}

	private String jmeno;
	private int rocnik;
	private float studijniPrumer;
}