public class tribe {
    private static final Integer[] rankTable = {0,150,360,510,720,990,1320,1730};
    public static Integer startRank;
    public static Integer maxRank;
    public Integer[] xpTable;

    public tribe(Integer start, Integer max){
        startRank = start;
        maxRank = max;
        xpTable = new Integer[] {0,0,0,60,60,60,60,60};
    }

    public static tribe oldTribe(Integer start, Integer max, Integer r1, Integer r2, Integer r3, Integer r4, Integer r5, Integer r6, Integer r7){
        tribe localTribe = new tribe(start, max);

        localTribe.xpTable = new Integer[] {0, r1, r2, r3, r4, r5, r6, r7};
        return localTribe;
    }

    public int rankCalc(Integer rank){
        Integer total = rankTable[rank];
        float fDaily = xpTable[rank];
        float days = (total/(fDaily*3));
        Double result = Math.ceil(days);
        return result.intValue();
    }
}
