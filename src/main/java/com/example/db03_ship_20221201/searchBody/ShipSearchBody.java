package com.example.db03_ship_20221201.searchBody;

import com.example.db03_ship_20221201.entity.ShipType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ShipSearchBody {
    private BigDecimal minPrice;
    private BigDecimal maxPrice;

    //前端在全选时不传, 代表所有类型都可以
    private List<Integer> shipTypes;

    private String shipNameSearchString;

//    private Boolean shipNameExact;
    private String shipNumberSearchString;

//    private Boolean shipNumberExact;
    private Boolean isPage;
}

