from collections import deque
def solution(cacheSize, cities):
    answer = 0
    cities = [i.lower() for i in cities]
    cache = []
    if cacheSize == 0:
        return len(cities) * 5
    for city in cities:
        if city in cache:
            answer += 1
            cache.append(cache.pop(cache.index(city)))
        else:
            answer += 5
            if len(cache) < cacheSize:
                cache.append(city)
            else:
                
                cache.pop(0)
                cache.append(city)
            
    return answer