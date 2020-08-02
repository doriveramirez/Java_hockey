/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelimagen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author AlumnadoTarde
 */
public class Frame extends JFrame {

    private static final short MOVEMENT_IDLE = 0;
    private static final short MOVEMENT_UP = 1;
    private static final short MOVEMENT_DOWN = 2;
    private static final short MOVEMENT_RIGHT = 3;
    private static final short MOVEMENT_LEFT = 4;

    PlayerOne playerone = new PlayerOne();
    PlayerTwo playertwo = new PlayerTwo();
    Puck puck = new Puck();
    Background table = new Background();
    Controller controller = new Controller();
    private String player1Score = "5";
    private String player2Score = "5";
    private int point;
    private short movement = MOVEMENT_IDLE;
    private short timing = 0;

    public Frame() throws SQLException, IOException {

        setSize(1120, 569);

        Conexion conexion = new Conexion();

        playerone.setRutaImagePad1(conexion.photos(2));
        playertwo.setRutaImagePad2(conexion.photos(3));
        puck.setRutaImagePuck(conexion.photos(4));
        table.setRutaImageTable(conexion.photos(1));

        table.setBounds(0, 0, 1120, 569);
        playerone.setBounds(0, 0, 100, 100);
        playertwo.setBounds(0, 0, 100, 100);
        puck.setBounds(0, 0, 100, 100);

        JOptionPane.showMessageDialog(null, "Jugador 1:  W,A,S,D (moverse); Espacio (disparar). Jugador 2: Teclas de dirección (moverse); retroceso (disparar).", "Instrucciones (controles)", JOptionPane.PLAIN_MESSAGE);

        add(playerone);
        add(playertwo);
        add(puck);
        add(table);
        add(controller);

        this.addMouseMotionListener(
                new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                puck.setY(e.getY());
                puck.setX(e.getX());
            }
        }
        );

        Timer tm = new Timer(
                20, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                movimiento();
                collision();
                move();
                playerone.setLocation(playerone.getX(), playerone.getY());
                playertwo.setLocation(playertwo.getX(), playertwo.getY());
                puck.setLocation(puck.getX(), puck.getY());
                repaint();
                checkWin();
            }
        }
        );
        tm.start();

    }

    private void movimiento() {
        if (controller.isKeyUp() && controller.isKeyRight()) {
            playertwo.setX(playertwo.getX() + playertwo.getSpeed() / 2);
            playertwo.setY(playertwo.getY() - playertwo.getSpeed() / 2);
        } else if (controller.isKeyUp() && controller.isKeyLeft()) {
            playertwo.setX(playertwo.getX() - playertwo.getSpeed() / 2);
            playertwo.setY(playertwo.getY() - playertwo.getSpeed() / 2);
        } else if (controller.isKeyUp()) {
            playertwo.setY(playertwo.getY() - playertwo.getSpeed());
        }
        if (controller.isKeyLeft() && controller.isKeyUp()) {
            playertwo.setX(playertwo.getX() - playertwo.getSpeed() / 2);
            playertwo.setY(playertwo.getY() - playertwo.getSpeed() / 2);
        } else if (controller.isKeyLeft() && controller.isKeyDown()) {
            playertwo.setX(playertwo.getX() - playertwo.getSpeed() / 2);
            playertwo.setY(playertwo.getY() + playertwo.getSpeed() / 2);
        } else if (controller.isKeyLeft()) {
            playertwo.setX(playertwo.getX() - playertwo.getSpeed());
        }
        if (controller.isKeyDown() && controller.isKeyRight()) {
            playertwo.setX(playertwo.getX() + playertwo.getSpeed() / 2);
            playertwo.setY(playertwo.getY() + playertwo.getSpeed() / 2);
        } else if (controller.isKeyDown() && controller.isKeyLeft()) {
            playertwo.setX(playertwo.getX() - playertwo.getSpeed() / 2);
            playertwo.setY(playertwo.getY() + playertwo.getSpeed() / 2);
        } else if (controller.isKeyDown()) {
            playertwo.setY(playertwo.getY() + playertwo.getSpeed());
        }
        if (controller.isKeyRight() && controller.isKeyUp()) {
            playertwo.setX(playertwo.getX() + playertwo.getSpeed() / 2);
            playertwo.setY(playertwo.getY() - playertwo.getSpeed() / 2);
        } else if (controller.isKeyRight() && controller.isKeyDown()) {
            playertwo.setX(playertwo.getX() + playertwo.getSpeed() / 2);
            playertwo.setY(playertwo.getY() + playertwo.getSpeed() / 2);
        } else if (controller.isKeyRight()) {
            playertwo.setX(playertwo.getX() + playertwo.getSpeed());
        }
        if (controller.isKeyW() && controller.isKeyD()) {
            playerone.setX(playerone.getX() + playerone.getSpeed() / 2);
            playerone.setY(playerone.getY() - playerone.getSpeed() / 2);
        } else if (controller.isKeyW() && controller.isKeyA()) {
            playerone.setX(playerone.getX() - playerone.getSpeed() / 2);
            playerone.setY(playerone.getY() - playerone.getSpeed() / 2);
        } else if (controller.isKeyW()) {
            playerone.setY(playerone.getY() - playerone.getSpeed());
        }
        if (controller.isKeyA() && controller.isKeyW()) {
            playerone.setX(playerone.getX() - playerone.getSpeed() / 2);
            playerone.setY(playerone.getY() - playerone.getSpeed() / 2);
        } else if (controller.isKeyA() && controller.isKeyS()) {
            playerone.setX(playerone.getX() - playerone.getSpeed() / 2);
            playerone.setY(playerone.getY() + playerone.getSpeed() / 2);
        } else if (controller.isKeyA()) {
            playerone.setX(playerone.getX() - playerone.getSpeed());
        }
        if (controller.isKeyS() && controller.isKeyD()) {
            playerone.setX(playerone.getX() + playerone.getSpeed() / 2);
            playerone.setY(playerone.getY() + playerone.getSpeed() / 2);
        } else if (controller.isKeyS() && controller.isKeyA()) {
            playerone.setX(playerone.getX() - playerone.getSpeed() / 2);
            playerone.setY(playerone.getY() + playerone.getSpeed() / 2);
        } else if (controller.isKeyS()) {
            playerone.setY(playerone.getY() + playerone.getSpeed());
        }
        if (controller.isKeyD() && controller.isKeyW()) {
            playerone.setX(playerone.getX() + playerone.getSpeed() / 2);
            playerone.setY(playerone.getY() - playerone.getSpeed() / 2);
        } else if (controller.isKeyD() && controller.isKeyS()) {
            playerone.setX(playerone.getX() + playerone.getSpeed() / 2);
            playerone.setY(playerone.getY() + playerone.getSpeed() / 2);
        } else if (controller.isKeyD()) {
            playerone.setX(playerone.getX() + playerone.getSpeed());
        }
        if (playerone.getLocation().y <= 0) {
            playerone.setY(playerone.getY() + 10);
        }
        if (playerone.getLocation().y > 460) {
            playerone.setY(playerone.getY() - 10);
        }
        if (playerone.getLocation().x > 1050) {
            playerone.setX(playerone.getX() - 10);
        }
        if (playerone.getLocation().x < 0) {
            playerone.setX(playerone.getX() + 10);
        }
        if (playertwo.getLocation().y <= 0) {
            playertwo.setY(playertwo.getY() + 10);
        }
        if (playertwo.getLocation().y > 460) {
            playertwo.setY(playertwo.getY() - 10);
        }
        if (playertwo.getLocation().x > 1050) {
            playertwo.setX(playertwo.getX() - 10);
        }
        if (playertwo.getLocation().x < 0) {
            playertwo.setX(playertwo.getX() + 10);
        }
    }

    //Checks whether the puck collided with the pads, if it did it will bounce back.
    public void collision() {
        if (playerone.getBounds().intersects(puck.getBounds())) {
            if (puck.getLocation().x > playerone.getLocation().x - 60 & puck.getLocation().x <= playerone.getLocation().x & puck.getLocation().y >= playerone.getLocation().y - 40 & puck.getLocation().y < playerone.getLocation().y + 80) {
                puck.setX(puck.getX() - 10);
                if (movement == MOVEMENT_RIGHT) {
                    movement = MOVEMENT_IDLE;
                }
                if (controller.isKeySpace()) {
                    movement = MOVEMENT_LEFT;
                }
            }
            if (puck.getLocation().x >= playerone.getLocation().x + 60 & puck.getLocation().y >= playerone.getLocation().y - 30 & puck.getLocation().y < playerone.getLocation().y + 80) {
                puck.setX(puck.getX() + 10);
                if (movement == MOVEMENT_LEFT) {
                    movement = MOVEMENT_IDLE;
                }
                if (controller.isKeySpace()) {
                    movement = MOVEMENT_RIGHT;
                }
            }
            if (puck.getLocation().x >= playerone.getLocation().x - 40 & puck.getLocation().x < playerone.getLocation().x + 80 & puck.getLocation().y >= playerone.getLocation().y - 50 & puck.getLocation().y < playerone.getLocation().y) {
                puck.setY(puck.getY() - 10);
                if (movement == MOVEMENT_DOWN) {
                    movement = MOVEMENT_IDLE;
                }
                if (controller.isKeySpace()) {
                    movement = MOVEMENT_UP;
                }
            }
            if (puck.getLocation().x >= playerone.getLocation().x - 40 & puck.getLocation().x < playerone.getLocation().x + 80 & puck.getLocation().y >= playerone.getLocation().y - 30) {
                puck.setY(puck.getY() + 10);
                if (movement == MOVEMENT_UP) {
                    movement = MOVEMENT_IDLE;
                }
                if (controller.isKeySpace()) {
                    movement = MOVEMENT_DOWN;
                }
            }
        }
        if (playertwo.getBounds().intersects(puck.getBounds())) {
            if (puck.getLocation().x > playertwo.getLocation().x - 60 & puck.getLocation().x <= playertwo.getLocation().x & puck.getLocation().y >= playertwo.getLocation().y - 40 & puck.getLocation().y < playertwo.getLocation().y + 80) {
                puck.setX(puck.getX() - 10);
                if (movement == MOVEMENT_RIGHT) {
                    movement = MOVEMENT_IDLE;
                }
                if (controller.isKeyBackSpace()) {
                    movement = MOVEMENT_LEFT;
                }
            }
            if (puck.getLocation().x >= playertwo.getLocation().x + 60 & puck.getLocation().y >= playertwo.getLocation().y - 30 & puck.getLocation().y < playertwo.getLocation().y + 80) {
                puck.setX(puck.getX() + 10);
                if (movement == MOVEMENT_LEFT) {
                    movement = MOVEMENT_IDLE;
                }
                if (controller.isKeyBackSpace()) {
                    movement = MOVEMENT_RIGHT;
                }
            }
            if (puck.getLocation().x >= playertwo.getLocation().x - 40 & puck.getLocation().x < playertwo.getLocation().x + 80 & puck.getLocation().y >= playertwo.getLocation().y - 50 & puck.getLocation().y < playertwo.getLocation().y) {
                puck.setY(puck.getY() - 10);
                if (movement == MOVEMENT_DOWN) {
                    movement = MOVEMENT_IDLE;
                }
                if (controller.isKeyBackSpace()) {
                    movement = MOVEMENT_UP;
                }
            }
            if (puck.getLocation().x >= playertwo.getLocation().x - 40 & puck.getLocation().x < playertwo.getLocation().x + 80 & puck.getLocation().y >= playertwo.getLocation().y - 30) {
                puck.setY(puck.getY() + 10);
                if (movement == MOVEMENT_UP) {
                    movement = MOVEMENT_IDLE;
                }
                if (controller.isKeyBackSpace()) {
                    movement = MOVEMENT_DOWN;
                }
            }
        }
        if (puck.getLocation().y > 460) {
            if (movement == MOVEMENT_DOWN) {
                movement = MOVEMENT_UP;
            } else {
                puck.setY(puck.getY() - 10);
                movement = MOVEMENT_IDLE;
            }
        }
        if (puck.getLocation().y <= 0) {
            if (movement == MOVEMENT_UP) {
                movement = MOVEMENT_DOWN;
            } else {
                puck.setY(puck.getY() + 10);
            }
        }
        if (puck.getLocation().x > 1050) {
            puck.setX(520);
            puck.setY(230);
            playerone.setX(300);
            playerone.setY(200);
            playertwo.setX(700);
            playertwo.setY(200);
            point = Integer.parseInt(player2Score);
            point--;
            player2Score = String.valueOf(point);
            movement = MOVEMENT_IDLE;
        }
        if (puck.getLocation().x < 0) {
            puck.setX(520);
            puck.setY(230);
            playerone.setX(300);
            playerone.setY(200);
            playertwo.setX(700);
            playertwo.setY(200);
            point = Integer.parseInt(player1Score);
            point--;
            player1Score = String.valueOf(point);
            movement = MOVEMENT_IDLE;
        }
    }

    private void move() {
        switch (movement) {
            case MOVEMENT_UP:
                puck.setY(puck.getY() - 7);
                timing++;
                if (timing > 100) {
                    movement = MOVEMENT_IDLE;
                    timing = 0;
                }
                break;
            case MOVEMENT_DOWN:
                puck.setY(puck.getY() + 7);
                timing++;
                if (timing > 100) {
                    movement = MOVEMENT_IDLE;
                    timing = 0;
                }
                break;
            case MOVEMENT_LEFT:
                puck.setX(puck.getX() - 7);
                timing++;
                if (timing > 100) {
                    movement = MOVEMENT_IDLE;
                    timing = 0;
                }
                break;
            case MOVEMENT_RIGHT:
                puck.setX(puck.getX() + 7);
                timing++;
                if (timing > 100) {
                    movement = MOVEMENT_IDLE;
                    timing = 0;
                }
                break;
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        g.setColor(Color.BLACK);
        g.drawString(player1Score, 500, 320);

        g.setColor(Color.BLACK);
        g.drawString(player2Score, 590, 320);
    }

    private void checkWin() {
        if (player2Score.equals("0")) {
            JOptionPane.showMessageDialog(null, "Ha ganado el jugador 1", "Felicidades", JOptionPane.PLAIN_MESSAGE);
            player2Score = "5";
            player1Score = "5";
            playerone.setX(300);
            playerone.setY(200);
            playertwo.setX(700);
            playertwo.setY(200);
        }
        if (player1Score.equals("0")) {
            JOptionPane.showMessageDialog(null, "Ha ganado el jugador 2", "Felicidades", JOptionPane.PLAIN_MESSAGE);
            player2Score = "5";
            player1Score = "5";
            playerone.setX(300);
            playerone.setY(200);
            playertwo.setX(700);
            playertwo.setY(200);
        }
    }

}
