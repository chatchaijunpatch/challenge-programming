// UVA100 The 3n + 1 problem
package AcHocProblem.UVA100;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
        new Main().go();
    }
    // Space complexity O(1)
    private  int cycle_length(int n){
        int length = 1; // 1
        while (true){ // (n+1) (n is constant) so O(1)
            if (n == 1) break;
            else {
                if (n%2 != 0) n = (3*n)+1;
                else n = n/2;
                length += 1;
            }
        }
        return length;
    }
    // space complexity O(1)
    private  int maxValue(int[] n){
        int max_val = -1; // 1
        for(int num : n){ // (n+1) (n is constant) so O(1)
            if (num>max_val) max_val=num;
        }
        return max_val;
    }
    private void go() throws FileNotFoundException {
        // space complexity is O(n)
        sc = new Scanner(new FileInputStream("src/in.txt"));
        try{
        while (sc.hasNext()) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int m = 0;
            boolean swap = false;
            if (i > j) {
                m = j;
                j = i;
                i = m;
                swap = true;
            }
            int[] keep; //
            int count = 0; // O(1)
            keep = new int[(j - i) + 1]; // O(1)+O(1)+O(1)+O(1) + O(n)
            for (int k = i; k <= j; k++) { // (n)
                keep[count] = cycle_length(k);
                count += 1;
            }
            if (swap) System.out.println(j + " " + i + " " + maxValue(keep));
            else System.out.println(i + " " + j + " " + maxValue(keep));
        }
        }
        catch(Exception e){

        }
    }
}
