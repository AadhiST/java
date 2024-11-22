package FreelanceJob;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Job
{
	private final int jobId;
    private int clientId;
    private String jobTitle;
    private String description;
    private String jobType;
    private double budget;
    private double hourlyRate;
    private String status;
    private Timestamp postingDate;
    private Date dueDate;
    public Job(int jobId,int clientId,String jobTitle,String description,String jobType,double budget,double hourlyRate,String status,Timestamp postingDate, Date dueDate) 
    {
        this.jobId = jobId;
        this.clientId = clientId;
        this.jobTitle = jobTitle;
        this.description = description;
        this.jobType = jobType;
        this.budget = budget;
        this.hourlyRate = hourlyRate;
        this.status = status;
        this.postingDate = postingDate;
        this.dueDate = dueDate;
    }
    public static List<Job> getAllJobs() throws SQLException 
    {
        List<Job> jobs = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Jobs";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) 
        {
            Job job = new Job(
                resultSet.getInt("job_id"),
                resultSet.getInt("client_id"),
                resultSet.getString("job_title"),
                resultSet.getString("description"),
                resultSet.getString("job_type"),
                resultSet.getDouble("budget"),
                resultSet.getDouble("hourly_rate"),
                resultSet.getString("status"),
                resultSet.getTimestamp("posting_date"),
                resultSet.getDate("due_date")
            );
            jobs.add(job);
        }
        return jobs;
    }
    public int getJobId() {
        return jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getJobType() {
        return jobType;
    }

    public double getBudget() {
        return budget;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
 // Add to Job class
    public void saveToDatabase() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO Jobs (client_id, job_title, description, job_type, budget, hourly_rate, status, posting_date, due_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, clientId);
        statement.setString(2, jobTitle);
        statement.setString(3, description);
        statement.setString(4, jobType);
        statement.setDouble(5, budget);
        statement.setDouble(6, hourlyRate);
        statement.setString(7, "Open"); // Default status
        statement.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
        statement.setDate(9, dueDate);
        statement.executeUpdate();
        System.out.println("Job saved to database.");
    }
	
}
