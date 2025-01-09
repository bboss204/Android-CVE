import Database;
import java.sql.SQLException;
//les condition pour que ce code marche sont que vous avez une base de donnée mysql et que vous avez un utilisateur root avec le mot de passe test1234
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
