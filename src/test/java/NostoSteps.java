import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NostoSteps {
    Pankkitili tili;

    @Given("tilillä on {double}")
    public void tililla_on(Double saldo) {
        tili = new Pankkitili(saldo, 0);
    }

    @When("yritän nostaa {double}")
    public void yritan_nostaa(Double nostoMaara) {
        tili.nosto(nostoMaara);
    }

    @Then("tilin uusi saldo on {double}")
    public void tilin_uusi_saldo_on(Double kohdeSaldo) {
        assertEquals(kohdeSaldo, tili.getSaldo());
    }

}
