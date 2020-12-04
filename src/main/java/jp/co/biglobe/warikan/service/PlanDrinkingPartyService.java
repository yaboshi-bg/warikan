package jp.co.biglobe.warikan.service;

import jp.co.biglobe.warikan.domain.drinking_party.AmountOfBill;
import jp.co.biglobe.warikan.domain.drinking_party.DrinkingParty;
import jp.co.biglobe.warikan.domain.drinking_party.DrinkingPartyRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlanDrinkingPartyService {
    @NonNull
    private DrinkingPartyRepository drinkingPartyRepository;

    public DrinkingParty plan(AmountOfBill amountOfBill) {
        DrinkingParty drinkingParty = DrinkingParty.plan(drinkingPartyRepository.nextIdentity(), amountOfBill);
        drinkingPartyRepository.store(drinkingParty);
        return drinkingParty;
    }
}
