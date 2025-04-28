import re
from itertools import count
#https://education.yandex.ru/ege/task/105730a4-97f7-485b-a86a-76c11682aa85
text = open("C:\\Users\\ASUS\\Downloads\\24 (6).txt").read().strip()
palindroms = re.findall(r'(.)(.)(.)(\2)(\1)',text)
palindroms1 = []
print(len(palindroms))
for i in range(len(text) - 4):
    slice = text[i : i+5]
    if slice == slice[::-1]:
        palindroms1.append(slice)
counter = 0;
print(len(palindroms1))


