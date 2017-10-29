package string;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 找出字符串中的数字
 */
public class HasNumber {

	/**
	 * 输出字符串中的数字
	 * note: 用JAVA自带的函数: Character
	 */
	@Test
	public void test01() {
		String str = "2a";
		for (int i = 0; i < str.length(); i++){
		   if (Character.isDigit(str.charAt(i))){
			   System.out.println(str.charAt(i));
		   }
		}
	}
	
	/**
	 * 输出字符串中的数字
	 * note: 用正则表达式
	 */
	@Test
	public void test01_01() {
		String str1 = "2a";
		Pattern pattern1 = Pattern.compile("[0-9]*"); 
		Matcher isNum1 = pattern1.matcher(str1);
		System.out.println(isNum1.matches());
	}
	
	/**
	 * 输出字符串中的数字
	 * note: 用ACSII : 1==49  a==97
	 */
	@Test
	public void test01_02() {
		String str = "2a";
		for(int i=str.length();--i>=0;){  
		      int chr=str.charAt(i);  
		      if(chr<48 || chr>57) 
		    	  System.out.println(chr);
		   } 
	}
}
