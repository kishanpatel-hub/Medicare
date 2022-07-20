package Medicare.model;
public class Prescription {
	protected int prescriptionID;
	protected String medicine;
	protected int quantity;
	protected int timesADay;
	
	public Prescription(int prescriptionID, String medicine, int quantity, int timesADay) {
		this.prescriptionID = prescriptionID;
		this.medicine = medicine;
		this.quantity = quantity;
		this.timesADay = timesADay;
	}
	
	public Prescription(int prescriptionID) {
		this.prescriptionID = prescriptionID;
	}
	
	public Prescription(String medicine, int quantity, int timesADay) {
		this.medicine = medicine;
		this.quantity = quantity;
		this.timesADay = timesADay;
	}

	public int getPrescriptionID() {
		return prescriptionID;
	}

	public void setPrescriptionID(int prescriptionID) {
		this.prescriptionID = prescriptionID;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTimesADay() {
		return timesADay;
	}

	public void setTimesADay(int timesADay) {
		this.timesADay = timesADay;
	}
	
	
}
