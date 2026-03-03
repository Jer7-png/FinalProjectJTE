Feature: Tilin hallinta
  Scenario: Tilin luominen alkusaldolla
    Given luon uuden pankkitilin saldolla 10
    When tarkistan saldon
    Then saldo on 10
  Scenario: Noston tekeminen onnistuneesti
    Given tilillä on 50
    When yritän nostaa 10
    Then tilin uusi saldo on 40
  Scenario: Noston tekeminen epäonnistuneesti
    Given tilillä on valmiiksi 50
    When yritän nostaa tililtä 60
    Then tilin saldo on 50
  Scenario: Negatiivisen saldon syöttäminen
    Given 50 tilillä
    When nosto -50
    Then 50 euroa tilillä
  Scenario: Rahan talletus
    Given alkusaldo 50
    When talletetaan 30
    Then uusi saldo 80