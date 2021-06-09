package A剑指offer;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 */
public class _20_表示数值的字符串_Y {
    /**
     * 有限状态自动机
     * 比较全面的方式，代码量较大
     */
    public static boolean isNumber(String s) {
        // 初始化状态机
        Map<State, Map<Type, State>> transfer = new HashMap<>();
        Map<Type, State> startMap = new HashMap<Type, State>() {{
            put(Type.SPACE, State.START);
            put(Type.NUMBER, State.INT);
            put(Type.POINT, State.POINT_WITHOUT_INT);
            put(Type.SIGN, State.INT_SIGN);
        }};
        transfer.put(State.START, startMap);

        Map<Type, State> intSignMap = new HashMap<Type, State>() {{
            put(Type.NUMBER, State.INT);
            put(Type.POINT, State.POINT_WITHOUT_INT);
        }};
        transfer.put(State.INT_SIGN, intSignMap);

        Map<Type, State> intMap = new HashMap<Type, State>() {{
            put(Type.NUMBER, State.INT);
            put(Type.EXP, State.EXP);
            put(Type.POINT, State.POINT);
            put(Type.SPACE, State.END);
        }};
        transfer.put(State.INT, intMap);

        Map<Type, State> pointMap = new HashMap<Type, State>() {{
            put(Type.NUMBER, State.FRACTION);
            put(Type.EXP, State.EXP);
            put(Type.SPACE, State.END);
        }};
        transfer.put(State.POINT, pointMap);

        Map<Type, State> pointWithoutIntMap = new HashMap<Type, State>() {{
            put(Type.NUMBER, State.FRACTION);
        }};
        transfer.put(State.POINT_WITHOUT_INT, pointWithoutIntMap);

        Map<Type, State> fractionMap = new HashMap<Type, State>() {{
            put(Type.NUMBER, State.FRACTION);
            put(Type.EXP, State.EXP);
            put(Type.SPACE, State.END);
        }};
        transfer.put(State.FRACTION, fractionMap);

        Map<Type, State> expMap = new HashMap<Type, State>() {{
            put(Type.NUMBER, State.EXP_NUMBER);
            put(Type.SIGN, State.EXP_SIGN);
        }};
        transfer.put(State.EXP, expMap);

        Map<Type, State> expSignMap = new HashMap<Type, State>() {{
            put(Type.NUMBER, State.EXP_NUMBER);
        }};
        transfer.put(State.EXP_SIGN, expSignMap);

        Map<Type, State> expNumberMap = new HashMap<Type, State>() {{
            put(Type.NUMBER, State.EXP_NUMBER);
            put(Type.SPACE, State.END);
        }};
        transfer.put(State.EXP_NUMBER, expNumberMap);

        Map<Type, State> endMap = new HashMap<Type, State>() {{
            put(Type.SPACE, State.END);
        }};
        transfer.put(State.END, endMap);

        State state = State.START;
        for (int i = 0; i < s.length(); i++) {
            Type type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {
                return false;
            }
            state = transfer.get(state).get(type);
        }
        return state == State.INT || state == State.POINT || state == State.FRACTION || state == State.EXP_NUMBER || state == State.END;
    }

    public static Type toCharType(char c) {
        if ('0' <= c && c <= '9') {
            return Type.NUMBER;
        } else if (c == 'e' || c == 'E') {
            return Type.EXP;
        } else if (c == '.') {
            return Type.POINT;
        } else if (c == '+' || c == '-') {
            return Type.SIGN;
        } else if (c == ' ') {
            return Type.SPACE;
        } else {
            return Type.ILLEGAL;
        }
    }

    enum State {
        START,
        INT_SIGN,
        INT,
        POINT,
        POINT_WITHOUT_INT,
        FRACTION,
        EXP,
        EXP_SIGN,
        EXP_NUMBER,
        END,
    }

    enum Type {
        NUMBER,
        EXP,
        POINT,
        SIGN,
        SPACE,
        ILLEGAL
    }

    public static void main(String[] args) {
        isNumber("0");
    }

    /**
     * 简洁版
     */
    public static boolean isNumber1(String s) {
        if (s == null || s.length() == 0) return false;
        Map[] states = {
                // 0
                new HashMap<Character, Integer>() {{
                    put(' ', 0);
                    put('s', 1);
                    put('d', 2);
                    put('.', 4);
                }},
                // 1
                new HashMap<Character, Integer>() {{
                    put('d', 2);
                    put('.', 4);
                }},
                // 2
                new HashMap<Character, Integer>() {{
                    put('d', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                // 3
                new HashMap<Character, Integer>() {{
                    put('d', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                // 4
                new HashMap<Character, Integer>() {{
                    put('d', 3);
                }},
                // 5
                new HashMap<Character, Integer>() {{
                    put('s', 6);
                    put('d', 7);
                }},
                // 6
                new HashMap<Character, Integer>() {{
                    put('d', 7);
                }},
                // 7
                new HashMap<Character, Integer>() {{
                    put('d', 7);
                    put(' ', 8);
                }},
                // 8
                new HashMap<Character, Integer>() {{
                    put(' ', 8);
                }}
        };

        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char type;
            if ('0' <= c && c <= '9') {
                type = 'd';
            } else if (c == 'e' || c == 'E') {
                type = 'e';
            } else if (c == '+' || c == '-') {
                type = 's';
            } else if (c == ' ' || c == '.') {
                type = c;
            } else {
                return false;
            }
            if (!states[p].containsKey(type)) return false;
            p = (int) states[p].get(type);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}
