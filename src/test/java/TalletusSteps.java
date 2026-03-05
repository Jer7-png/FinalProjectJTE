import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TalletusSteps {
    Pankkitili tili;

    @Given("alkusaldo {double}")
    public void tili(Double saldo) {
        tili = new Pankkitili(saldo, 0);
    }

    @When("talletetaan {double}")
    public void talletus(Double talletusMaara) {
        tili.talleta(talletusMaara);
    }

    @Then("uusi saldo {double}")
    public void uusi_saldo(Double kohdeSaldo) {
        assertEquals(kohdeSaldo, tili.getSaldo());
    }
}
