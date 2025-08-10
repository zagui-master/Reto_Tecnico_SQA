Feature: Seleccionar fecha en el DatePicker
  Como usuario del módulo de reservas
  Quiero seleccionar una fecha desde el calendario emergente "DatePicker"
  Para poder agendar eventos en el sistema sin errores de fecha


  Background:
    Given  que navego a la pagina principal de JQuery DatePicker
    When doy click en el campo de seleccion de fecha


  @CP-01
  Scenario Outline: CP-01 Reserva de una cita seleccionando una fecha en el calendario
    And selecciono el dia <day> del mes actual
    Then la fecha seleccionada aparece en el campo de texto <day>
    Examples:
      | day |
      | 15  |

  @CP-02
  Scenario Outline: CP-02 Selección de una fecha específica en un mes diferente
    And navego hasta el proximo mes
    And selecciono el dia <day> del proximo mes
    Then la fecha seleccionada aparece en el campo de texto del proximo mes <day>
    Examples:
      | day |  |
      | 10  |  |

  @CP-03
  Scenario Outline: CP-03 Validación de campo bloqueado
    And intento ingresar una fecha "<date>" manualmente en el campo de texto
    Then valido que no se permite la edicion manual y que solo es posible seleccionar una fecha desde el calendario
    Examples:
      | date        |  |
      | 20/08/20025 |  |