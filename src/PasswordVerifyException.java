// Custom exception class thrown when username or password validation rules are breached
public class PasswordVerifyException extends Exception {
    private String username;
    private String password;

    // Constructor accepting username, password, and a descriptive error message
    public PasswordVerifyException(String username, String password, String message) {
        super(message);
        this.username = username;
        this.password = password;
    }

    // Getters if needed for further extension
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}