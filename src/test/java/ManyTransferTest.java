import lombok.val;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManyTransferTest {

    @BeforeEach
    void shouldTransferManyBetweenOwnCards () {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
    }

    @Test
    @DisplayName("Should transfer money to first card")
    void shouldTransferMoneyToFirstCard() {
        int StartFirstCardBalance = DashboardPage.GetFirstCardBalance();
        int StartSecondCardBalance = DashboardPage.GetSecondCardBalance();
        String amount = "500";
        int amountInt = Integer.parseInt(amount);
        int ExpectedFirstCardBalance = StartFirstCardBalance + amountInt;
        int ExpectedSecondCardBalance = StartSecondCardBalance - amountInt;
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.choiceFirstCard();
        dashboardPage.validAmountInput(amount);
        dashboardPage.cardNumberInput(DataHelper.getSecondCardNumber());
        dashboardPage.clickTransferActionButton();
        int NextFirstCardBalance = DashboardPage.GetFirstCardBalance();
        int NextSecondCardBalance = DashboardPage.GetSecondCardBalance();
        assertEquals(ExpectedFirstCardBalance, NextFirstCardBalance);
        assertEquals(ExpectedSecondCardBalance, NextSecondCardBalance);
        dashboardPage.dashboardPageVisible();
    }

    @Test
    @DisplayName("Should transfer money to second card")
    void shouldTransferMoneyToSecondCard() {
        int StartFirstCardBalance = DashboardPage.GetFirstCardBalance();
        int StartSecondCardBalance = DashboardPage.GetSecondCardBalance();
        String amount = "500";
        int amountInt = Integer.parseInt(amount);
        int ExpectedFirstCardBalance = StartFirstCardBalance - amountInt;
        int ExpectedSecondCardBalance = StartSecondCardBalance + amountInt;
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.choiceSecondCard();
        dashboardPage.validAmountInput(amount);
        dashboardPage.cardNumberInput(DataHelper.getFirstCardNumber());
        dashboardPage.clickTransferActionButton();
        int NextFirstCardBalance = DashboardPage.GetFirstCardBalance();
        int NextSecondCardBalance = DashboardPage.GetSecondCardBalance();
        assertEquals(ExpectedFirstCardBalance, NextFirstCardBalance);
        assertEquals(ExpectedSecondCardBalance, NextSecondCardBalance);
        dashboardPage.dashboardPageVisible();
    }
    @DisplayName("Should not transfer money from card with a negative balance(bug)")
    @Test
    void shouldNotTransferMoneyFromCardWithANegativeBalance() {
        String amount = "500000";
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.choiceSecondCard();
        dashboardPage.validAmountInput(amount);
        dashboardPage.cardNumberInput(DataHelper.getFirstCardNumber());
        dashboardPage.clickTransferActionButton();
        dashboardPage.dashboardPageVisible();
    }

}