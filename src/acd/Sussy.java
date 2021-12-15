package acd;

public class Sussy {
    int roomnumber;
    Sussy nextroom;
    Sussy prevroom;
    Sussy roomn;


    public Sussy(int roomn) {
        roomn= 0b0;
    }

    public static void main(String[] args) {

        Sussy roomA = new Sussy (1);
        Sussy roomB = new Sussy( 2);
        Sussy roomC = new Sussy(3);
        Sussy roomD = new Sussy(4);
        Sussy roomE = new Sussy(5);
        Sussy roomF = new Sussy(6);



        roomA.nextroom = roomB;
        roomA.prevroom = roomF;
        roomB.nextroom = roomC;
        roomB.prevroom = roomA;
        roomC.nextroom = roomD;
        roomC.prevroom = roomB;
        roomD.nextroom = roomE;
        roomD.prevroom = roomC;
        roomE.nextroom = roomF;
        roomE.prevroom = roomD;
        roomF.nextroom = roomA;
        roomF.prevroom = roomE;
        System.out.println(isSus(roomA));
    }
    static String isSus(Sussy roomn){
        String sus = "WHen the Imposter is sus";
        String notsus = "THis impostor is not sus";
        int countminutes =0;
        int Impostermoves;


        return sus;
    }
}
