package mans;

public class Period {
    private int minutes;


    public Period(int Minutes, int Stunden) {

        if (Minutes < 0) {
            Minutes = 0;
        }
        if (Stunden < 0) {
            Stunden = 0;
        }
        minutes = Minutes + (Stunden * 60);
    }

    public Period(int Minutes) {
        if (Minutes< 0) {
            Minutes = 0;
        }
        minutes = Minutes;
    }

    public int getMinutes() {
        return minutes;
    }
    public int getHours(){
        int Stunden = minutes/60;
        return Stunden;
    }
    public int getMinorMinutes(){
        int get = (getHours()*60)-minutes;
        return get*-1;
    }

public String toString(){
        int hours = getHours();
        int minutes = getMinorMinutes();
        String zero = "0";
        String smallerthanten = "";
        String space = " ";
        String seperate = ":";
        if (minutes < 10 & hours < 10){
            hours = getHours()%10;
            minutes = getMinorMinutes()%10;
            smallerthanten = zero + hours + seperate + zero  + minutes;
            return smallerthanten;
        }
        if (minutes < 10){
            minutes = getMinorMinutes()%10;
            smallerthanten = hours + zero +seperate+ minutes;
            return smallerthanten;
        }
        if( hours < 10){
            hours = getHours()%10;
            smallerthanten = zero + hours + seperate + getMinorMinutes();
            return smallerthanten;}

        return hours + seperate + getMinorMinutes();
}
public Period clone(){
        return new Period(minutes,getHours());
}
public int change(int Minutes){
        if (Minutes > 0){
        minutes = minutes + Minutes;}
        return minutes;
}


    public static void main(String[] Aref) {
        Period p1 = new Period(60);
        Period p2 = new Period(3,3);
        Period p3 = new Period(90,3);
        System.out.println(p3.toString());
        System.out.println(p2.clone());
        System.out.println(p2.change(6));
        System.out.println(p2.toString());

    }

}
