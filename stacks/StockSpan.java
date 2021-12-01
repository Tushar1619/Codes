package stacks;
import java.util.*;
public class StockSpan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++) {
            arr[i]=sc.nextInt();
        }
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        st.push(0);
        ans[0]=1;

        for(int i=1;i<arr.length;i++){
            while(st.size()!=0 && arr[i]>=arr[st.peek()]){
                st.pop();
            }

            if(st.size()==0){
                ans[i]=i+1;
            }else{
                ans[i]=i-st.peek();
            }

            st.push(i);
        }

    }
}