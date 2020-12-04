package jp.co.biglobe.warikan.api.attend_drinking_party;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 飲み会参加のリクエスト
 */
@ToString(includeFieldNames = false)
@EqualsAndHashCode
@AllArgsConstructor
public class AttendDrinkingPartyRequest {
    @Getter
    int personId;
    @Getter
    String paymentClassification;
}
