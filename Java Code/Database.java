import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    String url;
    String utilisateur;
    String mdp;

    public Database(String urlOfDatabase, String utilisateur, String mdp) throws SQLException{
        this.url = urlOfDatabase;
        this.utilisateur = utilisateur;
        this.mdp = mdp;
        String dbName = this.url.substring(this.url.lastIndexOf("/") + 1);
        String urlNoDBName = this.url.replace(dbName, ""); 
        Connection launchConnection = DriverManager.getConnection(urlNoDBName, this.utilisateur, this.mdp);
        String sql_init_database = "CREATE DATABASE IF NOT EXISTS " + dbName + ";";
        launchConnection.createStatement().executeUpdate(sql_init_database);
    }

    public void testConnect() throws SQLException {
        try (Connection launchConnection = DriverManager.getConnection(this.url, this.utilisateur, this.mdp)) {
            System.out.println("Connexion réussie !");
        } catch (SQLException exception) {
            System.out.println("Erreur de connexion !");
                    exception.printStackTrace();
                }       
    }

    public void initiate_androidCVE_DB()throws SQLException {
        Connection launchConnection = DriverManager.getConnection(this.url, this.utilisateur, this.mdp);
        String sql_init_table = "CREATE TABLE IF NOT EXISTS `cve` (\r\n" +
                  "  `id` int(11) NOT NULL AUTO_INCREMENT,\r\n" +
                  "  `cveID` text,\r\n" +
                  "  `state` text,\r\n" +
                  "  `datePublished` DATETIME  DEFAULT NULL,\r\n" +
                  "  `dateUpdated` DATETIME  DEFAULT NULL,\r\n" +
                  "  `title` text,\r\n" +
                  "  `vendor` text,\r\n" +
                  "  `product` text,\r\n" +
                  "  `version_product` text,\r\n" +
                  "  `status_product` text,\r\n" +
                  "  `descriptions` text,\r\n" +
                  "  `cvss_baseScore` float DEFAULT NULL,\r\n" +
                  "  `technical_description` text,\r\n" +
                  "  `exploit` text,\r\n" +
                  "PRIMARY KEY (`id`)\r\n" + 
                  ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        try {
            launchConnection.createStatement().executeUpdate(sql_init_table);
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
