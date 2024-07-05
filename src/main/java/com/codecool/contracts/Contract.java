package com.codecool.contracts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    private long id;
    private double grossPrice;
    private double netPrice;
    private long customerId;
}
