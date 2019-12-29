import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement buttonBalance1 = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] button");
    private SelenideElement buttonBalance2 = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] button");
    private SelenideElement amountToTransfer=$(".input__control");
    private SelenideElement from = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement refill = $("[data-test-id='action-transfer']");

    public void dashboardPageVisible() {

        heading.shouldBe(visible);
    }

        public void transferMoneyToFirstCard() {
        buttonBalance1.click();
        amountToTransfer.setValue("500");
        from.setValue(DataHelper.CartData.getNumberLastCard());
        refill.click();
    }

    public void transferMoneyToLastCard() {
        buttonBalance2.click();
        amountToTransfer.setValue("500");
        from.setValue(DataHelper.CartData.getNumberFirstCard());
        refill.click();
    }

    public void transferMoneyFromNegativeBalance() {
        buttonBalance1.click();
        amountToTransfer.setValue("100000");
        from.setValue(DataHelper.CartData.getNumberFirstCard());
        refill.click();
    }
}

