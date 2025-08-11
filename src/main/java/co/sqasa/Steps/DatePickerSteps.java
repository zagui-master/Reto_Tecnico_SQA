package co.sqasa.Steps;

import co.sqasa.pageObjects.DatePickerPageObject;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DatePickerSteps {

    @Page
    DatePickerPageObject datePickerPageObject;

    @Step("Abre la página web")
    public void openPage() {
        datePickerPageObject.openPage();
    }


    @Step("Selecciona él date picker")
    public void clickOnInputDataPicker() {

        datePickerPageObject.clickOnInputDataPicker();
    }

    @Step("Selecciona un día del calendario")
    public void chooseDay(String day) {
        datePickerPageObject.chooseDay(day);
    }

    @Step("Navega al mes siguiente")
    public void goToNextMonth() {
        datePickerPageObject.goToNexMonth();
    }

    @Step("Ingresa una fecha manualmente al date picker")
    public void typeOnInputDatePicker(String value) {
        datePickerPageObject.typeOnInputDatePicker(value);
    }

    @Step("Válida fecha en él date picker")
    public void validateDateOnDatePicker(String date) {
        String actualValue = datePickerPageObject.getDateFromDataPicker();
        assertThat(actualValue, containsString(date));
    }

    @Step("válida que él date picker esta vacío")
    public void validateDatePickerIsClear() {
        String actualValue = datePickerPageObject.getDateFromDataPicker();
        assertThat(actualValue, is(""));
    }

}
