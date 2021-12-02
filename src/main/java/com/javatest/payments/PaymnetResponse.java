package com.javatest.payments;

public class PaymnetResponse {
    enum PaymentStatus{
        ok, error
    }
    private PaymentStatus status;

    public PaymnetResponse(PaymentStatus status){
        this.status = status;
    }

    public PaymentStatus getStatus(){
        return status;
    }
}

