package sample.takipi.daethmatch.exceptions;

import java.sql.SQLException;

/**
 * Alright, so what do we have here? We have generics with type erasure involved, and a couple of exceptions. A few things to remember here:
 * <p>
 * 1. RuntimeException and SQLException both inherit from Exception, while RuntimeException is unchecked and SQLException is a checked exception.
 * 2. Java generics are not reified, meaning that in compile time, the generic type information is “lost” and treated as if the code is replaced with the type’s bound or with Object if it doesn’t exist.
 * This is what you call type erasure.
 * <p>
 * Naively we’d expect line 7 to cause a compilation error since you can’t cast SQLException to RuntimeException, but that’s not the case.
 * What happens is that T is replaced with Exception so we have:
 * <p>
 * throw (Exception) t;  // t is also an Exception
 * <p>
 * Since pleaseThrow expects an Exception, and T is replaced with Exception, the cast is eliminated as if it wasn’t written. We can see that in bytecode:
 * <p>
 * Just for fun, we tried to see what the bytecode will look like without generics involved, and the cast appeared right before the ATHROW statement:
 * <p>
 * CHECKCAST java/lang/RuntimeException
 * <p>
 * Now that we’re convinced there’s no casting involved, we can scratch off these two answers:
 * “Compilation fails because we cannot cast SQLException to RuntimeException”
 * “Throws ClassCastException because SQLException is not instanceof RuntimeException”
 * <p>
 * So we throw a SQLException after all, and you’d expect it to get caught by the catch block and get its stack trace. Well, not really. This game is rigged. Turns out the compiler gets confused just as we do, and the code makes it think that the catch block is unreachable. For the unsuspecting bystander, there is no SQLException. The correct answer is that compilation fails because the compiler doesn’t expect a SQLException to be thrown from the try block – When in fact it does get thrown!
 */
public class Mocker<T extends Exception> {
    public void pleaseThrow(final Exception t) throws T {
        throw (T) t;
    }

    public static void main(String[] args) {
        try {
            new Mocker<RuntimeException>().pleaseThrow(new SQLException());
//        } catch (final SQLException ex) {  //compilation error that suggest that SQLException is never thrown altougth it is...
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
}
