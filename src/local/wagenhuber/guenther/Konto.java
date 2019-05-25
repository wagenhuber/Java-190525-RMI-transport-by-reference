package local.wagenhuber.guenther;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Konto extends Remote {

    int getSaldo() throws RemoteException;

    void add(int betrag) throws RemoteException, KontoException;
}
