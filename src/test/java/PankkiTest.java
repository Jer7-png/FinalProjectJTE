import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PankkiTest {
    @Test
    void test_tilin_luonti() {
        Pankkitili testiTili = new Pankkitili(10);
        assertEquals(10, testiTili.getSaldo());
    }
}
