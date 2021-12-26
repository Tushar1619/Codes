import java.util.*;

public class Constructor {

  public static void main(String[] args) {
    // Write your code here
    int[] arr ={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
    Stack<Node> st = new Stack();
    Node root;

    for(int i=0;i<arr.length;i++){
        if(arr[i]==-1){
            st.pop();
        }
        else{
            Node temp = new Node();
            temp.data=arr[i];

            if(st.size()==0){
                root=temp;
            }
            else{
                st.peek().children.add(temp);
            }

            st.push(temp);
        }
    }
  }
}