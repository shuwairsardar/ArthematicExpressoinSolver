package com.arvato.evaluator;
/**
* Exception handels runtime in Evaluation and Parsing which will add INVALID
*/

public class EvaluationException extends RuntimeException {


    public EvaluationException(String message) {
        super(message);
    }

    public String getMessage() {

        return super.getMessage();
    }

}
