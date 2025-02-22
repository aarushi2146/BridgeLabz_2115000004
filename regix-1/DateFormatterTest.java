
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
class DateFormatter {
    public String formatDate(String inputDate) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
class DateFormatterTest {
    DateFormatter dateFormatter = new DateFormatter();
    @Test
    void testValidDate() {
        String inputDate = "2025-02-21";
        String expected = "21-02-2025";
        assertEquals(expected, dateFormatter.formatDate(inputDate));
    }
    @Test
    void testInvalidDate() {
        String inputDate = "2025-02-30";
        assertNull(dateFormatter.formatDate(inputDate)); 
    }
    @Test
    void testInvalidFormat() {
        String inputDate = "21-02-2025"; 
        assertNull(dateFormatter.formatDate(inputDate)); 
    }
    @Test
    void testEmptyDate() {
        String inputDate = "";
        assertNull(dateFormatter.formatDate(inputDate)); 
}


