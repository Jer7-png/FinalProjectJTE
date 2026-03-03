import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TalletusSteps {
    Pankkitili tili;

    @Given("alkusaldo {int}")
    public void tili(int alkusaldo) {
        tili = new Pankkitili(alkusaldo);
    }

    @When("talletetaan {int}")
    public void talletus(int talletusMaara) {
        tili.talleta(talletusMaara);
    }

    @Then("uusi saldo {int}")
    public void uusi_saldo(int kohdeSaldo) {
        assertEquals(kohdeSaldo, tili.getSaldo());
    }
}
