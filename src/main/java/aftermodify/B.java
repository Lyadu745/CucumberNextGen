package aftermodify;



public class B extends A {
	B get() {
		return this;
	}
  void ms() {
		System.out.println("ABCD");

		}
	

	public static void main(String[] args)  {
		new A().get().ms();
		

	}
}
