package jp.co.biglobe.warikan.domain.payment;

import jp.co.biglobe.warikan.domain.amount.Amount;
import lombok.Getter;

public class AmountOfPaymentUnitAfterPaymentAccuracyAdjustment {
    @Getter
    private Amount amount;

    public AmountOfPaymentUnitAfterPaymentAccuracyAdjustment(AmountOfMinimumPaymentUnit amountOfMinimumPaymentUnit, CoefficientOfAmountOfMinimumPaymentUnit coefficientOfAmountOfMinimumPaymentUnit) {
        amount = amountOfMinimumPaymentUnit.getAmount().multiply(coefficientOfAmountOfMinimumPaymentUnit.getCoefficientOfPaymentCalculationAccuracy());

        if (amount.lessThan(Amount.zero())) {
            throw new IllegalArgumentException("支払い最小単位調整後支払い単位金額は0未満にできません。");
        }
    }
}

