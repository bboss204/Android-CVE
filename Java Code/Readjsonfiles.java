import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Readjsonfiles {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\bosch\\OneDrive\\Documents\\Cours\\2eme\\Android-CVE\\2024\\0xxx";
        List<JsonObject> jsonObjects = readJsonFiles(folderPath);
        saveToDatabase(jsonObjects);
    }

    public static List<JsonObject> readJsonFiles(String folderPath) {
        List<JsonObject> jsonObjects = new ArrayList<>();
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));

        if (files != null) {
            JsonParser parser = new JsonParser();
            for (File file : files) {
                if (file.isFile()) {
                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                        JsonObject jsonObject = parser.parse(br).getAsJsonObject();
                        jsonObjects.add(jsonObject);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("Le dossier est vide ou n'existe pas.");
        }
        return jsonObjects;
    }

    public static void saveToDatabase(List<JsonObject> jsonObjects) {
        String url = "jdbc:mysql://localhost:3306/cve";
        String user = "root";
        String password = "root";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO cve (product, version, cveId) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            for (JsonObject jsonObject : jsonObjects) {
                String product = jsonObject.get("product").getAsString();
                String version = jsonObject.get("version").getAsString();
                String cveId = jsonObject.get("cveId").getAsString();

                pstmt.setString(1, product);
                pstmt.setString(2, version);
                pstmt.setString(3, cveId);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            System.out.println("Données insérées avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
