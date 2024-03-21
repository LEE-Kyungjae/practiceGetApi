package com.lkj.getapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mosquito {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


}
