import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegatiivinenNostoSteps {
    Pankkitili tili;

    @Given("{double} tilillä")
    public void tili(Double saldo) {
        tili = new Pankkitili(saldo, 0);
    }

    @When("nosto {double}")
    public void negatiivinen_nosto(Double nostoMaara) {
        tili.nosto(nostoMaara);
    }

    @Then("{double} euroa tilillä")
    public void tili_saldo(Double kohdeSaldo) {
        assertEquals(kohdeSaldo, tili.getSaldo());
    }
}
