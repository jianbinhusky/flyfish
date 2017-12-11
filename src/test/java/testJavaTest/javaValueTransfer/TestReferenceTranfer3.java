package testJavaTest.javaValueTransfer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestReferenceTranfer3 {

	/**
	 * @param args
	 */
	
	public static void test(String str,StringBuffer strbuff,String strUseNew){
		str = "World";
		str = str + "dddd";
		strbuff.append(",hehe,xixi~");
		strUseNew = strUseNew + "Girl~";
	}
	
	public static void main(String[] args) {
		String string = "Hello";
		StringBuffer strbuff = new StringBuffer("haha");
		String stringUseNew = new String("Sunshine");
		String stringUseEqual = "Sunshine";
		test(string,strbuff,stringUseNew);
		log.info("string in main is "+string);
		log.info("strbuff in main is "+strbuff);
		log.info("stringUseNew in main is "+stringUseNew);
		log.info("stringUseNew hashcode is "+stringUseNew.hashCode());
		log.info("stringUseEqual hashcode is "+stringUseEqual.hashCode());
		log.info("equal() is "+(stringUseNew.equals(stringUseEqual)));
		log.info("== is "+(stringUseNew == stringUseEqual));
	}

}
