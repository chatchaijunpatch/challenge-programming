package hackerearth.Array1D.Non_empty_subsets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        new Main().go();
    }

    private void go() throws FileNotFoundException {
        sc = new Scanner(new FileInputStream("src/in.txt"));
        int numtestcase = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numtestcase; i++) {
            int num = Integer.parseInt(sc.nextLine());
            String[] array = sc.nextLine().split(" ");
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                list.add(Integer.parseInt(array[j]));
            }
            int result = Collections.min(list);
            System.out.println(result);
        }
    }
}
