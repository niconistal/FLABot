package JavaLog.examples;


import JavaLog.*;
import JavaLog.visitor.*;


public class SimpleTest {
    public static void main(String args[]) {
        PlEngine brain = new PlEngine();

        brain.eCall("append([1,2,3],Y,X).");
        DereferenceVisitor dv = new DereferenceVisitor();

        System.out.println(brain.goal().accept(dv).dereference());
        System.out.println(brain.goal().dereference());
    }
}
