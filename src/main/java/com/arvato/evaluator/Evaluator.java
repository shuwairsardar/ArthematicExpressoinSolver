package com.arvato.evaluator;
/**
* This class evaluates expressions and rebuld list in a form that contains only evaluted value or operator
 * Thans pass to outer evalutors to evaluate '^' , '*' '/' , '+' '-' in sequence
 *
 */
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.arvato.contant.Constants.*;

public class Evaluator {
    /**
     * Solve expression in order
     *
     * @param expressions
     *                  List of expressions
     * @return
     *         Evaluated value or invalid
     */
    public String evalaute(List<String> expressions) {
        try {

            evaluateInerExpression(expressions);
            evaluateOuterPowExpression(expressions);
            evaluateOuterMulDivExpression(expressions);
            evaluatePlusMinExpression(expressions);
            return formateValue(expressions.get(0));

        } catch (EvaluationException e) {
            return e.getMessage();
        }
    }
   /**
     * Solve outer expressions with ^ and rebuild expression list
     * @param outerExp
     *                  List of outer expressions
     * @ return
     *         Evaluated value or invalid
     */

    private void evaluateOuterPowExpression(List<String> outerExp) {
        int size = outerExp.size();
        if (outerExp.size() == 1)
            return;
        for (int i = 0; i < size - 1; i++) {
            if (outerExp.get(i).equals(POW)) {
                String newValue = solve(outerExp.get(i - 1), outerExp.get(i + 1), outerExp.get(i));
                for (int j = 0; j < 3; j++) {
                    outerExp.remove(i - 1);
                }
                outerExp.add(i - 1, newValue);
                size = outerExp.size();
                i = i - 2;
            }
        }
    }

    /**
     * Solve outer expressions with * / and rebuild expression list
     * @param outerExp
     *                  List of outer expressions
     * @ return
     *         Evaluated value or invalid
     */
    private void evaluateOuterMulDivExpression(List<String> outerExp) {
        try {
            int size = outerExp.size();
            if (outerExp.size() == 1)
                return;
            for (int i = 0; i < size - 1; i++) {
                if (outerExp.get(i).equals(MULTIPLY) || outerExp.get(i).equals(DIVIDE)) {
                    String newValue = solve(outerExp.get(i - 1), outerExp.get(i + 1), outerExp.get(i));
                    for (int j = 0; j < 3; j++) {
                        outerExp.remove(i - 1);
                    }
                    outerExp.add(i - 1, newValue);
                    size = outerExp.size();
                    i = i - 2;
                }
            }
        } catch (RuntimeException e) {
            throw new EvaluationException("INVALID");
        }
    }

    /**
     * Solve outer expressions with + - and rebuild expression list
     * @param outerExp
     *                  List of outer expressions
     * @ return
     *         Evaluated value or invalid
     */
    private void evaluatePlusMinExpression(List<String> outerExp) {
        try {
            if (outerExp.size() == 1)
                return;
            String newValue = solve(outerExp.get(0), outerExp.get(2), outerExp.get(1));
            for (int i = 0; i < 3; i++) {
                outerExp.remove(0);
            }
            outerExp.add(0, newValue);
            evaluatePlusMinExpression(outerExp);
        } catch (RuntimeException e) {
            throw new EvaluationException("INVALID");
        }
    }

    /**
     * Solve inner expressions with all oprator and rebuild expression list
     * @param innerExp
     *                  List of inner expressions
     * @ return
     *         Evaluated value or invalid
     */
    private void evaluateInerExpression(List<String> innerExp) {
        try {
            for (int i = 0; i < innerExp.size(); i++) {

                Pattern regex = Pattern.compile(OPERATOR_REG);
                String tempExp = innerExp.get(i);
                Matcher matcher = regex.matcher(tempExp);
                if (tempExp.length() > 1 && matcher.find()) {
                    innerExp.set(i, solve(tempExp.substring(0, matcher.start()),
                            tempExp.substring(matcher.end()),
                            matcher.group()));
                }
            }
        } catch (RuntimeException e) {
            throw new EvaluationException("INVALID");
        }
    }

    /**
     * Solve values based on left right and operator
     * @param left
     *                  first value in list
     * @param right
     *                  last value in list
     * @param operator
     *                   operator between first and last
     * @ return
     *         Evaluated value or invalid
     */
    private String solve(String left, String right, String operator) {
        try {
            if (operator.equals(PLUS))
                return Double.toString(Double.parseDouble(left) + Double.parseDouble(right));
            if (operator.equals(MINUS))
                return Double.toString(Double.parseDouble(left) - Double.parseDouble(right));
            if (operator.equals(MULTIPLY))
                return Double.toString(Double.parseDouble(left) * Double.parseDouble(right));
            if (operator.equals(DIVIDE))
                return Double.toString(Double.parseDouble(left) / Double.parseDouble(right));
            if (operator.equals(POW))
                return Double.toString(Math.pow(Double.parseDouble(left), Double.parseDouble(right)));
            return "";
        } catch (RuntimeException e) {
            throw new EvaluationException("INVALID");
        }
    }

    /**
     * Format to int if not double value
     * @param strValue
     * @return
     */
    private String formateValue(String strValue) {
        double value = Double.parseDouble(strValue);
        if (value == (long) value)
            return String.format("%d", (long) value);
        else
            return String.format("%s", value);
    }

}
