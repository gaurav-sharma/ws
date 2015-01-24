package io.gauravsharma.ws;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class EchoResponseEncoder implements Encoder.Text<EchoResponse> {

	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public String encode(EchoResponse object) throws EncodeException {
		
		return Json.createObjectBuilder()
				.add("timestamp", object.getTimestamp()).build().toString();
	}

}
