import Database;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        Database db = new Database("jdbc:mysql://localhost:3306/", "root", "test1234");
        try {
            db.connect(new String[]{});
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
