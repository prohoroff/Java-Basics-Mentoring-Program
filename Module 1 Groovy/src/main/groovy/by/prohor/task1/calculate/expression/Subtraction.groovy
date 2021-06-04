package main.groovy.by.prohor.task1.calculate.expression

class Subtraction implements Expression{

    Expression left
    Expression right

    @Override
    BigDecimal eval() throws Exception {
        return left.eval() - right.eval()
    }
}
