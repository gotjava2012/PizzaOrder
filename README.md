Business scenario:
A dine-in pizza shop plans to implement a software solution to optimize the processes of ordering and baking pizzas.
Each table in the dining area will have a client terminal that allows customers to place orders.

The baking will be done by one of the two ovens available (allow for future increase of baking capacity by adding new ovens), in a first come - first served fashion.

Requirements:
- Implement a client-server solution, in which the customer uses the terminal (command line interface) to place the order.
- The orders will be handled by a back end server. Client server communication will be over an HTTP connection.
- The server will read the toppings and quantities from a csv file (inventory.csv, provided) when the server application is first started.
- The server distributes the baking tasks to whichever oven becomes available first, or randomly if both ovens are available.
- The system accepts orders interactively. An order consists of one or more pizzas. For each pizza, the customers should be able to choose different quantities from the available topping (e.g. 2 mushrooms, 1 cheese etc, 1 tomato).
- Ingredient quantities should be updated as new orders are being submitted. Immediately notify users when ingredients are no longer available in the desired quantities.
- Simulate the baking process in the background. Baking time needs to be configurable (e.g. 30 seconds).
- Notify the user (via the same terminal used for placing the order) as soon as the baking process is completed for each individual pizza.
- The system should handle multiple customers simultaneously.
- Optional: Allow the user to place another order while the previous order is being executed.
- Optional: On the client terminal, display a countdown timer with the time left until the entire order is completed.

Deliverables:
- the whole project as a zip file, Alternatively, provide a link to github or similar repository.
- zip archives containing the executable jars and config files for the server and client components.
- both server and client apps should be executed form the command line (java -jar etc).
- design notes, as seen fit.

Features:
- Has an order management system which ensures that all orders are baked and delivered
- Uses multi-threading
- Uses state pattern for tracking the state of the order

How to run the program:
- There is a simple command line interface defined by PizzaMain you will need to pass in the csv as an argument to run the application
- An unit test StoreManagerTest

