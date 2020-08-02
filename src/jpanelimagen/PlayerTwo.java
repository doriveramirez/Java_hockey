/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelimagen;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author AlumnadoTarde
 */
public class PlayerTwo extends JPanel implements Serializable {

    public PlayerTwo() {
        this.setOpaque(false);
        this.setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    private String rutaImagePad2;

    private static int pad_width = 100;
    private static int pad_height = 100;

    private int pad2_x;
    private int pad2_y;
    private int x = 700;
    private int y = 200;

    private static int speed = 10;

    public int getPad2_x() {
        return pad2_x;
    }

    public void setPad2_x(int pad2_x) {
        this.pad2_x = pad2_x;
    }

    public int getPad2_y() {
        return pad2_y;
    }

    public void setPad2_y(int pad2_y) {
        this.pad2_y = pad2_y;
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

    public Rectangle getPad2() {
        return new Rectangle(getPad2_x(), getPad2_y(), pad_width, pad_height);
    }

    public String getRutaImagePad2() {
        return rutaImagePad2;
    }

    public void setRutaImagePad2(String rutaImagePad2) {
        this.rutaImagePad2 = rutaImagePad2;
    }

    public static int getSpeed() {
        return speed;
    }

    @Override
    protected void paintComponent(Graphics g) {
        File filePlayerTwo = new File(rutaImagePad2);

        if (filePlayerTwo != null && filePlayerTwo.exists()) {

            ImageIcon imageIcon = new ImageIcon(filePlayerTwo.getAbsolutePath());
            g.drawImage(imageIcon.getImage(), 0, 0, this);
        }

    }

}
