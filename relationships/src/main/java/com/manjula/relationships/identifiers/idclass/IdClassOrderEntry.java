package com.manjula.relationships.identifiers.idclass;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "identifiers_idclass_order_entry")
@IdClass(IdClassOrderEntryId.class)
public class IdClassOrderEntry {

    @Id
    private long orderId;
    @Id
    private long productId;

    private int quantity;

}
