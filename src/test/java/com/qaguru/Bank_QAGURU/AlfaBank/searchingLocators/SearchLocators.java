package com.qaguru.Bank_QAGURU.AlfaBank.searchingLocators;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchLocators {

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
    }

    @DisplayName("Поиск sibling")
    @Test
    void siblingSearchTest() {

        open("https://alfabank.ru/");
        $("span.p1Cda9K").sibling(0).click();
        $("body").shouldHave(text("Накопительные продукты"));
        $("[data-test-id='tabs-list'] button").sibling(0).click();
        $("body").
                shouldHave(text("Альфа-Банк является участником системы обязательного страхования вкладов"));
    }

    @DisplayName("Поиск parent")
    @Test
    void parentSearchTest() {
        open("https://alfabank.ru/");
        $x("//*[@class='F1Cda9K']/..//span[@class='p1Cda9K'][2]").click();
        $("body").shouldHave(text("Накопительные продукты"));
        $x("//*[@id='footer']/..//div[@id='good-to-know']//button[@data-test-id='tabs-list-tabTitle-1']").click();
        $("body").shouldHave(text("Альфа-Банк является участником системы обязательного страхования вкладов"));
    }

    @DisplayName("Поиск preceding")
    @Test
    void precedingSearchTest() {
        open("https://alfabank.ru/make-money/");
        $("[data-test-id='tabs-list-tabTitle-2']").preceding(1).click();
        $("body").shouldHave(text("Альфа-Банк является участником системы обязательного страхования вкладов"));

        sleep(3000);
    }

    @DisplayName("Поиск closest")
    @Disabled
    @Test
//    Не смог подобрать локатор
    void closestSearchTest() {
        open("https://alfabank.ru/make-money/");
        $("[data-test-id='tabs-list-tabTitle-2']").closest(".aw_H28R Jw_H28R kw_H28R").click();
        $("body").shouldHave(text("Альфа-Банк является участником системы обязательного страхования вкладов"));
        sleep(3000);
    }

}
