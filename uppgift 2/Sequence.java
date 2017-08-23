import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Sequence {
    public static void main(String[] args) throws IOException {

        Scanner s = null;
        Integer first;
        Integer last;
        List<Integer> numbers = new ArrayList<Integer>();


        try {
            s = new Scanner(System.in);

            first = s.nextInt();
            last = s.nextInt();

            for (int i = first; i < last+1; i++) {
                numbers.add(breakDown(i));
            }

            numbers.forEach((n) -> System.out.println(n));

        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    static int breakDown(int a) {
        Integer count = 0;
        while (a != 1) {

            if((a % 2 ) == 0){
                // even
                a = a/2;
            } else
            {
                // odd
                a = a * 3 + 1;
            }
            count++;
        }
        return count;
    }
}
