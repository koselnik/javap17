import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;


public class Tidsbokning {
    public static void main(String[] args) throws IOException {

        Scanner s = null;
        Meeting[] meetings;

        try {
            s = new Scanner(System.in);

            int numMeetings = s.nextInt();
            int numPeople = s.nextInt();
            int id;
            String description;
            List<String> peopleVotes = new ArrayList<String>();
            List<String> votes = new ArrayList<String>();

            meetings = new Meeting[numMeetings];
            s.nextLine();

            for ( int i = 0; i < numMeetings; i++ ) {
                description = s.nextLine();
                meetings[i] = new Meeting(description);
            }

            for (int a = 0; a < numPeople; a++) {
                String x = s.nextLine();
                peopleVotes.add(x);
            }

            peopleVotes.forEach((n) -> {
                List<String> items = Arrays.asList(n.split("\\s+"));
                items.forEach((v)-> {
                    if (isStringInt(v)) {
                        votes.add(v);
                    }
                });
            });

            votes.forEach((v)-> {
                int vote = Integer.parseInt(v);
                meetings[vote].addVote();
            });

            Collections.reverse(Arrays.asList(meetings));
            Collections.sort(Arrays.asList(meetings), Comparator.comparing(a -> a.getVotes()));
            Collections.reverse(Arrays.asList(meetings));

            for ( int i = 0; i < numMeetings; i++ ) {
                System.out.println(meetings[i].getDescription() + " " + meetings[i].getVotes());
            }

        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    static boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
