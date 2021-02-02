package com.company.state;


import com.company.businessProcess.Order;

public class OrderPlacedState implements State
{
    private final Order order;

    public OrderPlacedState(Order order)
    {
        this.order = order;
    }

    @Override
    public void nextPhase()
    {
        System.out.println("Ready for delivery state...");
        order.setState(new OrderReadyForDeliveryState(order));
    }

    @Override
    public void getState()
    {

    }
}
