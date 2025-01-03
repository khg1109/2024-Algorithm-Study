#include <iostream>
#include <queue>
#include <set>
#include <vector>

class TernaryTree {
private:
  int data;
  int search;
  int timer;
  std::vector<TernaryTree *> children;

public:
  TernaryTree();
  TernaryTree(int data, int search, int timer);

  int printTimer();
};

TernaryTree::TernaryTree(int data, int search, int timer) : data(data), search(search), timer(timer), children(3) {}

int TernaryTree::printTimer() {
  std::queue<TernaryTree *> q;
  std::set<int> foundNumber;

  TernaryTree *root = this;
  q.push(root);
  foundNumber.insert(this->data);

  while (!q.empty()) {
    TernaryTree *current = q.front();
    q.pop();

    if (current->data == search) {
      return current->timer;
    }

    int next1 = current->data - 1;
    if (foundNumber.find(next1) == foundNumber.end()) {
      TernaryTree *child1 = new TernaryTree(next1, search, current->timer + 1);
      current->children.push_back(child1);
      q.push(child1);
      foundNumber.insert(next1);
    }

    int next2 = current->data * 2;
    if (foundNumber.find(next2) == foundNumber.end()) {
      TernaryTree *child2 = new TernaryTree(next2, search, current->timer + 1);
      current->children.push_back(child2);
      q.push(child2);
      foundNumber.insert(next2);
    }

    int next3 = current->data + 1;
    if (foundNumber.find(next3) == foundNumber.end()) {
      TernaryTree *child3 = new TernaryTree(next3, search, current->timer + 1);
      current->children.push_back(child3);
      q.push(child3);
      foundNumber.insert(next3);
    }
  }

  return -1;
}

int main() {
  int start;
  int search;
  std::cin >> start >> search;

  TernaryTree *root = new TernaryTree(start, search, 0);

  int timer = root->printTimer();
  std::cout << timer;
}