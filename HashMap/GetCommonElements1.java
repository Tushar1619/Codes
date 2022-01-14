import java.io.*;
import java.util.*;

public class GetCommonElements1{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    
    int n1 = sc.nextInt();
    int[] a1 = new int[n1];
    for(int i=0;i<n1;i++){
        a1[i]=sc.nextInt();
    }
    
    int n2 = sc.nextInt();
    int[] a2 = new int[n2];
    for(int i=0;i<n2;i++){
        a2[i]=sc.nextInt();
    }
    
    HashMap<Integer,Boolean> hm = new HashMap<>();
    for(int elem:a1){
        if(hm.containsKey(elem)){
            
        }
        else{
            hm.put(elem,true);
        }
    }
    
    for(int key:a2){
        if(hm.containsKey(key)){
            System.out.println(key);
            hm.remove(key);
        }
    }
 }
}