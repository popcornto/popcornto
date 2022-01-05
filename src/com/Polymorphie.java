package com;


    public class Polymorphie {
        public static class All {}
        public static class Most extends All {  }
        public static class Normal extends Most {  }
        public static class Special extends Normal {  }

        public static class Top
        {
            public void m( All p ) { System.out.print("A"); }
            public void m( Special p ) { System.out.print("B"); }
        }
        public static class Upper extends Top
        {
            public void m( Most p ) { System.out.print("M"); }
            public void m( Normal p ) { System.out.print("P"); }
        }
        public static class Middle extends Upper
        {
            public void m( Normal p ) { System.out.print("X"); }
        }
        public static class Bottom extends Middle
        {
            public void m( All p ) { System.out.print("E"); }
        }
        public static class main
        {
            public static void run()
            {
                All all = new Most();
                Most most = new Most();
                Normal normal = new Special();
                Special special = new Special();
                Top tu = new Upper();
                Upper um = new Middle();
                Middle mm = new Middle();
                Middle mb = new Bottom();
                tu.m( most );
                tu.m( special );
                um.m( normal );
                um.m( special );
                mm.m( normal );
                mm.m( special );
                mb.m( all );
                mb.m( normal );
            }
        }
}

