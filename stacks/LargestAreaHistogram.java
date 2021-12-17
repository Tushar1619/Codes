import java.io.*;
import java.util.*;

public class LargestAreaHistogram{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }

    // code
    int[] rb = new int[arr.length]; //nse to the right
    rb[arr.length-1]=arr.length;
    Stack<Integer> rst = new Stack<Integer>();
    rst.push(arr.length-1);

    for(int i=arr.length-2;i>=0;i--){
       while(rst.size()!=0 && arr[i]<=arr[rst.peek()]){
          rst.pop();
       }

       if(rst.size()==0){
          rb[i]=arr.length;
       }else{
          rb[i]=rst.peek();
       }
       rst.push(i);
    }

    int[] lb = new int[arr.length]; //nse to the left
    lb[0]=-1;
    Stack<Integer> lst = new Stack<Integer>();
    lst.push(0);

    for(int i=1;i<arr.length;i++){
       while(lst.size()!=0 && arr[i]<=arr[lst.peek()]){
          lst.pop();
       }

       if(lst.size()==0){
          lb[i]=-1;
       }else{
          lb[i]=lst.peek();
       }
       lst.push(i);
    }

    int maxArea=0;
    for(int i=0;i<arr.length;i++){
       int width=rb[i]-lb[i]-1;
       int area=arr[i]*width;
       if(area>maxArea){
          maxArea=area;
    }
 }
 System.out.println(maxArea);
}
}