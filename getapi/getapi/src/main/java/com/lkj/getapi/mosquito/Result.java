package com.lkj.getapi.mosquito;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Result {
    private String code;
    private String message;
}
