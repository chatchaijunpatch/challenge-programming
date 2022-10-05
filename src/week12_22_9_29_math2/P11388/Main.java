package week12_22_9_29_math2.P11388;


import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    void go() throws Exception {
        sc = new Scanner(new FileInputStream("src/in.txt"));
        int a = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < a; i++) {
            String[] input = sc.nextLine().split(" ");
            int b = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            int gcd =GCD(b,c);
            int lcm = LCM(b,c);

            if (gcd!= b && lcm != c) System.out.println(-1);
            else {
                System.out.println(gcd+" "+lcm);
            }

        }

    }
    private int GCD(int b, int c) {
        if (b%c ==0)return c;
        return GCD(c,b%c);
    }
    private int LCM(int b,int c){
        return (b/GCD(b,c))*c;
    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}