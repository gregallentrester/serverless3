package net.greg.examples.serverless;

import java.util.*;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public final class Handler
		implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	@Override
	public ApiGatewayResponse handleRequest(
			Map<String, Object> input, Context context) {

		Response response =
			new Response("This is the current time " + new Date());

		Map<String, String> headers =
			new HashMap();

		headers.put("X-Powered-By", "AWS Lambda & Serverless");
		headers.put("Content-Type", "application/json");

		System.err.println("\n Received: " + input);

		return
			ApiGatewayResponse.
				builder().
				setStatusCode(200).
				setObjectBody(response).
				setHeaders(headers).
				build();
	}
}
