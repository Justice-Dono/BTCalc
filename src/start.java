import java.util.Scanner;

public class start {
    public static void main(String[] args) throws Exception {
        tribe Amaljaa = tribe.oldTribe(1,3,10,14,20,0,0,0,0,"Amaljaa");
        tribe Kobold = tribe.oldTribe(1,3,10,14,20,0,0,0,0,"Kobold");
        tribe Sahagin = tribe.oldTribe(1,3,10,14,20,0,0,0,0,"Sahagin");
        tribe Sylph = tribe.oldTribe(1,3,10,14,20,0,0,0,0,"Sylph");
        tribe Ixali = tribe.oldTribe(1,6,20,24,29,35,42,50,0,"Ixali");
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
        tribe[] all = {Amaljaa, Kobold, Sahagin, Sylph, Ixali, VanuVanu, Moogle, Vath, Namazu, Anata, Kojin, Pixie, Qitari, Dwarf, Arkasodara, Omicron,Loporrit};
        Integer days = 0;
        System.out.println(all.length);
        Scanner localScanner = new Scanner(System.in);
        for(int x = 0; x < all.length; x++){
            tribe localTribe = all[x];
            System.out.println("Have you maxed out the " + localTribe.name + " tribe? [y/n]");
            String r1 = localScanner.nextLine();
            Boolean loopbreak = false;
            Integer flag = 0;
            while(loopbreak != true){
                if(r1.equalsIgnoreCase("Y")){
                    days = days + 0;
                    flag = 0;
                    loopbreak = true;
                }
                if(r1.equalsIgnoreCase("N")){
                    flag = 1;
                    loopbreak = true;
                }
                if(loopbreak == false){
                    System.out.println("I didn't quite get that.");
                    Thread.sleep(1000);
                    System.out.println("Please type out your answer again");
                    Thread.sleep(1000);
                    System.out.println("Have you maxed out the " + localTribe.name + " tribe? [y/n]");
                    r1 = localScanner.nextLine();
                }
            }
            if(flag ==1){
                System.out.println("What is the current rank of the tribe? (Starting rank is " + localTribe.startRank + ")");
                Integer localr = Integer.parseInt(localScanner.nextLine());
                System.out.println("How much reputation do you have towards the current rank?");
                Integer localxp = Integer.parseInt(localScanner.nextLine());
                Integer nextDay = localTribe.daysLeft(localr, localxp);
                days = days + nextDay;
            }
        }
        localScanner.close();
        Double sessions = Math.ceil(days/4);
        System.out.println("You will be finished in " + sessions + " days.");
    }
}
