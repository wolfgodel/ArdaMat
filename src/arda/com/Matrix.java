package arda.com;

public class Matrix {
	
	int rowNum, colNum;
	double data[][];
	
	public Matrix(int rowNum, int colNum) {
		data = new double[rowNum][colNum];
		this.rowNum = rowNum;
		this.colNum = colNum;
	}
	
	public Matrix(double data[][]) {
		
		this.rowNum = data.length;
		this.colNum = data[0].length;
		
		this.data = new double[rowNum][colNum];
		
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				this.data[i][j] = data[i][j];
			}
		}
		
	}
	
	// 1   	2 	 	1 	    2 	2
	// 0   	1      18	 	9 	6
	// 0   	4    	6  		8 	10
	
	
	public void reduceToRowEchelonForm() {
		System.out.println("----");
		print();
		for(int k=0; k<rowNum; k++) {
			
			double val = data[k][k]; // k=1
			
			
			for(int j=0; j<colNum;j++) {
				data[k][j] /= val;
			}
			
			for(int r=0; r<rowNum;r++) { //r=0
				if(r!=k) {
					val =data[r][k];
					for(int c=k; c<colNum; c++) { //c=1, 
						data[r][c] = data[r][c] - val * data[k][c];
					}
					
				}
			}
		}

	}
	
	public void print() {
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				System.out.printf("%10.1f", this.data[i][j] );
				
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public int getRowNum() {
		return rowNum;
	}

	public int getColNum() {
		return colNum;
	}

	public Matrix multiply(Matrix v) {
		
		if(this.colNum!=v.rowNum) {
			System.out.print("Error. Column number of first matrix and row number of");
			System.out.print(" second matrix do not match.");
			return null;
		}
		//    		[1]
		//[1 2 3 ] 	[2]  = [14] 
		//			[3]
		//rowNum ve colNum int olunca array double değer istedğinden sıkıntı çıkıyor.
		
		double newData[][] = new double[this.rowNum][v.colNum];
		
		
		for(int i=0;i<this.rowNum;i++) {
			
			for (int j = 0; j < v.colNum; j++) {
				int top=0;
				
				for (int k = 0; k <this.colNum;k++) {
					top+=this.data[i][k]*v.data[k][j];
				}
				
				newData[i][j]=top;
			}
			
			
		}
		
		return new Matrix(newData);
	}
	
	public boolean insertVector(Vector v) {
		
		if (v.getOrientation() == VectorOrientation.Vertical) {
			
			if(this.rowNum!=v.length()) {
				System.out.println("Row numbers are not matched.");
				return false;
			}
			
			double newData[][] = new double[rowNum][colNum+1];
			
			for (int i = 0; i < rowNum; i++) {
				for (int j = 0; j < colNum; j++) {
					newData[i][j] = data[i][j];
				}
			}
			
			colNum++;
			
			for (int i = 0; i < v.length(); i++) {
				newData[i][colNum-1] = v.valueAt(i);
			}
			
			
			this.data = newData;
			return true;
		}
		else {
			if(this.colNum!=v.length()) {
				System.out.println("Column numbers are not matched.");
				return false;
			}
			
			double newData[][] = new double[rowNum+1][colNum];
			
			for (int i = 0; i < rowNum; i++) {
				for (int j = 0; j < colNum; j++) {
					newData[i][j] = data[i][j];
				}
			}
			
			rowNum++;
			
			for (int i = 0; i < v.length(); i++) {
				newData[rowNum-1][i] = v.valueAt(i);
			}
			
			this.data = newData;
			return true;
		}
		
	}
	
	//sum
	
	//subtract
	
	//partition
	
	//multiplyNaive
	
	//stressen
}
