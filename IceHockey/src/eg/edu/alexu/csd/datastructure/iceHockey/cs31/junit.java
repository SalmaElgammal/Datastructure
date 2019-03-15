package eg.edu.alexu.csd.datastructure.iceHockey.cs31;

import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;

public class junit {

	@Test
	public void test() {
		MyIceHockey obj =new MyIceHockey();
		String[] testing={"11111",
				"1AAA1",
				"1A1A1",
				"1AAA1",
				"11111"};
		Point[] res=new Point[2];
		for(int i=0;i<res.length;i++){
			res[i]=new Point();
		}
		res[0].x=5;
		res[0].y=5;
		res[1].x=5;
		res[1].y=5;
		
		Assert.assertArrayEquals(res, obj.findPlayers(testing,1,3));
	}

}

