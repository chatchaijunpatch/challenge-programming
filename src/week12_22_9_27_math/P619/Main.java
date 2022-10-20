package week12_22_9_27_math.P619;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        new Main().go();
    }
    static String reverse(String a){
        String ret = new String("");
        int len = a.length()-1;
        for(int i=len;i>=0;i--){
            ret = ret+a.charAt(i);
        }
        return ret;
    }
    static String convert(String a){
        String ret = new String("");
        a = reverse(a);
        for(int i=0;i<a.length();i++){
            if(i != 0 && i%3==0)
                ret = ret+',';
            ret = ret+a.charAt(i);
        }
        return reverse(ret);
    }
    static String convertToString (BigInteger a){
        String ret = new String("");
        BigInteger div = BigInteger.valueOf(26);
        while(a.compareTo(BigInteger.ZERO) != 0){
            BigInteger tmp = a.mod(div);
            a = a.divide(div);
            long val = tmp.longValue();
            ret = ret+(char)('a'+(val-1+26)%26);
        }
        if(ret.length() == 0)
            return new String("a");
        return reverse(ret);
    }
    String convertToNumber(String string){
        int a = 97;
        BigInteger alphabetNum = BigInteger.valueOf(26);
        BigInteger result = BigInteger.ZERO;
        int p = 0;
        for (int i = string.length()-1; i >= 0 ; i--) {
            result = result.add(alphabetNum.pow(p).multiply(BigInteger.valueOf(string.charAt(i)-a+1)));
            p += 1;
        }
        return result.toString();
    }
     void go() throws FileNotFoundException {

         sc = new Scanner(new FileInputStream("src/in.txt"));
         while (true){
             String a = sc.nextLine();
             String result = "";
             String val = "";
             if (a.charAt(0) == 42) break; //42 = *
             else {
                 //สำหรับเปลี่ยนอักษรเป็นตัวเลข
                 if (a.charAt(0) > '9'){
                     val = convertToNumber(a);
                     result = a;
                 }
                 else {
                     result = convertToString(new BigInteger(a));
                     val =a;
                 }
             }
             int tmp = result.length();
             System.out.print(result);
             for(int i=tmp;i<22;i++)
                 System.out.print(' ');
             val = convert(val);
             System.out.println(val);
         }



     }
}
