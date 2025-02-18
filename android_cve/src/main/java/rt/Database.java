package rt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    String url;
    String utilisateur;
    String mdp;

    public Database(String urlOfDatabase, String utilisateur, String mdp) throws SQLException {
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

    public void initiate_androidCVE_DB() throws SQLException {
        Connection launchConnection = DriverManager.getConnection(this.url, this.utilisateur, this.mdp);
        String sql_init_table = "CREATE TABLE IF NOT EXISTS `cve` (" +
                "  `id` INT NOT NULL AUTO_INCREMENT," +
                "  `cveID` TEXT," +
                "  `state` TEXT," +
                "  `datePublished` DATETIME DEFAULT NULL," +
                "  `dateUpdated` DATETIME DEFAULT NULL," +
                "  `title` TEXT," +
                "  `vendor` TEXT," +
                "  `product` TEXT," +
                "  `version_product` TEXT," +
                "  `status_product` TEXT," +
                "  `descriptions` TEXT," +
                "  `cvss_baseScore` FLOAT DEFAULT NULL," +
                "  `technical_description` TEXT," +
                "  `exploit` TEXT," +
                "  PRIMARY KEY (`id`)" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci";
        
        try {
            launchConnection.createStatement().executeUpdate(sql_init_table);
            System.out.println("Table créée !");
        } catch (SQLException exception) {
            System.out.println("Erreur de création de la base !");
            exception.printStackTrace();
        } finally {
            if (launchConnection != null) {
                launchConnection.close();
            }
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