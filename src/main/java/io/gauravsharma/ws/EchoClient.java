package io.gauravsharma.ws;

import java.io.IOException;
import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint
public class EchoClient {

	private static final String URL = "ws://localhost:8080/ws/echo";
	
	public static void main(String[] args) {
		WebSocketContainer container = null;
		
		Session session = null;
		
		container = ContainerProvider.getWebSocketContainer();
		try {
			session = container.connectToServer(EchoClient.class, URI.create(URL));
		} catch (DeploymentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				session.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
