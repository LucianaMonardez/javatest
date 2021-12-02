package com.javatest.payments;

public interface PaymentGateWay {

    PaymnetResponse requestPayment(PaymentRequest request);

}
