package jp.co.biglobe.warikan.domain.drinking_party;

import jp.co.biglobe.warikan.domain.payment.PaymentClassification;
import jp.co.biglobe.warikan.domain.person.PersonId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@SuppressWarnings("serial")
public class Member implements Serializable {
    @Getter
    private PersonId personId;
    @Getter
    private PaymentClassification paymentClassification;
}
