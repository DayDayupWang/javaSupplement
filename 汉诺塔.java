/**
 * 汉诺塔
 */
public class 汉诺塔 {
    public static void main(String[] args) {
        int num = 10;
        char a = 'A';
        char b = 'B';
        char c = 'C';
        move(num, a, b, c);
    }

    // 目标是a到c
    public static void move(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println(a + "->" + c);
        } else {
            // 先借助c把上面所有盘借助c移动到b
            move(num - 1, a, c, b);
            System.out.println(a + "->" + c);
            // 借助a把b的所有盘移动到c
            move(num - 1, b, a, c);
        }
    }
}