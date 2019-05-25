package local.wagenhuber.guenther;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class KontoImpl extends UnicastRemoteObject implements Konto {

    private int pin;
    private int saldo;

    public KontoImpl(int pin) throws RemoteException {
        this.pin = pin;
    }

    public int getSaldo() throws RemoteException {
        return saldo;
    }

    public void add(int betrag) throws RemoteException, KontoException {
        if (saldo + betrag < 0) {
            throw new KontoException("Das Konto kann nicht ueberzogen werden.");
        }
        saldo += betrag;
    }

    public int getPin() {
        return pin;
    }
}
