import java.util.*;

class Patient {
    int id;
    String name;

    Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Doctor {
    int id;
    String name;

    Doctor(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Appointment {
    Patient patient;
    Doctor doctor;

    Appointment(Patient p, Doctor d) {
        this.patient = p;
        this.doctor = d;
    }
}

public class HospitalManagement {

    static List<Patient> patients = new ArrayList<>();
    static List<Doctor> doctors = new ArrayList<>();
    static List<Appointment> appointments = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while(true) {

            System.out.println("\n1.Add Patient");
            System.out.println("2.Add Doctor");
            System.out.println("3.Book Appointment");
            System.out.println("4.View Appointments");
            System.out.println("5.Exit");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    addDoctor();
                    break;

                case 3:
                    bookAppointment();
                    break;

                case 4:
                    viewAppointments();
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }

    static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Patient Name: ");
        String name = sc.next();

        patients.add(new Patient(id, name));
        System.out.println("Patient added");
    }

    static void addDoctor() {
        System.out.print("Enter Doctor ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Doctor Name: ");
        String name = sc.next();

        doctors.add(new Doctor(id, name));
        System.out.println("Doctor added");
    }

    static void bookAppointment() {

        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt();

        System.out.print("Enter Doctor ID: ");
        int did = sc.nextInt();

        Patient p = null;
        Doctor d = null;

        for(Patient pat : patients)
            if(pat.id == pid)
                p = pat;

        for(Doctor doc : doctors)
            if(doc.id == did)
                d = doc;

        if(p == null || d == null) {
            System.out.println("Invalid Patient or Doctor");
            return;
        }

        appointments.add(new Appointment(p, d));
        System.out.println("Appointment booked");
    }

    static void viewAppointments() {
        for(Appointment a : appointments) {
            System.out.println(
                    "Patient: " + a.patient.name +
                            " -> Doctor: " + a.doctor.name
            );
        }
    }
}