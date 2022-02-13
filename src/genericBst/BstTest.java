package genericBst;

import java.util.LinkedList;
import java.util.List;

public class BstTest
{
    public static void main( String[] args )
    {
        //test();
        BinarySearchTree<Student> students = new BinarySearchTree<>();
        Student ten = new Student( "A", "Inf", 10 );
        Student neun = new Student( "C", "M", 9 );
        Student six = new Student( "E", "M", 6 );
        Student eight = new Student( "E", "M", 8 );
        students.add( new Student( "A", "Inf", 4 ) );
        students.add(ten);
        students.add( new Student( "E", "M", 3 ) );
        students.add( six);
        students.add( eight );
        students.add(neun);

        List<Student> lsist = new LinkedList<>();

        //students.show();
        //students.show();
        //System.out.println(students.height());
        //System.out.println(students.countNodes(0, 2));
        //System.out.println(students.completeLevels());
        //System.out.println(students.onLevel(st, 1));
        //System.out.println(students.shortest());
        //System.out.println(students.deleteLeavesAbove(3));
        students.allInner(lsist);
        System.out.println(lsist.toArray().toString());
        for (Object elemt:lsist.toArray()
             ) {
            System.out.println(elemt);
        }
        //System.out.println(students.pathCheck(  six , s, false));
        //System.out.println(students.pathsCheck(six,s,true));

    }
}
