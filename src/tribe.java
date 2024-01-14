public class tribe {
    private static final Integer[] rankTable = {0,150,360,510,720,990,1320,1730};
    public static Integer startRank;
    public static Integer maxRank;
    public static Integer r1Xp;
    public static Integer r2Xp;
    public static Integer r3Xp;
    public static Integer r4Xp;
    public static Integer r5Xp;
    public static Integer r6Xp;
    public static Integer r7Xp;
    public Integer[] xpTable;

    public tribe(Integer start, Integer max){
        startRank = start;
        maxRank = max;
        xpTable = new Integer[] {0,0,0,60,60,60,60,60};
    }

    public int rankCalc(Integer rank){
        Integer total = rankTable[rank];
        float fDaily = xpTable[rank];
        float days = (total/(fDaily*3));
        Double result = Math.ceil(days);
        return result.intValue();
    }
}
