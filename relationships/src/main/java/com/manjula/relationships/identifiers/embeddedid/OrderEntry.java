package com.manjula.relationships.identifiers.embeddedid;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "identifiers_embedded_order_entry")
public class OrderEntry {

    @EmbeddedId
    private OrderEntryId id;

    private int quantity;

}
