import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Pankkitili implements Serializable {
    private double saldo;
    private int id;
    private LinkedList<String> historia = new LinkedList<>();

    public LinkedList<String> getHistoria() {
        return historia;
    }

    public Pankkitili(double alkusaldo, int id) {
        if (alkusaldo >= 0) {
            this.saldo = alkusaldo;
        }
        this.id = id;
        historia.addFirst(LocalDateTime.now() + " Tili luotiin saldolla " + alkusaldo);
    }
    public Pankkitili(int id) {
        this.saldo = 0;
        this.id = id;
        historia.addFirst(LocalDateTime.now() + " Tili luotiin saldolla 0");
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
            historia.addFirst(LocalDateTime.now() + " Nostettiin " + nostoMaara);
        }
    }
    public void talleta(double talletusMaara) {
        if (talletusMaara > 0) {
            saldo += talletusMaara;
            historia.addFirst(LocalDateTime.now() + " Talletettiin " + talletusMaara);
        }
    }
}
