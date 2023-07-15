
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * The Main class has the main method and acts as the driver class for the
 * program
 */
public class Main {

    public static final String ANT_ID = "a";
    public static final String BEATLE_ID = "B";

    //This method finds and returns row number of ant that is nearest in north side
    //Returns MAX_VALUE if no ant exists above
    public static int nearestNorthAnt(Creature board[][], final int GRID_SIZE, final int beetleRow, final int beetleCol) {

        for (int i = beetleRow - 1; i >= 0; i--) {
            if (board[i][beetleCol] != null) {
                if (board[i][beetleCol].Move().equals(ANT_ID)) {
                    return i;
                }
            }
        }

        return Integer.MAX_VALUE;

    }

    //This method finds and returns row number of ant that is nearest in south side
    //Returns MAX_VALUE if no ant exists below
    public static int nearestSouthAnt(Creature board[][], final int GRID_SIZE, final int beetleRow, final int beetleCol) {

        for (int i = beetleRow + 1; i < GRID_SIZE; i++) {
            if (board[i][beetleCol] != null) {
                if (board[i][beetleCol].Move().equals(ANT_ID)) {
                    return i;
                }
            }
        }

        return Integer.MAX_VALUE;

    }

    //This method finds and returns col number of ant that is nearest in east side
    //Returns MAX_VALUE if no ant exists west
    public static int nearestWestAnt(Creature board[][], final int GRID_SIZE, final int beetleRow, final int beetleCol) {

        for (int i = beetleCol - 1; i >= 0; i--) {
            if (board[beetleRow][i] != null) {
                if (board[beetleRow][i].Move().equals(ANT_ID)) {
                    return i;
                }
            }
        }

        return Integer.MAX_VALUE;

    }

    //This method finds and returns col number of ant that is nearest in west side
    //Returns MAX_VALUE if no ant exists east
    public static int nearestEastAnt(Creature board[][], final int GRID_SIZE, final int beetleRow, final int beetleCol) {

        for (int i = beetleCol + 1; i < GRID_SIZE; i++) {
            if (board[beetleRow][i] != null) {
                if (board[beetleRow][i].Move().equals(ANT_ID)) {
                    return i;
                }
            }
        }

        return Integer.MAX_VALUE;

    }

    //This method finds and returns row number of beatke that is nearest in north side
    //Returns MAX_VALUE if no beatle exists above
    public static int nearestNorthBeatle(Creature board[][], final int GRID_SIZE, final int beetleRow, final int beetleCol) {

        for (int i = beetleRow - 1; i >= 0; i--) {
            if (board[i][beetleCol] != null) {
                if (board[i][beetleCol].Move().equals(BEATLE_ID)) {
                    return i;
                }
            }
        }

        return Integer.MAX_VALUE;

    }

    //This method finds and returns row number of ant that is nearest in south side
    //Returns MAX_VALUE if no ant exists below
    public static int nearestSouthBeatle(Creature board[][], final int GRID_SIZE, final int beetleRow, final int beetleCol) {

        for (int i = beetleRow + 1; i < GRID_SIZE; i++) {
            if (board[i][beetleCol] != null) {
                if (board[i][beetleCol].Move().equals(BEATLE_ID)) {
                    return i;
                }
            }
        }

        return Integer.MAX_VALUE;

    }

    //This method finds and returns col number of ant that is nearest in east side
    //Returns MAX_VALUE if no ant exists west
    public static int nearestWestBeatle(Creature board[][], final int GRID_SIZE, final int beetleRow, final int beetleCol) {

        for (int i = beetleCol - 1; i >= 0; i--) {
            if (board[beetleRow][i] != null) {
                if (board[beetleRow][i].Move().equals(BEATLE_ID)) {
                    return i;
                }
            }
        }

        return Integer.MAX_VALUE;

    }

    //This method finds and returns col number of ant that is nearest in west side
    //Returns MAX_VALUE if no ant exists east
    public static int nearestEastBeatle(Creature board[][], final int GRID_SIZE, final int beetleRow, final int beetleCol) {

        for (int i = beetleCol + 1; i < GRID_SIZE; i++) {
            if (board[beetleRow][i] != null) {
                if (board[beetleRow][i].Move().equals(BEATLE_ID)) {
                    return i;
                }
            }
        }

        return Integer.MAX_VALUE;

    }

    public static int countNeighbouringAnts(Creature board[][], final int GRID_SIZE, final int row, final int col) {

        int neighbours = 0;
        if (row < 0 || row >= GRID_SIZE || col < 0 || col >= GRID_SIZE) {
            return 0;
        }

        if (col - 1 >= 0 && board[row][col - 1] != null && board[row][col - 1].Move().equals(ANT_ID)) {
            neighbours++;
        }
        if (col + 1 < GRID_SIZE && board[row][col + 1] != null && board[row][col + 1].Move().equals(ANT_ID)) {
            neighbours++;
        }
        if (row - 1 >= 0 && board[row - 1][col] != null && board[row - 1][col].Move().equals(ANT_ID)) {
            neighbours++;
        }
        if (row + 1 < GRID_SIZE && board[row + 1][col] != null && board[row + 1][col].Move().equals(ANT_ID)) {
            neighbours++;
        }

        //Diagonal Checks
        if (row + 1 < GRID_SIZE && col + 1 < GRID_SIZE && board[row + 1][col + 1] != null && board[row + 1][col + 1].Move().equals(ANT_ID)) {
            neighbours++;
        }
        if (row + 1 < GRID_SIZE && col - 1 >= 0 && board[row + 1][col - 1] != null && board[row + 1][col - 1].Move().equals(ANT_ID)) {
            neighbours++;
        }
        if (row - 1 >= 0 && col + 1 < GRID_SIZE && board[row - 1][col + 1] != null && board[row - 1][col + 1].Move().equals(ANT_ID)) {
            neighbours++;
        }
        if (row - 1 >= 0 && col - 1 >= 0 && board[row - 1][col - 1] != null && board[row - 1][col - 1].Move().equals(ANT_ID)) {
            neighbours++;
        }

        return neighbours;
    }

    //This method performs a single turn on the board
    public static Creature[][] singleBeatleMove(Creature board[][], final int GRID_SIZE) {
        Creature newBoard[][] = new Creature[GRID_SIZE][GRID_SIZE];

        //Copying the board
        for (int k = 0; k < GRID_SIZE; k++) {
            for (int l = 0; l < GRID_SIZE; l++) {
                newBoard[k][l] = board[k][l];
            }
        }

        //The grid is traversed in column major order
        for (int j = 0; j < GRID_SIZE; j++) {
            for (int i = 0; i < GRID_SIZE; i++) {

                if (board[i][j] != null) {

                    //Checking if it was an ant or beetle
                    if (board[i][j].Move().equals(BEATLE_ID)) {

                        /*System.out.println();
                        printBoard(newBoard, GRID_SIZE);
                        System.out.println();*/
                        int northAntRow = nearestNorthAnt(newBoard, GRID_SIZE, i, j);
                        int southAntRow = nearestSouthAnt(newBoard, GRID_SIZE, i, j);
                        int eastAntCol = nearestEastAnt(newBoard, GRID_SIZE, i, j);
                        int westAntCol = nearestWestAnt(newBoard, GRID_SIZE, i, j);

                        int distanceNorth = Math.abs(i - northAntRow);
                        int distanceSouth = Math.abs(i - southAntRow);
                        int distanceEast = Math.abs(j - eastAntCol);
                        int distanceWest = Math.abs(j - westAntCol);

                        int minDist = Math.min(Math.min(distanceNorth, distanceSouth), Math.min(distanceEast, distanceWest));

                        int northAdjacentAnts = -1;
                        int southAdjacentAnts = -1;
                        int eastAdjacentAnts = -1;
                        int westAdjacentAnts = -1;

                        //Checking which ants compete for the min distance
                        if (distanceNorth == minDist) {
                            northAdjacentAnts = countNeighbouringAnts(newBoard, GRID_SIZE, northAntRow, j);
                        }
                        if (distanceEast == minDist) {
                            eastAdjacentAnts = countNeighbouringAnts(newBoard, GRID_SIZE, i, eastAntCol);;
                        }
                        if (distanceSouth == minDist) {
                            southAdjacentAnts = countNeighbouringAnts(newBoard, GRID_SIZE, southAntRow, j);;
                        }
                        if (distanceWest == minDist) {
                            westAdjacentAnts = countNeighbouringAnts(newBoard, GRID_SIZE, i, westAntCol);;
                        }

                        boolean moved = false;
                        //If all adjacent variables have -1, it means that there was no ant in orthogonal
                        if (northAdjacentAnts == -1 && southAdjacentAnts == -1 && eastAdjacentAnts == -1 && westAdjacentAnts == -1) {
                            //Check for farthest edge
                            int northEdgeDistance = i;
                            int southEdgeDistance = Math.abs(i - GRID_SIZE);
                            int eastEdgeDistance = j;
                            int westEdgeDistance = Math.abs(j - GRID_SIZE);

                            int maxEdgeDistance = Math.max(Math.max(northEdgeDistance, southEdgeDistance), Math.max(eastEdgeDistance, westEdgeDistance));

                            //The sequence of if statements act as priority for direction in case of matching distances
                            if (northEdgeDistance == maxEdgeDistance && !moved) {
                                //Making sure that a move is possible
                                if (i - 1 >= 0 && ((board[i - 1][j] == null || board[i - 1][j].Move().equals(ANT_ID))
                                        && (newBoard[i - 1][j] == null || newBoard[i - 1][j].Move().equals(ANT_ID)))) {

                                    if (board[i - 1][j] != null && (board[i - 1][j].Move().equals(ANT_ID))) {
                                        ((Beetle) newBoard[i][j]).incrementAntsEaten();
                                    }

                                    moved = true;
                                    newBoard[i - 1][j] = newBoard[i][j];
                                    newBoard[i][j] = null;
                                }
                            }
                            if (eastEdgeDistance == maxEdgeDistance && !moved) {
                                //Making sure that a move is possible
                                if (j + 1 < GRID_SIZE && (board[i][j + 1] == null || board[i][j + 1].Move().equals(ANT_ID)
                                        && (newBoard[i][j + 1] == null || newBoard[i][j + 1].Move().equals(ANT_ID)))) {
                                    moved = true;

                                    if (board[i][j + 1] != null && (board[i][j + 1].Move().equals(ANT_ID))) {
                                        ((Beetle) newBoard[i][j]).incrementAntsEaten();
                                    }

                                    newBoard[i][j + 1] = newBoard[i][j];
                                    newBoard[i][j] = null;
                                }
                            }
                            if (southEdgeDistance == maxEdgeDistance && !moved) {
                                //Making sure that a move is possible
                                if (i + 1 < GRID_SIZE && (board[i + 1][j] == null || board[i + 1][j].Move().equals(ANT_ID)
                                        && (newBoard[i + 1][j] == null || newBoard[i + 1][j].Move().equals(ANT_ID)))) {

                                    if (board[i + 1][j] != null && (board[i + 1][j].Move().equals(ANT_ID))) {
                                        ((Beetle) newBoard[i][j]).incrementAntsEaten();
                                    }

                                    moved = true;
                                    newBoard[i + 1][j] = newBoard[i][j];
                                    newBoard[i][j] = null;
                                }
                            }
                            if (westEdgeDistance == maxEdgeDistance && !moved) {
                                //Making sure that a move is possible
                                if (j - 1 >= 0 && ((board[i][j - 1] == null || board[i][j - 1].Move().equals(ANT_ID))
                                        && (newBoard[i][j - 1] == null || newBoard[i][j - 1].Move().equals(ANT_ID)))) {
                                    moved = true;

                                    if (board[i][j - 1] != null && (board[i][j - 1].Move().equals(ANT_ID))) {
                                        ((Beetle) newBoard[i][j]).incrementAntsEaten();
                                    }

                                    newBoard[i][j - 1] = newBoard[i][j];
                                    newBoard[i][j] = null;
                                }
                            }

                        } else {

                            int maxAdjacentAnts = Math.max(Math.max(northAdjacentAnts, southAdjacentAnts), Math.max(eastAdjacentAnts, westAdjacentAnts));

                            //The sequence of if statements act as priority for direction in case of matching distances
                            if (northAdjacentAnts == maxAdjacentAnts && !moved) {
                                //Making sure that a move is possible
                                if (i - 1 >= 0 && ((board[i - 1][j] == null || board[i - 1][j].Move().equals(ANT_ID))
                                        && (newBoard[i - 1][j] == null || newBoard[i - 1][j].Move().equals(ANT_ID)))) {
                                    moved = true;

                                    if (board[i - 1][j] != null && (board[i - 1][j].Move().equals(ANT_ID))) {
                                        ((Beetle) newBoard[i][j]).incrementAntsEaten();
                                    }

                                    newBoard[i - 1][j] = newBoard[i][j];
                                    newBoard[i][j] = null;
                                }
                            }
                            if (eastAdjacentAnts == maxAdjacentAnts && !moved) {
                                //Making sure that a move is possible
                                if (j + 1 < GRID_SIZE && (board[i][j + 1] == null || board[i][j + 1].Move().equals(ANT_ID)
                                        && (newBoard[i][j + 1] == null || newBoard[i][j + 1].Move().equals(ANT_ID)))) {
                                    moved = true;

                                    if (board[i][j + 1] != null && (board[i][j + 1].Move().equals(ANT_ID))) {
                                        ((Beetle) newBoard[i][j]).incrementAntsEaten();
                                    }

                                    newBoard[i][j + 1] = newBoard[i][j];
                                    newBoard[i][j] = null;
                                }
                            }
                            if (southAdjacentAnts == maxAdjacentAnts && !moved) {
                                //Making sure that a move is possible
                                if (i + 1 < GRID_SIZE && (board[i + 1][j] == null || board[i + 1][j].Move().equals(ANT_ID)
                                        && (newBoard[i + 1][j] == null || newBoard[i + 1][j].Move().equals(ANT_ID)))) {
                                    moved = true;
                                    if (board[i + 1][j] != null && (board[i + 1][j].Move().equals(ANT_ID))) {
                                        ((Beetle) newBoard[i][j]).incrementAntsEaten();
                                    }
                                    newBoard[i + 1][j] = newBoard[i][j];
                                    newBoard[i][j] = null;
                                }
                            }
                            if (westAdjacentAnts == maxAdjacentAnts && !moved) {
                                //Making sure that a move is possible
                                if (j - 1 >= 0 && ((board[i][j - 1] == null || board[i][j - 1].Move().equals(ANT_ID))
                                        && (newBoard[i][j - 1] == null || newBoard[i][j - 1].Move().equals(ANT_ID)))) {
                                    moved = true;

                                    if (board[i][j - 1] != null && (board[i][j - 1].Move().equals(ANT_ID))) {
                                        ((Beetle) newBoard[i][j]).incrementAntsEaten();
                                    }

                                    newBoard[i][j - 1] = newBoard[i][j];
                                    newBoard[i][j] = null;
                                }
                            }

                        }

                        if (!moved) {
                            if (i - 1 >= 0 && ((board[i - 1][j] == null || board[i - 1][j].Move().equals(ANT_ID))
                                    && (newBoard[i - 1][j] == null || newBoard[i - 1][j].Move().equals(ANT_ID)))) {
                                moved = true;
                                if (board[i - 1][j] != null && (board[i - 1][j].Move().equals(ANT_ID))) {
                                    ((Beetle) newBoard[i][j]).incrementAntsEaten();
                                }

                                newBoard[i - 1][j] = newBoard[i][j];
                                newBoard[i][j] = null;
                            }
                            if (j + 1 < GRID_SIZE && (board[i][j + 1] == null || board[i][j + 1].Move().equals(ANT_ID)
                                    && (newBoard[i][j + 1] == null || newBoard[i][j + 1].Move().equals(ANT_ID)))) {
                                moved = true;

                                if (board[i][j + 1] != null && (board[i][j + 1].Move().equals(ANT_ID))) {
                                    ((Beetle) newBoard[i][j]).incrementAntsEaten();
                                }

                                newBoard[i][j + 1] = newBoard[i][j];
                                newBoard[i][j] = null;
                            }
                            if (i + 1 < GRID_SIZE && (board[i + 1][j] == null || board[i + 1][j].Move().equals(ANT_ID)
                                    && (newBoard[i + 1][j] == null || newBoard[i + 1][j].Move().equals(ANT_ID)))) {
                                moved = true;

                                if (board[i + 1][j] != null && (board[i + 1][j].Move().equals(ANT_ID))) {
                                    ((Beetle) newBoard[i][j]).incrementAntsEaten();
                                }

                                newBoard[i + 1][j] = newBoard[i][j];
                                newBoard[i][j] = null;
                            }
                            if (j - 1 >= 0 && ((board[i][j - 1] == null || board[i][j - 1].Move().equals(ANT_ID))
                                    && (newBoard[i][j - 1] == null || newBoard[i][j - 1].Move().equals(ANT_ID)))) {
                                moved = true;

                                if (board[i][j - 1] != null && (board[i][j - 1].Move().equals(ANT_ID))) {
                                    ((Beetle) newBoard[i][j]).incrementAntsEaten();
                                }

                                newBoard[i][j - 1] = newBoard[i][j];
                                newBoard[i][j] = null;
                            }
                        }

                    }

                }

            }
        }

        return newBoard;

    }

    //This method performs a single turn on the board
    public static Creature[][] singleAntMove(Creature board[][], final int GRID_SIZE) {

        Creature newBoard[][] = new Creature[GRID_SIZE][GRID_SIZE];

        //Copying the board
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                newBoard[i][j] = board[i][j];
            }
        }

        //The grid is traversed in column major order
        for (int j = 0; j < GRID_SIZE; j++) {
            for (int i = 0; i < GRID_SIZE; i++) {

                if (board[i][j] != null && newBoard[i][j] != null) {

                    //Checking if it was an ant or beetle
                    if (newBoard[i][j].Move().equals(ANT_ID)) {

                        int northAntRow = nearestNorthBeatle(newBoard, GRID_SIZE, i, j);
                        int southAntRow = nearestSouthBeatle(newBoard, GRID_SIZE, i, j);
                        int eastAntCol = nearestEastBeatle(newBoard, GRID_SIZE, i, j);
                        int westAntCol = nearestWestBeatle(newBoard, GRID_SIZE, i, j);

                        int distanceNorth = Math.abs(i - northAntRow);
                        int distanceSouth = Math.abs(i - southAntRow);
                        int distanceEast = Math.abs(j - eastAntCol);
                        int distanceWest = Math.abs(j - westAntCol);

                        int minDist = -1;

                        boolean firstTime = true;

                        //Finding distance to max farthest beatle
                        int maxDist = -1;
                        if (northAntRow != Integer.MAX_VALUE) {
                            maxDist = distanceNorth;
                            minDist = distanceNorth;
                        }

                        if (eastAntCol != Integer.MAX_VALUE) {
                            if (firstTime) {
                                maxDist = distanceEast;
                                minDist = distanceEast;
                                firstTime = false;
                            }
                            if (distanceEast > maxDist) {
                                maxDist = distanceEast;
                            }
                            if (distanceEast < minDist) {
                                minDist = distanceEast;
                            }
                        }
                        if (westAntCol != Integer.MAX_VALUE) {
                            if (firstTime) {
                                maxDist = distanceWest;
                                minDist = distanceWest;
                                firstTime = false;
                            }

                            if (distanceWest > maxDist) {
                                maxDist = distanceWest;
                            }
                            if (distanceWest < minDist) {
                                minDist = distanceWest;
                            }
                        }

                        if (southAntRow != Integer.MAX_VALUE) {

                            if (firstTime) {
                                maxDist = distanceSouth;
                                minDist = distanceSouth;
                                firstTime = false;
                            }

                            if (distanceSouth > maxDist) {
                                maxDist = distanceSouth;
                            }
                            if (distanceSouth < minDist) {
                                minDist = distanceSouth;
                            }
                        }

                        boolean moved = false;

                        if (distanceNorth == minDist && distanceEast == minDist && distanceWest == minDist && distanceSouth == minDist) {
                            //No need to move
                        } else {

                            if (distanceNorth == minDist && !moved) {
                                //Making sure that a move is possible
                                //if (eastAntCol == Integer.MAX_VALUE && westAntCol == Integer.MAX_VALUE && southAntRow == Integer.MAX_VALUE) {
                                if (i + 1 < GRID_SIZE && board[i + 1][j] == null && (newBoard[i + 1][j] == null)) {
                                    moved = true;
                                    newBoard[i + 1][j] = newBoard[i][j];
                                    newBoard[i][j] = null;
                                }
                                //}

                            }
                            if (distanceEast == minDist && !moved) {
                                //Making sure that a move is possible

                                //if (northAntRow == Integer.MAX_VALUE && westAntCol == Integer.MAX_VALUE && southAntRow == Integer.MAX_VALUE) {
                                if (j - 1 >= 0 && board[i][j - 1] == null && (newBoard[i][j - 1] == null)) {
                                    moved = true;
                                    newBoard[i][j - 1] = newBoard[i][j];
                                    newBoard[i][j] = null;
                                }
                                //}
                            }
                            if (distanceSouth == minDist && !moved) {
                                //Making sure that a move is possible

                                //if (northAntRow == Integer.MAX_VALUE && westAntCol == Integer.MAX_VALUE && eastAntCol == Integer.MAX_VALUE) {
                                if (i - 1 >= 0 && board[i - 1][j] == null && (newBoard[i - 1][j] == null)) {
                                    moved = true;
                                    newBoard[i - 1][j] = newBoard[i][j];
                                    newBoard[i][j] = null;
                                }
                                //}
                            }
                            if (distanceWest == minDist && !moved) {
                                //Making sure that a move is possible
                                //if (northAntRow == Integer.MAX_VALUE && eastAntCol == Integer.MAX_VALUE && southAntRow == Integer.MAX_VALUE) {
                                if (j + 1 < GRID_SIZE && board[i][j + 1] == null && (newBoard[i][j + 1] == null)) {
                                    moved = true;
                                    newBoard[i][j + 1] = newBoard[i][j];
                                    newBoard[i][j] = null;
                                }
                                //}
                            }
                        }

                    }

                }

            }
        }

        return newBoard;

    }

    //This method performs a single turn on the board
    public static Creature[][] singleAntBreed(Creature board[][], final int GRID_SIZE, char antSymbol) {

        Creature newBoard[][] = new Creature[GRID_SIZE][GRID_SIZE];

        //Copying the board
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                newBoard[i][j] = board[i][j];
            }
        }

        //The grid is traversed in column major order
        for (int j = 0; j < GRID_SIZE; j++) {
            for (int i = 0; i < GRID_SIZE; i++) {

                if (board[i][j] != null) {

                    //Checking if it was an ant or beetle
                    if (board[i][j].Move().equals(ANT_ID)) {

                        boolean placed = false;
                        if (board[i][j].Breed()) {

                            if (i - 1 >= 0 && (board[i - 1][j] == null && (newBoard[i - 1][j] == null))) {
                                placed = true;
                                newBoard[i - 1][j] = new Ant(antSymbol);
                            }
                            if (!placed && j + 1 < GRID_SIZE && board[i][j + 1] == null && (newBoard[i][j + 1] == null)) {
                                placed = true;
                                newBoard[i][j + 1] = new Ant(antSymbol);
                            }
                            if (!placed && i + 1 < GRID_SIZE && board[i + 1][j] == null && (newBoard[i + 1][j] == null)) {
                                placed = true;
                                newBoard[i + 1][j] = new Ant(antSymbol);
                            }
                            if (!placed && j - 1 >= 0 && (board[i][j - 1] == null) && (newBoard[i][j - 1] == null)) {
                                placed = true;
                                newBoard[i][j - 1] = new Ant(antSymbol);
                            }

                        }
                    }

                }

            }
        }

        return newBoard;

    }

    //This method performs a single turn on the board
    public static Creature[][] singleBeetleBreed(Creature board[][], final int GRID_SIZE, char beetleSymbol) {

        Creature newBoard[][] = new Creature[GRID_SIZE][GRID_SIZE];

        //Copying the board
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                newBoard[i][j] = board[i][j];
            }
        }

        //The grid is traversed in column major order
        for (int j = 0; j < GRID_SIZE; j++) {
            for (int i = 0; i < GRID_SIZE; i++) {

                if (board[i][j] != null) {

                    //Checking if it was an ant or beetle
                    if (board[i][j].Move().equals(BEATLE_ID)) {

                        boolean placed = false;
                        if (board[i][j].Breed()) {

                            if (i - 1 >= 0 && (board[i - 1][j] == null && (newBoard[i - 1][j] == null))) {
                                placed = true;
                                newBoard[i - 1][j] = new Beetle(beetleSymbol);
                            }
                            if (!placed && j + 1 < GRID_SIZE && board[i][j + 1] == null && (newBoard[i][j + 1] == null)) {
                                placed = true;
                                newBoard[i][j + 1] = new Beetle(beetleSymbol);
                            }
                            if (!placed && i + 1 < GRID_SIZE && board[i + 1][j] == null && (newBoard[i + 1][j] == null)) {
                                placed = true;
                                newBoard[i + 1][j] = new Beetle(beetleSymbol);
                            }
                            if (!placed && j - 1 >= 0 && (board[i][j - 1] == null) && (newBoard[i][j - 1] == null)) {
                                placed = true;
                                newBoard[i][j - 1] = new Beetle(beetleSymbol);
                            }

                        }
                    }

                }

            }
        }

        return newBoard;

    }

    //This method performs a single turn on the board
    public static void singleBeetleStarve(Creature board[][], final int GRID_SIZE) {

        //The grid is traversed in column major order
        for (int j = 0; j < GRID_SIZE; j++) {
            for (int i = 0; i < GRID_SIZE; i++) {

                if (board[i][j] != null) {

                    //Checking if it was an ant or beetle
                    if (board[i][j].Move().equals(BEATLE_ID)) {

                        if (((Beetle) board[i][j]).Starve()) {

                            //Starving simply means that the beatle is removed from the board
                            board[i][j] = null;

                        }
                    }

                }

            }
        }

    }

    //This method increments survival of all live creatures
    public static void survivalIncrement(Creature board[][], final int GRID_SIZE) {

        //The grid is traversed in column major order
        for (int j = 0; j < GRID_SIZE; j++) {
            for (int i = 0; i < GRID_SIZE; i++) {

                if (board[i][j] != null) {

                    board[i][j].incrementSurvivedForTurns();

                }
            }
        }

    }

    public static void turnsSinceAntIncrement(Creature board[][], final int GRID_SIZE) {

        //The grid is traversed in column major order
        for (int j = 0; j < GRID_SIZE; j++) {
            for (int i = 0; i < GRID_SIZE; i++) {

                if (board[i][j] != null) {

                    if (board[i][j].Move().equals(BEATLE_ID)) {
                        ((Beetle) board[i][j]).incrementTurnsSinceAnt();
                    }

                }
            }
        }

    }

    //The printBoard method prints the board of creatures on console
    public static void printBoard(Creature board[][], final int GRID_SIZE) {

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {

                if (board[i][j] != null) {
                    System.out.print(board[i][j].getSymbol());
                } else {
                    System.out.print(" ");
                }

            }

            System.out.println("");
        }

    }

    public static void main(String args[]) throws FileNotFoundException {

        //Initializing the grid for game board
        //An empty index is represented by null
        final int GRID_SIZE = 10;
        final char ANT_FILE_SYMBOL = 'a';
        final char BEETLE_FILE_SYMBOL = 'B';
        Creature board[][] = new Creature[GRID_SIZE][GRID_SIZE];

        //Getting input file name from user
        String fileName;

        Scanner input = new Scanner(System.in);
        fileName = input.nextLine();

        //Getting input for ant and beetle characters
        String ant;
        String beetle;
        int numberOfTurns;
        char antSymbol;
        char beetleSymbol;

        ant = input.nextLine();

        beetle = input.nextLine();

        numberOfTurns = input.nextInt();
        //input.nextLine();
        antSymbol = ant.charAt(0);
        beetleSymbol = beetle.charAt(0);

        File file = new File(fileName);
        Scanner fileInput = new Scanner(file);
        for (int i = 0; i < GRID_SIZE; i++) {
            String singleLine = fileInput.nextLine();
            for (int j = 0; j < GRID_SIZE; j++) {
                if (singleLine.charAt(j) == ANT_FILE_SYMBOL) {
                    board[i][j] = new Ant(antSymbol);
                } else if (singleLine.charAt(j) == BEETLE_FILE_SYMBOL) {
                    board[i][j] = new Beetle(beetleSymbol);
                }
            }
        }

        //This loop performs the movements for the number of turns
        for (int i = 0; i < numberOfTurns; i++) {

            board = singleBeatleMove(board, GRID_SIZE);
            board = singleAntMove(board, GRID_SIZE);
            survivalIncrement(board, GRID_SIZE);
            turnsSinceAntIncrement(board, GRID_SIZE);
            singleBeetleStarve(board, GRID_SIZE);
            board = singleAntBreed(board, GRID_SIZE, antSymbol);
            board = singleBeetleBreed(board, GRID_SIZE, beetleSymbol);
            
            
            

            int turnNumber = i + 1;
            System.out.println("TURN " + turnNumber);
            printBoard(board, GRID_SIZE);
            if (i != numberOfTurns - 1) {
                System.out.println("");
            }

        }

    }

}
