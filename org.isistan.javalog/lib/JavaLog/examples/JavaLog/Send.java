//-*-jde-*-
package JavaLog.examples;


import JavaLog.*;


public class Send {
    public static void main(String args[]) {
        PlEngine plEngine = new PlEngine();

        plEngine.eCall("assert(aString($0)).", new String[] {"java string"}
        );
        System.out.println(plEngine.eCall("listing(aString)."));
        System.out.println(plEngine.eCall("append([1,2,3],[4],X)."));
    }
}
