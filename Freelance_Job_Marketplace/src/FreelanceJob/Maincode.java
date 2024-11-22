package FreelanceJob;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Maincode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("=== Freelance Job Marketplace ===");
            System.out.println("1. View All Clients");
            System.out.println("2. View All Freelancers");
            System.out.println("3. View All Jobs");
            System.out.println("4. Post a Job");
            System.out.println("5. Apply for a Job");
            System.out.println("6. Approve an Application");
            System.out.println("7. ADD Client");
            System.out.println("8. ADD Freelancer");
            System.out.println("9. Delete Client");
            System.out.println("10. Delete Freelancer");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            try {
                switch (choice) {
                    case 1:
                        viewAllClients();
                        break;
                    case 2:
                        viewAllFreelancers();
                        break;
                    case 3:
                        viewAllJobs();
                        break;
                    case 4:
                        postJob(scanner);
                        break;
                    case 5:
                        applyForJob(scanner);
                        break;
                    case 6:
                        approveApplication(scanner);
                        break;
                    case 7:
                        addNewClient(scanner);
                        break;
                    case 8:
                        addNewFreelancer(scanner);
                        break;
                    case 9:
                        deleteClient(scanner);
                        break;
                    case 10:
                        deleteFreelancer(scanner);
                        break;
                    case 11:
                        running = false;
                        System.out.println("Exiting... Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }

    private static void viewAllClients() throws SQLException {
        List<Client> clients = Client.getAllClients();
        if (clients.isEmpty()) {
            System.out.println("No clients found.");
        } else {
            for (Client client : clients) {
                System.out.println("ID: " + client.getId() + ", Name: " + client.getName() + ", Email: " + client.getEmail());
            }
        }
    }

    private static void viewAllFreelancers() throws SQLException {
        List<Freelancer> freelancers = Freelancer.getAllFreelancers();
        if (freelancers.isEmpty()) {
            System.out.println("No freelancers found.");
        } else {
            for (Freelancer freelancer : freelancers) {
                System.out.println("ID: " + freelancer.getId() + ", Name: " + freelancer.getName() + ", Skills: " + freelancer.getSkills());
            }
        }
    }

    private static void viewAllJobs() throws SQLException {
        List<Job> jobs = Job.getAllJobs();
        if (jobs.isEmpty()) {
            System.out.println("No jobs found.");
        } else {
            for (Job job : jobs) {
                System.out.println("Job ID: " + job.getJobId() + ", Title: " + job.getJobTitle() + ", Type: " + job.getJobType() + ", Budget: " + job.getBudget());
            }
        }
    }

    private static void postJob(Scanner scanner) throws SQLException {
        System.out.print("Enter Client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Job Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Job Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Job Type (Fixed-Price or Hourly): ");
        String jobType = scanner.nextLine();
        System.out.print("Enter Budget (for Fixed-Price): ");
        double budget = scanner.nextDouble();
        System.out.print("Enter Hourly Rate (for Hourly jobs): ");
        double hourlyRate = scanner.nextDouble();
        scanner.nextLine();
        Job job; 
        if (jobType.equalsIgnoreCase("Fixed-Price")) {
            job = new FixedPriceJob(clientId, title, description, budget);
        } else {
            job = new HourlyJob(clientId, title, description, hourlyRate); 
        }
        job.saveToDatabase(); 
        System.out.println("Job posted successfully.");
    }

    private static void applyForJob(Scanner scanner) throws SQLException {
        System.out.print("Enter Freelancer ID: ");
        int freelancerId = scanner.nextInt();
        if (!isFreelancerExists(freelancerId)) {
            System.out.println("Error: Freelancer ID does not exist.");
            return; // Exit the method if freelancer ID is invalid
        }

        System.out.print("Enter Job ID: ");
        int jobId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Cover Letter: ");
        String coverLetter = scanner.nextLine();

        // Assuming that freelancer_id exists, proceed with application creation
        Application application = new Application(jobId, freelancerId, coverLetter);
        application.saveToDatabase();
        System.out.println("Application submitted successfully.");
    }

    private static boolean isFreelancerExists(int freelancerId) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT COUNT(*) FROM freelancers WHERE freelancer_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, freelancerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }

    private static void approveApplication(Scanner scanner) throws SQLException {
        System.out.print("Enter Application ID: ");
        int applicationId = scanner.nextInt();
        Application application = Application.getApplicationById(applicationId);
        if (application != null) {
            application.approve();
            System.out.println("Application approved successfully.");
        } else {
            System.out.println("Application not found.");
        }
    }

    private static void addNewClient(Scanner scanner) throws SQLException {
        System.out.print("Enter Client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Client Name: ");
        String clientName = scanner.nextLine();
        System.out.print("Enter Client Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Client Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Client Address: ");
        String address = scanner.nextLine();

        Client newClient = new Client(clientId, clientName, email, phoneNumber, address, null, null);
        newClient.saveToDatabase(); 
        System.out.println("Client added successfully.");
    }

    private static void addNewFreelancer(Scanner scanner) throws SQLException {
        System.out.print("Enter Freelancer ID: ");
        int freelancerId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Freelancer Name: ");
        String freelancerName = scanner.nextLine();
        System.out.print("Enter Freelancer Skills: ");
        String skills = scanner.nextLine();
        System.out.print("Enter Freelancer Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Freelancer Phone Number: ");
        String phoneNumber = scanner.nextLine();

        Freelancer newFreelancer = new Freelancer(freelancerId, freelancerName, skills, email, phoneNumber, null, null);
        newFreelancer.saveToDatabase(); 
        System.out.println("Freelancer added successfully.");
    }

    // Method to delete client
    private static void deleteClient(Scanner scanner) throws SQLException {
        System.out.print("Enter Client ID to delete: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        Client client = Client.getClientById(clientId);
        if (client != null) {
            client.deleteFromDatabase();
            System.out.println("Client deleted successfully.");
        } else {
            System.out.println("Client with ID " + clientId + " not found.");
        }
    }

    // Method to delete freelancer
    private static void deleteFreelancer(Scanner scanner) throws SQLException {
        System.out.print("Enter Freelancer ID to delete: ");
        int freelancerId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        Freelancer freelancer = Freelancer.getFreelancerById(freelancerId);
        if (freelancer != null) {
            freelancer.deleteFromDatabase();
            System.out.println("Freelancer deleted successfully.");
        } else {
            System.out.println("Freelancer with ID " + freelancerId + " not found.");
        }
    }
}
