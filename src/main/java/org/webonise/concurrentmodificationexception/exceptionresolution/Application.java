package org.webonise.concurrentmodificationexception.exceptionresolution;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*To avoid Concurrent modification exception, one should use CopyOnWriteArrayList(for ArrayList) or ConcurrentHashMap(for hashmap) classes*/
public class Application {
   public static void main(String[] args) {

      System.out.println("\n=======Concurrent Modification Exception After Resolving=======\n");
      System.out.println("=====Using CopyOnWriteArrayList=====\n");
      List<Integer> list = new CopyOnWriteArrayList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(4);
      list.add(5);

      /*CopyOnWriteArrayList provide fresh copy of array list to each block asking for it. And any changes made to the list while
      * block is working on it's copy of list will not be reflected to block's copy.But if after changes, some other block ask for
      * list , that copy will reflects the changes.Thus It will avoid conurrent modification exception as specific block's copy
      * will not be effected by changes made to the main list*/
      int index = 2;
      int element = 3;
      System.out.println("Given a copy to first FOR loop ");
      System.out.println("Print list while removing " + element + " element from the list");
      for (Integer num : list) {
         System.out.println(num);

         if (num.equals(element)) {
            list.remove(index);
         }
      }
      System.out.println("No changes are reflected on FOR\'s list. But Main list is changed\n");

      System.out.println("Given updated copy to second FOR loop");
      System.out.println("Printing list with recent update to Main list");
      for (int num : list) {
         System.out.println(num);
      }
   }
}
