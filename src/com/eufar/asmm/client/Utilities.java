package com.eufar.asmm.client;

import static com.google.gwt.query.client.GQuery.$;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.logging.Level;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.datepicker.client.DateBox;

public class Utilities {
	
	
	// let the user choose the location in the Geographic Information tab
	public static void geoLocationSet(final int index) {
		Asmm_eufar.rootLogger.log(Level.INFO, "Selection of a localisation in progress...");
		if (index == 0) {
			Asmm_eufar.geoDetailLst.clear();
			Asmm_eufar.geoDetailLst.setEnabled(false);
		}
		else {
			Asmm_eufar.geoDetailLst.clear();
			Asmm_eufar.geoDetailLst.setEnabled(true);
			if (index == 1) {
				populateListBox(Asmm_eufar.geoDetailLst, Asmm_eufar.continentList, 0);
			} else if (index == 2) {
				populateListBox(Asmm_eufar.geoDetailLst, Asmm_eufar.countryList, 0);
			} else if (index == 3) {
				populateListBox(Asmm_eufar.geoDetailLst, Asmm_eufar.oceanList, 0);
			} else if (index == 4) {
				populateListBox(Asmm_eufar.geoDetailLst, Asmm_eufar.regionList, 0);
			}
			Asmm_eufar.rootLogger.log(Level.INFO, "Localisation selected.");
		}
	}
	
	
	// populate easily each List Box
	public static void populateListBox(ListBox listBox, ArrayList<String> list, int defaultItem) {
		Asmm_eufar.rootLogger.log(Level.INFO, "Populating " + listBox.getName() + " in progress...");
		for (int i=0; i<list.size(); i++) {
			listBox.addItem(list.get(i));
		}
		listBox.setItemSelected(defaultItem, true);
		Asmm_eufar.rootLogger.log(Level.INFO, "Populating finished");
	}
	

	// find the correct text and index in a List Box from an entry in an xml file
	public static void checkList(TreeMap<String, String> treeMap, String string, ListBox listBox) {
		Asmm_eufar.rootLogger.log(Level.INFO, "Link between listbox and treeMap invoked...");
		String key = new String();
		for (Entry<String, String> entry : treeMap.entrySet()) {
			if (entry.getValue().equals(string)) {
				key = entry.getKey();
				break;
			}
		}
		int indexToFind = -1;
		for (int i = 0; i < listBox.getItemCount(); i++) {
			if (listBox.getItemText(i).equals(key)) {
				indexToFind = i;
				break;
			}
		}
		listBox.setSelectedIndex(indexToFind);
	}


	// find the correct check box in a panel, and tick or untick it, from an entry in an xml file
	public static void checkBox(ScrollPanel scrollPanel, TreeMap<String, String> treeMap, String string) {
		Asmm_eufar.rootLogger.log(Level.INFO, "Link between checkbox and treeMap invoked...");
		List<CheckBox> allCheckBox = $("*", scrollPanel).widgets(CheckBox.class);
		String key = new String();
		for (Entry<String, String> entry : treeMap.entrySet()) {
			if (entry.getValue().equals(string)) {
				key = entry.getKey(); 
				break;
			}
		}
		for (int i = 0; i < allCheckBox.size(); i = i + 2) {
			if (allCheckBox.get(i).getName() == key) {
				allCheckBox.get(i).setValue(true);
			}
		}
	}
	
	
	// modify the window title to add " - modified"
	public static void docIsModified() {
		Asmm_eufar.isModified = true;
		Asmm_eufar.titleString = "ASMM Creator - modified";
		Window.setTitle(Asmm_eufar.titleString);
	}


	// modify the window title to remove " - modified"
	public static void docNotModorSaved() {
		Asmm_eufar.isModified = false;
		Asmm_eufar.titleString = "ASMM Creator";
		Window.setTitle(Asmm_eufar.titleString);
	}
	
	
	// modify the window title to add " - saved"
	public static void docIsSaved() {
		Asmm_eufar.isModified = false;
		Asmm_eufar.titleString = "ASMM Creator - saved";
		Window.setTitle(Asmm_eufar.titleString);
	}


	// obtain screen width
	public static native int getScreenWidth()/*-{
		return screen.width;
	}-*/;


	// obtain screen height
	public static native int getScreenHeight()/*-{
		return screen.height;
	}-*/;
	
	
	// clear all fields
	public static void clearFields() {
		Asmm_eufar.rootLogger.log(Level.INFO, "Cleaning all fields in progress...");
		runCheckDefault();
		List<TextBox> allTextBox = $("*", Asmm_eufar.subDockPanel).widgets(TextBox.class);
		List<TextArea> allTextArea = $("*", Asmm_eufar.subDockPanel).widgets(TextArea.class);
		List<CheckBox> allCheckBox = $("*", Asmm_eufar.subDockPanel).widgets(CheckBox.class);
		for (int i = 0; i < allTextBox.size(); i++) {
			allTextBox.get(i).setText("");
		}
		for (int i = 0; i < allTextArea.size(); i++) {
			allTextArea.get(i).setText("");
		}
		for (int i = 0; i < allCheckBox.size(); i = i + 1) {
			allCheckBox.get(i).setValue(false);
		}
		Asmm_eufar.fi_dateText.setValue(new Date());
		Asmm_eufar.ci_roleText.setSelectedIndex(0);
		Asmm_eufar.so_groundSitesList.clear();
		Asmm_eufar.so_groundSitesTable.removeAllRows();
		Asmm_eufar.so_researchVesselsList.clear();
		Asmm_eufar.so_researchVesselsTable.removeAllRows();
		Asmm_eufar.so_armSitesList.clear();
		Asmm_eufar.so_armSitesTable.removeAllRows();
		Asmm_eufar.so_mobileSitesList.clear();
		Asmm_eufar.so_mobileSitesTable.removeAllRows();
		Asmm_eufar.sa_addCatMap.clear();
		Asmm_eufar.sa_addCatTable.removeAllRows();
		int numWidget = Asmm_eufar.verticalPanel67.getWidgetCount();
		if (numWidget > 1) {
			Asmm_eufar.verticalPanel67.remove(1);
			Asmm_eufar.verticalPanel67.remove(1);
		}
		Asmm_eufar.gi_addCatMap.clear();
		Asmm_eufar.gi_addCatTable.removeAllRows();
		numWidget = Asmm_eufar.verticalPanel68.getWidgetCount();
		if (numWidget > 1) {
			Asmm_eufar.verticalPanel68.remove(1);
			Asmm_eufar.verticalPanel68.remove(1);
		}
		Asmm_eufar.af_addCatMap.clear();
		Asmm_eufar.af_addCatTable.removeAllRows();
		numWidget = Asmm_eufar.verticalPanel69.getWidgetCount();
		if (numWidget > 1) {
			Asmm_eufar.verticalPanel69.remove(1);
			Asmm_eufar.verticalPanel69.remove(1);
		}
		Asmm_eufar.ct_addCatMap.clear();
		Asmm_eufar.ct_addCatTable.removeAllRows();
		numWidget = Asmm_eufar.verticalPanel70.getWidgetCount();
		if (numWidget > 1) {
			Asmm_eufar.verticalPanel70.remove(1);
			Asmm_eufar.verticalPanel70.remove(1);
		}
		Asmm_eufar.cp_addCatMap.clear();
		Asmm_eufar.cp_addCatTable.removeAllRows();
		numWidget = Asmm_eufar.verticalPanel71.getWidgetCount();
		if (numWidget > 1) {
			Asmm_eufar.verticalPanel71.remove(1);
			Asmm_eufar.verticalPanel71.remove(1);
		}
		Asmm_eufar.lo_addCatMap.clear();
		Asmm_eufar.lo_addCatTable.removeAllRows();
		numWidget = Asmm_eufar.verticalPanel72.getWidgetCount();
		if (numWidget > 1) {
			Asmm_eufar.verticalPanel72.remove(1);
			Asmm_eufar.verticalPanel72.remove(1);
		}
		Asmm_eufar.ar_addCatMap.clear();
		Asmm_eufar.ar_addCatTable.removeAllRows();
		numWidget = Asmm_eufar.verticalPanel73.getWidgetCount();
		if (numWidget > 1) {
			Asmm_eufar.verticalPanel73.remove(1);
			Asmm_eufar.verticalPanel73.remove(1);
		}
		Asmm_eufar.fm_addCatMap.clear();
		Asmm_eufar.fm_addCatTable.removeAllRows();
		numWidget = Asmm_eufar.verticalPanel74.getWidgetCount();
		if (numWidget > 1) {
			Asmm_eufar.verticalPanel74.remove(1);
			Asmm_eufar.verticalPanel74.remove(1);
		}
		Asmm_eufar.sc_addCatMap.clear();
		Asmm_eufar.sc_addCatTable.removeAllRows();
		numWidget = Asmm_eufar.verticalPanel75.getWidgetCount();
		if (numWidget > 1) {
			Asmm_eufar.verticalPanel75.remove(1);
			Asmm_eufar.verticalPanel75.remove(1);
		}
		Asmm_eufar.fi_operatorText.setSelectedIndex(0);
		Asmm_eufar.fi_aircraftText.clear();
		Asmm_eufar.fi_aircraftText.setEnabled(false);
		if (Asmm_eufar.horizontalPanel26.getWidgetCount() > 1) {
			Asmm_eufar.horizontalPanel26.remove(1);
			Asmm_eufar.horizontalPanel27.remove(1);
			Asmm_eufar.fiGrid.remove(Asmm_eufar.fi_otherOpsText);
			Asmm_eufar.fiGrid.remove(Asmm_eufar.fi_otherAiText);
		}
		Asmm_eufar.geoLocationLst.setSelectedIndex(0);
		Utilities.geoLocationSet(0);
		Asmm_eufar.imageTab.removeAllRows();
		Asmm_eufar.imageCaption.clear();
		Asmm_eufar.imagePath.clear();
		Utilities.docNotModorSaved();
		Asmm_eufar.rootLogger.log(Level.INFO, "Cleaning all fields finished.");
	}
	
	
	// add element to a list and a widget
	public static SimplePanel addListButton(final FlexTable flexTable, final TextBox widget, final ArrayList<String> itemList) {
		final Image image = new Image("icons/plus_icon.png");
		final SimplePanel addButton = new SimplePanel(image);
		addButton.setPixelSize(25, 25);
		addButton.setStyleName("infoButton");
		widget.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					if (widget.getText() == "") {
						Asmm_eufar.rootLogger.log(Level.INFO, "No name entered...");
						return;
					}
					Asmm_eufar.rootLogger.log(Level.INFO, "Item added to list (keyboard): " + widget.getText() + " / " + widget.getName());
					Utilities.docIsModified();
					final String widgetText = widget.getText();
					final int row = flexTable.getRowCount();
					final Image image = new Image("icons/del_icon.png");
					final SimplePanel delButton = new SimplePanel(image);
					final Label label = new Label(widgetText);
					itemList.add(widgetText);
					widget.setText("");
					delButton.setPixelSize(25, 25);
					delButton.setStyleName("infoButton");
					label.setStyleName("so_tableTextLabel");
					flexTable.insertRow(row);
					flexTable.setWidget(row, 0, label);
					flexTable.setWidget(row, 1, delButton);
					flexTable.getFlexCellFormatter().setHorizontalAlignment(row, 1, HasHorizontalAlignment.ALIGN_RIGHT);
					image.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							Asmm_eufar.rootLogger.log(Level.INFO, "Item will be removed from list: " + widgetText);
							Utilities.docIsModified();
							int removedIndex = itemList.indexOf(widgetText);
							itemList.remove(removedIndex);
							flexTable.removeRow(removedIndex);
							Asmm_eufar.rootLogger.log(Level.INFO, "Item removed from list");
						}
					});
					Asmm_eufar.rootLogger.log(Level.INFO, "Item added to list (keyboard)");
				}
			}
		});
		addButton.setStyleName("infoButton");
		image.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (widget.getText() == "") {
					return;
				}
				Asmm_eufar.rootLogger.log(Level.INFO, "Item proposed to list (mouse): " + widget.getText() + " / " + widget.getName());
				Utilities.docIsModified();
				final String widgetText = widget.getText();
				final int row = flexTable.getRowCount();
				final Image image = new Image("icons/del_icon.png");
				final SimplePanel delButton = new SimplePanel(image);
				final Label label = new Label(widgetText);
				itemList.add(widgetText);
				widget.setText("");
				delButton.setPixelSize(25, 25);
				delButton.setStyleName("infoButton");
				label.setStyleName("so_tableTextLabel");
				flexTable.insertRow(row);
				flexTable.setWidget(row, 0, label);
				flexTable.setWidget(row, 1, delButton);
				flexTable.getFlexCellFormatter().setHorizontalAlignment(row, 1, HasHorizontalAlignment.ALIGN_RIGHT);
				image.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						Asmm_eufar.rootLogger.log(Level.INFO, "Item will be removed from list: " + widgetText);
						Utilities.docIsModified();
						int removedIndex = itemList.indexOf(widgetText);
						itemList.remove(removedIndex);
						flexTable.removeRow(removedIndex);
						Asmm_eufar.rootLogger.log(Level.INFO, "Item removed from list");
					}
				});
				Asmm_eufar.rootLogger.log(Level.INFO, "Item added to list (mouse)");
			}
		});
		return addButton;
	}
	
	
	// see above, but dedicated to the read function
	public static void addList(final FlexTable flexTable, final String string, final ArrayList<String> itemList) {
		Asmm_eufar.rootLogger.log(Level.INFO, "Item proposed to list (xmlfile): " + string);
		final int row = flexTable.getRowCount();
		final PushButton delButton = new PushButton(Resources.smallImage("del"));
		final Label label = new Label(string);
		itemList.add(string);
		delButton.setPixelSize(25, 25);
		delButton.setStyleName("infoButton");
		label.setStyleName("so_tableTextLabel");
		flexTable.insertRow(row);
		flexTable.setWidget(row, 0, label);
		flexTable.setWidget(row, 1, delButton);
		flexTable.getFlexCellFormatter().setHorizontalAlignment(row, 1, HasHorizontalAlignment.ALIGN_RIGHT);
		delButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Asmm_eufar.rootLogger.log(Level.INFO, "Item will be removed from list: " + string);
				Utilities.docIsModified();
				int removedIndex = itemList.indexOf(string);
				itemList.remove(removedIndex);
				flexTable.removeRow(removedIndex);
				Asmm_eufar.rootLogger.log(Level.INFO, "Item removed from list");
			}
		});
		Asmm_eufar.rootLogger.log(Level.INFO, "Item added to list (xmlfile)");
	}
	
	
	// put all labels and text to default color and position
	public static void runCheckDefault() {
		Asmm_eufar.rootLogger.log(Level.INFO, "Default display before check in progress...");
		boolean otherOpsState = Asmm_eufar.fi_otherOpsText.isVisible();
		List<Label> allLabel = $("*", Asmm_eufar.subDockPanel).widgets(Label.class);
		List<TextBoxBase> allBox = $("*", Asmm_eufar.subDockPanel).widgets(TextBoxBase.class);
		List<DateBox> allDateBox = $("*", Asmm_eufar.subDockPanel).widgets(DateBox.class);
		List<ListBox> allListBox = $("*", Asmm_eufar.subDockPanel).widgets(ListBox.class);
		for (int i = 0; i < allLabel.size(); i++) {
			String style = allLabel.get(i).getStylePrimaryName();
			allLabel.get(i).getElement().setAttribute("style","");
			allLabel.get(i).setStyleName(style);
		}
		for (int i = 0; i < allBox.size(); i++) {
			String style = allBox.get(i).getStylePrimaryName();
			allBox.get(i).getElement().setAttribute("style","");
			allBox.get(i).setStyleName(style);
		}
		for (int i = 0; i < allDateBox.size(); i++) {
			String style = allDateBox.get(i).getStylePrimaryName();
			allDateBox.get(i).getElement().setAttribute("style","");
			allDateBox.get(i).setStyleName(style);
		}
		for (int i = 0; i < allListBox.size(); i++) {
			String style = allListBox.get(i).getStylePrimaryName();
			allListBox.get(i).getElement().setAttribute("style","");
			allListBox.get(i).setStyleName(style);
		}
		Asmm_eufar.fi_otherOpsText.setVisible(otherOpsState);
		Asmm_eufar.fi_otherAiText.setVisible(otherOpsState);
		Asmm_eufar.fi_dateText.getElement().setAttribute("Style","margin-left: 20px !important;");
		for (int i = 0; i < 9; i++) {
			Asmm_eufar.tabPanel.getTabWidget(i).getElement().setAttribute("style","color: white !important;");
		}
		Asmm_eufar.rootLogger.log(Level.INFO, "Default display set.");
	}
}
