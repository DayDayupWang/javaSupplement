public class NOdeDemo {
    public static void main(String[] args) {
        Node jack = new Node("bar");
        Node qq = new Node("ma");
        Node ali = new Node("yun");
        // 连接链表
        jack.next = qq;
        qq.next = ali;

        // pre链接

        ali.pre = qq;
        qq.pre = jack;
        Node first = jack;
        Node last = ali;
        System.out.println("-------链表的从前到后遍历---------");
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }
        System.out.println("-------链表的从后往前遍历---------");
        while (true) {
            if (last == null) {
                break;
            }
            System.out.println(last);
            first = first.next;
        }
    }
}
