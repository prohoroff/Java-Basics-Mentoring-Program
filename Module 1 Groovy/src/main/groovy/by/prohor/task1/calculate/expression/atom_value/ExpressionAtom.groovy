package main.groovy.by.prohor.task1.calculate.expression.atom_value

import main.groovy.by.prohor.task1.calculate.expression.Expression

class ExpressionAtom extends Atom {

   Expression expression

    @Override
    BigDecimal eval() {
        expression.eval()
    }
}
