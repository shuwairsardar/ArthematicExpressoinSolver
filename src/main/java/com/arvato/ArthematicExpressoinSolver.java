package com.arvato;

/*
 * ArthematicExpressoinSolver read inputs from input.txt and parse and evalute expressios
 */

import com.arvato.evaluator.Evaluator;
import com.arvato.parser.Parser;
import com.avarto.reader.InputReader;

import java.util.List;

public class ArthematicExpressoinSolver {

    /**
     * Read expressions from input file and solve them
     */
    public void readAndSolve() {
        List<String> expressionList = InputReader.readInput();
        for (String s : expressionList) {
            System.out.println(solve(s));
        }
    }

    /**
     * Solve single expression
     *
     * @param expression single expression e.g 1+2*(1+2)
     */
    public String solve(String expression) {
        Parser parser = new Parser();
        List<String> expList = parser.parse(expression);
        Evaluator evaluator = new Evaluator();
        return evaluator.evalaute(expList);
    }

    public static void main(String[] args) {

        ArthematicExpressoinSolver ar = new ArthematicExpressoinSolver();
        ar.readAndSolve();


    }
}
