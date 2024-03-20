package com.lkj.getapi.mosquito;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Row {
    private String mosquitoDate;
    private String mosquitoValueWater;
    private String mosquitoValueHouse;
    private String mosquitoValuePark;
}
