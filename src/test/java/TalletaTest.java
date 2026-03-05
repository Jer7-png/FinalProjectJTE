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
}
