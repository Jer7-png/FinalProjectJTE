import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NostoTest {

    @Test
    void testOnnistunutNosto() {
        Pankkitili tili = new Pankkitili(50, 0);
        tili.nosto(10);
        assertEquals(40, tili.getSaldo());
    }

    @Test
    void testTaysiNosto() {
        Pankkitili tili = new Pankkitili(50, 0);
        tili.nosto(50);
        assertEquals(0, tili.getSaldo());
    }

    @Test
    void testLiianSuuriNosto() {
        Pankkitili tili = new Pankkitili(50, 0);
        tili.nosto(60);
        assertEquals(50, tili.getSaldo());
    }

    @Test
    void testNollaNosto() {
        Pankkitili tili = new Pankkitili(50, 0);
        tili.nosto(0);
        assertEquals(50, tili.getSaldo());
    }

    @Test
    void testNegatiivinenNosto() {
        Pankkitili tili = new Pankkitili(50, 0);
        tili.nosto(-50);
        assertEquals(50, tili.getSaldo());
    }

    @Test
    void testPerakkaiset() {
        Pankkitili tili = new Pankkitili(50, 0);
        tili.nosto(5);
        tili.nosto(23);
        assertEquals(50 - 5 - 23, tili.getSaldo());
    }

    @Test
    void testDesimaali() {
        Pankkitili tili = new Pankkitili(50, 0);
        tili.nosto(23.5);
        assertEquals(50 - 23.5, tili.getSaldo());
    }



}
