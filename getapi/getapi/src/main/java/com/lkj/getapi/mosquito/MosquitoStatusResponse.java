package com.lkj.getapi.mosquito;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class MosquitoStatusResponse {

    private int listTotalCount;
    private Result result;
    private List<Row> row;

}
