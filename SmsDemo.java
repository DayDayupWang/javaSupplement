
public class SmsDemo {
    // 创建存储主题、附件、正文状态的标记
    private static final int HAS_SUBJECT = (1 << 0); // 1{0000 0001}
    private static final int HAS_ATTACHMENT = (1 << 1); // 2{0000 0010}
    private static final int HAS_CONTENT = (1 << 2); // 4{0000 0100}

    static class Sms {
        // 短信，初始化flag = 0，不含有主题、附件、正文
        private int flags = 0;

        // 更新短信状态
        private void updateSmsState(int state, boolean has) {
            int oldFlags = flags;//不要用累积思维看，按位逻辑运算下主要看某个位的结果以及它保存的东西
            if (has) {//此处做了修改操作，修改后的修改也算修改而不是undo修改
                // 那么按位或就会使flags在对应操作的二进制位数上变成相应值00->1;01->1;11->1
                flags |= state;
            } else {
                flags &= ~state;
            }
            // 按位 异或，得到变化的flags,如果flag变化可以被捕捉到
            int flagsChanges = oldFlags ^ flags;
            if ((flagsChanges & HAS_SUBJECT) != 0) {
                System.out.println("\t【主题】标记状态发生了改变！");
            } else if ((flagsChanges & HAS_ATTACHMENT) != 0) {
                System.out.println("\t【附件】标记状态发生了改变！");
            } else if ((flagsChanges & HAS_CONTENT) != 0) {
                System.out.println("\t【正文】标记状态发生了改变！");
            } else {
                System.out.println("\tflags标记状态没有发生改变！");
            }
        }

        // 得到短信三组成各自是否改变的布尔值
        private boolean hasSmsSubject(int smsFlag) {
            return (smsFlag & HAS_SUBJECT) > 0;
        }

        private boolean hasSmsAttachment(int smsFlag) {
            return (smsFlag & HAS_ATTACHMENT) > 0;
        }

        private boolean hasSmsContent(int smsFlag) {
            return (smsFlag & HAS_CONTENT) > 0;
        }

        public String toString() {
            String hasSubject = hasSmsSubject(flags) ? "[主题]" : "";
            String hasAttachment = hasSmsAttachment(flags) ? "[附件]" : "";
            String hasContent = hasSmsContent(flags) ? "[正文]" : "";
            return "短信：" + hasSubject
                    + "," + hasAttachment
                    + "," + hasContent;
        }
    }

    public static void main(String[] args) {
        // 初始化短信对象
        Sms sms = new Sms();

        System.out.println("初始化短信：" + sms);

        // 给短信设定主题
        sms.updateSmsState(HAS_SUBJECT, true);
        System.out.println("短信添加主题后：" + sms);

        // 给短信设定附件
        sms.updateSmsState(HAS_ATTACHMENT, true);
        System.out.println("短信添加附件后：" + sms);

        // 给短信设定正文
        sms.updateSmsState(HAS_CONTENT, true);
        System.out.println("短信添加正文后：" + sms);

        // 短信不能含有附件
        sms.updateSmsState(HAS_ATTACHMENT, false);
        System.out.println("短信去除附件后：" + sms);
    }

}
