import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Enigma {
    public static void main(String[] args) throws IOException {

        Scanner s = null;

        try {
            s = new Scanner(System.in);

            String encrypted = s.next();
            String word = s.next();

            List<String> encryptedChars = new ArrayList<String>(Arrays.asList(encrypted.split("(?!^)")));
            List<String> wordChars = new ArrayList<String>(Arrays.asList(word.split("(?!^)")));
            List<Integer> positions = new ArrayList<Integer>();
            int difference = encryptedChars.size() - wordChars.size();

            for (int i = 0; i <= difference; i++) {
                int count = 0;
                for (int a = 0; a < wordChars.size(); a++) {
                    if (!isSameChar(encryptedChars.get(a+i), wordChars.get(a))) {
                        count++;
                    }
                }

                if (count == wordChars.size()) {
                    positions.add(i+1);
                }
            }

            if(positions.isEmpty()) {
                positions.add(-1);
            }

            positions.forEach((n) -> System.out.println(n));

        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    static boolean isSameChar (String encryptedChar, String wordChar) {
        return encryptedChar.equals(wordChar);
    }

    static boolean checkAllChars (List<String> encrypted, List<String> word, int indexEncryted) {
        int count = 0;
        for (int i = 0; i < word.size(); i++) {
            if (isSameChar(encrypted.get(i + indexEncryted), word.get(i))) {
                count++;
            }
        }
        return count == word.size();
    }
}
