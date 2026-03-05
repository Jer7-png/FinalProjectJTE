import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TilinLuontiTest {
    @Test
    void testTilinLuontiAlkusaldolla() {
        Pankkitili testiTili = new Pankkitili(10, 0);
        assertEquals(10, testiTili.getSaldo());
    }

    @Test
    void testTilinLuontiIlmanAlkusaldoa() {
        Pankkitili tili = new Pankkitili(0);
        assertEquals(0, tili.getSaldo());
    }

    @Test
    void testTilinLuontiNegatiivisellaSaldolla() {
        // Testin kautta löydetty bugi

        Pankkitili tili = new Pankkitili(-14, 0);
        assertEquals(0, tili.getSaldo());
    }
}
