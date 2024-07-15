package com.alessandro.strconsumer.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Payment implements Serializable {

    private Long id;
    private Long idUser;
    private Long idProduct;
    private String cardNumber;

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idProduct=" + idProduct +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
