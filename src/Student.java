public class Student
{
    private String name;
    private String subject;
    private int registrationNo;

    public Student( String n, String sub, int no ) {
        name = n;
        subject = sub;
        registrationNo = no;
    }

    public String toString() {
        return "student: " + name +
                ", registration number: " + registrationNo +
                "(" + subject + ")";
    }

    public String getName()
    {
        return name;
    }

    public String getSubject()
    {
        return subject;
    }

    public int getRegistrationNo()
    {
        return registrationNo;
    }

    public boolean hasGreaterNumber( Student s )
    {
        return getRegistrationNo() > s.getRegistrationNo();
    }

    public boolean hasEqualNumber( Student s )
    {
        return getRegistrationNo() == s.getRegistrationNo();
    }

    public boolean hasGreaterName( Student s )
    {
        return getName().compareTo( s.getName() ) > 0;
    }

    public boolean hasEqualName( Student s )
    {
        return getName().compareTo( s.getName() ) == 0;
    }

    public static class Element
    {
        private Object content;
        private Element pred, succ;
    
        public Element( Object c )
        {
            content = c;
            pred = succ = null;
        }
    
        public Object getContent()
        {
            return content;
        }
    
        public void setContent( Object c )
        {
            content = c;
        }
    
        public boolean hasSucc()
        {
            return succ != null;
        }
    
        public Element getSucc()
        {
            return succ;
        }
    
        public void disconnectSucc()
        {
            if ( hasSucc() )
            {
                succ.pred = null;
                succ = null;
            }
        }
    
        public void connectAsSucc( Element e)
        {
            disconnectSucc();
            if ( e != null )
            {
                e.disconnectPred();
                e.pred = this;
            }
            succ = e;
        }
    
        public boolean hasPred()
        {
            return pred != null;
        }
    
        public Element getPred()
        {
            return pred;
        }
    
        public void disconnectPred()
        {
            if ( hasPred() )
            {
                pred.succ = null;
                pred = null;
    
            }
        }
    
        public void connectAsPred( Element e )
        {
            disconnectPred();
            if ( e != null )
            {
                e.disconnectSucc();
                e.succ = this;
            }
            pred = e;
        }
    }

    public static class Student
    {
        private String name;
        private String subject;
        private int registrationNo;
    
        public Student( String n, String sub, int no ) {
            name = n;
            subject = sub;
            registrationNo = no;
        }
    
        public String toString() {
            return "student: " + name +
                    ", registration number: " + registrationNo +
                    "(" + subject + ")";
        }
    
        public String getName()
        {
            return name;
        }
    
        public String getSubject()
        {
            return subject;
        }
    
        public int getRegistrationNo()
        {
            return registrationNo;
        }
    
        public boolean hasGreaterNumber( Student s )
        {
            return getRegistrationNo() > s.getRegistrationNo();
        }
    
        public boolean hasEqualNumber( Student s )
        {
            return getRegistrationNo() == s.getRegistrationNo();
        }
    
        public boolean hasGreaterName( Student s )
        {
            return getName().compareTo( s.getName() ) > 0;
        }
    
        public boolean hasEqualName( Student s )
        {
            return getName().compareTo( s.getName() ) == 0;
        }
    }
}
