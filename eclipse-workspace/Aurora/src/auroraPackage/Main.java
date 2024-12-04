package auroraPackage;

import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	String months[] = {
                "Jan",
                "Feb",
                "Mar",
                "Apr",
                "May",
                "Jun",
                "Jul",
                "Aug",
                "Sep",
                "Oct",
                "Nov",
                "Dec"
            };
            Calendar calendar = Calendar.getInstance();
            //System.out.println("--------------------------------------------------------------------------------");
            int count1 = 4, count2 = 4, count3 = 4, count4 = 4, count5 = 4;
            System.out.println("\n--------------------------------------------------------------------------------");
            System.out.println("               *** AURORA SKIN CARE CLINIC***");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("Date: " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR));
            System.out.println("\t\t\t\t\t\tTime: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
       
        Scanner scanner = new Scanner(System.in);
        ClinicSystem system = new ClinicSystem();

        // Add dermatologists to the system
        system.addDermatologist(new Dermatologist("Dr. Piyal", new String[] {"Monday", "Wednesday"}));
        system.addDermatologist(new Dermatologist("Dr. Malka", new String[] {"Friday", "Saturday"}));

        int choice;
        do {
            System.out.println("\n                          MAIN MENU");
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("1. Make Appointment");
            System.out.println("2. Update Appointment");
            System.out.println("3. View Appointments by Date");
            System.out.println("4. Search Appointment");
            System.out.println("5. Pay Registration Fee");
            System.out.println("6. Calculate Total Fee");
            System.out.println("7. Generate Invoice");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter patient NIC: ");
                    String nic = scanner.nextLine();
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter patient email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter patient phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter dermatologist name: ");
                    String dermName = scanner.nextLine();
                    System.out.print("Enter appointment date (e.g., Monday): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter appointment time (e.g., 10:15): ");
                    String time = scanner.nextLine();

                    Patient patient = new Patient(nic, name, email, phone);
                    system.makeAppointment(patient, dermName, date, time);
                    break;

                    //update existing appointmnet
                case 2:
                    System.out.print("Enter appointment ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter new appointment date: ");
                    String newDate = scanner.nextLine();
                    System.out.print("Enter new appointment time: ");
                    String newTime = scanner.nextLine();
                    system.updateAppointment(updateId, newDate, newTime);
                    break;

                case 3:
                    System.out.print("Enter date to view appointments: ");
                    String viewDate = scanner.nextLine();
                    system.viewAppointmentsByDate(viewDate);
                    break;

                    //search patients by appintment ID or patient name
                case 4:
                    System.out.print("Enter patient name or appointment ID to search: ");
                    String searchInput = scanner.nextLine();
                    system.searchAppointment(searchInput);
                    break;

                    //accept registration fee after make an appointment
                case 5:
                    System.out.print("Enter appointment ID to pay registration fee: ");
                    int payId = scanner.nextInt();
                    system.acceptRegistrationFee(payId);
                    break;

                    //calculate total price
                case 6:
                    System.out.print("Enter appointment ID: ");
                    int feeId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter treatment type (Acne, Whitening, Mole, Laser): ");
                    String treatmentName = scanner.nextLine();
                    double total = system.calculateTotalFee(feeId, treatmentName);
                    System.out.println("Total fee: " + total);
                    break;

                    //generate invoice for the treatment
                case 7:
                    System.out.print("Enter appointment ID to generate invoice: ");
                    int invoiceId = scanner.nextInt();
                    system.generateInvoice(invoiceId);
                    break;

                case 8:
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }
}


