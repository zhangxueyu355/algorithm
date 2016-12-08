// 测试类
public class TestDemo {
	
	public static void main(String args[]){
		Goods[] bags = new Goods[]{new Goods(2,6),new Goods(2,3),new Goods(6,5),
				new Goods(5,4),new Goods(4,6)};
		int totalWeight = 12;
		DymanicProgramming dyProgramming = new DymanicProgramming(bags, totalWeight);
		//数字规模太小，暂时就不计算算法时间啦，等以后再补充扒
		dyProgramming.solve();
		System.out.println(dyProgramming.getBestValue());
	}
}
