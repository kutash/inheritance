package test.kutash.inheritance.parser;

import com.kutash.inheritance.exception.EmployeeException;
import com.kutash.inheritance.exception.ReadingException;
import com.kutash.inheritance.parser.StringParser;
import com.kutash.inheritance.reader.DataReader;
import org.testng.annotations.Test;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class ParserTest {

    @Test
    public void parserTest() throws ReadingException, EmployeeException {
        DataReader reader = new DataReader();
        List<String> data = reader.read("right.txt");
        StringParser parser = new StringParser();
        String[][][] expected = {{{"John", "Reese", "1000.00", "USA", "New-York", "street", "7", "5", "B1", "JUNIOR","html,css,javascript"},{"html","css","javascript"}},
                                 {{"John", "Lock", "1300.00", "USA", "Boston", "Street", "1", "2", "B1", "MIDDLE","java,scala,sql"},{"java","scala","sql"}},
                                 {{"Jack", "Shepard", "1200.00", "USA", "Los-Angeles", "Rodeo-Drive", "5", "22", "C1", "MIDDLE", "javascript,react,html,css"},{"javascript","react","html","css"}},
                                 {{"Dexter", "Morgan", "800.00", "USA", "Miami", "Street", "5", "777", "A1", "JUNIOR", "java,sql"},{"java","sql"}},
                                 {{"Harold", "Finch", "3000.00", "USA", "New-York", "street", "99", "109", "C2", "TEAM_LEAD", "java,sql,javascript,react,angular,html,css"},{"java","sql","javascript","react","angular","html","css"}},
                                 {{"Sameen", "Shaw", "700.00", "USA", "New-York", "street", "8", "55", "B2", "JUNIOR", "html,css,javascript"},{"html","css","javascript"}}};
        List<String[][]> validData = parser.parseString(data);
        String[][][] actual = {validData.get(0),validData.get(1),validData.get(2),validData.get(3),validData.get(4),validData.get(5)};
        assertArrayEquals("wrong data",actual,expected);
    }
}
