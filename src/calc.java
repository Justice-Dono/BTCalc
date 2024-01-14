//import java.math.*;

public class calc {
    public static final Integer R1 = 150;
    public static final Integer R2 = 360;
    public static final Integer R3 = 510;
    public static final Integer R4 = 720;
    public static final Integer R5 = 990;
    public static final Integer R6 = 1320;
    public static final Integer R7 = 1730;

    public static int rankCalc(Integer Rank, Integer XP){
        Double days = Math.ceil(Rank/(XP*3));
        int result = days.intValue();
        return result;
    }
}
