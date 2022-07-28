package week3_22_7_14.P11173;

import java.io.FileInputStream;

//11173 - Grey Codes 
import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);

    void go() throws Exception {
        sc = new Scanner(new FileInputStream("src/in.txt"));
        int a = sc.nextInt();
        for (int i = 0; i < a; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(k^(k>>1));

        }

    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}