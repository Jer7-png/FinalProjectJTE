import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TilinLuontiSteps {
    Pankkitili tili;

    @Given("luon uuden pankkitilin saldolla {int}")
    public void luoPankkitili(int saldo) {
        this.tili = new Pankkitili(saldo);
    }

    @When("tarkistan saldon")
    public void asd() {

    }

    @Then("saldo on {int}")
    public void tarkistaSaldo(int saldo) {
        assertEquals(tili.getSaldo(), saldo);
    }

}
