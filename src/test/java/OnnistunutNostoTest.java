import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnnistunutNostoTest {

    @Test
    void testNosto() {
        Pankkitili tili = new Pankkitili(50);
        tili.nosto(10);
        assertEquals(40, tili.getSaldo());
    }
}
