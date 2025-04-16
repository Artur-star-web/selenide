package ru.netology.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import java.nio.channels.Selector;
import java.time.Duration;
import java.time.LocalDate;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    String expectedDate = DateGenerator.getDatePlusDays(3);




    @Test
    void shouldRegisterByAccountNumber() {
        open("http://localhost:9999");
        $("[data-test-id = 'city'] input").setValue("Казань");
        $("[data-test-id = 'date'] input").press(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").sendKeys(DateGenerator.getDatePlusDays(3));
        $("[data-test-id='name'] input").setValue("Иванов Иван");
        $("[data-test-id='phone'] input").setValue("+79270000000");
        $("[data-test-id='agreement']").click();
        $(".button").click();
        $(Selectors.withText("Успешно")).should(Condition.visible, Duration.ofSeconds(15));
        $("[class='notification__content']").shouldHave(Condition.text(expectedDate)).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    // @Test
    //void shouldRegisterByAccountNumber1(){
   //     open("http://localhost:9999");
     //   $("[data-test-id = 'city'] input").setValue("Мо");
       // $$(".menu-item__control").findBy(text("Москва")).shouldBe(visible).click();
        //$("[data-test-id = 'date'] input").press(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        //$("[data-test-id='date'] input").click();
        //$$("td").findBy(visible);
        //LocalDate targetDate = LocalDate.now().plusDays(3);
        //String day = String.valueOf(targetDate.getDayOfMonth());
        //$$("td").findBy(text(day))
               // .click();
    //}
}
