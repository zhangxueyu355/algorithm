
public class DymanicProgramming {
	private Goods [] bags ;//物品的集合（数组表示）
	private int n;//物品数量
	private int totalWeight;//背包总重
	private int[][] bestValues;//二位数组中的每一步的最优解
	private int bestValue;//最优解
	
	public DymanicProgramming(Goods[] bags,int totalWeight){
		this.bags = bags;
		this.totalWeight = totalWeight;
		this.n = bags.length;
		if(bestValues == null){
			//防止数组角标越界
		   bestValues = new int[n + 1][totalWeight + 1];
		}
	}
	
	public void solve(){
		//遍历背包的承重
		for(int j=0;j<=totalWeight;j++){
			//遍历指定物品
			for(int i = 0;i <= n;i++){
				//如果背包中没有物品 或者承重为0
				if(i == 0||j == 0){
					bestValues[i][j] = 0;
				}else{
					//如果第i个物品的重量大于总的承重，则最优解存在于前i-1个背包中
					if (j < bags[i - 1].getWeight()){
						bestValues[i][j] = bestValues[i - 1][j];
					}else{
						//如果第I个物品重量大于总承重，则最优解要么是包含第i个背包的最优解，
						//要么是不包含第i个背包的最优解，取两者最大值
						int weight = bags[i - 1].getWeight();
						int value = bags[i -1].getValue();
						bestValues[i][j] = Math.max(bestValues[i - 1][j], value + bestValues[i - 1][j - weight]);
					}
				}
			}				
		}
		bestValue = bestValues[n][totalWeight];
	}
	public int getBestValue(){
		return bestValue;
	}
}
