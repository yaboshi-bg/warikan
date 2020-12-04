package jp.co.biglobe.warikan.domain.payment;

import jp.co.biglobe.warikan.domain.amount.Amount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.EnumMap;
import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class AmountOfPaymentOfAllMembers {
    @Getter
    private Map<PaymentClassification, Amount> amountOfPaymentOfAllMembers;

    public AmountOfPaymentOfAllMembers(AmountOfPaymentUnitAfterPaymentAccuracyAdjustment amountOfPaymentUnitAfterPaymentAccuracyAdjustment, RatioOfPaymentOfAllMembers ratioOfPaymentOfAllMembers) {
        amountOfPaymentOfAllMembers = new EnumMap<>(PaymentClassification.class);

        for (PaymentClassification paymentClassification : PaymentClassification.values()) {
            AmountOfPaymentOfMembersOfPaymentClassification amountOfPaymentOfMembersOfPaymentClassification = new AmountOfPaymentOfMembersOfPaymentClassification(amountOfPaymentUnitAfterPaymentAccuracyAdjustment, ratioOfPaymentOfAllMembers.ratioOfPaymentOfMembersOf(paymentClassification));
            amountOfPaymentOfAllMembers.put(paymentClassification, amountOfPaymentOfMembersOfPaymentClassification.getAmount());
        }
    }

    public Amount amountOfPaymentOfAllMembers() {
        return amountOfPaymentOfAllMembers.entrySet().stream().map(paymentClassificationAmountEntry -> paymentClassificationAmountEntry.getValue()).reduce(Amount.zero(), (sum, amount) -> sum.add(amount));
    }

    public Amount amountOfPaymentOf(PaymentClassification paymentClassification) {
        return amountOfPaymentOfAllMembers.get(paymentClassification);
    }
}