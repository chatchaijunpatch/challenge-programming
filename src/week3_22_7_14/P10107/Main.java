package week3_22_7_14.P10107;
// uhunt problem 10107

import java.io.FileInputStream;
import java.util.*;

public class Main {
    public static Long Median(  List<Long> values) {
        Collections.sort(values);
        if (values.size() % 2 == 1)
            return values.get((values.size() + 1) / 2 - 1);
        else {
            double lower = values.get(values.size() / 2 - 1);
            double upper = values.get(values.size() / 2);

            return (long) ((lower + upper) / 2);
        }
    }
//    Scanner sc = new Scanner(System.in);
    void go() throws Exception {
      Scanner sc = new Scanner(new FileInputStream("src/week3_22_7_14/P10107/in.txt"));
        List<Long> input = new ArrayList<Long>();
        List<Long> keep = new ArrayList<Long>();

        while (true){
            try {
                Long a = sc.nextLong();
                input.add(a);
                keep.add(Median(input));
            }
            catch (Exception e){
                break;
            }
        }
        for (int i =0; i< keep.size();i++){
            System.out.println(keep.get(i));
        }


    }
    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
