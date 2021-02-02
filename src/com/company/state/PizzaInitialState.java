package com.company.state;


import com.company.domain.Pizza;

public class PizzaInitialState implements State
{
    Pizza pizza;

    public PizzaInitialState(Pizza pizza)
    {
        this.pizza = pizza;
    }

    @Override
    public void nextPhase()
    {
        System.out.println("Baking...");
        pizza.setState(new PizzaCookedState(pizza));
    }

    @Override
    public void getState()
    {

    }
}
