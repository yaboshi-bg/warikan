package jp.co.biglobe.warikan.domain.payment

import jp.co.biglobe.warikan.domain.amount.Amount
import spock.lang.Specification

class BillSplitterTest extends Specification {
    def splitTest() {
        when:
        AmountOfBill amountOfBill = new AmountOfBill(new Amount(2110))
        NumberOfAllMembers numberOfAllMembers = new NumberOfAllMembers()
                .changeNumberOfMembersOfPaymentClassification(new NumberOfMembersOfPaymentClassification(PaymentClassification.LARGE, new NumberOfMembers(2)))
                .changeNumberOfMembersOfPaymentClassification(new NumberOfMembersOfPaymentClassification(PaymentClassification.MEDIUM, new NumberOfMembers(2)))
                .changeNumberOfMembersOfPaymentClassification(new NumberOfMembersOfPaymentClassification(PaymentClassification.SMALL, new NumberOfMembers(2)))

        SettingsOfRatioOfPaymentOfPaymentClassification settingsOfRatioOfPaymentOfPaymentClassification = new SettingsOfRatioOfPaymentOfPaymentClassification()
                .changeSetting(new SettingOfRatioOfPaymentOfPaymentClassification(PaymentClassification.LARGE, new RatioOfPayment(5)))
                .changeSetting(new SettingOfRatioOfPaymentOfPaymentClassification(PaymentClassification.MEDIUM, new RatioOfPayment(3)))
                .changeSetting(new SettingOfRatioOfPaymentOfPaymentClassification(PaymentClassification.SMALL, new RatioOfPayment(2)))

        BillSplitter billSplitter = new BillSplitter()
        SplitBillResult splitBillResult = billSplitter.split(amountOfBill, numberOfAllMembers, settingsOfRatioOfPaymentOfPaymentClassification)

        then:
        splitBillResult.amountOfPaymentOfAMemberOf(PaymentClassification.LARGE) == new Amount(500)
        splitBillResult.amountOfPaymentOfAMemberOf(PaymentClassification.MEDIUM) == new Amount(300)
        splitBillResult.amountOfPaymentOfAMemberOf(PaymentClassification.SMALL) == new Amount(200)
        splitBillResult.balanceDue.amount == new Amount(110)
    }
}
