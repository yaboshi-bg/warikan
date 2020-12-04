package jp.co.biglobe.warikan.domain.payment;

import jp.co.biglobe.warikan.domain.amount.Amount;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
public class SplitBillResult {
    @Getter
    private BalanceDue balanceDue;
    @Getter
    private AmountOfPaymentOfAllMembers amountOfPaymentOfAllMembers;
    @Getter
    private NumberOfAllMembers numberOfAllMembers;

    public Amount amountOfPaymentOfAMemberOf(PaymentClassification paymentClassification) {
        return this.amountOfPaymentOfAllMembers.amountOfPaymentOf(paymentClassification).divide(numberOfAllMembers.numberOfMembersOf(paymentClassification).getNumberOfMembers());
    }
}
