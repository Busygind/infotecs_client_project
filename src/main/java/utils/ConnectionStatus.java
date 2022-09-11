package utils;

/**
 * Enum with possible connection statuses and their info messages
 */
public enum ConnectionStatus {
    SUCCESS("Success!"),
    UNKNOWN_HOST("Unknown IP-address, try again"),
    INCORRECT_LOGIN("Login or password is incorrect, try again"),
    MALFORMED_HOST("Server address is incorrect, try again"),
    FILE_NOT_FOUND("The file named \"students.json\" is not on the specified server. "
            + "Check the contents of the server storage. The connection is broken."),
    WRONG_PASSWORD("The password is wrong or empty, try again"),
    NULL_POINTER("Connection error, try again");

    private final String message;

    ConnectionStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
