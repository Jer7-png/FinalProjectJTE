package FinalProject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NostoTest {

    @Test
    void testOnnistunutNosto() {
        Pankkitili tili = new Pankkitili(50, 0);
        tili.nosto(10);
        assertEquals(40, tili.getSaldo());
        assertTrue(tili.getHistoria().getFirst().contains("Success"));
    }

    @Test
    void testTaysiNosto() {
        Pankkitili tili = new Pankkitili(50, 0);
        tili.nosto(50);
        assertEquals(0, tili.getSaldo());
        assertTrue(tili.getHistoria().getFirst().contains("Success"));
    }

    @Test
    void testLiianSuuriNosto() {
        Pankkitili tili = new Pankkitili(50, 456);
        int historiaSize = tili.getHistoria().size();
        tili.nosto(60);
        assertEquals(50, tili.getSaldo());
        assertEquals(historiaSize, tili.getHistoria().size());
    }

    @Test
    void testNollaNosto() {
        Pankkitili tili = new Pankkitili(50, 0);
        int historiaSize = tili.getHistoria().size();
        tili.nosto(0);
        assertEquals(50, tili.getSaldo());
        assertEquals(historiaSize, tili.getHistoria().size());

    }

    @Test
    void testNegatiivinenNosto() {
        Pankkitili tili = new Pankkitili(50, 456);
        int historiaSize = tili.getHistoria().size();
        tili.nosto(-50);
        assertEquals(50, tili.getSaldo());
        assertEquals(historiaSize, tili.getHistoria().size());
    }

    @Test
    void testPerakkaiset() {
        Pankkitili tili = new Pankkitili(50, 0);
        tili.nosto(5);
        tili.nosto(23);
        assertEquals(50 - 5 - 23, tili.getSaldo());
        assertTrue(tili.getHistoria().getFirst().contains("Success"));
    }

    @Test
    void testDesimaali() {
        Pankkitili tili = new Pankkitili(50, 0);
        tili.nosto(23.5);
        assertEquals(50 - 23.5, tili.getSaldo());
        assertTrue(tili.getHistoria().getFirst().contains("Success"));
    }



}
