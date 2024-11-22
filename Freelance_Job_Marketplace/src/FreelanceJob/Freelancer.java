package FreelanceJob;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Freelancer 
{
	private int freelancerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String skills;
    private Timestamp createdAt;
    public Freelancer(int freelancerId,String firstName,String lastName,String email,String phoneNumber,String skills,Timestamp createdAt) 
    {
        this.freelancerId = freelancerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.skills = skills;
        this.createdAt = createdAt;
    }
    public static List<Freelancer> getAllFreelancers() throws SQLException 
    {
        List<Freelancer> freelancers = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Freelancers";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) 
        {
            Freelancer freelancer = new Freelancer(
                resultSet.getInt("freelancer_id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("email"),
                resultSet.getString("phone_number"),
                resultSet.getString("skills"),
                resultSet.getTimestamp("created_at")
            );
            freelancers.add(freelancer);
        }
        return freelancers;
    }
    public int getId() {
        return freelancerId;
    }

    public String getName() {
        return firstName + " " + lastName;
    }
    public String getSkills() {
        return skills;
    }
    public void saveToDatabase() throws SQLException {
        Connection conn = DatabaseConnection.getConnection(); // Assuming you have a Database class for managing DB connections
        String query = "INSERT INTO freelancers (freelancer_id, first_name, skills, email, phone_number) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, this.freelancerId);
            stmt.setString(2, this.firstName);
            stmt.setString(3, this.skills);
            stmt.setString(4, this.email);
            stmt.setString(5, this.phoneNumber);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error saving freelancer to the database: " + e.getMessage());
        }
    }
    public static Freelancer getFreelancerById(int freelancerId) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM freelancers WHERE freelancer_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, freelancerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Assuming Freelancer has the constructor Freelancer(int, String, String, String, String)
                return new Freelancer(
                        rs.getInt("freelancer_id"),
                        rs.getString("name"),
                        rs.getString("skills"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        null, // Add other fields if necessary
                        null  // Add other fields if necessary
                );
            } else {
                return null; // Freelancer not found
            }
        }
    }

    // Method to delete freelancer from the database
    public void deleteFromDatabase() throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "DELETE FROM freelancers WHERE freelancer_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, this.getId());
            stmt.executeUpdate();
        }
    }
}
