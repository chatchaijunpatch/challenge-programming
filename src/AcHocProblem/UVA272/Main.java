// uva 272
package AcHocProblem.UVA272;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
    void go() throws Exception{
        // space complexity = O(1)
        sc = new Scanner(new FileInputStream("src/in.txt"));
        boolean first =true;
        while (sc.hasNext()){
            String text = sc.nextLine();

            for (int i = 0; i < text.length(); i++) {
                char t = text.charAt(i);
                if ((t == '"')&&first){
                    System.out.print("``");
                    first = false;
                }
                else if ((t == '"')&& (!first)){
                    System.out.print("''");
                    first = true;
                }
                else {
                    System.out.print(t);
                }
            }
            System.out.println();
        }


    }
}
