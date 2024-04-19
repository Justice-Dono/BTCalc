import java.io.File;

public class start {
    public static void main(String[] args) throws Exception {
        boolean load = false;
        File localFile = new File("file.csv");
        if(localFile.exists()){
            int[][] loads = save.loadFile(localFile.getPath());
            calc.loadCalc(loads);
            load = true;

        }
        if(!localFile.exists()){
            save.newFile("file.csv");
        }
        if(load == false){
            int[][] saves = calc.runCalc();
            save.saveFile(saves, "file.csv");
        }
    }
}
