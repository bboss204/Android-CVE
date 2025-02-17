import java.io.File;
import java.sql.SQLException;

import com.google.gson.JsonObject;

//les condition pour que ce code marche sont que vous avez une base de donnée mysql et que vous avez un utilisateur rt avec le mot de passe rt
public class Main {

    public static void main(String[] args) throws SQLException {
        String path = "C:\\Users\\bboss\\Documents\\GitHub\\Android-CVE\\2024";
        Database db = new Database("jdbc:mysql://localhost:3306/android_cve", "root", "test1234");
        db.initiate_androidCVE_DB();
        YearFolder y2024 = new YearFolder(path);
        int id = 0;
        try {
            for (File jsonin2024 : y2024.listfiles(new File(path))){
                id++;
                JSONReader reader = new JSONReader(jsonin2024.getAbsolutePath());
                JsonObject jsonObject = reader.readcve_injson();
                CVE cve = reader.JsonreaderToCVE(jsonObject);
                String sql = cve.toSQL();
                db.writeDB(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        
        }
        system.out.println("Insertion terminée ! " + id + " entrées insérées");
    }
}
