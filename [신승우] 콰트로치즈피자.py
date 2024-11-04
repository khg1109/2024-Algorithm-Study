import sys

cnt = 0
topping_no = int(sys.stdin.readline().strip())    # 피자에 넣을 토핑 개수 입력
pizzaSet = sys.stdin.readline().strip().split()   # 공백을 두고 토핑 입력
pizzaSet = set(pizzaSet[:topping_no])             # 토핑 갯수만큼만 생성하고 세트형으로 중복된 문자열 제거

for topping in pizzaSet:
    if topping.endswith('Cheese'):                # pizzaSet 안의 요소의 문자열 끝에 'Cheese'가 있는지 판별
        cnt += 1                                  # 'Cheese'가 포함된 문자열을 발견할 때마다 카운트

print('yummy') if cnt >= 4 else print('sad')      # 치즈 토핑이 네 개 이상인지 판별

        
        
