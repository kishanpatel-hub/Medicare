package Medicare.model;

public class Referral {
	protected Patient patient_ID;
	protected Doctor referredBy;
	protected Doctor referredTo;
	protected String notes;
	
	
	public Referral(Patient patient_ID, Doctor referredBy, Doctor referredTo, String notes) {
		this.patient_ID = patient_ID;
		this.referredBy = referredBy;
		this.referredTo = referredTo;
		this.notes = notes;
	}


	public Patient getPatient_ID() {
		return patient_ID;
	}


	public void setPatient_ID(Patient patient_ID) {
		this.patient_ID = patient_ID;
	}


	public Doctor getReferredBy() {
		return referredBy;
	}


	public void setReferredBy(Doctor referredBy) {
		this.referredBy = referredBy;
	}


	public Doctor getReferredTo() {
		return referredTo;
	}


	public void setReferredTo(Doctor referredTo) {
		this.referredTo = referredTo;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	

}
