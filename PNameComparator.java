import java.util.Comparator;


public class PNameComparator implements Comparator<Product> {
    // We override compare through this operator so that we can compare with the name of the product
    public int compare(Product p1, Product p2) {
        return p1.getName().compareTo(p2.getName());
    }
}
