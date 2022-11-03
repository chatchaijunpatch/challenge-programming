package Contest.P1Banker_and_Stocks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    public boolean[] primebool = new boolean[1000000 + 1];


    public ArrayList<BigInteger> GenPrimesInrage() {
        ArrayList<BigInteger> pp = new ArrayList<>();
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
                pp.add(BigInteger.valueOf(p));
            }
        }
//        pp.remove(0);
        pp.remove(pp.size() - 1);
        return pp;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new Main().go();
    }
    private void go() throws FileNotFoundException {
        sc = new Scanner(new FileInputStream("src/in.txt"));
        ArrayList<BigInteger> primes = GenPrimesInrage();
        while (sc.hasNextLine()) {
            ArrayList<BigInteger> resultPrime = new ArrayList<>();
            ArrayList<BigInteger> result = new ArrayList<>();
            BigInteger a = sc.nextBigInteger();
            if (primes.contains(a)){
                resultPrime.add(a);
            }
                for (BigInteger num : primes) {
                    if (a.mod(num).equals(a) ) {
                        break;
                    } else if (a.mod(num).equals(BigInteger.ZERO) ) {
                        resultPrime.add(num);

                    }
                }

            for (BigInteger num: resultPrime){
                result.add(num);
                if (!primes.contains(a.divide(num))){
                    result.add(a.divide(num));
                }

            }
            result.add(BigInteger.ONE);
            result.add(a);
            int odd = 0;
            int even = 0;
            for (BigInteger num: result){
                if (num.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)){
                    even+=1;
                }
                else odd+=1;
            }
            if (a.equals(BigInteger.ZERO)) System.out.println("BUY");
            else if (odd>even) System.out.println("SELL");
            else if (even >odd) System.out.println("BUY");
            else System.out.println("PASS");


        }

    }
}
