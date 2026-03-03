import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegatiivinenNostoTest {
    @Test
    void testNegatiivinenNosto() {
        Pankkitili tili = new Pankkitili(50);
        tili.nosto(-40);
        assertEquals(50, tili.getSaldo());
    }
}
