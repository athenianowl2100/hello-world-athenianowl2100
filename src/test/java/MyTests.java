import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTests {

    public static void assertMultipleEquals(String[] expected, String actual, String message) {
        for (String str: expected) {
            if (str.equals(actual)) {
                assertEquals(str, actual, message);
                return;
            }
        }

        assertEquals(expected[0], actual, message);
    }

    @Test
    public void testStdoutGreeting() throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(bos));

            // Call main()
            MyMain.main(null);

            // assert statements
            String str = bos.toString().trim();

            assertMultipleEquals(new String[]{"Hello world!", "Hello, world!"}, str, "Output should be \"Hello world!\" or \"Hello, world!\"");

            // Boolean bool = str.equals("Hello world!") || str.equals("Hello, world!");
            // assertTrue(bool, "Output should be \"Hello world!\" or \"Hello, world!\"");

            // undo the binding in System
            System.setOut(originalOut);
        }
    }
}
