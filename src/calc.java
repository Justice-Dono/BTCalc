//import java.math.*;

public class calc {
    private static final Integer[] rankTable = {0,150,360,510,720,990,1320,1730};

    public static float rankCalc(Integer rank, Integer daily){
        float total = rankTable[rank];
        float fDaily = daily;
         float days = (total/(fDaily*3));
        //int result = days//.intValue();
        return days;
    }

    public static int rankLeft(int current, int max){
        int result = max - current;
        return result;
    }
}
