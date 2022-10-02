package week12_22_9_29_math2.P00543;

//UVa00543(Goldbach’s Conjecture)

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    public boolean[] primebool = new boolean[1000000 + 1];


    public ArrayList<Integer> GenPrimesInrage() {
        ArrayList<Integer> pp = new ArrayList<>();
        for (int i = 0; i <= 1000000; i++) {
            primebool[i] = true;
        }
        for (int p = 2; p * p <= 1000000; p++) {
            if (primebool[p]) {
                for (int i = p * p; i < 1000000; i += p) {
                    primebool[i] = false;
                }
            }
        }
        for (int p = 2; p <= 1000000; p++) {
            if (primebool[p]) {
                pp.add(p);
            }
        }
        pp.remove(0);
        pp.remove(pp.size() - 1);
        return pp;
    }

    void go() throws Exception {
        sc = new Scanner(new FileInputStream("src/in.txt"));
        ArrayList<Integer> primes = GenPrimesInrage();
//        System.out.println(primes);
        int a = sc.nextInt();
        while (true) {
            if (a == 0) break;

            for (int i = 0; primes.get(i) <= a / 2; i++) {
                if (primebool[a - primes.get(i)]) {
                    System.out.println(a + " = " + primes.get(i) + " + " + (a - primes.get(i)));

                    break;
                }

            }
            a = sc.nextInt();

        }

    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
