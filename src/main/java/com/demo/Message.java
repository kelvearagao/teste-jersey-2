package com.demo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message implements Serializable {
	
	private int fromId;
	
	private int toId;
	
	public Message() {} // JAXB needs this
	
	public Message(int fromId, int toId) {
		this.fromId = fromId;
		this.toId = toId;
	};
	
	public int getFromId() {
		return fromId;
	}
	public void setFromId(int fromId) {
		this.fromId = fromId;
	}
	public int getToId() {
		return toId;
	}
	public void setToId(int toId) {
		this.toId = toId;
	}
	
}
