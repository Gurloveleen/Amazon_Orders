import java.util.*;

/*
 * Models a simple ECommerce system. Keeps track of products for sale, registered customers, product orders and
 * orders that have been shipped to a customer
 */
public class ECommerceSystem
{
    private ArrayList<Product>  products = new ArrayList<Product>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();	
    
    private ArrayList<ProductOrder> orders   = new ArrayList<ProductOrder>();
    private ArrayList<ProductOrder> shippedOrders   = new ArrayList<ProductOrder>();
    
    // These variables are used to generate order numbers, customer id's, product id's 
    private int orderNumber = 500;
    private int customerId = 900;
    private int productId = 700;
    
    // General variable used to store an error message when something is invalid (e.g. customer id does not exist)  
    String errMsg = null;
    
    // Random number generator
    Random random = new Random();
    
    public ECommerceSystem()
    {
    	// NOTE: do not modify or add to these objects!! - the TAs will use for testing
    	// If you do the class Shoes bonus, you may add shoe products
    	
    	// Create some products. Notice how generateProductId() method is used
    	products.add(new Product("Acer Laptop", generateProductId(), 989.0, 99, Product.Category.COMPUTERS));
    	products.add(new Product("Apex Desk", generateProductId(), 1378.0, 12, Product.Category.FURNITURE));
    	products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "Ahm Gonna Make You Learn", "T. McInerney", 2014));
    	products.add(new Product("DadBod Jeans", generateProductId(), 24.0, 50, Product.Category.CLOTHING));
    	products.add(new Product("Polo High Socks", generateProductId(), 5.0, 199, Product.Category.CLOTHING));
    	products.add(new Product("Tightie Whities", generateProductId(), 15.0, 99, Product.Category.CLOTHING));
    	products.add(new Book("Book", generateProductId(), 35.0, 4, 2, "How to Fool Your Prof", "D. Umbast",2020));
    	products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "How to Escape from Prison", "A. Fugitive",2019));
    	products.add(new Book("Book", generateProductId(), 44.0, 14, 12, "Ahm Gonna Make You Learn More", "T. McInerney",2018));
    	products.add(new Product("Rock Hammer", generateProductId(), 10.0, 22, Product.Category.GENERAL));

        // Creating shoe products
        products.add(new Shoes("Jordans Nike", generateProductId(), 190.0, 5, 6, 6 , 2, 2, 2, 3, 4, 5, 6));
        products.add(new Shoes("Nike Airforce", generateProductId(), 270.0, 5, 6, 6 , 2, 2, 2, 3, 4, 5, 6));
        products.add(new Shoes("Nike Dunks", generateProductId(), 850.0, 5, 6, 6 , 2, 2, 2, 3, 4, 5, 0));
        products.add(new Shoes("Adidas Beige", generateProductId(), 46.0, 2, 6, 6 , 1, 5, 2, 3, 4, 5, 0));

    	// Create some customers. Notice how generateCustomerId() method is used
    	customers.add(new Customer(generateCustomerId(),"Inigo Montoya", "1 SwordMaker Lane, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Prince Humperdinck", "The Castle, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Andy Dufresne", "Shawshank Prison, Maine"));
    	customers.add(new Customer(generateCustomerId(),"Ferris Bueller", "4160 Country Club Drive, Long Beach"));

    }
    
    private String generateOrderNumber()
    {
    	return "" + orderNumber++;
    }

    private String generateCustomerId()
    {
    	return "" + customerId++;
    }
    
    private String generateProductId()
    {
    	return "" + productId++;
    }
    
    public String getErrorMessage()
    {
    	return errMsg;
    }
    public void setErrorMessage(String message)
    {
        errMsg = message;
    }
    
    public void printAllProducts()
    {
    	for (Product p : products)
    		p.print(); // Printing all the products
    }
    
    // Print all products that are books. See getCategory() method in class Product
    public void printAllBooks()
    {
        for(Product po : products)
            if(po.getCategory()==Product.Category.BOOKS)
                po.print(); // printing orders which are specifically books
    	
    }
    // Print all current orders
    public void printAllOrders()
    {
    	for(ProductOrder o : orders) {
            o.print(); // printing each and every order
        }
    }
    // Print all shipped orders
    public void printAllShippedOrders()
    {
        for(ProductOrder so : shippedOrders) {
            so.print();//printing all the shipped orders
        }
    }



    // Print all customers
    public void printCustomers()
    {
    	for(Customer c: customers)
            c.print(); //printing customers
    }
    /*
     * Given a customer id, print all the current orders and shipped orders for them (if any)
     */
    public boolean printOrderHistory(String customerId)
    {
        boolean flag = true;
      // Make sure customer exists - check using customerId
    	// If customer does not exist, set errMsg String and return false
    	// see video for an appropriate error message string
    	// ... code here
        boolean cfound = false;
        for(Customer j : customers){
            if(Objects.equals(customerId, j.getId())){
                cfound = true;
                break;
            }
        }
        if(!cfound) { // checking is customeer is found or not
            setErrorMessage("Customer"+ customerId +" Not found");
            flag = false;
        }else {
            // Print current orders of this customer
            System.out.println("Current Orders of Customer " + customerId);
            // enter code here
            for (ProductOrder k : orders){
                if(customerId.equals(k.getCustomer().getId())){
                    k.print();
                }
            }

            // Print shipped orders of this customer
            System.out.println("\nShipped Orders of Customer " + customerId);
            //enter code here
            for (ProductOrder k : shippedOrders){
                if(customerId.equals(k.getCustomer().getId())){
                    k.print();
                }
            }

        }
    	return flag;
    }
    
    public String orderProduct(String productId, String customerId, String productOptions)
    {
        Product oproduct = new Product();
        Customer orderingcust = new Customer(customerId);
        String flag = null;
    	// First check to see if customer object with customerId exists in array list customers
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Customer object
        boolean cfound = false;
        for(Customer j : customers){
            if(Objects.equals(customerId, j.getId())){
                cfound = true;
                orderingcust = j;
                break;
            }
        }
        if(!cfound){ // checking if customer is found or not
            setErrorMessage("Customer"+ customerId +" Not found");
            System.out.println(getErrorMessage());
        }else {

            // Check to see if product object with productId exists in array list of products
            // if it does not, set errMsg and return null (see video for appropriate error message string)
            // else get the Product object
            boolean id_found = false;
            for (Product j : products) {
                if (Objects.equals(productId, j.getId())) {
                    id_found = true;
                    oproduct = j;
                    break;
                }
            }
            if (!id_found) {
                setErrorMessage("Product"+ productId +" Not found");
                System.out.println(getErrorMessage());
            }else {

                // Check if the options are valid for this product (e.g. Paperback or Hardcover or EBook for Book product)
                // See class Product and class Book for the method validOptions()
                // If options are not valid, set errMsg string and return null;
                if (!oproduct.validOptions(productOptions)) {
                    setErrorMessage("Product "+ oproduct.getName() +" ProductId "+ oproduct.getId() +" Invalid Option "+ productOptions);
                }else{
                // Check if the product has stock available (i.e. not 0)
                // See class Product and class Book for the method getStockCount()
                // If no stock available, set errMsg string and return null
                    if(oproduct.getStockCount(productOptions) == 0){
                        setErrorMessage("Product has no stock ");
                    }else {
                        // Create a ProductOrder, (make use of generateOrderNumber() method above)
                        // reduce stock count of product by 1 (see class Product and class Book)
                        // Add to orders list and return order number string
                        ProductOrder porder = new ProductOrder(generateOrderNumber(), oproduct, orderingcust, productOptions);
                        oproduct.reduceStockCount(productOptions);
                        orders.add(porder);
                        flag = porder.getOrderNumber();
                    }
                }
            }
        }
    	return flag; // replace this line
    }
    
    /*
     * Create a new Customer object and add it to the list of customers
     */
    
    public boolean createCustomer(String name, String address)
    {
        boolean flag = true;

    	// Check name parameter to make sure it is not null or ""
    	// If it is not a valid name, set errMsg (see video) and return false
    	// Repeat this check for address parameter
    	if(name.isEmpty() | name.equalsIgnoreCase("")){
            flag = false;
            setErrorMessage("Invalid Customer Name");

        }else if(address.isEmpty() | address.equalsIgnoreCase("")){
            flag = false;
            setErrorMessage("Invalid Customer Address");
        }else {
            // Create a Customer object and add to array list
            Customer newcust = new Customer(generateCustomerId(), name, address);// adding new customer
            customers.add(newcust);
        }
    	return flag;
    }
    
    public ProductOrder shipOrder(String orderNumber)
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return false
        ProductOrder so = null;
        boolean order_number_check = false;
        for (ProductOrder j : orders){
            if (orderNumber.equals(j.getOrderNumber())){
                order_number_check = true;
                so = j;
                break;
            }
        }
        if(!order_number_check){
            setErrorMessage("Order "+ orderNumber + " Not Found");
            System.out.println(getErrorMessage());
        }else {
            // Retrieve the order from the orders array list, remove it, then add it to the shippedOrders array list
            // return a reference to the order
            Iterator<ProductOrder> itr = orders.iterator();
            while (itr.hasNext()){
                ProductOrder prod = itr.next();
                if(prod == so)
                    itr.remove();
            }

            shippedOrders.add(so);

        }
    	return so;
    }
    
    /*
     * Cancel a specific order based on order number
     */
    public boolean cancelOrder(String orderNumber)
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return false
        boolean flag = false;
        ProductOrder order_to_be_cancelled = null;
        for (ProductOrder j : orders){
            if (orderNumber.equals(j.getOrderNumber())){ // checking if order number matches the given order number as a parameter
                flag = true;
                order_to_be_cancelled = j;
                break;
            }
        }
        if (!flag){
            setErrorMessage("Order"+ orderNumber +" Not Found");
        }else{
            Iterator<ProductOrder> itr = orders.iterator();
            while (itr.hasNext()){
                ProductOrder prod = itr.next();
                if(prod == order_to_be_cancelled)
                    itr.remove();
            }
        }
    	return flag;
    }
    // Sort products by increasing price
    public void sortByPrice()
    {
        //after implementing our Comperator we use sort() to sort our list by price
        PPriceComparator price_comp = new PPriceComparator();
        Collections.sort(products, price_comp);
        //and then we print it
        printAllProducts();
    }
    // Sort products alphabetically by product name
    public void sortByName()
    {
        //after implementing our Comperator we use sort() to sort our list by name
        PNameComparator name_comp = new PNameComparator();
        Collections.sort(products,name_comp);
        //and then we print it
        printAllProducts();
    }
    // Sort products alphabetically by product name
    public void sortCustomersByName()
    {
        //after implementing our Comparable we use sort() to sort our arraylist
        Collections.sort(customers);
        //and then we print it
        printCustomers();

    }
    }
