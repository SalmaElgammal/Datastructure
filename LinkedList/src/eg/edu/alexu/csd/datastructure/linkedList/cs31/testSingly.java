package eg.edu.alexu.csd.datastructure.linkedList.cs31;

public class testSingly {

	public static void main(String[] args) {
		Singly list=new Singly();
//		list.add(5);
//		System.out.print(list.get(0)+" ");

		for(int i=0;i<5;i++) {
			list.add(i+1);
			for(int j=0;j<list.size();j++) {
				System.out.print(list.get(j)+" ");
			}
			System.out.println();
		}
		list.add(2, 10);
		list.remove(4);
		for(int j=0;j<list.size();j++) {
			System.out.print(list.get(j)+" ");
		}

	}

}
