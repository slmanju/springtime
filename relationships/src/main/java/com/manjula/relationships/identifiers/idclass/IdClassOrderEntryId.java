package com.manjula.relationships.identifiers.idclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data @EqualsAndHashCode
@Embeddable
public class IdClassOrderEntryId implements Serializable {

    private long orderId;
    private long productId;

}
