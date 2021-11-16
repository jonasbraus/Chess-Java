package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Character
{
    public Pawn(Color color)
    {
        super(color);
    }

    @Override
    public Image getImage()
    {
        if(color == Color.black)
        {
            return new ImageIcon("Graphics/blackPawn.png").getImage();
        }

        return new ImageIcon("Graphics/whitePawn.png").getImage();
    }

    @Override
    public List<Vector2> getValidMoves(Character[][] grid)
    {
        List<Vector2> out = new ArrayList<>();

        Vector2 pos = getPositionInGrid(grid);

        int y = 0;
        int defaultPos = 0;

        if(color == Color.black)
        {
            y = 1;
            defaultPos = 1;
        }
        else
        {
            y = -1;
            defaultPos = 6;
        }

        if(isInGrid(new Vector2(pos.x, pos.y + y)))
        {
            if(grid[pos.x][pos.y + y] == null)
            {
                out.add(new Vector2(pos.x, pos.y + y));

                if(pos.y == defaultPos && grid[pos.x][pos.y + y * 2] == null)
                {
                    out.add(new Vector2(pos.x, pos.y + y * 2));
                }
            }
        }
        
        if(isInGrid(new Vector2(pos.x + 1, pos.y + y)))
        {
            if(grid[pos.x + 1][pos.y + y] != null)
            {
                if(grid[pos.x + 1][pos.y + y].color != color)
                {
                    out.add(new Vector2(pos.x + 1, pos.y + y));
                }
            }
        }
        if(isInGrid(new Vector2(pos.x - 1, pos.y + y)))
        {
            if(grid[pos.x - 1][pos.y + y] != null)
            {
                if(grid[pos.x - 1][pos.y + y].color != color)
                {
                    out.add(new Vector2(pos.x - 1, pos.y + y));
                }
            }
        }

        return out;
    }
}
