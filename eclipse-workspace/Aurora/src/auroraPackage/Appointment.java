package auroraPackage;

//Appointment class
public class Appointment {
    private int appointmentId;
    private Patient patient;
    private Dermatologist dermatologist;
    private String date;
    private String time;
    private boolean registrationFeePaid;
    private String treatmentType;
    private double totalFee;

    public Appointment(int appointmentId, Patient patient, Dermatologist dermatologist, String date, String time) {
        this.appointmentId 		 = appointmentId;
        this.patient 	   		 = patient;
        this.dermatologist 		 = dermatologist;
        this.date 		   		 = date;
        this.time 		   		 = time;
        this.registrationFeePaid = false;
    }

    
    public int getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isRegistrationFeePaid() {
        return registrationFeePaid;
    }

    public void setRegistrationFeePaid(boolean registrationFeePaid) {
        this.registrationFeePaid = registrationFeePaid;
    }

    public double calculateFee(String treatmentType) {
        this.treatmentType = treatmentType;
        double treatmentPrice = 0;
        switch (treatmentType) {
            case "Acne":
                treatmentPrice = 2750;
                break;
            case "Whitening":
                treatmentPrice = 7650;
                break;
            case "Mole":
                treatmentPrice = 3850;
                break;
            case "Laser":
                treatmentPrice = 12500;
                break;
            default:
                System.out.println("Invalid treatment type.");
                return 0;
        }
     // add 2.5% tax
        totalFee = treatmentPrice + (treatmentPrice * 0.025); 
     // round to two decimals
        totalFee = Math.round(totalFee * 100.0) / 100.0; 
        return totalFee;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public String getDetails() {
        return "Appointment ID: " + appointmentId + ", Patient: " + patient.getName() +
               ", Dermatologist: " + dermatologist.getName() +
               ", Date: " + date + ", Time: " + time +
               ", Treatment: " + treatmentType +
               ", Registration Paid: " + (registrationFeePaid ? "Yes" : "No");
    }
}


