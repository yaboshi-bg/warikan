package jp.co.biglobe.warikan.domain.payment;

import jp.co.biglobe.warikan.domain.drinking_party.AmountOfBill;

public class BillSplitter {
    public static SplitBillResult split(
            AmountOfBill amountOfBill,
            NumberOfAllMembers numberOfAllMembers,
            SettingsOfRatioOfPaymentOfPaymentClassification settingsOfRatioOfPaymentOfPaymentClassification
    ) {
        RatioOfPaymentOfAllMembers ratioOfPaymentOfAllMembers = new RatioOfPaymentOfAllMembers(settingsOfRatioOfPaymentOfPaymentClassification, numberOfAllMembers);
        AmountOfPaymentUnitBeforePaymentAccuracyAdjustment amountOfPaymentUnitBeforePaymentAccuracyAdjustment = new AmountOfPaymentUnitBeforePaymentAccuracyAdjustment(amountOfBill, ratioOfPaymentOfAllMembers);
        AmountOfMinimumPaymentUnit amountOfMinimumPaymentUnit = new AmountOfMinimumPaymentUnit();
        CoefficientOfAmountOfMinimumPaymentUnit coefficientOfAmountOfMinimumPaymentUnit = new CoefficientOfAmountOfMinimumPaymentUnit(amountOfPaymentUnitBeforePaymentAccuracyAdjustment, amountOfMinimumPaymentUnit);
        AmountOfPaymentUnitAfterPaymentAccuracyAdjustment amountOfPaymentUnitAfterPaymentAccuracyAdjustment = new AmountOfPaymentUnitAfterPaymentAccuracyAdjustment(amountOfMinimumPaymentUnit, coefficientOfAmountOfMinimumPaymentUnit);
        AmountOfPaymentOfAllMembers amountOfPaymentOfAllMembers = new AmountOfPaymentOfAllMembers(amountOfPaymentUnitAfterPaymentAccuracyAdjustment, ratioOfPaymentOfAllMembers);
        BalanceDue balanceDue = new BalanceDue(amountOfBill, amountOfPaymentOfAllMembers);
        return new SplitBillResult(balanceDue, amountOfPaymentOfAllMembers, numberOfAllMembers);
    }
}
