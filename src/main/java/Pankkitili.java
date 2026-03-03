public class Pankkitili {
    private int saldo;

    public Pankkitili(int alkusaldo) {
        this.saldo = alkusaldo;
    }
    public Pankkitili() {
        this.saldo = 0;
    }

    public int getSaldo() {
        return this.saldo;
    }
    public void nosto(int nostoMaara) {
        if (saldo >= nostoMaara && nostoMaara > 0) {
            saldo -= nostoMaara;
        }
    }
    public void talleta(int talletusMaara) {
        if (talletusMaara > 0) {
            saldo += talletusMaara;
        }
    }
}
