import java.io.*;
import java.util.Scanner;

public class ConcatStringOnly {
    public static void main(String[] args) throws IOException {

        Scanner s = null;
        String everything;
        String next;

        try {
            s = new Scanner(new BufferedReader(new FileReader("sample.txt")));
            StringBuilder sb = new StringBuilder();

            while (s.hasNext()) {
                next = s.next();
                if (!isStringInt(next)) {
                    sb.append(next);
                }
            }

            everything = sb.toString();

            System.out.println(removeSpaces(everything));

        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    static boolean isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }

    static String removeSpaces(String s) {
        s = s.replaceAll("\\s+","");
        return s;
    }
}
