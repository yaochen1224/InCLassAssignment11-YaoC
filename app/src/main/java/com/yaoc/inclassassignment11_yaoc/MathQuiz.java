package com.yaoc.inclassassignment11_yaoc;

/**
 * Created by YaoChen on 4/18/17.
 */

public class MathQuiz {
    String operater;
    String number1;
    String number2;
    String answer;

    public MathQuiz(String operater, String number1, String number2, String answer) {
        this.operater = operater;
        this.number1 = number1;
        this.number2 = number2;
        this.answer = answer;
    }

    public MathQuiz() {
    }

    public String toQuiz(){
        return number1 + " " + operater + " " + number2;
    }

    public String getOperater() {
        return operater;
    }

    public String getNumber1() {
        return number1;
    }

    public String getNumber2() {
        return number2;
    }

    public void setOperater(String operater) {
        this.operater = operater;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public String getAnswer() {

        return answer;
    }

    @Override
    public String toString() {
        return "MathQuiz{" +
                "operater='" + operater + '\'' +
                ", number1='" + number1 + '\'' +
                ", number2='" + number2 + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
