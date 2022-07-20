package Medicare.model;

import java.sql.Date;

public class Reviews {
	
	protected int review_ID;
	protected Patient patient_ID;
	protected Doctor doctor_ID;
	protected String content;
	protected double rating;
	protected Date created;
	
	
	public Reviews(int review_ID, Patient patient_ID, Doctor doctor_ID, String content, double rating, Date created) {
		this.review_ID = review_ID;
		this.patient_ID = patient_ID;
		this.doctor_ID = doctor_ID;
		this.content = content;
		this.rating = rating;
		this.created = created;
	}


	public Reviews(Patient patient_ID, Doctor doctor_ID, String content, double rating, Date created) {
		this.patient_ID = patient_ID;
		this.doctor_ID = doctor_ID;
		this.content = content;
		this.rating = rating;
		this.created = created;
	}


	public Reviews(int review_ID) {
		this.review_ID = review_ID;
	}


	public int getReview_ID() {
		return review_ID;
	}


	public void setReview_ID(int review_ID) {
		this.review_ID = review_ID;
	}


	public Patient getPatient_ID() {
		return patient_ID;
	}


	public void setPatient_ID(Patient patient_ID) {
		this.patient_ID = patient_ID;
	}


	public Doctor getDoctor_ID() {
		return doctor_ID;
	}


	public void setDoctor_ID(Doctor doctor_ID) {
		this.doctor_ID = doctor_ID;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}
	
}
