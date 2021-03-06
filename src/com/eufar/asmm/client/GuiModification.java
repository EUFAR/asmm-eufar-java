package com.eufar.asmm.client;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.logging.Level;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GuiModification {
	
	
	// aircraft selection
	public static void aircraftSelection(final String string) {
		Asmm_eufar.rootLogger.log(Level.INFO, "Selection of an aircraft in progress...");
		if (string == "Make a choice...") {
			Asmm_eufar.fi_aircraftText.clear();
			Asmm_eufar.fi_aircraftText.setEnabled(false);
			Asmm_eufar.fi_operatorImage.setVisible(false);
			Asmm_eufar.fi_otherOpsText.setVisible(false);
			Asmm_eufar.fi_aircraftImage.setVisible(false);
			Asmm_eufar.fi_otherAiText.setVisible(false);
			Asmm_eufar.fi_starLab09.setVisible(false);
			Asmm_eufar.fi_starLab10.setVisible(false);
			Asmm_eufar.fi_starLab11.setVisible(false);
			Asmm_eufar.fi_otherManLabel.setVisible(false);
			Asmm_eufar.fi_otherRegLabel.setVisible(false);
			Asmm_eufar.fi_otherCntLabel.setVisible(false);
			Asmm_eufar.fi_otherCntText.setVisible(false);
			Asmm_eufar.fi_otherRegText.setVisible(false);
			Asmm_eufar.fi_otherManText.setVisible(false);
			Asmm_eufar.rootLogger.log(Level.INFO, "Aircraft panel cleared");
		} else if (string == "Other...") {
			Asmm_eufar.fi_operatorImage.setVisible(true);
			Asmm_eufar.fi_otherOpsText.setVisible(true);
			Asmm_eufar.fi_aircraftImage.setVisible(true);
			Asmm_eufar.fi_otherAiText.setVisible(true);
			Asmm_eufar.fi_starLab09.setVisible(true);
			Asmm_eufar.fi_starLab10.setVisible(true);
			Asmm_eufar.fi_starLab11.setVisible(true);
			Asmm_eufar.fi_otherManLabel.setVisible(true);
			Asmm_eufar.fi_otherRegLabel.setVisible(true);
			Asmm_eufar.fi_otherCntLabel.setVisible(true);
			Asmm_eufar.fi_otherCntText.setVisible(true);
			Asmm_eufar.fi_otherRegText.setVisible(true);
			Asmm_eufar.fi_otherManText.setVisible(true);
			Asmm_eufar.fi_otherOpsText.setText("");
			Asmm_eufar.fi_otherAiText.setText("");
			Asmm_eufar.fi_aircraftText.clear();
			Asmm_eufar.fi_aircraftText.setEnabled(true);
			Asmm_eufar.fi_aircraftText.addItem("Other...");
			Asmm_eufar.rootLogger.log(Level.INFO, "Other selected");
		} else {
			Asmm_eufar.fi_operatorImage.setVisible(false);
			Asmm_eufar.fi_otherOpsText.setVisible(false);
			Asmm_eufar.fi_aircraftImage.setVisible(false);
			Asmm_eufar.fi_otherAiText.setVisible(false);
			Asmm_eufar.fi_starLab09.setVisible(false);
			Asmm_eufar.fi_starLab10.setVisible(false);
			Asmm_eufar.fi_starLab11.setVisible(false);
			Asmm_eufar.fi_otherManLabel.setVisible(false);
			Asmm_eufar.fi_otherRegLabel.setVisible(false);
			Asmm_eufar.fi_otherCntLabel.setVisible(false);
			Asmm_eufar.fi_otherCntText.setVisible(false);
			Asmm_eufar.fi_otherRegText.setVisible(false);
			Asmm_eufar.fi_otherManText.setVisible(false);
			Asmm_eufar.fi_aircraftText.setEnabled(true);
			Asmm_eufar.fi_aircraftText.clear();
			Asmm_eufar.fi_aircraftText.addItem("Make a choice...");
			for (int i = 0; i < Asmm_eufar.operatorsAircraft.length; i++) {
				if (Asmm_eufar.fi_operatorText.getSelectedItemText() == Asmm_eufar.operatorsAircraft[i][0]) {
					String fullAircraft = Asmm_eufar.operatorsAircraft[i][1];
					try {
						if (fullAircraft == Asmm_eufar.operatorsAircraft[i - 1][1] & 
								Asmm_eufar.operatorsAircraft[i][0] == Asmm_eufar.operatorsAircraft[i - 1][0]) {
							fullAircraft = fullAircraft + " - " + Asmm_eufar.operatorsAircraft[i][2];
						}
					} catch (Exception e) {}
					try {
						if (fullAircraft == Asmm_eufar.operatorsAircraft[i + 1][1] &
								Asmm_eufar.operatorsAircraft[i][0] == Asmm_eufar.operatorsAircraft[i + 1][0]) {
							fullAircraft = fullAircraft + " - " + Asmm_eufar.operatorsAircraft[i][2];
						}
					} catch (Exception e) {}
					int index = fullAircraft.indexOf(", ");
					String aircraft = fullAircraft.substring(index + 2);
					Asmm_eufar.fi_aircraftText.addItem(aircraft);
					Asmm_eufar.rootLogger.log(Level.INFO, "Operator selected: " + Asmm_eufar.fi_operatorText.getSelectedItemText());
				}
			}
			if (Asmm_eufar.fi_aircraftText.getItemCount() < 3) {
				Asmm_eufar.fi_aircraftText.removeItem(0);
			}
		}
	}
	
	
	// create new checkboxes and an information popup
	public static Label addCatButton(final FlexTable flexTable, final TreeMap<String, String> treeMap, final VerticalPanel verticalPanel) {
		final Label addButton = new Label("Add a new CheckBox");
		addButton.setStyleName("addCheckboxPushbutton");
		addButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Asmm_eufar.rootLogger.log(Level.INFO, "New checkbox invoked...");
				if (treeMap.size() == 12) {
					Asmm_eufar.rootLogger.log(Level.INFO, "Impossible to add more than 12 checkboxes");
					PopupMessages.noCheckboxPanel();
					return;
				}
				final HashMap<VerticalPanel, String> parentMap = Materials.parentMap();
				final DialogBox checkboxDialog = new DialogBox();
				final VerticalPanel verticalPanel01 = new VerticalPanel();
				final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
				final HorizontalPanel horizontalPanel02 = new HorizontalPanel();
				final Label label01 = new Label("Please enter a title for the new checkbox.");
				final TextBox textBox = new TextBox();
				final Button submitButton = new Button("Submit");
				checkboxDialog.setGlassEnabled(true);
				verticalPanel01.add(label01);
				verticalPanel01.add(textBox);
				textBox.addKeyDownHandler(new KeyDownHandler() {
					public void onKeyDown(KeyDownEvent event) {
						if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
							String value = treeMap.get(textBox.getText());
							if (value != null || textBox.getText() == "") {
								Asmm_eufar.rootLogger.log(Level.INFO, "No name entered...");
								return;
							}
							for (int i = 0; i < Asmm_eufar.newCheckboxLst.size(); i++) {
								if (textBox.getText() == ((Label) Asmm_eufar.newCheckboxLst.get(i).getWidget(1)).getText()) {
									Asmm_eufar.rootLogger.log(Level.INFO, "Checkbox already exists...");
									return;
								}
							}
							if (flexTable.getRowCount() == 0) {
								final Label label03 = new Label("User-defined");
								verticalPanel.add(flexTable);
								flexTable.getElement().setAttribute("style", "margin-left: 40px !important;");
								flexTable.insertRow(0);
								label03.setStyleName("gi_titleText");
								label03.getElement().setAttribute("style", "margin-left: 10px !important;");
								verticalPanel.insert(label03, 1);
							}
							int row = flexTable.getRowCount();
							int cell = flexTable.getCellCount(row - 1);
							if (cell == 4) {
								flexTable.insertRow(row);
								row = flexTable.getRowCount();
								cell = flexTable.getCellCount(row-1);
							} else {
								cell = flexTable.getCellCount(row-1);
							}
							String parent = parentMap.get(verticalPanel);
							treeMap.put(parent + "UD" + Integer.toString(row) + Integer.toString(cell) + textBox.getValue(),textBox.getValue());
							Asmm_eufar.rootLogger.log(Level.INFO, "Proposed checkbox: " + textBox.getText() + " / " + textBox.getValue());
							final HorizontalPanel checkBox = Elements.checkBox(textBox.getText(),parent + "UD" + Integer.toString(row) + Integer.toString(cell) + textBox.getValue());
							checkBox.getElement().setAttribute("style", "color: #4f4f4f !important;");
							((CheckBox) checkBox.getWidget(0)).addClickHandler(new ClickHandler() {
								@Override
								public void onClick(ClickEvent event) {
									Utilities.docIsModified();
								}
							});
							horizontalPanel02.add(checkBox);
							Asmm_eufar.newCheckboxLst.add(checkBox);
							flexTable.setWidget(row - 1, cell, horizontalPanel02);
							checkboxDialog.hide();
							Asmm_eufar.rootLogger.log(Level.INFO, "Checkbox added");
						}
					}
				});
				submitButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						String value = treeMap.get(textBox.getText());
						if (value != null || textBox.getText() == "") {
							Asmm_eufar.rootLogger.log(Level.INFO, "No name entered...");
							return;
						}
						for (int i = 0; i < Asmm_eufar.newCheckboxLst.size(); i++) {
							if (textBox.getText() == ((Label) Asmm_eufar.newCheckboxLst.get(i).getWidget(1)).getText()) {
								Asmm_eufar.rootLogger.log(Level.INFO, "Checkbox already exists...");
								return;
							}
						}
						if (flexTable.getRowCount() == 0) {
							final Label label03 = new Label("User-defined");
							verticalPanel.add(flexTable);
							flexTable.getElement().setAttribute("style", "margin-left: 40px !important;");
							label03.getElement().setAttribute("style", "margin-left: 10px !important;");
							flexTable.insertRow(0);
							label03.setStyleName("gi_titleText");
							verticalPanel.insert(label03, 1);
						}
						int row = flexTable.getRowCount();
						int cell = flexTable.getCellCount(row - 1);
						if (cell == 4) {
							flexTable.insertRow(row);
							row = flexTable.getRowCount();
							cell = flexTable.getCellCount(row-1);
						} else {
							cell = flexTable.getCellCount(row-1);
						}
						String parent = parentMap.get(verticalPanel);
						treeMap.put(parent + "UD" + Integer.toString(row) + Integer.toString(cell) + textBox.getValue(),textBox.getValue());
						Asmm_eufar.rootLogger.log(Level.INFO, "Proposed checkbox: " + textBox.getText() + " / " + textBox.getValue());
						final HorizontalPanel checkBox = Elements.checkBox(textBox.getText(), parent + "UD" + Integer.toString(row) + Integer.toString(cell) + textBox.getValue());
						checkBox.getElement().setAttribute("style", "color: #4f4f4f !important;");
						((CheckBox) checkBox.getWidget(0)).addClickHandler(new ClickHandler() {
							@Override
							public void onClick(ClickEvent event) {
								Utilities.docIsModified();
							}
						});
						horizontalPanel02.add(checkBox);
						Asmm_eufar.newCheckboxLst.add(checkBox);
						flexTable.setWidget(row - 1, cell, horizontalPanel02);
						checkboxDialog.hide();
						Asmm_eufar.rootLogger.log(Level.INFO, "Checkbox added");
					}
				});
				final Button cancelButton = new Button("Cancel", new ClickHandler() {
					public void onClick(ClickEvent event) {
						checkboxDialog.hide();
					}
				});
				horizontalPanel01.add(submitButton);
				horizontalPanel01.add(cancelButton);
				verticalPanel01.add(horizontalPanel01);
				checkboxDialog.add(verticalPanel01);
				textBox.setStyleName("addCheckboxBox");
				label01.setStyleName("addCheckboxText");
				checkboxDialog.setStyleName("addCheckboxPanel");
				submitButton.addStyleName("addCheckboxButton1");
				cancelButton.addStyleName("addCheckboxButton2");
				checkboxDialog.setSize("250px","50px");
				checkboxDialog.setModal(true);
				checkboxDialog.center();
				checkboxDialog.show();
				textBox.setFocus(true);
			}
		});
		return addButton;
	}
	
	
	// see above, but dedicated to the read function
	public static void addCat(final FlexTable flexTable, final TreeMap<String, String> treeMap, final VerticalPanel verticalPanel, final String string) {
		Asmm_eufar.rootLogger.log(Level.INFO, "New checkbox invoked (xmlfile)...");
		final HashMap<VerticalPanel, String> parentMap = Materials.parentMap();
		final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
		final Label userLabel = new Label("User-defined:");
		if (flexTable.getRowCount() == 0) {
			verticalPanel.add(flexTable);
			flexTable.getElement().setAttribute("style", "margin-left: 40px !important;");
			flexTable.insertRow(0);
			userLabel.setStyleName("gi_titleText");
			verticalPanel.insert(userLabel, 1);
		}
		int row = flexTable.getRowCount();
		int cell = flexTable.getCellCount(row - 1);
		if (cell == 4) {
			flexTable.insertRow(row);
			row = flexTable.getRowCount();
			cell = flexTable.getCellCount(row-1);
		} else {
			cell = flexTable.getCellCount(row-1);
		}
		String parent = parentMap.get(verticalPanel);
		final HorizontalPanel checkBox = Elements.checkBox(string,parent + "UD" + Integer.toString(row) + Integer.toString(cell) + string);
		treeMap.put(parent + "UD" + Integer.toString(row) + Integer.toString(cell) + string, string);
		Asmm_eufar.rootLogger.log(Level.INFO, "Proposed checkbox: " + string + " / " + string);
		checkBox.getElement().setAttribute("style", "color: #4f4f4f !important;");
		((CheckBox) checkBox.getWidget(0)).addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Utilities.docIsModified();
			}
		});
		
		((CheckBox) checkBox.getWidget(0)).setValue(true);
		horizontalPanel01.add(checkBox);
		Asmm_eufar.newCheckboxLst.add(checkBox);
		flexTable.setWidget(row - 1, cell, horizontalPanel01);
		Asmm_eufar.rootLogger.log(Level.INFO, "Checkbox added");
	}
	
	
	// Fill in autmatically other fields from project acronym
	public static void fillInFieldsFromProject(final String acronym) {
		Asmm_eufar.rootLogger.log(Level.INFO, "fillInFieldsFromProject requested from: " + acronym);
		String operator = null;
		String aircraft_manufacturer = null;
		HashMap<String, String> projectData = null;
		String aircraft = null;
		try {
			projectData = Asmm_eufar.projectsDBMap.get(acronym);
			Asmm_eufar.fi_scientistText.setText(projectData.get("leader"));
			String platform = projectData.get("aircraft");
			HashMap<String, String> platformData = Asmm_eufar.aircraftDBMap.get(platform);
			operator = platformData.get("operator");
			aircraft_manufacturer = platformData.get("manufacturer and aircraft type");
			int index = aircraft_manufacturer.indexOf(", ");
			aircraft = aircraft_manufacturer.substring(index + 2);
			if (operator == "INTA" || operator == "NERC") {
				aircraft = aircraft + " - " + platformData.get("registration number");
			}
		} catch (Exception e) {};
		if (projectData != null) {
			try {
				Utilities.checkList(operator, Asmm_eufar.fi_operatorText);
				aircraftSelection(operator);
				Utilities.checkList(aircraft, Asmm_eufar.fi_aircraftText);
			} catch (Exception ex) {
				Utilities.checkList("Other...", Asmm_eufar.fi_operatorText);
				aircraftSelection("Other...");
				Asmm_eufar.fi_otherOpsText.setText(operator);
				Asmm_eufar.fi_otherAiText.setText(aircraft);
			}
		}
	}
}
