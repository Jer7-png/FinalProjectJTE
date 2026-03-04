import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Pankkitili implements Serializable {
    private int saldo;
    private int id;
    private LinkedList<String> historia = new LinkedList<>();

    public LinkedList<String> getHistoria() {
        return historia;
    }

    public Pankkitili(int alkusaldo, int id) {
        this.saldo = alkusaldo;
        this.id = id;
        historia.addFirst(LocalDateTime.now() + "Tili luotiin saldolla " + alkusaldo);
    }
    public Pankkitili(int id) {
        this.saldo = 0;
        this.id = id;
        historia.addFirst(LocalDateTime.now() + "Tili luotiin saldolla 0");
    }

    public int getSaldo() {
        return this.saldo;
    }

    public int getId() {
        return id;
    }

    public void nosto(int nostoMaara) {
        if (saldo >= nostoMaara && nostoMaara > 0) {
            saldo -= nostoMaara;
            historia.addFirst(LocalDateTime.now() + "Nostettiin " + nostoMaara);
        }
    }
    public void talleta(int talletusMaara) {
        if (talletusMaara > 0) {
            saldo += talletusMaara;
            historia.addFirst(LocalDateTime.now() + "Talletettiin " + talletusMaara);
        }
    }
}
