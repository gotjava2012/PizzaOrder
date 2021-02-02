package com.company.state;


import com.company.domain.Pizza;

public class PizzaCookedState implements State
{
    Pizza pizza;
    public PizzaCookedState(Pizza pizza)
    {
        this.pizza = pizza;
    }

    @Override
    public void nextPhase()
    {
        System.out.println("Out For Delivery...");
        pizza.setState(new PizzaCompleteState(pizza));
    }

    @Override
    public void getState()
    {

    }
}
