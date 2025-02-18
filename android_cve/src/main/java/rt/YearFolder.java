package rt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class YearFolder {
    String path;
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
        return jscveFiles;
    }
    

    public static void main(String[] args) {
        YearFolder year = new YearFolder("C:\\Users\\bboss\\Documents\\GitHub\\Android-CVE\\2024");
        year.listfiles(new File(year.path));
        for (File file : year.jscveFiles) {
            System.out.println(file);
        }
    }
    
}
