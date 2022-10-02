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
        double previous =0 ;
        double distance =0;
        double currentspeed = 0;
        String a = sc.nextLine();
        while (a != null) {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            String[] input = a.split(" ");
            double currenttime = simpleDateFormat.parse(input[0]).getTime();
            double travel = currenttime - previous;
            double currentspeedtravel = currentspeed * (travel/3600000);
            if (input.length == 2){
                distance+= currentspeedtravel;
                previous = currenttime;

                currentspeed = Double.parseDouble(input[1]);

            }
            else {
                System.out.printf(input[0]+" "+ "%.2f km"+"\n",(distance+currentspeedtravel));

            }
            if (!sc.hasNextLine())break;
            a = sc.nextLine();
        }

    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}