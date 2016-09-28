package org.webonise.concurrentmodificationexception.exceptioncreation;

import java.util.ArrayList;
import java.util.List;

/*concurrent modification exception occurs when thread is traversing the list(or hashmap) and some structural modification to list(or hashmap) takes place.*/
public class Application {
   public static void main(String[] args) {

      System.out.println("\n=======Concurrent Modification Exception=======\n");
      List<Integer> list = new ArrayList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(4);
      list.add(5);

      int index = 2;
      int element = 3;
      System.out.println("Print list while removing " + element + " element from the list");
      for (Integer num : list) {
         System.out.println(num);

         if (num.equals(element)) {
            list.remove(index);
         }
      }
   }
}
