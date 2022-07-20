package Medicare.model;
import java.sql.Date;

public class Payment {
	protected Bill bill_ID;
	protected long payTranNo;
	protected String method;
	protected int status;
	protected Date date;
	
	
	public Bill getBill_ID() {
		return bill_ID;
	}


	public void setBill_ID(Bill bill_ID) {
		this.bill_ID = bill_ID;
	}


	public long getPayTranNo() {
		return payTranNo;
	}


	public void setPayTranNo(long payTranNo) {
		this.payTranNo = payTranNo;
	}


	public String getMethod() {
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Payment(Bill bill_ID, long payTranNo, String method, int status, Date date) {
		this.bill_ID = bill_ID;
		this.payTranNo = payTranNo;
		this.method = method;
		this.status = status;
		this.date = date;
	}
	
	

}
