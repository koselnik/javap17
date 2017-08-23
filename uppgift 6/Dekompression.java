import java.io.*;
import java.util.*;

public class Dekompression {

    public static LinkedList<String> queueInput = new LinkedList<String>();

    public static void main(String[] args) throws IOException {

        Scanner s = null;
        String output;

        try {
            s = new Scanner(System.in);
            String input = s.next();
            List<String> inputList = new ArrayList<String>(Arrays.asList(input.split("(?!^)")));

            inputList.forEach((i) -> {
                queueInput.add(i);
            });

            output = reconstruct();
            System.out.println(output);

        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    static String reconstruct() {
        String str = "";

        if (!queueInput.isEmpty()) {
            String first = queueInput.peek();

            if (first.equals("a") || first.equals("b")) {
                str += queueInput.pop();
                str += reconstruct();
            } else if (isStringInt(first)) {
                int number = Integer.valueOf(queueInput.pop());
                str += nextToNumber(number);
                str += reconstruct();
            } else if (first.equals(")")) {
                return "";
            }
        }
        return str;
    }

    static String nextToNumber(int num) {
        String next = queueInput.peek();
        String str = "";

        if (next.equals("a") || next.equals("b")) {
            str += multiplyString(num, queueInput.pop());
            str += reconstruct();
        } else if (next.equals("(")) {
            str += handleParenthesis(num);
            str += reconstruct();
        } else if (isStringInt(next)){
            String nextStr = queueInput.pop();
            int combinedNum = Integer.valueOf(String.valueOf(num) + nextStr);
            str += nextToNumber(combinedNum);
            str += reconstruct();
        }

        return str;
    }

    static String handleParenthesis(int num) {
        String s = "";

        queueInput.removeFirst();

        while (!")".equals(queueInput.peek())) {
            s += reconstruct();
        }

        queueInput.removeFirst();

        String str = multiplyString(num, s);

        return str;
    }

    static String multiplyString(int num, String s) {
        String str = "";

        for (int i = 0; i < num; i++) {
            str += s;
        }

        return str;
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
