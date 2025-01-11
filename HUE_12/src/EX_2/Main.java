package EX_2;

import JavaUtils.*;

public class Main {
    public static void main(String[] args) {
        int repetitions = 100;
        int stringLength = 20000;

        long timeStringBuilder = Timer.benchmarkFunctionExecTime(Function -> testStringBuilder(stringLength), repetitions);
        System.out.printf("StringBuilder:\t\t\t%d ns (=%f ms)%n", timeStringBuilder, Timer.toMillisecondsDouble(timeStringBuilder));

        long timeStringBuffer = Timer.benchmarkFunctionExecTime(Function -> testStringBuffer(stringLength), repetitions);
        System.out.printf("StringBuffer:\t\t\t%d ns (=%f ms)%n", timeStringBuffer, Timer.toMillisecondsDouble(timeStringBuffer));

        long timeString = Timer.benchmarkFunctionExecTime(Function -> testString(stringLength), repetitions);
        System.out.printf("String concatenation:\t%d ns (=%f ms)%n", timeString, Timer.toMillisecondsDouble(timeString));
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
