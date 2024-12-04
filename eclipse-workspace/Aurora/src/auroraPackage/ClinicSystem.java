package auroraPackage;

//import all classes from the java util package
import java.util.*;

public class ClinicSystem {
	//stroes appoinments
    private List<Appointment> appointments = new ArrayList<>();
    //store dermatologists
    private List<Dermatologist> dermatologists = new ArrayList<>();
    //generate unique ID
    private int appointmentCounter = 1;

    public void addDermatologist(Dermatologist dermatologist) {
        dermatologists.add(dermatologist);
    }
    
//book an appointment
    public void makeAppointment(Patient patient, String dermName, String date, String time) {
        Dermatologist dermatologist = findDermatologistByName(dermName);
        if (dermatologist != null && dermatologist.isAvailable(date, time)) {
            Appointment appointment = new Appointment(appointmentCounter++, patient, dermatologist, date, time);
            appointments.add(appointment);
            dermatologist.bookTime(date, time);
            System.out.println("Appointment booked successfully!");
        } else {
            System.out.println("Dermatologist not available or time slot unavailable.");
        }
    }
    
//update an existing appointment
    public void updateAppointment(int appointmentId, String newDate, String newTime) {
        Appointment appointment = findAppointmentById(appointmentId);
        if (appointment != null) {
            appointment.setDate(newDate);
            appointment.setTime(newTime);
            System.out.println("Appointment updated successfully!");
        } else {
            System.out.println("Appointment not found.");
        }
    }

    //view appointment filter by date
    public void viewAppointmentsByDate(String date) {
        System.out.println("Appointments on " + date + ":");
        for (Appointment appointment : appointments) {
            if (appointment.getDate().equals(date)) {
                System.out.println(appointment.getDetails());
            }
        }
    }

    //search appointment using appointment ID
    public void searchAppointment(String searchInput) {
        try {
            int appointmentId = Integer.parseInt(searchInput);
            Appointment appointment = findAppointmentById(appointmentId);
            if (appointment != null) {
                System.out.println(appointment.getDetails());
            } else {
                System.out.println("Appointment not found.");
            }
        } catch (NumberFormatException e) {
            for (Appointment appointment : appointments) {
                if (appointment.getPatient().getName().equalsIgnoreCase(searchInput)) {
                    System.out.println(appointment.getDetails());
                    return;
                }
            }
            System.out.println("Appointment not found.");
        }
    }

//accept regiatration fee
    public void acceptRegistrationFee(int appointmentId) {
        Appointment appointment = findAppointmentById(appointmentId);
        if (appointment != null) {
            appointment.setRegistrationFeePaid(true);
            System.out.println("Registration fee paid.");
        } else {
            System.out.println("Appointment not found.");
        }
    }

//calculate total price
    public double calculateTotalFee(int appointmentId, String treatmentType) {
        Appointment appointment = findAppointmentById(appointmentId);
        if (appointment != null) {
            double totalFee = appointment.calculateFee(treatmentType);
            return totalFee;
        }
        System.out.println("Appointment not found.");
        return 0;
    }

//generate invoices
    public void generateInvoice(int appointmentId) {
        Appointment appointment = findAppointmentById(appointmentId);
        if (appointment != null) {
            System.out.println("Invoice:");
            System.out.println(appointment.getDetails());
            System.out.println("Total Fee: " + appointment.getTotalFee());
        } else {
            System.out.println("Appointment not found.");
        }
    }

    private Appointment findAppointmentById(int appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId() == appointmentId) {
                return appointment;
            }
        }
        return null;
    }

    private Dermatologist findDermatologistByName(String name) {
        for (Dermatologist dermatologist : dermatologists) {
            if (dermatologist.getName().equalsIgnoreCase(name)) {
                return dermatologist;
            }
        }
        return null;
    }
}


