#include <iostream>
#include <queue>
#include <vector>

class TernaryTree {
  int data;
  int search;
  int timer;

public:
  TernaryTree();
  TernaryTree(int data, int search, int timer);

  int printTimer();
};

TernaryTree::TernaryTree(int data, int search, int timer) : data(data), search(search), timer(timer) {}

int TernaryTree::printTimer() {
  std::queue<TernaryTree *> q;
  std::vector<bool> foundNumber(100001, false);

  TernaryTree *root = this;
  q.push(root);
  foundNumber[this->data] = true;

  if (this->data > search) {
    return this->data - search;
  }

  while (!q.empty()) {
    TernaryTree *current = q.front();
    q.pop();

    if (current->data == search) {
      return current->timer;
    }

    int next1 = current->data - 1;
    if (next1 >= 0 && next1 <= 100000 && foundNumber[next1] == false) {
      TernaryTree *child1 = new TernaryTree(next1, search, current->timer + 1);
      q.push(child1);
      foundNumber[next1] = true;
    }

    int next2 = current->data * 2;
    if (next2 >= 0 && next2 <= 100000 && foundNumber[next2] == false) {
      TernaryTree *child2 = new TernaryTree(next2, search, current->timer + 1);
      q.push(child2);
      foundNumber[next2] = true;
    }

    int next3 = current->data + 1;
    if (next3 >= 0 && next3 <= 100000 && foundNumber[next3] == false) {
      TernaryTree *child3 = new TernaryTree(next3, search, current->timer + 1);
      q.push(child3);
      foundNumber[next3] = true;
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