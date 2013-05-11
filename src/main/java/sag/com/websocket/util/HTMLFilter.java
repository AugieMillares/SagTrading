package sag.com.websocket.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Augie
 * Date: 4/7/13
 * Time: 8:45 PM
 * <p/>
 * Modification:
 * ----------------------------
 */


public class HTMLFilter {
    public static String filter(String message) {
        if (message == null) return null;

        char[] content = new char[message.length()];
        message.getChars(0, message.length(), content, 0);
        StringBuilder result = new StringBuilder(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            SpecialChar specialChar = SpecialChar.check(content[i]);
            if(specialChar != null) result.append(specialChar.toString());
            else result.append(content[i]);
        }
        return result.toString();
    }

    private enum SpecialChar {
        GREATERTHAN('>'),
        LESSTHAN('<'),
        AND('&'),
        QUOTE('"');
        private final Map<Character, String> CharEQ = new HashMap<Character, String>() {{
            put('>', "&gt;");
            put('<', "&lt;");
            put('"', "&quote;");
            put('&', "&amp;");
        }};
        private char value;

        private SpecialChar(char value) {
            this.value = value;
        }

        public static SpecialChar check(char charValue){
            for(SpecialChar specialChar: SpecialChar.values()){
                if(specialChar.value == charValue)
                    return specialChar;
            }
            return null;
        }

        public String toString() {
            return CharEQ.get(value);
        }
    }


}
