import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegatiivinenNostoSteps {
    Pankkitili tili;

    @Given("{int} tilillä")
    public void tili(int saldo) {
        tili = new Pankkitili(saldo);
    }

    @When("nosto {int}")
    public void negatiivinen_nosto(int nostoMaara) {
        tili.nosto(nostoMaara);
    }

    @Then("{int} euroa tilillä")
    public void tili_saldo(int kohdeSaldo) {
        assertEquals(kohdeSaldo, tili.getSaldo());
    }
}
