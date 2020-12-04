package jp.co.biglobe.warikan.service;

import jp.co.biglobe.warikan.domain.drinking_party.DrinkingParty;
import jp.co.biglobe.warikan.domain.drinking_party.DrinkingPartyId;
import jp.co.biglobe.warikan.domain.drinking_party.DrinkingPartyRepository;
import jp.co.biglobe.warikan.domain.drinking_party.Member;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AttendDrinkingPartyService {
    @NonNull
    private DrinkingPartyRepository drinkingPartyRepository;

    public void attend(DrinkingPartyId drinkingPartyId, Member member) {
        // Todo: memberのpersonIdが存在するか確認
        DrinkingParty drinkingParty = drinkingPartyRepository.drinkingPartyOf(drinkingPartyId);
        drinkingParty.attend(member);
        drinkingPartyRepository.store(drinkingParty);
    }
}
