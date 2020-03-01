package com.arvato.contant;
/**
* Constants and regurlar expression
*/
public class Constants {

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";
    public static final String POW = "^";
    public static final String BRACKET_OPEN = "(";
    public static final String BRACKET_CLOSE = ")";

    //Regular exprassion for parsing
    public static final String BRACKET_REG = "\\(|\\)";
    public static final String WITHOUT_BRACKET_REG = "((?<=[+-/*^])|([+-/*^]=;))";
    public static final String END_LINE_OPERATOR_REG = "[+-/*^]$";
    public static final String START_LINE_OPERATOR_REG = "^[+-/*^]";
    public static final String OPERATOR_REG = "[+-/*^]";


}
