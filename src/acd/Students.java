package acd;

import mans.lecture;

public class Students {
    public String name;
    private String subject;
    private int registrationNo;


    public Students(String n, String sub, int no){
        name = n;
        subject = sub;
        registrationNo = no;
    }

    public String toString(){
        return "student: " + name + ", regestration number: " + registrationNo + "(" + subject + ")";
    }
    public boolean hasGreaterName(Students s){
        return getName().compareTo(s.getName())>0;
    }

    public boolean hasEqualName(Students s){
        return getName().compareTo(s.getName())==0;
    }
    public static void main(String[] args) {
        lecture dap1 = new lecture("Dap 1" , 5);

        dap1.add(new Students("C", "M", 17));
        Students s = new Students("E", "M", 11);
        dap1.add(s);
        Students t = new Students("E", "M", 11);dap1.add(t);
        dap1.add(t);
        Students s1 = new Students("C" , "M" , 17);
        Students s2 = new Students("A", "inf", 22);
        if (s1.hasGreaterNumber(s2)){
            System.out.println(s2);
        }


    }
    public String getName(){
        return name;
    }
    public String getSubject()
    {
        return subject;
    }
    public int getRegistrationNo(){
        return registrationNo;
    }
    public boolean hasGreaterNumber(Students s){
        return getRegistrationNo() > s.getRegistrationNo();
    }
    public boolean hasEqualnumber(Students s){
        return getRegistrationNo()==s.getRegistrationNo();
    }

}

