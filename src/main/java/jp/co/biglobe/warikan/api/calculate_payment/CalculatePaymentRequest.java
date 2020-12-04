package jp.co.biglobe.warikan.api.calculate_payment;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 支払い金額計算のリクエスト
 */
@ToString(includeFieldNames = false)
@EqualsAndHashCode
@AllArgsConstructor
public class CalculatePaymentRequest {

    /**
     * 請求金額
     */
    @Getter
    private int billingAmount;

    /**
     * 支払い区分が「多め」の支払い割合い
     */
    @Getter
    private int largeRatio;

    /**
     * 支払い区分が「普通」の支払い割合い
     */
    @Getter
    private int mediumRatio;

    /**
     * 支払い区分が「少なめ」の支払い割合い
     */
    @Getter
    private int smallRatio;
}
