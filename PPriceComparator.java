import java.util.Comparator;

public class PPriceComparator implements Comparator<Product> {
    // We override compare through this operator so that we can compare with the price of the product
    @Override
    public int compare(Product product_1, Product product_2) {
        return Integer.compare((int)product_1.getPrice(), (int)product_2.getPrice());
    }
}