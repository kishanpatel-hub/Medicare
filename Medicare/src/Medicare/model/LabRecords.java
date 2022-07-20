package Medicare.model;

import java.sql.Date;

public class LabRecords {
	protected int record_ID;
	protected String record;
	protected Date created;
	
	
	public LabRecords(int record_ID, String record, Date created) {
		this.record_ID = record_ID;
		this.record = record;
		this.created = created;
	}


	public LabRecords(String record, Date created) {
		this.record = record;
		this.created = created;
	}


	public LabRecords(int record_ID) {
		this.record_ID = record_ID;
	}


	public int getRecord_ID() {
		return record_ID;
	}


	public void setRecord_ID(int record_ID) {
		this.record_ID = record_ID;
	}


	public String getRecord() {
		return record;
	}


	public void setRecord(String record) {
		this.record = record;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}

}
