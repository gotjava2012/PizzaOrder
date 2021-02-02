package com.company.state;


import com.company.domain.Pizza;

public class PizzaCompleteState implements State
{
    private final Pizza pizza;

    public PizzaCompleteState(Pizza pizza)
    {
        this.pizza = pizza;
    }


    @Override
    public void nextPhase()
    {
        //do nothing as this is end of any state
    }

    @Override
    public void getState()
    {

    }
}
