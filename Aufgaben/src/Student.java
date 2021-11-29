public class Student {
    public String name;
    private String subject;
    private int registrationNo;


    public Student(String n, String sub, int no){
        name = n;
        subject = sub;
        registrationNo = no;
    }

    public String toString(){
        return "student: " + name + ", regestration number: " + registrationNo + "(" + subject + ")";
    }
    public boolean hasGreaterName(Student s){
        return getName().compareTo(s.getName())>0;
    }

    public boolean hasEqualName(Student s){
        return getName().compareTo(s.getName())==0;
    }
    public static void main(String[] args) {
        lecture dap1 = new lecture("Dap 1" , 5);

        dap1.add(new Student("C", "M", 17));
        Student s = new Student("E", "M", 11);
        dap1.add(s);
        Student t = new Student("E", "M", 11);dap1.add(t);
        dap1.add(t);
        Student s1 = new Student("C" , "M" , 17);
        Student s2 = new Student("A", "inf", 22);
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
    public boolean hasGreaterNumber(Student s){
        return getRegistrationNo() > s.getRegistrationNo();
    }
    public boolean hasEqualnumber(Student s){
        return getRegistrationNo()==s.getRegistrationNo();
    }

}

