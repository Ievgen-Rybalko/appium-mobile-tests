package net.testiteasy.screens.main;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.testiteasy.utils.variables.OSType;

import static net.testiteasy.utils.parameters.TestDataParams.testConfig;

@SuppressWarnings("unused")
public class MainScreen {

    @iOSXCUITFindBy(id = "Skip")
    private SelenideElement SKIP_BUTTON;

    @AndroidFindBy(id = "android:id/button1")
    private SelenideElement ANDROID_COMPAT_DIALOG_DISMISS;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Explore\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Explore\"]")
    private SelenideElement EXPLORE_ICON;

    @AndroidFindBy(id = "org.wikipedia.dev:id/nav_tab_search")
    private SelenideElement SEARCH_TAB;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name='Search Wikipedia']")
    private SelenideElement SEARCH_WIKIPEDIA_FIELD;

    @AndroidFindBy(className = "android.widget.Button")
    private SelenideElement ONBOARDING_NEXT_BUTTON;

    @AndroidFindBy(
            xpath = "//androidx.compose.ui.platform.ComposeView" +
                    "/android.view.View" +
                    "/android.view.View" +
                    "/android.widget.Button"
    )
    private SelenideElement SEARCH_POPUP_CLOSE;

    public void waitForMainContainerToAppear() {

        if (testConfig().getOSType() == OSType.ANDROID) {

            completeOnboarding();

            for (int i = 0; i < 3; i++) {

                if (ANDROID_COMPAT_DIALOG_DISMISS.is(Condition.visible)) {
                    ANDROID_COMPAT_DIALOG_DISMISS.click();
                } else {
                    break;
                }
            }
        }

        if (testConfig().getOSType() == OSType.IOS) {

            if (SKIP_BUTTON.is(Condition.visible)) {
                SKIP_BUTTON.click();
            }
        }
    }

    public void completeOnboarding() {
        for (int i = 0; i < 4; i++) {
            ONBOARDING_NEXT_BUTTON
                    .shouldBe(Condition.visible)
                    .click();
        }
    }

    public void checkExploreIcon() {
        EXPLORE_ICON.shouldBe(Condition.visible);
    }

    public void closeSearchPopupIfPresent() {

        if (testConfig().getOSType() == OSType.ANDROID
                && SEARCH_POPUP_CLOSE.is(Condition.visible)) {

            SEARCH_POPUP_CLOSE.click();
        }
    }

    public void clickOnSearchField() {

        if (testConfig().getOSType() == OSType.ANDROID) {

            SEARCH_TAB
                    .shouldBe(Condition.visible)
                    .click();

            closeSearchPopupIfPresent();

        } else {

            SEARCH_WIKIPEDIA_FIELD
                    .shouldBe(Condition.visible)
                    .click();
        }
    }
}