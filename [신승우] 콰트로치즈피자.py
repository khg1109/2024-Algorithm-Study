cnt = 0
#print('토핑갯수를 입력하세요')
topping_n = int(input())    #피자에 넣을 토핑 개수
pizza = input().split()   # 공백을 두고 토핑 입력
pizza = pizza[:topping_n]     # 토핑 갯수만큼만 입력을 받음
pizza = set(pizza)  # 세트를 통해 중복을 제거

for topping in pizza:
    if topping.endswith('Cheese'):
        cnt += 1    # 'Cheese'가 포함된 문자열을 발견할 때마다 카운트

if cnt >= 4:    # 치즈 토핑이 네 개 이상이면 콰트로치즈피자
    print('yummy')
else:
    print('sad')
        
        
