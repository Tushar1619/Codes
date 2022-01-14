import java.io.*;
import java.util.*;

public class HighestFreqCharacter {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(hm.containsKey(ch)){
                int oldv = hm.get(ch);
                int newv = oldv+1;
                hm.put(ch, newv);
            }
            else{
                hm.put(ch, 1);
            }
        }

        char mc = str.charAt(0);
        for(Character key : hm.keySet()){
            if(hm.get(key)>hm.get(mc)){
                mc=key;
            }
        }
        System.out.println(mc);
    }

}