package jp.co.biglobe.warikan.api.plan_drinking_party;

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
public class PlanDrinkingPartyRequest {

    /**
     * 請求金額
     */
    @Getter
    private int billingAmount;

    /**
     * 支払い区分が「多め」のメンバ数
     */

    @Getter
    private int largeMembers;

    /**
     * 支払い区分が「普通」のメンバ数
     */

    @Getter
    private int mediumMembers;

    /**
     * 支払い区分が「少なめ」のメンバ数
     */

    @Getter
    private int smallMembers;
}
