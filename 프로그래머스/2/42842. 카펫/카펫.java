class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2]; //answer에 어떻게 넣지?
        
        int mul = brown + yellow; // row * col
        int sum = (mul + 4 - yellow) / 2; //row + col
        
        // row >= col 
        
        int col = 1;
        int row = mul;
        while (true) {
            if (mul % col != 0) {
                col++;
                continue;
            }
            
            row = mul / col;
            if (col + row == sum) {
                answer[0] = row;
                answer[1] = col;
                break;
            }
            
            col ++;
        }
        
        return answer;
    }
}