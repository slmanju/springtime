package com.manjula.relationships.identifiers.embeddedid;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data @EqualsAndHashCode
@Embeddable
public class OrderEntryId implements Serializable {

    private long orderId;
    private long productId;

}
