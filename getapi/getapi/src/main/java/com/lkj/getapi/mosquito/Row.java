package com.lkj.getapi.mosquito;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mosquito_row")
@Getter
@Setter
public class Row {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mosquitoDate;
    private String mosquitoValueWater;
    private String mosquitoValueHouse;
    private String mosquitoValuePark;

    @ManyToOne
    private MosquitoStatusResponse mosquitoStatusResponse;

}