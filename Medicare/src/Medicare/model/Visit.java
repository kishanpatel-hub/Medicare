package Medicare.model;

import java.sql.Date;

public class Visit {
	protected int visit_ID;
	protected Appointments appointment_ID;
	protected String complaint;
	protected Prescription prescription_ID;
	protected Diagnosis diagnosis_ID;
	protected Date nextVisit;
	protected int isActive;
	
	
	public Visit(int visit_ID, Appointments appointment_ID, String complaint, Prescription prescription_ID,
			Diagnosis diagnosis_ID, Date nextVisit, int isActive) {
		this.visit_ID = visit_ID;
		this.appointment_ID = appointment_ID;
		this.complaint = complaint;
		this.prescription_ID = prescription_ID;
		this.diagnosis_ID = diagnosis_ID;
		this.nextVisit = nextVisit;
		this.isActive = isActive;
	}


	public Visit(Appointments appointment_ID, String complaint, Prescription prescription_ID, Diagnosis diagnosis_ID,
			Date nextVisit, int isActive) {
		this.appointment_ID = appointment_ID;
		this.complaint = complaint;
		this.prescription_ID = prescription_ID;
		this.diagnosis_ID = diagnosis_ID;
		this.nextVisit = nextVisit;
		this.isActive = isActive;
	}


	public Visit(int visit_ID) {
		this.visit_ID = visit_ID;
	}


	public int getVisit_ID() {
		return visit_ID;
	}


	public void setVisit_ID(int visit_ID) {
		this.visit_ID = visit_ID;
	}


	public Appointments getAppointment_ID() {
		return appointment_ID;
	}


	public void setAppointment_ID(Appointments appointment_ID) {
		this.appointment_ID = appointment_ID;
	}


	public String getComplaint() {
		return complaint;
	}


	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}


	public Prescription getPrescription_ID() {
		return prescription_ID;
	}


	public void setPrescription_ID(Prescription prescription_ID) {
		this.prescription_ID = prescription_ID;
	}


	public Diagnosis getDiagnosis_ID() {
		return diagnosis_ID;
	}


	public void setDiagnosis_ID(Diagnosis diagnosis_ID) {
		this.diagnosis_ID = diagnosis_ID;
	}


	public Date getNextVisit() {
		return nextVisit;
	}


	public void setNextVisit(Date nextVisit) {
		this.nextVisit = nextVisit;
	}


	public int getIsActive() {
		return isActive;
	}


	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
}
