package jp.co.biglobe.warikan.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class RatioOfPaymentOfMembersOfPaymentClassification {
    @Getter
    private PaymentClassification paymentClassification;
    @Getter
    private RatioOfPayment ratioOfPayment;

    public RatioOfPaymentOfMembersOfPaymentClassification(PaymentClassification paymentClassification, RatioOfPayment ratioOfPayment, NumberOfMembers numberOfMembers) {
        this.paymentClassification = paymentClassification;
        this.ratioOfPayment = ratioOfPayment.multiply(numberOfMembers);
    }
}
