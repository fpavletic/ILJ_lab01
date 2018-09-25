// Generated from C:/Users/Filip/IdeaProjects/ILJ_lab01/src/main/antlr\Request.g4 by ANTLR 4.7
package hr.tel.fer.lab1.antlr;

    import java.util.List;
    import java.util.ArrayList;
    import java.util.function.Predicate;
    import hr.tel.fer.lab1.logging.LogLine;
    import hr.tel.fer.lab1.server.LogRequestContainer;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RequestParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, KEYWORD=4, KEYWORD_IN_QUOTES=5, OPERATOR=6, VALUE=7, 
		VALUE_IN_QUOTES=8;
	public static final int
		RULE_request = 0, RULE_condition = 1;
	public static final String[] ruleNames = {
		"request", "condition"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'FILTER '", "'RETURN '", "' '"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "KEYWORD", "KEYWORD_IN_QUOTES", "OPERATOR", "VALUE", 
		"VALUE_IN_QUOTES"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Request.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private List<Predicate<LogLine>> predicates = new ArrayList<>();
	    private int count = -1;

	public RequestParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RequestContext extends ParserRuleContext {
		public LogRequestContainer result;
		public Token tmp;
		public TerminalNode VALUE() { return getToken(RequestParser.VALUE, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public RequestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_request; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestListener ) ((RequestListener)listener).enterRequest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestListener ) ((RequestListener)listener).exitRequest(this);
		}
	}

	public final RequestContext request() throws RecognitionException {
		RequestContext _localctx = new RequestContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_request);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4);
			match(T__0);
			setState(6); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(5);
				condition();
				}
				}
				setState(8); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==KEYWORD || _la==KEYWORD_IN_QUOTES );
			setState(10);
			match(T__1);
			setState(11);
			((RequestContext)_localctx).tmp = match(VALUE);

			            try {
			                count = Integer.parseInt((((RequestContext)_localctx).tmp).getText());
			            } catch (NumberFormatException nfe){
			            }
			            ((RequestContext)_localctx).result =  new LogRequestContainer(predicates, count);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public Token key;
		public Token op;
		public Token value;
		public TerminalNode OPERATOR() { return getToken(RequestParser.OPERATOR, 0); }
		public TerminalNode KEYWORD_IN_QUOTES() { return getToken(RequestParser.KEYWORD_IN_QUOTES, 0); }
		public TerminalNode KEYWORD() { return getToken(RequestParser.KEYWORD, 0); }
		public TerminalNode VALUE_IN_QUOTES() { return getToken(RequestParser.VALUE_IN_QUOTES, 0); }
		public TerminalNode VALUE() { return getToken(RequestParser.VALUE, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestListener ) ((RequestListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestListener ) ((RequestListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			((ConditionContext)_localctx).key = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==KEYWORD || _la==KEYWORD_IN_QUOTES) ) {
				((ConditionContext)_localctx).key = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(16);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(15);
				match(T__2);
				}
			}

			setState(18);
			((ConditionContext)_localctx).op = match(OPERATOR);
			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(19);
				match(T__2);
				}
			}

			setState(22);
			((ConditionContext)_localctx).value = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==VALUE || _la==VALUE_IN_QUOTES) ) {
				((ConditionContext)_localctx).value = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(23);
			match(T__2);

			            predicates.add(l ->
			                l.equals(
			                    ((ConditionContext)_localctx).key.getText().replaceAll("^\"|\"$", ""),
			                    ((ConditionContext)_localctx).value.getText().replaceAll("^\"|\"$", ""))
			                ^ ((ConditionContext)_localctx).op.getText().equals("!=") ? true : false);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\n\35\4\2\t\2\4\3"+
		"\t\3\3\2\3\2\6\2\t\n\2\r\2\16\2\n\3\2\3\2\3\2\3\2\3\3\3\3\5\3\23\n\3\3"+
		"\3\3\3\5\3\27\n\3\3\3\3\3\3\3\3\3\3\3\2\2\4\2\4\2\4\3\2\6\7\3\2\t\n\2"+
		"\35\2\6\3\2\2\2\4\20\3\2\2\2\6\b\7\3\2\2\7\t\5\4\3\2\b\7\3\2\2\2\t\n\3"+
		"\2\2\2\n\b\3\2\2\2\n\13\3\2\2\2\13\f\3\2\2\2\f\r\7\4\2\2\r\16\7\t\2\2"+
		"\16\17\b\2\1\2\17\3\3\2\2\2\20\22\t\2\2\2\21\23\7\5\2\2\22\21\3\2\2\2"+
		"\22\23\3\2\2\2\23\24\3\2\2\2\24\26\7\b\2\2\25\27\7\5\2\2\26\25\3\2\2\2"+
		"\26\27\3\2\2\2\27\30\3\2\2\2\30\31\t\3\2\2\31\32\7\5\2\2\32\33\b\3\1\2"+
		"\33\5\3\2\2\2\5\n\22\26";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}