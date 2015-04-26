import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		HeteroAssociative memory = new HeteroAssociative();
		System.out.println("input x : ");
		int x = input.nextInt();
		System.out.println("input y : ");
		int y = input.nextInt();
		System.out.println("input the number of times : ");
		int n = input.nextInt();
		for (int i = 0; i < n; i++) {
			Matrix mat1 = new Matrix(1,x);
			Matrix mat2 = new Matrix(1,y);
			System.out.println("input the first vector : ");
			for(int k=0; k < x; ++k){
				mat1.setValue(0, k, input.nextDouble());				
			}
			System.out.println("input the second vector : ");
			for(int k=0; k < y; ++k){
				mat2.setValue(0, k, input.nextDouble());				
			}
			memory.calculateMemory(mat1, mat2);
		}
		while (true) {
			Matrix x0 = new Matrix(1,x);
			for(int k=0; k < x; ++k){
				x0.setValue(0, k, input.nextDouble());				
			}
			
				Matrix results[] = memory.recallWithX(x0);
				System.out.println("X values : ");
				Matrix m = results[0];
				for (int i = 0; i < m.getNumOfRows(); i++) {
					for (int j = 0; j < m.getNumOfColmn(); j++) {
						System.out.println(m.value(i, j) + " ");
					}
					System.out.println();
				}
				System.out.println("Y values : ");
				m = results[1];
				for (int i = 0; i < m.getNumOfRows(); i++) {
					for (int j = 0; j < m.getNumOfColmn(); j++) {
						System.out.println(m.value(i, j) + " ");
					}
					System.out.println();
				}
		}
	}

}
