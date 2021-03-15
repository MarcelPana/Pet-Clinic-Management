import com.opencsv.exceptions.CsvValidationException;
import menu.Menu;
import utils.HibernateUtil;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, CsvValidationException {
        new Menu();

        HibernateUtil.shutdown();
    }
}
