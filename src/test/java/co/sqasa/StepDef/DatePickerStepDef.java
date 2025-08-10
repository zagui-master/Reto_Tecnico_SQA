package co.sqasa.StepDef;

import co.sqasa.Steps.DatePickerSteps;
import co.sqasa.helpers.DateHelper;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class DatePickerStepDef {

    private static final DateHelper dateHelper = new DateHelper();

    @Steps
    DatePickerSteps datePickerSteps;

    @Given("que navego a la pagina principal de JQuery DatePicker")
    public void queNavegoALaPaginaPrincipalDeJQueryDatePicker() {
        datePickerSteps.openPage();
    }


    @When("doy click en el campo de seleccion de fecha")
    public void doyClickEnElCampoDeSeleccionDeFecha() {
        datePickerSteps.clickOnInputDataPicker();
    }

    @And("selecciono el dia {int} del mes actual")
    public void seleccionoElDiaDelMesActual(int day) {
        datePickerSteps.chooseDay(String.valueOf(day));
    }

    @Then("la fecha seleccionada aparece en el campo de texto {int}")
    public void laFechaSeleccionadaApareceEnElCampoDeTexto(int day) {
        datePickerSteps.validateDateOnDatePicker(dateHelper.getCurrentDate(day));
    }

    @And("navego hasta el proximo mes")
    public void navegoHastaElProximoMes() {
        datePickerSteps.goToNextMonth();
    }

    @And("selecciono el dia {int} del proximo mes")
    public void seleccionoElDiaDelProximoMes(int day) {
        datePickerSteps.chooseDay(String.valueOf(day));
    }

    @Then("la fecha seleccionada aparece en el campo de texto del proximo mes {int}")
    public void laFechaSeleccionadaApareceEnElCampoDeTextoDelProximoMes(int day) {
        datePickerSteps.validateDateOnDatePicker(dateHelper.getNextMonthDate(day));
    }


    @And("intento ingresar una fecha {string} manualmente en el campo de texto")
    public void intentoIngresarUnaFechaManualmentEnElCampDeTexto(String date) {
        datePickerSteps.typeOnInputDatePicker(date);
    }

    @Then("valido que no se permite la edicion manual y que solo es posible seleccionar una fecha desde el calendario")
    public void validoQueNoSePermiteLaEdicionManualYQueSoloEsPosibleSeleccionarUnaFechaDesdeElCalendario() {
        datePickerSteps.validateDatePickerIsClear();
    }
}
