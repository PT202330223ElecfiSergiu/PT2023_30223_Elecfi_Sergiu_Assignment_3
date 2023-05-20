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
        this.clienti = CL.getAll();
    }

    public String afisareClienti(){
        String x = "";
        x = "ID  |  Name    | Email            |  Age :  " + '\n';
        for(Client aux : clienti){
            x = x + aux.toString();
        }
        return x;
    }

}
