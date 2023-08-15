public int nthUglyNumber(int n) {
        TreeSet<Long> st = new TreeSet<>();
        st.add((long)1);
        int cnt = 0;
        long ans = 1;
        for(;cnt != n;){
            long ugly = st.pollFirst();
            ans = ugly;
            ++cnt;
            st.add(2 * ugly);
            st.add(3 * ugly);
            st.add(5 * ugly);
        }
        return (int)ans;
    }
