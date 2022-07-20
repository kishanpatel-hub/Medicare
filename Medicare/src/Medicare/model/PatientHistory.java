package Medicare.model;

public class PatientHistory {
	protected Patient patient_ID;
	protected int smoking;
	protected int drugs;
	protected String allergy;
	protected String major_diseases;
	protected String surgeries;
	protected String injuries;	
	protected LabRecords record_ID;
	
	
	public PatientHistory(Patient patient_ID, int smoking, int drugs, String allergy, String major_diseases,
			String surgeries, String injuries, LabRecords record_ID) {
		this.patient_ID = patient_ID;
		this.smoking = smoking;
		this.drugs = drugs;
		this.allergy = allergy;
		this.major_diseases = major_diseases;
		this.surgeries = surgeries;
		this.injuries = injuries;
		this.record_ID = record_ID;
	}

	public Patient getPatient_ID() {
		return patient_ID;
	}


	public void setPatient_ID(Patient patient_ID) {
		this.patient_ID = patient_ID;
	}


	public int getSmoking() {
		return smoking;
	}


	public void setSmoking(int smoking) {
		this.smoking = smoking;
	}


	public int getDrugs() {
		return drugs;
	}


	public void setDrugs(int drugs) {
		this.drugs = drugs;
	}


	public String getAllergy() {
		return allergy;
	}


	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}


	public String getMajor_diseases() {
		return major_diseases;
	}


	public void setMajor_diseases(String major_diseases) {
		this.major_diseases = major_diseases;
	}


	public String getSurgeries() {
		return surgeries;
	}


	public void setSurgeries(String surgeries) {
		this.surgeries = surgeries;
	}


	public String getInjuries() {
		return injuries;
	}


	public void setInjuries(String injuries) {
		this.injuries = injuries;
	}


	public LabRecords getRecord_ID() {
		return record_ID;
	}


	public void setRecord_ID(LabRecords record_ID) {
		this.record_ID = record_ID;
	}

}
