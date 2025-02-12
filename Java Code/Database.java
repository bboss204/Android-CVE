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

    public void initiate_androidCVE_DB(String[] args)throws SQLException {
        Connection launchConnection = DriverManager.getConnection(this.url, this.utilisateur, this.mdp);
        String sql_init = "CREATE TABLE `cve` (\r\n" +
                  "  `id` int(11) NOT NULL AUTO_INCREMENT,\r\n" +
                  "  `cveID` text,\r\n" +
                  "  `state` text,\r\n" +
                  "  `datePublished` date DEFAULT NULL,\r\n" +
                  "  `dateUpdated` date DEFAULT NULL,\r\n" +
                  "  `title` text,\r\n" +
                  "  `vendor` text,\r\n" +
                  "  `product` text,\r\n" +
                  "  `version_product` text,\r\n" +
                  "  `status_product` text,\r\n" +
                  "  `descriptions` text,\r\n" +
                  "  `cvss_baseScore` float DEFAULT NULL,\r\n" +
                  "  `technical-description` text,\r\n" +
                  "  `exploit` text\r\n" +
                  ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        try {
            launchConnection.createStatement().executeUpdate(sql_init);
            System.out.println("Table créée !");
        } catch (SQLException exception) {
            System.out.println("Erreur de création de la base !");
            exception.printStackTrace();
        }
    }

    public void writeDB(String sql) throws SQLException {
        try (Connection launchConnection = DriverManager.getConnection(this.url, this.utilisateur, this.mdp)) {
            launchConnection.createStatement().executeUpdate(sql);
            System.out.println("Requête effectuée !");
        } catch (SQLException exception) {
            System.out.println("Erreur de requête !");
            exception.printStackTrace();
        }
    } 
}
