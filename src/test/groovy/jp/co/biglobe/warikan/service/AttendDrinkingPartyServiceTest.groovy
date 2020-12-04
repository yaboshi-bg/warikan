package jp.co.biglobe.warikan.service

import jp.co.biglobe.warikan.datasource.mock.MockDrinkingPartyRepository
import jp.co.biglobe.warikan.domain.amount.Amount
import jp.co.biglobe.warikan.domain.drinking_party.*
import jp.co.biglobe.warikan.domain.payment.PaymentClassification
import jp.co.biglobe.warikan.domain.payment.SettingsOfRatioOfPaymentOfPaymentClassification
import jp.co.biglobe.warikan.domain.person.PersonId
import spock.lang.Specification

class AttendDrinkingPartyServiceTest extends Specification {
    def attendTest() {
        setup:
        DrinkingPartyRepository mockDrinkingPartyRepository = new MockDrinkingPartyRepository()
        AttendDrinkingPartyService sut = new AttendDrinkingPartyService(mockDrinkingPartyRepository)

        DrinkingParty drinkingParty = DrinkingParty.plan(new DrinkingPartyId(1), new AmountOfBill(new Amount(2110)))
        mockDrinkingPartyRepository.store(drinkingParty)

        when:
        sut.attend(new DrinkingPartyId(1), new Member(new PersonId(1), PaymentClassification.LARGE))
        DrinkingParty storedDrinkingParty = mockDrinkingPartyRepository.drinkingPartyOf(new DrinkingPartyId(1))

        then:
        storedDrinkingParty.drinkingPartyId == new DrinkingPartyId(1)
        storedDrinkingParty.amountOfBill == new AmountOfBill(new Amount(2110))
        storedDrinkingParty.members == new Members().attend(new Member(new PersonId(1), PaymentClassification.LARGE))
        storedDrinkingParty.settingsOfRatioOfPaymentOfPaymentClassification == new SettingsOfRatioOfPaymentOfPaymentClassification()
    }
}
