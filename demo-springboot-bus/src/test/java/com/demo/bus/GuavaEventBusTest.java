package com.demo.bus;

import com.demo.bus.guava.PaymentSuccessfulEvent;
import com.demo.bus.guava.PaymentSuccessfulListener;
import com.google.common.eventbus.EventBus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GuavaEventBusTest {

    private PaymentSuccessfulListener listener;
    private EventBus eventBus;

    @Before
    public void start() {
        eventBus = new EventBus();
        listener = new PaymentSuccessfulListener();

        eventBus.register(listener);
    }

    @After
    public void end() {
        eventBus.unregister(listener);
    }

    @Test
    public void test01() {
        PaymentSuccessfulEvent event = new PaymentSuccessfulEvent();
        event.setAction("payment successful event");

        eventBus.post(event);


    }
}
