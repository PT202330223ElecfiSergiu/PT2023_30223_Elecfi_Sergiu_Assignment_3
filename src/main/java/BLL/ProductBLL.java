package BLL;

import DataAccess.ClientDAO;
import Model.Product;
import DataAccess.ProductDAO;
import java.util.ArrayList;
import java.util.List;

public class ProductBLL {
    private List<Product> produse;
    private ProductDAO PR;
    public ProductBLL(){
        this.PR = new ProductDAO();
        this.produse = new ArrayList<>();
    }

    public List<Product> getAll(){
        this.produse = PR.getAll();
        return this.produse;
    }

    public void insert(Product product) {
        PR.insert(product);
    }

    public void delete(Product product){
        PR.delete(product);
    }

    public void update(Product product){
        PR.update(product);
    }

}
