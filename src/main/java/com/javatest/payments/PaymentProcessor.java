package com.javatest.payments;

public class PaymentProcessor {

    private PaymentGateWay paymentGateWay;
    public PaymentProcessor(PaymentGateWay paymentGateWay){
        this.paymentGateWay = paymentGateWay;
    }
    public boolean makePayment(double amount) {

        PaymnetResponse response = paymentGateWay.requestPayment(new PaymentRequest(amount));
        if (response.getStatus() == PaymnetResponse.PaymentStatus.ok) {
            return true;
        } else {
            return false;
        }
    }
}
