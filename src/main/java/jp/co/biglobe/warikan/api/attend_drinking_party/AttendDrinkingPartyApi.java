package jp.co.biglobe.warikan.api.attend_drinking_party;

import jp.co.biglobe.warikan.domain.drinking_party.DrinkingPartyId;
import jp.co.biglobe.warikan.domain.drinking_party.Member;
import jp.co.biglobe.warikan.domain.payment.PaymentClassification;
import jp.co.biglobe.warikan.domain.person.PersonId;
import jp.co.biglobe.warikan.service.AttendDrinkingPartyService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AttendDrinkingPartyApi {

    @NonNull
    private AttendDrinkingPartyService attendDrinkingPartyService;

    @PutMapping("/drinking_parties/{drinking_party_id}/attend")
    public AttendDrinkingPartyResponse attend(@PathVariable("drinking_party_id") int drinkingPartyId, AttendDrinkingPartyRequest request) {
        Member member = new Member(new PersonId(request.getPersonId()), PaymentClassification.valueOf(request.getPaymentClassification()));
        attendDrinkingPartyService.attend(new DrinkingPartyId(drinkingPartyId), member);
        return new AttendDrinkingPartyResponse();
    }
}
