import java.io.FileReader;
import java.io.IOException;
import java.gson.Gson;


public class JSONReader {
    String chemin;
    Gson gson = new Gson();

    public JSONReader(String chemin) {
        this.chemin = chemin;
    }

    public CVE readcve_injson() throws IOException {
        try (FileReader fileReader = new FileReader(this.chemin)) {
            // Parse the JSON file and return as a JsonObject
            return gson.fromJson(fileReader, CVE.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "erreur";
    }
}
