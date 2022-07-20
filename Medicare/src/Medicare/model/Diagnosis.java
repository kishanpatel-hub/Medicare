package Medicare.model;

public class Diagnosis {

	protected int diagnosis_ID;
	protected String diagnosis;



	public Diagnosis(int diagnosis_ID, String diagnosis) {
		this.diagnosis_ID = diagnosis_ID;
		this.diagnosis = diagnosis;
	}

	public Diagnosis(int diagnosis_ID) {
		this.diagnosis_ID = diagnosis_ID;
	}

	public Diagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public int getDiagnosisID() {
		return diagnosis_ID;
	}

	public void setDiagnosisID(int diagnosis_ID) {
		this.diagnosis_ID = diagnosis_ID;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}


}