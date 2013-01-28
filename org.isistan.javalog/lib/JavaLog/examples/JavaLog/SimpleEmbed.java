//-*-jde-*-
package JavaLog.examples;


import JavaLog.*;


public class SimpleEmbed {
    Brain brain;

    public SimpleEmbed() {
        brain = new Brain();
        initKnowledge();
    }
    
    public void extra() {
        brain().activeCapability("SimpleEmbed.extra()", 0);
    }

    final Brain brain() {
        return brain;
    }

    public void test() {
        Integer i = new Integer(1);

        extra();
        System.out.println("edge(X,Y) " + brain().answerQuery("edge(X,Y).")  
            + " X=" + brain.answer().get("X")
            + " Y=" + brain.answer().get("Y"));
        brain().activeCapability("SimpleEmbed.test()", 0, new Object[] {i}
        );
        System.out.println(brain.answer());
        //	System.out.println( brain.answer() );
        //brain().parser().eClause("padre(A,B)." );
    }

    public static void main(String args[]) {
        SimpleEmbed s = new SimpleEmbed();

        s.test();
    }

    public void initKnowledge() {
        brain().addCapability("SimpleEmbed.extra()",
            " edge(4,6). ");
        brain().addCapability("SimpleEmbed.test()",
            " edge($0,2). "
            + "edge(2,3). "
            + "edge(3,4). "
            + "edge(6,7)."
            + "connected(X,Y):-edge(X,Y). "
            + "connected(X,Y):-edge(X,Z),edge(Z,Y)."
            + "?-edge(1,Y). "
            + "?-connected(A,B)."
            + "?-connected(4,7).", 1);
    }

}
