import java.io.*;
import java.util.*;

public class LongestConsecutiveSequence{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
    }

    HashMap<Integer,Boolean> hm = new HashMap<>();

    for(int key:a){
        hm.put(key,true);
    }

    for(int key:a){
        if(hm.containsKey(key-1)){
            hm.put(key,false);
        }     
    }

    int mc=0;
    int mk=0;
    for(int key:a){
        if(hm.get(key)){
            int tc=1;
            int tk=key;

            while(hm.containsKey(tk+tc)){
                tc++;
            }
            if(tc>mc){
            mc=tc;
            mk=tk;
        }
        }

        
    }

    for(int i=0;i<mc;i++){
        System.out.println(mk+i);
    }
 }

}

