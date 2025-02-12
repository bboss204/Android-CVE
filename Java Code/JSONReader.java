import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.*;


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
 
    public CVE JsonreaderToCVE(JsonObject jsonObject) {
        String cveID = jsonObject.get("cveMetadata").getAsString();
        String state = jsonObject.get("state").getAsString();
        String datePublished = jsonObject.get("datePublished").getAsString();
        String dateUpdated = jsonObject.get("dateUpdated").getAsString();
        String title = jsonObject.get("title").getAsString();
        String vendor = jsonObject.get("vendor").getAsString();
        String product = jsonObject.get("product").getAsString();
        String versionProduct = jsonObject.get("versionProduct").getAsString();
        String statusProduct = jsonObject.get("statusProduct").getAsString();
        String descriptions = jsonObject.get("descriptions").getAsString();
        float cvssBaseScore = jsonObject.get("cvssBaseScore").getAsFloat();
        String technicalDescription = jsonObject.get("technicalDescription").getAsString();
        String exploit = jsonObject.get("exploit").getAsString();
        return new CVE(cveID, state, datePublished, dateUpdated, title, vendor, product, versionProduct, statusProduct, descriptions, cvssBaseScore, technicalDescription, exploit);
    }

    public static void main(String[] args) {
        JSONReader reader = new JSONReader("C:\\Users\\bboss\\Documents\\GitHub\\Android-CVE\\2024\\0xxx\\CVE-2024-0001.json");
        try {
            JsonObject jsonObject = reader.readcve_injson(); 
            CVE cve1 = reader.JsonreaderToCVE(jsonObject);
            System.out.println(cve1);
        } catch (IOException e) {
            e.printStackTrace();
          }
    }
}
