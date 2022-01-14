import java.io.*;
import java.util.*;

public class Intro {

  public static void main(String[] args)
  {
    HashMap< String, Integer> hm = new HashMap< >();
    hm.put("India", 1391);
    hm.put("China", 1398);
    hm.put("USA", 329);
    hm.put("Indonesia", 268);

    //Using keySet() to iterate through the hashmap
    for (String key : hm.keySet())
    {
      Integer val = hm.get(key);
      System.out.print(key + ":" + val + "  ");
    }
  }
}