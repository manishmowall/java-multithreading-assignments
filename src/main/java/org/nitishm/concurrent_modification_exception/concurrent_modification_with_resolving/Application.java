package org.nitishm.concurrent_modification_exception.concurrent_modification_with_resolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/*To avoid Concurrent modification exception, one should use CopyOnWriteArrayList(ArrayList) or ConcurrentHashMap(for hashmap) classes*/

public class Application {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();;
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator<Integer> iterator = list.iterator();

        Integer value;
        while(iterator.hasNext()) {
            value = iterator.next();
            System.out.println(value);

            if(value.equals(3)) {
                list.remove(2);
            }
        }


    }
}
