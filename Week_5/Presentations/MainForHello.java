public class MainForHello {	
	public static void hiAndBye(HelloInterface h) {
		h.hello();
		h.goodbye();
	}
	public static void main(String[] args) {
		hiAndBye(new HelloWorld());
		hiAndBye(new HelloKitty("Mitsi"));
	}
}
