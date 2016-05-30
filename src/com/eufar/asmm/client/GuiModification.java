package com.eufar.asmm.client;

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
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GuiModification {
	
	
	// function to reload the page
	public static native void reloadGUI() /*-{
		$wnd.location.reload();
	}-*/;
	
	
	// aircraft selection
	public static void aircraftSelection(final String string) {
		Asmm_eufar.rootLogger.log(Level.INFO, "Selection of an aircraft in progress...");
		if (string == "Make a choice...") {
			Asmm_eufar.fi_aircraftText.clear();
			Asmm_eufar.fi_aircraftText.setEnabled(false);
			if (Asmm_eufar.horizontalPanel26.getWidgetCount() > 1) {
				Asmm_eufar.horizontalPanel26.remove(1);
				Asmm_eufar.horizontalPanel27.remove(1);
				Asmm_eufar.fiGrid.remove(Asmm_eufar.fi_otherOpsText);
				Asmm_eufar.fiGrid.remove(Asmm_eufar.fi_otherAiText);
			}
			Asmm_eufar.rootLogger.log(Level.INFO, "Aircraft panel cleared");
		} else if (string == "Other...") {
			Asmm_eufar.horizontalPanel26.add(Asmm_eufar.fi_operatorImage);
			Asmm_eufar.horizontalPanel27.add(Asmm_eufar.fi_aircraftImage);
			Asmm_eufar.fi_aircraftText.clear();
			Asmm_eufar.fi_aircraftText.setEnabled(true);
			Asmm_eufar.fi_aircraftText.addItem("Other...");
			Asmm_eufar.fiGrid.setWidget(5, 2, Asmm_eufar.fi_otherOpsText);
			Asmm_eufar.fiGrid.setWidget(6, 2, Asmm_eufar.fi_otherAiText);
			Asmm_eufar.rootLogger.log(Level.INFO, "Other selected");
		} else {
			if (Asmm_eufar.horizontalPanel26.getWidgetCount() > 1) {
				Asmm_eufar.horizontalPanel26.remove(1);
				Asmm_eufar.horizontalPanel27.remove(1);
				Asmm_eufar.fiGrid.remove(Asmm_eufar.fi_otherOpsText);
				Asmm_eufar.fiGrid.remove(Asmm_eufar.fi_otherAiText);
			}
			Asmm_eufar.fi_aircraftText.setEnabled(true);
			Asmm_eufar.fi_aircraftText.clear();
			Asmm_eufar.fi_aircraftText.addItem("Make a choice...");
			for (int i = 0; i < Asmm_eufar.operatorsAircraft.length; i++) {
				if (Asmm_eufar.fi_operatorText.getSelectedItemText() == Asmm_eufar.operatorsAircraft[i][0]) {
					Asmm_eufar.fi_aircraftText.addItem(Asmm_eufar.operatorsAircraft[i][1]);
					Asmm_eufar.rootLogger.log(Level.INFO, "Operator selected: " + Asmm_eufar.fi_operatorText.getSelectedItemText());
				}
			}
			if (Asmm_eufar.fi_aircraftText.getItemCount() < 3) {
				Asmm_eufar.fi_aircraftText.removeItem(0);
			}
		}
	}
	
	
	// create new checkboxes and an information popup
	public static PushButton addCatButton(final FlexTable flexTable, final TreeMap<String, String> treeMap, final VerticalPanel verticalPanel) {
		final PushButton addButton = new PushButton("Add a new CheckBox");
		addButton.setTabIndex(-1);
		addButton.getElement().setAttribute("style", "width: 160px !important; height: 18px !important; margin-left: 440px !important; "
				+ "font-family: MyFontBold !important; font-size: 14px; text-align: center !important; padding-top: 5px !important; "
				+ "color: #4f4f4f;");
		addButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Asmm_eufar.rootLogger.log(Level.INFO, "New checkbox invoked...");
				if (treeMap.size() == 12) {
					Asmm_eufar.rootLogger.log(Level.INFO, "Impossible to add more than 12 checkboxes");
					PopupMessages.noCheckboxPanel();
					return;
				}
				final DialogBox checkboxDialog = new DialogBox();
				final VerticalPanel verticalPanel01 = new VerticalPanel();
				final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
				final HorizontalPanel horizontalPanel02 = new HorizontalPanel();
				final Label label01 = new Label("Please enter a title for the new checkbox.");
				final TextBox textBox = new TextBox();
				final Button submitButton = new Button("Submit");
				checkboxDialog.setGlassEnabled(true);
				label01.setStyleName("addCatPopupText");
				verticalPanel01.add(label01);
				verticalPanel01.add(textBox);
				textBox.setStyleName("myAddBox");
				textBox.addKeyDownHandler(new KeyDownHandler() {
					public void onKeyDown(KeyDownEvent event) {
						if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
							String value = treeMap.get(textBox.getText());
							if (value != null || textBox.getText() == "") {
								Asmm_eufar.rootLogger.log(Level.INFO, "No name entered...");
								return;
							}
							if (flexTable.getRowCount() == 0) {
								final Label label03 = new Label("User-defined:");
								verticalPanel.add(flexTable);
								flexTable.getElement().setAttribute("style", "margin-left: 40px !important;");
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
							String parent = Asmm_eufar.parentMap.get(verticalPanel);
							treeMap.put(parent + "UD" + Integer.toString(row) + Integer.toString(cell) + textBox.getValue(),textBox.getValue());
							Asmm_eufar.rootLogger.log(Level.INFO, "Proposed checkbox: " + textBox.getText() + " / " + textBox.getValue());
							final HorizontalPanel checkBox = Elements.checkBox(textBox.getText());
							((CheckBox) checkBox.getWidget(0)).setName(parent + "UD" + Integer.toString(row) + Integer.toString(cell) + textBox.getValue());
							((CheckBox) checkBox.getWidget(0)).addClickHandler(new ClickHandler() {
								@Override
								public void onClick(ClickEvent event) {
									Utilities.docIsModified();
								}
							});
							horizontalPanel02.add(checkBox);
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
						if (flexTable.getRowCount() == 0) {
							final Label label03 = new Label("User-defined:");
							verticalPanel.add(flexTable);
							flexTable.getElement().setAttribute("style", "margin-left: 40px !important;");
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
						String parent = Asmm_eufar.parentMap.get(verticalPanel);
						treeMap.put(parent + "UD" + Integer.toString(row) + Integer.toString(cell) + textBox.getValue(),textBox.getValue());
						Asmm_eufar.rootLogger.log(Level.INFO, "Proposed checkbox: " + textBox.getText() + " / " + textBox.getValue());
						final HorizontalPanel checkBox = Elements.checkBox(textBox.getText());
						((CheckBox) checkBox.getWidget(0)).setName(parent + "UD" + Integer.toString(row) + Integer.toString(cell) + textBox.getValue());
						((CheckBox) checkBox.getWidget(0)).addClickHandler(new ClickHandler() {
							@Override
							public void onClick(ClickEvent event) {
								Utilities.docIsModified();
							}
						});
						horizontalPanel02.add(checkBox);
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
				submitButton.getElement().setAttribute("style", "margin-left:40px !important; font-family: MyFont !important; "
						+ "font-weight: bold !important;");
				cancelButton.getElement().setAttribute("style", "margin-left:65px !important; font-family: MyFont !important; "
						+ "font-weight: bold !important;");
				horizontalPanel01.getElement().setAttribute("style", "margin-top:40px !important;");
				checkboxDialog.setSize( "280px", "170px" );
				checkboxDialog.setModal(true);
				checkboxDialog.center();
				checkboxDialog.setStyleName("myUploadBox");
				checkboxDialog.show();
				textBox.setFocus(true);
			}
		});
		return addButton;
	}
	
	
	// see above, but dedicated to the read function
	public static void addCat(final FlexTable flexTable, final TreeMap<String, String> treeMap, final VerticalPanel verticalPanel, final String string) {
		Asmm_eufar.rootLogger.log(Level.INFO, "New checkbox invoked (xmlfile)...");
		final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
		final Label userLabel = new Label("User-defined:");
		final HorizontalPanel checkBox = Elements.checkBox(string);
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
		String parent = Asmm_eufar.parentMap.get(verticalPanel);
		treeMap.put(parent + "UD" + Integer.toString(row) + Integer.toString(cell) + string, string);
		Asmm_eufar.rootLogger.log(Level.INFO, "Proposed checkbox: " + string + " / " + string);
		((CheckBox) checkBox.getWidget(0)).setName(parent + "UD" + Integer.toString(row) + Integer.toString(cell) + string);
		((CheckBox) checkBox.getWidget(0)).addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Utilities.docIsModified();
			}
		});
		
		((CheckBox) checkBox.getWidget(0)).setValue(true);
		horizontalPanel01.add(checkBox);
		flexTable.setWidget(row - 1, cell, horizontalPanel01);
		Asmm_eufar.rootLogger.log(Level.INFO, "Checkbox added");
	}
}
