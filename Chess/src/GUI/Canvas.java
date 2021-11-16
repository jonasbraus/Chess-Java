package GUI;

import Game.Character;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel
{
    private Graphics2D g2d;
    private Character[][] grid;
    private byte[][] highlights;

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g2d = (Graphics2D) g;

        if(grid != null)
        {
            for (int x = 0; x < grid.length; x++)
            {
                for (int y = 0; y < grid[0].length; y++)
                {
                    if((x + y) % 2 == 0)
                    {
                        g2d.setColor(new Color(156, 129, 98));
                    }
                    else
                    {
                        g2d.setColor(new Color(255, 255, 255));
                    }

                    switch(highlights[x][y])
                    {
                        case 1:
                            g2d.setColor(new Color(173, 76, 76));
                            break;
                        case 2:
                            g2d.setColor(new Color(76, 173, 102));
                            break;
                        case 3:
                            g2d.setColor(Color.orange);
                            break;
                    }

                    g2d.fillRect(x * (getWidth() / 8), y * (getWidth() / 8), getWidth() / 8, getWidth() / 8);

                    if (grid[x][y] != null)
                    {
                        Character current = grid[x][y];
                        g2d.drawImage(current.getImage(), x * (getWidth() / 8), y * (getWidth() / 8), getWidth() / 8, getWidth() / 8, null);
                    }
                }
            }
        }

        repaint();
    }

    public void drawGame(Character[][] grid, byte[][] highlights)
    {
        this.highlights = highlights;
        this.grid = grid;
    }
}
