package org.jackey.topcoder.levelthree;

/**
 * Created with IntelliJ IDEA.
 * User: jinhuang
 * Date: 7/23/14
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 * <p/>
 * Problem Statement for Parking
 * <p/>
 * <p/>
 * Problem Statement
 * In a parking lot there are a lot of cars and parking spots and all cars want to drive to a parking spot. Due to the traffic regulations cars may only drive parallel to the boundaries of the parking lot and only at the speed of one square per unit of time.
 * <p/>
 * <p/>
 * <p/>
 * Usually all cars drive to the nearest available parking spot, but that might turn out badly for some cars. Consider for example the following car park
 * .C.....P.X...
 * XX.......X..P
 * XX.....C.....
 * (here 'C' stands for car, 'P' for parking spot, 'X' for wall and '.' for empty spot)
 * <p/>
 * <p/>
 * <p/>
 * If the car on the bottom drives to its nearest parking spot, the upper left car must drive all the way to the right, taking 13 units of time. If, however, the car on the bottom drives to the parking spot on the right, it will take 6 units of time for both cars to find a parking spot.
 * <p/>
 * <p/>
 * <p/>
 * Return the minimal amount of time it takes before every car can have a parking spot (assuming that the cars act socially like above). All cars start on an empty spot. Cars are small and any number of them can drive on the same square simultaneously. They can drive over empty spots and parking spots, but not through walls. Each car has to end on a separate parking spot.
 * <p/>
 * <p/>
 * <p/>
 * If it is impossible for each car to drive to a parking place, return -1.
 * <p/>
 * Definition
 * <p/>
 * Class:	Parking
 * Method:	minTime
 * Parameters:	String[]
 * Returns:	int
 * Method signature:	int minTime(String[] park)
 * (be sure your method is public)
 * <p/>
 * <p/>
 * Constraints
 * -	park will contain between 1 and 50 elements, inclusive.
 * -	All elements of park have equal length.
 * -	Each element of park has length between 1 and 50, inclusive.
 * -	Each character in park is either 'C', 'P', 'X' or '.'.
 * -	There will be no more than 100 cars and 100 parking places in park.
 * <p/>
 * Examples
 * 0)
 * <p/>
 * {"C.....P",
 * "C.....P",
 * "C.....P"}
 * Returns: 6
 * Every car just drives to the opposite parking spot.
 * 1)
 * <p/>
 * {"C.X.....",
 * "..X..X..",
 * "..X..X..",
 * ".....X.P"}
 * Returns: 16
 * The slalom takes the car 16 units of time.
 * 2)
 * <p/>
 * {"XXXXXXXXXXX",
 * "X......XPPX",
 * "XC...P.XPPX",
 * "X......X..X",
 * "X....C....X",
 * "XXXXXXXXXXX"}
 * Returns: 5
 * This would take 11 instead of 5 units of time if the car on the bottom drove to its nearest parking spot.
 * 3)
 * <p/>
 * {".C.",
 * "...",
 * "C.C",
 * "X.X",
 * "PPP"}
 * Returns: 4
 * While driving, the cars can be on the same empty spot or parking spot, but they have to finish on different parking spots.
 * 4)
 * <p/>
 * {"CCCCC",
 * ".....",
 * "PXPXP"}
 * Returns: -1
 * There are not enough parking spots for all the cars.
 * 5)
 * <p/>
 * {"..X..",
 * "C.X.P",
 * "..X.."}
 * Returns: -1
 * The car can't reach the parking spot.
 */
public class Parking {
}
