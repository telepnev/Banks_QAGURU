package com.qaguru.Bank_QAGURU.AlfaBank;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBankDepositTest {
    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
    }

    @Test
    public void depositTest() {
        open("https://alfabank.ru/");
        $(byText("Вклады")).click();
        $x("//a[@href='/make-money/deposits/']/button").click();
        $x("//a[@href='/make-money/archive/']/button").click();
        $$(byText("Депозиты")).find(visible).click();
        $("body").shouldHave(text("Архивные счета и депозиты"));
        $("#filter").$$("[data-widget-name='CatalogCard']").shouldHaveSize(5);
    }
}
