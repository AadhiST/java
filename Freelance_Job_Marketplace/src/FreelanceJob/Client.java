package FreelanceJob;

import java.sql.*;
import java.util.*;

public class Client {

    private int clientID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private Timestamp createdAt;

    // Constructor
    public Client(int clientID, String firstName, String lastName, String email, String phoneNumber, String address, Timestamp createdAt) {
        this.clientID = clientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.createdAt = createdAt;
    }

    // Get all clients from the database
    public static List<Client> getAllClients() throws SQLException {
        List<Client> clients = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Clients";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Client client = new Client(
                    resultSet.getInt("client_id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("address"),
                    resultSet.getTimestamp("created_at")
            );
            clients.add(client);
        }
        return clients;
    }

    // Getter for clientID
    public int getId() {
        return clientID;
    }

    // Getter for client's full name
    public String getName() {
        return firstName + " " + lastName;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Save client to database
    public void saveToDatabase() throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "INSERT INTO clients (client_id, first_name, last_name, email, phone_number, address, created_at) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, this.clientID);
            stmt.setString(2, this.firstName);
            stmt.setString(3, this.lastName); // Include last name
            stmt.setString(4, this.email);
            stmt.setString(5, this.phoneNumber);
            stmt.setString(6, this.address);
            stmt.setTimestamp(7, this.createdAt); // Include created_at timestamp
            stmt.executeUpdate();
            System.out.println("Client saved to database.");
        } catch (SQLException e) {
            throw new SQLException("Error saving client to the database: " + e.getMessage());
        }
    }

    // Optional: Method to update client in the database (if needed)
    public void updateInDatabase() throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "UPDATE clients SET first_name = ?, last_name = ?, email = ?, phone_number = ?, address = ?, created_at = ? WHERE client_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, this.firstName);
            stmt.setString(2, this.lastName);
            stmt.setString(3, this.email);
            stmt.setString(4, this.phoneNumber);
            stmt.setString(5, this.address);
            stmt.setTimestamp(6, this.createdAt);
            stmt.setInt(7, this.clientID);
            stmt.executeUpdate();
            System.out.println("Client updated in database.");
        } catch (SQLException e) {
            throw new SQLException("Error updating client in the database: " + e.getMessage());
        }
    }

    public static Client getClientById(int clientId) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM clients WHERE client_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, clientId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Assuming Client has the constructor Client(int, String, String, String, String)
                return new Client(
                        rs.getInt("client_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("address"),
                        null, // You can add other fields like jobs, if necessary
                        null  // You can add other fields like posts, if necessary
                );
            } else {
                return null; // Client not found
            }
        }
    }

    // Method to delete client from the database
    public void deleteFromDatabase() throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "DELETE FROM clients WHERE client_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, this.getId());
            stmt.executeUpdate();
        }
    }

    // Main method to test saving a client to the database
    public static void main(String[] args) {
        try {
            // Example client data
            Timestamp createdAt = new Timestamp(System.currentTimeMillis());
            Client client = new Client(101, "EEE", "LastName", "eee@example.com", "555-5555-5555", "cbe", createdAt);
            client.saveToDatabase(); // Save the client to the database
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
