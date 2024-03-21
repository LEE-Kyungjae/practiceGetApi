package com.lkj.getapi.mosquito;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String message;


    @OneToOne(mappedBy = "result")
    private MosquitoStatusResponse mosquitoStatusResponse;
}
