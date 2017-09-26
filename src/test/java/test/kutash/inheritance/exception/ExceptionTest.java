package test.kutash.inheritance.exception;

import com.kutash.inheritance.creator.EmployeeCreator;
import com.kutash.inheritance.exception.EmployeeException;
import com.kutash.inheritance.exception.EmployeeTypeNotFoundException;
import com.kutash.inheritance.exception.ReadingException;
import com.kutash.inheritance.factory.EmployeeFactory;
import com.kutash.inheritance.parser.StringParser;
import com.kutash.inheritance.reader.DataReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ExceptionTest {

    private DataReader reader;
    private StringParser parser;
    private EmployeeCreator creator;

    @BeforeClass
    public void setUp(){
        reader = new DataReader();
        parser = new StringParser();
        creator = new EmployeeCreator();
    }

    @Test
    public void readingExceptionTest(){
        try {
            reader.read("noFile.txt");
            fail("Test should have thrown a ReadingException");
        } catch (ReadingException e) {
            assertEquals("exception in reader coordinates", e.getMessage());
        }
    }

    @Test
    public void noDataExceptionTest(){
        try {
            reader.read("empty.txt");
            fail("Test should have thrown a ReadingException");
        } catch (ReadingException e) {
            assertEquals("empty file", e.getMessage());
        }
    }

    @Test
    public void parserNullExceptionTest() {
        try {
            parser.parseString(null);
            fail("Test should have thrown a EmployeeException");
        } catch (EmployeeException e) {
            assertEquals("no data for parsing", e.getMessage());
        }
    }

    @Test
    public void creatorNullExceptionTest() throws EmployeeException, EmployeeTypeNotFoundException {
        try {
            creator.createDeveloper(null);
            fail("Test should have thrown a ShapeException");
        } catch (EmployeeException e) {
            assertEquals("no data to create object", e.getMessage());
        }
    }

    @Test
    public void wrongRadiusExceptionTest() {
        try{
            new EmployeeFactory().getEmployee("employee");
            fail("Test should have thrown a EmployeeTypeNotFoundException");
        }catch(EmployeeTypeNotFoundException e) {
            assertEquals("this type of employee does not exist", e.getMessage());
        }
    }

}
