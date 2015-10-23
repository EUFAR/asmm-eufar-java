package com.eufar.asmm.client;

import java.util.logging.Level;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.xml.client.DOMException;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;

public class xmlOpen {
	

	// read the xml code in the opened xml file
	public static void readXml(String stringXml) {
		Asmm_eufar.rootLogger.log(Level.INFO, "Reading in progress in progress...");
		try {
			Document doc = XMLParser.parse(stringXml);
			Asmm_eufar.creationDate = doc.getElementsByTagName("creationdate").item(0).getFirstChild().getNodeValue();


			//////////////////////////
			/// Flight information ///
			//////////////////////////
			try {
				Asmm_eufar.fi_flightText.setText(doc.getElementsByTagName("flightnumber").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'flightnumber' failed: " + ex.getMessage());
			}
			Asmm_eufar.fi_dateText.setValue(DateTimeFormat.getFormat("yyyy-MM-dd").parse(doc.getElementsByTagName("date").item(0).getFirstChild().
					getNodeValue()));
			try {
				Asmm_eufar.fi_campaignText.setText(doc.getElementsByTagName("projectacronym").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'projectacronym' failed: " + ex.getMessage());
			}
			try {
				Asmm_eufar.fi_scientistText.setText(doc.getElementsByTagName("missionscientist").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'missionscientist' failed: " + ex.getMessage());
			}
			try {
				Asmm_eufar.fi_managerText.setText(doc.getElementsByTagName("flightmanager").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'flightmanager' failed: " + ex.getMessage());
			}
			int l = 0;
			int k = 0;
			String operator = "";
			String aircraft = "";
			try {
				operator = doc.getElementsByTagName("operator").item(0).getFirstChild().getNodeValue();
				for (int i = 0; i < Asmm_eufar.operatorsAircraft.length; i++) {
					if (operator == Asmm_eufar.operatorsAircraft[i][2]) {
						l = 1;
						for (int j = 0; j < Asmm_eufar.operatorList.size(); j++) {
							if (Asmm_eufar.operatorsAircraft[i][0] == Asmm_eufar.operatorList.get(j)) {
								Asmm_eufar.fi_operatorText.setSelectedIndex(j);
								GuiModification.aircraftSelection(Asmm_eufar.operatorsAircraft[j][0]);
								break;
							}
						}
					}
				}
				if (l == 0) {
					Asmm_eufar.fi_operatorText.setSelectedIndex(14);
					GuiModification.aircraftSelection(Asmm_eufar.fi_operatorText.getSelectedItemText());
					Asmm_eufar.fi_otherOpsText.setText(operator);
				}
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'operator' failed: " + ex.getMessage());
			}
			
			try {
				aircraft = doc.getElementsByTagName("platform").item(0).getFirstChild().getNodeValue();
				for (int i = 0; i < Asmm_eufar.operatorsAircraft.length; i++) {
					if (aircraft == Asmm_eufar.operatorsAircraft[i][3]) {
						k = 1;
						if (Asmm_eufar.fi_aircraftText.getSelectedItemText() == Asmm_eufar.operatorsAircraft[i][1]) {
							break;
						} else if (Asmm_eufar.fi_aircraftText.getSelectedItemText() == "Make a choice...") {
							for (int j = 0; j < Asmm_eufar.fi_aircraftText.getItemCount(); j++) {
								if (Asmm_eufar.operatorsAircraft[i][1] == Asmm_eufar.fi_aircraftText.getItemText(j)) {
									Asmm_eufar.fi_aircraftText.setSelectedIndex(j);
									break;
								}
							}
						}
					}
				}
				if (l == 0) {
					Asmm_eufar.fi_otherAiText.setText(aircraft);
				} else if (l == 1 & k == 0) {
					String tmp = Asmm_eufar.fi_operatorText.getSelectedItemText();
					Asmm_eufar.fi_operatorText.setSelectedIndex(14);
					GuiModification.aircraftSelection(Asmm_eufar.fi_operatorText.getSelectedItemText());
					Asmm_eufar.fi_otherOpsText.setText(tmp);
					Asmm_eufar.fi_otherAiText.setText(aircraft);
				}
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'platform' failed: " + ex.getMessage());
			}
			int indexToFind = -1;
			try {
				String description = doc.getElementsByTagName("localisation").item(0).getFirstChild().getNodeValue();
				for (int i = 0; i < Asmm_eufar.continentList.size(); i++) {
					if (description == Asmm_eufar.continentList.get(i)) {
						Utilities.geoLocationSet(1);
						Asmm_eufar.geoDetailLst.setSelectedIndex(i);
						Asmm_eufar.geoLocationLst.setSelectedIndex(1);
						break;
					}
				}
				for (int i = 0; i < Asmm_eufar.countryList.size(); i++) {
					if (description == Asmm_eufar.countryList.get(i)) {
						Utilities.geoLocationSet(2);
						Asmm_eufar.geoDetailLst.setSelectedIndex(i);
						Asmm_eufar.geoLocationLst.setSelectedIndex(2);
						break;
					}
				}
				for (int i = 0; i < Asmm_eufar.oceanList.size(); i++) {
					if (description == Asmm_eufar.oceanList.get(i)) {
						Utilities.geoLocationSet(3);
						Asmm_eufar.geoDetailLst.setSelectedIndex(i);
						Asmm_eufar.geoLocationLst.setSelectedIndex(3);
						break;
					}
				}
				for (int i = 0; i < Asmm_eufar.regionList.size(); i++) {
					if (description == Asmm_eufar.regionList.get(i)) {
						Utilities.geoLocationSet(4);
						Asmm_eufar.geoDetailLst.setSelectedIndex(i);
						Asmm_eufar.geoLocationLst.setSelectedIndex(4);
						break;
					}
				}			
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'localisation' failed: " + ex.getMessage());
			}


			///////////////////////////
			/// Contact information ///
			///////////////////////////
			try {
				Asmm_eufar.ci_nameText.setText(doc.getElementsByTagName("contactname").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'contactname' failed: " + ex.getMessage());
			}
			indexToFind = -1;
			try {
				for (int i=0; i < Asmm_eufar.ci_roleText.getItemCount(); i++) {
					if (Asmm_eufar.ci_roleText.getItemText(i).equals(doc.getElementsByTagName("contactrole").item(0).getFirstChild().
							getNodeValue())) {
						indexToFind = i;
						break;
					}
				}
				Asmm_eufar.ci_roleText.setSelectedIndex(indexToFind);
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'contactrole' failed: " + ex.getMessage());
			}
			try {
				Asmm_eufar.ci_emailText.setText(doc.getElementsByTagName("contactemail").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'contactemail' failed: " + ex.getMessage());
			}


			///////////////////////
			/// Scientific aims ///
			///////////////////////
			NodeList scientificAims = doc.getElementsByTagName("sa_code");
			for (int i=0; i< scientificAims.getLength(); i++) {
				Utilities.checkBox(Asmm_eufar.saScroll, Asmm_eufar.scientificMap, scientificAims.item(i).getFirstChild().getNodeValue());
			}
			try {
				Asmm_eufar.sa_comArea.setText(doc.getElementsByTagName("sa_other").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'sa_other' failed: " + ex.getMessage());
			}
			NodeList saUser = doc.getElementsByTagName("sa_user");
			for (int i = 0; i < saUser.getLength(); i++) {
				String userDefined = saUser.item(i).getFirstChild().getNodeValue();
				GuiModification.addCat(Asmm_eufar.sa_addCatTable, Asmm_eufar.sa_addCatMap, Asmm_eufar.verticalPanel67, userDefined);
			}


			//////////////////////////////
			/// Geographic Information ///
			//////////////////////////////
			try {
				Asmm_eufar.gi_northText.setText(doc.getElementsByTagName("northboundlatitude").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'northboundlatitude' failed: " + ex.getMessage());
			}
			try {
				Asmm_eufar.gi_southText.setText(doc.getElementsByTagName("southboundlatitude").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'southboundlatitude' failed: " + ex.getMessage());
			}
			try {
				Asmm_eufar.gi_westText.setText(doc.getElementsByTagName("westboundlongitude").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'westboundlongitude' failed: " + ex.getMessage());
			}
			try {
				Asmm_eufar.gi_eastText.setText(doc.getElementsByTagName("eastboundlongitude").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'eastboundlongitude' failed: " + ex.getMessage());
			}
			try {
				Asmm_eufar.gi_minText.setText(doc.getElementsByTagName("minaltitude").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'minaltitude' failed: " + ex.getMessage());
			}
			try {
				Asmm_eufar.gi_maxText.setText(doc.getElementsByTagName("maxaltitude").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'maxaltitude' failed: " + ex.getMessage());
			}
			NodeList geographicInformation = doc.getElementsByTagName("gr_code");
			for (int i=0; i< geographicInformation.getLength(); i++) {
				Utilities.checkBox(Asmm_eufar.giScroll, Asmm_eufar.geographicMap, geographicInformation.item(i).getFirstChild().getNodeValue());
			}
			try {
				Asmm_eufar.gi_comArea.setText(doc.getElementsByTagName("gr_other").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'gr_other' failed: " + ex.getMessage());
			}
			NodeList giUser = doc.getElementsByTagName("gr_user");
			for (int i = 0; i < giUser.getLength(); i++) {
				String userDefined = giUser.item(i).getFirstChild().getNodeValue();
				GuiModification.addCat(Asmm_eufar.gi_addCatTable, Asmm_eufar.gi_addCatMap, Asmm_eufar.verticalPanel68, userDefined);
			}


			/////////////////////////////////////
			/// Atmospheric Synoptic Features ///
			/////////////////////////////////////
			NodeList atmosphericFeatures = doc.getElementsByTagName("af_code");
			for (int i=0; i< atmosphericFeatures.getLength(); i++) {
				Utilities.checkBox(Asmm_eufar.afScroll, Asmm_eufar.synopticMap, atmosphericFeatures.item(i).getFirstChild().getNodeValue());
			}
			try {
				Asmm_eufar.af_comArea.setText(doc.getElementsByTagName("af_other").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'af_other' failed: " + ex.getMessage());
			}
			NodeList afUser = doc.getElementsByTagName("af_user");
			for (int i = 0; i < afUser.getLength(); i++) {
				String userDefined = afUser.item(i).getFirstChild().getNodeValue();
				GuiModification.addCat(Asmm_eufar.af_addCatTable, Asmm_eufar.af_addCatMap, Asmm_eufar.verticalPanel69, userDefined);
			}


			///////////////////////////////////////////////////
			/// Cloud Types and Forms Sampled During Flight ///
			///////////////////////////////////////////////////
			NodeList cloudTypes = doc.getElementsByTagName("ct_code");
			for (int i=0; i< cloudTypes.getLength(); i++) {Utilities.checkBox(Asmm_eufar.ctScroll, Asmm_eufar.cloudMap, cloudTypes.item(i).getFirstChild().getNodeValue());}
			try {
				Asmm_eufar.ct_comArea.setText(doc.getElementsByTagName("ct_other").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'ct_other' failed: " + ex.getMessage());
			}
			NodeList ctUser = doc.getElementsByTagName("ct_user");
			for (int i = 0; i < ctUser.getLength(); i++) {
				String userDefined = ctUser.item(i).getFirstChild().getNodeValue();
				GuiModification.addCat(Asmm_eufar.ct_addCatTable, Asmm_eufar.ct_addCatMap, Asmm_eufar.verticalPanel70, userDefined);
			}


			//////////////////////////////////////////////////////////
			/// Cloud, Precipitation and Aerosol Particles Sampled ///
			//////////////////////////////////////////////////////////
			NodeList cpapTypes = doc.getElementsByTagName("ps_code");
			for (int i=0; i< cpapTypes.getLength(); i++) {
				Utilities.checkBox(Asmm_eufar.cpScroll, Asmm_eufar.cpapMap, cpapTypes.item(i).getFirstChild().getNodeValue());
			}
			try {
				Asmm_eufar.cp_comArea.setText(doc.getElementsByTagName("ps_other").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'ps_other' failed: " + ex.getMessage());
			}
			NodeList cpUser = doc.getElementsByTagName("ps_user");
			for (int i = 0; i < cpUser.getLength(); i++) {
				String userDefined = cpUser.item(i).getFirstChild().getNodeValue();
				GuiModification.addCat(Asmm_eufar.cp_addCatTable, Asmm_eufar.cp_addCatMap, Asmm_eufar.verticalPanel71, userDefined);
			}


			/////////////////////////////////////////
			/// Land or Oceans Surfaces Overflown ///
			/////////////////////////////////////////
			NodeList surfacesOverflown = doc.getElementsByTagName("so_code");
			for (int i=0; i< surfacesOverflown.getLength(); i++) {
				Utilities.checkBox(Asmm_eufar.loScroll, Asmm_eufar.surfacesMap, surfacesOverflown.item(i).getFirstChild().getNodeValue());
			}
			try {
				Asmm_eufar.lo_comArea.setText(doc.getElementsByTagName("so_other").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'so_other' failed: " + ex.getMessage());
			}
			NodeList loUser = doc.getElementsByTagName("so_user");
			for (int i = 0; i < loUser.getLength(); i++) {
				String userDefined = loUser.item(i).getFirstChild().getNodeValue();
				GuiModification.addCat(Asmm_eufar.lo_addCatTable, Asmm_eufar.lo_addCatMap, Asmm_eufar.verticalPanel72, userDefined);
			}


			/////////////////////////////////////
			/// Altitude Range of Measurement ///
			/////////////////////////////////////
			NodeList rangeMeasurement = doc.getElementsByTagName("ar_code");
			for (int i=0; i< rangeMeasurement.getLength(); i++) {
				Utilities.checkBox(Asmm_eufar.arScroll, Asmm_eufar.measurementMap, rangeMeasurement.item(i).getFirstChild().getNodeValue());
			}
			try {
				Asmm_eufar.ar_comArea.setText(doc.getElementsByTagName("ar_other").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'ar_other' failed: " + ex.getMessage());
			}
			NodeList arUser = doc.getElementsByTagName("ar_user");
			for (int i = 0; i < arUser.getLength(); i++) {
				String userDefined = arUser.item(i).getFirstChild().getNodeValue();
				GuiModification.addCat(Asmm_eufar.ar_addCatTable, Asmm_eufar.ar_addCatMap, Asmm_eufar.verticalPanel73, userDefined);
			}


			/////////////////////////////////
			/// Types of Flight Manoeuvre ///
			/////////////////////////////////
			NodeList flightManoeuvre = doc.getElementsByTagName("ft_code");
			for (int i=0; i< flightManoeuvre.getLength(); i++) {
				Utilities.checkBox(Asmm_eufar.fmScroll, Asmm_eufar.manoeuvreMap, flightManoeuvre.item(i).getFirstChild().getNodeValue());
			}
			try {
				Asmm_eufar.fm_comArea.setText(doc.getElementsByTagName("ft_other").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'ft_other' failed: " + ex.getMessage());
			}
			NodeList fmUser = doc.getElementsByTagName("ft_user");
			for (int i = 0; i < fmUser.getLength(); i++) {
				String userDefined = fmUser.item(i).getFirstChild().getNodeValue();
				GuiModification.addCat(Asmm_eufar.fm_addCatTable, Asmm_eufar.fm_addCatMap, Asmm_eufar.verticalPanel74, userDefined);
			}


			//////////////////////////////
			/// Satellite Coordination ///
			//////////////////////////////
			NodeList satelliteCoordination = doc.getElementsByTagName("sc_code");
			for (int i=0; i< satelliteCoordination.getLength(); i++) {
				Utilities.checkBox(Asmm_eufar.scScroll, Asmm_eufar.satelliteMap, satelliteCoordination.item(i).getFirstChild().getNodeValue());
			}
			try {
				Asmm_eufar.sc_comArea.setText(doc.getElementsByTagName("sc_other").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'sc_other' failed: " + ex.getMessage());
			}
			NodeList scUser = doc.getElementsByTagName("sc_user");
			for (int i = 0; i < scUser.getLength(); i++) {
				String userDefined = scUser.item(i).getFirstChild().getNodeValue();
				GuiModification.addCat(Asmm_eufar.sc_addCatTable, Asmm_eufar.sc_addCatMap, Asmm_eufar.verticalPanel75, userDefined);
			}


			/////////////////////////////////////////////
			/// Supporting Surface-based Observations ///
			/////////////////////////////////////////////
			NodeList groundSites = doc.getElementsByTagName("groundsite");
			for (int i=0; i< groundSites.getLength(); i++) {
				String string = groundSites.item(i).getFirstChild().getNodeValue();
				Utilities.addList(Asmm_eufar.so_groundSitesTable, string, Asmm_eufar.so_groundSitesList);
			}
			NodeList researchVessels = doc.getElementsByTagName("researchvessel");
			for (int i=0; i< researchVessels.getLength(); i++) {
				String string = researchVessels.item(i).getFirstChild().getNodeValue();
				Utilities.addList(Asmm_eufar.so_researchVesselsTable, string, Asmm_eufar.so_researchVesselsList);
			}
			NodeList armSites = doc.getElementsByTagName("armsite");
			for (int i=0; i< armSites.getLength(); i++) {
				String string = armSites.item(i).getFirstChild().getNodeValue();
				Utilities.addList(Asmm_eufar.so_armSitesTable, string, Asmm_eufar.so_armSitesList);
			}
			NodeList mobileSites = doc.getElementsByTagName("armmobile");
			for (int i=0; i< mobileSites.getLength(); i++) {
				String string = mobileSites.item(i).getFirstChild().getNodeValue();
				Utilities.addList(Asmm_eufar.so_mobileSitesTable, string, Asmm_eufar.so_mobileSitesList);
			}


			//////////////////////////////////////
			/// Additional Notes on the Flight ///
			//////////////////////////////////////
			try {
				Asmm_eufar.nf_comArea.setText(doc.getElementsByTagName("othercomments").item(0).getFirstChild().getNodeValue());
			} catch (Exception ex) {
				Asmm_eufar.rootLogger.log(Level.WARNING, "Element 'othercomments' failed: " + ex.getMessage());
			}
			Asmm_eufar.rootLogger.log(Level.INFO, "Reading of the file finished...");

		} catch (DOMException ex) {
			Asmm_eufar.rootLogger.log(Level.SEVERE, "A problem occured during the loading of the file...", ex);
			Window.alert("Could not parse XML document. A log has been saved on the server for debugging.");
		}
	}
}

