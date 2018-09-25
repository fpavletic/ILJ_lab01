// Generated from C:/Users/Filip/IdeaProjects/ILJ_lab01/src/main/antlr\Request.g4 by ANTLR 4.7
package hr.tel.fer.lab1.antlr;

    import java.util.List;
    import java.util.ArrayList;
    import java.util.function.Predicate;
    import hr.tel.fer.lab1.logging.LogLine;
    import hr.tel.fer.lab1.server.LogRequestContainer;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RequestLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, KEYWORD=4, KEYWORD_IN_QUOTES=5, OPERATOR=6, VALUE=7, 
		VALUE_IN_QUOTES=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "KEYWORD", "KEYWORD_IN_QUOTES", "OPERATOR", "VALUE", 
		"VALUE_IN_QUOTES", "NUMBER", "LETTER", "DIGIT"
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


	    private List<Predicate<LogLine>> predicates = new ArrayList<>();
	    private int count = -1;


	public RequestLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Request.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\nk\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5I\n\5"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7S\n\7\3\b\3\b\3\b\6\bX\n\b\r\b\16"+
		"\bY\3\t\3\t\3\t\3\t\3\n\5\na\n\n\3\n\6\nd\n\n\r\n\16\ne\3\13\3\13\3\f"+
		"\3\f\2\2\r\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\2\25\2\27\2\3\2\5\6\2"+
		"\60\61<<]]__\4\2C\\c|\3\2\62;\2q\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\31\3\2"+
		"\2\2\5!\3\2\2\2\7)\3\2\2\2\tH\3\2\2\2\13J\3\2\2\2\rR\3\2\2\2\17W\3\2\2"+
		"\2\21[\3\2\2\2\23`\3\2\2\2\25g\3\2\2\2\27i\3\2\2\2\31\32\7H\2\2\32\33"+
		"\7K\2\2\33\34\7N\2\2\34\35\7V\2\2\35\36\7G\2\2\36\37\7T\2\2\37 \7\"\2"+
		"\2 \4\3\2\2\2!\"\7T\2\2\"#\7G\2\2#$\7V\2\2$%\7W\2\2%&\7T\2\2&\'\7P\2\2"+
		"\'(\7\"\2\2(\6\3\2\2\2)*\7\"\2\2*\b\3\2\2\2+,\7K\2\2,I\7R\2\2-.\7F\2\2"+
		"./\7C\2\2/\60\7V\2\2\60\61\7G\2\2\61\62\7V\2\2\62\63\7K\2\2\63\64\7O\2"+
		"\2\64I\7G\2\2\65\66\7O\2\2\66\67\7G\2\2\678\7V\2\289\7J\2\29:\7Q\2\2:"+
		"I\7F\2\2;<\7X\2\2<=\7G\2\2=>\7T\2\2>?\7U\2\2?@\7K\2\2@A\7Q\2\2AI\7P\2"+
		"\2BC\7U\2\2CD\7V\2\2DE\7C\2\2EF\7V\2\2FG\7W\2\2GI\7U\2\2H+\3\2\2\2H-\3"+
		"\2\2\2H\65\3\2\2\2H;\3\2\2\2HB\3\2\2\2I\n\3\2\2\2JK\7$\2\2KL\5\t\5\2L"+
		"M\7$\2\2M\f\3\2\2\2NO\7?\2\2OS\7?\2\2PQ\7#\2\2QS\7?\2\2RN\3\2\2\2RP\3"+
		"\2\2\2S\16\3\2\2\2TX\5\23\n\2UX\5\25\13\2VX\t\2\2\2WT\3\2\2\2WU\3\2\2"+
		"\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\20\3\2\2\2[\\\7$\2\2\\]\5"+
		"\17\b\2]^\7$\2\2^\22\3\2\2\2_a\7/\2\2`_\3\2\2\2`a\3\2\2\2ac\3\2\2\2bd"+
		"\5\27\f\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\24\3\2\2\2gh\t\3\2"+
		"\2h\26\3\2\2\2ij\t\4\2\2j\30\3\2\2\2\t\2HRWY`e\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}