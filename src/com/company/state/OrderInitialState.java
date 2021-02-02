package com.company.state;


import com.company.businessProcess.Order;

public class OrderInitialState implements State
{
    private final Order order;

    public OrderInitialState(Order order)
    {
        this.order = order;
    }

    @Override
    public void nextPhase()
    {
        System.out.println("Placing the order....");
        order.setState(new OrderPlacedState(order));
    }

    @Override
    public void getState()
    {

    }
}
