package local.wagenhuber.guenther;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class BankServer {
    public static void main(String[] args) throws Exception {

        //TCP-Port für RMI-Registry
        int registryPort = Integer.parseInt(args[0]);

        //Port für Server
        int port = Integer.parseInt(args[1]);

        //Erstellt eine lokale RMI-Registry auf port tcp/1099
        LocateRegistry.createRegistry(registryPort);



        Remote remote = new KontoManagerImpl(port);
        System.out.println("Referenz remote:");
        System.out.println(remote);

        //Objekt vom Typ KontoManagerImpl wird in Registry registriert
        Naming.rebind("//:" + "1099" + "/bank", remote);
        System.out.println("Bankserver gestartet");
    }
}
