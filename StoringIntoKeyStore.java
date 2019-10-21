import java.io.FileInputStream;
import java.security.KeyStore;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class StoringIntoKeyStore
{
    public static void main(String args[]) throws Exception
    {
        // Creating the KeyStore object
        KeyStore keyStore = KeyStore.getInstance("JCEKS");

        // Loading the KeyStore object
        // use same password when keystore is created in Makefile
        char[] password = "changeit".toCharArray(); 
        String path = "keystore";
        java.io.FileInputStream fis = new FileInputStream(path);
        keyStore.load(fis, password);

        // Creating the KeyStore.ProtectionParameter object
        KeyStore.ProtectionParameter protectionParam
            = new KeyStore.PasswordProtection(password);

        // Creating SecretKey object
        SecretKey mySecretKey
            = new SecretKeySpec("myPassword".getBytes(), "DSA");

        // Creating SecretKeyEntry object
        KeyStore.SecretKeyEntry secretKeyEntry
            = new KeyStore.SecretKeyEntry(mySecretKey);
        keyStore.setEntry("secretKeyAlias", secretKeyEntry, protectionParam);

        // Storing the KeyStore object
        java.io.FileOutputStream fos = null;
        fos = new java.io.FileOutputStream("keystore1");
        keyStore.store(fos, password);
        System.out.println("data stored");
    }
}
