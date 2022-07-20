package Medicare.model;

import java.util.Date;

public class Patient {
	protected int patient_ID;
	protected String first_name;
	protected String last_name;
	protected int age;
	protected gender gender;
	protected String phone;
	protected String street;
	protected String city;
	protected String zip;
	protected Date dob; 
	protected String bloodgroup;
	protected int height;
	protected int weight;
	protected long policy_no;
	protected Insurance insCom;
	
	public Patient(int patient_ID, String first_name, String last_name, int age, gender gender, 
			String phone, String street, String city, String zip, Date date, String bloodgroup,
			int height, int weight, long policy_no, Insurance insCom) {
		this.patient_ID = patient_ID;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.dob = date;
		this.bloodgroup = bloodgroup;
		this.height = height;
		this.weight = weight;
		this.policy_no = policy_no;
		this.insCom = insCom;	
	}
	
	public Patient(String first_name, String last_name, int age, gender gender, 
			String phone, String street, String city, String zip, Date date, String bloodgroup,
			int height, int weight, long policy_no, Insurance insCom) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.dob = date;
		this.bloodgroup = bloodgroup;
		this.height = height;
		this.weight = weight;
		this.policy_no = policy_no;
		this.insCom = insCom;	
	}
	
	public Patient(int patient_ID) {
		this.patient_ID = patient_ID;
	}
	
	/**
	 * @return the patient_ID
	 */
	public int getPatient_ID() {
		return patient_ID;
	}

	/**
	 * @param patient_ID the patient_ID to set
	 */
	public void setPatient_ID(int patient_ID) {
		this.patient_ID = patient_ID;
	}

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
    public String getName() {
        return first_name + " " + last_name;
    }

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the gender
	 */
	public gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(gender gender) {
		this.gender = gender;
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
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

    public String getAddress() {
        return street + ", " + city + ", " + zip;
    }  
	
	/**
	 * @return the date
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param date the date to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the bloodgroup
	 */
	public String getBloodgroup() {
		return bloodgroup;
	}

	/**
	 * @param bloodgroup the bloodgroup to set
	 */
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the policy_no
	 */
	public long getPolicy_no() {
		return policy_no;
	}

	/**
	 * @param policy_no the policy_no to set
	 */
	public void setPolicy_no(long policy_no) {
		this.policy_no = policy_no;
	}

	/**
	 * @return the insCom
	 */
	public Insurance getInsCom() {
		return insCom;
	}

	/**
	 * @param insCom the insCom to set
	 */
	public void setInsCom(Insurance insCom) {
		this.insCom = insCom;
	}


}
