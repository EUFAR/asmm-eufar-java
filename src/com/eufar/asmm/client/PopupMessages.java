package com.eufar.asmm.client;

import java.util.logging.Level;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;

public class PopupMessages {
	
	public enum infoEnum{NEWCHECKBOX;}
	
	
	// create a popup panel displaying a changelog
	public static void changelogPanel() {
		final DialogBox myOpenDialog = new DialogBox();
		final ScrollPanel scrollPanel = new ScrollPanel();
		final VerticalPanel verticalPanel = new VerticalPanel();
		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		final HTML label = new HTML(logText());
		final Button okButton = new Button("Ok");
		final Image image = Resources.popupImage("changelog");
		okButton.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				myOpenDialog.hide();
			}
		});
		verticalPanel.add(horizontalPanel);
		horizontalPanel.add(image);
		horizontalPanel.add(scrollPanel);
		myOpenDialog.add(verticalPanel);
		myOpenDialog.setGlassEnabled(true);
		scrollPanel.add(label);
		scrollPanel.setHeight("500px");
		scrollPanel.setWidth("700px");
		image.getElement().setAttribute("style", "margin-right: 10px !important;");
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(okButton);
		okButton.getElement().setAttribute("style", "font-family: MyFontBold !important; margin-top: "
				+ "10px !important; font-size: 14px !important;");
		verticalPanel.getElement().setAttribute("style", "margin: 10px;");
		myOpenDialog.setSize("700px", "500px");
		myOpenDialog.setStyleName("myUploadBox");
		myOpenDialog.setModal(true);
		myOpenDialog.center();
	}
	
	
	// Popup to warn the user with Internet Explorer
	public static void explorerPanel() {
		final DialogBox aboutDialog = new DialogBox();
		final VerticalPanel verticalPanel01 = new VerticalPanel();
		final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
		final HTML label = new HTML("ASMM has detected that you are using Internet Explorer.<br><br>ASMM has been deeply tested on Firefox, "
				+ "Internet Explorer, Chrome and Opera. However, it presents serious compatibility issues with Internet Explorer, which prevent "
				+ "a proper use of the following functions: save or open a document, print a report, upload images.<br><br>We strongly recommend "
				+ "that you use a different browser to ensure the proper functioning of ASMM.");
		final Button button = new Button("Ok");
		button.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				aboutDialog.hide();
			}
		});
		aboutDialog.setGlassEnabled(true);
		horizontalPanel01.add(Resources.popupImage("warning"));
		horizontalPanel01.add(label);
		verticalPanel01.add(horizontalPanel01);
		verticalPanel01.add(button);
		aboutDialog.add(verticalPanel01);
		label.setStyleName("popupText");
		verticalPanel01.getElement().setAttribute("style", "margin-left: 10px !important; margin-top: 10px !important; margin-right: 10px "
				+ "!important;");
		button.getElement().setAttribute("style", "margin-left: 220px !important; font-family: MyFontBold !important; margin-top: 20px "
				+ "!important; font-size: 14px !important;");
		aboutDialog.setSize( "500px", "180px" );
		aboutDialog.setStyleName("myUploadBox");
		aboutDialog.setModal(true);
		aboutDialog.center();
		aboutDialog.show();
	}
	
	
	// display a warning to change the layout 
	public static void layoutPanel() {
		final DialogBox myOpenDialog = new DialogBox();
		final VerticalPanel verticalPanel01 = new VerticalPanel();
		final VerticalPanel verticalPanel02 = new VerticalPanel();
		final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
		final HorizontalPanel horizontalPanel02 = new HorizontalPanel();
		final Label label = new Label("You have the possibility to change the global layout to a browser-like horizontal layout. Once the new "
				+ "layout is selected, you have to reload EMC to revert back to the original layout.");
		final Button submitButton = new Button("Ok");
		final Button cancelButton = new Button("Cancel");
		submitButton.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				myOpenDialog.hide();
				GuiModification.changeLayout();
			}
		});
		cancelButton.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				myOpenDialog.hide();
			}
		});
		myOpenDialog.setGlassEnabled(true);
		myOpenDialog.add(verticalPanel02);
		verticalPanel02.add(horizontalPanel01);
		horizontalPanel01.add(Resources.popupImage("preferences"));
		horizontalPanel01.add(verticalPanel01);
		verticalPanel01.add(label);
		horizontalPanel02.add(submitButton);
		horizontalPanel02.add(cancelButton);
		verticalPanel01.add(horizontalPanel02);
		label.setStyleName("popupText");
		myOpenDialog.setStyleName("myUploadBox");
		verticalPanel02.getElement().setAttribute("style", "margin-left: 10px !important; margin-top: 10px !important; margin-right: 10px "
				+ "!important;");
		submitButton.getElement().setAttribute("style", "margin-left:20px !important; font-family: MyFontBold !important; "
				+ "font-size: 14px !important;");
		cancelButton.getElement().setAttribute("style", "margin-left:120px !important; font-family: MyFontBold !important;");
		horizontalPanel02.getElement().setAttribute("style", "margin-top:30px !important; margin-bottom:20px !important;");
		myOpenDialog.setSize("350px", "130px");
		myOpenDialog.setModal(true);
		myOpenDialog.center();
	}
	
	
	// create a window with text dedicated to ASMM
	public static void aboutWindow() {
		Asmm_eufar.rootLogger.log(Level.INFO, "About ASMM invoked...");
		final DialogBox aboutDialog = new DialogBox();
		final VerticalPanel verticalPanel01 = new VerticalPanel();
		final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
		final HTML label = new HTML("The Airborne Science Mission Metadata (ASMM) Creator " + Asmm_eufar.asmmVersion + " online version, was "
				+ "developed by EUFAR using Eclipse " + Asmm_eufar.eclipseVersion + ", Google Web Toolkit " + Asmm_eufar.gwtVersion + " and Java "
				+ Asmm_eufar.javaVersion + ". XML files generated by this version conform to " + Asmm_eufar.xmlVersion + " of the ASMM XML "
				+ "standard. The opensource reporting library (" + Asmm_eufar.jasperVersion + ") used for PDF report generation is provided and "
				+ "owned by <a href=http://community.jaspersoft.com/project/jasperreports-library><span style=\" text-decoration: underline; "
				+ "color:#0000ff;\">JasperSoft</a>.<br><br>For more information, or to report a bug, please contact <a href='mailto:olivier."
				+ "henry.at.meteo.fr'><span style=\" text-decoration: underline; color:#0000ff;\">olivier.henry.at.meteo.fr</a>.<br><br>The "
				+ "latest offline version and source code of the ASMM Creator can be found at <a href=https://github.com/eufarn7sp/asmm-eufar-"
				+ "java><span style=\" text-decoration: underline; color:#0000ff;\">https://github.com/eufarn7sp/asmm-eufar-java</a>.");
		final Button button = new Button("Ok");
		button.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {aboutDialog.hide();}
		});
		aboutDialog.setGlassEnabled(true);
		horizontalPanel01.add(Resources.popupImage("about"));
		horizontalPanel01.add(label);
		verticalPanel01.add(horizontalPanel01);
		verticalPanel01.add(button);
		aboutDialog.add(verticalPanel01);
		label.setStyleName("popupText");
		aboutDialog.setStyleName("myUploadBox");
		verticalPanel01.getElement().setAttribute("style", "margin-left: 10px !important; margin-top: 10px !important; margin-right: 10px "
				+ "!important;");
		button.getElement().setAttribute("style", "margin-left: 220px !important; font-family: MyFontBold !important; margin-top: 20px "
				+ "!important; margin-bottom: 10px !important; font-size: 14px !important;");
		aboutDialog.setSize( "500px", "270px" );
		aboutDialog.setModal(true);
		aboutDialog.center();
		aboutDialog.show();
	}


	// create a window with text dedicated to ASMM XML standard
	public static void aboutStandard() {
		Asmm_eufar.rootLogger.log(Level.INFO, "About XML Standard invoked...");
		final DialogBox aboutDialog = new DialogBox();
		final VerticalPanel verticalPanel01 = new VerticalPanel();
		final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
		final HTML label = new HTML("The Airborne Science Mission Metadata (ASMM) standard aims to harmonise descriptive information of science "
				+ "research flights. This common description will allow users of the airborne science data to search datasets for specific "
				+ "meteorological conditions, geographical regions, cloud-types encountered, particles sampled, and other parameters not evident "
				+ "from the data itself.<br><br>For more information, please read the following document: <a href=https://github.com/eufarn7sp/asmm"
				+ "-eufar/blob/master/Documentation/ASMM%20-%20XML%20Implementation%20Rules.pdf><span style=\" text-decoration: underline; color"
				+ ":#0000ff;\">ASMM - XML Implementation Rules.pdf</a>");
		final Button button = new Button("Ok");
		button.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {aboutDialog.hide();}
		});
		aboutDialog.setGlassEnabled(true);
		horizontalPanel01.add(Resources.popupImage("xml"));
		horizontalPanel01.add(label);
		verticalPanel01.add(horizontalPanel01);
		verticalPanel01.add(button);
		aboutDialog.add(verticalPanel01);
		label.setStyleName("popupText");
		aboutDialog.setStyleName("myUploadBox");
		verticalPanel01.getElement().setAttribute("style", "margin-left: 10px !important; margin-top: 10px !important; margin-right: 10px "
				+ "!important;");
		button.getElement().setAttribute("style", "margin-left: 220px !important; font-family: MyFontBold !important; margin-top: 20px "
				+ "!important; margin-bottom: 10px !important; font-size: 14px !important;");
		aboutDialog.setSize( "500px", "140px" );
		aboutDialog.setModal(true);
		aboutDialog.center();
		aboutDialog.show();
	}

	
	// create a popup panel displaying an informative message
	public static void infoPanel(final String context, final PushButton infoButton) {
		final DialogBox infoDialog = new DialogBox();
		final VerticalPanel verticalPanel01 = new VerticalPanel();
		final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
		final Label label = addInfoText(context);
		final Button button = new Button("Ok");
		button.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				infoDialog.hide();
			}
		});
		infoDialog.setGlassEnabled(true);
		horizontalPanel01.add(Resources.popupImage("info"));
		horizontalPanel01.add(label);
		verticalPanel01.add(horizontalPanel01);
		verticalPanel01.add(button);
		infoDialog.add(verticalPanel01);
		label.setStyleName("popupText");
		infoDialog.setStyleName("myUploadBox");
		verticalPanel01.getElement().setAttribute("style","margin-left: 10px !important; margin-right: 10px !important; margin-top: 10px"
				+ " !important;");
		button.getElement().setAttribute("style", "margin-left: 145px !important; font-family: MyFontBold !important; margin-top: 20px "
				+ "!important; margin-bottom: 10px !important; font-size: 14px !important;");
		infoDialog.setSize( "350px", "50px" );
		infoDialog.setModal(true);
		infoDialog.center();
		infoDialog.showRelativeTo(infoButton);
	}
	
	
	// create a new file by cleaning all widgets
	public static void newFile() {
		Asmm_eufar.rootLogger.log(Level.INFO, "Cleaning function invoked... ");
		if (Asmm_eufar.isModified) {
			final DialogBox infoDialog = new DialogBox();
			final VerticalPanel verticalPanel01 = new VerticalPanel();
			final VerticalPanel verticalPanel02 = new VerticalPanel();
			final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
			final HorizontalPanel horizontalPanel02 = new HorizontalPanel();
			final Label label = new Label("The actual document has been modified. Changes will be lost if the document is not saved.");
			final Label label2 = new Label("Do you want to save your changes?");
			final Button saveButton = new Button("Save");
			final Button cancelButton = new Button("Cancel");
			final Button createButton = new Button("Clear without saving");	
			saveButton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					infoDialog.hide();
					PopupMessages.saveFile("clear");
				}
			});
			cancelButton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					infoDialog.hide();
				}
			});
			createButton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					infoDialog.hide();
					Utilities.clearFields();
				}
			});
			infoDialog.setGlassEnabled(true);
			horizontalPanel01.add(Resources.popupImage("warning"));
			verticalPanel02.add(label);
			verticalPanel02.add(label2);
			horizontalPanel01.add(verticalPanel02);
			verticalPanel01.add(horizontalPanel01);
			horizontalPanel02.add(saveButton);
			horizontalPanel02.add(cancelButton);
			horizontalPanel02.add(createButton);
			verticalPanel01.add(horizontalPanel02);
			infoDialog.add(verticalPanel01);
			infoDialog.setStyleName("myUploadBox");
			verticalPanel01.getElement().setAttribute("style", "margin-left: 10px !important; margin-top: 10px !important; margin-right: 10px "
					+ "!important;");
			label2.getElement().setAttribute("style", "margin-top: 20px !important; margin-bottom: 20px !important; text-decoration: "
					+ "underline !important; font-weight: bold !important;");
			saveButton.getElement().setAttribute("style", "margin-left: 20px !important; font-family: MyFontBold !important; margin-top: "
					+ "10px !important; font-size: 14px !important;");
			cancelButton.getElement().setAttribute("style", "margin-left: 40px !important; font-family: MyFontBold !important;"
					+ " margin-top: 10px !important; font-size: 14px !important;");
			createButton.getElement().setAttribute("style", "margin-left: 20px !important; font-family: MyFontBold !important;"
					+ " margin-top: 10px !important; height: 30px !important; width: 180px !important; "
					+ "font-size: 14px !important;");
			infoDialog.setSize( "130px", "180px" );
			infoDialog.setModal(true);
			infoDialog.center();
			infoDialog.show();
		} else {
			Utilities.clearFields();
		}
	}
	
	
	// open an existing xml file - 1
	public static void openFile() {
		Asmm_eufar.rootLogger.log(Level.INFO, "Opening function invoked...");
		if (Asmm_eufar.isModified) {
			final DialogBox infoDialog = new DialogBox();
			final VerticalPanel verticalPanel01 = new VerticalPanel();
			final VerticalPanel verticalPanel02 = new VerticalPanel();
			final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
			final HorizontalPanel horizontalPanel02 = new HorizontalPanel();
			final Label label = new Label("The actual document has been modified. Changes will be lost if the document is not saved.");
			final Label label2 = new Label("Do you want to save your changes?");
			final Button saveButton = new Button("Save");
			final Button cancelButton = new Button("Cancel");
			final Button createButton = new Button("Open without saving");
			saveButton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					infoDialog.hide();
					PopupMessages.saveFile("open");
				}
			});
			cancelButton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					infoDialog.hide();
				}
			});
			createButton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					infoDialog.hide();
					openAction();
				}
			});
			infoDialog.setGlassEnabled(true);
			horizontalPanel01.add(Resources.popupImage("warning"));
			verticalPanel02.add(label);
			verticalPanel02.add(label2);
			horizontalPanel01.add(verticalPanel02);
			verticalPanel01.add(horizontalPanel01);
			horizontalPanel02.add(saveButton);
			horizontalPanel02.add(cancelButton);
			horizontalPanel02.add(createButton);
			verticalPanel01.add(horizontalPanel02);
			infoDialog.add(verticalPanel01);
			infoDialog.setStyleName("myUploadBox");
			verticalPanel01.getElement().setAttribute("style", "margin-left: 10px !important; margin-top: 10px !important; margin-right: 10px "
					+ "!important;");
			label2.getElement().setAttribute("style", "margin-top: 20px !important; margin-bottom: 20px !important; text-decoration: "
					+ "underline !important; font-weight: bold !important;");
			saveButton.getElement().setAttribute("style", "margin-left: 20px !important; font-family: MyFontBold !important; margin-top: "
					+ "10px !important; font-size: 14px !important;");
			cancelButton.getElement().setAttribute("style", "margin-left: 40px !important; font-family: MyFontBold !important;"
					+ " margin-top: 10px !important; font-size: 14px !important;");
			createButton.getElement().setAttribute("style", "margin-left: 20px !important; font-family: MyFontBold !important;"
					+ " margin-top: 10px !important; height: 30px !important; width: 180px !important; "
					+ "font-size: 14px !important;");
			infoDialog.setSize( "130px", "180px" );
			infoDialog.setModal(true);
			infoDialog.center();
			infoDialog.show();
		} else {
			openAction();
		}
	}
	
	
	// open an existing xml file - 1
	public static void openAction() {
		final DialogBox myOpenDialog = new DialogBox();
		final FileUpload myFileUpload = new FileUpload();
		final FormPanel myUploadForm = new FormPanel();
		final VerticalPanel verticalPanel01 = new VerticalPanel();
		final VerticalPanel verticalPanel02 = new VerticalPanel();
		final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
		final HorizontalPanel horizontalPanel02 = new HorizontalPanel();
		final Label label = new Label("Please select a file.");
		final Button submitButton = new Button("Open");
		final Button cancelButton = new Button("Cancel/Close");
		submitButton.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				if (myFileUpload.getFilename().length() == 0) {
					Asmm_eufar.rootLogger.log(Level.INFO, "No file selected...");
					return;
				} else {
					Asmm_eufar.myFileName = myFileUpload.getFilename();
					myUploadForm.submit();
					Utilities.clearFields();
				}
			}
		});
		cancelButton.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				Asmm_eufar.rootLogger.log(Level.INFO, "Load of a file canceled");
				myOpenDialog.hide();
			}
		});
		myOpenDialog.setGlassEnabled(true);
		myOpenDialog.add(verticalPanel02);
		verticalPanel02.add(horizontalPanel01);
		horizontalPanel01.add(Resources.popupImage("open"));
		horizontalPanel01.add(verticalPanel01);
		verticalPanel01.add(label);
		myFileUpload.setName("uploadFormElement");
		myFileUpload.getElement().setId("uploadFormElement");
		myFileUpload.getElement().setId("myFile");
		myFileUpload.getElement().setAttribute("accept", "xml");
		verticalPanel01.add(myFileUpload);
		myUploadForm.setAction(Asmm_eufar.asmmPath + "/upload");
		myUploadForm.setEncoding(FormPanel.ENCODING_MULTIPART);
		myUploadForm.setMethod(FormPanel.METHOD_POST);
		myUploadForm.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
			@Override
			public void onSubmitComplete(SubmitCompleteEvent event) {
				Asmm_eufar.rootLogger.log(Level.INFO, "Submission completed");
				myOpenDialog.hide();
				String ret = "";
				try {
					if (ret.contains("format")) {
						Window.alert("The file format is not supported. The file couldn't be uploaded.");
						return;
					}
					ret = event.getResults();
					ret = ret.replaceAll("\t", "").replace("\n", "");
				} catch (Exception ex) {
					Asmm_eufar.rootLogger.log(Level.SEVERE, "a problem occured after submission completed: ", ex);
				}
				xmlOpen.readXml(ret);
			}			
		});		
		myUploadForm.add(verticalPanel02);
		horizontalPanel02.add(submitButton);
		horizontalPanel02.add(cancelButton);
		verticalPanel01.add(horizontalPanel02);
		myOpenDialog.add(myUploadForm);
		myOpenDialog.setStyleName("myUploadBox");
		myFileUpload.getElement().setAttribute("style", "margin-left:20px !important;");
		verticalPanel02.getElement().setAttribute("style", "margin-left: 5px !important; margin-top: 10px !important; margin-right: 10px "
				+ "!important;");
		verticalPanel01.getElement().setAttribute("style", "margin-right:20px !important;");
		label.getElement().setAttribute("style", "margin-right:20px !important; margin-bottom:30px !important; margin-top:10px !important;");

		submitButton.getElement().setAttribute("style", "margin-left:20px !important; font-family: MyFontBold !important; font-size: "
				+ "14px !important;");
		cancelButton.getElement().setAttribute("style", "margin-left:75px !important; font-family: MyFontBold !important; font-size: "
				+ "14px !important;");
		horizontalPanel02.getElement().setAttribute("style", "margin-top:30px !important; margin-bottom:20px !important;");
		myOpenDialog.setSize( "130px", "180px" );
		myOpenDialog.setModal(true);
		myOpenDialog.center();
	}
	
	
	// save an xml file
	public static void saveFile(final String string) {
		Asmm_eufar.rootLogger.log(Level.INFO, "Saving function invoked...");
		final DialogBox mySaveDialog = new DialogBox();
		final VerticalPanel verticalPanel01 = new VerticalPanel();	
		final VerticalPanel verticalPanel02 = new VerticalPanel();
		final VerticalPanel verticalPanel03 = new VerticalPanel();
		final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
		final HorizontalPanel horizontalPanel02 = new HorizontalPanel();
		final TextArea xmlTree = new TextArea();
		final TextBox fileName = new TextBox();
		final TextBox filebox = new TextBox();
		final Label label = new Label("Please enter a name to save the XML file.");
		final FormPanel myForm = new FormPanel();
		final Button cancelButton = new Button("Cancel/Close");
		final Button submitButton = new Button("Save");
		cancelButton.addClickHandler(new ClickHandler () {
			@Override
			public void onClick(ClickEvent event) {
				mySaveDialog.hide();
				if (string == "open") {
					openAction();
				} else if (string =="clear") {
					Utilities.clearFields();
				} else if (string == "exit") {
					Window.open("http://www.eufar.net", "_self", "");
				}
			}
		});
		submitButton.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				if (fileName.getText() == "") {
					Asmm_eufar.rootLogger.log(Level.INFO, "No filename entered...");
					return;
				} else {
					Asmm_eufar.myFileName = fileName.getText();
					if (!Asmm_eufar.myFileName.toLowerCase().endsWith(".xml")) {
						Asmm_eufar.myFileName = Asmm_eufar.myFileName + ".xml";
					}
					filebox.setText(Asmm_eufar.myFileName);
					myForm.submit();
					Utilities.docNotModified();
					if (string == "clear") {
						Utilities.clearFields();
					}
				}
			}
		});
		fileName.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					if (fileName.getText() == "") {
						Asmm_eufar.rootLogger.log(Level.INFO, "No filename entered...");
						return;
					} else {
						Asmm_eufar.myFileName = fileName.getText();
						if (!Asmm_eufar.myFileName.toLowerCase().endsWith(".xml")) {
							Asmm_eufar.myFileName = Asmm_eufar.myFileName + ".xml";
						}
						filebox.setText(Asmm_eufar.myFileName);
						myForm.submit();
						Utilities.docNotModified();
						if (string == "clear") {
							Utilities.clearFields();
						}
					}
				}
			}
		});
		mySaveDialog.setGlassEnabled(true);
		verticalPanel03.add(horizontalPanel02);
		horizontalPanel02.add(Resources.popupImage("save"));
		horizontalPanel02.add(verticalPanel02);
		xmlTree.setText(xmlSave.createXml());
		xmlTree.setName("xmltree");
		verticalPanel01.add(xmlTree);
		verticalPanel02.add(label);
		fileName.setText(Asmm_eufar.myFileName);
		verticalPanel02.add(fileName);
		Asmm_eufar.myFileName = fileName.getText();
		if (!Asmm_eufar.myFileName.toLowerCase().endsWith(".xml")) {
			Asmm_eufar.myFileName = Asmm_eufar.myFileName + ".xml";
		}
		filebox.setName("filename");
		verticalPanel01.add(filebox);
		myForm.setAction(Asmm_eufar.asmmPath + "/download");
		myForm.setMethod(FormPanel.METHOD_POST);
		myForm.add(verticalPanel01);
		myForm.setVisible(false);
		horizontalPanel01.add(submitButton);
		horizontalPanel01.add(cancelButton);
		verticalPanel02.add(myForm);	
		verticalPanel03.add(horizontalPanel01);
		mySaveDialog.add(verticalPanel03);	
		fileName.setStyleName("gi_textBox");
		mySaveDialog.setStyleName("myUploadBox");
		verticalPanel03.getElement().setAttribute("style", "margin-left: 5px !important; margin-top: 10px !important; margin-right: 10px "
				+ "!important;");
		label.getElement().setAttribute("style", "margin-right:20px !important; margin-bottom:30px !important; margin-top:10px !important;");
		fileName.getElement().setAttribute("style", "width:230px !important; margin-left: 20px !important;");
		submitButton.getElement().setAttribute("style", "margin-left:88px !important; font-family: MyFontBold !important; font-size: "
				+ "14px !important;");
		cancelButton.getElement().setAttribute("style", "margin-left:70px !important; font-family: MyFontBold !important; font-size: "
				+ "14px !important;");
		horizontalPanel01.getElement().setAttribute("style", "margin-top:30px !important; margin-bottom:20px !important;");
		mySaveDialog.setSize( "370px", "180px" );
		mySaveDialog.setModal(true);
		mySaveDialog.center();
		fileName.setFocus(true);
	}

	
	// print a report based on user inputs
	public static void printFile() {
		Asmm_eufar.rootLogger.log(Level.INFO, "Printing function invoked...");
		final DialogBox mySaveDialog = new DialogBox();
		final VerticalPanel verticalPanel01 = new VerticalPanel();	
		final VerticalPanel verticalPanel02 = new VerticalPanel();
		final VerticalPanel verticalPanel03 = new VerticalPanel();
		final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
		final HorizontalPanel horizontalPanel02 = new HorizontalPanel();
		final HTML label = new HTML("Please enter a name to save the PDF file.<br>Depending on your network connexion and, the size and/or "
				+ "number of the uploaded image(s), the download of the PDF report may take some time.");
		final TextBox fileName = new TextBox();
		final TextBox filebox = new TextBox();
		final FormPanel myForm = new FormPanel();
		final Button cancelButton = new Button("Cancel/Close");
		final Button submitButton = new Button("Print");
		cancelButton.addClickHandler(new ClickHandler () {
			@Override
			public void onClick(ClickEvent event) {
				mySaveDialog.hide();
			}
		});
		submitButton.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				if (fileName.getText() == "") {
					Asmm_eufar.rootLogger.log(Level.INFO, "No filename entered...");
					return;
				} else {
					verticalPanel01.clear();
					verticalPanel01.add(filebox);
					pdfSave.createPrint(verticalPanel01);
					Asmm_eufar.myPDFName = fileName.getText();
					if (!Asmm_eufar.myPDFName.toLowerCase().endsWith(".pdf")) {
						Asmm_eufar.myPDFName = Asmm_eufar.myPDFName + ".pdf";
					}
					filebox.setText(Asmm_eufar.myPDFName);
					myForm.submit();
					Utilities.docNotModified();
				}
			}
		});
		fileName.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					if (fileName.getText() == "") {
						Asmm_eufar.rootLogger.log(Level.INFO, "No filename entered...");
						return;
					} else {
						verticalPanel01.clear();
						verticalPanel01.add(filebox);
						pdfSave.createPrint(verticalPanel01);
						Asmm_eufar.myPDFName = fileName.getText();
						if (!Asmm_eufar.myPDFName.toLowerCase().endsWith(".pdf")) {
							Asmm_eufar.myPDFName = Asmm_eufar.myPDFName + ".pdf";
						}
						filebox.setText(Asmm_eufar.myPDFName);
						myForm.submit();
						Utilities.docNotModified();
					}
				}
			}
		});
		filebox.setName("filename");
		mySaveDialog.setGlassEnabled(true);
		verticalPanel03.add(horizontalPanel02);
		horizontalPanel02.add(Resources.popupImage("print"));
		horizontalPanel02.add(verticalPanel02);
		verticalPanel02.add(label);
		verticalPanel02.add(fileName);
		Asmm_eufar.myPDFName = fileName.getText();
		if (!Asmm_eufar.myPDFName.toLowerCase().endsWith(".pdf")) {
			Asmm_eufar.myPDFName = Asmm_eufar.myPDFName + ".pdf";
		}
		myForm.setAction(Asmm_eufar.asmmPath + "/print");
		myForm.setMethod(FormPanel.METHOD_POST);
		myForm.add(verticalPanel01);
		myForm.setVisible(false);
		horizontalPanel01.add(submitButton);
		horizontalPanel01.add(cancelButton);
		verticalPanel02.add(myForm);	
		verticalPanel03.add(horizontalPanel01);
		mySaveDialog.add(verticalPanel03);	
		mySaveDialog.setStyleName("myUploadBox");
		label.setStyleName("gwt-Label");
		fileName.setStyleName("gi_textBox");
		verticalPanel03.getElement().setAttribute("style", "margin-left: 5px !important; margin-top: 10px !important; margin-right: 10px "
				+ "!important;");
		label.getElement().setAttribute("style", "margin-right:20px !important; margin-bottom:30px !important; margin-top:10px !important;");
		fileName.getElement().setAttribute("style", "width:230px !important; margin-left: 20px !important;");
		submitButton.getElement().setAttribute("style", "margin-left:88px !important; font-family: MyFontBold !important; font-size: "
				+ "14px !important;");
		cancelButton.getElement().setAttribute("style", "margin-left:65px !important; font-family: MyFontBold !important; font-size: "
				+ "14px !important;");
		horizontalPanel01.getElement().setAttribute("style", "margin-top:30px !important; margin-bottom:20px !important;");
		mySaveDialog.setSize( "370px", "180px" );
		mySaveDialog.setModal(true);
		mySaveDialog.center();
		fileName.setFocus(true);
	}
	
	
	// open an image to include in PDF report
	public static void uploadImage() {
		Asmm_eufar.rootLogger.log(Level.INFO, "Upload of an image in progress...");
		if (Asmm_eufar.imagePath.size() < 11) {
			final DialogBox myOpenDialog = new DialogBox();
			final FileUpload myFileUpload = new FileUpload();
			final FormPanel myUploadForm = new FormPanel();
			final VerticalPanel verticalPanel01 = new VerticalPanel();
			final VerticalPanel verticalPanel02 = new VerticalPanel();
			final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
			final HorizontalPanel horizontalPanel02 = new HorizontalPanel();
			final Label label = new Label("Please select the image you want to upload. Depending on the size of the image, it may take some "
					+ "time.");
			final Label label2 = new Label("Caption (optional):");
			final TextBox legendeBox = new TextBox();
			final Button submitButton = new Button("Upload");
			final Button cancelButton = new Button("Cancel/Close");
			submitButton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					if (myFileUpload.getFilename().length() == 0) {
						Asmm_eufar.rootLogger.log(Level.INFO, "No file selected...");
						return;
					} else {
						Asmm_eufar.rootLogger.log(Level.INFO, "Filename: " + myFileUpload.getFilename());
						myUploadForm.submit();
					}
				}
			});
			cancelButton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {myOpenDialog.hide();}
			});
			myOpenDialog.setGlassEnabled(true);
			myOpenDialog.add(verticalPanel02);
			verticalPanel02.add(horizontalPanel01);
			horizontalPanel01.add(Resources.popupImage("open_image"));
			horizontalPanel01.add(verticalPanel01);
			verticalPanel01.add(label);
			myFileUpload.setName("uploadFormElement");
			myFileUpload.getElement().setId("uploadFormElement");
			myFileUpload.getElement().setId("myFile");
			verticalPanel01.add(myFileUpload);
			verticalPanel01.add(label2);
			verticalPanel01.add(legendeBox);
			myUploadForm.setAction(Asmm_eufar.asmmPath + "/image");
			myUploadForm.setEncoding(FormPanel.ENCODING_MULTIPART);
			myUploadForm.setMethod(FormPanel.METHOD_POST);
			myUploadForm.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
				@Override
				public void onSubmitComplete(SubmitCompleteEvent event) {
					myOpenDialog.hide();
					final String ret = event.getResults();
					if (ret.contains("ERROR")) {
						Window.alert("The image size exceeds the maximum size permitted. The image couldn't be uploaded.");
						return;
					} else if (ret.contains("format")) {
						Window.alert("The image format is not supported. The image couldn't be uploaded.");
						return;
					}
					final String captionText = new String(legendeBox.getText());
					final int row = Asmm_eufar.imageTab.getRowCount();
					final Image image = new Image("/tmp/" + ret);
					final PushButton delButton = new PushButton(Resources.smallImage("del"));
					final Label label = new Label(captionText);	
					Asmm_eufar.imagePath.add("/tmp/" + ret);
					image.addLoadHandler(new LoadHandler() {
						public void onLoad(LoadEvent event) {
							int height = image.getHeight();
							int width = image.getWidth();
							float ratio = (float) width / height;
							int newWidth = 0;
							int newHeight = 0;
							if (ratio >= 1) {
								newWidth = 200;
								newHeight = (int) (newWidth / ratio);
							} else {
								newHeight = 150;
								newWidth = (int) (newHeight * ratio);
							}
							image.setSize(Integer.toString(newWidth) + "px", Float.toString(newHeight) + "px");
							Asmm_eufar.rootLogger.log(Level.INFO, "Upload succeeded");
						}
					});
					image.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							Asmm_eufar.rootLogger.log(Level.INFO, "Full screen image invoked...");
							final DialogBox myOpenDialog = new DialogBox();
							final VerticalPanel verticalPanel = new VerticalPanel();
							final Image image = new Image("tmp/" + ret);
							final Button okButton = new Button("Ok");
							int screen_height = Utilities.getScreenHeight();
							int screen_width = Utilities.getScreenWidth();
							int image_width = image.getWidth();
							int image_height = image.getHeight();
							float ratio = (float) image_width / image_height;
							float desired_width = 0;
							float desired_height = 0;
							desired_height = screen_height * 3 / 4;
							desired_width = (float) desired_height * ratio;
							if (desired_width > screen_width) {
								desired_width = screen_width * 3 / 4;
								desired_height = (float) desired_width / ratio;
							}
							okButton.addClickHandler(new ClickHandler() {			
								@Override
								public void onClick(ClickEvent event) {
									myOpenDialog.hide();
									Asmm_eufar.rootLogger.log(Level.INFO, "Full screen image closed");
								}
							});
							image.setSize(Float.toString(desired_width) + "px", Float.toString(desired_height) + "px");
							myOpenDialog.add(verticalPanel);
							verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
							verticalPanel.add(image);
							verticalPanel.add(okButton);
							myOpenDialog.setStyleName("myUploadBox");
							okButton.getElement().setAttribute("style", "font-family: MyFontBold !important; font-size: 14px !important;");
							myOpenDialog.setGlassEnabled(true);
							myOpenDialog.setModal(true);
							myOpenDialog.center();
							Asmm_eufar.rootLogger.log(Level.INFO, "Full screen image displayed");
						}
					});
					Asmm_eufar.imageCaption.add(captionText);
					delButton.setPixelSize(25, 25);
					delButton.setStyleName("infoButton");
					label.getElement().setAttribute("style", "width: 200px !important;");
					image.setStyleName("uploadImage");
					Asmm_eufar.imageTab.insertRow(row);
					Asmm_eufar.imageTab.setWidget(row, 0, image);
					Asmm_eufar.imageTab.setWidget(row, 1, label);
					Asmm_eufar.imageTab.setWidget(row, 2, delButton);
					Asmm_eufar.imageTab.getFlexCellFormatter().setHorizontalAlignment(row, 0, HasHorizontalAlignment.ALIGN_CENTER);
					Asmm_eufar.imageTab.getFlexCellFormatter().setHorizontalAlignment(row, 1, HasHorizontalAlignment.ALIGN_RIGHT);
					delButton.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							int removedIndex = Asmm_eufar.imageTab.getCellForEvent(event).getRowIndex();
							Asmm_eufar.imageCaption.remove(removedIndex);
							Asmm_eufar.imagePath.remove(removedIndex);
							Asmm_eufar.imageTab.removeRow(removedIndex);
							Asmm_eufar.rootLogger.log(Level.INFO, "Image removed, index: " + Integer.toString(removedIndex));
						}
					});
				}
			});		
			myUploadForm.add(verticalPanel02);
			horizontalPanel02.add(submitButton);
			horizontalPanel02.add(cancelButton);
			verticalPanel01.add(horizontalPanel02);
			myOpenDialog.add(myUploadForm);
			legendeBox.setStyleName("au_textBox");
			myOpenDialog.setStyleName("myUploadBox");
			verticalPanel02.getElement().setAttribute("style", "margin-left: 5px !important; margin-top: 10px !important; margin-right: 10px "
					+ "!important;");
			verticalPanel01.getElement().setAttribute("style", "margin-right:20px !important;");
			label.getElement().setAttribute("style", "margin-right:20px !important; margin-bottom:10px !important; margin-top:10px !important;");
			myFileUpload.getElement().setAttribute("style", "margin-left:20px !important;");
			label2.getElement().setAttribute("style", "margin-top:10px !important; text-decoration: underline !important; font-weight: "
					+ "bold !important; margin-bottom: 10px !important");
			submitButton.getElement().setAttribute("style", "margin-left:20px !important; font-family: MyFontBold !important; font-size: "
					+ "14px !important;");
			cancelButton.getElement().setAttribute("style", "margin-left:73px !important; font-family: MyFontBold !important; font-size: "
					+ "14px !important;");
			horizontalPanel02.getElement().setAttribute("style", "margin-top:30px !important; margin-bottom:20px !important;");
			myOpenDialog.setSize( "130px", "180px" );
			myOpenDialog.setModal(true);
			myOpenDialog.center();
			
		} else {
			Asmm_eufar.rootLogger.log(Level.INFO, "Impossible to upload more than 10 images");
			Window.alert("You can't upload more than 10 images");
		}
	}


	// open an image to include in PDF report (URL)
	public static void uploadImageURL() {
		Asmm_eufar.rootLogger.log(Level.INFO, "Upload of an image in progress (URL)...");
		if (Asmm_eufar.imagePath.size() < 11) {
			final DialogBox myOpenDialog = new DialogBox();
			final VerticalPanel verticalPanel01 = new VerticalPanel();
			final VerticalPanel verticalPanel02 = new VerticalPanel();
			final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
			final HorizontalPanel horizontalPanel02 = new HorizontalPanel();
			final Label label = new Label("Please enter the URL of the image you want to upload.");
			final Label label2 = new Label("URL:");
			final Label label3 = new Label("Caption (optional):");
			final TextBox legendeBox = new TextBox();
			final TextBox textBox = new TextBox();
			final Button submitButton = new Button("Upload");
			final Button cancelButton = new Button("Cancel/Close");
			cancelButton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					myOpenDialog.hide();
				}
			});
			submitButton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					if (textBox.getText() == "") {
						Asmm_eufar.rootLogger.log(Level.INFO, "Invalid URL...");
						return;
					}
					final String captionText = new String(legendeBox.getText());
					final String string = new String(textBox.getText());
					Asmm_eufar.imagePath.add(string);
					myOpenDialog.hide();
					int row = Asmm_eufar.imageTab.getRowCount();
					final Image image = new Image(string);
					final PushButton delButton = new PushButton(Resources.smallImage("del"));
					final Label label = new Label(captionText);
					image.addLoadHandler(new LoadHandler() {
						public void onLoad(LoadEvent event) {
							int height = image.getHeight();
							int width = image.getWidth();
							float ratio = (float) width / height;
							int newWidth = 0;
							int newHeight = 0;
							if (ratio >= 1) {
								newWidth = 200;
								newHeight = (int) (newWidth / ratio);
							} else {
								newHeight = 150;
								newWidth = (int) (newHeight * ratio);
							}
							image.setSize(Integer.toString(newWidth) + "px", Float.toString(newHeight) + "px");
							Asmm_eufar.rootLogger.log(Level.INFO, "Upload succeeded");
						}
					});
					image.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							Asmm_eufar.rootLogger.log(Level.INFO, "Full screen image invoked...");
							final DialogBox myOpenDialog = new DialogBox();
							final VerticalPanel verticalPanel = new VerticalPanel();
							final Image image = new Image(string);
							final Button okButton = new Button("Ok");
							int screen_height = Utilities.getScreenHeight();
							int screen_width = Utilities.getScreenWidth();
							int image_width = image.getWidth();
							int image_height = image.getHeight();
							float ratio = (float) image_width / image_height;
							float desired_width = 0;
							float desired_height = 0;
							desired_height = screen_height * 3 / 4;
							desired_width = (float) desired_height * ratio;
							if (desired_width > screen_width) {
								desired_width = screen_width * 3 / 4;
								desired_height = (float) desired_width / ratio;
							}
							okButton.addClickHandler(new ClickHandler() {			
								@Override
								public void onClick(ClickEvent event) {
									myOpenDialog.hide();
									Asmm_eufar.rootLogger.log(Level.INFO, "Full screen image closed");
								}
							});
							image.setSize(Float.toString(desired_width) + "px", Float.toString(desired_height) + "px");
							myOpenDialog.add(verticalPanel);
							verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
							verticalPanel.add(image);
							verticalPanel.add(okButton);
							myOpenDialog.setStyleName("myUploadBox");
							okButton.getElement().setAttribute("style", "font-family: MyFontBold !important; font-size: 14px !important;");
							myOpenDialog.setGlassEnabled(true);
							myOpenDialog.setModal(true);
							myOpenDialog.center();
							
							Asmm_eufar.rootLogger.log(Level.INFO, "Full screen image displayed");
						}
					});
					Asmm_eufar.imageCaption.add(captionText);
					delButton.setPixelSize(25, 25);
					delButton.setStyleName("infoButton");
					label.getElement().setAttribute("style", "width: 200px !important;");
					image.setStyleName("uploadImage");
					Asmm_eufar.imageTab.insertRow(row);
					Asmm_eufar.imageTab.setWidget(row, 0, image);
					Asmm_eufar.imageTab.setWidget(row, 1, label);
					Asmm_eufar.imageTab.setWidget(row, 2, delButton);
					Asmm_eufar.imageTab.getFlexCellFormatter().setHorizontalAlignment(row, 1, HasHorizontalAlignment.ALIGN_RIGHT);
					delButton.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							int removedIndex = Asmm_eufar.imageTab.getCellForEvent(event).getRowIndex();
							Asmm_eufar.imageCaption.remove(removedIndex);
							Asmm_eufar.imagePath.remove(removedIndex);
							Asmm_eufar.imageTab.removeRow(removedIndex);
							Asmm_eufar.rootLogger.log(Level.INFO, "Image removed, index: " + Integer.toString(removedIndex));
						}
					});
				}
			});
			myOpenDialog.setGlassEnabled(true);
			myOpenDialog.add(verticalPanel02);
			verticalPanel02.add(horizontalPanel01);
			horizontalPanel01.add(Resources.popupImage("open_image"));
			horizontalPanel01.add(verticalPanel01);
			verticalPanel01.add(label);
			verticalPanel01.add(label2);
			verticalPanel01.add(textBox);
			verticalPanel01.add(label3);
			verticalPanel01.add(legendeBox);
			horizontalPanel02.add(submitButton);
			horizontalPanel02.add(cancelButton);
			verticalPanel01.add(horizontalPanel02);
			textBox.setStyleName("au_textBox");
			legendeBox.setStyleName("au_textBox");
			myOpenDialog.setStyleName("myUploadBox");
			verticalPanel01.getElement().setAttribute("style", "margin-right:20px !important;");
			label.getElement().setAttribute("style", "margin-right:20px !important; margin-bottom:10px !important; margin-top:10px !important;");
			verticalPanel02.getElement().setAttribute("style", "margin-left: 5px !important; margin-top: 10px !important; margin-right: 10px "
					+ "!important;");
			label2.getElement().setAttribute("style", "text-decoration: underline !important; font-weight: bold !important; margin-bottom: 10px "
					+ "!important");
			label3.getElement().setAttribute("style", "margin-top:10px !important; text-decoration: underline !important; font-weight: "
					+ "bold !important; margin-bottom: 10px !important");
			submitButton.getElement().setAttribute("style", "margin-left:20px !important; font-family: MyFontBold !important; font-size: "
					+ "14px !important;");
			cancelButton.getElement().setAttribute("style", "margin-left:73px !important; font-family: MyFontBold !important; font-size: "
					+ "14px !important;");
			horizontalPanel02.getElement().setAttribute("style", "margin-top:30px !important; margin-bottom:20px !important;");
			myOpenDialog.setSize( "350px", "180px" );
			myOpenDialog.setModal(true);
			myOpenDialog.center();
			
		} else {
			Asmm_eufar.rootLogger.log(Level.INFO, "Impossible to upload more than 10 images");
			Window.alert("You cannot upload more than 10 images.");
		}
	}

	
	// panel to warn user that he can't add more than 12 checkboxes
	public static void noCheckboxPanel() {
		final DialogBox infoDialog = new DialogBox();
		final VerticalPanel verticalPanel01 = new VerticalPanel();
		final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
		final Label label02 = new Label("You cannot create more than 12 checkboxes per section in ASMM Creator Online.");
		final Button button = new Button("Ok");
		button.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				infoDialog.hide();
			}
		});
		infoDialog.setGlassEnabled(true);
		horizontalPanel01.add(Resources.popupImage("warning"));
		horizontalPanel01.add(label02);
		verticalPanel01.add(horizontalPanel01);
		verticalPanel01.add(button);
		infoDialog.add(verticalPanel01);
		button.getElement().setAttribute("style", "margin-left: 120px !important; font-family: MyFontBold !important; margin-top: "
				+ "20px !important; font-size: 14px !important;");
		verticalPanel01.getElement().setAttribute("style", "margin: 10px;");
		infoDialog.setSize( "300px", "100px" );
		infoDialog.setModal(true);
		infoDialog.center();
		infoDialog.setStyleName("myUploadBox");
		infoDialog.show();
	}
	
	
	// return the text asked for a particular Info button
	public static Label addInfoText(final String context) {
		HTML infoLabel = new HTML();
		switch (infoEnum.valueOf(context.toUpperCase())) {
		case NEWCHECKBOX:
			infoLabel.setHTML("<p align=justify>Use this button to add a new checkbox. Each activated checkbox is then saved in "
					+ "the XML file with the code <b>xx_User</b>.</p><p align=center style='color:#C80000'><b>All non-activated checkboxes "
					+ "will not be saved and will be lost.</b></p><p align=justify>As the PDF report generator is limited to 12 checkboxes "
					+ "per section, you cannot create more than 12 checkboxes per section in ASMM Creator Online.</p>");
			break;
		default:
			infoLabel.setHTML("No information for this item");
			break;
		}
		infoLabel.setWordWrap(true);
		return infoLabel;
	}
	
	
	// create the changelog string to be displayed by the popup
	private static String logText() {
		String string = new String(""
				+ "<b><u>CHANGELOG</u></b><br><br>"
				+ "<u>TESTED ON:</u><ul><li>Firefox 31.5.3, 38.0.1, 39, 40 (succeeded)</li><li>Chrome 44 "
				+ "(succeeded)</li><li>Internet Explorer 11 (failed on one computer and succeeded on others)</li><li>Safari 5.1.7, 8.0.5 "
				+ "(succeeded)</li><li>Opera 30 (succeeded)</li></ul><br>"
				+ "<u>KNOWN ISSUES:</u><ul><li>!!! "
				+ "IMPORTANT !!! in the [ONLINE] version, a line need to be activated or commented to allow a proper operation of the downloading, "
				+ "uploading and printing servlets, based on the platform of devlopment or production: see in the 'Asmm_eufar.java' file, find "
				+ "those lines at the beginning:<ul><li>String asmmPath = new String(GWT.getHostPageBaseURL()); // for Tomcat7/8 Server</li><li>"
				+ "String asmmPath = new String(''); // for Eclipse Dev Mode</li></ul></li></ul><br>"
				
				+ "<b><u>December 14 2015, Release version 1.0.2 [ONLINE]</u></b><br><ul style='list-style-type:none'><li>FIXED:<ul>"
				+ "<li>the top banner wasn't displayed when the GUI was in 'Tab' mode.</li><li>few mistakes have been corrected in the GUI</li>"
				+ "</ul></li><li>MODIFIED:<ul><li>the current fonts have been replaced by the one from the EUFAR website.</li></ul></li></ul><br>"
				+ "<b><u>October 20 2015, Release version 1.0.1 [ONLINE][OFFLINE]</u></b><br><ul style='list-style-type:none'><li>FIXED:<ul>"
				+ "<li>a small bug prevented the read of the name of the aircraft in few circumstances [ONLINE].</li></ul></li></ul><br>"
				+ "<b><u>September 3 2015, Release version 1.0.0 [ONLINE]</u></b><br>All functions have heen dispatched into new "
				+ "java files to allow a better following of the code.<br><ul style='list-style-type:none'><li>FIXED:<ul><li>when a document is "
				+ "modified and clear function invoked, if the user want to save the file, the open function will be invoked once the file is "
				+ "saved, it has been fixed [ONLINE].</li></ul></li><li>MODIFIED:<ul><li>few adjustments in the GUI [ONLINE].</li></ul></li><li>"
				+ "ADDED:<ul><li>if the user wants to exit ASMM and if the document has been modified, ASMM will ask if the user wants to exit "
				+ "before to save it [ONLINE].</li></ul></li></ul><br>"
				+ "<b><u>August 18 2015, Release version 0.9.10[ONLINE]</u></b><br>The changelog has been introduced in ASMM Online.<br>"
				+ "<ul style='list-style-type:none'><li>FIXED:<ul><li>few issues in the GUI related to infoButton [ONLINE].</li><li>an issue "
				+ "prevented the display of images in the pdf report. As this issue concerned only one computer and couldn't be reproduced so "
				+ "far, a temporary solution has been implemented : the upload function dedicated to image know write a copy of the image in the "
				+ "'tmp' folder of ASMM package (to feed the GUI) and in the '/tmp' folder of the server (to feed the pdf generator) [ONLINE]"
				+ "</li></li><li>'Do your choice...' sentence has been corrected to 'Make your choice...' [ONLINE].</li>"
				+ "</ul></li><li>ADDED:<ul><li>new logging messages added to check image upload and rights [ONLINE].</li></ul></li><li>MODIFIED:"
				+ "<ul><li>icons have been reworked to increase resolution, improve shape and optimize weight [ONLINE].</li></ul></li></ul><br>"
				+ "<b><u>July 28 2015, Release version 0.9.9 [ONLINE]</u></b><br>A proper logging system is being introduced in ASMM "
				+ "Creator Online. It will be introduced in ASMM Creator Offline once the v0.9.8 is released.  Because off compatibility issues "
				+ "with Internet Explorer, a popup message has been introduced to warn user if they use IE.<br><ul style='list-style-type:none'>"
				+ "<li>FIXED:<ul><li>the 'Country' listbox wasn't reseted correctly when clearfields() was invoked [ONLINE].</li><li>a 'java.lang"
				+ ".NullPointerException' was fixed [ONLINE]</li><li>if an empty url is entered to upload an image, ASMM now doesn't display an "
				+ "empty image [ONLINE].</li><li>In the Image section, after an image upload, when the caption textbox was empty, the delete "
				+ "button didn't remove the image linked to it, but always the first row ; it has been fixed [ONLINE].</li><li>fixed the size of "
				+ "the caption when a user uploads an image from its URL [ONLINE].</li><li>fixed an uncaught exception with the contact name "
				+ "when this field was empty during the reading of an XML file [ONLINE].</li></ul></li><li>ADDED:<ul><li>when printing or saving "
				+ "a file, if the filename is empty, the Print/Save button will not work ; the window.alert to warn the user has been removed "
				+ "[ONLINE].</li><li>when trying to create new checkbox, or add ground observation sites, if the name if empty, the Submit button"
				+ " will not work ; the window.alert to warn the user has been removed [ONLINE].</li><li>when trying to upload a file or an "
				+ "image, if the filename is empty, the Upload button will not work ; the window.alert to warn the user has been removed "
				+ "[ONLINE].</li><li>a function to see all uploaded images fullscreen has been introduced [ONLINE].</li><li>the servlet to "
				+ "upload images triggers an alert window on client-side if an image is greater than 5 Mo [ONLINE]. </li><li>the servlet to "
				+ "upload images triggers an alert window on client-side if the extension of an image is not a predefined image extension "
				+ "[ONLINE].</li></ul></li><li>MODIFIED:<ul><li>few adjustments in the GUI [ONLINE].</li></ul></li></ul><br>"
				+ "<b><u>July 22 2015, Release version 0.9.8 [ONLINE]</u></b><br>As the code is stable and no more bug has been found, the "
				+ "software is released in the current state, and version number increases to 0.9.8 [ONLINE].<br><br>"
				+ "<b><u>July 2-22 2015, Release version 0.9.8b12-b20</u></b><br>It is now possible to upload images to be included in the PDF "
				+ "report (request from UK airborne research operators) in the online version of ASMM.  A new layout has been introduced to "
				+ "allow a browser-like layout for small wide screen (automatically) and other screens (manually).<br><ul style='list-style-type:"
				+ "none'><li>MODIFIED:<ul><li>the item 'Campaign' has been changed to 'Project acronym', the xml code reflects the change "
				+ "[ONLINE].</li><li>the items 'Mountainous', 'Hilly' and 'Flat' have been moved to the same column [ONLINE].</li><li>the "
				+ "'Country' selection has been changed to comply with the EUFAR Metadata Creator system, the xml code reflects the change "
				+ "[ONLINE].</li><li>few adjustments in the GUI [ONLINE].</li></ul></li><li>FIXED:<ul><li>all included images are now well "
				+ "cleaned if a new file is created or an existing xml file is loaded [ONLINE].</li><li>once an infobutton is clicked, the "
				+ "linked clickhandler is deactivated permanently, it has been fixed [ONLINE].</li><li>in the section 'Supporting Surface-based "
				+ "Observations', if there is no text in a textbox and a '+' button is clicked, an empty widget with a 'x' button is created in "
				+ "the listpanel [ONLINE].</li><li>with the modification of the country selection, the printing function couldn't work properly, "
				+ "it has been fixed [ONLINE].</li><li>few spelling mistakes have been corrected [ONLINE].</li><li>in the pdf report, textboxes "
				+ "for the Geographic Bounding Box were inverted [ONLINE].</li></ul></li><li>ADDED:<ul><li>the focus has been added to all popup"
				+ " windows with a textbox to enter text [ONLINE].</li><li>the Keyboard Event Handler has been added to all necessary textboxes "
				+ "[ONLINE].</li><li>the printing function now warns the user about the necessary time to generate and download the pdf report, "
				+ "depending on the network connexion and the number/size of the image(s) [ONLINE].</li><li>the function to create checkboxes "
				+ "now doesn't allow more than 12 checkboxes per section to comply with the pdf report generator [ONLINE].</li><li>if a user try "
				+ "to create a new checkbox with the name of an existing checkbox, the new checkbox won't be created [ONLINE].</li><li>it is now "
				+ "impossible to create empty checkbox [ONLINE].</li></ul></li></ul><br>"
				+ "<b><u>June 22 - July 2 2015, Release version 0.9.8b1-b11</u></b><br>A new plugin to print pdf report from user inputs has "
				+ "been introduced in the online version of ASMM. The pdf template has been produced using Jasper Reports 6.1.0 and Eclipse "
				+ "4.4.<br><ul style='list-style-type:none'><li>FIXED:<ul><li>few spelling mistakes have been corrected [ONLINE].</li><li>the "
				+ "country and role comboboxes were saved even when the displayed text was 'Do your choice...' [ONLINE].</li></ul></li></ul><br>"
				+ "<b><u>June 19 2015, Release version 0.9.7</u></b><br>As the code is stable and no more bug has been found, the software is "
				+ "released in the current state, and version number increases to 0.9.7 [OFFLINE][ONLINE].<br><br>"
				+ "<b><u>June 18-19 2015, Release version 0.9.7b2-b3</u></b><br><ul style='list-style-type:none'><li>MODIFIED:<ul><li>the Line "
				+ "Edits to enter the aircraft and operator have been replaced by combobox to list first all the aircraft and operators open to "
				+ "Transnational Access. If a user needs to enter a non TA operator/aircraft, he will select 'Other' and two new Line Edits "
				+ "will appear [ONLINE][OFFLINE][mainwindow.py][button_functions.py][sql_functions.py][Ui_mainwindow.py].</li><li>the Line Edit "
				+ "to enter the country has been replaced by a combobox listing all countries [ONLINE][OFFLINE][mainwindow.py][Ui_mainwindow.py]"
				+ "[sql_functions.py].</li><li>the function to save an xml file has been modified to take care of the new country and "
				+ "operator/aircraft comboboxes [ONLINE][OFFLINE][asmm_xml.py].</li><li>the function to create a new file has been modified to "
				+ "take care of the new country and operator/aircraft comboboxes [ONLINE][OFFLINE][mainwindow.py].</li></ul></li><li>FIXED:<ul>"
				+ "<li>fixed a bug which prevents a total clear of all user-defined checkboxes [ONLINE].</li></ul></li></ul><br>"
				+ "<b><u>June 17 2015, Release version 0.9.7b1</u></b><br><ul style='list-style-type:none'><li>ADDED:<ul><li>a function to "
				+ "append the suffix 'modified' to the browser window title has been introduced when a modification is brought to a field, the "
				+ "suffix disapears if the file is saved or cleared [ONLINE].</li><li>when a user wants to create a new file and some fields are "
				+ "not empty or have been changed, a function will ask him if he wants to save the file before creating a new one [ONLINE].</li>"
				+ "<li>when a user tries to open an xml file and some fields are not empty, it is not prompted if the user wants to save his work"
				+ " before opening the xml file [ONLINE].</li><li>new window has been added to replace an internal window (asking if the user "
				+ "wants to save a previous file before loading a new one or clearing all fields) [OFFLINE][mainwindow.py][Ui_presavewindow.py]."
				+ "</li></ul></li></ul><br>"
				+ "<b><u>June 12 2015, Release version 0.9.6</u></b><br>As the code is stable and no more bug has been found, the software is "
				+ "released in the current state, and version number increases to 0.9.6 [OFFLINE][ONLINE].<br><br>"
				+ "<b><u>June 11-12 2015, Release version 0.9.6b21-b22</u></b><br><ul style='list-style-type:none'><li>MODIFIED:<ul><li>the "
				+ "function to save xml file has been modified to include all new checkboxes created by the user [OFFLINE][asmm_xml.py].</li>"
				+ "<li>the ASMM menu has been a bit reorganized with the introduction of information about the ASMM XML Standard [OFFLINE]"
				+ "[mainwindow.py].</li><li>the function to create a new file has been modified to take care of the new checkboxes created by "
				+ "the user [OFFLINE][mainwindow.py].</li></ul></li><li>FIXED:<ul><li>few http links in the software have been fixed to redirect "
				+ "to the documents on GitHub [ONLINE][OFFLINE][mainwindow.py].</li></ul></li><li>ADDED:<ul><li>a new window has been added to "
				+ "give information about the ASMM XML Standard [OFFLINE][mainwindow.py][Ui_aboutstandard.py].</li><li>a new function to let the "
				+ "user enter his own checkboxes has been introduced [OFFLINE][mainwindow.py][buttons_functions.py][Ui_addcheckbox.py].</li></ul>"
				+ "</li></ul><br>"
				+ "<b><u>June 10 2015, Release version 0.9.6b20</u></b><br>Revamp of the GUI is finished [OFFLINE][Ui_mainwindow.py].<br>"
				+ "<ul style='list-style-type:none'><li>ADDED:<ul><li>info buttons have been introduced to add information about the function "
				+ "which create new checkBoxes from user inputs [OFFLINE][mainwindow.py]</li></ul></li></ul><br>"
				+ "<b><u>June 9 2015, Release version 0.9.6b19</u></b><br>A revamp of the GUI is ongoing, to comply with the online version of "
				+ "ASMM [OFFLINE][Ui_mainwindow.py].<br><br><b><u>May 19 2015, Release version 0.9.6b18</u></b><br><ul style='list-style-type:"
				+ "none'><li>FIXED:<ul><li>when no new checkbox was created by the user, all other original checkboxes were saved with the code "
				+ "'XX_User' [ONLINE].</li><li>a small bug prevented to display the content of the 'Scientific Aims' Comments textArea [ONLINE]."
				+ "</li></ul></li></ul><br>"
				+ "<b><u>May 7 2015, Release version 0.9.6b17</u></b><br><ul style='list-style-type:none'><li>MODIFIED:<ul><li>the function to "
				+ "save an xml file has been modified to be fully coded in Java, no php script remaining [ONLINE].</li></ul></li></ul><br>"
				+ "<b><u>May 4-6 2015, Release version 0.9.6b16</u></b><br><ul style='list-style-type:none'><li>ADDED:<ul><li>a button with a "
				+ "dedicated function has been introduced in the diffrent panel to let the user enter his own checkBoxes [ONLINE].</li><li>two "
				+ "aboutWindow has been created to present the goal of ASMM and the ASMM XML standard [ONLINE].</li></ul></li><li>MODIFIED:<ul>"
				+ "<li>the function to clear all widgets has been modified to handle the user-defined checkboxes [ONLINE].</li><li>the function "
				+ "to save the xml file has been modified to save all activated user-defined checkboxes [ONLINE].</li><li>the function to load "
				+ "an xml file has been modified to handle the presence of user-defined xml code [ONLINE].</li></ul></li></ul><br>"
				+ "<b><u>April 28 2015, Release version 0.9.6b15</u></b><br><ul style='list-style-type:none'><li>ADDED:<ul><li>a function to "
				+ "parse XML code within all fields [ONLINE].</li></ul></li><li>FIXED:<ul><li>North and South Latitudes of the bounding box were "
				+ "saved as 'NorthLongitudes' and 'SouthLongitudes' [ONLINE].</li></ul></li></ul><br>"
				+ "<b><u>April 28 2015, Release version 0.9.6b14</u></b><br>A function to allow upload of xml file has been started [ONLINE].<br>"
				+ "<ul style='list-style-type:none'><li>ADDED:<ul><li>a server-side function to handle upload of xml file [ONLINE].</li><li>the "
				+ "first function to upload file from client-side has been introduce in the main gwt application [ONLINE].</li></ul></li></ul><br>"
				+ "<b><u>April 23-27 2015, Release version 0.9.6b13</u></b><br><ul style='list-style-type:none'><li>ADDED:<ul><li>a function to "
				+ "generate XML file from PHP script has been created. Its a simple and temporary function [ONLINE].</li><li>dictionnaries to "
				+ "handle checkboxes and the xml schema of those checkboxes [ONLINE].</li></ul></li><li>FIXED:<ul><li>the final xml code was "
				+ "written in the last textArea of the program when the 'Save' function was triggered [ONLINE].</li><li>the 'Scientific Aims "
				+ "Comments' item wasn't saved in the XML file [ONLINE].</li></ul></li></ul><br>"
				+ "<b><u>April 22 2015, Release version 0.9.6b12</u></b><br><ul style='list-style-type:none'><li>ADDED:<ul><li>a new function to "
				+ "create a new file if the different fields are not empty [ONLINE].</li><li>GWTQuery has been added to the program as a library "
				+ "[ONLINE].</li></ul></li></ul><br>"
				+ "<b><u>April 9-21 2015, Release version 0.9.6b1-b11</u></b><br>To comply with EUFAR requirements, alongside with a Python "
				+ "version, a Java version is developed to allow creation of xml file using an online application. This application is coded "
				+ "using Java and GWT, with Eclipse 4.4. The changelog of the online version is merged with the offline one. From now on, the "
				+ "parameters [ONLINE] and [OFFLINE] will be used to differenciate inputs brought to the online or offline version of ASMM.<br>"
				+ "First version of the graphical user interface [ONLINE] and improvements.<br><br>"
				+ "<b><u>October 23 2014, Release version 0.9.5</u></b><br>As the code is stable and no more bug has been found, the software is "
				+ "released in the current state, and version number increases to 0.9.5. Two stand alone versions have been produced for Linux "
				+ "and Windows : they work with my personal Windows 8.1 Update1 and Ubuntu 14.04, they need intensive tests with other windows "
				+ "and linux operating systems.<br><br>"
				+ "<b><u>October 23 2014, Release version 0.9.5b4</u></b><br><ul style='list-style-type:none'><li>FIXED:<ul><li>corrected a bug "
				+ "that make the sentence 'closing ASMM Creator ...' appears in the terminal when a document was modified, 'Exit' button pushed, "
				+ "and 'Cancel' selected when it was asked to save or not [asmm_xml.py].</li><li>corrected a bug which permits a contact role to "
				+ "be writen in the XML file even if a contact name doesn't exist [asmm_xml.py].</li><li>corrected a but which crashes the "
				+ "application when a contact role read in the XML file was missing [asmm_xml.py].</li></ul></li><li>MODIFIED:<ul><li>modified "
				+ "path to retrieve fonts to help creation of the stand alone application under Windows [asmm_pdf.py].</li></ul></li><li>ADDED:"
				+ "<ul><li>a licence file to the 'fonts' directory to comply with Fedora font licence.</li><li>the version number to ASMM "
				+ "starting and closing sentence [asmm_creator.py][mainwindow.py].</li></ul></li></ul><br>"
				+ "<b><u>October 22 2014, Release version 0.9.5b3</u></b><br><ul style='list-style-type:none'><li>MODIFIED:<ul><li>'asmm_pdf.py' "
				+ "and 'asmm_xml.py' have been moved to 'functions' directory as they are functions. Code in the main program has been modified "
				+ "according to the new location.</li></ul></li></ul><br>"
				+ "<b><u>October 21 2014, Release version 0.9.5b2</u></b><br>Some work has been done since the 20th of October to produce a "
				+ "stable stand alone version for Windows and Linux, with PyInstaller.<br><ul style='list-style-type:none'><li>ADDED:<ul><li>"
				+ "'import netCDF4' was added to help PyInstaller add this module to the stand alone file [asmm_creator.py].</li><li>'import "
				+ "numpy' was added to help PyInstaller add this module to the stand alone file [asmm_creator.py].</li><li>titles have been "
				+ "added to the different pages to improve clarity of the code for futur modification [UI_mainwindow.py].</li></ul></li><li>"
				+ "MODIFIED:<ul><li>modified 'asmm_pdf.py' code to use free policies on every systems (Windows, Linux, MacOS). PyInstaller had "
				+ "problems to point towards the correct directory.</li></ul></li></ul><br>"
				+ "<b><u>October 20 2014, Release version 0.9.5b1</u></b><br><ul style='list-style-type:none'><li>FIXED:<ul><li>when 'Print' "
				+ "button was clicked  then 'Cancel', an error was raised invoking a missing filename. This has been corrected by added a "
				+ "condition on the filename with a return function [mainwindow.py].</li></ul></li></ul><br>"
				+ "<b><u>October 17 2014, Release version 0.9.4</u></b><br>As the code is stable and no more bug has been found, the software is "
				+ "released in the current state, and version number increases to 0.9.4.<br><br>"
				+ "<b><u>October 13-17 2014, Release version 0.9.4b2-13</u></b><br><ul style='list-style-type:none'><li>FIXED:<ul><li>few issues "
				+ "converning the 'asmm_pdf.py' code</li></ul></li><li>ADDED:<ul><li>a function to allow the user to enter is own PDF filename "
				+ "[asmm_pdf.py].</li><li>a function to allow a printing on multiple pages [asmm_pdf.py].</li><li>new functions to produce tick "
				+ "boxes, squares, lines, in the pdf document [asmm_pdf.py].</li><li>the possibility to use fonts installed on particular "
				+ "Operating Systems (deprecated) [asmm_pdf.py].</li><li>few free policies to avoid use of non distributable policies on a linux "
				+ "operating systems[asmm_pdf.py].</li></ul></li><li>MODIFIED:<ul><li>the 'About ASMM Creator' text has been modifies to change "
				+ "the version number and to integrate link and text about Reportlab plugin.</li></ul></li></ul><br>"
				+ "<b><u>October 13 2014, Release version 0.9.4b1</u></b><br>First implementation of a plugin to allow a pdf printing of the XML "
				+ "file. It's a demonstrator and need improvements and agreement from EUFAR community.<br><ul style='list-style-type:none'><li>"
				+ "ADDED:<ul><li>'Print' button has been added in 'File' menu, code has been added to link the 'Print' button to the new plugin "
				+ "[UI_mainwindow.py][mainwindow.py]</li><li>the first version of the plugin to allow printing through Reportlab libraries has "
				+ "been created [asmm_pdf.py]</li></ul></li></ul><br>"
				+ "<b><u>October 13 2014, Release version 0.9.3</u></b><br>As the code is stable and no more bug has been found, the software is "
				+ "released in the current state, and version number increases to 0.9.3.<br><br>"
				+ "<b><u>October 10 2014, Release version 0.9.3b6</u></b><br><ul style='list-style-type:none'><li>MODIFIED:<ul><li>the code in "
				+ "'asmm_xml' has been modified for clarification: few 'newline' deleted, few lines have been moved to be in the right section, "
				+ "... [asmm_xml.py].</li><li>'if __name__ == '__main__':' statement has been removed from 'UI_mainwindow.py' as it is "
				+ "deprecated, not executed, and a modified version is present in 'asmm_creator.py' [UI_mainwindow.py].</li><li>some files have "
				+ "been updated to reflect the new EUFAR2 FP7 project and to comply with python international standards : PKG-INFO, requires.txt,"
				+ " SOURCES.txt, setup.cfg, setup.py. Those files are needed to prepare an installation package.</li></ul></li><li>ADDED:<ul><li>"
				+ "few lines of code have been added to allow the software to adapt itself to the height of a screen [UI_mainwindow.py].</li>"
				+ "</ul></li></ul><br>"
				+ "<b><u>October 9 2014, Release version 0.9.3b5</u></b><br><ul style='list-style-type:none'><li>FIXED:<ul><li>when 'Save as ...' "
				+ "button was clicked, then 'Cancel', an error was raised invoking a missing filename. This has been corrected by added a "
				+ "condition on the filename with a return function [mainwindow.py].</li><li>when 'Read bounding box information from NetCDF' "
				+ "button was clicked, then 'Cancel', an error was raised invoking a missing filename. This has been corrected by added a "
				+ "condition on the filename with a return function [mainwindow.py].</li></ul></li><li>MODIFIED:<ul><li>when 'Open' button was "
				+ "clicked, all cells/checkboxes were automatically cleared, even if the button was not clicked intentionnaly. The "
				+ "'self.reset_all_fields' function has been moved to 'asmm_xml.py' file in order to clear the document only if a user is agree "
				+ "to reada new one by selecting the new file [mainwindow.py][asmm_xml.py].</li></ul></li><li>ADDED:<ul><li>a function to "
				+ "automatically add extension to filename has been coded [mainwindow.py].</li></ul></li></ul><br>"
				+ "<b><u>October 8 2014, Release version 0.9.3b4</u></b><br><ul style='list-style-type:none'><li>FIXED:<ul><li>ASMM Creator "
				+ "wasn't saving the 'Scientific Aims' checkboxes to the XML file, the code 'self.scientific_aims_check_dict' has been added to "
				+ "the main code in order to properly save checkboxes to XML file [mainwindow.py].</li><li>the element 'GR_other' has been "
				+ "corrected to 'GR_Other' in order to properly save this part in XML file [asmm_xml.py].</li></ul></li><li>MODIFIED:<ul><li>the "
				+ "part 'geographic bounding box' was saved in the 'Contact Information' part. It has been modified to be saved properly in the "
				+ "'Geographical region' part [asmm_xml.py].</li><li>few lines of code, involving 'return' function, have been deleted in order "
				+ "to simplify the main code. Those functions were never invoked as placed in an 'if ... else' statement which never could be "
				+ "TRUE [mainwindow.py].</li></ul></li></ul><br>"
				+ "<b><u>October 7 2014, Release version 0.9.3b3</u></b><br><ul style='list-style-type:none'><li>FIXED:<ul><li>ASMM Creator "
				+ "wasn't saving the 'Scientific Aims' checkboxes to the XML file, the code 'self.scientific_aims_check_dict' has been added to "
				+ "the main code in order to properly save checkboxes to XML file [mainwindow.py].</li><li>the element 'GR_other' has been "
				+ "corrected to 'GR_Other' in order to properly save this part in XML file [asmm_xml.py].</li></ul></li><li>MODIFIED:<ul><li>ASMM "
				+ "Creator was calling for EGADS in order to read netcdf files for latitude/longitude coordinates and altitude. This call has "
				+ "been removed and a function based on EGADS has been integrated in ASMM Creator package, to avoid issue if EGADS is not "
				+ "installed alongside of ASMM Creator [mainwindow.py].</li></ul></li><li>ADDED:<ul><li>the netcdf reading function has been "
				+ "added to the import part [mainwindow.py].</li></ul></li></ul><br>"
				+ "<b><u>October 6 2014, Release version 0.9.3b2</u></b><br><ul style='list-style-type:none'><li>MODIFIED:<ul><li>the "
				+ "'title_string' variable has been modified to see 'unsaved' and/or 'modified' when the document has been modified and/or not "
				+ "been saved [mainwindow.py].</li><li>the function 'on_groundListWidget_doubleClicked' and other relatives have been deleted to "
				+ "avoid confusion and wrong manipulation in the software [mainwindow.py].</li><li>the main code has been expanded with a line "
				+ "to inform that the software has been executed and is running [asmm_creator.py].</li><li>the main code has been expanded with "
				+ "a line to inform that the software is currently closing [mainwindow.py.py].</li></ul></li></ul><br>"
				+ "<b><u>September 29 2014, Release version 0.9.3b1</u></b><br><ul style='list-style-type:none'><li>ADDED:<ul><li>a button to "
				+ "exit the application have been placed near the button 'Generate XML' [mainwindow.py].</li></ul></li></ul><br>"
				+ "<b><u>September 15 2014, Release version 0.9.2</u></b><br>Different kind of tests have been run in order to isolate all bugs "
				+ "and all necessary modifications to improve/correct to the software.<br><br>"
				+ "<b><u>September 1 2014, Release version 0.9.2</u></b><br>This project - Airborne Science Mission Metadata (ASMM) - was "
				+ "motivated by the need to create a standard set of mission reports, aiding in classification and searches of data sets based "
				+ "on flight phenomena, mission parameters or other criteria. To meet this goal, an XML format has been developed to store the "
				+ "mission report data in a standard manner, and an easy-to-use graphical user interface has been developed to facilitate "
				+ "creation and display of the standard XML files. This project contains the source code and executables for the ASMM creator as "
				+ "well as documentation describing the ASMM XML schema.  ASMM Creator was coded by Matt Freer (EUFAR)");  
		return string;
	}
}

