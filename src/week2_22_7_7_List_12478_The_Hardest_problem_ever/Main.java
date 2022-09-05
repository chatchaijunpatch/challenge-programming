package week2_22_7_7_List_12478_The_Hardest_problem_ever;
// uhunt problem 12478

import java.util.*;

public class Main {
    void go() throws Exception {
        String[] grid = {"obidaibkr", "rkaulhisp", "sadiyanno", "heisawhia", "irakibuls", "mfbintrno", "utoyzifah", "lebsynune", "emotional"
                ,"orshimule","bkaerftem","iadiabobo","duiskiyst","alyainzyi","ihawbtino","binhurfun","ksnilnana","rpoasohel"
        };
        String[] names = {"rakibul", "anindya", "moshiur", "shiplu", "kabir", "sunny", "obaida", "wasi"};
        Map<String,Integer> collect = new HashMap<String,Integer>();
        for (int i  = 0; i < names.length ; i++) {
            int len = names[i].length();
            int count = 0;
            for (int j = 0; j < grid.length; j++) {
                char[] charsName = names[i].toCharArray();
                Arrays.sort(charsName);
                String stringName = String.valueOf(charsName);
                for (int k = 0; k < grid[j].length(); k++) {
                    try {
                        char[] charsGrid = grid[j].substring(k,len+k).toCharArray();
                        Arrays.sort(charsGrid);
                        String stringGrid = String.valueOf(charsGrid);
                        if (stringGrid.equals(stringName)){
                            count+=1;
                            collect.put(names[i],count);
                        }
                    }
                    catch (Exception e){

                    }
                }
            }
        }
        int max = Collections.max(collect.values());
        for (Map.Entry<String, Integer> entry : collect.entrySet()) {

            if (entry.getValue() == max) {
                System.out.println(entry.getKey().toUpperCase());
            }
        }

    }
    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
