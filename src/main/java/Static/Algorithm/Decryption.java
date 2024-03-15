package Static.Algorithm;

public class Decryption {
    public String encryptData(String data) {
        return AES.decrypt(data);
    }
}
