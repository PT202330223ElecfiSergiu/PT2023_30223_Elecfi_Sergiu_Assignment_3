package Model;

public class Order {
    private int id;
    private int idProduct;
    private int idClient;
    private int noofpieces;
    private int price;

    public Order(int id, int idProduct, int idClient, int noofpieces, int price) {
        this.id = id;
        this.idProduct = idProduct;
        this.idClient = idClient;
        this.noofpieces = noofpieces;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setNoofpieces(int noofpieces) {
        this.noofpieces = noofpieces;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getNoofpieces() {
        return noofpieces;
    }

    public int getPrice() {
        return price;
    }
}
