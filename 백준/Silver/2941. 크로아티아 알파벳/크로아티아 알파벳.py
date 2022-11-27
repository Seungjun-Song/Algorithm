dic = {}
dic['c='] = 'č'
dic['c-'] = 'ć'
dic['dz='] = 'dž'
dic['d-'] = 'đ'
dic['lj'] = 'lj'
dic['nj'] = 'nj'
dic['s='] = 'š'
dic['z='] = 'ž'

s = input()

for k in dic.keys():
    s = s.replace(k, "0")

print(len(s))