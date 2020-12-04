package jp.co.biglobe.warikan.domain.payment;

import jp.co.biglobe.warikan.domain.amount.Amount;
import lombok.Getter;

public class AmountOfPaymentOfMembersOfPaymentClassification {
    @Getter
    private PaymentClassification paymentClassification;
    @Getter
    private Amount amount;

    public AmountOfPaymentOfMembersOfPaymentClassification(
            AmountOfPaymentUnitAfterPaymentAccuracyAdjustment amountOfPaymentUnitAfterPaymentAccuracyAdjustment,
            RatioOfPaymentOfMembersOfPaymentClassification ratioOfPaymentOfMembersOfPaymentClassification) {
        paymentClassification = ratioOfPaymentOfMembersOfPaymentClassification.getPaymentClassification();
        amount = amountOfPaymentUnitAfterPaymentAccuracyAdjustment.getAmount().multiply(ratioOfPaymentOfMembersOfPaymentClassification.getRatioOfPayment().getRatioOfPayment());

        if (amount.lessThan(Amount.zero())) {
            throw new IllegalArgumentException("支払い区分別参加者支払い金額は0未満にできません。");
        }
    }
}

