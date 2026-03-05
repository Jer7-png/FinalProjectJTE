import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TalletaTest {
    @Test
    void testTalletusPos() {
        Pankkitili tili = new Pankkitili(50, 0);
        tili.talleta(30);
        assertEquals(80, tili.getSaldo());

    }

    @Test
    void testTalletusNeg() {
        Pankkitili tili = new Pankkitili(10, 0);
        tili.talleta(-30);
        assertEquals(10, tili.getSaldo());
    }

    @Test
    void testTalletusNolla() {
        Pankkitili tili = new Pankkitili(30, 0);
        tili.talleta(0);
        assertEquals(30, tili.getSaldo());
    }

    @Test
    void testTalletusDecimal() {
        Pankkitili tili = new Pankkitili(30, 0);
        tili.talleta(35.623514214);
        assertEquals(65.62351421, tili.getSaldo(), 0.01);
    }

    @Test
    void testMaxNumber() {
        // Testi, että saldo ei voi ylittää max double arvoa.
        Pankkitili tili = new Pankkitili(0);
        tili.talleta(Double.MAX_VALUE + 100.0);
        assertEquals(Double.MAX_VALUE, tili.getSaldo());

    }

    @Test
    void testBigNumber() {
        Pankkitili tili = new Pankkitili(0);
        tili.talleta(1000000000);
        assertEquals(1000000000, tili.getSaldo());
    }

    @Test
    void testMontaTalletusta() {
        Pankkitili tili = new Pankkitili(0);
        tili.talleta(30);
        tili.talleta(40);
        tili.talleta(50);
        assertEquals(30 + 40 + 50, tili.getSaldo());
    }

}
