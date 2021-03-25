package com.group1;

import java.util.ArrayList;

public class CreateMap {
    private final int row;
    private final int col;
    private final int r;
    private final int c;
    public int[][] map;


    CreateMap(int initRow, int initCol){
        row = initRow;
        col = initCol;
        r = (2 * row) + 1;
        c = (2 * col) + 1;

        map = new int[r][c];
    }

    public void InitMap(){
        for (int i = 0; i < r; i++) // Set all grids as walls
            for (int j = 0; j < c; j++)
                map[i][j] = 0; //0 is an unbreakable wall, 1 is not a wall

        // The middle grid is set to 1
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                map[(2 * i) + 1][(2 * j) + 1] = 1; //0 is an unbreakable wall, 1 is not a wall
    }

}
