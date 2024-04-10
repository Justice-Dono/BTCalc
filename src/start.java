
public class start {
    public static void main(String[] args) throws Exception {
        save.newFile();
        int[][] saves = calc.runCalc();
        save.saveFile(saves, "test.csv");
    }
}
