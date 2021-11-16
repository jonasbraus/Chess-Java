package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Knight extends Character
{
    public Knight(Color color)
    {
        super(color);
    }
    private static Vector2[] moves =
            {
                    new Vector2(-2, 1),
                    new Vector2(-1, 2),
                    new Vector2(1, 2),
                    new Vector2(2, 1),
                    new Vector2(2, -1),
                    new Vector2(1, -2),
                    new Vector2(-1, -2),
                    new Vector2(-2, -1),
            };

    @Override
    public Image getImage()
    {
        if(color == Color.black)
        {
            return new ImageIcon("Graphics/blackKnight.png").getImage();
        }

        return new ImageIcon("Graphics/whiteKnight.png").getImage();
    }

    @Override
    public List<Vector2> getValidMoves(Character[][] grid)
    {
        List<Vector2> out = new ArrayList<>();

        for(Vector2 vs : moves)
        {
            Vector2 v = Vector2.add(getPositionInGrid(grid), vs);

            if(isInGrid(v))
            {
                if (grid[v.x][v.y] == null)
                {
                    out.add(new Vector2(v.x, v.y));
                } else
                {
                    if (grid[v.x][v.y].color != color)
                    {
                        out.add(new Vector2(v.x, v.y));
                    }
                }
            }
        }

        return out;
    }
}
