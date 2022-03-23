package pc2t.cv07;

public class Student {

	private int year;
	private float gpa;

	public int getYear() {
		return this.year;
	}
	// Getter pro průměr + kontrola zadaného průměru
	public float getGpa() throws CustomException {
		if (this.gpa==0) {
			throw new CustomException();
		}
		else {
			return this.gpa;
		}
	}

	// Konstruktor pro zapsání dat
	public Student(int year, float gpa) {
		this.year = year;
		this.gpa = gpa;
	}

	public void writeGPA(float gpa) throws CustomException {
		if (gpa >= 1 && gpa <= 5) {
			this.gpa = gpa;
		}
		else {
			throw new CustomException(gpa);
		}
	}


}