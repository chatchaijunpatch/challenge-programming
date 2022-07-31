package week5_22_7_28.P11286;
// uhunt problem 11286

import java.io.FileInputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
//        Scanner sc = new Scanner(System.in);
    void go() throws Exception {
        Scanner sc = new Scanner(new FileInputStream("src/week5_22_7_28/P11286/in.txt"));
        while (true) {
            Long count = sc.nextLong();
            if (count == 0) break;
            else {
                Map<List<Long>,Integer> map = new HashMap<>();
                for (int i = 0; i < count; i++) {
                    List<Long> input = new ArrayList<>();
                    long a = sc.nextLong();
                    long b = sc.nextLong();
                    long c = sc.nextLong();
                    long d = sc.nextLong();
                    long e = sc.nextLong();
                    input.add(a);
                    input.add(b);
                    input.add(c);
                    input.add(d);
                    input.add(e);
                    Collections.sort(input);
                    if (map.containsKey(input)){
                        map.put(input,map.get(input).hashCode()+1);
                    }
                    else {
                        map.put(input,1);
                    }
                }
                // Print value from map
                // if all on map == size it's mean that all subject is unique
                // else that mean they have some subject list that not unique so we have to compare with max subject combination
                if (count == map.size()) System.out.println(count);
                else {
                    int result = 0;
                    Integer maxvalue = Collections.max(map.values()); //max subject combination มีซ้ำกันสูงสุด
                    for (Map.Entry<List<Long>, Integer> entry : map.entrySet()) {
                        if (entry.getValue() .equals(maxvalue)){ //เทียบกับคู่ที่สูงที่สุดในกรณีที่ มีคู่ซ้ำกันมากกว่า 1
                            result +=  entry.getValue();
                        }
                    }
                    System.out.println(result);
                }


            }


        }


    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
