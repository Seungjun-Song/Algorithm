for _ in range(10):
    test = int(input())
    word = input()
    sentence = input()
    
    cnt = sentence.count(word)
        
    print('#{} {}'.format(test, cnt))