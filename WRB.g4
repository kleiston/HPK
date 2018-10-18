/**
 * Define a grammar called WRB
 */
grammar WRB;

options {
	language = Java;
}

start: statement  ;

statement: (expr (';')?)* | (assign (';')?)* ;

expr: expr op=(MUL|DIV) expr # MulDiv
    | expr op=(ADD|SUB) expr # AddSub
    | Number                 # Numb
    | '('expr')'             # Parens
    ;

assign: Var op=('='|':') expr;

Var: Word Int? Word*;

/* A number: can be an integer value, or a decimal value */
Number: (SUB)?Int ('.' Int)?;
          
Int: ('0'..'9')+;
Word: ('a'..'z' |'A'..'Z' | '_')+;
          
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';