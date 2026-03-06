package FinalProject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TilinLuontiTest {
    @Test
    void testTilinLuontiAlkusaldolla() {
        Pankkitili testiTili = new Pankkitili(10, 0);
        Pankkitili testTili2 = new Pankkitili(0, 0);
        assertEquals(10, testiTili.getSaldo());
        assertEquals(0, testTili2.getSaldo());
        assertEquals(1, testiTili.getHistoria().size());
        assertTrue(testiTili.getHistoria().getFirst().contains("Success"));
        assertTrue(testTili2.getHistoria().getFirst().contains("Success"));
        assertEquals(1, testTili2.getHistoria().size());
    }

    @Test
    void testTilinLuontiIlmanAlkusaldoa() {
        Pankkitili tili = new Pankkitili(0);
        assertEquals(0, tili.getSaldo());
        assertEquals(1, tili.getHistoria().size());
    }

    @Test
    void testTilinLuontiNegatiivisellaSaldolla() {
        // Testin kautta löydetty bugi

        Pankkitili tili = new Pankkitili(-14, 567);
        assertEquals(0, tili.getSaldo());
        assertEquals(567, tili.getId());
        assertTrue(tili.getHistoria().getFirst().contains("Error"));
    }
}
