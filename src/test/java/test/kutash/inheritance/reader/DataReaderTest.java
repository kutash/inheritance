package test.kutash.inheritance.reader;

import com.kutash.inheritance.exception.ReadingException;
import com.kutash.inheritance.reader.DataReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DataReaderTest {

    @BeforeTest
    public static void initEmployeeTest() throws IOException {
        Path path = Paths.get("right.txt");
        List<String> lines = new ArrayList<>();
        lines.add("John Reese 1000.00 USA New-York street 7 5 B1 JUNIOR html,css,javascript");
        lines.add("John Lock 1300.00 USA Boston Street 1 2 B1 MIDDLE java,scala,sql");
        lines.add("Jack Shepard 1200.00 USA Los-Angeles Rodeo-Drive 5 22 C1 MIDDLE javascript,react,html,css");
        lines.add("Dexter Morgan 800.00 USA Miami Street 5 777 A1 JUNIOR java,sql");
        lines.add("ffdgdfgdfg");
        lines.add("Harold Finch 3000.00 USA New-York street 99 109 C2 TEAM_LEAD java,sql,javascript,react,angular,html,css");
        lines.add("44.5.5 55 664");
        lines.add("Sameen Shaw 700.00 USA New-York street 8 55 B2 JUNIOR html,css,javascript");
        lines.add("#Hello &May 700.00 Belarus Minsk street 8 55 B2 html,css,javascript");
        Files.createFile(path);
        Files.write(path,lines, Charset.forName("UTF-8"), StandardOpenOption.WRITE);
        Path pathEmpty = Paths.get("empty.txt");
        Files.createFile(pathEmpty);
    }

    @Test
    public void readingTest() throws ReadingException {
        List<String> expected = new ArrayList<>();
        expected.add("John Reese 1000.00 USA New-York street 7 5 B1 JUNIOR html,css,javascript");
        expected.add("John Lock 1300.00 USA Boston Street 1 2 B1 MIDDLE java,scala,sql");
        expected.add("Jack Shepard 1200.00 USA Los-Angeles Rodeo-Drive 5 22 C1 MIDDLE javascript,react,html,css");
        expected.add("Dexter Morgan 800.00 USA Miami Street 5 777 A1 JUNIOR java,sql");
        expected.add("ffdgdfgdfg");
        expected.add("Harold Finch 3000.00 USA New-York street 99 109 C2 TEAM_LEAD java,sql,javascript,react,angular,html,css");
        expected.add("44.5.5 55 664");
        expected.add("Sameen Shaw 700.00 USA New-York street 8 55 B2 JUNIOR html,css,javascript");
        expected.add("#Hello &May 700.00 Belarus Minsk street 8 55 B2 html,css,javascript");
        List<String> coordinates = new DataReader().read("right.txt");
        assertEquals("wrong object", expected, coordinates);
    }

    @AfterTest
    public void deleteFile() throws IOException {
        Files.delete(Paths.get("right.txt"));
        Files.delete(Paths.get("empty.txt"));
    }
}
