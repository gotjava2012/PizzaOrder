package com.company.state;


import com.company.businessProcess.Order;

public class OrderOutForDeliveryState implements State
{
    private final Order order;

    public OrderOutForDeliveryState(Order order)
    {
        this.order = order;
    }

    @Override
    public void nextPhase()
    {
        System.out.println("Order Delivered...");
        order.setState(new OrderDeliveredState(order));
    }

    @Override
    public void getState()
    {

    }
}
