package jp.co.biglobe.warikan.domain.drinking_party;

public interface DrinkingPartyRepository {
    void store(DrinkingParty drinkingParty);

    DrinkingParty drinkingPartyOf(DrinkingPartyId drinkingPartyId);

    DrinkingPartyId nextIdentity();
}
