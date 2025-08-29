class Solution {
    List<String> result = new ArrayList<>();
    String[] digitToLetters = {
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };
    private void backtrack(String digits, int index, StringBuilder current) {
        if(index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters = digitToLetters[digits.charAt(index) - '2'];
        for(char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(digits, index + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 )
            return result;
        backtrack(digits, 0, new StringBuilder());
        return result;       
    }
}