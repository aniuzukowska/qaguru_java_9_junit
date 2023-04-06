import com.codeborne.selenide.Selenide;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainMenuTest {

    @ValueSource(strings = {
            "История", "Просмотр кода"
    })
    @ParameterizedTest(name="В меню справа выбрать вкладку {0}")
    public void openedPageShouldHaveTitleGivenButtonsMainMenu_1(String testData) {
        Selenide.open("https://ru.wikipedia.org/wiki/Заглавная_страница");
        $$(".vector-menu-content-list span").find(text(testData)).click();
        $("#firstHeading").shouldHave(text("Заглавная страница"));
    }

    @CsvSource(value = {
            "История, Заглавная страница: история изменений",
            "Просмотр кода, Просмотр кода страницы Заглавная страница"
    })
    @ParameterizedTest(name="В меню справа выбрать вкладку {0}, проверить, что открылась страница {1}")
    public void openedPageShouldHaveTitleGivenButtonsMainMenu_2(String testData, String expectedText) {
        Selenide.open("https://ru.wikipedia.org/wiki/Заглавная_страница");
        $$(".vector-menu-content-list span").find(text(testData)).click();
        $("#firstHeading").shouldHave(text(expectedText));
    }

    @CsvFileSource(resources = "/testdata/openedPageShouldHaveTitleGivenButtonsMainMenu_3.csv")
    @ParameterizedTest(name="В меню справа выбрать вкладку {0}, проверить, что открылась страница {1}")
    public void openedPageShouldHaveTitleGivenButtonsMainMenu_3(String testData, String expectedText) {
        Selenide.open("https://ru.wikipedia.org/wiki/Заглавная_страница");
        $$(".vector-menu-content-list span").find(text(testData)).click();
        $("#firstHeading").shouldHave(text(expectedText));
    }

    static Stream<Arguments> openedPageShouldHaveTitleGivenButtonsMainMenu_4() {
        return Stream.of(
                Arguments.of("История", "Заглавная страница: история изменений"),
                Arguments.of("Просмотр кода", "Просмотр кода страницы Заглавная страница")
        );
    }

    @MethodSource()
    @ParameterizedTest(name="В меню справа выбрать вкладку {0}, проверить, что открылась страница {1}")
    public void openedPageShouldHaveTitleGivenButtonsMainMenu_4(String testData, String expectedText) {
        Selenide.open("https://ru.wikipedia.org/wiki/Заглавная_страница");
        $$(".vector-menu-content-list span").find(text(testData)).click();
        $("#firstHeading").shouldHave(text(expectedText));
    }
}

