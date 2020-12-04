package jp.co.biglobe.warikan.domain.amount

import spock.lang.Specification

class AmountTest extends Specification {
    def addTest() {
        when:
        Amount amount1 = new Amount(10)
        Amount amount2 = new Amount(15)
        Amount amount3 = amount1.add(amount2)
        then:
        amount1.amount == 10
        amount2.amount == 15
        amount3.amount == 25
    }

    def subtractTest() {
        when:
        Amount amount1 = new Amount(a)
        Amount amount2 = new Amount(b)
        Amount amount3 = amount1.subtract(amount2)
        then:
        amount1.amount == a
        amount2.amount == b
        amount3.amount == expected
        where:
        a  | b  | expected
        15 | 10 | 5
        10 | 15 | -5
    }

    def divideTest() {
        when:
        Amount amount1 = new Amount(a)
        Amount amount2 = amount1.divide(b)

        then:
        amount1.amount == a
        amount2.amount == expected

        where:
        a   | b  | expected
        15  | 10 | 1
        10  | 15 | 0
        15  | 15 | 1
        -15 | 15 | -1
    }

    def remainderTest() {
        when:
        Amount amount1 = new Amount(a)
        Amount amount2 = amount1.remainder(b)

        then:
        amount1.amount == a
        amount2.amount == expected

        where:
        a   | b  | expected
        15  | 10 | 5
        10  | 15 | 10
        15  | 15 | 0
        -15 | 15 | 0
    }
}