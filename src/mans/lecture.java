package mans;

public class lecture {
    private String title;
    private Students[] students;
    private int firstUnsed;

    public lecture(String t, int cap )
    {
        title = t;
        students = new Students[cap];
        firstUnsed = 0;
    }
    public boolean add( Students s )
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
        System.out.println("mans.lecture: " + title);
        System.out.println("participents: ");
        for (Students s: students){
            if(s != null){
                System.out.println(s.toString());
            }
        }
    }
}
