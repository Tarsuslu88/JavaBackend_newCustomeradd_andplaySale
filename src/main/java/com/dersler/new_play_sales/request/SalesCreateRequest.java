package com.dersler.new_play_sales.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesCreateRequest {

    //int id;
    int salesQuantity;
    int customerId;
    int gameId;
    String gameName;


}
