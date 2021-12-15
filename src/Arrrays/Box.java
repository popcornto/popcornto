package Arrrays;

public class Box {

    private int Breite, Höhe, Tiefe;

    public Box(int breite, int höhe, int tiefe) {
        Breite = breite;
        Höhe = höhe;
        Tiefe = tiefe;
    }

    public static void main(String[] args) {
        Box b1 = new Box(10, 30, 20);
        Box b2 = new Box(11, 31, 21);
        System.out.println(b2.enclosess().getVolumeSize());
        System.out.println(b1.getVolumeSize());
        System.out.println(b2.encloses(b1));

    }

    public int getBreite() {
        return Breite;
    }

    public int getHöhe() {
        return Höhe;
    }

    public int getTiefe() {
        return Tiefe;
    }

    public  int getVolumeSize() {

        return Breite * Höhe * Tiefe;
    }
    public Box enclosess(){
        return new Box(Tiefe+1, Breite+1, Höhe+1);
    }
    public int getAreaSize() {
        return 2 * (Tiefe * Höhe) + 2 * (Breite * Tiefe) + 2 * (Breite * Höhe);
    }

    public int getEdgesLength() {
        return 4 * Breite + 4 * Tiefe + 4 * Höhe;
    }

    /*public boolean isCube(){
        boolean iscube = false;
        if (Breite == Tiefe & Tiefe==Höhe){
            iscube = true;
        }
        return iscube;
    }*/
    public boolean isCube() {

        return Breite == Tiefe & Tiefe == Höhe;
    }

    public int compareto(Box f) {
        int compare;
        if ( getVolumeSize() > f.getVolumeSize()) {
            compare =  1;}else if (getVolumeSize() < f.getVolumeSize()){
            compare = -1;
        }else compare = 0;


        return compare;
    }
    public boolean encloses(Box f){
        boolean encloses;
        if (getVolumeSize() < f.enclosess().getVolumeSize()){
            encloses = false;
        }else encloses = true;
    return encloses;
    }
}
