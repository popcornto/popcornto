public class PointinTime {
    private int years;
    private int days;
    private int hours;

    public PointinTime(int years, int days, int hours) {
        if (years < 0) {
            throw new IllegalArgumentException();
        }
        if (years > 999 & years < 10000) {
            this.years = years;
        }
        if (days >= 1 & days < 366) {
            this.days = days;
        }
        if (hours >= 0 & hours < 24) {
            this.hours = hours;
        }

    }

    public int getDays() {
        return days;
    }

    public int getHours() {
        return hours;
    }

    public int getYears() {
        return years;
    }
    public String toString(){
        int days = getDays();
        int hours = getHours();
        String zero = "0";
        String empty = "";
        String slash = "/";

        if (days < 100 & hours < 10){
            return  getYears() +slash + zero +zero +days+slash +zero +hours;
        }else if(days < 100){
            empty = zero + zero + days;
            return getYears() + slash +empty +slash +getHours();
        }else if(hours < 10){
            empty = zero +hours;
            return getYears() + slash +days +slash +empty;
        }
        return getYears() + "/" + getDays() + "/" + getHours();
    }
    public PointinTime clone(){
        return new PointinTime(years,days,hours);
    }
    public int change(int hours){
        if (hours> 0)
        if(hours + getHours() <24){
            this.hours = hours +getHours();
        }

    return getHours();}

    public static void main(String[] args) {
        PointinTime p1 = new PointinTime(2021,1,1);
        System.out.println(p1.change(0));
        System.out.println(p1.toString());
    }

}
