import java.io.*;
import java.util.*;

public class Constructor {

 public static class Node{
    int data;
    Node left;
    Node right;

    Node(int data,Node left,Node right){
        this.data=data;
        this.left=left;
        this.right=right;
    }
 }
 public static class Pair {
     Node node;
     int state;

     Pair(Node node,int state){
         this.node=node;
         this.state=state;
     }
 }
 
 public static void display(Node node){
     if(node==null){
         return;
     }
    if(node.left==null && node.right!=null){
        System.out.println("."+" -> " + node.data +" <- " + node.right.data);
    }
    if(node.right==null && node.left!=null){
        System.out.println(node.left.data+" -> " + node.data +" <- " + ".");
    }
    if(node.right==null && node.left==null){
        System.out.println("." + " -> " + node.data +" <- " +".");
    }
    if(node.left!=null && node.right!=null){
    System.out.println(node.left.data+" -> " + node.data +" <- " + node.right.data);
    }

    display(node.left);
    display(node.right);
 }

 public static void main(String[] args) {
    Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};

    Node root = new Node(arr[0], null, null);
    Pair rootPair = new Pair(root, 1);
    Stack<Pair> st = new Stack<>();
    st.push(rootPair);
    int idx=1;

    while(st.size()>0){
        Pair top = st.peek();
        
        if(top.state==1){
            if(arr[idx]!=null){
                Node lc = new Node(arr[idx], null, null);
                top.node.left=lc;

                Pair lp = new Pair(lc, 1);
                st.push(lp);
            }
            top.state=2;
            idx++;
        }
        else if(top.state==2){
            if(arr[idx]!=null){
                Node rc = new Node(arr[idx], null, null);
                top.node.right=rc;
                Pair rp = new Pair(rc, 1);
                st.push(rp);
            }
            top.state=3;
            idx++;
        }
        else{
            st.pop();
        }
       
    }
    display(root);
}
}
