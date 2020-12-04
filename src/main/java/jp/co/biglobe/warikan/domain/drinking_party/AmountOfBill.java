package jp.co.biglobe.warikan.domain.drinking_party;

import jp.co.biglobe.warikan.domain.amount.Amount;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@EqualsAndHashCode
@SuppressWarnings("serial")
public class AmountOfBill implements Serializable {
    @Getter
    private Amount amount;

    public AmountOfBill(Amount amount) {
        if (amount.lessThan(Amount.zero())) {
            throw new IllegalArgumentException("請求金額は0未満にできません。");
        }
        this.amount = amount;
    }
}
