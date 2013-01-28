/**
 * 
 */
package org.isistan.flabot.util.javalog;

import java.util.LinkedList;
import java.util.List;

import JavaLog.PlClause;
import JavaLog.PlException;
import JavaLog.PlFVar;
import JavaLog.PlJavaObj;
import JavaLog.PlList;
import JavaLog.PlObject;
import JavaLog.PlOpTable;
import JavaLog.PlParser;
import JavaLog.PlStruct;
import JavaLog.PlStructArgs;
import JavaLog.PlUVar;

/**
 * Default implementation of JavalogUtil
 * @author mblech
 *
 */
public class DefaultJavalogUtil implements JavalogUtil {
	
	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.javalogutil.JavalogUtil#fixArg(JavaLog.PlObject)
	 */
	public PlObject fixArg(PlObject plo) {
	      return (plo instanceof PlUVar) ? ((PlUVar) plo).contents() : plo;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.javalogutil.JavalogUtil#mkClause(JavaLog.PlObject)
	 */
	public PlClause mkClause(PlObject plo) {
	      plo = fixArg(plo);
	      if (plo instanceof PlFVar || plo == null)
	          return null;
	      if (plo instanceof PlClause)
	          return (PlClause) ((PlClause) plo).freeze();
	      PlUVar[] variables = null;

	      if (plo instanceof PlStructArgs) {
	          plo = ((PlStructArgs) plo).freeze();
	          variables = ((PlStructArgs) plo).variables();
	      }
	      PlClause plc = new PlClause(1, null);

	      plc.setHead((PlStruct) plo);
	      plc.setVars(variables);
	      return plc;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.javalogutil.JavalogUtil#splitClauses(java.lang.String)
	 */
	public List<String> splitClauses(String prologCode) {
		List<String> clauses = new LinkedList<String>();
		int begin = 0;
		int end = 0;
		int length = prologCode.length();
		boolean simpleQuote = false;
		boolean doubleQuote = false;
		while (end < length) {
			char c = prologCode.charAt(end);
			end++;
			switch (c) {
			case '\'':
				if (!doubleQuote)
					simpleQuote = !simpleQuote;
				break;
			case '"':
				if (!simpleQuote)
					doubleQuote = !doubleQuote;
				break;
			case '.':
				if (!simpleQuote && !doubleQuote) {
					String clause = prologCode.substring(begin, end);
					clauses.add(clause.trim());
					begin = end;
				}
			}
		}
		if (end > begin) {
			String clause = prologCode.substring(begin, end).trim();
			if (!clause.equals(""))
				clauses.add(clause.trim());
		}
		return clauses;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.javalogutil.JavalogUtil#validatePrologCode(java.lang.String)
	 */
	public String validatePrologCode(String prologCode) {
		List<String> clauses = splitClauses(prologCode);
		PlParser parser = new PlParser(new PlOpTable());
		for (String clauseString: clauses) {
			try {
				PlClause clause = mkClause(parser.query(clauseString));
				if (clause == null)
					return "Clause \"" + clauseString + "\" can't be parsed";
			}
			catch (Throwable t) {
				return "Clause \"" + clauseString + "\" can't be parsed: " + t;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.javalogutil.JavalogUtil#escapePrologString(java.lang.String)
	 */
	public String escapePrologString(String prologString) {
		if (prologString == null)
			return null;
		if (prologString.length() >= 2 &&
				prologString.startsWith("'") &&
				prologString.endsWith("'")) {
			prologString = prologString.substring(1, prologString.length()-1);
		}
		return prologString;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.util.javalog.JavalogUtil#createPlList(java.util.List)
	 */
	public PlList createPlList(List list) {
		PlList plList;
		if (list != null && list.size() > 0) {
			PlObject[] plObjectArray = new PlObject[list.size()];
			int i = 0;
			for (Object object: list) {
				PlObject plObject = new PlJavaObj(object);
				plObjectArray[i++] = plObject;
			}
			plList = PlList.arrayToPlList(plObjectArray, null);
		}
		else {
			plList = PlList.empty();
		}
		return plList;
	}

}
