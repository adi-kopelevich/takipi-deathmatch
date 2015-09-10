package sample.takipi.daethmatch.brace.init;

import java.util.ArrayList;
import java.util.List;

/**
 Not many developers are aware of this syntax that comes in handy when you need to initialize a constant collection,
 although some side-effects are included. Actually, this lack of popularity might be a good thing. So when the WAT?! effect wears off,
 you can see that we add an element to the list, and then try to print it out.
 Normally you’d expect it to print out [John] but double brace initialization has other plans in mind.
 What we see here is an anonymous class that is used to initialize the List.
 When it tries to print out NAMES, it actually comes out as null. Since the initializer wasn’t consumed yet and the list is empty.
 */
public class DoubleBraceInit {

    public static final List<String> NAMES = new ArrayList<String>(){
        {
            add("john");
            add("deer");
            System.out.println(NAMES); // NAMES was'nt init yet... null is expected
        }
    };

    public static void main(String[] args) {
        System.out.println(NAMES);  // NAMES was init... [john, deer] is expected
    }
}
