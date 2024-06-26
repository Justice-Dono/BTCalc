import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class save {
    public static void newFile() throws NumberFormatException, IOException {
        File localFile = new File("file.csv");
        localFile.createNewFile();
        try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tribeLine = {};
                tribeLine = line.split(",");
                if(Integer.valueOf(tribeLine[0]) == 1){
                    BufferedWriter bw = new BufferedWriter(new FileWriter(localFile, true));
                    String str0 = tribeLine[3];
                    String str1 = tribeLine[1];
                    String str2 = "0";
                    String collectedString = str0 + "," + str1 + "," + str2;
                    bw.append(collectedString); 
                    bw.newLine();
                    bw.close();
                }
                if(Integer.valueOf(tribeLine[0]) == 0){
                    BufferedWriter bw = new BufferedWriter(new FileWriter(localFile, true));
                    String str0 = tribeLine[10];
                    String str1 = tribeLine[1];
                    String str2 = "0";
                    String collectedString = str0 + "," + str1 + "," + str2;
                    bw.append(collectedString); 
                    bw.newLine();
                    bw.close();
                }
            }
        }
    }

    public static void saveFile(int[][] saves, String path) throws IOException {
        //File localFile = new File("test.csv");
        try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                Boolean check = true;
                    if(count == 0){
                check = false;
                }
                String[] tribeLine = {};
                tribeLine = line.split(",");
                if(Integer.valueOf(tribeLine[0]) == 1){
                    BufferedWriter bw = new BufferedWriter(new FileWriter(path, check));
                    String str0 = tribeLine[3];
                    String str1 = Integer.toString(saves[count][0]);
                    String str2 = Integer.toString(saves[count][1]);
                    String collectedString = str0 + "," + str1 + "," + str2;
                    bw.append(collectedString); 
                    bw.newLine();
                    bw.close();
                }
                if(Integer.valueOf(tribeLine[0]) == 0){
                    BufferedWriter bw = new BufferedWriter(new FileWriter(path, check));
                    String str0 = tribeLine[10];
                    String str1 = Integer.toString(saves[count][0]);
                    String str2 = Integer.toString(saves[count][1]);
                    String collectedString = str0 + "," + str1 + "," + str2;
                    bw.append(collectedString); 
                    bw.newLine();
                    bw.close();
                }
                count++;
            }
        }
    }
}
