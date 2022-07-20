package Medicare.model;

import java.sql.Date;

public class Bill {
	protected int bill_ID;
	protected Visit visit_ID;
	protected int amount;
	protected Date date;
	protected Date due_Date;
	
	
	public Bill(int bill_ID, Visit visit_ID, int amount, Date date, Date due_Date) {
		this.bill_ID = bill_ID;
		this.visit_ID = visit_ID;
		this.amount = amount;
		this.date = date;
		this.due_Date = due_Date;
	}


	public Bill(Visit visit_ID, int amount, Date date, Date due_Date) {
		this.visit_ID = visit_ID;
		this.amount = amount;
		this.date = date;
		this.due_Date = due_Date;
	}


	public Bill(int bill_ID) {
		this.bill_ID = bill_ID;
	}


	public int getBill_ID() {
		return bill_ID;
	}


	public void setBill_ID(int bill_ID) {
		this.bill_ID = bill_ID;
	}


	public Visit getVisit_ID() {
		return visit_ID;
	}


	public void setVisit_ID(Visit visit_ID) {
		this.visit_ID = visit_ID;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Date getDue_Date() {
		return due_Date;
	}


	public void setDue_Date(Date due_Date) {
		this.due_Date = due_Date;
	}
		
}
