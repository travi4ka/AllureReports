package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class GitPage {
    public static final String
            SEARCH = "selenide",
            REPOSITORY = "selenide/selenide",
            ISSUE_NUMBER = "2130",
            EXPECTEDTEXT = "Add conditions oneOfTexts, oneOfExactTexts, oneOfTextsCaseSensitive, oneOfExactTextsCaseSensitive";

    public static final SelenideElement
            searchInput = $("[name=q]"),
            issuesTab = $("#issues-tab"),
            issue = $("#issue_" + ISSUE_NUMBER + "_link");

    public GitPage openPage() {
        open("");
        return this;
    }

    public GitPage setValueToTheSearchField() {
        searchInput.setValue(SEARCH).pressEnter();
        return this;
    }

    public GitPage openRepository() {
        $(linkText(REPOSITORY)).click();
        return this;
    }

    public GitPage openIssuesTab() {
        issuesTab.click();
        return this;
    }

    public GitPage checkIssue() {
        issue.shouldHave(text(EXPECTEDTEXT));
        return this;
    }

    @Step("Open page")
    public GitPage openPageWebSteps() {
        openPage();
        return this;
    }

    @Step("Set " + SEARCH + " to search field")
    public GitPage setValueToTheSearchFieldWebSteps() {
        setValueToTheSearchField();
        return this;
    }

    @Step("Opening of " + REPOSITORY + " repository")
    public GitPage openRepositoryWebSteps() {
        openRepository();
        return this;
    }

    @Step("Opening of issues tab")
    public GitPage openIssuesTabWebSteps() {
        openIssuesTab();
        return this;
    }

    @Step("Checking issue has " + EXPECTEDTEXT)
    public GitPage checkIssueWebSteps() {
        checkIssue();
        return this;
    }

}
