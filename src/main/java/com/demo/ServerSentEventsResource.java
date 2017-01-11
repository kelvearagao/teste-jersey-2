package com.demo;

import java.io.IOException;

import javax.inject.Singleton;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

@Singleton
@Path("testSSE")
public class ServerSentEventsResource {

	static EventOutput eventOutput = new EventOutput();

	@GET
	@Produces(SseFeature.SERVER_SENT_EVENTS)
	public EventOutput getMessage() {
		System.out.println("test");
		return eventOutput;
	}

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public void sendMessage(String message) throws IOException, JAXBException {
		System.out.println(message);

		OutboundEvent.Builder eventBuilder = new OutboundEvent.Builder();
		
		JsonObject msg = Json.createObjectBuilder()
		        .add("fromId", 12)
		        .add("toId", 15)
		        .build();

		OutboundEvent event = eventBuilder.name("message")
				.mediaType(MediaType.APPLICATION_JSON_TYPE)
				.data(JsonObject.class, msg)
				.build();

		eventOutput.write(event);
	}

}
