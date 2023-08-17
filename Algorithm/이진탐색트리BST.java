import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		
		
	}
}

class BynarySearchTree {
	static Node root = null; //클래스 할당 시 루트노드를 생성
	
	//특정 값 BST에 추가
	public static void AddNode(int value) {
		//BST가 빈 경우
		Node node = new Node(value); //매개변수로 받은 값에 대한 노드를 생성
		if(root == null) {
			root = node; //루트에 새로운 노드를 할당
		} else { //BST가 비어있지 않은 경우
			Node head = root; //루트를 가리키는 헤더
			Node CurrentNode; //현재를 가리키는 포인터
			
			while(true) {
				CurrentNode = head;
				
				if(head.Vertex > value) { //현재 루트보다 작은 경우
					head = head.leftNode;
					
					
					if(head == null) { //헤드가 널일 경우는 왼쪽 자식 노드가 없는 경우
						//현재 헤드위치에 새로운 노드 할당
						head = node;
						break;
					}
				} else { //현재 루트보다 클 경우
					head = head.rightNode; //현재 루트의 오른쪽 자식노드로 탐색
					
					
					if(head == null) {//헤드가 널일 경우는 오른쪽 자식 노드가 없는 경우
						head = node;
						break;
					}
				}
				
			}
		}
	}
	//특정 값을 가진 노드 삭제 메서드
	public static boolean Remove(int Value) {
		Node removeNode = root; //루트에서부터 삭제대상의 위치를 탐색
		Node parent_remover = null; //해당 노드를 찾아 삭제 후 삭제된 노드의 부모에 연결시켜주기 위한 변수 선언
		
		while(removeNode.Vertex != Value) { //루트노드가 찾는 값이 아니라면 ==> 탐색
			parent_remover = removeNode; //부모 노드를 루트 노드로 카피
			
			//삭제할 값이 현재 노드보다 작다면 왼쪽 탐색
			if(removeNode.Vertex > Value) {
				removeNode = removeNode.leftNode;
			} else {
				removeNode = removeNode.rightNode;
			}
			
			//대소관계를 비교해가며 탐색했을 때 leaf Node인 경우 삭제를 위한 탐색은 실패로 끝
			if(removeNode == null) {
				return false;
			}
		}
		
		//while을 빠져나왔다는건 삭제할 값의 노드를 BST에서 발견했을 경우 (즉 removeNode == 삭제대상노드)
		
		//삭제대상노드가 자식이 없을 경우 => 해당 노드만 삭제 후 종료
		if(removeNode.leftNode == null && removeNode.rightNode == null) {
			if(removeNode == root) { //삭제 대상이 트리의 루트일 때
				removeNode = null;
			} else if (removeNode == parent_remover.rightNode) { //삭제대상 노드가 부모의 오른쪽 노드일 때
				parent_remover.rightNode = null;
			} else { //삭제대상 노드가 부모의 오른쪽 노드일 때
				parent_remover.leftNode = null;
			}
		}
		
		//삭제대상노드의 왼쪽 자식노드만 존재할 경우 => parent_remover = removeNode.leftNode
		if(removeNode.leftNode != null && removeNode.rightNode == null) {
			if(removeNode == root) {//삭제할 노드가 최상단 루트 노드라면
				root = removeNode.leftNode;
			} else if(removeNode == parent_remover.rightNode) { //삭제할 노드가 부모의 오른쪽 노드라면
				parent_remover.rightNode = removeNode.leftNode;
			} else {
				parent_remover.leftNode = removeNode.leftNode;
			}
		}
		
		//삭제대상노드의 왼쪽 오른쪽 자식 모두 존재할 경우
		if(removeNode.leftNode != null && removeNode.rightNode != null) {
			if()
		}
		
	}
}
class Node {
	int Vertex;
	Node leftNode;
	Node rightNode;
	public Node(int vertex, Node leftNode, Node rightNode) {
		super();
		Vertex = vertex;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	
	public Node(int value) {
		this.Vertex = value;
	}
}
