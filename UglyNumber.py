class Solution:
    def nthUglyNumber(self, n: int) -> int:
        p2=0 # Pointer for digit 2
        p3=0 # Pointer for digit 3
        p5=0 # Pointer for digit 5
        
        n2=2
        n3=3
        n5=5
        
        arr = [0 for i in range(n)] #creating an empty array

        arr[0] =1
        for i in range(1, n):
            ## calculate n2, n3 and n5 and take the min among them and add that to arr array. Then compare the minimum with n2, n3 and n5 whichever is minimum increase that pointer by 1.
            arr[i] = min(n2,min(n3,n5)) 
            # print(arr[i])
            if arr[i]==n2: 
                p2+=1 
                n2 = arr[p2]*2
            if arr[i]==n3:
                p3+=1
                n3 = arr[p3]*3
            if arr[i]==n5:
                p5+=1
                n5 = arr[p5]*5
        #returning the last element
        return arr[-1]
            