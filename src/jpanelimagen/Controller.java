/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelimagen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

/**
 *
 * @author AlumnadoTarde
 */
public class Controller extends JPanel {

    private boolean keyW = false;
    private boolean keyA = false;
    private boolean keyS = false;
    private boolean keyD = false;
    private boolean keyUp = false;
    private boolean keyLeft = false;
    private boolean keyRight = false;
    private boolean keyDown = false;
    private boolean keySpace = false;
    private boolean keyBackSpace = false;

    public Controller() {
        this.setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.addKeyListener(
                new KeyListener() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        keyW = true;
                        break;
                    case KeyEvent.VK_S:
                        keyS = true;
                        break;
                    case KeyEvent.VK_A:
                        keyA = true;
                        break;
                    case KeyEvent.VK_D:
                        keyD = true;
                        break;
                    case KeyEvent.VK_UP:
                        keyUp = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        keyDown = true;
                        break;
                    case KeyEvent.VK_LEFT:
                        keyLeft = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        keyRight = true;
                        break;
                    case KeyEvent.VK_SPACE:
                        keySpace = true;
                        break;
                    case KeyEvent.VK_BACK_SPACE:
                        keyBackSpace = true;
                        break;
                    default:
                        break;
                }
            }

            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        keyW = false;
                        break;
                    case KeyEvent.VK_S:
                        keyS = false;
                        break;
                    case KeyEvent.VK_A:
                        keyA = false;
                        break;
                    case KeyEvent.VK_D:
                        keyD = false;
                        break;
                    case KeyEvent.VK_UP:
                        keyUp = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        keyDown = false;
                        break;
                    case KeyEvent.VK_LEFT:
                        keyLeft = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        keyRight = false;
                        break;
                    case KeyEvent.VK_SPACE:
                        keySpace = false;
                        break;
                    case KeyEvent.VK_BACK_SPACE:
                        keyBackSpace = false;
                        break;
                    default:
                        break;
                }
            }

            public void keyTyped(KeyEvent arg0) {

            }
        }
        );

    }

    public boolean isKeyW() {
        return keyW;
    }

    public void setKeyW(boolean keyW) {
        this.keyW = keyW;
    }

    public boolean isKeyA() {
        return keyA;
    }

    public void setKeyA(boolean keyA) {
        this.keyA = keyA;
    }

    public boolean isKeyS() {
        return keyS;
    }

    public void setKeyS(boolean keyS) {
        this.keyS = keyS;
    }

    public boolean isKeyD() {
        return keyD;
    }

    public void setKeyD(boolean keyD) {
        this.keyD = keyD;
    }

    public boolean isKeyUp() {
        return keyUp;
    }

    public void setKeyUp(boolean keyUp) {
        this.keyUp = keyUp;
    }

    public boolean isKeyLeft() {
        return keyLeft;
    }

    public void setKeyLeft(boolean keyLeft) {
        this.keyLeft = keyLeft;
    }

    public boolean isKeyRight() {
        return keyRight;
    }

    public void setKeyRight(boolean keyRight) {
        this.keyRight = keyRight;
    }

    public boolean isKeyDown() {
        return keyDown;
    }

    public void setKeyDown(boolean keyDown) {
        this.keyDown = keyDown;
    }

    public boolean isKeySpace() {
        return keySpace;
    }

    public void setKeySpace(boolean keySpace) {
        this.keySpace = keySpace;
    }

    public boolean isKeyBackSpace() {
        return keyBackSpace;
    }

    public void setKeyBackSpace(boolean keyBackSpace) {
        this.keyBackSpace = keyBackSpace;
    }

}
