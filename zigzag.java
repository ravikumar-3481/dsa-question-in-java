class zigzag {
    public String zigzagConversion(String s, int numRow) {
        if (numRow == 1 || numRow >= s.length()) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRow];
        for (int i = 0; i < numRow; i++) {
            rows[i] = new StringBuilder() ;
        }
        
        int curr_row = 0 ;
        int direction = -1 ;

        for (char c : s.toCharArray()) {
            rows[curr_row].append(c) ;

            if (curr_row == 0) {
                direction = 1 ;
            } else if (curr_row == numRow - 1){ 
                direction = -1 ;
            }
            curr_row += direction ;
        } 

        StringBuilder result = new StringBuilder() ;
        for (StringBuilder row : rows) {
            result.append(row) ;
        }

        return result.toString() ;
   } 


   public static void main(String[] args) {
    String b = "PAYPALISHIRING" ;
    System.out.println(new zigzag().zigzagConversion(b, 4)) ;
   }
}