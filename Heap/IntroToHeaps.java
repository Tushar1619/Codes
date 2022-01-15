import java.io.*;
import java.util.*;

public class IntroToHeaps {
    public static void main(String[] args) throws Exception {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int[] ranks = {22,44,54,2,9,88,1,7,38};

    for(int val:ranks){
        pq.add(val);
    }

    while(pq.size()>0){
        System.out.println(pq.peek());
        pq.remove();
    }
    }
}

//Output will be a sorted set of elements also called as heap sorting
// 1
// 2
// 7
// 9
// 22
// 38
// 44
// 54
// 88
