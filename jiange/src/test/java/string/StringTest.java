package string;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StringTest {

	public static void main(String[] args) {
//		String str = "TODO Auto-generated method stub";
//		System.out.println(str.intern());
//		System.out.println(str.substring(1, 3));
//		System.out.println(str.subSequence(1, 3));
//		StringBuffer sb = new StringBuffer(str);
//		sb.reverse();
//
//		System.out.println(sb.toString());

		BigDecimal poi = BigDecimal.valueOf(0).setScale(2, RoundingMode.HALF_UP);
		System.out.println(String.valueOf(poi));

		BigDecimal poi1 = BigDecimal.valueOf(1199.74).setScale(2, RoundingMode.HALF_UP);
		System.out.println(String.valueOf(poi1));
	}

}
