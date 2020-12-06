package jp.co.biglobe.warikan.domain.payment;

import jp.co.biglobe.warikan.domain.amount.Amount;
import lombok.Getter;

public class AmountOfPaymentUnitBeforePaymentAccuracyAdjustment {
    @Getter
    private Amount amount;

    public AmountOfPaymentUnitBeforePaymentAccuracyAdjustment(AmountOfBill amountOfBill, RatioOfPaymentOfAllMembers ratioOfPaymentOfAllMembers) {
        amount = amountOfBill.getAmount().divide(ratioOfPaymentOfAllMembers.getRatioOfPaymentOfAllMembers().getRatioOfPayment());

        if (amount.lessThan(Amount.zero())) {
            throw new IllegalArgumentException("支払い最小単位調整前支払い単位金額は0未満にできません。");
        }
    }
}

