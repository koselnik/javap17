public class Meeting {

    private String description;
    private int votes;

    public Meeting( String d) {
        description = d;
    }

    public void addVote() {
        votes++;
    }

    public int getVotes() {
        return votes;
    }

    public String getDescription() {
        return description;
    }
}
