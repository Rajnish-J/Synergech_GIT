package StringAssn;

public class StudentManager {
	public static void main(String[] args) {
		Student s = new Student();
		s.setStudentId(10);
		Student s1 = new Student();
		s.setStudentId(10);

		System.out.println("message 1 =>" + s.equals(s1));

		System.out.println("message 2 =>" + s.hashCode());

		System.out.println("message 3 =>" + s1.hashCode());

		System.out.println("message 4 =>" + (s == s1));

		Student s2 = new Student();
		s.setStudentId(100);
		Student s3 = new Student();
		s.setStudentId(101);

		System.out.println("message 5 =>" + s2.equals(s3));

		System.out.println("message 6 =>" + s2.hashCode());

		System.out.println("message 7 =>" + s3.hashCode());

		System.out.println("message 8 =>" + (s2 == s3));
	}
}
