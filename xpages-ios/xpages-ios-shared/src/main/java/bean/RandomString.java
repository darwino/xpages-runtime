package bean;

import java.io.Serializable;
import java.util.Random;

import javax.xml.bind.DatatypeConverter;

public class RandomString implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final Random rnd = new Random();
	static {
		rnd.setSeed(System.nanoTime());
	}

	public String getRandomString() {
		int val = rnd.nextInt();
		return DatatypeConverter.printBase64Binary(String.valueOf(val).getBytes()).replace("=", "");
	}
}
