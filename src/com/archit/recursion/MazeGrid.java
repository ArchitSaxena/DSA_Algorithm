package com.archit.recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MazeGrid {
    public static void main(String[] args) {
        MazeGrid obj = new MazeGrid();
        int r = 3, c = 3;
        boolean[][] obstacles = new boolean[r][c];
        for (boolean[] row : obstacles) {
            Arrays.fill(row, true);
        }
//        System.out.println(obj.countPaths(r, c));
//        List<String> paths = new LinkedList<>();
//        obj.printPaths(paths, "", r, c);
//        System.out.println(paths);
//
//        List<String> obstaclesResult = new LinkedList<>();
//        obj.obstaclesResult(obstacles, obstaclesResult, "", 0, 0);
//        System.out.println(obstaclesResult);

        List<String> allDirectionResult = new LinkedList<>();
        obj.allDirectionsPath(obstacles, allDirectionResult, "", 0, 0);
        System.out.println(allDirectionResult);
    }

    public int countPaths(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        return countPaths(r - 1, c) + countPaths(r, c - 1);
    }

    public void printPaths(List<String> paths, String path, int r, int c) {
        if (r == 1 && c == 1) {
            paths.add(path);
            return;
        }
        if (c > 1 && r > 1) {
            printPaths(paths, path + "Di", r - 1, c - 1);
        }
        if (c > 1) {
            printPaths(paths, path + "R", r, c - 1);
        }
        if (r > 1) {
            printPaths(paths, path + "D", r - 1, c);
        }
    }

    public void obstaclesResult(boolean[][] obstacles, List<String> obstaclesResult, String path, int r, int c) {
        if (r == obstacles.length - 1 && c == obstacles[0].length - 1) {
            obstaclesResult.add(path);
            return;
        }
        if (!obstacles[r][c])
            return;
        if (r < obstacles.length - 1 && c < obstacles[0].length - 1) {
            obstaclesResult(obstacles, obstaclesResult, path + "Di", r + 1, c + 1);
        }
        if (c < obstacles[0].length - 1) {
            obstaclesResult(obstacles, obstaclesResult, path + "R", r, c + 1);
        }
        if (r < obstacles.length - 1) {
            obstaclesResult(obstacles, obstaclesResult, path + "D", r + 1, c);
        }
    }

    public void allDirectionsPath(boolean[][] visited, List<String> result, String path, int r, int c) {
        if (r == visited.length - 1 && c == visited[0].length - 1) {
            result.add(path);
            return;
        }
        if (!visited[r][c])
            return;
//        if (r < visited.length-1 && c< visited[0].length-1) {
//            obstaclesResult(visited, result, path + "Di", r + 1, c + 1);
//        }
        visited[r][c] = false;
        if (c < visited[0].length - 1) {
            allDirectionsPath(visited, result, path + "R", r, c + 1);
        }
        if (r < visited.length - 1) {
            allDirectionsPath(visited, result, path + "D", r + 1, c);
        }
        if (r > 0) {
            allDirectionsPath(visited, result, path + "U", r - 1, c);
        }
        if (c > 0) {
            allDirectionsPath(visited, result, path + "L", r, c - 1);
        }
        visited[r][c] = true;
    }
}
