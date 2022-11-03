package Contest.P2File_Reorganization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        new Main().go();
    }

    private void go() throws FileNotFoundException {
        sc = new Scanner(new FileInputStream("src/in.txt"));
        String str = sc.nextLine();
//        System.out.println(solution(str));
        solution(str);
    }

//    static void printSubStr(String str, int low, int high)
//    {
//        for (int i = low; i <= high; ++i)
//            System.out.print(str.charAt(i));
//    }
static Integer findLongestPalindromicString(String text)
{
    int N = text.length();
    if (N == 0)
        return 0;
    N = 2 * N + 1; // Position count
    int[] L = new int[N + 1]; // LPS Length Array
    L[0] = 0;
    L[1] = 1;
    int C = 1; // centerPosition
    int R = 2; // centerRightPosition
    int i = 0; // currentRightPosition
    int iMirror; // currentLeftPosition
    int maxLPSLength = 0;
    int maxLPSCenterPosition = 0;
    int start = -1;
    int end = -1;
    int diff = -1;

    // Uncomment it to print LPS Length array
    // printf("%d %d ", L[0], L[1]);
    for (i = 2; i < N; i++)
    {

        // get currentLeftPosition iMirror
        // for currentRightPosition i
        iMirror = 2 * C - i;
        L[i] = 0;
        diff = R - i;

        // If currentRightPosition i is within
        // centerRightPosition R
        if (diff > 0)
            L[i] = Math.min(L[iMirror], diff);

        // Attempt to expand palindrome centered at
        // currentRightPosition i. Here for odd positions,
        // we compare characters and if match then
        // increment LPS Length by ONE. If even position,
        // we just increment LPS by ONE without
        // any character comparison
        while (((i + L[i]) + 1 < N && (i - L[i]) > 0) &&
                (((i + L[i] + 1) % 2 == 0) ||
                        (text.charAt((i + L[i] + 1) / 2) ==
                                text.charAt((i - L[i] - 1) / 2))))
        {
            L[i]++;
        }

        if (L[i] > maxLPSLength) // Track maxLPSLength
        {
            maxLPSLength = L[i];
            maxLPSCenterPosition = i;
        }

        // If palindrome centered at currentRightPosition i
        // expand beyond centerRightPosition R,
        // adjust centerPosition C based on expanded palindrome.
        if (i + L[i] > R)
        {
            C = i;
            R = i + L[i];
        }

        // Uncomment it to print LPS Length array
        // printf("%d ", L[i]);
    }

    start = (maxLPSCenterPosition - maxLPSLength) / 2;
    end = start + maxLPSLength - 1;
//    for (i = start; i <= end; i++)
//        System.out.print(text.charAt(i));
   return end;
}
    static ArrayList<String> lst = new ArrayList<>();

     static ArrayList<String> permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            lst.add(prefix);
        }
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
        return lst;
    }
    static ArrayList<String> findPermutations(String string) {
        findPermutationswithN(string, string.length());
        return perms;
    }
    static ArrayList<String> perms = new ArrayList<>();

    static void findPermutationswithN(String string, Integer size) {
        if(size == 1) {
            perms.add(string);
        }
        else {
            for(Integer i = 0; i < size;i++) {
                findPermutationswithN(string, size - 1);
                if(size % 2 == 0) {
                    string = swap(string, i, size - 1);
                }
                else {
                    string = swap(string, 0, size - 1);
                }
            }
        }
    }


    static String swap(String string,Integer i, Integer j) {
        String[] stringarr = string.split("");
        String temp = stringarr[i];
        stringarr[i] = stringarr[j];
        stringarr[j] = temp;
        StringBuilder builder = new StringBuilder();
        for(String s: stringarr) {
            builder.append(s);
        }
        String str = builder.toString();
        return str;
    }

    private void solution(String str) {
//        permutation("",str);
        if (str.length() == 1) System.out.println(1);
        else {
        ArrayList<String> strings = findPermutations(str);
        ArrayList<Integer> results = new ArrayList<>();
        for (String s : strings){

            results.add(findLongestPalindromicString(s));
        }
        System.out.println(Collections.max(results));
//        return Collections.max(results);
//        }

    }
}
}


