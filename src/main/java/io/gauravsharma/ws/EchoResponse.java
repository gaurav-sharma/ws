package io.gauravsharma.ws;


public class EchoResponse {
	
	private long timestamp;

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}	
	
	@Override
	public String toString() {
		return "EchoResponse [timestamp=" + timestamp + "]";
	}

}
