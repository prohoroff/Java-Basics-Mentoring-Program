package main.groovy.by.prohor.task1.calculate.expression

class Division implements Expression {

    Expression left
    Expression right

    @Override
    BigDecimal eval() throws Exception {
        return left.eval() / right.eval()
    }
}


