public class lecture {
    private String title;
    private Student[] students;
    private int firstUnsed;

    public lecture(String t, int cap )
    {
        title = t;
        students = new Student[cap];
        firstUnsed = 0;
    }
    public boolean add( Student s )
    {
        for ( int i = 0; i < students.length; i++ )
        {
            if ( students.length > firstUnsed )
            {
                students[firstUnsed] = s;
                firstUnsed++;
                return true;
            }
        }
        return false;
    }
    public void show(){
        System.out.println("lecture: " + title);
        System.out.println("participents: ");
        for (Student s: students){
            if(s != null){
                System.out.println(s.toString());
            }
        }
    }
}
