package two_sum.sum;

public class IsoscelesRightTriangleSpiral {

    public static void main(String[] args) {
        int N = 5;

        // 计算三角形总点数（1+2+...+N）
        int totalPoints = N * (N + 1) / 2;
        
        // 创建网格：triangle[i][j]表示第i行第j列的值（i,j从0开始）
        // 第i行有(N-i)个元素
        int[][] triangle = new int[N][];
        // 创建访问标记数组
        boolean[][] visited = new boolean[N][];
        
        // 初始化不规则二维数组：第0行有N列，第1行有N-1列，...，第N-1行有1列
        for (int i = 0; i < N; i++) {
            int columnsInThisRow = N - i;
            triangle[i] = new int[columnsInThisRow];
            visited[i] = new boolean[columnsInThisRow];
        }

        // 方向数组：向下、右上、向左
        // 向下：行增加，列不变
        // 右上：行减少，列增加  
        // 向左：行不变，列减少
        int[][] directions = {{1, 0}, {-1, 1}, {0, -1}};
        int currentDirection = 0; // 起始方向：向下
        
        // 起始位置：左上角（第0行第0列）
        int currentRow = 0;
        int currentCol = 0;
        
        // 从1开始编号
        int currentNumber = 1;
        
        // 螺旋填充数字
        while (currentNumber <= totalPoints) {
            // 在当前位置填写数字并标记为已访问
            triangle[currentRow][currentCol] = currentNumber;
            visited[currentRow][currentCol] = true;
            
            // 尝试按当前方向移动到下一个位置
            int nextRow = currentRow + directions[currentDirection][0];
            int nextCol = currentCol + directions[currentDirection][1];
            
            // 检查下一个位置是否有效（在网格内且未访问）
            if (isValidPosition(nextRow, nextCol, N, visited)) {
                // 有效则移动到下一个位置
                currentRow = nextRow;
                currentCol = nextCol;
            } else {
                // 无效则改变方向（循环尝试三个方向）
                int directionAttempt = 0;
                boolean foundValidDirection = false;
                
                while (directionAttempt < 3 && !foundValidDirection) {
                    currentDirection = (currentDirection + 1) % 3; // 循环切换方向
                    
                    nextRow = currentRow + directions[currentDirection][0];
                    nextCol = currentCol + directions[currentDirection][1];
                    
                    if (isValidPosition(nextRow, nextCol, N, visited)) {
                        currentRow = nextRow;
                        currentCol = nextCol;
                        foundValidDirection = true;
                    }
                    directionAttempt++;
                }
                
                // 如果三个方向都无效，说明所有点已访问完毕（理论上不会发生，因为currentNumber<=totalPoints控制）
                if (!foundValidDirection) {
                    break;
                }
            }
            
            currentNumber++;
        }
        
        // 输出结果：按行优先顺序
        System.out.println("螺旋编号结果：");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j]);
                if (j < triangle[i].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * 检查位置是否有效
     * @param row 行索引
     * @param col 列索引
     * @param N 三角形边长
     * @param visited 访问标记数组
     * @return true如果位置有效且未访问
     */
    private static boolean isValidPosition(int row, int col, int N, boolean[][] visited) {
        // 检查行是否在有效范围内
        if (row < 0 || row >= N) {
            return false;
        }
        // 检查列是否在有效范围内（注意：第row行的列数范围为0到N-row-1）
        if (col < 0 || col >= N - row) {
            return false;
        }
        // 检查是否已访问
        return !visited[row][col];
    }
}