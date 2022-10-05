package week12_22_9_29_math2.P11827;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    void go() throws Exception {
        sc = new Scanner(new FileInputStream("src/in.txt"));
        int a = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < a; i++) {
            String[] input = sc.nextLine().split(" ");
            int max = 0;
            for (int j = 0; j < input.length-1; j++) {
                for (int k = j+1; k < input.length; k++) {
                   int b = Integer.parseInt(input[j]);
                   int c = Integer.parseInt(input[k]);
                   int val = GCD(b,c);
                   if (max<val) max = val;
                }
            }
            System.out.println(max);
        }

    }

    private int GCD(int b, int c) {
        if (b%c ==0)return c;
        return GCD(c,b%c);
    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}