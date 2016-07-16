package t;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TT {
	public static void main(String[] args) {
		BCryptPasswordEncoder t = new BCryptPasswordEncoder();
		System.out.println(t.encode("123456"));
	}
}
