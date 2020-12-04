package jp.co.biglobe.warikan.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CoefficientOfAmountOfMinimumPaymentUnit {
    @Getter
    private int coefficientOfPaymentCalculationAccuracy;

    public CoefficientOfAmountOfMinimumPaymentUnit(
            AmountOfPaymentUnitBeforePaymentAccuracyAdjustment amountOfPaymentUnitBeforePaymentAccuracyAdjustment,
            AmountOfMinimumPaymentUnit amountOfMinimumPaymentUnit
    ) {
        coefficientOfPaymentCalculationAccuracy = amountOfPaymentUnitBeforePaymentAccuracyAdjustment.getAmount().divide(amountOfMinimumPaymentUnit.getAmount());
    }
}