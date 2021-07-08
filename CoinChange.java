package com.balazsholczer.udemy;

public class CoinChange {

	// recursive coin change EXPONENTIAL RUNNING TIME O(2^N)
	public int naiveCoinChange(int M, int[] v, int index) {
		
		if( M < 0 ) return 0;
		if( M == 0 ) return 1;
		
		if( v.length == index ) return 0;
		
		return naiveCoinChange(M-v[index], v, index) + naiveCoinChange(M, v, index+1);
	}
	
	public void dynamicProgrammingCoinChange(int[] coins, int amount) {
		
		int[][] dpTable = new int[coins.length+1][amount+1];
		
		for(int i=0;i<=coins.length;i++)
			dpTable[i][0] = 1;
		
		for(int i=1;i<=amount;i++)
			dpTable[0][i] = 0;
		
		// O(v*M)
		for(int i=1;i<=coins.length;i++) {
			for(int j=1;j<=amount;j++) {
				
				if( coins[i-1] <= j ) {
					dpTable[i][j] = dpTable[i-1][j] + dpTable[i][j-coins[i-1]];
				} else {
					dpTable[i][j] = dpTable[i-1][j];
				}
			}
		}

		System.out.println("Solution: " + dpTable[coins.length][amount]);
	}
	public long count(int S[], int m, int n) 
    { 
        //code here.
        
        if(m <= 0) return 0;
        if(n == 0) return 1;
        
        long[][] dp = new long[m+1][n+1];
        
        for(int i = 0; i <= m; i++){
            dp[i][0] = 1;
        }
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                
                if(S[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - S[i-1]];
                    
                }
            }
        }
        
        return dp[m][n];
    } 
}
