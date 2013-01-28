//-*-jde-*-
package JavaLog.examples;


import JavaLog.*;


public class Test {
    private Brain brain = null;

    public void nada() {
        Person p1 = null, p2 = null, p3 = null, p4 = null;

        //BRAIN=brain
        brain.activeCapability("Test.nada()", 0, new Object[] {p3, p2, p4, p1}
        );
    }
  
    public Test() {
        brain = new Brain();
        brain.trace(false);
    }

    public void run()
        throws PlException {
        Person.prolog = brain;
        boolean prologResult = false;

        Person p1 = new Person("Bertrand", 70, true);
        Person p2 = new Person("Elen", 65, false);
        Person p3 = new Person("Linus", 28, true);
        Person p4 = new Person("Alan", 35, true);

        brain.activeCapability("Test.run()", 0, new Object[] {p1}
        );
        brain.answerQuery("listing($0,[madre,padre]).", new Object[] {p2}
        );

        brain.answerQuery("consult('../test.pl').");
        //     System.out.println( "?- hermano('Linus',Y)" );
        //     brain.answerQuery("hermano('Linus',Y)." ) 
        //     System.out.println( prolog.goal().state() );
        //     System.out.println( "brain.answerQuery(" padre(aPerson(Linus..." ) ),Y)" );
        //     brain.answerQuery("padre($0,Y).", new Object[] {p3} ) 
        //     System.out.println( prolog.goal().state() );
        //     System.out.println( "?- padre('Alan',Y)" );
        //     brain.answerQuery("padre('Alan',Y)." ) 
        //     System.out.println( prolog.goal().state() );
        //     System.out.println( "brain.answerQuery(" madre(aPerson(Linus..." ) ),Y)" );
        //     brain.answerQuery("madre($0,Y).", new Object[] {p3} ) 
        //     System.out.println( prolog.goal().state() );
        //     System.out.println( "?- madre('Alan',Y)" );
        //     brain.answerQuery("madre('Alan',Y)." ) 
        //     System.out.println( prolog.goal().state() );
        //    while( prolog.redo() ) {
        //      System.out.println( prolog.goal().state() );
        //    }
    }

    final public static void main(String args[]) 
        throws Exception {
        Test aTest = new Test();

        aTest.run();
    }

    public java.lang.Object[] aMethod1() {
        return null;
    }

    public void initKnowledge() {
        brain.addCapability("Test.nada()",
            "  madre($0,$1)."
            + "madre($2,$1)."
            + "padre($0,$3)."
            + "padre($2,$3).", 4);
        brain.addCapability("Test.run()",
            " padre($0, pedro)."
            + "padre(martin, pedro)."
            + "madre(martin, estela)."
            + "madre(lucy, estela).", 1);
    }

}
