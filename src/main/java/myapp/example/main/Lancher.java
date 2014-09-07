package myapp.example.main;

import java.net.URL;
import java.security.ProtectionDomain;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Lancher {
	// see:
	// http://eclipsesource.com/blogs/2009/10/02/executable-wars-with-jetty/
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		WebAppContext context = new WebAppContext();
		context.setContextPath("/");

		ProtectionDomain protectionDomain = Lancher.class.getProtectionDomain();
		URL location = protectionDomain.getCodeSource().getLocation();
		context.setWar(location.toExternalForm());

		server.setHandler(context);

		try {
			server.start();
			System.err.println("Press ENTER to exit.");
			System.in.read();
			server.stop();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
