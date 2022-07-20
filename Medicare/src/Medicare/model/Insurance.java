package Medicare.model;

public class Insurance {
	protected int insCom_ID;
	protected String insCom_Name;
	protected String phone;
	protected String email;
	protected String address;
	
	public Insurance(int insCom_ID, String insCom_Name, String phone, String email, String address) {
		this.insCom_ID = insCom_ID;
		this.insCom_Name = insCom_Name;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	
	public Insurance( String insCom_Name, String phone, String email, String address) {
		this.insCom_Name = insCom_Name;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	
	public Insurance(int insCom_ID) {
		this.insCom_ID = insCom_ID;
	}
	
	/**
	 * @return the insCom_ID
	 */
	public int getInsCom_ID() {
		return insCom_ID;
	}
	/**
	 * @param insCom_ID the insCom_ID to set
	 */
	public void setInsCom_ID(int insCom_ID) {
		this.insCom_ID = insCom_ID;
	}
	/**
	 * @return the insCom_Name
	 */
	public String getInsCom_Name() {
		return insCom_Name;
	}
	/**
	 * @param insCom_Name the insCom_Name to set
	 */
	public void setInsCom_Name(String insCom_Name) {
		this.insCom_Name = insCom_Name;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
}
