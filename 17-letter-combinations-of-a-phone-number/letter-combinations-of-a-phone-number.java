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
    private void backtrack(String digits, int index, String current_combination){
        if(index == digits.length()){
            result.add(current_combination);
            return;
        }
        char digit = digits.charAt(index);
        String letters = digitToLetters[digit - '2'];
        for (char letter : letters.toCharArray())
            backtrack(digits, index + 1, current_combination + letter);
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 )
            return result;
        backtrack(digits, 0, "");
        return result;       
    }
}