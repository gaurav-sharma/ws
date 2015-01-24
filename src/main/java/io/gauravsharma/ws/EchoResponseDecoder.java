package io.gauravsharma.ws;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class EchoResponseDecoder implements Decoder.Text<EchoResponse> {

	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public EchoResponse decode(String s) throws DecodeException {

		JsonObject jsonObject = Json.createReader(new StringReader(s))
				.readObject();
		EchoResponse response = new EchoResponse();
		response.setTimestamp(jsonObject.getJsonNumber("timestamp").longValue());

		return response;
	}

	public boolean willDecode(String s) {

		return true;
	}

}
