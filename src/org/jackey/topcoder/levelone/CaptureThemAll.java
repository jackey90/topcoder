package org.jackey.topcoder.levelone;

/**
 * 
 * @author jinhuang
 * 
 *         solved by smalex(https://code.google.com/p/smalex-at-topcoder
 *         /source/browse/trunk/src/p200/srm207/CaptureThemAll.java?r=89)
 * 
 *         Problem Statement for CaptureThemAllProblem Statement Harry is
 *         playing magical chess. In this version of the game, all pieces move
 *         the same way as in regular chess, but players can cast some magical
 *         spells. Unfortunately, Harry's opponent, Joe, has captured all of
 *         Harry's pieces except one knight; Joe, on the other hand, still has a
 *         queen and a rook. The only chance Harry has to win this game is to
 *         cast a spell, "Haste", that will allow Harry's knight to make several
 *         moves in a row. You should determine the minimal number of moves the
 *         knight needs to capture both the rook and the queen, assuming neither
 *         of them moves. You may capture them in either order - rook first or
 *         queen first.
 * 
 * 
 * 
 *         You will be given a String, knight, containing information about the
 *         knight. You will also be given a String, queen, and a String, rook,
 *         giving you information about Joe's pieces. knight, rook and queen
 *         will be formatted as "cr", where c is a character between 'a' and
 *         'h', inclusive, determining the column on the board ('a' is the first
 *         column, 'h' is the last), and r is a digit between '1' and '8',
 *         inclusive, determining the row (1 is the lowest, 8 is the highest).
 *         Definition Class:CaptureThemAllMethod:fastKnightParameters:String,
 *         String, StringReturns:intMethod signature:int fastKnight(String
 *         knight, String rook, String queen)(be sure your method is public)
 *         Notes-A knight's jump moves him 2 cells along one of the axes, and 1
 *         cell along the other one. In other words, if knight is in the (0,0)
 *         now, it can be in (-2, -1), (-2, 1), (2, -1), (2, 1), (-1, -2), (1,
 *         -2), (-1, 2) or (1, 2) after his move.-The knight will capture one of
 *         Joe's pieces if it ends its move in the cell that the piece
 *         occupies.-The knight cannot jump out of the board.-A chessboard has 8
 *         rows and 8 columns. Constraints-knight, rook and queen will all be
 *         distinct.-knight, rook and queen will be formatted as "cr", where c
 *         is a lowercase character between 'a' and 'h', inclusive, and r is a
 *         digit between '1' and '8', inclusive. Examples0) "a1"
 * 
 *         "b3"
 * 
 *         "c5"
 * 
 *         Returns: 2
 * 
 *         From "a1", the knight can move directly to "b3" and capture the rook.
 *         From there, the knight can move directly to "c5" and capture the
 *         queen.1) "b1"
 * 
 *         "c3"
 * 
 *         "a3"
 * 
 *         Returns: 3
 * 
 *         The rook and the queen are both 1 move away from the knight. Once the
 *         knight captures one of them (it doesn't matter which one), it can
 *         return to its starting location, and capture the other piece in one
 *         more move.2) "a1"
 * 
 *         "a2"
 * 
 *         "b2"
 * 
 *         Returns: 6
 * 
 *         The rook and the queen are close, but it takes 6 moves to capture
 *         them.3) "a5"
 * 
 *         "b7"
 * 
 *         "e4"
 * 
 *         Returns: 3
 * 
 *         4) "h8"
 * 
 *         "e2"
 * 
 *         "d2"
 * 
 *         Returns: 6
 * 
 *         This problem statement is the exclusive and proprietary property of
 *         TopCoder, Inc. Any unauthorized use or reproduction of this
 *         information without the prior written consent of TopCoder, Inc. is
 *         strictly prohibited. (c)2010, TopCoder, Inc. All rights reserved.
 * 
 * 
 */

public class CaptureThemAll {

	public int fastKnight(String knight, String rook, String queen) {
		int[] coorsKnight = toCoords(knight);
		int[] coorsRook = toCoords(rook);
		int[] coorsQueen = toCoords(queen);
		int[][] delta = new int[][] { { -2, -1 }, { -2, 1 }, { 2, -1 },
				{ 2, 1 }, { -1, -2 }, { 1, -2 }, { -1, 2 }, { 1, 2 } };

		return Math.min(
				countStep(coorsKnight, coorsRook, delta)
						+ countStep(coorsRook, coorsQueen, delta),
				countStep(coorsKnight, coorsQueen, delta)
						+ countStep(coorsQueen, coorsRook, delta));
	}

	/**
	 * change "cr" to {x,y}
	 * 
	 * @author Jackey
	 * @date Apr 16, 2014
	 * @param str
	 * @return
	 */
	public int[] toCoords(String str) {
		int[] coords = new int[2];
		int x = str.charAt(0) - 'a';
		int y = str.charAt(1) - '1';
		coords[0] = x;
		coords[1] = y;
		return coords;
	}

	private int countStep(int[] coorsKnight, int[] coorsQueen, int[][] delta) {
		int[][] map = new int[8][8];
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				map[x][y] = -1;
			}
		}
		// startpoint
		map[coorsKnight[0]][coorsKnight[1]] = 0;
		map[coorsQueen[0]][coorsQueen[1]] = -7;

		int[][] queue = new int[128][2];
		int queuePut = 0, queueGet = 0;
		// put the startpoint
		queue[queuePut][0] = coorsKnight[0];
		queue[queuePut][1] = coorsKnight[1];
		queuePut++;
		// if the queue is not empty
		while (queueGet < queuePut) {
			int[] pos = queue[queueGet++];

			for (int i = 0; i < delta.length; i++) {
				// one move
				int[] xy = delta[i];
				int nextX = xy[0] + pos[0];
				int nextY = xy[1] + pos[1];
				if (nextX >= 0 && nextX < 8 && nextY >= 0 && nextY < 8) {
					if (map[nextX][nextY] == -1 || map[nextX][nextY] == -7) {
						// step plus one
						final int step = map[pos[0]][pos[1]] + 1;
						if (map[nextX][nextY] < -1) {
							return step;
						}
						map[nextX][nextY] = step;
						queue[queuePut][0] = nextX;
						queue[queuePut][1] = nextY;
						queuePut++;
					}
				}
			}
		}
		return -1;
	}
}
