import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TalletusTest {
    @Test
    void testTalletus() {
        Pankkitili tili = new Pankkitili(50);
        tili.talleta(30);
        assertEquals(80, tili.getSaldo());
    }
}
