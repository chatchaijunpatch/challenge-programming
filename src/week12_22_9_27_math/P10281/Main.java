package week12_22_9_27_math.P10281;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
//UVA 10281 - Average Speed

public class Main {
    Scanner sc = new Scanner(System.in);

    void go() throws Exception {
        sc = new Scanner(new FileInputStream("src/in.txt"));
        int keep = 0;
        Date date1 = new Date();
        String a = sc.nextLine();
        while (sc.hasNextLine()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            String[] input = a.split(" ");
            if (input.length == 2){
                 date1 =simpleDateFormat.parse(input[0]);
                 keep = Integer.parseInt(input[1]);
            }
            else {
                Date date2 = simpleDateFormat.parse(input[0]);
                long differenceInMilliSeconds
                        = Math.abs(date2.getTime() - date1.getTime());
                long differenceInMinutes
                        = (differenceInMilliSeconds / (60 * 1000)) % 60;
//                System.out.println((differenceInMinutes/60)*keep);

            }
            a = sc.nextLine();
        }

    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}