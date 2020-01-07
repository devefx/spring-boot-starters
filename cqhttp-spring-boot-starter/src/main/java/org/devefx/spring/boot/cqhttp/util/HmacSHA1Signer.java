package org.devefx.spring.boot.cqhttp.util;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSHA1Signer {
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    /**
     * Sign the given message using the given secret.
     * @param message message to sign
     * @param secret secret key
     * @return a signed message
     */
    public static String sign(byte[] message, String secret) {
        try {
            Mac sha256_HMAC = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), HMAC_SHA1_ALGORITHM);
            sha256_HMAC.init(secretKeySpec);
            return new String(Hex.encodeHex(sha256_HMAC.doFinal(message)));
        } catch (Exception e) {
            throw new RuntimeException("Unable to sign message.", e);
        }
    }
}
