import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NostoSteps {
    Pankkitili tili;

    @Given("tilillä on {int}")
    public void tililla_on(int saldo) {
        tili = new Pankkitili(saldo);
    }

    @When("yritän nostaa {int}")
    public void yritan_nostaa(int nostoMaara) {
        tili.nosto(nostoMaara);
    }

    @Then("tilin uusi saldo on {int}")
    public void tilin_uusi_saldo_on(int kohdeSaldo) {
        assertEquals(kohdeSaldo, tili.getSaldo());
    }

}
