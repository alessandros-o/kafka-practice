package com.alessandro.strproducer.controller.impl;

import com.alessandro.strproducer.controller.PaymentController;
import com.alessandro.strproducer.model.Payment;
import com.alessandro.strproducer.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
@RequiredArgsConstructor
public class PaymentControllerImpl implements PaymentController {

    private final PaymentService service;

    @Override
    public ResponseEntity<Payment> payment(Payment payment) throws InterruptedException {
        service.sendPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
