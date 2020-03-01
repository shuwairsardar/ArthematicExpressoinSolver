package com.arvato.parser;
/**
 * Parser class using regular expression
 * First parse to open bracket or with operator
 * Thans build inner expressions to pass to Evaluator
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.arvato.contant.Constants.*;

public class Parser {
    /**
     * Split with brackets or with operator if no bracket exits
     * @param expression single line string expression
     * @return
     */
    public  List<String> parse(String expression) {
        String[] innerExpressions = null;
        if (expression.contains(BRACKET_OPEN) || expression.contains(BRACKET_CLOSE)) {
            innerExpressions = expression.split(BRACKET_REG);

        }
        else
            innerExpressions  = expression.split(WITHOUT_BRACKET_REG);
        return buildInnerExpression(innerExpressions);
    }

    /**
     * Build inner expression to have preper list either with complete expression, number or operator
     * E.g 2+3,7,+..
     * @param exp
     * @return
     */
    private  List<String> buildInnerExpression(String[] exp) {
        List<String> expList = new ArrayList<>(Arrays.asList(exp));
        int addCount = 0;
        for (int i = 0; i < exp.length; i++) {
            Pattern regex = Pattern.compile(END_LINE_OPERATOR_REG);
            String tempExp = exp[i];
            Matcher matcher = regex.matcher(exp[i]);
            if (tempExp.length() < 2)
                continue;
            if (matcher.find()) {

                expList.remove(i + addCount);
                expList.add(i + addCount, tempExp.substring(0, tempExp.length() - 1));
                expList.add(i + addCount + 1, Character.toString(tempExp.charAt(tempExp.length() - 1)));
                addCount++;
            }

            Pattern regex2 = Pattern.compile(START_LINE_OPERATOR_REG);
            Matcher matcher2 = regex2.matcher(exp[i]);
            if (matcher2.find()) {

                expList.remove(i + addCount);
                expList.add(i + addCount, Character.toString(tempExp.charAt(0)));
                expList.add(i + addCount + 1, tempExp.substring(1, tempExp.length()));
                addCount++;
            }

        }
        return expList;

    }
}
