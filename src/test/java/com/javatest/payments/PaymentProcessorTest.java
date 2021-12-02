package com.javatest.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    private PaymentGateWay paymentGateway;
    private PaymentProcessor paymentProcessor;

    @Before
    public void setup(){
        paymentGateway = Mockito.mock(PaymentGateWay.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }
    @Test
    public void payment_is_correct() {
//preparacion del esenario

        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymnetResponse(PaymnetResponse.PaymentStatus.ok));
//preparqacion de los objetos
        //PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);
//preparacion de los metodos  a utlizar
        assertTrue(paymentProcessor.makePayment(1000));
    }


    @Test
    public void payment_is_wrong() {

        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymnetResponse(PaymnetResponse.PaymentStatus.error));



        assertFalse(paymentProcessor.makePayment(1000));
    }
}