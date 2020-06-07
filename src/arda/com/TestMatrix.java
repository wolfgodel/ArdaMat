package arda.com;

import java.lang.reflect.Array;

public class TestMatrix {

	public static void main(String[] args) {
		
		double data1[][] = { {100,2,3},{4,5,6},{7,8,900}};
		Matrix mat1 = new Matrix(data1);
		mat1.print();
		System.out.println("------");
		double data2[] = {-1,-2,-3};
		Vector v1 = new Vector(data2, VectorOrientation.Vertical);
		
		mat1.insertVector(v1);
		mat1.print();
		
	
		System.out.println("------");
		double data3[] = {-1,-2,-3, -4};
		Vector v2 = new Vector(data3, VectorOrientation.Horizontal);
		mat1.insertVector(v2);
		mat1.print();
		
		
		
		double data6[][] = { {3,4,1},{1,2,2},{2,1,2}};
		double data7[] = {7,8,3};
		
		Matrix mat2 = new Matrix(data6);
		mat2.insertVector(new Vector(data7, VectorOrientation.Vertical));
		mat2.print();
		mat2.reduceToRowEchelonForm();
		mat2.print();
		
		/*
		System.out.println("------");
		double data4[][] = new double[10000][1000];
		double data5[][] = new double[1000][10000];
		
		for (int i = 0; i < data4.length; i++) {
			for (int j = 0; j < data4[0].length; j++) {
				data4[i][j] = Math.random();
			}
		}
		
		for (int i = 0; i < data5.length; i++) {
			for (int j = 0; j < data5[0].length; j++) {
				data5[i][j] = Math.random();
			}
		}
		Matrix a= new Matrix(data4);
		Matrix b = new Matrix(data5);
		
		long starTime = System.nanoTime();
		Matrix c = a.multipication(b); //Time elapsed=1502019
		long endTime = System.nanoTime();
		
		System.out.println("Time elapsed=" + (endTime-starTime)/1000000); 
		//a.print();
		//b.print();
		//c.print();
		
		*/
		 
	}

}
