package GUI;

import Game.Character;
import Game.Chess;
import Game.Vector2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window extends JFrame
{
    private Canvas canvas;
    private Chess chess;

    public Window(Chess chess)
    {
        this.chess = chess;
        canvas = new Canvas();
        setTitle("Chess");

        getContentPane().setPreferredSize(new Dimension(800, 800));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        canvas.setBounds(0, 0, 800, 800);
        add(canvas);

        setVisible(true);

        addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                if(getContentPane().getWidth() == getContentPane().getHeight())
                {
                    canvas.setBounds(0, 0, getContentPane().getWidth(), getContentPane().getWidth());
                }
                else if(getContentPane().getWidth() < getContentPane().getHeight())
                {
                    canvas.setBounds(0, getContentPane().getHeight() / 2 - getContentPane().getWidth() / 2, getContentPane().getWidth(), getContentPane().getWidth());
                }
                else
                {
                    canvas.setBounds(getContentPane().getWidth() / 2 - getContentPane().getHeight() / 2, 0, getContentPane().getHeight(), getContentPane().getHeight());
                }
            }
        });

        canvas.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {

            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                chess.onMousePressed(new Vector2(e.getX(), e.getY()));
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {

            }

            @Override
            public void mouseEntered(MouseEvent e)
            {

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }
        });
    }

    public void drawGame(Character[][] grid, byte[][] highlights)
    {
        canvas.drawGame(grid, highlights);
    }

    public int getWidth()
    {
        return canvas.getWidth();
    }
}
