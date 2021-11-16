package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class King extends Character
{
    public King(Color color)
    {
        super(color);
    }

    @Override
    public Image getImage()
    {
        if (color == Color.black)
        {
            return new ImageIcon("Graphics/blackKing.png").getImage();
        }

        return new ImageIcon("Graphics/whiteKing.png").getImage();
    }

    @Override
    public List<Vector2> getValidMoves(Character[][] grid)
    {
        Vector2 direction = new Vector2(0, -1);
        List<Vector2> out = new ArrayList<>();

        for (int i = 0; i < 8; i++)
        {

            Vector2 v = Vector2.add(getPositionInGrid(grid), direction);
            if (isInGrid(v))
            {
                if (grid[v.x][v.y] != null)
                {
                    if (grid[v.x][v.y].color != color)
                    {
                        out.add(new Vector2(v.x, v.y));
                    }
                } else
                {
                    out.add(new Vector2(v.x, v.y));
                }
            }


            direction.rotate(45);
        }

        return out;
    }
}
