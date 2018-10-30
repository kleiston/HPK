grammar WRB;

options {
	language = Java;
}

start: statement;

statement: (expr (';')?)* | (assign (';')?)* ;

expr: expr op=(MUL|DIV) expr # MulDiv
    | expr op=(ADD|SUB) expr # AddSub
    | functionsignature		 # Function
    | Number                 # Numb
    | Var					 # Variable
    | '('expr')'             # Parens
    ;

assign: Var op=('='|':') expr # assignVar |
		functionsignature op=('=' | ':') expr # assignFunction;
		
functionsignature: functionname '(' (Var)(','Var)* ')';

functionname: Var;

Var: (SUB)?Word Int? Word*;
// A number: can be an integer/decimal value
Number: (Int ('.' Int)? | ('.' Int))BASE?;

Int: ('0'..'9')+;
Word: ('a'..'z' |'A'..'Z' | '_')+;
          
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
BASE: ('e' | 'E')(SUB|ADD)Int;