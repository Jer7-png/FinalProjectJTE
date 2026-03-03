import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EpaonnistunutNostoTest {
    @Test
    void testNosto() {
        Pankkitili tili = new Pankkitili(50);
        tili.nosto(60);
        assertEquals(50, tili.getSaldo());
    }
}
