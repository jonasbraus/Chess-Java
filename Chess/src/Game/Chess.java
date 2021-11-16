package Game;

import GUI.Window;

public class Chess
{
    private Character[][] grid = new Character[8][8];
    private byte[][] highlights = new byte[8][8];
    private Window window;
    private Character selected;
    private Character.Color turn = Character.Color.white;

    public void init()
    {
        window = new Window(this);

        addCharacters();
        window.drawGame(grid, highlights);
    }

    public void onMousePressed(Vector2 mousePosInFrame)
    {
        Vector2 position = framePositionToGrid(mousePosInFrame);

        removeAllHighlights();
        if(selected != null)
        {
            for (Vector2 v : selected.getValidMoves(grid))
            {
                if(v.equals(position))
                {
                    Vector2 selectedPos = selected.getPositionInGrid(grid);
                    grid[v.x][v.y] = grid[selectedPos.x][selectedPos.y];
                    grid[selectedPos.x][selectedPos.y] = null;
                    selected = null;
                    removeAllHighlights();

                    if(turn == Character.Color.white) turn = Character.Color.black; else turn = Character.Color.white;

                    return;
                }
            }
        }

        if(selected == grid[position.x][position.y] || grid[position.x][position.y] == null)
        {
            selected = null;
        }
        else if(grid[position.x][position.y].color == turn)
        {
            selected = grid[position.x][position.y];
            highlights[position.x][position.y] = 1;
            for (Vector2 v : selected.getValidMoves(grid))
            {
                if(grid[v.x][v.y] == null)
                {
                    highlights[v.x][v.y] = 2;
                }
                else
                {
                    highlights[v.x][v.y] = 3;
                }
            }
        }
    }

    private void removeAllHighlights()
    {
        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 8; y++)
            {
                highlights[x][y] = 0;
            }
        }
    }

    private Vector2 framePositionToGrid(Vector2 pos)
    {
        return new Vector2((int)(pos.x / (window.getWidth() / 8f)), (int)(pos.y / (window.getWidth() / 8f)));
    }

    private void addCharacters()
    {
        grid[0][0] = new Rook(Character.Color.black);
        grid[1][0] = new Knight(Character.Color.black);
        grid[2][0] = new Bishop(Character.Color.black);
        grid[3][0] = new Queen(Character.Color.black);
        grid[4][0] = new King(Character.Color.black);
        grid[5][0] = new Bishop(Character.Color.black);
        grid[6][0] = new Knight(Character.Color.black);
        grid[7][0] = new Rook(Character.Color.black);

        for(int x = 0; x < 8; x++)
        {
            grid[x][1] = new Pawn(Character.Color.black);
        }

        grid[0][7] = new Rook(Character.Color.white);
        grid[1][7] = new Knight(Character.Color.white);
        grid[2][7] = new Bishop(Character.Color.white);
        grid[3][7] = new Queen(Character.Color.white);
        grid[4][7] = new King(Character.Color.white);
        grid[5][7] = new Bishop(Character.Color.white);
        grid[6][7] = new Knight(Character.Color.white);
        grid[7][7] = new Rook(Character.Color.white);

        for(int x = 0; x < 8; x++)
        {
            grid[x][6] = new Pawn(Character.Color.white);
        }
    }
}
