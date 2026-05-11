//Function that starts the calculator.
public class start {
    public static void main(String[] args) throws Exception {
        int[][] saves = calc.runCalc();
        save.saveFile(saves, "file.csv"); 
    }
}
