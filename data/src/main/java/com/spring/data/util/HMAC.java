package com.spring.data.util;

import com.google.common.io.BaseEncoding;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;

/**
 * Created by mint on 8/19/18.
 */
public abstract class HMAC {

    private static final Hash hash = Hash.SHA512;

    public static String hash(String key, String message) {
        final Charset CHARSET_UTF_8 = Charset.forName("UTF-8");
        final String algorithm = "Hmac" + hash.value;
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(CHARSET_UTF_8), algorithm);
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(keySpec);
            return BaseEncoding.base64().encode(mac.doFinal(message.getBytes(CHARSET_UTF_8)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public enum Hash {
        MD5("MD5"), SHA1("SHA1"), SHA256("SHA256"), SHA512("SHA512");

        Hash(String value) {
            this.value = value;
        }

        final String value;
    }
}
