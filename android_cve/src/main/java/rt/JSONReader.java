package rt;
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
            // Parse the JSON file and return as a JsonObject
            return gson.fromJson(fileReader, JsonObject.class);
        } catch (Exception e) {
        }
        return null;
    }

    public CVE JsonreaderToCVE(JsonObject jsonObject) {
        JsonObject cveMetadata = jsonObject.has("cveMetadata") ? jsonObject.getAsJsonObject("cveMetadata") : new JsonObject();
        String cveID = cveMetadata.has("cveId") ? cveMetadata.get("cveId").getAsString() : "";
        String state = cveMetadata.has("state") ? cveMetadata.get("state").getAsString() : "";
        String datePublished = cveMetadata.has("datePublished") ? cveMetadata.get("datePublished").getAsString() : "";
        String dateUpdated = cveMetadata.has("dateUpdated") ? cveMetadata.get("dateUpdated").getAsString() : "";

        JsonObject cna = jsonObject.has("containers") ? jsonObject.getAsJsonObject("containers").getAsJsonObject("cna") : new JsonObject();
        String descriptions = "";
        if (cna.has("descriptions") && cna.get("descriptions").isJsonArray() && cna.getAsJsonArray("descriptions").size() > 0) {
            descriptions = cna.getAsJsonArray("descriptions").get(0).getAsJsonObject().has("value") ? cna.getAsJsonArray("descriptions").get(0).getAsJsonObject().get("value").getAsString() : "";
        }
    
        String title = cna.has("title") ? cna.get("title").getAsString() : "";

        String vendor = "";
        String product = "";
        String versionProduct = "";
        String statusProduct = "";
        if (cna.has("affected") && cna.get("affected").isJsonArray() && cna.getAsJsonArray("affected").size() > 0) {
            JsonObject affected = cna.getAsJsonArray("affected").get(0).getAsJsonObject();
            vendor = affected.has("vendor") ? affected.get("vendor").getAsString() : "";
            product = affected.has("product") ? affected.get("product").getAsString() : "";

            if (affected.has("versions") && affected.get("versions").isJsonArray() && affected.getAsJsonArray("versions").size() > 0) {
                JsonObject versionInfo = affected.getAsJsonArray("versions").get(0).getAsJsonObject();
                versionProduct = versionInfo.has("version") ? versionInfo.get("version").getAsString() : "";
                statusProduct = versionInfo.has("status") ? versionInfo.get("status").getAsString() : "";
            }
        }

        float cvssBaseScore = 0.0f;
        if (cna.has("metrics") && cna.get("metrics").isJsonArray() && cna.getAsJsonArray("metrics").size() > 0) {
            JsonObject metrics = cna.getAsJsonArray("metrics").get(0).getAsJsonObject();
            if (metrics.has("cvssV3_1")) {
                JsonObject cvss = metrics.getAsJsonObject("cvssV3_1");
                cvssBaseScore = cvss.has("baseScore") ? cvss.get("baseScore").getAsFloat() : 0.0f;
            }
        }

        String technicalDescription = cna.has("technicalDescription") ? cna.get("technicalDescription").getAsString() : "";
        String exploit = cna.has("exploit") ? cna.get("exploit").getAsString() : "";

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
