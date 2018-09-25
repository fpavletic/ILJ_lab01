grammar Request;

@header {
    import java.util.List;
    import java.util.ArrayList;
    import java.util.function.Predicate;
    import hr.tel.fer.lab1.logging.LogLine;
    import hr.tel.fer.lab1.server.LogRequestContainer;
}

@members {
    private List<Predicate<LogLine>> predicates = new ArrayList<>();
    private int count = -1;
}

request returns [LogRequestContainer result]
    :    'FILTER ' condition+ 'RETURN ' tmp=VALUE
        {
            try {
                count = Integer.parseInt(($tmp).getText());
            } catch (NumberFormatException nfe){
            }
            $result = new LogRequestContainer(predicates, count);
        }
    ;
condition
    :   key=(KEYWORD_IN_QUOTES | KEYWORD) ' '? op=OPERATOR ' '? value=(VALUE_IN_QUOTES | VALUE ) ' '
        {
            predicates.add(l ->
                l.equals(
                    $key.getText().replaceAll("^\"|\"$", ""),
                    $value.getText().replaceAll("^\"|\"$", ""))
                ^ $op.getText().equals("!=") ? true : false);
        }
    ;

KEYWORD: ('IP'|'DATETIME'|'METHOD'|'VERSION'|'STATUS');
KEYWORD_IN_QUOTES: '"' KEYWORD '"';
OPERATOR: ('=='|'!=');
VALUE: (NUMBER|LETTER|':'|'.'|'/'|'['|']')+;
VALUE_IN_QUOTES: '"' VALUE '"';
fragment NUMBER: '-'? DIGIT+;
fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];
