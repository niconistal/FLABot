//-*-jde-*-
package JavaLog.examples;


import JavaLog.*; 
import java.util.*; 


public class Send2 { 
    public static void main(String args[]) { 
        boolean result; 
        Brain brain = new Brain(); 
        Vector  v = new Vector(); 
        //        LogicKnowledge  = new LogicKnowledge(brain,""); 
        String a = "A";

        v.addElement(a);
        v.addElement("B");
	
        if (brain.answerQuery("send($0,elementAt,[1],X).", new Object[] {v}
            )) {
            System.out.println("elementsAt OK!");
            System.out.println(brain.answer());
        } else
            System.out.println("elementsAt FAILED");	

        if (brain.answerQuery("send($0,removeElement,[$1]).", new Object[] {v, a}
            ))
            System.out.println("removeElement OK!");
        else
            System.out.println("removeElement FAILED");	

        System.out.println(v);

        if (brain.answerQuery("send($0,removeAllElements,[],X).", new Object[] {v}
            ))
            System.out.println("removeAllElements OK!");
    }

    public void initKnowledge() {}
 
}
