import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class calc {
    public static int[][] runCalc() throws InterruptedException, FileNotFoundException, IOException{
        tribe[] all = calcFile.tribeRead();
        int[][] save = new int[all.length][all.length];
        Scanner localScanner = new Scanner(System.in);
        System.out.println("How many tribes a day are you planning to do?");
        String dayResult = localScanner.nextLine();
        Integer newResult = Integer.parseInt(dayResult);
        if(newResult > 4 || newResult < 1){
            newResult = 4;
        }
        Integer[] daysTracker = new Integer[newResult];
        for(Integer x = 0; x < newResult; x++){
            daysTracker[x] = 0;
        }
        for(int x = 0; x < all.length; x++){
            tribe localTribe = all[x];
            System.out.println("Have you maxed out the " + localTribe.name + " tribe? [y/n]");
            String r1 = localScanner.nextLine();
            Boolean loopbreak = false;
            Integer flag = 0;
            Integer localr = 0;
            Integer localxp = 0;
            while(loopbreak != true){
                if(r1.equalsIgnoreCase("Y")){
                    flag = 0;
                    save[x][0] = 9;
                    loopbreak = true;
                }
                if(r1.equalsIgnoreCase("N")){
                    System.out.println("What is the current rank of the tribe? (Starting rank is " + localTribe.startRank + ")");
                    localr = Integer.parseInt(localScanner.nextLine());
                    System.out.println("How much reputation do you have towards the current rank?");
                    localxp = Integer.parseInt(localScanner.nextLine());
                    if((localr >= localTribe.startRank) && (localr <= localTribe.maxRank)){
                        if((localxp >= 0) && (localxp <= localTribe.rankTable[localr])) {
                            flag = 1;
                            loopbreak = true;
                        }
                    }
                }
                if(loopbreak == false){
                    System.out.println("I didn't quite get that.");
                    Thread.sleep(100);
                    System.out.println("Please make sure you entered in your rank and reputation values correctly.");
                    Thread.sleep(100);
                    System.out.println("Please type out your answer again");
                    Thread.sleep(100);
                    System.out.println("Have you maxed out the " + localTribe.name + " tribe? [y/n]");
                    r1 = localScanner.nextLine();
                }
            }
            if(flag == 1){
                Integer nextDay = localTribe.daysLeft(localr, localxp);
                save[x][0] = localr;
                save[x][1] = localxp;
                Integer index = tribe.getSmallest(daysTracker);
                daysTracker[index] = daysTracker[index] + nextDay;
            }
        }
        localScanner.close();
        Integer sessions = Collections.max(Arrays.asList(daysTracker));
        System.out.println("You will be finished in " + sessions + " days.");
        return save;
    }
}
