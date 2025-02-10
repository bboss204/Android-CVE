//ce code doit pouvoir lire les fichier json un a un et les afficher
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonFile {
    String chemin;
    
    public jsonFile(String chemin) {
        this.chemin = chemin;
    }

    public void read()throws IOException {
        try {
            FileReader file = new FileReader(this.chemin);
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(file);
            return json;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
         
    }

    
    
}
