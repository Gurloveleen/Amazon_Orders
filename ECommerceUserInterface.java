import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

// Simulation of a Simple E-Commerce System (like Amazon)

public class ECommerceUserInterface
{
	public static void main(String[] args)
	{
		// Create the system
		ECommerceSystem amazon = new ECommerceSystem();

		Scanner scanner = new Scanner(System.in);
		System.out.print(">");
		
		// Process keyboard actions
		while (scanner.hasNextLine())
		{
			String action = scanner.nextLine();
			
			if (action == null || action.equals("")) 
			{
				System.out.print("\n>");
				continue;
			}
			else if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT"))
				return;

			else if (action.equalsIgnoreCase("PRODS"))	// List all products for sale
			{
				amazon.printAllProducts(); 
			}
			else if (action.equalsIgnoreCase("BOOKS"))	// List all books for sale
			{
				amazon.printAllBooks(); 
			}
			else if (action.equalsIgnoreCase("CUSTS")) 	// List all registered customers
			{
				amazon.printCustomers();	
			}
			else if (action.equalsIgnoreCase("ORDERS")) // List all current product orders
			{
				amazon.printAllOrders();	
			}
			else if (action.equalsIgnoreCase("SHIPPED"))	// List all orders that have been shipped
			{
				amazon.printAllShippedOrders();	
			}
			else if (action.equalsIgnoreCase("NEWCUST"))	// Create a new registered customer
			{
				String name = "";
				String address = "";
				
				System.out.print("Name: ");
				if (scanner.hasNextLine())
					name = scanner.nextLine();
				
				System.out.print("\nAddress: ");
				if (scanner.hasNextLine())
					address = scanner.nextLine();
				
				boolean success = amazon.createCustomer(name, address);
				if (!success)
				{
					System.out.println(amazon.getErrorMessage());
				}
			}
			else if (action.equalsIgnoreCase("SHIP"))	// ship an order to a customer
			{
				String orderNumber = "";

				System.out.print("Order Number: ");// asking user to give the order number
				// Get order number from scanner
				orderNumber = scanner.nextLine(); // taking the String input for order number

				// Ship order to customer (see ECommerceSystem for the correct method to use
				ProductOrder shipped_order = amazon.shipOrder(orderNumber);
				if(shipped_order != null)
					shipped_order.print();
			}
			else if (action.equalsIgnoreCase("CUSTORDERS")) // List all the current orders and shipped orders for this customer id
			{
				String customerId = "";

				System.out.print("Customer Id: ");
				// Get customer Id from scanner
				customerId = scanner.nextLine();// getting customer id from user
				// Print all current orders and all shipped orders for this customer
				if(!amazon.printOrderHistory(customerId))
					System.out.println(amazon.getErrorMessage());


			}
			else if (action.equalsIgnoreCase("ORDER")) // order a product for a certain customer
			{
				String productId = "";
				String customerId = "";
				String options = "";

				System.out.print("Product Id: ");
			  // Get product Id from scanner
				productId = scanner.nextLine();

				System.out.print("\nCustomer Id: ");
			  // Get customer Id from scanner
				customerId = scanner.nextLine();

				// Order the product. Check for valid orderNumber string return and for error message set in ECommerceSystem
				String ordered_prod_id = amazon.orderProduct(productId, customerId, options);
				if(ordered_prod_id == null)
					System.out.println(amazon.getErrorMessage());
				else
					System.out.printf("Order #%s", ordered_prod_id);
			}
			else if (action.equalsIgnoreCase("ORDERBOOK")) // order a book for a customer, provide a format (Paperback, Hardcover or EBook)
			{
				String productId = "";
				String customerId = "";
				String options = "";

				System.out.print("Product Id: ");
				// get product id
				productId = scanner.nextLine();

				System.out.print("\nCustomer Id: ");
				// get customer id
				customerId = scanner.nextLine();

				System.out.print("\nFormat [Paperback Hardcover EBook]: ");
				// get book format and store in options string
				options = scanner.nextLine();


				// Order product. Check for error mesage set in ECommerceSystem
				// Print order number string if order number is not null
				String ordered_prod_id = amazon.orderProduct(productId, customerId, options);
				if(ordered_prod_id == null)
					System.out.println(amazon.getErrorMessage());
				else
					System.out.printf("Order #%s", ordered_prod_id);
			}
			else if (action.equalsIgnoreCase("ORDERSHOES")) // order shoes for a customer, provide size and color 
			{
				String productId = "";
				String customerId = "";
				String options = "";
				
				System.out.print("Product Id: ");
				// get product id
				productId = scanner.nextLine();

				System.out.print("\nCustomer Id: ");
				// get customer id
				customerId = scanner.nextLine();

				System.out.print("\nSize: \"6\" \"7\" \"8\" \"9\" \"10\": ");
				// get shoe size and store in options
				options = scanner.nextLine();
				
				System.out.print("\nColor: \"Black\" \"Brown\": ");
				// get shoe color and append to options
				options = options.concat(scanner.nextLine());

				//order shoes
				String ordered_prod_id = amazon.orderProduct(productId, customerId, options);
				if(ordered_prod_id == null)
					System.out.println(amazon.getErrorMessage());
				else
					System.out.printf("Order #%s", ordered_prod_id);
			}
			
			
			else if (action.equalsIgnoreCase("CANCEL")) // Cancel an existing order
			{
				String orderNumber = "";
				System.out.print("Order Number: ");
				// get order number from scanner
				orderNumber = scanner.nextLine();// getting order number from user
				
				// cancel order. Check for error
				if(!amazon.cancelOrder(orderNumber))
					System.out.println(amazon.getErrorMessage());

			}
			else if (action.equalsIgnoreCase("SORTBYPRICE")) // sort products by price
			{
				amazon.sortByPrice();
			}
			else if (action.equalsIgnoreCase("SORTBYNAME")) // sort products by name (alphabetic)
			{
				amazon.sortByName();
			}
			else if (action.equalsIgnoreCase("SORTCUSTS")) // sort products by name (alphabetic)
			{
				amazon.sortCustomersByName();
			}else if(action.equalsIgnoreCase("BOOKSBYAUTHOR")) //sort books by name of book for a specific
				//author
			{
				System.out.print("Author: ");
				//we scan for the authors name
				String author = scanner.nextLine(); // Getting user input for Author's name

				if(!amazon.BooksByAuthor(author)){// checing if such and author exists or not
					System.out.println(amazon.getErrorMessage());
				}

			}
			System.out.print("\n>");
		}
	}
}
