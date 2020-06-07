package arda.com;

public class Test {

	public static void main(String[] args) throws Exception {
		
		int a=5;
		
		
		double data1[] = {1,2,3,4,5,6,7,8};
		double data2[] = {10,11,12,13,14,15,16,17,18,19};
		
		Vector v1 =  new Vector(data1, VectorOrientation.Horizontal);
		Vector v2 =  new Vector(data2, VectorOrientation.Vertical);
		System.out.print("V1:");
		v1.print();
		Vector v1T = v1.transpose();
		System.out.print("V1-T:");
		v1T.print();
		System.out.print("V2:");
		v2.print();
		
		Vector v2Kopya = new Vector(v2);
		
		System.out.print("V2-Kop:");
		v2Kopya.print();
		
		System.out.println();
		Vector topVek, top1Vek;
		System.out.print("V1+V2-Kop=");
		topVek = v1.sumGeneral(v2Kopya);
		
		if (topVek != null)
			topVek.print();
			
		System.out.println();
		System.out.print("V2+V2-Kop=");
		top1Vek = v2.sumGeneral2(v2Kopya);
			
		if (top1Vek != null)
			top1Vek.print();
		
		System.out.println();
		v2.scalar(5, '*');
		v2.print();
		
		System.out.print("V1*V1-T=");
		v1.multiply(v1T).print();
		
		double data3[] = {1,2,-1, 10,4,6,12,-3};
		Vector v3 = new Vector(data3, VectorOrientation.Vertical);
		v2.print();
		v3.print();
		v3.elementWise(v2, '+').print();
		v3.elementWise(v2, '-').print();
		v3.elementWise(v2, '*').print();
		v3.elementWise(v2, '/').print();
	}

}
