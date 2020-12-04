package jp.co.biglobe.warikan.api.calculate_payment;

import jp.co.biglobe.warikan.domain.amount.Amount;
import jp.co.biglobe.warikan.domain.drinking_party.AmountOfBill;
import jp.co.biglobe.warikan.domain.drinking_party.DrinkingParty;
import jp.co.biglobe.warikan.domain.payment.PaymentClassification;
import jp.co.biglobe.warikan.domain.payment.RatioOfPayment;
import jp.co.biglobe.warikan.domain.payment.SettingOfRatioOfPaymentOfPaymentClassification;
import jp.co.biglobe.warikan.domain.payment.SettingsOfRatioOfPaymentOfPaymentClassification;
import jp.co.biglobe.warikan.domain.payment.SplitBillResult;
import jp.co.biglobe.warikan.service.PlanDrinkingPartyService;
import jp.co.biglobe.warikan.service.SplitBillService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculatePaymentApi {

    @NonNull
    private PlanDrinkingPartyService planDrinkingPartyService;

    @NonNull
    private SplitBillService billSplitService;

    @PutMapping("/payment/calculate")
    public CalculatePaymentResponse calculate(CalculatePaymentRequest request) {
        DrinkingParty drinkingParty = planDrinkingPartyService.plan(new AmountOfBill(new Amount(request.getBillingAmount())));

        SettingsOfRatioOfPaymentOfPaymentClassification settingsOfRatioOfPaymentOfPaymentClassification = new SettingsOfRatioOfPaymentOfPaymentClassification()
                .changeSetting(new SettingOfRatioOfPaymentOfPaymentClassification(PaymentClassification.LARGE, new RatioOfPayment(request.getLargeRatio())))
                .changeSetting(new SettingOfRatioOfPaymentOfPaymentClassification(PaymentClassification.MEDIUM, new RatioOfPayment(request.getMediumRatio())))
                .changeSetting(new SettingOfRatioOfPaymentOfPaymentClassification(PaymentClassification.SMALL, new RatioOfPayment(request.getSmallRatio())));

        SplitBillResult splitBillResult = billSplitService.split(
                drinkingParty.getDrinkingPartyId(),
                settingsOfRatioOfPaymentOfPaymentClassification
        );

        return new CalculatePaymentResponse(
                splitBillResult.getAmountOfPaymentOfAllMembers().amountOfPaymentOf(PaymentClassification.LARGE).getAmount(),
                splitBillResult.getAmountOfPaymentOfAllMembers().amountOfPaymentOf(PaymentClassification.MEDIUM).getAmount(),
                splitBillResult.getAmountOfPaymentOfAllMembers().amountOfPaymentOf(PaymentClassification.SMALL).getAmount(),
                splitBillResult.getBalanceDue().getAmount().getAmount()
        );
    }
}
