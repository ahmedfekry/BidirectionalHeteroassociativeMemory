
public class HeteroAssociative {

	private Matrix memory;
	public HeteroAssociative() {
		memory = null;
	}
	public void calculateMemory(Matrix x,Matrix y){
		x.transposeMatrix();
		Matrix result = new Matrix();
		result = Matrix.multiplyTwoMatrices(x, y);
		if (memory == null) {
			memory = result;
		}else{
			memory = Matrix.addTwoMatrices(memory, result);
		}
	}
	public Matrix[] recallWithX(Matrix x){
		x.transposeMatrix();
		Matrix y = Matrix.multiplyTwoMatrices(memory, x);
		x.transposeMatrix(); y.transposeMatrix(); y.Hebbsrule();
		Matrix previousX = null, previousY = null;
		while(true){
			if(previousX != null && (!previousX.equals(x) && !previousY.equals(y)))
				break;
			previousX = new Matrix(x);
			previousY = new Matrix(y);
			x = Matrix.multiplyTwoMatrices(y, memory);
			x.transposeMatrix();
			y = Matrix.multiplyTwoMatrices(memory, x);
			x.transposeMatrix();
			y.transposeMatrix();
			x.Hebbsrule();
			y.Hebbsrule();
		}
		return new Matrix[]{x,y};
	}
	
	public Matrix getMemeory(){
		return this.memory;
	}

}
