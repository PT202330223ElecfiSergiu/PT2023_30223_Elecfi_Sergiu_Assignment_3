package BLL;

import Model.Client;
import DataAccess.ClientDAO;
import java.util.ArrayList;
import java.util.List;

public class ClientBLL {
    private List<Client> clienti;
    private ClientDAO CL;
    public ClientBLL(){
        this.CL = new ClientDAO();
        this.clienti = new ArrayList<>();
    }

    public List<Client> getAll(){
        this.clienti = CL.getAll();
        return this.clienti;
    }

    public void insert(Client client){
        CL.insert(client);
    }

    public void delete(Client client){
        CL.delete(client);
    }

    public void update(Client client){
        CL.update(client);
    }
}
