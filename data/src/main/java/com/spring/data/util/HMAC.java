package com.spring.data.util;

import com.google.common.io.BaseEncoding;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;

/**
 * Created by mint on 8/19/18.
 */
public abstract class HMAC {
    public static String hash(String key, String message) {
        final Charset CHARSET_UTF_8 = Charset.forName("UTF-8");
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(CHARSET_UTF_8), "HmacSHA512");
        try {
            Mac mac = Mac.getInstance("HmacSHA512");
            mac.init(keySpec);
            return BaseEncoding.base64().encode(mac.doFinal(message.getBytes(CHARSET_UTF_8)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
