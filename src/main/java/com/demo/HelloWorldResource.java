package com.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("helloWorld")
public class HelloWorldResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String greet() {
		return "Hello World";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{name}")
	public String sayHello(@PathParam("name") String name) {
		return "Hello " + name;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("v2/{name: ([a-zA-Z])*}")
	public String sayHello2(@PathParam(value="name") String name) {
		return "Hello " + name;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("v2/message")
	public Message getMessage() {
		return new Message(12, 13);
	}
	
}
