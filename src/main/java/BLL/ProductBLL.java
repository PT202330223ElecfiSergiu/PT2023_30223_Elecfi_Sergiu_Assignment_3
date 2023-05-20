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
        this.produse = PR.getAll();
    }

    public String afisareProduse(){
        String x = "";
        x = "ID  |  Name    |Stock|Price :  " + '\n';
        for(Product aux : produse){
            x = x + aux.toString();
        }
        return x;
    }
}
