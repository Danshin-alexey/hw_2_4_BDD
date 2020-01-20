import lombok.Value;

public class DataHelper {
    private DataHelper () {
    }

    @Value
    public static class AuthInfo {
        public String login;
        public String password;
    }

    public static AuthInfo getAuthInfo () {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        public String code;
    }

    public static VerificationCode getVerificationCodeFor (AuthInfo authInfo) {

        return new VerificationCode("12345");
    }

    @Value
    public static class NumberCard {
        public String cardNumber;
    }

    public static NumberCard getFirstCardNumber () {
        return new NumberCard("5559 0000 0000 0001");
    }

    public static NumberCard getSecondCardNumber () {
        return new NumberCard("5559 0000 0000 0002");
    }

    @Value
    public static class Amount {
        public String amount;

        public static String getAmount (String amount) {
            return amount;
        }
    }
}






