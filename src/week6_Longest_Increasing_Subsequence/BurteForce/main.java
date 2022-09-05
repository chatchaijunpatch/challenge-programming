package week6_Longest_Increasing_Subsequence.BurteForce;

public class main {
    public static void main(String[] args) {
        int[] a = {10,7,3,5,8,2,9};
        int max = -1;
        int Slst[] = new int[7];
        for (int i = 0; i < (1<<a.length); i++) {
            Boolean[] ret = new Boolean[a.length];

            int var = i;
            int count = 0;
            // Collect Boolean from bit
            for (int j = 1 << 6; j>0;j = j/2) {
                if ((var & j) != 0) ret[count] = true;
                else ret[count] = false;
                count+=1;
            }
            int select = -1;
            int lst = 0;
            count = 0;
            int SLSTCollect[] = new int[7];
            // Find LIS
            for (int j = 0; j < a.length; j++) {
                if (ret[j]){
                    if (a[j]>select){
                        select = a[j];
                        lst+=1;
                        SLSTCollect[count] = select;
                        count+=1;
                    }
                }

            }
            if (lst>max){
                max = lst;
                Slst = SLSTCollect;
            }
        }
        for (int i = 0; i < Slst.length; i++)
            System.out.printf(String.valueOf(Slst[i])+" ");
        System.out.println();
        System.out.println("Value "+max);

    }
}
