package jp.co.biglobe.warikan.domain.drinking_party;

import jp.co.biglobe.warikan.domain.payment.BillSplitter;
import jp.co.biglobe.warikan.domain.payment.NumberOfAllMembers;
import jp.co.biglobe.warikan.domain.payment.SettingsOfRatioOfPaymentOfPaymentClassification;
import jp.co.biglobe.warikan.domain.payment.SplitBillResult;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings("serial")
public class DrinkingParty implements Serializable {
    @Getter
    private DrinkingPartyId drinkingPartyId;
    @Getter
    private AmountOfBill amountOfBill;
    @Getter
    private Members members;
    @Getter
    private SettingsOfRatioOfPaymentOfPaymentClassification settingsOfRatioOfPaymentOfPaymentClassification;

    public static DrinkingParty plan(
            DrinkingPartyId drinkingPartyId,
            AmountOfBill amountOfBill
    ) {
        DrinkingParty drinkingParty = new DrinkingParty();
        drinkingParty.drinkingPartyId = drinkingPartyId;
        drinkingParty.amountOfBill = amountOfBill;
        drinkingParty.members = new Members();
        drinkingParty.settingsOfRatioOfPaymentOfPaymentClassification = new SettingsOfRatioOfPaymentOfPaymentClassification();
        return drinkingParty;
    }

    public void attend(Member member) {
        members = members.attend(member);
    }

    public void changeSettingsOfRatioOfPaymentOfPaymentClassification(SettingsOfRatioOfPaymentOfPaymentClassification settingsOfRatioOfPaymentOfPaymentClassification) {
        this.settingsOfRatioOfPaymentOfPaymentClassification = settingsOfRatioOfPaymentOfPaymentClassification;
    }

    public SplitBillResult splitBill() {
        return BillSplitter.split(amountOfBill, numberOfAllMembers(), settingsOfRatioOfPaymentOfPaymentClassification);
    }

    public NumberOfAllMembers numberOfAllMembers() {
        return members.numberOfAllMembers();
    }
}
