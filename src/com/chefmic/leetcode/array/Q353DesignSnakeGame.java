package com.chefmic.leetcode.array;

import java.util.*;

/**
 * Created by cyuan on 2/10/17.
 */
public class Q353DesignSnakeGame {

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    class SnakeGame {

        final int width, height;
        final Deque<Point> snake;
        final Queue<Point> foods;
        int score = 0;

        public SnakeGame(int width, int height, int[][] food) {
            foods = new LinkedList<>();
            for (int[] f : food) {
                foods.offer(new Point(f[1], f[0]));
            }
            this.width = width;
            this.height = height;
            this.snake = new LinkedList<>();
            snake.offerFirst(new Point(0, 0));
        }

        /**
         * Moves the snake.
         *
         * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         * @return The game's score after the move. Return -1 if game over.
         * Game over when snake crosses the screen boundary or bites its body.
         */
        public int move(String direction) {
            Point head = snake.peekFirst();
            Point next = null;
            switch (direction) {
                case "U":
                    next = new Point(head.x, head.y - 1);
                    break;
                case "R":
                    next = new Point(head.x + 1, head.y);
                    break;
                case "L":
                    next = new Point(head.x - 1, head.y);
                    break;
                case "D":
                    next = new Point(head.x, head.y + 1);
            }

            if (next.x < 0 || next.x == width || next.y < 0 || next.y == height) return -1;

            if (snake.contains(next)) return -1;

            if (foods.isEmpty() && foods.peek().equals(next)) {
                foods.poll();
                snake.offerFirst(next);
                score++;
            }

            snake.removeLast();
            snake.offerFirst(next);
            return score;
        }
    }

}
