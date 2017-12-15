package org.sarace.codewars;

/**
 * Created by sarace on 15/12/17.
 */
public class SimpleEncryption1 {
    public static String encrypt(final String text, final int n) {
        return whatCrypt(text, n, true);
    }

    public static String decrypt(final String encryptedText, final int n) {
        return whatCrypt(encryptedText, n, false);
    }

    private static String whatCrypt(String text, int n, boolean do_encrypt) {
        if(text == null || text.isEmpty() || n <= 0) {
            return text;
        } else if (do_encrypt){
            return whatCrypt(encryptOnce(text), n - 1, do_encrypt);
        } else {
            return whatCrypt(decryptOnce(text), n - 1, do_encrypt);
        }
    }

    private static String encryptOnce(String text) {
        StringBuilder leftStringBuilder = new StringBuilder();
        StringBuilder rightStringBuilder = new StringBuilder();
        Integer idx = 1;
        for (Character m: text.toCharArray()){
            if (idx % 2 == 0){
                leftStringBuilder.append(m);
            } else {
                rightStringBuilder.append(m);
            }
            idx++;
        }
        return leftStringBuilder.toString() + rightStringBuilder.toString();
    }

    private static String decryptOnce(String encryptedText) {
        String leftString = encryptedText.substring(0, (encryptedText.length() / 2));
        String rightString = encryptedText.substring(encryptedText.length() / 2);
        StringBuilder resultBuiilder = new StringBuilder();
        Integer idx = 0;
        for(Character m: rightString.toCharArray()){
            resultBuiilder.append(m);
            if(leftString.length() > idx){
                resultBuiilder.append(leftString.charAt(idx));
            }
            idx++;
        }
        return resultBuiilder.toString();
    }


}
