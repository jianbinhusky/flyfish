package string;

public class PasswordUtil {
	
	/**
	 * 密码强度
	 *       弱：小于8位/纯数字/纯大写或小写字母
	 *       中：8-20位，包含数字、字母、特殊符号中的两种
	 *       强：8-20位，同时包含 数字、字母、特殊符号
	 * @param password
	 * @return
	 *        weak:弱
	 *        middle:中等
	 *        strong:强
	 *        unkown:未知
	 */
	public static String strength(String password) {
		if(null == password || password.length() <= 0) return UNKOWN;
		if(password.length() < 8 || password.matches(WEAK_PARTTEN)) return WEAK;
		if(password.matches(SRRONG_PARTTEN)) return STRONG;
		//既不是强、也不是弱，那就是中等强度
		return MIDDLE;
	}
	private static final String WEAK_PARTTEN = "(^\\d*$)|(^[a-z]*$)|(^[A-Z]*$)";
	private static final String SRRONG_PARTTEN = "^((?=.*[\\d].*)(?=.*[a-zA-Z].*)(?=.*[^\\da-zA-Z].*)).{8,20}";
	
	private static final String WEAK = "weak";
	private static final String MIDDLE = "middle";
	private static final String STRONG = "strong";
	private static final String UNKOWN = "unkown";
	
	public static void main(String[] args) {
		//弱
		String pwd1 = "!QAZ"; 
		String pwd2 = "1111111111";  
		String pwd3 = "aaaaaaaaaa";
		String pwd4 = "BBBBBBBBBB";
		
		//中
		String pwd5 = "1111111a";
		String pwd6 = "aaaaaaBB";
		String pwd7 = "aa~aaaaa";
		String pwd8 = "11aaaaa11";
		String pwd9 = "aa11111a";
		String pwd10 = "~111111~";
		String pwd11 = "111~1111";
		
		//强
		String pwd12 = "~1qazqaz";
		String pwd13 = "a~1111111";
		String pwd14 = "1a111111~~!";
		
//		System.out.println("pwd1.strength=" + PasswordUtil.strength(pwd1));
//		System.out.println("pwd2.strength=" + PasswordUtil.strength(pwd2));
//		System.out.println("pwd3.strength=" + PasswordUtil.strength(pwd3));
//		System.out.println("pwd4.strength=" + PasswordUtil.strength(pwd4));
//		System.out.println("pwd5.strength=" + PasswordUtil.strength(pwd5));
//		System.out.println("pwd6.strength=" + PasswordUtil.strength(pwd6));
//		System.out.println("pwd7.strength=" + PasswordUtil.strength(pwd7));
//		System.out.println("pwd8.strength=" + PasswordUtil.strength(pwd8));
//		System.out.println("pwd9.strength=" + PasswordUtil.strength(pwd9));
//		System.out.println("pwd10.strength=" + PasswordUtil.strength(pwd10));
//		System.out.println("pwd11.strength=" + PasswordUtil.strength(pwd11));
//		System.out.println("pwd12.strength=" + PasswordUtil.strength(pwd12));
//		System.out.println("pwd13.strength=" + PasswordUtil.strength(pwd13));
//		System.out.println("pwd14.strength=" + PasswordUtil.strength(pwd14));
//
//		System.out.println("1q2w3e4r5t6y7u8i9o0pz = " +PasswordUtil.strength("1q2w3e4r5t6y7u8i9o0pz"));
//		System.out.println("1q2w3e4r5t6y7u8i9o0pz".length());


		String ours = "(?!^(\\d+|[a-zA-Z]+|[~!@#$%^&*?\\.>\\-\\=\\+<\\(\\),\\[\\];:/]+)$)^[\\w~!@#$%^&*?\\.>\\-\\=\\+<\\(\\),\\[\\];:/]{8,20}$";
		//8-20 &
//		System.out.println("1 " +pwd1 + "=" +pwd1.matches(ours));
//		System.out.println("2 " +pwd2 + "=" +pwd2.matches(ours));
//		System.out.println("3 " +pwd3 + "=" +pwd3.matches(ours));
//		System.out.println("4 " +pwd4 + "=" +pwd4.matches(ours));
//		System.out.println("5 " +pwd5 + "=" +pwd5.matches(ours));
//		System.out.println("6 " +pwd6 + "=" +pwd6.matches(ours));
//		System.out.println("7 " +pwd7 + "=" +pwd7.matches(ours));
//		System.out.println("8 " +pwd8 + "=" +pwd8.matches(ours));
//		System.out.println("9 " +pwd9 + "=" +pwd9.matches(ours));

		System.out.println("12#$ab = " + "12#$ab".matches(ours));
		System.out.println("1q2w3e4r5t6y7u8i9o0pz = " +"1q2w3e4r5t6y7u8i9o0pz".matches(ours));
		System.out.println("12345678 = " + "12345678".matches(ours));
		System.out.println("asdfghDBTs = " + "asdfghDBTs".matches(ours));
		System.out.println("~!@#$%^&* = " + "~!@#$%^&*".matches(ours));
		System.out.println();
		System.out.println("1234qweR = " + "1234qweR".matches(ours));
		System.out.println("1234!@#$%* = " + "1234!@#$%*".matches(ours));
		System.out.println("qweR#%^$#*! = " + "qweR#%^$#*!".matches(ours));
		System.out.println("1234Qwer!*#% = " + "1234Qwer!*#%".matches(ours));

		System.out.println();
		System.out.println("1234qweR = " + PasswordUtil.strength("1234qweR"));
		System.out.println("1234!@#$%* = " + PasswordUtil.strength("1234!@#$%*"));
		System.out.println("qweR#%^$#*! = " + PasswordUtil.strength("qweR#%^$#*!"));
		System.out.println("1234Qwer!*#% = " + PasswordUtil.strength("1234Qwer!*#%"));
	}
	
}
