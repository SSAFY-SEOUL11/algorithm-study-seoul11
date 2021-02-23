package mon02.day09_boj_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class Node{
	int num;
	int parent;
	ArrayList<Node> child = new ArrayList<>(); // 자식 노드를 담는 리스트
	
	public Node(int num, int parent) {
		this.num = num;
		this.parent = parent;
	}
	public void add(Node node) {
		this.child.add(node);
	}
}

public class boj_트리_이상현 {
	
	static Node[] node; // default : 0
	static List<Node> root = new ArrayList<Node>(); // 루트노드가 여러 개 일 수 있다
	static boolean[] visited;
	static int n, leaf = 0;
	final static int R = -100;
	
	public static void addChild() {
		
		for(int i = 0; i < n ; i++) {
			if(node[i].parent == -1) {
				root.add(node[i]); // 루트노드의 idx
			}
		}
		for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(node[i].num == node[j].parent) // 자식노드들 추가
                    node[i].add(node[j]);
            }
        }
	}
	
	public static void cntLeaf(Node parent) { // 루트노드 부터 시작
		boolean flag = true;
		
		if(parent.num == R) // 삭제한 노드임
			return;

		for(int i = 0; i < parent.child.size(); i++) {
			if(parent.child.get(i).num != R) { // 하나라도 존재하면
				flag = false; // 단말노드가 아님 
				break;
			} 
		}
		if(flag) { 
			leaf++;
			return;
		}
		/*
		if(parent.child.size() == 0) {
			leaf++; // 리프노드 찾음
			return;
		}
		*/
		
		for(Node child : parent.child)
			cntLeaf(child);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		node = new Node[n];
		visited = new boolean[n];
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int parent = Integer.parseInt(st.nextToken());
			node[i] = new Node(i, parent);
		}
		
		int remove = Integer.parseInt(br.readLine());	
		node[remove].num = R; // 삭제
		
		addChild();
		
		for(int i = 0; i < root.size(); i++) {
			cntLeaf(root.get(i)); // 루트 노드부터 시작
		}
		System.out.print(leaf);
	}
}
