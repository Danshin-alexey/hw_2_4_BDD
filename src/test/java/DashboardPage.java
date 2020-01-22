import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement FirstCard = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement firstCardButton = FirstCard.$("[data-test-id = action-deposit]");
    private SelenideElement SecondCard = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private SelenideElement secondCardButton = SecondCard.$("[data-test-id = action-deposit]");
    private static SelenideElement fieldTransactionAmount = $("[data-test-id = amount] input");
    private SelenideElement fieldCardNumberFrom = $("[data-test-id = from] input");
    private SelenideElement transferActionButton = $("[data-test-id = action-transfer]");

    public void dashboardPageVisible() {

        heading.shouldBe(visible);
    }

    public static void validAmountInput(String amount) {
        fieldTransactionAmount.setValue(DataHelper.Amount.getAmount(amount));
    }


    public void cardNumberInput(DataHelper.NumberCard number) {
        fieldCardNumberFrom.setValue(number.getCardNumber());
    }

    public void choiceFirstCard() {
        firstCardButton.click();
    }

    public void choiceSecondCard() {
        secondCardButton.click();
    }

    public void clickTransferActionButton() {
        transferActionButton.click();
    }


    public static class CurrentBalance {
        private static SelenideElement FirstCard = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
        private static SelenideElement SecondCard = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");

        public static int GetFirstCardBalance() {
            String balanceText = FirstCard.getText();
            int startInd = balanceText.indexOf("баланс: ");
            int finishInd = balanceText.indexOf(" р.");
            String balance = balanceText.substring(startInd + 8, finishInd);
            return Integer.parseInt(balance)    ;
        }

        public static int GetSecondCardBalance () {
            String balanceText = SecondCard.getText();
            int startInd = balanceText.indexOf("баланс: ");
            int finishInd = balanceText.indexOf(" р.");
            String balance = balanceText.substring(startInd + 8, finishInd);
            return Integer.parseInt(balance)    ;
        }
    }
}