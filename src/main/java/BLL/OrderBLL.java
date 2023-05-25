package BLL;

import DataAccess.OrderDAO;
import Model.Order;

public class OrderBLL {
    private OrderDAO OD;
    public OrderBLL(){
        OD = new OrderDAO();
    }

    public void makeOrder(Order order){
        OD.makeOrder(order);
    }
}
