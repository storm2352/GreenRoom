package com.greenroom.awt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.greenroom.awt.shared.RoomInfo;

public class GRmain implements EntryPoint, ClickHandler, KeyDownHandler {

	Label rooms = new Label("Enter rooms: ");
	IntegerBox roomsAnswer = new IntegerBox();
	Button bt = new Button("Enter");
	RoomInfo rm = new RoomInfo();
	Label noRooms;
	Label answer;

	public void onModuleLoad() {

		RootPanel.get().add(rooms);
		RootPanel.get().add(roomsAnswer);
		RootPanel.get().add(bt);
		roomsAnswer.setMaxLength(2);
		
		roomsAnswer.addKeyDownHandler(this);
		bt.addClickHandler(this);

	}

	private void getData() {
		rm.setRooms(roomsAnswer.getValue());
		noRooms = new Label("You have " + rm.getRooms() + " rooms.");

		if (rm.getRooms() == null) {
			Window.alert("Please only enter a number value!");

		} else if (!(rm.getRooms() == null)) {

			if (Window.confirm("Are you sure you want to add this?") == true) {
				RootPanel.get().add(noRooms);
				RootPanel.get()
						.add(answer = new Label("Your total is : "
								+ rm.quickTest()));
			}
		}

	}

	@Override
	public void onClick(ClickEvent event) {
		
		// note that in general, events can have sources that are not Widgets.
	    Widget sender = (Widget) event.getSource();
	    
	    if(sender == bt){
	    	getData();
	    }
		
	}

	@Override
	public void onKeyDown(KeyDownEvent event) {
		
		 Widget sender = (Widget) event.getSource();
		 
		 if(sender == roomsAnswer && event.getNativeKeyCode() == KeyCodes.KEY_ENTER){
			 getData();
		 }
		
	}

	
		
	}


