package com.alessandro.strproducer.service;

import com.alessandro.strproducer.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment) throws InterruptedException;
}
