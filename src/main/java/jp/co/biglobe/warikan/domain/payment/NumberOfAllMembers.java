package jp.co.biglobe.warikan.domain.payment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.EnumMap;
import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class NumberOfAllMembers {
    @Getter
    private Map<PaymentClassification, NumberOfMembers> numberOfAllMembers;

    public NumberOfAllMembers() {
        numberOfAllMembers = new EnumMap<>(PaymentClassification.class);

        for (PaymentClassification paymentClassification: PaymentClassification.values()) {
            numberOfAllMembers.put(paymentClassification, NumberOfMembers.zero());
        }
    }

    public NumberOfAllMembers changeNumberOfMembersOfPaymentClassification(NumberOfMembersOfPaymentClassification numberOfMembersOfPaymentClassification) {
        Map<PaymentClassification, NumberOfMembers> newNumberOfAllMembers = new EnumMap<>(PaymentClassification.class);
        newNumberOfAllMembers.putAll(numberOfAllMembers);
        newNumberOfAllMembers.put(numberOfMembersOfPaymentClassification.getPaymentClassification(), numberOfMembersOfPaymentClassification.getNumberOfMembers());
        return new NumberOfAllMembers(newNumberOfAllMembers);
    }

    public NumberOfMembers numberOfMembersOf(PaymentClassification paymentClassification) {
        return numberOfAllMembers.get(paymentClassification);
    }

    public NumberOfAllMembers increment(PaymentClassification paymentClassification) {
        Map<PaymentClassification, NumberOfMembers> newNumberOfAllMembers = new EnumMap<>(PaymentClassification.class);
        newNumberOfAllMembers.putAll(numberOfAllMembers);
        NumberOfMembers newNumberOfMembers = numberOfMembersOf(paymentClassification).increment();
        newNumberOfAllMembers.put(paymentClassification, newNumberOfMembers);
        return new NumberOfAllMembers(newNumberOfAllMembers);
    }
}
