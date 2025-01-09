import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    String url;
    String utilisateur;
    String mdp;

    public Database(String url, String utilisateur, String mdp){
        this.url = url;
        this.utilisateur = utilisateur;
        this.mdp = mdp;
    }

    public void testConnect(String[] args) throws SQLException {
        try (Connection launchConnection = DriverManager.getConnection(this.url, this.utilisateur, this.mdp)) {
            System.out.println("Connexion réussie !");
        } catch (SQLException exception) {
            System.out.println("Erreur de connexion !");
            exception.printStackTrace();
        }
    }

    public void enterSQL(String sql) throws SQLException {
        connect(args);
    } 
}
