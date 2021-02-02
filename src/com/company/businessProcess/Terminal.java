package com.company.businessProcess;


import com.company.domain.PizzaType;
import com.company.domain.Topping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Terminal implements Runnable 
{

	private final Store store;

	public Terminal(Store store)
	{
		this.store = store;
	}

	@Override
	public void run() 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Pizza Delivery System: ");
		System.out.println("Place Order: ");

		int choice=0;
		int customerId = 0;
		Order order = new Order(customerId++);
		while (choice < 8)
		{
			System.out.println("1. Pizza 4. Cancel Order 5. Place Order 6. Print Order 7. Close Store");
			if (scanner.hasNext())
			{
				choice = scanner.nextInt();
				System.out.println("Selected Choice: "+ choice);
				switch(choice)
				{
					case 1:
						int answer = 0;
						List<Topping> toppingsList = new ArrayList<Topping>();
						while (answer < 8){
							System.out.println("What toppings would you like on your pizza? \n" +
									"\tCHEESE(1),\n" +
									"\tSAUSAGE(2),\n" +
									"\tMUSHROOM(3),\n" +
									"\tPINEAPPLE(4),\n" +
									"\tHAM(5),\n" +
									"\tJALAPENO(6),\n" +
									"\tPEPPERONI(7)");
							System.out.println("to Exit enter a number greater than 7");
							answer = scanner.nextInt();
							if(answer > 7) break;
							String[] toppings = {"CHEESE","SAUSAGE","MUSHROOM","PINEAPPLE","HAM","JALAPENO","PEPPERONI"};
							int index = answer - 1;
							System.out.println("Selected choice: "+ Topping.valueOf(toppings[index]));
							toppingsList.add(Topping.valueOf(toppings[index] ));
						}

						order.addLargePizza(PizzaType.THIN_CRUST, toppingsList, 1);
						System.out.println("Adding pizza to the order with the following toppings :" + toppingsList.toString());
						break;

					case 2:

						break;

					case 3:

						break;

					case 4:
						order.cancelAll();
						break;

					case 5:
						store.getStoreManager().addOrder(order);
						order = new Order(customerId++);
						System.out.println("Size of orderlist: " + store.getStoreManager().getSize());

						if (store.isCloseStore())
						{
							System.out.println("Store is closed and hence exiting terminal...");
							return;
						}
						choice = 8;
						break;

					case 6:
						order.printOrder();
						break;
					case 7:
						try
						{
							store.getStoreManager().closeStore();
						} catch (InterruptedException e)
						{
							e.printStackTrace();
						}
						break;
				}
			}
		}
		System.out.println("Thank you for placing the order!!");
		scanner.close();
	}
}


