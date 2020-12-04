package jp.co.biglobe.warikan.domain.drinking_party;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@SuppressWarnings("serial")
public class DrinkingPartyId implements Serializable {
    @Getter
    private int drinkingPartyId;
}
