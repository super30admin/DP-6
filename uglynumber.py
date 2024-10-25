def nthUglyNumber(self, n: int) -> int:
    # time complexity : O(n)
    # space complexity: O(n)
    arr = [0] * n
    arr[0] = 1
    p2,p3,p5 = 0,0,0
    n2,n3,n5 = 2,3,5

    for i in range(1,n):
        # update minimum of the 3 numbers
        mini = min(n2,min(n3,n5))
        arr[i] = mini

        # update the pointer of the minimum found by 1 and find factor at that place
        if n2 == mini:
            p2+=1
            n2 = arr[p2] * 2

        if n3 == mini:
            p3+=1
            n3 = arr[p3] * 3
        if n5 == mini:
            p5+=1
            n5 = arr[p5] *5
        
    return arr[n-1]

