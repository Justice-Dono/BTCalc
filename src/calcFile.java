import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class calcFile {
    public static tribe[] tribeRead() throws FileNotFoundException, IOException{
        long count = countLines("data.csv");
        int intCount = (int) count;
        Integer index = 0;
        tribe[] tribeArray =  new tribe[intCount];
        try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tribeLine = {};
                tribeLine = line.split(",");
                if(Integer.valueOf(tribeLine[0]) == 1){
                    tribe localTribe = new tribe(Integer.valueOf(tribeLine[1]),Integer.valueOf(tribeLine[2]),tribeLine[3]);
                    tribeArray[index] = localTribe;
                    index = index + 1;
                }
                if(Integer.valueOf(tribeLine[0]) == 0){
                    tribe localTribe = tribe.oldTribe(Integer.valueOf(tribeLine[1]), Integer.valueOf(tribeLine[2]), Integer.valueOf(tribeLine[3]), Integer.valueOf(tribeLine[4]), Integer.valueOf(tribeLine[5]), Integer.valueOf(tribeLine[6]), Integer.valueOf(tribeLine[7]), Integer.valueOf(tribeLine[8]), Integer.valueOf(tribeLine[9]), tribeLine[10]);
                    tribeArray[index] = localTribe;
                    index = index + 1;
                }
            }
        }
        return tribeArray;
    }

    public static long countLines(String fileName) {

        Path path = Paths.get(fileName);
        long lines = 0;
        try {
            lines = Files.lines(path).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;

    }
}
