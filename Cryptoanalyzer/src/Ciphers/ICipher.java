package Ciphers;

public interface ICipher {

    public String encrypt(String plain, String key);

    public String decrypt(String cipher, String key);

    public void analysis(String cipher);

    public String brute(String cipher);

}
