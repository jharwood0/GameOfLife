/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author josh
 */
public class GameOfLife {

    public static int rows = 130, cols = 130, initial = 1000;
    public static Color dead = Color.WHITE;
    public static Color alive = Color.BLACK;
    public static JPanel[][] panels = new JPanel[rows][cols];

    public static int isAlive(int row, int col) {
        
        if (row >= rows || col >= cols || row < 0 || col < 0) {
            //System.out.println("check: " + row + " " + " " + col);
            return -1;
        }
        if(panels[row][col].getBackground().equals(alive)){
            //System.out.println("check: " + row + " " + " " + col);
            return 1;
        }else if (panels[row][col].getBackground().equals(dead)){
            return 0;
        }
        return -1;
    }

    public static void rules(int row, int col) {
        /*
         row + 1
         row - 1
         col + 1
         col - 1
         row + 1 | col + 1
         row - 1 | col + 1
         row + 1 | col - 1
         row - 1 | col - 1
         Neighbours = all 8
        
         RULE 1: if less than 2 neighbours = dead
         RULE 2: Any live cell with two or three live neighbours lives on to the next generation
         RULE 3: > 3 = dead
         RULE 4: == 3 = LIVES
        
         */

        //calculating neighbours
        int neighbours = 0;
        if (isAlive(row + 1, col) == 1) {
            neighbours++;
        }
        if (isAlive(row - 1, col) == 1) {
            neighbours++;
        }
        if (isAlive(row, col + 1) == 1) {
            neighbours++;
        }
        if (isAlive(row, col - 1) == 1) {
            neighbours++;
        }
        if (isAlive(row + 1, col + 1) == 1) {
            neighbours++;
        }
        if (isAlive(row - 1, col + 1) == 1) {
            neighbours++;
        }
        if (isAlive(row + 1, col - 1) == 1) {
            neighbours++;
        }
        if (isAlive(row - 1, col - 1) == 1) {
            neighbours++;
        }
        if (isAlive(row, col) == 1) {
            //System.out.println(neighbours);
            switch (neighbours) {
                case 0: case 1:
                    panels[row][col].setBackground(dead);
                    break;
                case 2: case 3:
                    break;
                case 4: case 5: case 6: case 7: case 8:
                    panels[row][col].setBackground(dead);
                    break;
                default:
                    panels[row][col].setBackground(dead);
                    break;
            }
        } else if(isAlive(row,col) == 0 && neighbours == 3) {
            panels[row][col].setBackground(alive);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        int x = 800, y = 800;
        JFrame grid = new JFrame();
        grid.setSize(x, y);
        grid.setTitle("Game Of Life");

        Container pane = grid.getContentPane();
        pane.setLayout(new GridLayout(rows, cols));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                panels[i][j] = new JPanel();

                panels[i][j].setBackground(dead);
                panels[i][j].setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

                pane.add(panels[i][j]);

            }
        }
        grid.setVisible(true);
        //System.out.println("Generating random live cells");

        Random random = new Random();

        //inital build
        for (int i = 0; i < initial; i++) {
                int r = random.nextInt((rows - 1) - 0 + 1) + 0;
                int c = random.nextInt((cols - 1) - 0 + 1) + 0;
                panels[c][r].setBackground(alive);
            }
        //start game
        while (true) {
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    rules(i, j);
                    
                }
                //Thread.sleep(10000);
                
            }
            Thread.sleep(100);
        }

    }

}
