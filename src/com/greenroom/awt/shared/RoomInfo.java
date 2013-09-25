package com.greenroom.awt.shared;

public class RoomInfo {

	private static final int TEST = 2;

	private Integer rooms;

	public RoomInfo() {

	}

	public Integer getRooms() {
		return rooms;
	}

	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}

	public double quickTest() {

		double result;
		result = rooms * TEST;
		return result;
	}
}
