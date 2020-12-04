package jp.co.biglobe.warikan.domain.person;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@SuppressWarnings("serial")
public class PersonId implements Serializable {
    @Getter
    private int personId;
}
