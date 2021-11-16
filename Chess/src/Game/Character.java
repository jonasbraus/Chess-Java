package Game;

import java.awt.*;
import java.util.List;

public abstract class Character
{
    public Color color;

    public Character(Color color)
    {
        this.color = color;
    }

    public abstract Image getImage();

    public abstract List<Vector2> getValidMoves(Character[][] grid);

    public enum Color
    {
        black, white
    }

    public Vector2 getPositionInGrid(Character[][] grid)
    {
        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 8; y++)
            {
                if(grid[x][y] == this)
                {
                    return new Vector2(x, y);
                }
            }
        }

        return new Vector2(-1, -1);
    }

    protected boolean isInGrid(Vector2 pos)
    {
        if(pos.x < 0 || pos.x >= 8 || pos.y < 0 || pos.y >= 8)
        {
            return false;
        }

        return true;
    }
}