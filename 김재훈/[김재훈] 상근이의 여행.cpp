#include <iostream>
#include <queue>
#include <vector>
using namespace std;

class Graph {
private:
  // 정점(국가) 개수
  int V;

  // 인접 리스트
  vector<vector<int>> adj;

public:
  // 생성자, 국가를 1~V로 표현하기 때문에 v+1로 벡터 생성자 실행
  Graph(int V) : V(V), adj(V + 1) {}

  // 양방향 간선(비행기) 추가
  void addEdge(int u, int v) {
    adj[u].push_back(v);
    adj[v].push_back(u);
  }

  // BFS를 이용해 스패닝 트리를 만들고, 포함된 간선의 개수를 반환
  int bfsSpanningTree() {
    vector<bool> visited(V + 1, false);

    // 어떤 노드가 처음 방문될 때 연결된 '부모' 기록
    vector<int> parent(V + 1, -1);

    // 너비 우선에서 갈라진 분기점으로 돌아가기 위한 큐
    queue<int> q;

    // 시작 정점을 1번으로 가정 (연결 그래프이므로 어디서 시작해도 됨)
    visited[1] = true;

    // 1번을 방문했으므로 큐에 1번 삽입
    q.push(1);

    // 큐가 비어있지 않으면 다음을 실행
    while (!q.empty()) {
      // 큐에서 현재 정점 꺼내기
      int current = q.front();

      // std::queue<T>의pop() 함수는 반환값이 없고 그저 제거하는 함수
      q.pop();

      // 현재 정점에 인접한 정점들을 탐색
      for (int next : adj[current]) {
        // 아직 방문하지 않았다면
        if (!visited[next]) {
          // 방문하고
          visited[next] = true;
          // 방문한 국가의 이전 국가 기록
          // 현재 스패닝 트리에 포함될 때 사용한 간선 기록
          parent[next] = current;
          // 큐에 추가
          q.push(next);
        }
      }
    }

    // parent[v]가 -1이 아닌 노드는 트리에 편입된 것
    // 즉, BFS로 만든 스패닝 트리에 포함된 간선 수를 센다
    int edgeCount = 0;
    for (int v = 2; v <= V; v++) {
      if (parent[v] != -1) {
        edgeCount++;
      }
    }

    // 연결 그래프라면 항상 V-1이 됨
    return edgeCount;
  }
};

int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);

  // 테스트 케이스 수
  int testCaseNumber;
  cin >> testCaseNumber;

  for (int i = 0; i < testCaseNumber; i++) {
    // 국가(정점) 수, 비행기(간선) 종류 수
    int countries, planes;
    cin >> countries >> planes;

    // 그래프 생성
    Graph g(countries);

    // 비행 스케줄 입력받아 그래프 구성
    for (int i = 0; i < planes; i++) {
      int country1, country2;
      cin >> country1 >> country2;
      g.addEdge(country1, country2);
    }

    // BFS로 만든 스패닝 트리에 포함된 간선 수를 출력
    cout << g.bfsSpanningTree() << "\n";
  }

  return 0;
}