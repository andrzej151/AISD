package Testy;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;



public class ExegeTest {

	
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		Exege e = new Exege();
		Integer [] tab = {1,2,3,4,5};
		Integer [] tab2 = {1,4,3,5,5};
		tab = e.exchange(tab,1,3);
		Assert.assertEquals(tab, tab2);
		
	}

}
