package com.jim.web;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderLine {
    private String item;
    private int quantity;
    private BigDecimal unitPrice;
}
