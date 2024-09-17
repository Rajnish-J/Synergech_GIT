package MethodReferences;

public class JavaMethodReference {

//	=> method reference
//	public void sayHello() {
//		System.out.println("Hello");
//	}

//	=> static reference:
//	public static void sayHello() {
//		System.out.println("Say hello static");
//	}

//	=> constructor reference:
	public JavaMethodReference() {
		System.out.println("Say hello constructor");
	}

	public static void main(String[] args) {
		JavaMethodReference ref = new JavaMethodReference();

//		=> method reference
//		JavaMethodReference ref = new JavaMethodReference();
//		=> output: Hello

//		=> static method reference
//		Say say = JavaMethodReference::sayHello;
//		=> output: Say hello static

//		=> constructor reference
		Say say = JavaMethodReference::new;
		say.wish();
//		output: Say hello constructor
	}
}
