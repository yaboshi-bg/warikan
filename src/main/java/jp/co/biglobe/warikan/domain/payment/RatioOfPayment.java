package jp.co.biglobe.warikan.domain.payment;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@EqualsAndHashCode
@SuppressWarnings("serial")
public class RatioOfPayment implements Serializable {
    @Getter
    private int ratioOfPayment;

    public RatioOfPayment(int ratioOfPayment) {
        if (ratioOfPayment < 0) {
            throw new IllegalArgumentException("支払い割合は0未満にできません。");
        }
        this.ratioOfPayment = ratioOfPayment;
    }

    static RatioOfPayment zero() {
        return new RatioOfPayment(0);
    }

    public RatioOfPayment add(RatioOfPayment ratioOfPayment) {
        return new RatioOfPayment(this.ratioOfPayment + ratioOfPayment.getRatioOfPayment());
    }

    public RatioOfPayment multiply(NumberOfMembers by) {
        return new RatioOfPayment(ratioOfPayment * by.getNumberOfMembers());
    }
}
