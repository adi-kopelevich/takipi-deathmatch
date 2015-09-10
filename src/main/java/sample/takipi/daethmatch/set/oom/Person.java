package sample.takipi.daethmatch.set.oom;

import java.util.HashSet;
import java.util.Set;

/**
 So what are we seeing here? We have a method that returns a set containing a “clique” of a person’s best friends.
 We see that there’s a loop that checks if a person has a best friend, and adds them to the results set.
 If a person indeed has a best friend, it repeats the process for them, so we end up having a set of best friends until we reach a person who doesn’t have a best friend
 OR that its best friend is already in the set. That last part might be a bit tricky – we can’t add a person who is already in the set so there’s no potential for an infinite loop.

 The problem here is that we’re risking an out of memory exception. There’s no bound on the set so we can keep adding and adding people until we run out of memory.
 */
public class Person {

    private String name;
    private Person bestFriend;

    public Person(String name, Person bestFriend) {
        this.name = name;
        this.bestFriend = bestFriend;
    }

    public static Set<Person> getBestFriendsClique(Person person) {
        Set<Person> result = new HashSet<Person>();

        while ((person.bestFriend != null) && (result.add(person.bestFriend))) {
            person = person.bestFriend;
        }

        return result;
    }
}
