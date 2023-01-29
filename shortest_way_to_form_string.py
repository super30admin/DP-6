class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        
        ## approach 1: Two pointers
        ## T.C = O(m.n)
        ## S.C = O(1)

        hs = set(source)
        tp = 0
        sp = 0
        cnt = 0

        while tp < len(target):
            if target[tp] not in hs:
                return -1
            sp = 0
            while sp < len(source) and tp < len(target):
                if source[sp] == target[tp]:
                    tp += 1
                sp += 1
            
            cnt += 1

        return cnt