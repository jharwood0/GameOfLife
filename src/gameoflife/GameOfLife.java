/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author josh
 */
public class GameOfLife {

    public static int rows = 20, cols = 20;
    public static Color dead = Color.WHITE;
    public static Color alive = Color.BLACK;
    public static void main(String[] args) {
        JPanel[][] panels = new JPanel[rows][cols];
        int x = 400,y = 400;
        
        
        JFrame grid = new JFrame();
        grid.setSize(x,y);
        grid.setTitle("Game Of Life");
        
        Container pane = grid.getContentPane();
        pane.setLayout(new GridLayout(rows, cols));
        Color temp;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                panels[i][j] = new JPanel();

                panels[i][j].setBackground(dead);
                
                pane.add(panels[i][j]);
                
            }
        }
        grid.setVisible(true);
    }
    
}
