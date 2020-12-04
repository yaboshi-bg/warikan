package jp.co.biglobe.warikan.service;

import jp.co.biglobe.warikan.domain.drinking_party.DrinkingParty;
import jp.co.biglobe.warikan.domain.drinking_party.DrinkingPartyId;
import jp.co.biglobe.warikan.domain.drinking_party.DrinkingPartyRepository;
import jp.co.biglobe.warikan.domain.payment.SplitBillResult;
import jp.co.biglobe.warikan.domain.payment.SettingsOfRatioOfPaymentOfPaymentClassification;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SplitBillService {
    @NonNull
    private DrinkingPartyRepository drinkingPartyRepository;

    public SplitBillResult split(
            DrinkingPartyId drinkingPartyId,
            SettingsOfRatioOfPaymentOfPaymentClassification settingsOfRatioOfPaymentOfPaymentClassification
    ) {
        DrinkingParty drinkingParty = drinkingPartyRepository.drinkingPartyOf(drinkingPartyId);
        drinkingParty.changeSettingsOfRatioOfPaymentOfPaymentClassification(settingsOfRatioOfPaymentOfPaymentClassification);
        drinkingPartyRepository.store(drinkingParty);
        return drinkingParty.splitBill();
    }
}
