public enum CryptionMethod {
    CESAR_ENCRYPTION_METHOD(0, "Cesar Encryption Method"),
    CESAR_DECRYPTION_METHOD(1, "Cesar Decryption Method"),
    BRUTE_FORCE_DECRYPTION_METHOD(2, "Brute Force Decryption Method");

    private final int id;
    private final String displayMethodName;

    CryptionMethod(int id, String displayName) {
        this.id = id;
        this.displayMethodName = displayName;
    }

    public int getId() {
        return id;
    }

    public String getDisplayMethodName() {
        return displayMethodName;
    }
}