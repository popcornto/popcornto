public class Date {
    private int bezeichnung;
    private PointinTime startzeitpunkt;
    private Period dauer;

    public Date(int bezeichnung,PointinTime startzeitpunkt,Period dauer ){
        this.bezeichnung = bezeichnung;
        this.startzeitpunkt = startzeitpunkt;
        this.dauer = dauer;
    }

    public int getBezeichnung() {
        return bezeichnung;
    }

    public PointinTime getStartzeitpunkt() {
        return startzeitpunkt;
    }

    public Period getDauer() {
        return dauer;
    }

    public Date clone(){
        return new Date(bezeichnung, startzeitpunkt,dauer);
    }


}
