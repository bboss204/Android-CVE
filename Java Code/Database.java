import java.sql.Connection;

public class Database {
    String url;
    String utilisateur;
    String mdp;

    public Database(String url, String utilisateur, String mdp){
        this.url = url;
        this.utilisateur = utilisateur;
        this.mdp = mdp;
    }

    public static void connect(String[] args) {
        Connection launchConnection = null;

        
    }
}
