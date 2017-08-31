package com.eufar.asmm.client;

import java.util.ArrayList;
import java.util.logging.Level;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.VerticalPanel;

public class pdfSave {
	
	// preparation of the printing, all fields are copy/past in textboxes
	public static void createPrint(final VerticalPanel verticalPanel) {
		Asmm_eufar.rootLogger.log(Level.INFO, "Preparation of all data for the report in progress...");
		final ArrayList<TextBoxBase> textboxLst = Materials.textboxLst();
		final ArrayList<ListBox> listboxLst = Materials.listboxLst();
		final ArrayList<HorizontalPanel> checkboxLst = Materials.checkboxLst();
		checkboxLst.addAll(Asmm_eufar.newCheckboxLst);
		TextBox textBox = new TextBox();
		textBox.setName("flightCampaign");
		textBox.setText(Asmm_eufar.fi_campaignText.getText());
		verticalPanel.add(textBox);
		for (int i = 0; i < textboxLst.size(); i++) {
			textBox = new TextBox();
			if (Materials.nonrequiredTextboxLst().contains(textboxLst.get(i))) {
				String string = Utilities.addCoordinateText(textboxLst.get(i).getText(), textboxLst.get(i));
				textBox.setText(string);
			} else {
				textBox.setText(textboxLst.get(i).getText());
			}
			textBox.setName(textboxLst.get(i).getName());
			verticalPanel.add(textBox);
		}
		
		for (int i = 0; i< listboxLst.size(); i++) {
			textBox = new TextBox();
			if (listboxLst.get(i).getSelectedItemText() == "Other...") {
				if (listboxLst.get(i).getName() == "operatorText") {
					textBox.setText(Asmm_eufar.fi_otherOpsText.getText());
				} else if (listboxLst.get(i).getName() == "aircraftText") {
					textBox.setText(Asmm_eufar.fi_otherAiText.getText());
				}
			} else {
				textBox.setText(listboxLst.get(i).getSelectedItemText());
			}
			textBox.setName(listboxLst.get(i).getName());
			verticalPanel.add(textBox);
		}
		
		TextBox dateBox = new TextBox();
		dateBox.setText(DateTimeFormat.getFormat("yyyy-MM-dd").format(Asmm_eufar.fi_dateText.getValue()));
		dateBox.setName("date");
		verticalPanel.add(dateBox);
		
		for (int i = 0; i < checkboxLst.size(); i++) {
			textBox = new TextBox();
			CheckBox checkbox = (CheckBox) checkboxLst.get(i).getWidget(0);
			if (checkbox.getName().contains("UD")) {
				if (checkbox.getValue() == true) {
					textBox.setText("icons/checkbox_checked.png*" + checkbox.getName().substring(6));
					textBox.setName(checkbox.getName().substring(0, 6));
					verticalPanel.add(textBox);
				}
			} else {
				if (checkbox.getValue() == true) {
					textBox.setText("icons/checkbox_checked.png");
				} else {
					textBox.setText("icons/checkbox_unchecked.png");
				}
				textBox.setName(checkbox.getName());
				verticalPanel.add(textBox);
			}
		}
		
		if (!Asmm_eufar.so_groundSitesList.isEmpty()) {
			textBox = new TextBox();
			String string = new String();
			textBox.setName("groundSites");
			for (int i = 0; i < Asmm_eufar.so_groundSitesList.size(); i++) {
				if (i == 0){
					string = Asmm_eufar.so_groundSitesList.get(i).toString();
				} else {
					string = string + "<br>" + Asmm_eufar.so_groundSitesList.get(i).toString();
				}
			}
			textBox.setText(string);
			verticalPanel.add(textBox);
		}

		if (Asmm_eufar.so_armSitesList.isEmpty() == false) {
			textBox = new TextBox();
			String string = new String();
			textBox.setName("armSites");
			for (int i = 0; i < Asmm_eufar.so_armSitesList.size(); i++) {
				if (i == 0){
					string = Asmm_eufar.so_armSitesList.get(i).toString();
				} else {
					string = string + "<br>" + Asmm_eufar.so_armSitesList.get(i).toString();
				}
			}
			textBox.setText(string);
			verticalPanel.add(textBox);
		}
		
		if (Asmm_eufar.so_researchVesselsList.isEmpty() == false) {
			textBox = new TextBox();
			textBox.setName("researchVessels");
			String string = new String();
			for (int i = 0; i < Asmm_eufar.so_researchVesselsList.size(); i++) {
				if (i == 0){
					string = Asmm_eufar.so_researchVesselsList.get(i).toString();
				} else {
					string = string + "<br>" + Asmm_eufar.so_researchVesselsList.get(i).toString();
				}
			}
			textBox.setText(string);
			verticalPanel.add(textBox);
		}
		
		if (Asmm_eufar.so_mobileSitesList.isEmpty() == false) {
			textBox = new TextBox();
			textBox.setName("mobileSites");
			String string = new String();
			for (int i = 0; i < Asmm_eufar.so_mobileSitesList.size(); i++) {
				if (i == 0){
					string = Asmm_eufar.so_mobileSitesList.get(i).toString();
				} else {
					string = string + "<br>" + Asmm_eufar.so_mobileSitesList.get(i).toString();
				}
			}
			textBox.setText(string);
			verticalPanel.add(textBox);
		}
		
		if (Asmm_eufar.imagePath.isEmpty() == false) {
			for (int i = 0; i < Asmm_eufar.imagePath.size(); i++) {
				textBox = new TextBox();
				textBox.setName("image" + Integer.toString(i));
				textBox.setText(Asmm_eufar.imagePath.get(i) + "*" + Asmm_eufar.imageCaption.get(i));
				verticalPanel.add(textBox);
			}
		}
		Asmm_eufar.rootLogger.log(Level.INFO, "Preparation of all data for the report finished");
	}
}
