package leetcode.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

import org.apache.commons.codec.binary.Hex;


public class EncriptionUtils {

    public static long getCRC32(String s) {
        byte[] bytes = s.getBytes();
        Checksum checksum = new CRC32();
        checksum.update(bytes, 0, bytes.length);
        return checksum.getValue();
    }
    
    public static String getMD5(String s) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] digest = messageDigest.digest(s.getBytes());
        char[] hex = Hex.encodeHex(digest);
        return new String(hex);
    }
    
    public static void main(String[] args) throws Exception {
        String input1 = "Java Code Geeks - Java Examples";
        String input2 = "Java Code Geeka - Java Examples";
        System.out.println(getCRC32(input1));
        System.out.println(getCRC32(input2));
        System.out.println("This is a Java string".hashCode());
        System.out.println(getMD5("This is a Java string"));
    }
}
