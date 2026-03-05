import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TapahtumahistoriaTest {
    @Test
    void testHistoriaPaivittyyNosto() {

        // Tili luodaan tapahtumahistorialistan koolla 1
        Pankkitili tili = new Pankkitili(50, 0);
        tili.nosto(30);
        assertEquals(2, tili.getHistoria().size());
    }

    @Test
    void testHistoriaLuodaanTilinKanssa() {
        // Tili luodaan tapahtumahistorialistan koolla 1
        Pankkitili tili = new Pankkitili(0);
        assertEquals(1, tili.getHistoria().size());
    }

    @Test
    void testHistoriaPaivittyyTalletus() {
        Pankkitili tili = new Pankkitili(0);
        tili.talleta(50.4);
        assertEquals(2, tili.getHistoria().size());
    }

    @Test
    void testPerakkaisetTapahtumat() {
        Pankkitili tili = new Pankkitili(0);
        tili.talleta(50);
        tili.nosto(32);
        tili.nosto(8);
        assertEquals(4, tili.getHistoria().size());
    }
}
