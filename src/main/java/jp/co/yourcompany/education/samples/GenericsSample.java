package jp.co.yourcompany.education.samples;

public class GenericsSample<T1, T2> {

	private T1 obj1;
	private T2 obj2;


	public GenericsSample( T1 obj1 , T2 obj2){
		this.obj1 = obj1;
		this.obj2 = obj2;
	}


	public T1 get1() {
		return obj1;
	}

	public void set1(T1 obj1) {
		this.obj1 = obj1;
	}

	public T2 get2() {
		return obj2;
	}

	public void set2(T2 obj2) {
		this.obj2 = obj2;
	}

	public static final void main (String args[] ){

		GenericsSample<BoxOnly , String> gs1 =
					new GenericsSample<BoxOnly , String>( new BoxOnly() , new String("abc") );
		GenericsSample<Integer , String> gs2 =
					new GenericsSample<Integer , String>( new Integer(1) , new String("ABC") );
		GenericsSample<String , Exception> gs3 =
					new GenericsSample<String , Exception>( new String("01") , new  Exception() );
	}
}

