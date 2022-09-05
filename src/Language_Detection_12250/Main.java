package Language_Detection_12250;
//// uhunt problem 12250

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    void go() throws Exception {
//        sc = new Scanner(new FileInputStream("src/Language_Detection_12250/in.txt"));
        List<String> keep = new ArrayList<>();
        while (true) {
            String word = sc.next();
            if (word.equals("#")) {
                break;
            }
            if (word.equals("HELLO")) keep.add("ENGLISH");
            else if (word.equals("HOLA")) keep.add("SPANISH");
            else if (word.equals("HALLO")) keep.add("GERMAN");
            else if (word.equals("BONJOUR")) keep.add("FRENCH");
            else if (word.equals("CIAO")) keep.add("ITALIAN");
            else if (word.equals("ZDRAVSTVUJTE")) keep.add("RUSSIAN");
            else keep.add("UNKNOWN");


        }
        for (int i = 0; i < keep.size(); i++) {
            int count = i + 1;
            System.out.printf("Case " + count + ": " + keep.get(i) + "\n");
        }


    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
