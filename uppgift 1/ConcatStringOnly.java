import java.io.*;
import java.util.Scanner;

public class ConcatString {
    public static void main(String[] args) throws IOException {

        Scanner s = null;
        String everything;
        String next;
        Integer n;

        try {
            s = new Scanner(new BufferedReader(new FileReader("sample.txt")));
            StringBuilder sb = new StringBuilder();
            n = s.nextInt();

            for (int i = 0; i < n; i++) {
                next = s.next();
                sb.append(next);
            }

            everything = sb.toString();

            System.out.println(removeSpaces(everything));

        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    static String removeSpaces(String s) {
        s = s.replaceAll("\\s+","");
        return s;
    }
}
