import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawCircle extends JFrame {
    private MyPanel mp = null;

    public static void main(String[] args) {

    }

    public DrawCircle() {// 构造器
        // 初始化面板
        mp = new MyPanel();
        // 把面板放入到这个窗口（）
        this.add(mp);
        // 设置窗口的大小
        this.setSize(400, 300);
        // 当点击窗口小叉时程序推出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);// 使其可视
    }

}

// MyPanel 对象是一个画板
//

class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.DrawCircle(10, 10, 100, 100);
    }
}
