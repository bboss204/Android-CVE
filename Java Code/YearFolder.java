import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class YearFolder {
    String path;
    File year;
    File inFile;
    File[] folldinYear;
    List<File> jscveFiles = new ArrayList<>();


    public YearFolder(String yearpath) {
        this.path = yearpath;
    }

    public List<File> listfiles(File input) {     
        File[] input2 = input.listFiles();
        for(File inFile : input2) {
            if (inFile.isDirectory()) {
                listfiles(inFile);
            }
            else {
                jscveFiles.add(inFile);
            }
        }
        for (File f : jscveFiles) {
            System.out.println(f);
        }
        return jscveFiles;
    }
    

    public static void main(String[] args) {
        YearFolder year = new YearFolder("C:\\Users\\bboss\\Documents\\GitHub\\Android-CVE\\2024");
        year.listfiles(new File(year.path));
    }
    
}
