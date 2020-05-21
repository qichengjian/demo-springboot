package com.demo.bus.service;

import com.demo.bus.event.UserRegisterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author qichengjian
 */
@Service
public class CouponService {

    @EventListener
    public void addCoupon(UserRegisterEvent event) {
        System.out.println("给用户发送优惠券中：" + event.getUsername()+event.getTimestamp());
    }
}
