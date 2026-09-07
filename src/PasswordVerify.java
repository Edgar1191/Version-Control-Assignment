// Class representing a validated Username and Password profile
public class PasswordVerify {
    private String username;
    private String password;

    /**
     * Constructor validates inputs against business rules before setting fields
     * Throws PasswordVerifyException if any rule is broken
     */
    public PasswordVerify(String username, String password) throws PasswordVerifyException {
        // Validate Username Rule 1: Must end in '!'
        if (username == null || !username.endsWith("!")) {
            throw new PasswordVerifyException(username, password, "Username must end with the character '!'");
        }

        // Validate Username Rule 2: Needs exactly 2 capital letters
        int upperCount = 0;
        for (int i = 0; i < username.length(); i++) {
            if (Character.isUpperCase(username.charAt(i))) {
                upperCount++;
            }
        }
        if (upperCount != 2) {
            throw new PasswordVerifyException(username, password, "Username must contain exactly 2 capital letters (Found: " + upperCount + ").");
        }

        // Validate Password Rule 1: Needs at least 3 vowels
        int vowelCount = 0;
        String lowerPassword = password.toLowerCase();
        for (int i = 0; i < lowerPassword.length(); i++) {
            char ch = lowerPassword.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }
        }
        if (vowelCount < 3) {
            throw new PasswordVerifyException(username, password, "Password must contain at least 3 vowels (Found: " + vowelCount + ").");
        }

        // Validate Password Rule 2: Needs exactly 3 digits
        int digitCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                digitCount++;
            }
        }
        if (digitCount != 3) {
            throw new PasswordVerifyException(username, password, "Password must contain exactly 3 digits (Found: " + digitCount + ").");
        }

        // If all rules pass, assign fields
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User Profile [Username: " + username + ", Password: " + password + "]";
    }
}