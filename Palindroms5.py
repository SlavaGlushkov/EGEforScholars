import re
from itertools import count

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


