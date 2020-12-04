package jp.co.biglobe.warikan.service

import jp.co.biglobe.warikan.datasource.mock.MockDrinkingPartyRepository
import jp.co.biglobe.warikan.domain.amount.Amount
import jp.co.biglobe.warikan.domain.drinking_party.*
import jp.co.biglobe.warikan.domain.payment.*
import jp.co.biglobe.warikan.domain.person.PersonId
import spock.lang.Specification

class SplitBillServiceTest extends Specification {
    def splitTest() {
        setup:
        DrinkingPartyRepository mockDrinkingPartyRepository = new MockDrinkingPartyRepository()
        SplitBillService sut = new SplitBillService(mockDrinkingPartyRepository)

        DrinkingParty drinkingParty = DrinkingParty.plan(new DrinkingPartyId(1), new AmountOfBill(new Amount(2110)))
        drinkingParty.attend(new Member(new PersonId(1), PaymentClassification.LARGE))
        drinkingParty.attend(new Member(new PersonId(2), PaymentClassification.LARGE))
        drinkingParty.attend(new Member(new PersonId(3), PaymentClassification.MEDIUM))
        drinkingParty.attend(new Member(new PersonId(4), PaymentClassification.MEDIUM))
        drinkingParty.attend(new Member(new PersonId(5), PaymentClassification.SMALL))
        drinkingParty.attend(new Member(new PersonId(6), PaymentClassification.SMALL))
        mockDrinkingPartyRepository.store(drinkingParty)

        SettingsOfRatioOfPaymentOfPaymentClassification settingsOfRatioOfPaymentOfPaymentClassification = new SettingsOfRatioOfPaymentOfPaymentClassification()
                .changeSetting(new SettingOfRatioOfPaymentOfPaymentClassification(PaymentClassification.LARGE, new RatioOfPayment(5)))
                .changeSetting(new SettingOfRatioOfPaymentOfPaymentClassification(PaymentClassification.MEDIUM, new RatioOfPayment(3)))
                .changeSetting(new SettingOfRatioOfPaymentOfPaymentClassification(PaymentClassification.SMALL, new RatioOfPayment(2)))

        when:
        SplitBillResult splitBillResult = sut.split(new DrinkingPartyId(1), settingsOfRatioOfPaymentOfPaymentClassification)

        then:
        splitBillResult.amountOfPaymentOfAMemberOf(PaymentClassification.LARGE) == new Amount(500)
        splitBillResult.amountOfPaymentOfAMemberOf(PaymentClassification.MEDIUM) == new Amount(300)
        splitBillResult.amountOfPaymentOfAMemberOf(PaymentClassification.SMALL) == new Amount(200)
        splitBillResult.balanceDue.amount == new Amount(110)
    }
}

