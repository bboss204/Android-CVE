import java.io.File;
import java.time.Year;
//les condition pour que ce code marche sont que vous avez une base de donnée mysql et que vous avez un utilisateur root avec le mot de passe test1234
public class Main {

    public static void main(String[] args) {
        Database db = new Database("jdbc:mysql://localhost:3306/", "root", "test1234");
        YearFolder year = new YearFolder("C:\\Users\\bboss\\Documents\\GitHub\\Android-CVE\\2024");
        JsonReader reader = new JsonReader();
        try {
            print(year.listfiles(new File(yearpath)));
        } catch (Exception e) {
            e.printStackTrace();
        
        }
    }
}
