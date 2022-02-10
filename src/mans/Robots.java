package mans;

public class Robots {

    String name;
    String color;
    int weight;
    String kilo = " Kilogramms";
    Robots lookingat;

    public Robots(String name, String color , int weight){
        this.name=name;
        this.color=color;
        this.weight=weight;
    }

    void  introduceSelf(){
        System.out.println("My name is " + this.name);
    }
    void Mycoloris(){
        System.out.println("My color is " + this.color);
    }
    void Iweigh(){
        System.out.println("I weigh " + this.weight + kilo);
    }

    public static void main(String[] args) {
        Robots r1 =new Robots("bob", "black", 69);
        Robots r2 = new Robots("tom" , "red" , 42);

        r1.introduceSelf();
        r2.introduceSelf();
        r1.Iweigh();
        r1.lookingat=r2;
        r1.lookingat.Mycoloris();
    }
}
