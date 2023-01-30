package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static pages.GitPage.*;

public class Tests extends TestBase {
    @Test
    @DisplayName("Just Listener")
    @Owner("Сергей Жихарев")
    @Feature("Issue " + ISSUE_NUMBER + " в репозитории " + REPOSITORY)
    @Story("Проверка Issue " + ISSUE_NUMBER)
    @Severity(SeverityLevel.CRITICAL)
    void checkIssue() {
        gitPage.openPage()
                .setValueToTheSearchField()
                .openRepository()
                .openIssuesTab()
                .checkIssue();
    }

    @Test
    @DisplayName("Lambda steps (name, () -> {})")
    @Owner("Сергей Жихарев")
    @Feature("Issue " + ISSUE_NUMBER + " в репозитории " + REPOSITORY)
    @Story("Проверка Issue " + ISSUE_NUMBER)
    @Severity(SeverityLevel.CRITICAL)
    void checkIssueLambda() {
        step("Open main page", () -> {
            gitPage.openPage();
        });
        step("Set value " + SEARCH + " to find repository", () -> {
            gitPage.setValueToTheSearchField();
        });
        step("Open repository" + REPOSITORY, () -> {
            gitPage.openRepository();
        });
        step("Open issue tab ", () -> {
            gitPage.openIssuesTab();
        });
        step("Checking issue number " + ISSUE_NUMBER, () -> {
            gitPage.checkIssue();
        });
    }

    @Test
    @DisplayName("WebSteps")
    @Owner("Сергей Жихарев")
    @Feature("Issue " + ISSUE_NUMBER + " в репозитории " + REPOSITORY)
    @Story("Проверка Issue " + ISSUE_NUMBER)
    @Severity(SeverityLevel.CRITICAL)
    void checkIssueWebSteps() {
        gitPage.openPageWebSteps()
                .setValueToTheSearchFieldWebSteps()
                .openRepositoryWebSteps()
                .openIssuesTabWebSteps()
                .checkIssueWebSteps();
    }
}
