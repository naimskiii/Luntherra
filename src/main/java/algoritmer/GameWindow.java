package algoritmer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameWindow extends JPanel {

    // === Indre klasse for byer ===
    static class City {
        String name;
        int x, y;

        City(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }
    }

    private JFrame parentFrame;
    private java.util.List<City> cities = new ArrayList<>();

    // === Konstruktør ===
    public GameWindow(JFrame frame) {
        this.parentFrame = frame;

        // Eksempelbyer
        cities.add(new City("Corvathen", 150, 150));
        cities.add(new City("Virethra", 350, 220));
        cities.add(new City("Mournhall", 500, 100));

        setBackground(new Color(10, 20, 30));

        // Musklikk for å velge by
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleClick(e.getX(), e.getY());
            }
        });
    }

    // === Håndter klikk på kartet ===
    private void handleClick(int mouseX, int mouseY) {
        for (City city : cities) {
            int dx = mouseX - city.x;
            int dy = mouseY - city.y;
            int distance = (int) Math.sqrt(dx * dx + dy * dy);

            if (distance <= 15) { // radius til byen
                System.out.println("Clicked on: " + city.name);
                enterCity(city);
                break;
            }
        }
    }

    // === Gå inn i en by ===
    private void enterCity(City city) {
        CityViewPanel cityPanel = new CityViewPanel(city.name, parentFrame);

        parentFrame.getContentPane().removeAll();
        parentFrame.add(cityPanel);
        parentFrame.revalidate();
        parentFrame.repaint();

        System.out.println("Entering city: " + city.name);
    }

    // === Game update (logikk per frame) ===
    public void updateGame() {
        // Senere: world.tick(), animasjoner osv.
    }

    // === Game loop via Swing Timer ===
    public void start() {
        Timer timer = new Timer(16, e -> {
            updateGame();
            repaint();
        });
        timer.start();
    }

    // === Tegn verdenskartet ===
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        // Byer
        for (City city : cities) {
            g2.setColor(new Color(52, 209, 182));
            g2.fillOval(city.x - 15, city.y - 15, 30, 30);

            g2.setColor(Color.WHITE);
            g2.drawString(city.name, city.x - 20, city.y - 25);
        }

        // Enkle forbindelser mellom byene
        g2.setColor(new Color(100, 100, 255));
        for (int i = 0; i < cities.size() - 1; i++) {
            City a = cities.get(i);
            City b = cities.get(i + 1);
            g2.drawLine(a.x, a.y, b.x, b.y);
        }
    }

    // === main: start spillet ===
    public static void main(String[] args) {
        JFrame frame = new JFrame("Luntherra 🌍");
        GameWindow panel = new GameWindow(frame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.add(panel);
        frame.setLocationRelativeTo(null); // midt på skjermen
        frame.setVisible(true);

        panel.start();
    }
}
