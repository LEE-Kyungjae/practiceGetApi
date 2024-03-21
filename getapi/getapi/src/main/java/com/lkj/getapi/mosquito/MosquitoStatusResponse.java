package com.lkj.getapi.mosquito;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "mosquito_data")
public class MosquitoStatusResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int listTotalCount;
    @OneToOne(cascade = CascadeType.ALL)
    private Result result;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mosquito_status_response_id")
    private List<Row> rows;
}
