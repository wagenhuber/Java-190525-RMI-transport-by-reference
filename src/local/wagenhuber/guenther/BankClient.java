package local.wagenhuber.guenther;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class BankClient {

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            System.err.println("java BankClient <host> <registryPort> <id> <pin> ");
        }

        String host = args[0];
        int registryPort = Integer.parseInt(args[1]);
        int id = Integer.parseInt(args[2]);
        int pin = Integer.parseInt(args[3]);

        KontoManager manager = ((KontoManager) Naming.lookup("//" + host + ":" + registryPort + "/bank"));

        Konto konto = manager.getKonto(id, pin);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (true) {
            try {
                System.out.println("Kommando eingeben (get | <zahl> | q): ");
                input = in.readLine();
                if (input == null || input.length() == 0 || input.equals("q")) {
                    break;
                }
                if (input.equals("get")) {
                    System.out.println("Aktueller Kontostand: " + konto.getSaldo());
                } else {
                    int betrag = Integer.parseInt(input);
                    konto.add(betrag);
                }
            } catch (NumberFormatException e) {
            } catch (KontoException e) {
                System.out.println(e.getMessage());
            }
        }

    }



}
