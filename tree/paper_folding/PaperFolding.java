package tree.paper_folding;

// 一个纸条，依次对折，打印出对应的折痕（凹凸），输入为对折的次数
// 折叠完以后，是一个满二叉树，中序遍历就是对应的折痕（左节点为凹，右节点为凸）
public class PaperFolding {
    public static void main(String[] args) {
        int N = 3;
        printAllFolds(N);
    }

    public static void printAllFolds(int N) {
        printProcess(1, N, true);
    }

    // 递归过程，来到某一个节点
    // i 是节点的层数，N一共的层数，down == true 凹，down == false 凸
    public static void printProcess(int i, int N, boolean down) {
        if (i> N) {
            return;
        }

        printProcess(i+1, N, true);
        System.out.println(down ? "凹":"凸");
        printProcess(i+1, N, false);
    }
}
