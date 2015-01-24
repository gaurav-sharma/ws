package io.gauravsharma.ws;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/echo", encoders = { EchoResponseEncoder.class }, decoders = { EchoResponseDecoder.class })
public class Echo {

	private Session session;

	@OnOpen
	public void connect(Session session) {
		this.session = session;
		System.out.println("session = " + session);
	}

	@OnClose
	public void close() {
		this.session = null;
		System.out.println("Closed!");
	}

	@OnMessage
	public void onMessage(EchoResponse message) {

		// I'm printing to console, but this can 
		//easily be save to db using something like:
		//heartbeatRepository.save(new Heartbeat(timestamp, deviceId, ipAddress));
		System.out.println(message);
		
		this.session.getAsyncRemote().sendObject(message);
	}
}
