
/**
 * emailRegistered
 */
public class emailRegistered {

    public static void main(String[] args) {
        String name = "黎明";
        String pwd = "123245";
        String email = "awdja@qq.com";

        try {
            Registered(name, pwd, email);
            System.out.println("恭喜你注册成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Registered(String name, String pwd, String email) {
        if (name == null || pwd == null || email == null) {
            throw new RuntimeException("不能为空");
        }
        if (!(name.length() >= 2 && name.length() <= 4)) {
            throw new RuntimeException("用户名长度为2或者3或者4");
        }
        if (!(pwd.length() == 6 && idDigital(pwd))) {
            throw new RuntimeException("密码长度为6,要求都为数字");
        }
        if (!(email.indexOf("@") > 0 && email.indexOf(".") > email.indexOf("@"))) {
            throw new RuntimeException("邮箱中包含@和. 并且@在.的前面");
        }

    }

    private static boolean idDigital(String pwd) {
        char[] a = pwd.toCharArray();
        for (char c : a) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}