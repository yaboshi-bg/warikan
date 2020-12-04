package jp.co.biglobe.warikan.domain.payment;

import jp.co.biglobe.warikan.domain.amount.Amount;
import lombok.Getter;

public class AmountOfMinimumPaymentUnit {
    @Getter
    private Amount amount;

    public AmountOfMinimumPaymentUnit() {
        amount = new Amount(100);
    }
}