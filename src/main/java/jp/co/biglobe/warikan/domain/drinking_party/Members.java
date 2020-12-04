package jp.co.biglobe.warikan.domain.drinking_party;

import jp.co.biglobe.warikan.domain.payment.NumberOfAllMembers;
import jp.co.biglobe.warikan.domain.person.PersonId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings("serial")
public class Members implements Serializable {
    private Map<PersonId, Member> members;

    public Members() {
        members = new HashMap<>();
    }

    public Members attend(Member member) {
        Map<PersonId, Member> newMembers = new HashMap<>();
        newMembers.putAll(members);
        newMembers.put(member.getPersonId(), member);
        return new Members(newMembers);
    }

    public NumberOfAllMembers numberOfAllMembers() {
        NumberOfAllMembers numberOfAllMembers = new NumberOfAllMembers();

        for (Map.Entry<PersonId, Member> entry : members.entrySet()) {
            numberOfAllMembers = numberOfAllMembers.increment(entry.getValue().getPaymentClassification());
        }

        return numberOfAllMembers;
    }
}
