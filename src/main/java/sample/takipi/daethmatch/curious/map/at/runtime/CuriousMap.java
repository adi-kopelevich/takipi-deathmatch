package sample.takipi.daethmatch.curious.map.at.runtime;

import java.util.*;

/**

 Alright, compute looks up a value in the map. If it’s null, it adds it and returns its value. Since the list is empty, “foo” doesn’t exist, v is null, and we map “foo” to a new ArrayList<Object>().
 The ArrayList is empty, so it prints out [].

 For the second line, “foo” does exist in the map so we evaluate the expression on the right. The ArrayList is cast to a List successfully, and “ber” is added to it.
 add returns true and that’s what it prints out.

 The correct answer is [] true. Thanks again Barak for sharing this question with us!

 */
public class CuriousMap {

    public static void main(String[] args) {
        Map<String, Object> coll = new TreeMap<String, Object>();
        System.out.println(coll.compute("foo", (k,v) -> (v==null) ? new ArrayList<Objects>(): ((List)v).add("bar")));
        System.out.println(coll.compute("foo", (k,v) -> (v==null) ? new ArrayList<Objects>(): ((List)v).add("ber")));
    }
}
