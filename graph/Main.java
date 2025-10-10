package graph;

public class Main {
    public static void main(String[] args) {
        Integer[][] matrix = new Integer[14][3];
        matrix[0][0] = 0;
        matrix[0][1] = 1;
        matrix[0][2] = 1;

        matrix[1][0] = 0;
        matrix[1][1] = 2;
        matrix[1][2] = 2;

        matrix[2][0] = 0;
        matrix[2][1] = 3;
        matrix[2][2] = 3;

        matrix[3][0] = 1;
        matrix[3][1] = 2;
        matrix[3][2] = 4;

        matrix[4][0] = 1;
        matrix[4][1] = 4;
        matrix[4][2] = 5;

        matrix[5][0] = 1;
        matrix[5][1] = 0;
        matrix[5][2] = 1;

        matrix[6][0] = 2;
        matrix[6][1] = 0;
        matrix[6][2] = 2;

        matrix[7][0] = 2;
        matrix[7][1] = 1;
        matrix[7][2] = 4;

        matrix[8][0] = 2;
        matrix[8][1] = 3;
        matrix[8][2] = 6;

        matrix[9][0] = 3;
        matrix[9][1] = 0;
        matrix[9][2] = 3;
        
        matrix[10][0] = 3;
        matrix[10][1] = 2;
        matrix[10][2] = 6;

        matrix[11][0] = 3;
        matrix[11][1] = 4;
        matrix[11][2] = 7;

        matrix[12][0] = 4;
        matrix[12][1] = 3;
        matrix[12][2] = 7;

        matrix[13][0] = 4;
        matrix[13][1] = 1;
        matrix[13][2] = 8;

        Graph graph = GraphGenerator.createGraph(matrix);

        System.out.println("宽度优先搜索");
        BreadthFirstSearch.bfs(graph.nodes.get(0));
        System.out.println("深度优先搜索");
        DepthFirstSearch.dfs(graph.nodes.get(1));
    }
}
