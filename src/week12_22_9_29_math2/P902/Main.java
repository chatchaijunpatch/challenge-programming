package week12_22_9_29_math2.P902;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    void go() throws Exception {
        sc = new Scanner(new FileInputStream("src/in.txt"));

        while (sc.hasNext()) {
            int range = sc.nextInt();
            String string = sc.next();
            HashMap<String, Integer> storage = new HashMap<>();
            for (int i = 0; i < string.length() - range + 1; i++) {
                String in = string.substring(i, i + range);
                if (storage.isEmpty()) {
                    storage.put(in, 1);
                } else {
                    if (storage.containsKey(in)) {
                        int l = storage.get(in);
                        storage.put(in, l + 1);
                    } else {
                        storage.put(in, 1);
                    }
                }

            }
            int max = Collections.max(storage.values());
            String result = "";
            for (String i : storage.keySet()) {
                if (storage.get(i) == max) {
                    result = i;
                }
            }
            System.out.println(result);
        }


    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}