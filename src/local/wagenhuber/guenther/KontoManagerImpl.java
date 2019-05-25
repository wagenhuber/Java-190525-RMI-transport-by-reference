package local.wagenhuber.guenther;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

public class KontoManagerImpl extends UnicastRemoteObject implements KontoManager {

    private Hashtable<Integer, KontoImpl> hashtable;

    public KontoManagerImpl(int port) throws RemoteException {
        super(port);
        this.hashtable = new Hashtable<Integer, KontoImpl>();
    }

    @Override
    public Konto getKonto(int id, int pin) throws RemoteException, KontoException {
        KontoImpl konto = hashtable.get(id);
        if (konto == null) {
            konto = new KontoImpl(pin);
            hashtable.put(id, konto);
            System.out.println("Konto " + id + " wurde eingerichtet.");
            return konto;
        } else {
            if (konto.getPin() == pin) {
                return konto;
            } else {
                throw new KontoException("PIN ist ungueltig.");
            }
        }
    }
}
