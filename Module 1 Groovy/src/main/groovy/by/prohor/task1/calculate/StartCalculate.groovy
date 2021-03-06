package main.groovy.by.prohor.task1.calculate

import main.groovy.by.prohor.task1.calculate.evaluator.EvaluatorExpression

class StartCalculate {
    static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = checkExpression(scanner, "Enter your expression => ")

            double value = EvaluatorExpression.evalExpression(line)
            println("Result your expression (${line}) => ${value}")
        }
    }

    static String checkExpression(Scanner scanner, String message) {
        print(message)
        String ex = scanner.nextLine().replaceAll("[\\s]", "")
        while (!ex.matches("[\\d+\\-*/)(]*")) {
            println("Your expression is not correct. Please enter other value!")
            ex = scanner.nextLine()
        }
        ex
    }
}