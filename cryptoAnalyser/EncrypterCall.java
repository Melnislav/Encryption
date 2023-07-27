interface EncrypterCall {
    default void cesar() {
        Cesar cesarEncryption = new Cesar(Ui.getInstance().getShiftCesar(), Ui.getInstance().getFileAddress(), Ui.getInstance().getInputStreamReader());
        cesarEncryption.crypt();
        Ui.getInstance().cryptSuccessfulMessage();
    }

    default void bruteForce() {
        BruteForce bruteForceDecryption = new BruteForce(Ui.getInstance().getFileAddress(), Ui.getInstance().getInputStreamReader());
        bruteForceDecryption.crypt();
        Ui.getInstance().cryptSuccessfulMessage();
    }
}