/**
 * Define a grammar called WRB
 */
grammar WRB;

options {
	language = Java;
}

expr: expr op=('*'|'/') expr # MulDiv
    | expr op=('+'|'-') expr # AddSub
    | Number                 # Numb
    | '('expr')'             # Parens
    ;




/* A number: can be an integer value, or a decimal value */
Number
    :    ('-')?('0'..'9')+ ('.' ('0'..'9')+)?
    ;
          
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
    