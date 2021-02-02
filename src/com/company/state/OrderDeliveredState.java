package com.company.state;


import com.company.businessProcess.Order;

public class OrderDeliveredState implements State
{
    private final Order order;

    public OrderDeliveredState(Order order)
    {
        this.order = order;
    }

    @Override
    public void nextPhase()
    {
        //do nothing as this is end of the state
    }

    @Override
    public void getState()
    {

    }
}
