package com.eufar.asmm.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.SimplePanel;

public class Elements {
	
	
	// checkbox hack to align vertically text
	public static HorizontalPanel checkBox(final String string) {
		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		final InlineLabel inlineLabel = new InlineLabel(string);
		final CheckBox box = new CheckBox();
		box.setName(string);
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		inlineLabel.setStyleName("checkboxText");
		horizontalPanel.add(box);
		horizontalPanel.add(inlineLabel);
		return horizontalPanel;
	}
	
	
	// create all the Info buttons in the different tabs
	public static SimplePanel addInfoButton(final String context) {
		final Image image = new Image("icons/info_icon.png");
		final SimplePanel infoButton = new SimplePanel(image);
		infoButton.setPixelSize(25, 25);
		infoButton.setStyleName("infoButton");
		image.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				PopupMessages.infoPanel(context, infoButton);
			}
		});
		return infoButton;
	}
}
