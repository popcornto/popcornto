public class Person {

    boolean sitting;
    String personality;
    String name;
    boolean b;
    Robots  robotowned;
    Robots arefriends;

    Person(boolean  b, String  p, String  n){
        this.name = n;
        this.personality=p;
        this.sitting=b;
    }
    void sitdown(){this.b = true;
        System.out.println(this.b);}
    void standup(){this.b = false;
        System.out.println(this.b);}


    public static void main(String[] args) {
        Robots r1 =new Robots("bob", "black", 69);
        Robots r2 = new Robots("tom" , "red" , 42);
        Person p1 = new Person(false , "nice" , "Alena" );
        p1.standup();
        p1.robotowned=r1;
        p1.robotowned.introduceSelf();


    }

}
