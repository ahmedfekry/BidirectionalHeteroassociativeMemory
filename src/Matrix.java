
public class Matrix {
	private double matrix[][];
	
	public Matrix() {
		// TODO Auto-generated constructor stub
	}
	public Matrix(Matrix m){
		matrix = new double[m.getNumOfRows()][m.getNumOfColmn()];
		for (int i = 0; i < m.getNumOfRows(); i++) {
			for (int j = 0; j < m.getNumOfColmn(); j++) {
				matrix[i][j] = m.value(i, j);
			}
		}
	}
	
	public Matrix(double mat[][]){
		matrix = new double[mat.length][mat[0].length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				matrix[i][j] = mat[i][j];
			}
		}
	}
	
	public Matrix(int rows,int columns){
		this.matrix = new double[rows][columns];
	}
	
	public static Matrix addTwoMatrices(Matrix matrix1,Matrix matrix2){
		if(matrix1.getNumOfRows() != matrix2.getNumOfRows() || matrix1.getNumOfColmn() != matrix2.getNumOfColmn()){
			System.out.println("cann't add");		
			return null;
		}
		
		Matrix result = new Matrix(matrix1.getNumOfRows(),matrix2.getNumOfColmn());
		for (int i = 0; i < matrix1.getNumOfRows(); i++) {
			for (int j = 0; j < matrix2.getNumOfColmn(); j++) {
				double x = matrix1.value(i, j) + matrix2.value(i, j);
				result.setValue(i, j, x);
			}
		}	
		return result;
	}
	
	public static Matrix multiplyTwoMatrices(Matrix matrix1,Matrix matrix2){
		
		if(matrix1.getNumOfColmn() != matrix2.getNumOfRows()){
			System.out.println("cannot multiply");
			return null;
		}
		
		Matrix result = new Matrix(matrix1.getNumOfRows(),matrix2.getNumOfColmn());
		for (int i = 0; i < result.getNumOfRows(); i++) {
			for (int j = 0; j < result.getNumOfColmn(); j++) {
				double sum = 0.0;
				for (int k = 0; k < result.getNumOfColmn(); k++) {
					sum += matrix1.value(i, k)*matrix2.value(k, j);
				}
				result.setValue(i, j, sum);
			}
		}
		return result;
	}
	
	public void transposeMatrix(){
		double result[][] = new double[getNumOfRows()][getNumOfColmn()];
		for (int i = 0; i<getNumOfRows(); i++)
			   for (int j = 0; j<getNumOfColmn(); j++)
			     result[j][i] = matrix[i][j];
		matrix=result;
	}
	public boolean equals(Matrix m){
		for(int i = 0 ; i < getNumOfRows(); ++i){
			for(int j = 0 ; j < getNumOfColmn(); ++j){
				if(matrix[i][j] != m.value(i, j))
					return false;
			}
		}
		return true;
	}
	
	public void Hebbsrule(){
		for(int i = 0 ; i < matrix.length; ++i){
			for(int j = 0 ; j < matrix[i].length; ++j){
				if(matrix[i][j] > 0)matrix[i][j] = 1;
				if(matrix[i][j] < 0)matrix[i][j] = -1;
			}
		}
	}
	
	public void setValue(int i,int j,double v){
		matrix[i][j] = v;
	}
	public int getNumOfRows(){
		return this.matrix.length;
	}
	public int getNumOfColmn(){
		return this.matrix[0].length;
	}
	public double value(int r,int c){
		return matrix[r][c];
	}


}
