package FreelanceJob;

public class HourlyJob extends Job {
    public HourlyJob(int clientId, String jobTitle, String description, double hourlyRate) {
        super(0, clientId, jobTitle, description, "Hourly", 0, hourlyRate, "Open", null, null);
    }
}
