import sys
def main():
    #print('토핑을 입력하세요')
    topping_no = int(sys.stdin.readline().strip())
    pizzaSet = sys.stdin.readline().split()
    cheeseSet = set()
    for i in range(topping_no):
        if pizzaSet[i].endswith("Cheese"):
            cheeseSet.add(pizzaSet[i])
        if len(cheeseSet) == 4:
            print(cheeseSet)
            print("yummy")
            return
    print("sad")
main()

        
        
