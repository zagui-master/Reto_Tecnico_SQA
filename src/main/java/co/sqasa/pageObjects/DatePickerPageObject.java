package co.sqasa.pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;


public class DatePickerPageObject extends PageObject {

    @FindBy(id = "datepicker")
    WebElementFacade inputDatePicker;

    @FindBy(xpath = "//span[text()='Next']")
    WebElementFacade iconDatePickerNext;


    public void openPage() {
        getDriver().get("https://jqueryui.com/datepicker/");
        getDriver().switchTo().frame(getDriver().findElement(By.className("demo-frame")));
    }


    public void clickOnInputDataPicker() {
        inputDatePicker.click();
    }

    public void chooseDay(String day) {
        String dayLocator = String.format("//a[text()='%s']", day);
        findBy(dayLocator).click();
    }

    public void goToNexMonth() {
        iconDatePickerNext.click();
    }

    public void typeOnInputDatePicker(String value) {
        inputDatePicker.sendKeys(value);
    }

    public String getDateFromDataPicker() {
        return inputDatePicker.getValue();
    }

}
