public class LectureWithSortAlgorithms {
    private String title;
    private Students[] students;
    private int firstUnused;

    public LectureWithSortAlgorithms( String t, int cap )
    {
        title = t;
        students = new Students[cap];
        firstUnused = 0;
    }

    public void add( Students s )
    {
        if ( firstUnused < students.length )
        {
            students[firstUnused] = s;
            firstUnused++;
        }
}
}
