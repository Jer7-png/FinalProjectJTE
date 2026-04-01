package FinalProject;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Pankkitili implements Serializable {
    private int test;
    private double saldo;
    private int id;
    private LinkedList<String> historia = new LinkedList<>();

    public LinkedList<String> getHistoria() {
        return historia;
    }

    // Lisäsin varoitukset ja viestit metodeihin koodikatselmuksen jälkeen
    public Pankkitili(double alkusaldo, int id) {
        if (alkusaldo >= 0) {
            this.saldo = alkusaldo;
            this.id = id;
            historia.addFirst(LocalDateTime.now() + " Success: Tili luotiin saldolla " + alkusaldo);

        }
        else {
            System.out.println("Alkusaldo ei voi olla negatiivinen: tili luotu saldolla 0");
            this.saldo = 0;
            this.id = id;
            historia.addFirst(LocalDateTime.now() + " Error: Tili luotiin saldolla 0" );
        }


    }
    public Pankkitili(int id) {
        this.saldo = 0;
        this.id = id;
        historia.addFirst(LocalDateTime.now() + " Success: Tili luotiin saldolla 0");
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getId() {
        return id;
    }

    public void nosto(double nostoMaara) {
        if (saldo >= nostoMaara && nostoMaara > 0) {
            saldo -= nostoMaara;
            historia.addFirst(LocalDateTime.now() + " Success: Nostettiin " + nostoMaara);
            System.out.println("Nostettiin: " + nostoMaara + " uusi saldo: " + saldo);
        }
        else if (nostoMaara < 0) {
            System.out.println("Error: Nostosumma ei voi olla negatiivinen. Saldo pysyy samana.");
        }
        else if (nostoMaara > saldo) {
            System.out.println("Error: Et voi nostaa enemmän, kuin tilillä on. Saldo pysyy samana.");
        }
    }
    public void talleta(double talletusMaara) {
        if (talletusMaara > 0) {
            saldo += talletusMaara;
            historia.addFirst(LocalDateTime.now() + "Success: Talletettiin " + talletusMaara);
            System.out.println("Talletettiin " + talletusMaara + " uusi saldo: " + saldo);
        }
        else {
            System.out.println("Et voi tallettaa negatiivista määrää. Käytä nostotoimintoa. Saldo pysyy samana.");
        }
    }
}
