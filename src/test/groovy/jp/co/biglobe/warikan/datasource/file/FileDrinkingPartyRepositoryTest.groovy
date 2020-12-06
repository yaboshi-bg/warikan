package jp.co.biglobe.warikan.datasource.file

import jp.co.biglobe.warikan.domain.amount.Amount
import jp.co.biglobe.warikan.domain.payment.AmountOfBill
import jp.co.biglobe.warikan.domain.drinking_party.DrinkingParty
import jp.co.biglobe.warikan.domain.drinking_party.DrinkingPartyId
import jp.co.biglobe.warikan.domain.drinking_party.Member
import jp.co.biglobe.warikan.domain.drinking_party.Members
import jp.co.biglobe.warikan.domain.payment.PaymentClassification
import jp.co.biglobe.warikan.domain.payment.SettingsOfRatioOfPaymentOfPaymentClassification
import jp.co.biglobe.warikan.domain.person.PersonId
import spock.lang.Specification

class FileDrinkingPartyRepositoryTest extends Specification {
    def storeTest() {
        setup:
        FileDrinkingPartyRepository sut = new FileDrinkingPartyRepository()

        when:
        DrinkingParty drinkingParty = new DrinkingParty()
        drinkingParty.drinkingPartyId = drinkingPartyId
        drinkingParty.amountOfBill = amountOfBill
        drinkingParty.members = members
        drinkingParty.settingsOfRatioOfPaymentOfPaymentClassification = settingsOfRatioOfPaymentOfPaymentClassification
        sut.store(drinkingParty)

        then:
        DrinkingParty storedDrinkingParty = sut.drinkingPartyOf(drinkingPartyId)
        storedDrinkingParty.drinkingPartyId == drinkingPartyId
        storedDrinkingParty.amountOfBill == amountOfBill
        storedDrinkingParty.members == members
        storedDrinkingParty.settingsOfRatioOfPaymentOfPaymentClassification == settingsOfRatioOfPaymentOfPaymentClassification

        cleanup:
        sut.refresh()

        where:
        drinkingPartyId        | amountOfBill                       | members                                                                        | settingsOfRatioOfPaymentOfPaymentClassification
        new DrinkingPartyId(1) | new AmountOfBill(new Amount(1000)) | new Members().attend(new Member(new PersonId(1), PaymentClassification.LARGE)) | new SettingsOfRatioOfPaymentOfPaymentClassification()
    }

    def nextIdentityTest() {
        setup:
        FileDrinkingPartyRepository sut = new FileDrinkingPartyRepository()

        expect:
        sut.nextIdentity() != sut.nextIdentity()

        cleanup:
        sut.refresh()

    }
}
