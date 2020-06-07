package arda.com;

public class Vector {
	
	//Attribute
	private VectorOrientation orientation;
	private double data[];
	
	//Methods
	public Vector() {
		data = new double[1];
		orientation =  VectorOrientation.Horizontal;
	}
	
	public Vector(int n, VectorOrientation orientation) {
		data = new double[n];
		this.orientation =  orientation;
	}
	
	public Vector(int n, VectorOrientation orientation, double value) {
		data = new double[n];
		for(int i=0; i<n; i++) {
			data[i]=value;
		}
		
		this.orientation =  orientation;
	}
	
	public Vector(double d[], VectorOrientation orientation) {
		data = new double[d.length];
		for(int i=0; i<d.length; i++) {
			data[i]=d[i];
		}
		
		this.orientation =  orientation;
	}
	
	public Vector(Vector vector) {
		
		data = new double[vector.length()];
		for(int i=0; i<vector.length(); i++) {
			data[i]=vector.valueAt(i);
		}
		
		this.orientation =vector.getOrientation();
	}
	
	public Vector multiply(Vector vector) {
		
		if(this.orientation!=VectorOrientation.Horizontal) {
			System.out.print("Baslangic vektoru Horizontal vektor degil.");
			return null;
		}
		
		if(vector.orientation!=VectorOrientation.Vertical) {
			System.out.print("Ikinci vektor Vertical degil.");
			return null;
		}
		
		if(vector.length()!=this.length()) {
			System.out.print("Vektorlerin lengthlari esit degil.");
			return null;
		}
		
		double multArray[] = new double[1];
		
		for(int i=0; i<this.length(); i++) {
			multArray[0]+=this.data[i]*vector.data[i];
		}
		
		
		Vector mult = new Vector(multArray, VectorOrientation.Horizontal);
		
		return mult;
	}
	
	public Vector sumGeneral(Vector v) {
		
		if(this.orientation!=v.getOrientation()) {
			System.out.print("Yönelim uyuşmazlığı");
			return null;
		}
	
		double top[];
				
		if(v.length()<data.length) {
			top = new double[data.length];
			for(int i=0;i<v.length();i++) {
				top[i]=v.data[i]+data[i];
			}
			
			for(int i=v.length();i<data.length;i++) {
				top[i]=data[i];
			}
		}
		else{
			
			top= new double[v.length()];
			
			for(int i=0;i<data.length;i++) {
				top[i]=v.data[i]+data[i];
			}
			for(int i=data.length;i<v.length();i++) {
				top[i]=v.data[i];
			}
			
		}
		
		Vector toplam = new Vector(top,v.orientation);
		
		return toplam;
	}
	
	public Vector sumGeneral2(Vector v) {
		
		if(this.orientation!=v.getOrientation()) {
			System.out.print("Yönelim uyuşmazlığı");
			return null;
		}
		
		Vector uzun, kisa;
		
		if(v.length()<=data.length) {
			uzun = this;
			kisa = v;
		}
		else {
			uzun = v;
			kisa = this;
		}

	
		double top[]; // = DoubleArray top
		
	
		top = new double[uzun.length()];
		
		for(int i=0;i<kisa.length();i++) {
			top[i]=kisa.data[i]+uzun.data[i];
		}
		
		for(int i=kisa.length();i<uzun.length();i++) {
			top[i]=uzun.data[i];
		}
	
	
		Vector toplam = new Vector(top,uzun.orientation);
		
		return toplam;
	}

	public Vector sumGeneral3(Vector v) {
		return this.elementWise(v, '+');
	}
	
	public Vector elementWise(Vector v, char op) {
		
		if(this.orientation!=v.getOrientation()) {
			System.out.print("Yönelim uyuşmazlığı");
			return null;
		}
		
		Vector uzun, kisa;
		
		if(v.length()<=data.length) {
			uzun = this;
			kisa = v;
		}
		else {
			uzun = v;
			kisa = this;
		}

		double top[]; // = DoubleArray top
	
		top = new double[uzun.length()];
		
		for(int i=0;i<kisa.length();i++) {
			
			switch(op) {
				case '+':
					top[i]=this.data[i]+v.data[i];
					break;
				case '-':
					top[i]=this.data[i]-v.data[i];
					break;
				case '*':
					top[i]=this.data[i]*v.data[i];
					break;
				case '/':
					top[i]=this.data[i]/v.data[i];
					break;
				default:
					System.out.println("Hatalı işlem operatörü.Op:" + op);
					return null;
			}
		}
		
		for(int i=kisa.length();i<uzun.length();i++) {
			top[i]=uzun.data[i];
		}
	
	
		Vector toplam = new Vector(top,uzun.orientation);
		
		return toplam;
		
	}
	
	public Vector sumEqualLengts(Vector v) {
		
		if(this.orientation!=v.getOrientation()) {
			System.out.print("Yönelim uyuşmazlığı");
			return null;
		}
		
		//1, 2, 3, 4, 5 ,7 , 8, 9, 10
		//5, 8, 9
		//6, 10, 12, 4, 5 ,7, 8, 9, 10
		
		double top[] = new double[v.length()];
		
		for(int i=0; i<top.length; i++){
			top[i]=v.valueAt(i)+this.data[i];
		}
		
		return new Vector(top,v.getOrientation());
	}
	
	public void scalar(double s, char op) {
		
		for (int i = 0; i < data.length; i++) {
			
			switch(op) {
				case '+':
					this.data[i]+=s;
					break;
				case '-':
					this.data[i]-=s;
					break;
				case '*':
					this.data[i]*=s;
					break;
				case '/':
					this.data[i]/=s;
					break;
				default:
					System.out.println("Hatalı işlem operatörü.Op:" + op);
					return;
			}
		}
		
				
	}

	public void print() {
		if(orientation==VectorOrientation.Vertical) {
			System.out.print("V[");
		}
		else {
			System.out.print("H[");
		}
		
		
		for(int i=0; i<data.length-1; i++) {
			System.out.print(data[i] + ",");
		}
		System.out.print(data[data.length-1]);
		
		System.out.println("]");
		System.out.println();
	}

	public VectorOrientation getOrientation() {
		return orientation;
	}

	public void makeHorizontal() {
		this.orientation = VectorOrientation.Horizontal;
	}
	
	public void VerticalYap() {
		this.orientation = VectorOrientation.Vertical;
	}
	
	public Vector transpose(){
		
		VectorOrientation transpozorientation;
		if(orientation==VectorOrientation.Vertical) {
			transpozorientation=VectorOrientation.Horizontal;
		}
		else {
			transpozorientation=VectorOrientation.Vertical;
		}

		return new Vector( data, transpozorientation);
				
	}
	
	public int length() {
		return data.length;
	}
	
	public double valueAt(int konum) {
		return data[konum];
	}
	
	
}

