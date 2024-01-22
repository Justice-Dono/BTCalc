import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class calc {
    public static void runCalc() throws InterruptedException{
        tribe Amaljaa = tribe.oldTribe(1,3,10,14,20,0,0,0,0,"Amaljaa");
        tribe Sylph = tribe.oldTribe(1,3,10,14,20,0,0,0,0,"Sylph");
        tribe Kobold = tribe.oldTribe(1,3,10,14,20,0,0,0,0,"Kobold");
        tribe Sahagin = tribe.oldTribe(1,3,10,14,20,0,0,0,0,"Sahagin");
        tribe Ixali = tribe.oldTribe(1,6,36,39,42,46,51,56,0,"Ixali");
        tribe VanuVanu = tribe.oldTribe(1,7,50,50,50,50,50,50,50,"VanuVanu");
        tribe Moogle = tribe.oldTribe(1,7,50,50,50,50,50,50,50,"Moogle");
        tribe Vath = tribe.oldTribe(3,7,0,0,70,70,70,70,70,"Vath");
        tribe Namazu = new tribe(3, 7,"Namazu");
        tribe Anata = new tribe(3, 7,"Anata");
        tribe Kojin = new tribe(3, 7,"Kojin");
        tribe Pixie = new tribe(3, 7,"Pixie");
        tribe Qitari = new tribe(3, 7,"Qitari");
        tribe Dwarf = new tribe(3, 7,"Dwarf");
        tribe Arkasodara = new tribe(3, 7,"Arkasodara");
        tribe Omicron = new tribe(3, 7, "Omicron");
        tribe Loporrit = new tribe(3, 7, "Loporrit");
        tribe[] all = {Amaljaa, Sylph, Kobold, Sahagin, Ixali, VanuVanu, Moogle, Vath, Namazu, Anata, Kojin, Pixie, Qitari, Dwarf, Arkasodara, Omicron,Loporrit};
        System.out.println(all.length);
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
