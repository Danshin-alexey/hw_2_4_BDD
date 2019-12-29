import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public VerificationPage validLogin(DataHelper.AuthInfo Info){
        $("[data-test-id=login] input").setValue(Info.getLogin());
        $("[data-test-id=password] input").setValue(Info.getPassword());
        $("[data-test-id=action-login]").click();
        return new VerificationPage();
    }
}
