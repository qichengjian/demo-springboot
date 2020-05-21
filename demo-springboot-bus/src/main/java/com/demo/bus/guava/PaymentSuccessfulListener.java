package com.demo.bus.guava;

import com.google.common.eventbus.Subscribe;

public class PaymentSuccessfulListener {

    @Subscribe
    public void paymentEvent(PaymentSuccessfulEvent event) {
        System.out.println("支付成功");
    }
}
