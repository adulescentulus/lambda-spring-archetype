#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import com.amazonaws.serverless.proxy.internal.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.internal.testutils.AwsProxyRequestBuilder;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.junit.Test;
import org.mockito.Mockito;

import javax.ws.rs.HttpMethod;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for {@link MainHandler}.
 */
public class MainHandlerTest {

	@Test
	public void testMainHandler() {

		final MainHandler mainHandler = new MainHandler();
		Context contextMock = Mockito.mock(Context.class);
		Mockito.when(contextMock.getLogger()).thenReturn(Mockito.mock(LambdaLogger.class));
		String name = "world!";
		final AwsProxyResponse response = mainHandler.handleRequest(new AwsProxyRequestBuilder().path("/hello/" + name).method(HttpMethod.GET).build(), new MockLambdaContext());
		assertNotNull("Repsonse must not be null", response);
		assertTrue(response.getBody().contains("world"));
	}
}
