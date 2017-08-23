import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    public static void main(String[] args) throws IOException {

        Scanner s = null;
        Integer last;
        List<Double> x = new ArrayList<Double>();
        List<Double> y = new ArrayList<Double>();
        List<Double> z = new ArrayList<Double>();
        Double distance = 0.0;

        try {
            s = new Scanner(System.in);

            last = s.nextInt();

            for (int i = 0; i < last; i++) {
                x.add(s.nextDouble());
                y.add(s.nextDouble());
                z.add(s.nextDouble());
            }

            for (int i = 0; i < last-1; i++) {
                Double xPoint = calculatePoint(x);
                Double yPoint = calculatePoint(y);
                Double zPoint = calculatePoint(z);
                distance += calculateDistance(xPoint, yPoint, zPoint);
            }

            System.out.format("%.2f%n", distance);

        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    static Double calculatePoint (List<Double> points) {
        Double first = pop(points);
        Double second = points.get(0);
        Double pointSum = first - second;

        return Math.pow(pointSum, 2);
    }

    static Double calculateDistance(Double a, Double b, Double c) {

        Double d = Math.sqrt(a+b+c);
        return d;
    }
    static Double pop (List<Double> points) {
        if(!points.isEmpty()){
           Double i= points.get(0);
           points.remove(0);
           return i;
        } else {
           return -1.0; // Or any invalid value
        }
    }
}
