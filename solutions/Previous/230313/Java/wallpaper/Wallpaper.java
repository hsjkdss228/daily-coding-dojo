public class Wallpaper {
    public static class Grid {
        private final int row;
        private final int column;

        public Grid(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public static Grid of(int row, int column) {
            return new Grid(row, column);
        }

        public int row() {
            return row;
        }

        public int column() {
            return column;
        }

        @Override
        public String toString() {
            return "Grid{" +
                "row=" + row +
                ", column=" + column +
                '}';
        }
    }

    public int[] solution(String[] wallpaper) {
        int left = 0;
        int top = 0;
        int right = wallpaper[0].length();
        int bottom = wallpaper.length;
        Grid leftmost = Grid.of(top, right);
        Grid topmost = Grid.of(bottom, left);
        Grid rightmost = Grid.of(top, left);
        Grid bottommost = Grid.of(top, left);

        for (int row = 0; row < wallpaper.length; row += 1) {
            for (int column = 0; column < wallpaper[row].length(); column += 1) {
                char status = wallpaper[row].charAt(column);
                if (status == '#') {
                    if (leftmost.column() > column) {
                        leftmost = Grid.of(row, column);
                    }
                    if (topmost.row() > row) {
                        topmost = Grid.of(row, column);
                    }
                    if (rightmost.column() < column) {
                        rightmost = Grid.of(row, column);
                    }
                    if (bottommost.row() < row) {
                        bottommost = Grid.of(row, column);
                    }
                }
            }
        }

        int topmostX = topmost.row();
        int leftmostY = leftmost.column();
        int bottommostX = bottommost.row() + 1;
        int rightmostY = rightmost.column() + 1;
        return new int[]{topmostX, leftmostY, bottommostX, rightmostY};
    }
}
