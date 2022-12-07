package com.example.db03_ship_20221201.searchBody;

import lombok.Data;

@Data
public class ShipTypeSearchBody {
    private String shipTypeKeyword;
    private Integer currentPage;

}
