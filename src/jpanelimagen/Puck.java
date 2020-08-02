/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelimagen;

import java.awt.Graphics;
import java.io.File;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author AlumnadoTarde
 */
public class Puck extends JPanel implements Serializable {

    public Puck() {
        this.setOpaque(false);
        this.setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    private String rutaImagePuck;
    private int puck_x = Frame.WIDTH / 2;
    private int puck_y = Frame.HEIGHT / 2;
    private int x = 540;
    private int y = 215;
    private static int vx = 2;
    private static int vy = 2;
    
    public static int getVx() {
        return vx;
    }

    public static void setVx(int vx) {
        Puck.vx = vx;
    }

    public static int getVy() {
        return vy;
    }

    public static void setVy(int vy) {
        Puck.vy = vy;
    }

    public int getPuck_x() {
        return puck_x;
    }

    public void setPuck_x(int puck_x) {
        this.puck_x = puck_x;
    }

    public int getPuck_y() {
        return puck_y;
    }

    public void setPuck_y(int puck_y) {
        this.puck_y = puck_y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRutaImagePuck(String rutaImagePuck) {
        this.rutaImagePuck = rutaImagePuck;
    }

    @Override
    protected void paintComponent(Graphics g) {
        File filePuck = new File(rutaImagePuck);

        if (filePuck != null && filePuck.exists()) {

            ImageIcon imageIcon = new ImageIcon(filePuck.getAbsolutePath());
            g.drawImage(imageIcon.getImage(), 0, 0, this);
        }

    }
    
}
