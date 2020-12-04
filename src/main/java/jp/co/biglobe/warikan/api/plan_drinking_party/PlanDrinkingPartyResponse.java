package jp.co.biglobe.warikan.api.plan_drinking_party;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(includeFieldNames = false)
@EqualsAndHashCode
@AllArgsConstructor
public class PlanDrinkingPartyResponse {
    @Getter
    int drinkingPartyId;
}
