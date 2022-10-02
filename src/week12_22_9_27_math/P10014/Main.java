package week12_22_9_27_math.P10014;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    void go() throws Exception {
        sc = new Scanner(new FileInputStream("src/in.txt"));
        String a = sc.nextLine();
        sc.nextLine();
        for (int i = 0; i < Integer.parseInt(a); i++) {
            double n = Double.parseDouble(sc.nextLine());
            double a0 = Double.parseDouble(sc.nextLine());
            double an_1 = Double.parseDouble(sc.nextLine());

            double c = 0;
            double count = 0;
            while (true) {
                String b = sc.nextLine();
                if (b.isEmpty()) {
                    break;
                } else {
//                    System.out.println(count);
                    c += (2 * (n - count) * Double.parseDouble(b));
                    count++;


                }
                if (!sc.hasNextLine()) break;
            }
            double ans =  (((n * a0 + an_1) - c) / (n + 1));
            if (i == Integer.parseInt(a)-1) {
                System.out.printf("%.2f\n",ans);
            } else {


                System.out.printf("%.2f\n\n", ans);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
