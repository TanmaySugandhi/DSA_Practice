class Solution {
    public long flowerGame(int n, int m) {
        double oddN = Math.ceil((double) n / 2);
        double oddM = Math.ceil((double) m / 2);
        return (long)((oddN * (m - oddM)) + (oddM * (n - oddN)));
    }
}