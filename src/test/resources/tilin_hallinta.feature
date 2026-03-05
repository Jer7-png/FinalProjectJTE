Feature: Tilin hallinta
  Scenario: Tilin luominen alkusaldolla
    Given luon uuden pankkitilin saldolla 10.0
    When tarkistan saldon
    Then saldo on 10.0
  Scenario: Noston tekeminen onnistuneesti
    Given tilillä on 50.0
    When yritän nostaa 10.0
    Then tilin uusi saldo on 40.0
  Scenario: Noston tekeminen epäonnistuneesti
    Given tilillä on valmiiksi 50.0
    When yritän nostaa tililtä 60.0
    Then tilin saldo on 50.0
  Scenario: Negatiivisen saldon syöttäminen
    Given 50 tilillä
    When nosto -50.0
    Then 50 euroa tilillä
  Scenario: Rahan talletus
    Given alkusaldo 50.0
    When talletetaan 30.0
    Then uusi saldo 80.0