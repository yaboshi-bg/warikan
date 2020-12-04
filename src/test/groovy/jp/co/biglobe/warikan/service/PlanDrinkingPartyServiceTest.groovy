package jp.co.biglobe.warikan.service

import jp.co.biglobe.warikan.datasource.mock.MockDrinkingPartyRepository
import jp.co.biglobe.warikan.domain.amount.Amount
import jp.co.biglobe.warikan.domain.drinking_party.*
import jp.co.biglobe.warikan.domain.payment.SettingsOfRatioOfPaymentOfPaymentClassification
import spock.lang.Specification

class PlanDrinkingPartyServiceTest extends Specification {
    def planTest() {
        setup:
        DrinkingPartyRepository mockDrinkingPartyRepository = new MockDrinkingPartyRepository()
        PlanDrinkingPartyService sut = new PlanDrinkingPartyService(mockDrinkingPartyRepository)

        when:
        sut.plan(new AmountOfBill(new Amount(2110)))
        DrinkingParty drinkingParty = mockDrinkingPartyRepository.drinkingPartyOf(new DrinkingPartyId(1))

        then:
        drinkingParty.drinkingPartyId == new DrinkingPartyId(1)
        drinkingParty.amountOfBill == new AmountOfBill(new Amount(2110))
        drinkingParty.members == new Members()
        drinkingParty.settingsOfRatioOfPaymentOfPaymentClassification == new SettingsOfRatioOfPaymentOfPaymentClassification()
    }
}
