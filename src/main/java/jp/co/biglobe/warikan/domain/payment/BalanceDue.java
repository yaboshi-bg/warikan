package jp.co.biglobe.warikan.domain.payment;

import jp.co.biglobe.warikan.domain.amount.Amount;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class BalanceDue {
    @Getter
    private Amount amount;

    public BalanceDue(AmountOfBill amountOfBill, AmountOfPaymentOfAllMembers amountOfPaymentOfAllMembers) {
        amount = amountOfBill.getAmount().subtract(amountOfPaymentOfAllMembers.amountOfPaymentOfAllMembers());

        if (amount.lessThan(Amount.zero())) {
            throw new IllegalArgumentException("不足金額は0未満にできません。");
        }
    }
}
