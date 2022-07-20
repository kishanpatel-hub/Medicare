package Medicare.model;


import java.sql.Date;
import java.sql.Time;

 

public class Appointments {
    protected int appointment_ID;
    protected Patient patient_ID;
    protected Doctor doctor_ID;
    protected Date created;
    protected Date appointmentOn;
    
    
    public Appointments(int appointment_ID, Patient patient_ID, Doctor doctor_ID, Date created, Date appointmentOn) {
        this.appointment_ID = appointment_ID;
        this.patient_ID = patient_ID;
        this.doctor_ID = doctor_ID;
        this.created = created;
        this.appointmentOn = appointmentOn;
    }

 


    public Appointments(Patient patient_ID, Doctor doctor_ID,  Date appointmentOn) {
        this.patient_ID = patient_ID;
        this.doctor_ID = doctor_ID;
        this.appointmentOn = appointmentOn;
    }

 


    public Appointments(int appointment_ID) {
        this.appointment_ID = appointment_ID;
    }

 


    public int getAppointment_ID() {
        return appointment_ID;
    }

 


    public void setAppointment_ID(int appointment_ID) {
        this.appointment_ID = appointment_ID;
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

 


    public Date getCreated() {
        return created;
    }

 


    public void setCreated(Date created) {
        this.created = created;
    }

 


    public Date getAppointmentOn() {
        return appointmentOn;
    }

 


    public void setAppointmentOn(Date newAppointmentOn) {
        this.appointmentOn = newAppointmentOn;
    }
    


}
 