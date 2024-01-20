public class tribe {
    private final Integer[] rankTable = {0,150,360,510,720,990,1320,1730};
    public String name;
    public Integer startRank;
    public Integer maxRank;
    public Integer[] xpTable;

    public tribe(Integer start, Integer max, String inputName){
        name = inputName;
        startRank = start;
        maxRank = max;
        xpTable = new Integer[] {0,0,0,60,60,60,60,60};
    }

    public static tribe oldTribe(Integer newStart, Integer newMax, Integer r1, Integer r2, Integer r3, Integer r4, Integer r5, Integer r6, Integer r7, String newName){
        tribe localTribe = new tribe(newStart, newMax, newName);

        localTribe.xpTable = new Integer[] {0, r1, r2, r3, r4, r5, r6, r7};
        localTribe.startRank = newStart;
        localTribe.maxRank = newMax;
        return localTribe;
    }

    public int rankCalc(Integer rank, Integer xp){
        Integer total = rankTable[rank];
        float fDaily = xpTable[rank];
        fDaily = fDaily - xp;
        float days = (total/(fDaily*3));
        Double result = Math.ceil(days);
        return result.intValue();
    }

    public static int rankLeft(int current, int max){
        int result = max - current;
        return result;
    }

    public int daysLeft(Integer cRank, Integer xpLeft){
        int days = 0;
        if (cRank > maxRank){
            //System.out.println("Amoigus!");
            return 0;
        }
        else{
            for(int x = maxRank; x > cRank-1; x--){

                days = days + this.rankCalc(x, xpLeft);

            }
        return days;
        }
    }
}
