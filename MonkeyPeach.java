// 猴子吃桃子问题：有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个
// 以后每天猴子都吃其中的一半，然后再多吃一个。当到第16天时，
// 想再吃时（即还没吃），发现只有1个桃子了。问题：最初共多少个桃子？
// 思路分析逆推
// 1,day=10时
// 有1个桃子
// 2.day= 9时有
// (day10+1)*2=4
// 3.day=8时
// 有(day9+1)*2=10
// 4,规律就是
// 前一天的桃子=（后一天的桃子+1)*2
// 5.递归

public class MonkeyPeach {
    public static void main(String[] args) {
        int DayNum = 2;

        int PeachNum = EatPeach(DayNum);
        System.out.println(PeachNum);
    }

    private static int EatPeach(int dayNum) {
        if (dayNum == 1) {
            return 1;
        } else {
            return 2 * (EatPeach(--dayNum) + 1);

        }

    }
}
