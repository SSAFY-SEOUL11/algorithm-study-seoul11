package mon02.day09_boj_트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_트리_김민권 {

    private static Node root; // 루트 노드 정보
    private static int result; // 리프 노드 개수

    private static class Node {
        int num, parentNum;
        List<Node> childList = new ArrayList<>(); // 해당 노드를 부모로 갖는 자식 노드 리스트

        public Node(int num, int parentNum) { this.num = num; this.parentNum = parentNum; }
        public void setNum(int num) { this.num = num; }
        public void addChild(Node child) { this.childList.add(child); }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Node[] nodeArr = new Node[N];
        for(int i = 0; i < N; i++)
            nodeArr[i] = new Node(i, Integer.parseInt(st.nextToken()));

        int removeNum = Integer.parseInt(br.readLine());
        nodeArr[removeNum].num = Integer.MIN_VALUE; // 지우고자 하는 노드의 Num을 범위 밖으로 초기화

        makeTree(N, nodeArr, removeNum);
        System.out.println(root.num);
        doTraversal(root); // 루트를 기점으로 리프 노드 탐색
        System.out.println(result);
    }

    private static void makeTree(int n, Node[] nodeArr, int removeNum) {
        for(int i = 0; i < n; i++){
            if(nodeArr[i].parentNum == -1) { // 루트노드 찾음
                root = nodeArr[i];
                break;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(nodeArr[i].num == nodeArr[j].parentNum) // 자식노드들 추가
                    nodeArr[i].addChild(nodeArr[j]);
            }
        }
    }

    private static void doTraversal(Node n) {
        if(n.num == Integer.MIN_VALUE) return; // 제거한 노드가 나오면 return; (그 밑의 자식노드는 볼 필요가 없음)
        if(n.childList.isEmpty()) { // 현재노드에 자식노드가 없다면 
            result++; // 리프 노드 발견! (루트 1개만 존재해도 리프 노드임)
            return;
        }
        for(Node child : n.childList) // 현재도가 갖고있는 자식 노드에 대해서 탐색
            doTraversal(child);
    }
}
