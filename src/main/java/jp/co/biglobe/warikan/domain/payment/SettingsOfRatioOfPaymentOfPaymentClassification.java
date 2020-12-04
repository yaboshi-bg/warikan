package jp.co.biglobe.warikan.domain.payment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;

@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings("serial")
public class SettingsOfRatioOfPaymentOfPaymentClassification implements Serializable {
    @Getter
    Map<PaymentClassification, RatioOfPayment> settingsOfRatioOfPaymentOfPaymentClassification;

    public SettingsOfRatioOfPaymentOfPaymentClassification() {
        settingsOfRatioOfPaymentOfPaymentClassification = new EnumMap<>(PaymentClassification.class);

        for (PaymentClassification paymentClassification : PaymentClassification.values()) {
            settingsOfRatioOfPaymentOfPaymentClassification.put(paymentClassification, RatioOfPayment.zero());
        }
    }

    public SettingsOfRatioOfPaymentOfPaymentClassification changeSetting(SettingOfRatioOfPaymentOfPaymentClassification settingOfRatioOfPaymentOfPaymentClassification) {
        Map<PaymentClassification, RatioOfPayment> newSettingsOfRatioOfPaymentOfPaymentClassification = new EnumMap<>(PaymentClassification.class);
        newSettingsOfRatioOfPaymentOfPaymentClassification.putAll(settingsOfRatioOfPaymentOfPaymentClassification);
        newSettingsOfRatioOfPaymentOfPaymentClassification.put(settingOfRatioOfPaymentOfPaymentClassification.getPaymentClassification(), settingOfRatioOfPaymentOfPaymentClassification.getRatioOfPayment());
        return new SettingsOfRatioOfPaymentOfPaymentClassification(newSettingsOfRatioOfPaymentOfPaymentClassification);
    }

    public RatioOfPayment ratioOfPaymentOf(PaymentClassification paymentClassification) {
        return settingsOfRatioOfPaymentOfPaymentClassification.get(paymentClassification);
    }

}
