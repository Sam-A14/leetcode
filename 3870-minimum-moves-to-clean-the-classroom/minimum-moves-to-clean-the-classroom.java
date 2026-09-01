class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int litterCount = 0;

        // ID of each litter cell
        int[][] id = new int[m][n];

        for (int i = 0; i < m; i++) {
            java.util.Arrays.fill(id[i], -1);

            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    id[i][j] = litterCount++;
                }
            }
        }

        int target = (1 << litterCount) - 1;

        if (target == 0)
            return 0;

        /*
            state = {row, col, energy, mask, moves}
        */
        java.util.Queue<int[]> q = new java.util.ArrayDeque<>();

        q.offer(new int[]{sr, sc, energy, 0, 0});

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        visited[sr][sc][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int e = cur[2];
            int mask = cur[3];
            int moves = cur[4];

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                // Outside grid
                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                // Wall
                if (classroom[nr].charAt(nc) == 'X')
                    continue;

                // Need energy to make a move
                if (e == 0)
                    continue;

                int ne = e - 1;
                int nm = mask;

                char cell = classroom[nr].charAt(nc);

                // Reset energy
                if (cell == 'R') {
                    ne = energy;
                }

                // Collect litter
                if (cell == 'L') {
                    nm |= (1 << id[nr][nc]);
                }

                // All litter collected
                if (nm == target) {
                    return moves + 1;
                }

                if (visited[nr][nc][ne][nm])
                    continue;

                visited[nr][nc][ne][nm] = true;

                q.offer(new int[]{
                    nr, nc, ne, nm, moves + 1
                });
            }
        }

        return -1;
    }
}