package com.company.state;


import com.company.businessProcess.Order;

public class OrderReadyForDeliveryState implements State
{
    private final Order order;

    public OrderReadyForDeliveryState(Order order)
    {
        this.order=order;
    }


    @Override
    public void nextPhase()
    {
        System.out.println("Out for delivery...");
        order.setState(new OrderOutForDeliveryState(order));
    }

    @Override
    public void getState()
    {

    }
}
