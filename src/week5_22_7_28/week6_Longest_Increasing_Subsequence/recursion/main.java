package week5_22_7_28.week6_Longest_Increasing_Subsequence.recursion;

public class main {
   public static int LengthOfLIS(int[] nums){
       return LIS(-1,0,nums);
   }
   public static int LIS(int prev, int curr, int nums[]){
       if (curr == nums.length) return 0;
       int var = 0;
       if (prev == -1 || nums[prev]<nums[curr]){
           var = 1+LIS(curr,curr+1,nums);
       }
       int var2 = LIS(prev,curr+1,nums);
       return Math.max(var,var2);
   }

    public static void main(String[] args) {
        int[] a = {10,7,3,5,8,2,9};
        System.out.println(LengthOfLIS(a));
    }
}
