import java.io.File;
//les condition pour que ce code marche sont que vous avez une base de donnée mysql et que vous avez un utilisateur root avec le mot de passe test1234
public class Main {

    public static void main(String[] args) {
        Database db = new Database("jdbc:mysql://localhost:3306/", "root", "test1234");
        
        File annee = new File("C:\\Users\\bboss\\Documents\\GitHub\\Android-CVE\\2024");
        File[] listAnnee = annee.listFiles();
        for (File f : listAnnee){
            
        }
    }
}
