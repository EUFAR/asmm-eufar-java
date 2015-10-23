package com.eufar.asmm.client;

import static com.google.gwt.query.client.GQuery.$;

import java.util.List;
import java.util.logging.Level;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

public class pdfSave {
	

	// preparation of the printing
	public static void createPrint(final VerticalPanel verticalPanel) {
		Asmm_eufar.rootLogger.log(Level.INFO, "Preparation of all data for the report in progress...");
		try {
			List<TextBoxBase> allTextBox = $("*", Asmm_eufar.subDockPanel).widgets(TextBoxBase.class);
			for (int i = 0; i < allTextBox.size(); i++) {
				TextBox textBox = new TextBox();
				textBox.setText(allTextBox.get(i).getText());
				textBox.setName(Asmm_eufar.textboxName.get(i).toString());
				verticalPanel.add(textBox);
			}
		} catch (Exception ex) {
			Asmm_eufar.rootLogger.log(Level.SEVERE, "A problem occured: ", ex);
		}
		try {
			List<ListBox> allListBox = $("*", Asmm_eufar.subDockPanel).widgets(ListBox.class);
			for (int i = 0; i < allListBox.size(); i++) {
				TextBox textBox = new TextBox();
				if (allListBox.get(i).getSelectedItemText() == "Make a choice...") {
					textBox.setText("");
				} else {
					textBox.setText(allListBox.get(i).getSelectedItemText());
				}
				textBox.setName(Asmm_eufar.listboxName.get(i).toString());
				verticalPanel.add(textBox);
			}
		} catch (Exception ex) {
			Asmm_eufar.rootLogger.log(Level.SEVERE, "A problem occured: ", ex);
		}
		try {
			List<DateBox> allDateBox = $("*", Asmm_eufar.subDockPanel).widgets(DateBox.class);
			for (int i = 0; i < allDateBox.size(); i++) {
				TextBox textBox = new TextBox();
				textBox.setText(DateTimeFormat.getFormat("yyyy-MM-dd").format(allDateBox.get(i).getValue()));
				textBox.setName(Asmm_eufar.dateboxName.get(i).toString());
				verticalPanel.add(textBox);
			}
		} catch (Exception ex) {
			Asmm_eufar.rootLogger.log(Level.SEVERE, "A problem occured: ", ex);
		}
		try {
			List<CheckBox> allCheckBox = $("*", Asmm_eufar.subDockPanel).widgets(CheckBox.class);
			int j = 0;
			for (int i = 0; i < allCheckBox.size(); i = i + 2) {
				TextBox textBox = new TextBox();
				if (allCheckBox.get(i).getName().contains("UD")) {
					if (allCheckBox.get(i).getValue() == true) {
						String name = allCheckBox.get(i).getName();
						textBox.setText("icons/checkbox_checked.png*" + name.substring(6));
						textBox.setName(name.substring(0, 6));
						verticalPanel.add(textBox);
					}
				} else {
					if (allCheckBox.get(i).getValue() == true) {
						textBox.setText("icons/checkbox_checked.png");
					} else {
						textBox.setText("icons/checkbox_unchecked.png");
					}
					textBox.setName(Asmm_eufar.checkboxName.get(j).toString());
					j++;
					verticalPanel.add(textBox);
				}
			}
		} catch (Exception ex) {
			Asmm_eufar.rootLogger.log(Level.SEVERE, "A problem occured: ", ex);
		}
		try {
			if (Asmm_eufar.so_groundSitesList.isEmpty() == false) {
				TextBox textBox = new TextBox();
				textBox.setName("groundSites");
				String string = new String();
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
		} catch (Exception ex) {
			Asmm_eufar.rootLogger.log(Level.SEVERE, "A problem occured: ", ex);
		}
		try {
			if (Asmm_eufar.so_armSitesList.isEmpty() == false) {
				TextBox textBox = new TextBox();
				textBox.setName("armSites");
				String string = new String();
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
		} catch (Exception ex) {
			Asmm_eufar.rootLogger.log(Level.SEVERE, "A problem occured: ", ex);
		}
		try {
			if (Asmm_eufar.so_researchVesselsList.isEmpty() == false) {
				TextBox textBox = new TextBox();
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
		} catch (Exception ex) {
			Asmm_eufar.rootLogger.log(Level.SEVERE, "A problem occured: ", ex);
		}
		try {
			if (Asmm_eufar.so_mobileSitesList.isEmpty() == false) {
				TextBox textBox = new TextBox();
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
		} catch (Exception ex) {
			Asmm_eufar.rootLogger.log(Level.SEVERE, "A problem occured: ", ex);
		}
		try {
			if (Asmm_eufar.imagePath.isEmpty() == false) {
				for (int i = 0; i < Asmm_eufar.imagePath.size(); i++) {
					TextBox textBox = new TextBox();
					textBox.setName("image" + Integer.toString(i));
					textBox.setText(Asmm_eufar.imagePath.get(i) + "*" + Asmm_eufar.imageCaption.get(i));
					verticalPanel.add(textBox);
				}
			}
		} catch (Exception ex) {
			Asmm_eufar.rootLogger.log(Level.SEVERE, "A problem occured: ", ex);
		}
		Asmm_eufar.rootLogger.log(Level.INFO, "Preparation of all data for the report finished");
	}
}
