package JavaLog.persistent;

import java.util.*;
import JavaLog.*;

public class PersistentLogicModuleIterator extends GenericLogicModuleIterator {

    /**
     *Constructor for the PersistentLogicModuleIterator object
     *
     * @param  lm       The database being iterated
     * @param  enum     Enumeration of clauses 
     * @param  functor  Functor of the clause being searched
     * @param  arity    Arity of the clause being searched
     */
    public PersistentLogicModuleIterator(PrologDatabase lm, Enumeration enum,
        String functor, int arity) {
        super();
        super.lm = lm;
        super.clauses = enum;
        super.modules = null;
        super.functor = functor;
        super.arity = arity;
        super.plStruct = null;
    }

    /**
     *Constructor for the PersistentLogicModuleIterator object
     *
     * @param  lm    The database being iterated
     * @param  enum  Enumeration of clauses 
     * @param  plo   Head of the clause being searched
     */
    public PersistentLogicModuleIterator(PrologDatabase lm, Enumeration enum,
        PlObject plo) {
        super();
        super.lm = lm;
        super.clauses = enum;
        super.modules = null;
        super.plStruct = (PlStruct) plo;
        super.functor = ((PlStruct) plo).functor();
        super.arity = ((PlStruct) plo).arity();
    }
       
    protected PrologDatabase nextModule() {
        PrologDatabase module = null;
        while (modules.hasMoreElements()) {
            module = ((PlLogicModule) modules.nextElement());
            if (plStruct == null)
                clauses = ((PersistentLogicModuleIterator) module.find(functor, arity)).clauses();
            else   
                clauses = ((PersistentLogicModuleIterator) module.find(plStruct)).clauses();
             
            if (clauses != null && clauses.hasMoreElements()) {
                return module;
            }
        }
        return module;
    }

    public Object get() {
        if (clauses == null) {
            return null;
        }
        return ((ResultSetIterator) clauses).get();
    }

}