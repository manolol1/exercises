package EX_3;

public class Main {
    public static void main(String[] args) {
        String s1 = "Test string";
        String s2 = "Test";
        String s3 = "Test";
        String s4 = "string";
        String s5 = "test";
        String s6 = "This is a test string";

        System.out.println(startsWith(s1, s2));
        System.out.println(startsWith(s1, s4));
        System.out.println(endsWith(s1, s4));
        System.out.println(endsWith(s1, s2));
        System.out.println(equals(s2, s3));
        System.out.println(equals(s1, s2));
        System.out.println(equalsIgnoreCase(s2, s5));
        System.out.println(contains(s6, s5));
        System.out.println(contains(s6, s2));
        System.out.println(toLowerCase(s1));
        System.out.println(toUpperCase(s1));
    }

    public static String toLowerCase(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) (c + 32));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static String toUpperCase(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append((char) (c - 32));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static boolean startsWith(String s, String prefix) {
        if (s == null || prefix == null) {
            return false;
        }

        if (prefix.length() > s.length()) {
            return false;
        }

        for (int i = 0; i < prefix.length(); i++) {
            if (s.charAt(i) != prefix.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean endsWith(String s, String suffix) {
        if (s == null || suffix == null) {
            return false;
        }

        if (suffix.length() > s.length()) {
            return false;
        }

        int suffixIndex = suffix.length() - 1;
        for (int i = s.length() - 1; i >= s.length() - suffix.length(); i--) {
            if (s.charAt(i) != suffix.charAt(suffixIndex)) {
                return false;
            }
            suffixIndex--;
        }

        return true;
    }

    public static boolean equals(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean equalsIgnoreCase(String s1, String s2) {
        return equals(toLowerCase(s1), toLowerCase(s2));
    }

    public static boolean contains(String s, String substring) {
        if (s == null || substring == null) {
            return false;
        }

        if (substring.length() > s.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == substring.charAt(0)) {
                boolean found = true;
                for (int j = 1; j < substring.length(); j++) {
                    if (s.charAt(i + j) != substring.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return true;
                }
            }
        }

        return false;
    }

}
