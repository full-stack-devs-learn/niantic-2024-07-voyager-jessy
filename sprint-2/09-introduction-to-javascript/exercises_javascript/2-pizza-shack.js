﻿/*
1.	Pizza Shack sells the best pizza in town.

	When customers are ready to order, they should
	be able to see a list of toppings that are 
	included on each type of pizza.

	getToppings("Hawaiian") => ["Ham","Pineapple","Mushroom"]
	getToppings("Cowboy") => ["Pepperoni", "Sausage", "Beef"]
	getToppings("Supreme") => ["Pepperoni", "Sausage", "Pepper", "Onion", "Black Olives"]
	getToppings("Vegetarian") => ["Spinach", "Zucchini", "Mushroom", "Artichoke", "Tomato", "Onion"]
	getToppings("Cheese") => ["Cheese"]

*/

function getToppings(pizza) {

	const toppings = {
		hawaiian: ["Ham", "Pineapple", "Mushroom"],
		cowboy: ["Pepperoni", "Sausage", "Beef"],
		supreme: ["Pepperoni", "Sausage", "Pepper", "Onion", "Black Olives"],
		vegetarian: ["Spinach", "Zucchini", "Mushroom", "Artichoke", "Tomato", "Onion"],
		cheese: ["Cheese"]

	}

	const newPizza = pizza.toLowerCase();


	return toppings[newPizza] || [];




}




/*
2.	Pizza Shack sells the best pizza in town.

	When a customer places an order we make the pizza.
	the makePizza function should return a 
	pizza object with a name, and the list of toppings.

	makePizza("Hawaiian") => {
								name: "Hawaiian",
								toppings: ["Ham","Pineapple","Mushroom"]
							}

*/

function makePizza(pizza) {

	if(pizza)
	{
		const toppings = getToppings(pizza)
		const pizzaInfo = {
						name: pizza,
						toppings
		};
		return  pizzaInfo;
	}
	return {};
	

}





/*
3.	Pizza Shack sells the best custom pizza in town.

	If a customer wants to order a custom pizza they
	can order up to 3 toppings. The makeCustom function
	should create the new pizza as follows...

	makeCustom("chicken") => 
					{
						name: "Custom",
						toppings: ["chicken"]
					}

	makeCustom("chicken", "mushroom") => 
					{
						name: "Custom",
						toppings: ["chicken", "mushroom"]
					}

	makeCustom("chicken", "mushroom", "artichokes") => 
					{
						name: "Custom",
						toppings: ["chicken", "mushroom", "artichokes"]
					}

	// a custom order with no toppings is not allowed an should return
	// an empty object
	makeCustom() => {}

// */



function makeCustom(topping1, topping2, topping3) 
{
		const name = "Custom";
		
	//possible solve #1 for longer form
		// if(topping1 && topping2 && topping3)
		// {
		// 	return{
		// 		name: name, 
		// 		toppings: [topping1, topping2, topping3]
		// 	}
		// }
		// else if(topping1 && topping2)
		// {
		// 	return {
		// 		name: name,
		// 		toppings: [topping1, topping2]
		// 	}
		// }
		// else if(topping1)
		// {
		// 	return {
		// 		name: name,
		// 		toppings: [topping1]
		// 	}
		// }
		// return{};
	

//solve for shorter form
		if(arguments.length == 0)
		{
			return {}

		}
		return {
			name: "Custom",
			toppings: [...arguments]
		}
		
}




/*
4.	Customers may want to order multiple pizzas on a single order.

	When a customer places an order you should create an order object.
	This includes the customer name, and an array of all the pizzas
	that they have ordered.

	createOrder("Gary", true, false, false, false, false) => 
		{
			customer: "Gary",
			pizzas: [
				{
					name: "Hawaiian",
					toppings: [
						"Ham",
						"Pineapple",
						"Mushroom"
					]
				}
			]
		}
	

	createOrder("Gary", true, false, false, false, true) => 
		{
			customer: "Gary",
			pizzas: [
				{
					name: "Hawaiian",
					toppings: [
						"Ham",
						"Pineapple",
						"Mushroom"
					]
				},
				{
					name: "Cheese",
					toppings: [
						"Cheese"
					]
				}
			]
		}


*/

function createOrder(customer, hawaiian, cowboy, supreme, vegetarian, cheese)
{
	// const pizzaOfferings = getToppings(pizza);
	const customerOrder = {

		customer: customer,
		pizzas: []

	};

	if(hawaiian){
		customerOrder.pizzas.push({
			name: "Hawaiian",
			toppings: getToppings("hawaiian")
		})
	};
	if(cowboy){
		customerOrder.pizzas.push({
			name: "Cowboy",
			toppings: getToppings("cowboy")
		})
	};
	if(supreme){
		customerOrder.pizzas.push({
			name: "Supreme",
			toppings: getToppings("supreme")
		})
	};
	if(vegetarian){
		customerOrder.pizzas.push({
			name: "Vegetarian",
			toppings: getToppings("vegetarian")
		})
	};
	if(cheese){
		customerOrder.pizzas.push({
			name: "Cheese",
			toppings: getToppings("cheese")
		})
	};
	if(customerOrder.pizzas.length == 0){
		return {};
	}

	

	return customerOrder;







}
