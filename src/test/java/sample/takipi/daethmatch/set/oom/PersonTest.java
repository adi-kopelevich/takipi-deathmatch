package sample.takipi.daethmatch.set.oom;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Set;

/**
 * Created by kopelevi on 10/09/2015.
 */
public class PersonTest {

    @Test
    public void whenGetPersonCliqueThenReturnSetOfPersonClique() throws Exception {
        int numOfPersons = 100;
        Person p = null;
        Person bestFriend = new Person("p1", null);
        for (int i = 2; i <= numOfPersons; i++) {
            p = new Person("p" + i, bestFriend);
            bestFriend = p;
        }

        Set<Person> pClique = Person.getBestFriendsClique(p);
        Assert.assertEquals(numOfPersons - 1, pClique.size());
    }

//    @Test
//    public void whenGetPersonCliqueIsTooBigThenOutOfMemoryIsReturned() throws Exception {
//        int numOfPersons = 1000000000;
//        Person p = null;
//        Person bestFriend = new Person("p1", null);
//        for (int i = 2; i <= numOfPersons; i++) {
//            p = new Person("p" + i, bestFriend);
//            bestFriend = p;
//        }
//
//        Set<Person> pClique = Person.getBestFriendsClique(p);
//        Assert.assertEquals(numOfPersons - 1, pClique.size());
//    }
}
