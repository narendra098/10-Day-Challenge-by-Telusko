import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> products = new ArrayList<>();



    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public void getProduct(String name){

        products.stream()
                .filter(p -> p.getName().equals(name))
                .forEach(p->System.out.println(p));

    }


    public void getProductWithText(String text) {
        String str = text.toLowerCase();
        products.stream()
                .filter(p->p.getName().toLowerCase().contains(str)
                        || p.getType().toLowerCase().contains(str)
                        || p.getPlace().toLowerCase().contains(str))
                .forEach(p->System.out.println(p));

    }

    public void searchByPlace(String text){
        String searchtext= text.toLowerCase();
        products.stream()
                .filter(p->p.getPlace().toLowerCase().contains(searchtext))
                .forEach(p->System.out.println(p));
    }

    public void searchProductsOutOfWarranty(){
        products.stream()
                .filter(p->p.getWarranty()<2023)
                .forEach(p->System.out.println(p));
    }
}