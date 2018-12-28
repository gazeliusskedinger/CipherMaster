package Ciphers;

public interface ICipher {

    String encrypt(String plain, String key);

    String decrypt(String cipher, String key);

    void analysis(String cipher);

    String brute(String cipher);
}
