package bean;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Random;

public class RandomString implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final Random rnd = new Random();
	static {
		rnd.setSeed(System.nanoTime());
	}

	public String getRandomString() throws NoSuchAlgorithmException {
		byte[] bytes = new byte[10];
		rnd.nextBytes(bytes);
		MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(bytes);
		return byteToHex(crypt.digest());
	}
	private static String byteToHex(final byte[] hash)
    {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
