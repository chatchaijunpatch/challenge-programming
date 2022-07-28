package week5_22_7_28.P10954;
// uhunt problem 10954

import java.io.FileInputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    Long solution(PriorityQueue input){
        PriorityQueue<Long> n = input;
        long cost = 0;
        for (int i = n.size(); i > 1; i--) {
            long total = n.poll().hashCode()+n.poll().hashCode();
            cost += total;
            n.add(total);
        }
        return cost;

    }

    //    Scanner sc = new Scanner(System.in);
    void go() throws Exception {
        Scanner sc = new Scanner(new FileInputStream("src/week5_22_7_28/P10954/in.txt"));


        while (true) {
            Long count = sc.nextLong();
            if (count == 0) break;
            else {
                PriorityQueue<Long> input = new PriorityQueue<Long>();
                int i = 0;
                while (i < count){
                    long a = sc.nextLong();
                    input.add(a);
                    i++;
                }
                System.out.println(solution(input));;
            }


        }



    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
