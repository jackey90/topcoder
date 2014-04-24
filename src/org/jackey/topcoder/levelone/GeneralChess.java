package org.jackey.topcoder.levelone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jinhuang
 * Date: 4/23/14
 * Time: 4:36 PM
 * To change this template use File | Settings | File Templates.
 * Problem Statement    You have decided that too many people do not know how to play chess. So, in an effort to teach the rules you must write some software that helps to understand how chess-pieces affect one another. Your current project involves the knight and its ability to threaten one or more pieces at once. The knight has an unusual style of "jumping" around the board. One move consists of traveling two squares in one of the four cardinal directions, followed by one square perpendicular to the original direction. For example, if a knight is on (0,0), it may move to (2,1), (2,-1), (1,2), (1,-2), (-2, 1), (-2,-1), (-1,2), or (-1,-2). In addition, if a piece is on any of those locations, it is threatened by the knight on (0,0).You will be given a String[] pieces, where each element is a comma delimited set of coordinates. Every element in pieces is formatted as "<x-coordinate>,<y-coordinate>" (quotes and angle brackets for clarity). Calculate and return a String[] where each element represents a position from which a knight threatens every piece in pieces. Your return String[] must be in the same format as pieces and sorted in increasing order by the x-coordinate. If two sets of coordinates have the same x-coordinate, the one with the smaller y-coordinate must come first. Definition    Class:GeneralChessMethod:attackPositionsParameters:String[]Returns:String[]Method signature:String[] attackPositions(String[] pieces)(be sure your method is public)     Constraints-pieces will contain between 1 and 8 elements, inclusive.-Each element in pieces will be formatted as "<x-coordinate>,<y-coordinate>" (quotes and angle brackets for clarity).-Each <x-coordinate> will be an integer between -10000 and 10000, inclusive and will not contain leading zeros.-Each <y-coordinate> will be an integer between -10000 and 10000, inclusive and will not contain leading zeros.-Each element in pieces will be unique. Examples0)
 * {"0,0"}
 * <p/>
 * Returns: { "-2,-1",  "-2,1",  "-1,-2",  "-1,2",  "1,-2",  "1,2",  "2,-1",  "2,1" }
 * <p/>
 * This location is threatened from eight different places.1)
 * {"2,1", "-1,-2"}
 * <p/>
 * Returns: { "0,0",  "1,-1" }
 * <p/>
 * A knight may be in two places such that both pieces are threatened. In chess, placing your pieces in such positions is usually undesirable when your opponent has a knight.2)
 * {"0,0", "2,1"}
 * <p/>
 * Returns: { }
 * <p/>
 * 3)
 * {"-1000,1000", "-999,999", "-999,997"}
 * <p/>
 * Returns: { "-1001,998" }
 * <p/>
 * No three pieces can ever be threatened by a knight from more than one position.
 */
public class GeneralChess {
    public String[] attackPositions(String[] pieces) {
        List<String> list = new ArrayList<String>();

        if (pieces != null) {
            int[][] realCoords = new int[pieces.length][2];
            int xMax = Integer.MIN_VALUE;
            int xMin = Integer.MAX_VALUE;
            int yMax = Integer.MIN_VALUE;
            int yMin = Integer.MAX_VALUE;

            int[][] visited = new int[7][7];

            for (int i = 0; i < pieces.length; i++) {
                String[] coord = pieces[i].split(",");
                realCoords[i][0] = Integer.parseInt(coord[0]);
                realCoords[i][1] = Integer.parseInt(coord[1]);
                xMax = xMax < realCoords[i][0] ? realCoords[i][0] : xMax;
                xMin = xMin > realCoords[i][0] ? realCoords[i][0] : xMin;
                yMax = yMax < realCoords[i][1] ? realCoords[i][1] : yMax;
                yMin = yMin > realCoords[i][1] ? realCoords[i][1] : yMin;
            }

            int[][] mockCoords = new int[pieces.length][2];
            int xMid = (xMax + xMin) / 2;
            int yMid = (yMax + yMin) / 2;
            if ((xMax - xMin <= 4) && (yMax - yMin <= 4)) {
                int coordXMax = xMid - xMin + 2;
                int coordXMin = xMid - xMin - 2;
                int coordYMax = yMid - yMin + 2;
                int coordYmin = yMid - yMin - 2;

                int[][] move = {{1, 2}, {2, 1}, {-1, -2}, {-2, -1}, {-1, 2}, {1, -2}, {-2, 1}, {2, -1}};
                for (int i = 0; i < pieces.length; i++) {
                    mockCoords[i][0] = realCoords[i][0] - xMin + 2;
                    mockCoords[i][1] = realCoords[i][1] - yMin + 2;

                    for (int j = 0; j < 8; j++) {
                        int x = mockCoords[i][0] + move[j][0];
                        int y = mockCoords[i][1] + move[j][1];
                        if (x >= coordXMin + 2 && x <= coordXMax + 2 && y <= coordYMax + 2 && y >= coordYmin + 2) {
                            visited[x][y] += 1;
                        }
                    }
                }

                for (int i = 0; i < visited.length; i++) {
                    for (int j = 0; j < visited[i].length; j++) {
                        if (visited[i][j] == pieces.length) {
                            list.add((i + xMin - 2) + "," + (j + yMin - 2));
                        }
                    }
                }

            }

        }
        String[] result = new String[list.size()];
        return list.toArray(result);
    }

    public static void main(String[] args) {
        String[] str = {"-1000,1000", "-999,999", "-999,997"};
        String[] result = new GeneralChess().attackPositions(str);

        for (String coord : result) {
            System.out.print(coord);
        }

    }


}
