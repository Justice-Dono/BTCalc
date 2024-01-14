public class start {
    public static void main(String[] args) throws Exception {
        tribe Amaljaa = tribe.oldTribe(1,3,10,14,20,0,0,0,0);
        tribe Kobold = tribe.oldTribe(1,3,10,14,20,0,0,0,0);
        tribe Sahagin = tribe.oldTribe(1,3,10,14,20,0,0,0,0);
        tribe Sylph = tribe.oldTribe(1,3,10,14,20,0,0,0,0);
        tribe Ixali = tribe.oldTribe(1,6,20,24,29,35,42,50,0);
        tribe VanuVanu = tribe.oldTribe(1,7,50,50,50,50,50,50,50);
        tribe Moogle = tribe.oldTribe(1,7,50,50,50,50,50,50,50);
        tribe Vath = tribe.oldTribe(3,7,0,0,70,70,70,70,70);
        tribe Namazu = new tribe(3, 7);
        tribe Anata = new tribe(3, 7);
        tribe Kojin = new tribe(3, 7);
        tribe Pixie = new tribe(3, 7);
        tribe Qitari = new tribe(3, 7);
        tribe Dwarf = new tribe(3, 7);
        tribe Arkasodara = new tribe(3, 7);
        tribe Omicron = new tribe(3, 7);
        tribe Loporrit = new tribe(3, 7);
        System.out.println(Omicron.rankCalc(3));
        System.out.println(Vath.rankCalc(5));
    }
}
