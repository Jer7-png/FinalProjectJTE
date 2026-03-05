import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EpaonnistunutNostoSteps {
    Pankkitili tili;

    @Given("tilillä on valmiiksi {double}")
    public void tililla_on_valmiiksi(Double saldo) {
        tili = new Pankkitili(saldo, 0);
    }

    @When("yritän nostaa tililtä {double}")
    public void tili_nosto(Double nostoMaara) {
        tili.nosto(nostoMaara);
    }

    @Then("tilin saldo on {double}")
    public void tilin_saldo_on(Double kohdeSaldo) {
        assertEquals(kohdeSaldo, tili.getSaldo());
    }
}
