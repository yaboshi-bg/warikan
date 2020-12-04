package jp.co.biglobe.warikan.domain.payment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.EnumMap;
import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RatioOfPaymentOfAllMembers {
    private Map<PaymentClassification, RatioOfPayment> ratioOfPaymentOfAllMembers;

    public RatioOfPaymentOfAllMembers(SettingsOfRatioOfPaymentOfPaymentClassification settingsOfRatioOfPaymentOfPaymentClassification, NumberOfAllMembers numberOfAllMembers) {
        ratioOfPaymentOfAllMembers = new EnumMap<>(PaymentClassification.class);

        for (PaymentClassification paymentClassification : PaymentClassification.values()) {
            RatioOfPaymentOfMembersOfPaymentClassification ratioOfPaymentOfMembersOfPaymentClassification = new RatioOfPaymentOfMembersOfPaymentClassification(
                    paymentClassification,
                    settingsOfRatioOfPaymentOfPaymentClassification.ratioOfPaymentOf(paymentClassification),
                    numberOfAllMembers.numberOfMembersOf(paymentClassification)
            );
            ratioOfPaymentOfAllMembers.put(paymentClassification, ratioOfPaymentOfMembersOfPaymentClassification.getRatioOfPayment());
        }
    }

    public RatioOfPayment getRatioOfPaymentOfAllMembers() {
        return ratioOfPaymentOfAllMembers.entrySet().stream().map(paymentClassificationRatioOfPaymentEntry -> paymentClassificationRatioOfPaymentEntry.getValue()).reduce(RatioOfPayment.zero(), (sum, ratioOfPayment) -> sum.add(ratioOfPayment));
    }

    public RatioOfPayment ratioOfPaymentOf(PaymentClassification paymentClassification) {
        return ratioOfPaymentOfAllMembers.get(paymentClassification);
    }

    public RatioOfPaymentOfMembersOfPaymentClassification ratioOfPaymentOfMembersOf(PaymentClassification paymentClassification) {
        return new RatioOfPaymentOfMembersOfPaymentClassification(paymentClassification, ratioOfPaymentOf(paymentClassification));
    }
}
