import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class calc {
    public static void runCalc() throws InterruptedException, FileNotFoundException, IOException{
        tribe[] all = calcFile.tribeRead();
        Scanner localScanner = new Scanner(System.in);
        Integer[] daysTracker = {0,0,0,0};
        for(int x = 0; x < all.length; x++){
            tribe localTribe = all[x];
            System.out.println("Have you maxed out the " + localTribe.name + " tribe? [y/n]");
            String r1 = localScanner.nextLine();
            Boolean loopbreak = false;
            Integer flag = 0;
            Integer localr = 0;
            Integer localxp = 0;
            //The Boolean won't stop appearing as a warning and it is driving me crazy.
            Boolean inputMiss = false;
            while(loopbreak != true){
                if(r1.equalsIgnoreCase("Y")){
                    flag = 0;
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
                    inputMiss = false;
                }
                if(loopbreak == false){
                    System.out.println("I didn't quite get that.");
                    Thread.sleep(1000);
                    if(inputMiss = true){
                        System.out.println("Please make sure you entered in your rank and reputation values correctly.");
                        Thread.sleep(1000);
                        inputMiss = false;
                    }
                    System.out.println("Please type out your answer again");
                    Thread.sleep(1000);
                    System.out.println("Have you maxed out the " + localTribe.name + " tribe? [y/n]");
                    r1 = localScanner.nextLine();
                }
            }
            if(flag ==1){
                Integer nextDay = localTribe.daysLeft(localr, localxp);
                Integer index = tribe.getSmallest(daysTracker);
                daysTracker[index] = daysTracker[index] + nextDay;
            }
        }
        localScanner.close();
        Integer sessions = Collections.max(Arrays.asList(daysTracker));
        System.out.println("You will be finished in " + sessions + " days.");
    }
}
