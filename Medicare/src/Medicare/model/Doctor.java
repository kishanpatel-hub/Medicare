package Medicare.model;

public class Doctor {
	   protected int doctor_ID;
	   protected String first_name;
	   protected String last_name;
	   protected int age;
	   protected String phone;
	   protected String email;
	   protected String street;
	   protected String city;
	   protected String zip;
	   protected gender gender;
	   protected String clinic;
	   protected specialization specialization;
	   protected String description;
	   protected int experiance;
	   
	     public Doctor(int doctor_ID, String first_name, String last_name, int age, String phone, String email, String street,
	             String city, String zip, gender gender, String clinic,
	             specialization specialization, String description, int experiance) {
	         this.doctor_ID = doctor_ID;
	         this.first_name = first_name;
	         this.last_name = last_name;
	         this.age = age;
	         this.phone = phone;
	         this.email = email;
	         this.street = street;
	         this.city = city;
	         this.zip = zip;
	         this.gender = gender;
	         this.clinic = clinic;
	         this.specialization = specialization;
	         this.description = description;
	         this.experiance = experiance;
	     }

	  

	     public Doctor(String first_name, String last_name, int age, String phone, String email, String street, String city,
	             String zip, gender gender, String clinic, specialization specialization,
	             String description, int experiance) {
	         
	         this.first_name = first_name;
	         this.last_name = last_name;
	         this.age = age;
	         this.phone = phone;
	         this.email = email;
	         this.street = street;
	         this.city = city;
	         this.zip = zip;
	         this.gender = gender;
	         this.clinic = clinic;
	         this.specialization = specialization;
	         this.description = description;
	         this.experiance = experiance;
	     }
	     
	     public Doctor(int doctor_ID) {
	         this.doctor_ID = doctor_ID;
	     }

	  

	     public int getDoctor_ID() {
	         return doctor_ID;
	     }

	  

	     public void setDoctor_ID(int doctor_ID) {
	         this.doctor_ID = doctor_ID;
	     }

	  

	     public String getFirst_name() {
	         return first_name;
	     }

	  

	     public void setFirst_name(String first_name) {
	         this.first_name = first_name;
	     }

	  

	     public String getLast_name() {
	         return last_name;
	     }

	  

	     public void setLast_name(String last_name) {
	         this.last_name = last_name;
	     }

	     public String getName() {
	         return first_name + " " + last_name;
	     }
	  

	     public int getAge() {
	         return age;
	     }

	  

	     public void setAge(int age) {
	         this.age = age;
	     }

	  

	     public String getPhone() {
	         return phone;
	     }

	  

	     public void setPhone(String phone) {
	         this.phone = phone;
	     }

	  

	     public String getEmail() {
	         return email;
	     }

	  

	     public void setEmail(String email) {
	         this.email = email;
	     }

	  

	     public String getStreet() {
	         return street;
	     }

	  

	     public void setStreet(String street) {
	         this.street = street;
	     }

	  

	     public String getCity() {
	         return city;
	     }

	  

	     public void setCity(String city) {
	         this.city = city;
	     }

	  

	     public String getZip() {
	         return zip;
	     }

	  

	     public void setZip(String zip) {
	         this.zip = zip;
	     }

	     public String getAddress() {
	         return street + ", " + city + ", " + zip;
	     }    
	  

	     public gender getGender() {
	         return gender;
	     }

	  

	     public void setGender(gender gender) {
	         this.gender = gender;
	     }

	  

	     public String getClinic() {
	         return clinic;
	     }

	  

	     public void setClinic(String clinic) {
	         this.clinic = clinic;
	     }

	  

	     public specialization getSpecialization() {
	         return specialization;
	     }

	  

	     public void setSpecialization(specialization specialization) {
	         this.specialization = specialization;
	     }

	  

	     public String getDescription() {
	         return description;
	     }

	  

	     public void setDescription(String description) {
	         this.description = description;
	     }

	  

	     public int getExperiance() {
	         return experiance;
	     }

	  

	     public void setExperiance(int experiance) {
	         this.experiance = experiance;
	     }
}
