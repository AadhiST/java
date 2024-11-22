package FreelanceJob;

public class FixedPriceJob extends Job {
    public FixedPriceJob(int clientId, String jobTitle, String description, double budget) {
        super(0, clientId, jobTitle, description, "Fixed-Price", budget, 0, "Open", null, null);
    }
}
