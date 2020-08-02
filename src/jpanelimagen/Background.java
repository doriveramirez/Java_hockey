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
public class Background extends JPanel implements Serializable {

    private String rutaImageTable;

    public Background() {
    }

    public String getRutaImageTable() {
        return rutaImageTable;
    }

    public void setRutaImageTable(String rutaImageTable) {
        this.rutaImageTable = rutaImageTable;
    }

    @Override
    protected void paintComponent(Graphics g) {
        File fileTable = new File(rutaImageTable);

        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

        if (fileTable != null && fileTable.exists()) {

            ImageIcon imageIcon = new ImageIcon(fileTable.getAbsolutePath());
            g.drawImage(imageIcon.getImage(), 0, 0, this);
        }

    }

}
