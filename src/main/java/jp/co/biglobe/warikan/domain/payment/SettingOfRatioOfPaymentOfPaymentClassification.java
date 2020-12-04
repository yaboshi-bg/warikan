package jp.co.biglobe.warikan.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class SettingOfRatioOfPaymentOfPaymentClassification {
    @Getter
    PaymentClassification paymentClassification;
    @Getter
    RatioOfPayment ratioOfPayment;
}
