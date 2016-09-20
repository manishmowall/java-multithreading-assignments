package org.webonise.concurrent_modification_exception.concurrent_modification_without_resolving;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*concurrent modification exception occurs when thread is traversing the list(or hashmap) and some structural modification to list(or hashmap) takes place.*/

public class Application {
   public static void main(String[] args) {

      List<Integer> list = new ArrayList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(4);
      list.add(5);

      Iterator<Integer> iterator = list.iterator();

      Integer value;
      while (iterator.hasNext()) {
         value = iterator.next();
         System.out.println(value);

         if (value.equals(3)) {
            //making changes to the list
            list.remove(value);
         }
      }
   }
}
