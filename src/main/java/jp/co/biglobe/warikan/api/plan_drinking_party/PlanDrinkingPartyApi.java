package jp.co.biglobe.warikan.api.plan_drinking_party;

import jp.co.biglobe.warikan.domain.amount.Amount;
import jp.co.biglobe.warikan.domain.payment.AmountOfBill;
import jp.co.biglobe.warikan.domain.drinking_party.DrinkingParty;
import jp.co.biglobe.warikan.service.PlanDrinkingPartyService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlanDrinkingPartyApi {

    @NonNull
    private PlanDrinkingPartyService planDrinkingPartyService;

    @PostMapping("/drinking_parties")
    public PlanDrinkingPartyResponse plan(PlanDrinkingPartyRequest request) {
        DrinkingParty drinkingParty = planDrinkingPartyService.plan(new AmountOfBill(new Amount(request.getBillingAmount())));
        return new PlanDrinkingPartyResponse(drinkingParty.getDrinkingPartyId().getDrinkingPartyId());
    }
}
