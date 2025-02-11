import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class JSONReader {
    String chemin;
    Gson gson = new Gson();

    public JSONReader(String chemin) {
        this.chemin = chemin;
    }

    public JsonObject readcve_injson() throws IOException {
        try (FileReader fileReader = new FileReader(this.chemin)) {
            // Parse the JSON file and return as a JsonObject*
            return gson.fromJson(fileReader, JsonObject.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        JSONReader reader = new JSONReader("C:\\Users\\bboss\\Documents\\GitHub\\Android-CVE\\2024\\0xxx\\CVE-2024-0001.json");
        try {
            JsonObject jsonObject = reader.readcve_injson(); 
            System.out.println(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
          }
    }
}
