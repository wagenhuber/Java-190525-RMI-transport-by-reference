package local.wagenhuber.guenther;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface KontoManager extends Remote {

    //Gibt Referenz auf entferntes Konto-Objekt zurück
    Konto getKonto(int id, int pin) throws RemoteException, KontoException;
}
