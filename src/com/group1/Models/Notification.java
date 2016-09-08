package com.group1.Models;

import java.sql.Date;

public class Notification {
	

	String content;
	Date send_date;
	int receiver_id;
	int sender_id;
	String senderName;

	public Notification(String content, Date send_date, int receiver_id, int sender_id) {
		this.content = content;
		this.send_date = send_date;
		this.receiver_id = receiver_id;
		this.sender_id = sender_id;
	}
	
	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSend_date() {
		return send_date;
	}

	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}

	public int getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}

	public int getSender_id() {
		return sender_id;
	}

	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}
	
}
