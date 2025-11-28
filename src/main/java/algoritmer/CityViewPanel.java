package algoritmer;

import javax.swing.*;
import java.awt.*;

public class CityViewPanel extends JPanel {

    private String cityName;
    private JFrame parentFrame;

    public CityViewPanel(String cityName, JFrame frame) {
        this.cityName = cityName;
        this.parentFrame = frame;

        setBackground(new Color(40, 40, 60));
        setLayout(null); // vi plasserer knapper manuelt

        // Tilbake-knapp
        JButton backButton = new JButton("Tilbake");
        backButton.setBounds(20, 20, 100, 30);

        backButton.addActionListener(e -> goBackToWorld());
        add(backButton);
    }

    // Bytt tilbake til verdenskartet
    private void goBackToWorld() {
        GameWindow worldPanel = new GameWindow(parentFrame);

        parentFrame.getContentPane().removeAll();
        parentFrame.add(worldPanel);
        parentFrame.revalidate();
        parentFrame.repaint();

        worldPanel.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.drawString("INSIDE CITY: " + cityName, 40, 80);
        g.drawString("Her kan du senere legge til:", 40, 110);
        g.drawString("- Hus og bygninger", 60, 130);
        g.drawString("- Folk og NPCs", 60, 150);
        g.drawString("- Ressurser, butikker, osv.", 60, 170);
    }
}
