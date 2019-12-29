import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

class ManyTransferTest {
    @Test
    void shouldTransferManyBetweenOwnCards () {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
    }
    @DisplayName("Should not transfer money from card with a negative balance(bug)")
    @Test
    void shouldNotTransferMoneyFromCardWithANegativeBalance() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val dashBoardPage = new DashboardPage();
        dashBoardPage.transferMoneyFromNegativeBalance();
        dashBoardPage.dashboardPageVisible();
    }

    @DisplayName("Should transfer money to first card")
    @Test
    void shouldTransferMoneyToFirstCard () {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val dashboardPage = new DashboardPage();
        dashboardPage.transferMoneyToFirstCard();
        dashboardPage.dashboardPageVisible();
    }

    @DisplayName("Should transfer money to last card")
    @Test
    void shouldTransferMoneyToLastCard () {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val dashBoardPage = new DashboardPage();
        dashBoardPage.transferMoneyToLastCard();
        dashBoardPage.dashboardPageVisible();
    }
}