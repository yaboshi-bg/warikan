package jp.co.biglobe.warikan.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class NumberOfMembersOfPaymentClassification {
    @Getter
    private PaymentClassification paymentClassification;
    @Getter
    private NumberOfMembers numberOfMembers;
}
