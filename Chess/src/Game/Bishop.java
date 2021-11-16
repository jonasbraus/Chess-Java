package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Bishop extends Character
{
    public Bishop(Color color)
    {
        super(color);
    }

    @Override
    public Image getImage()
    {
        if(color == Color.black)
        {
            return new ImageIcon("Graphics/blackBishop.png").getImage();
        }

        return new ImageIcon("Graphics/whiteBishop.png").getImage();
    }

    @Override
    public List<Vector2> getValidMoves(Character[][] grid)
    {
        Vector2 direction = new Vector2(-1, -1);
        List<Vector2> out = new ArrayList<>();

        for(int i = 0; i < 4; i++)
        {
            for(int f = 1; f < 8; f++)
            {
                Vector2 v = Vector2.add(getPositionInGrid(grid), Vector2.mul(direction, f));
                if(isInGrid(v))
                {
                    if (grid[v.x][v.y] != null)
                    {
                        if(grid[v.x][v.y].color != color)
                        {
                            out.add((new Vector2(v.x, v.y)));
                        }

                        break;
                    }
                    else
                    {
                        out.add(new Vector2(v.x, v.y));
                    }
                }
            }

            direction.rotate(90);
        }

        return out;
    }
}
