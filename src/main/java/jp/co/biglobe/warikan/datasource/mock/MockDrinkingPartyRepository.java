package jp.co.biglobe.warikan.datasource.mock;

import jp.co.biglobe.warikan.domain.drinking_party.DrinkingParty;
import jp.co.biglobe.warikan.domain.drinking_party.DrinkingPartyId;
import jp.co.biglobe.warikan.domain.drinking_party.DrinkingPartyRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MockDrinkingPartyRepository implements DrinkingPartyRepository {
    Map<DrinkingPartyId, DrinkingParty> drinkingParties = new HashMap<>();
    int nextIdentity = 1;

    public void store(DrinkingParty drinkingParty) {
        drinkingParties.put(drinkingParty.getDrinkingPartyId(), drinkingParty);
    }

    public DrinkingParty drinkingPartyOf(DrinkingPartyId drinkingPartyId) {
        return drinkingParties.get(drinkingPartyId);
    }

    public DrinkingPartyId nextIdentity() {
        return new DrinkingPartyId(nextIdentity++);
    }
}
