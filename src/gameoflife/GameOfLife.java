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

    /**
     * @param args the command line arguments
     */
    public static int rows = 20, cols = 20;
    public static Color col1 = Color.BLACK, col2 = Color.WHITE;
    public static void main(String[] args) {
        //TODO: implement these vars
        JPanel[][] panels = new JPanel[rows][cols];
        int x = 400,y = 400;
        JFrame checkerBoard = new JFrame();
        checkerBoard.setSize(x,y);
        checkerBoard.setTitle("Game Of Life");
        
        Container pane = checkerBoard.getContentPane();
        pane.setLayout(new GridLayout(rows, cols));
        Color temp;
        
        for (int i = 0; i < rows; i++) {
            if(i%2 == 0){
                temp = col1;
            }else{
                temp = col2;
            }
            for (int j = 0; j < cols; j++) {
                panels[i][j] = new JPanel();
                
                panels[i][j].setBackground(temp);
                if(temp.equals(col1)){
                    temp = col2;
                }else{
                    temp = col1;
                }
                pane.add(panels[i][j]);
            }
        }
        checkerBoard.setVisible(true);
        panels[0][5].setBackground(Color.BLUE);
    }
    
}
