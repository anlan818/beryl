package hc.spring;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.*;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() throws NoSuchAlgorithmException {
        // Generate a key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair keyPair = keyGen.generateKeyPair();

// Get the public and private keys
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println(Base64.encodeBase64String(publicKey.getEncoded()));
        System.out.println(Base64.encodeBase64String(privateKey.getEncoded()));

    }

}
