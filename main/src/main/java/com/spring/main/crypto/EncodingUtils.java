package com.spring.main.crypto;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;

/**
 * Replaced by com.google.guava: BaseEncoding
 */

public final class EncodingUtils {

    private static final String UTF_8 = "UTF-8";

    private static Charset CHARSET_UTF_8 = Charset.forName(UTF_8);

    public static String hex(byte[] bytes) {
        return new String(Hex.encodeHex(bytes));
    }

    public static byte[] decodeHex(String text) {
        try {
            return Hex.decodeHex(text.toCharArray());
        } catch (DecoderException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String base64(String text) {
        return base64(text.getBytes(CHARSET_UTF_8));
    }

    public static String base64(byte[] bytes) {
        return new String(Base64.encodeBase64(bytes), CHARSET_UTF_8);
    }

    public static byte[] decodeBase64(String base64Text) {
        return decodeBase64(base64Text.getBytes(CHARSET_UTF_8));
    }

    public static byte[] decodeBase64(byte[] base64Bytes) {
        return Base64.decodeBase64(base64Bytes);
    }

    public static String base64URLSafe(byte[] bytes) {
        return new String(Base64.encodeBase64URLSafe(bytes), CHARSET_UTF_8);
    }

    public static String url(String text) {
        try {
            return URLEncoder.encode(text, UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String decodeURL(String text) {
        try {
            return URLDecoder.decode(text, UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    private EncodingUtils() {
    }
}

