//package Cost_Cut_11727;
// uhunt problem 10550
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    void go() throws Exception {
//        sc = new Scanner(new FileInputStream("src/Cost_Cut_11727/in.txt"));
        List<Integer> keep = new ArrayList<>();
        int a = sc.nextInt();
        for (int i = 0; i<a;i++){
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            list.add(b);
            list.add(c);
            list.add(d);
            Collections.sort(list);
            keep.add(list.get(1));
        }
        for (int i =0; i< keep.size();i++){
            int count = i+1;
            System.out.printf("Case "+count+": "+keep.get(i)+"\n");
        }



    }
    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
