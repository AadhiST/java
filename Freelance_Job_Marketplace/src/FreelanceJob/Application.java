package FreelanceJob;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private int applicationId;
    private int jobId;
    private int freelancerId;
    private String coverLetter;
    private String status;
    private Timestamp applicationDate;

    // Constructor with all parameters
    public Application(int applicationId, int jobId, int freelancerId, String coverLetter, String status, Timestamp applicationDate) {
        this.applicationId = applicationId;
        this.jobId = jobId;
        this.freelancerId = freelancerId;
        this.coverLetter = coverLetter;
        this.status = status;
        this.applicationDate = applicationDate;
    }

    // New Constructor for 3 parameters (for when you apply for a job)
    public Application(int jobId, int freelancerId, String coverLetter) {
        this.jobId = jobId;
        this.freelancerId = freelancerId;
        this.coverLetter = coverLetter;
        this.status = "Pending"; // Default status
        this.applicationDate = new Timestamp(System.currentTimeMillis()); // Default current time
    }

    // Getters and setters

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getFreelancerId() {
        return freelancerId;
    }

    public void setFreelancerId(int freelancerId) {
        this.freelancerId = freelancerId;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Timestamp applicationDate) {
        this.applicationDate = applicationDate;
    }

    // Save to database
    public void saveToDatabase() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO Applications (job_id, freelancer_id, cover_letter, status, application_date) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, jobId);
        statement.setInt(2, freelancerId);
        statement.setString(3, coverLetter);
        statement.setString(4, status); // Default "Pending"
        statement.setTimestamp(5, applicationDate); // Current timestamp
        statement.executeUpdate();
        System.out.println("Application saved to database.");
    }

    // Other methods (getAllApplications, getApplicationById, approve, etc.)

    public static List<Application> getAllApplications() throws SQLException {
        List<Application> applications = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Applications";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Application application = new Application(
                resultSet.getInt("application_id"),
                resultSet.getInt("job_id"),
                resultSet.getInt("freelancer_id"),
                resultSet.getString("cover_letter"),
                resultSet.getString("status"),
                resultSet.getTimestamp("application_date")
            );
            applications.add(application);
        }
        return applications;
    }

    // Method to approve application
    public void approve() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "UPDATE Applications SET status = ? WHERE application_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "Approved");
        statement.setInt(2, applicationId);
        statement.executeUpdate();
        System.out.println("Application status updated to Approved.");
    }

    public static Application getApplicationById(int applicationId) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Applications WHERE application_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, applicationId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new Application(
                resultSet.getInt("application_id"),
                resultSet.getInt("job_id"),
                resultSet.getInt("freelancer_id"),
                resultSet.getString("cover_letter"),
                resultSet.getString("status"),
                resultSet.getTimestamp("application_date")
            );
        }
        return null;
    }
}
