package FinalProject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TilinLuontiSteps {
    Pankkitili tili;

    @Given("luon uuden pankkitilin saldolla {double}")
    public void luoPankkitili(Double saldo) {
        this.tili = new Pankkitili(saldo, 0);
    }

    @When("tarkistan saldon")
    public void asd() {

    }

    @Then("saldo on {double}")
    public void tarkistaSaldo(Double saldo) {
        assertEquals(saldo, tili.getSaldo());
    }

}
