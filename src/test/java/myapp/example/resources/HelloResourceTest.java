package myapp.example.resources;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class HelloResourceTest extends JerseyTest {
	@Override
	protected Application configure() {
		ResourceConfig rc = new ResourceConfig(HelloResource.class);
		return rc;
	}

	@Test
	public void getHelloTest() {
		Builder resource = this.target().path("/hello").request();
		Response response = resource.get();

		assertThat("check response status",
				response.getStatus(),
				is(200));

		assertThat("check response header",
				response.getHeaders().get("Content-type"),
				hasItems((Object) "text/plain"));

		assertThat("check response body",
				response.readEntity(String.class),
				is("Hello World"));
	}

	@Test
	public void postHelloTest() {
		Builder resource = this.target().path("/hello").request();
		String response = resource.post(
				Entity.form(new Form().param("name", "ryozi")
			), String.class);

		assertThat("check response body",
				response,
				is("Hello, ryozi"));
	}
}
