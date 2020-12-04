package jp.co.biglobe.warikan.domain.payment;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class NumberOfMembers {
    @Getter
    private int numberOfMembers;

    public NumberOfMembers(int numberOfMembers) {
        if (numberOfMembers < 0) {
            throw new IllegalArgumentException("参加人数は0未満にできません。");
        }
        this.numberOfMembers = numberOfMembers;
    }

    static NumberOfMembers zero() {
        return new NumberOfMembers(0);
    }

    public NumberOfMembers increment() {
        return new NumberOfMembers(++numberOfMembers);
    }
}
