package week1_22_6_30;
// uhunt problem 10550

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
//    Scanner sc = new Scanner(System.in);
    void go() throws Exception {
      Scanner sc = new Scanner(new FileInputStream("src/week1_22_6_30/in.txt"));
        List<Integer> keep = new ArrayList<Integer>();
        int current = 0;
        int total = 0;
        while (true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            if (a == 0 && b == 0 && c==0 && d == 0) break;
            current = a;
            total = (40*2*9);
            if (current < b){
                total +=(40-b+current)*9;
            }
            else {
                total += (current-b)*9;
            }
            current = b;
            total += (40*9);
            if (current <= c){
                total += (c-current)*9;
            }
            else {
                total += (40-current+c)*9;
            } //1350
            current = c;//0
            if (current < d){
                total +=(40-d+current)*9;
            }
            else {
                total += (current-d)*9;
            }
            keep.add(total);
        }
        for (int i =0; i< keep.size();i++){
            System.out.println(keep.get(i));
        }

    }
    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
