package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$x;

import java.io.File;

public class TextBoxTests {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void fillFormTest() {
        String name = "Egor";

        open("/automation-practice-form");
        //       $("[id="firstName"]").setValue("Egor");
        $("#firstName").setValue(name);
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("Egor@egor.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("11231231212");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--003:not(.react-datepicker__day--selected").click();
        $x("//input[@id='subjectsInput']").setValue("Arts").pressEnter();
        $(By.xpath("//div[@id='hobbiesWrapper']//label[contains(text(),'Music')]")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/Test.jpg"));
        $("#currentAddress").setValue("Some address 1");
        $x("//input[@id='react-select-3-input']").setValue("Uttar Pradesh").pressEnter();
        $x("//input[@id='react-select-4-input']").setValue("Merrut").pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Egor Egorov"),
                text("Ivan.Petrov@test.com"),
                text("Male"),
                text("11231231212"),
                text("3 September,1988"),
                text("Arts"),
                text("Music"),
                text("Test.jpg"),
                text("Some address 1"),
                text("Uttar Pradesh Merrut"));
    }
}