import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EpaonnistunutNostoSteps {
    Pankkitili tili;

    @Given("tilillä on valmiiksi {int}")
    public void tililla_on_valmiiksi(int saldo) {
        tili = new Pankkitili(saldo);
    }

    @When("yritän nostaa tililtä {int}")
    public void tili_nosto(int nostoMaara) {
        tili.nosto(nostoMaara);
    }

    @Then("tilin saldo on {int}")
    public void tilin_saldo_on(int kohdeSaldo) {
        assertEquals(kohdeSaldo, tili.getSaldo());
    }
}
