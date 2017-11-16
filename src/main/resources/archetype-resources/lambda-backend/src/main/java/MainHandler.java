#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import ${package}.spring.ApplicationConfiguration;

/**
 * Main Lambda entrypoint
 */
public class MainHandler implements RequestHandler<AwsProxyRequest, AwsProxyResponse>
{

    private SpringLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;

    @Override
    public AwsProxyResponse handleRequest(AwsProxyRequest awsProxyRequest, Context context)
    {
        if (handler == null)
        {
            try
            {
                handler = SpringLambdaContainerHandler.getAwsProxyHandler(ApplicationConfiguration.class);
            }
            catch (ContainerInitializationException e)
            {
                e.printStackTrace();
                return null;
            }
        }
        return handler.proxy(awsProxyRequest, context);
    }
}
