package week5_22_7_28.week6_Longest_Increasing_Subsequence.dynamic;

public class main {
    public static int LengthOFLIS(int[] a){
        int [] LIS = {1,1,1,1,1,1,1};
        for (int i = a.length-1; i >-1 ; i--) {
            for (int j = i+1; j < a.length ; j++) {
                if (a[i] < a[j]){
                    LIS[i] = Math.max(LIS[i],1+LIS[j]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (LIS[i] > max){
                max = LIS[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {10,7,3,5,8,2,9};
        System.out.println(LengthOFLIS(a));
    }
}
