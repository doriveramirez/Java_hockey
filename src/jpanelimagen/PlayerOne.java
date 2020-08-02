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
public class PlayerOne extends JPanel implements Serializable {

    public PlayerOne() {
        this.setOpaque(false);
        this.setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    private String rutaImagePad1;

    private static int pad_width = 100;
    private static int pad_height = 100;

    private int pad1_x;
    private int pad1_y;
    private int x = 300;
    private int y = 200;

    private static int speed = 10;

    

    public int getPad1_x() {
        return pad1_x;
    }

    public void setPad1_x(int pad1_x) {
        this.pad1_x = pad1_x;
    }

    public int getPad1_y() {
        return pad1_y;
    }

    public void setPad1_y(int pad1_y) {
        this.pad1_y = pad1_y;
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

    public Rectangle getPad1() {
        return new Rectangle(getPad1_x(), getPad1_y(), pad_width, pad_height);
    }

    public String getRutaImagePad1() {
        return rutaImagePad1;
    }

    public void setRutaImagePad1(String rutaImagePad1) {
        this.rutaImagePad1 = rutaImagePad1;
    }

    @Override
    protected void paintComponent(Graphics g) {
        File filePlayerOne = new File(rutaImagePad1);

        if (filePlayerOne != null && filePlayerOne.exists()) {

            ImageIcon imageIcon = new ImageIcon(filePlayerOne.getAbsolutePath());
            g.drawImage(imageIcon.getImage(), 0, 0, this);
        }

    }

    public static int getSpeed() {
        return speed;
    }
        
}
