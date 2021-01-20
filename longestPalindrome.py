arr = "abccdd"
pal = list()
count = 0
if arr is None or len(arr)==0:
    print("0")
for i in range(len(arr)):
    if arr[i] not in pal:
        pal.append(arr[i])
    else:
        pal.remove(arr[i])
        count = count+2
print(count)



