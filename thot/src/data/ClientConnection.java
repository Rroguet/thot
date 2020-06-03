package data;

public class ClientConnection {
	public static void main (String[] args)
	{
		SimpleClient c1 = new SimpleClient();
		c1.connect("localhost");
		c1.login("test1", "test1");
		c1.deconnection();
	}
}
