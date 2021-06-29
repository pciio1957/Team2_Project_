package 프로젝트소스_공유용.성근_시간기능;
 
import java.awt.Graphics;
import java.util.Calendar;
import java.util.GregorianCalendar;
 
import javax.swing.JFrame;
 
// 아날로그 시계
public class analogClock extends JFrame implements Runnable {
 
    private GregorianCalendar time;
 
    // frame 크기
    private int width = 300;
 
    // time 계산을 위한 변수
    private int hour = 0;
    private int min = 0;
    private int sec = 0;
 
    private Graphics gp;
 
    // time이 변경될 때마다 Frame 내 이미지를 재 배치하기 위한 메서드
    public void paint(Graphics gp) {
 
        time = new GregorianCalendar();
 
        // 시간 정보를 가져온다.
        min = time.get(Calendar.MINUTE);
        hour = time.get(Calendar.HOUR);
        sec = time.get(Calendar.SECOND);
 
        if (sec == 60) {
            sec = 0;
            min++;
        }
        if (min == 60) {
            min = 0;
            hour++;
        }
        if (min == 60 && hour == 12) {
            hour = 0;
        }
 
        // Frame 내부에 그려진 모든 부분을 지운다.
        gp.clearRect(0, 0, width, width);
        
        // 시계 테두리를 표현하기 위해
        rec_draw();
 
 
        // 초 / 분 / 시 바늘을 그린다.
        draw(150, 150, 150, 50, 100, sec * 6);
        draw(150, 150, 150, 50, 70, min * 6);
        draw(150, 150, 150, 50, 50, hour * 30 + min / 2);
    }
    
    // 시계 테두리를 점으로 표시하기 위한 메서드
    public void rec_draw() {
        int j = 1;
        for (int i = 1; i <= 60; i++) {
            // 5 분 단위로 시간을 표시하며, 점을 크게 표시하여 구분을 한다.
            if (i % 5 == 0) {
                draw_t(150, 50, i * 6, 3);
                draw_time(150, 50, i * 6, j + "");
                j++;
            } else {
                draw_t(150, 50, i * 6, 1);
            }
        }
    }
    
    // 시계 테두리에 점을 표시하기 위한 메서드
    public void draw_t(int x, int y, int angle, int width) {
        x = 150 + (int) (120 * Math.sin(angle * Math.PI / 180));
        y = 150 - (int) (120 * Math.cos(angle * Math.PI / 180));
        gp.fillRect(x, y, width, width);
    }
    
    // 시계 테두리 부분에 5분 단위로 시간을 표시하기 위한 메서드
    public void draw_time(int x, int y, int angle, String i) {
        x = 147 + (int) (105 * Math.sin(angle * Math.PI / 180));
        y = 155 - (int) (100 * Math.cos(angle * Math.PI / 180));
        gp.drawString(i, x, y);
    }
 
    // 초 / 분 / 시 를 표시하기 위해 drawLine(선을 그리는 메서드) 사용
    public void draw(int ox, int oy, int x, int y, int l, int angle) {
        x = ox + (int) (l * Math.sin(angle * Math.PI / 180));
        y = oy - (int) (l * Math.cos(angle * Math.PI / 180));
        gp.drawLine(ox, oy, x, y);
    }
 
    // 생성자 선언
    public analogClock() {
        init();
    }
 
    // frame을 그리기 위한 초기화 메서드
    public void init() {
        this.setTitle("Clock");
        this.setSize(width, width);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        gp = getGraphics();
    }
 
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            try {
                Thread.sleep(1000); // 1초마다
                repaint();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
 
    public static void main(String[] args) {
        analogClock h2 = new analogClock();
        Thread th = new Thread(h2);
        th.start();
    }
}