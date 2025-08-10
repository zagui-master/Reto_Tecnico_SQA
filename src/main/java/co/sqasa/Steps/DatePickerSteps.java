package co.sqasa.Steps;

import co.sqasa.pageObjects.DatePickerPageObject;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DatePickerSteps {

    @Page
    DatePickerPageObject datePickerPageObject;

    @Step
    public void openPage() {
        datePickerPageObject.openPage();
    }


    @Step
    public void clickOnInputDataPicker() {

        datePickerPageObject.clickOnInputDataPicker();
    }

    @Step
    public void chooseDay(String day) {
        datePickerPageObject.chooseDay(day);
    }

    @Step
    public void goToNextMonth() {
        datePickerPageObject.goToNexMonth();
    }

    @Step
    public void typeOnInputDatePicker(String value) {
        datePickerPageObject.typeOnInputDatePicker(value);
    }

    @Step
    public void validateDateOnDatePicker(String date) {
        String actualValue = datePickerPageObject.getDateFromDataPicker();
        assertThat(actualValue, containsString(date));
    }

    @Step
    public void validateDatePickerIsClear() {
        String actualValue = datePickerPageObject.getDateFromDataPicker();
        assertThat(actualValue, is(""));
    }

}
