import java.io.File;

public class start {
    public static void main(String[] args) throws Exception {
        File localFile = new File("file.csv");
        if(!localFile.exists()){
            save.newFile();
        }
        //save.newFile();
        int[][] saves = calc.runCalc();
        save.saveFile(saves, "file.csv");
    }
}
