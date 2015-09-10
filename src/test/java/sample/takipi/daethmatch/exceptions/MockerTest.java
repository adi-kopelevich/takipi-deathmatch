package sample.takipi.daethmatch.exceptions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.sql.SQLException;

/**
 * Created by kopelevi on 10/09/2015.
 */
public class MockerTest {

    @Rule
    public ExpectedException expectedException =  ExpectedException.none();

    @Test
    public void testName() throws Exception {
        expectedException.expect(SQLException.class);
        new Mocker<RuntimeException>().pleaseThrow(new SQLException());
    }
}
