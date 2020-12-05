package me.wietlol.test.awslambdatests.handlers;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;

import java.time.Instant;

public class LambdaInvokeTestHandler
{
	public String source()
	{
		log("started");
		
		String function = System.getenv("functionArn");
		
		String payload = "{}";
		
		log("getting client...");

		AWSLambda client = createClient();

		log("invoking function");

		client.invoke(new InvokeRequest()
			.withFunctionName(function)
			.withPayload(payload)
		);
		
		log("finished");
		
		return "{}";
	}
	
	public String target()
	{
		log("invoked");
		
		return "{}";
	}

	private AWSLambda createClient()
	{
		return AWSLambdaClientBuilder.defaultClient();
	}
	
	private void log(String text)
	{
		System.out.println(Instant.now() + " " + text);
	}
}
