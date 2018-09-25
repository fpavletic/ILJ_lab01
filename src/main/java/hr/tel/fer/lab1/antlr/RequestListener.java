// Generated from C:/Users/Filip/IdeaProjects/ILJ_lab01/src/main/antlr\Request.g4 by ANTLR 4.7
package hr.tel.fer.lab1.antlr;

    import java.util.List;
    import java.util.ArrayList;
    import java.util.function.Predicate;
    import hr.tel.fer.lab1.logging.LogLine;
    import hr.tel.fer.lab1.server.LogRequestContainer;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RequestParser}.
 */
public interface RequestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RequestParser#request}.
	 * @param ctx the parse tree
	 */
	void enterRequest(RequestParser.RequestContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#request}.
	 * @param ctx the parse tree
	 */
	void exitRequest(RequestParser.RequestContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(RequestParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(RequestParser.ConditionContext ctx);
}