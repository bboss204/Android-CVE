import java.io.FileReader;
import java.io.IOException;


public class JsonFile {
    String chemin;

    public JsonFile(String chemin) {
        this.chemin = chemin;
    }

    public JsonObject read() throws IOException {
        try (FileReader fileReader = new FileReader(this.chemin)) {
            // Parse the JSON file and return as a JsonObject
            JsonParser parser = new JsonParser();
            return parser.parse(fileReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "erreur";
    }
}
