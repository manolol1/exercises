package EX_2;

import JavaUtils.*;

public class Main {
    public static void main(String[] args) {
        int repetitions = 100;
        int stringLength = 10000;

        System.out.println(Timer.benchmarkFunctionExecTime(Function -> testStringBuilder(stringLength), repetitions));
        System.out.println(Timer.benchmarkFunctionExecTime(Function -> testStringBuffer(stringLength), repetitions));
        System.out.println(Timer.benchmarkFunctionExecTime(Function -> testString(stringLength), repetitions));
    }

    private static String testStringBuilder(int stringLength) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringLength; i++) {
            sb.append((char) JavaUtils.random(65, 90));
        }

        return sb.toString();
    }

    private static String testStringBuffer(int stringLength) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stringLength; i++) {
            sb.append((char) JavaUtils.random(65, 90));
        }

        return sb.toString();
    }

    private static String testString(int stringLength) {
        String s = new String();
        for (int i = 0; i < stringLength; i++) {
            s += (char) JavaUtils.random(65, 90);
        }

        return s;
    }
}
