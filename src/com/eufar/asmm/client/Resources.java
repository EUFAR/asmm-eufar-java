package com.eufar.asmm.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

public class Resources {
	
	
	public static HashMap<VerticalPanel, String> parentMap() {
		HashMap<VerticalPanel, String> map = new HashMap<VerticalPanel, String>();
		map.put(Asmm_eufar.verticalPanel67,"SA");
		map.put(Asmm_eufar.verticalPanel68,"GI");
		map.put(Asmm_eufar.verticalPanel69,"AF");
		map.put(Asmm_eufar.verticalPanel70,"CT");
		map.put(Asmm_eufar.verticalPanel71,"CP");
		map.put(Asmm_eufar.verticalPanel72,"LO");
		map.put(Asmm_eufar.verticalPanel73,"AR");
		map.put(Asmm_eufar.verticalPanel74,"FM");
		map.put(Asmm_eufar.verticalPanel75,"SC");
		return map;
	}
	
	
	public static TreeMap<String, String> scientificMap() {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("Satellite Cal/Val", "Satellite Cal/Val");
		map.put("Anthropogenic pollution", "Anthropogenic pollution");
		map.put("Mesoscale atmospheric impacts", "esoscale atmospheric impacts");
		map.put("Microphysics", "Microphysics");
		map.put("Dynamics (Cloud)", "Dynamics (Cloud)");
		map.put("Radiative properties", "Radiative properties");
		map.put("Convection dynamics", "Convection dynamics");
		map.put("Gas chemistry", "Gas chemistry");
		map.put("Oxydants", "Oxydants");
		map.put("Organics", "Organics");
		map.put("Other (Gas chemistry)", "Other (Gas chemistry)");
		map.put("Aerosol", "Aerosol");
		map.put("Cloud microphysical impacts", "Cloud microphysical impacts");
		map.put("Radiative properties/impacts", "Radiative properties/impacts");
		map.put("Radiation","Radiation");
		map.put("Atmospheric spectroscopy", "Atmospheric spectroscopy");
		map.put("Surface properties/retrievals", "Surface properties/retrievals");
		map.put("Other (Radiation)", "Other (Radiation)");
		map.put("Cloud", "Cloud (Boundary-layer)");
		map.put("Dynamics (Boundary-layer)", "Dynamics (Boundary-layer)");
		return map;
	}

	
	public static TreeMap<String, String> geographicMap() {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("Polar","Polar");
		map.put("Mid-latitudes","Mid-latitudes");
		map.put("Sub-tropical","Sub-tropical");
		map.put("Tropical","Tropical");
		map.put("Maritime","Maritime");
		map.put("Continental","Continental");
		map.put("Oceanic islands","Oceanic islands");
		map.put("Other","Other");
		return map;
	}
	
	
	public static TreeMap<String, String> synopticMap() {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("Stationary","Stationary");
		map.put("anticyclonic","Stationary anticyclonic");
		map.put("cyclonic","Stationary cyclonic");
		map.put("Warm front","Warm front");
		map.put("Warm conveyor belt","Warm conveyor belt");
		map.put("Cold front","Cold front");
		map.put("Occluded front","Occluded front");
		map.put("Warm sector","Warm sector");
		map.put("Post-cold-frontal air-mass","Post-cold-frontal air-mass");
		map.put("Arctic cold-air outbreak","Arctic cold-air outbreak");
		map.put("Orographic influence","Orographic influence");
		map.put("Sea-breeze front","Sea-breeze front");
		map.put("Stratospheric fold/intrusion","Stratospheric fold/intrusion");
		map.put("Extended convergence line","Extended convergence line");
		map.put("Easterly wave","Easterly wave");
		map.put("Equatorial wave","Equatorial wave");
		map.put("Tropical cyclone","Tropical cyclone");
		map.put("Mesoscale organized convection","Mesoscale organized convection");
		return map;
	}
	
	
	public static TreeMap<String, String> cloudMap() {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("Water clouds","Water clouds");
		map.put("Mixed-phase clouds","Mixed-phase clouds");
		map.put("Ice clouds","Ice clouds");
		map.put("Cirrus","Cirrus");
		map.put("Contrails","Contrails");
		map.put("Stratocumulus","Stratocumulus");
		map.put("Shallow cumulus","Shallow cumulus");
		map.put("Cumulus congestus","Cumulus congestus");
		map.put("Cumulonimbus/towering cumulus","Cumulonimbus/towering cumulus");
		map.put("Altostratus/altocumulus","Altostratus/altocumulus");
		map.put("Wave clouds","Wave clouds");
		map.put("Deep frontal statiform clouds","Deep frontal statiform clouds");
		map.put("Cloud-free above aircraft","Cloud-free above aircraft");
		map.put("Cloud-free below aircraft","Cloud-free below aircraft");
		return map;
	}

	
	public static TreeMap<String, String> cpapMap() {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("Rain","Rain");
		map.put("Drizzle","Drizzle");
		map.put("Droplets (liquid)","Droplets (liquid)");
		map.put("Pristine ice crystals","Pristine ice crystals");
		map.put("Snow/aggregates","Snow/aggregates");
		map.put("Graupel/hail","Graupel/hail");
		map.put("Sea-salt aerosol","Sea-salt aerosol");
		map.put("Continental aerosol","Continental aerosol");
		map.put("Urban plume","Urban plume");
		map.put("Biomass burning","Biomass burning");
		map.put("Desert/mineral dust","Desert/mineral dust");
		map.put("Volcanic ash","Volcanic ash");
		return map;
	}

	
	public static TreeMap<String, String> surfacesMap() {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("Ocean","Ocean");
		map.put("Semi-arid","Semi-arid");
		map.put("Sea-ice","Sea-ice");
		map.put("Desert","Desert");
		map.put("Snow","Snow");
		map.put("Urban","Urban");
		map.put("Lake-ice","Lake-ice");
		map.put("Mountainous","Mountainous");
		map.put("Vegetation","Vegetation");
		map.put("Hilly","Hilly");
		map.put("Forest","Forest");
		map.put("Flat","Flat");
		return map;
	}

	
	public static TreeMap<String, String> measurementMap() {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("Boundary-layer","Boundary-layer");
		map.put("near-surface","Boundary-layer near-surface");
		map.put("sub-cloud","Boundary-layer sub-cloud");
		map.put("in-cloud","Boundary-layer in-cloud");
		map.put("Lower troposphere","Lower troposphere");
		map.put("Mid troposphere","Mid troposphere");
		map.put("Upper troposphere","Upper troposphere");
		map.put("Lower stratosphere","Lower stratosphere");
		return map;
	}

	
	public static TreeMap<String, String> manoeuvreMap() {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("Straight/level runs","Straight/level runs");
		map.put("stacked","Straight/level runs stacked");
		map.put("separated","Straight/level runs separated");
		map.put("Racetracks","Racetracks");
		map.put("Orbits","Orbits");
		map.put("Lagrangian descents","Lagrangian descents");
		map.put("Deep profile ascents/descents","Deep profile ascents/descents");
		map.put("Dropsonde deployed","Dropsonde deployed");
		map.put("Self-calibration","Self-calibration");
		return map;
	}
	
	
	public static TreeMap<String, String> satelliteMap() {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("METOP","METOP");
		map.put("NPOESS","NPOESS");
		map.put("A-train","A-train");
		map.put("Other (Polar)","Other (Polar)");
		map.put("MSG","MSG");
		map.put("Other (Geosynch)","Other (Geosynch)");
		map.put("MODIS","MODIS");
		map.put("Cloudsat","Cloudsat");
		map.put("CALIOP","CALIOP");
		map.put("IASI","IASI");
		map.put("AIRS","AIRS");
		map.put("CriS","CriS");
		map.put("AMSU/MHS","AMSU/MHS");
		return map;
	}
	
	
	public static ArrayList<String> roleList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Make a choice...");
		list.add("Flight Manager");
		list.add("Mission Scientist");
		list.add("Other");
		list.add("Pilot");
		list.add("Scientist");
		return list;
	}
	
	public static ArrayList<String> operatorList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Make a choice...");
		list.add("Other...");
		list.add("Alfred Wegener Institute");
		list.add("CNR - Istituto per i Sistemi Agricoli e Forestali del Mediterraneo");
		list.add("CNR - Istituto di Metodologie per l'Analisi Ambientale");
		list.add("Deutsches Zentrum fur Luft- und Raumfahrt");
		list.add("ENVISCOPE");
		list.add("NERC - Facility for Airborne Atmospheric Measurements");
		list.add("FUB - Institut fur Weltraumwissenschaften");
		list.add("Instituto Nacional de Tecnica Aeroespacial");
		list.add("KIT - Institute of Meteorology and Climate Research");
		list.add("NERC - Airborne Research and Survey Facility");
		list.add("NERC - British Antarctic Survey");
		list.add("SAFIRE");
		list.add("UEDIN - Airborne GeoSciences");
    	return list;
	}
	
	
	public static ArrayList<String> aircraftList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("BT-67 POLAR 5");
		list.add("Sky Arrow 650");
		list.add("Partenavia P-68");
		list.add("Cessna 208");
		list.add("Dornier DO-228 D-CFFU");
		list.add("Dornier DO-228 D-CODE");
		list.add("Mystere/Falcon 20");
		list.add("Learjet 35");
		list.add("BAe-146");
		list.add("Cessna 207");
		list.add("CASA-212 AR");
		list.add("CASA-212 RS");
		list.add("Enduro");
		list.add("Dornier DO-228");
		list.add("DHC-6 Twin Otter");
		list.add("ATR-42");
		list.add("Piper PA23");
		list.add("HK36TTC ECO Dimona");
    	return list;
    }
	
	
	public static HashMap<TextBoxBase, String> textboxName() {
		HashMap<TextBoxBase, String> map = new HashMap<TextBoxBase, String>();
		map.put(Asmm_eufar.fi_campaignText, "flightCampaign");
		map.put(Asmm_eufar.fi_flightText, "flightNumber");
	    map.put(Asmm_eufar.fi_scientistText, "flightScientist");
	    map.put(Asmm_eufar.fi_managerText, "flightManager");
	    map.put(Asmm_eufar.ci_nameText, "contactName");
	    map.put(Asmm_eufar.ci_emailText, "contactEmail");
	    map.put(Asmm_eufar.sa_comArea, "scientificComments");
	    map.put(Asmm_eufar.gi_northText, "northBound");
	    map.put(Asmm_eufar.gi_southText, "southBound");
	    map.put(Asmm_eufar.gi_minText, "minAltitude");
	    map.put(Asmm_eufar.gi_maxText, "maxAltitude");
	    map.put(Asmm_eufar.gi_westText, "westBound");
	    map.put(Asmm_eufar.gi_eastText, "eastBound");
	    map.put(Asmm_eufar.gi_comArea, "geographicComments");
	    map.put(Asmm_eufar.af_comArea, "atmosphericComments");
	    map.put(Asmm_eufar.ct_comArea, "typesComments");
	    map.put(Asmm_eufar.cp_comArea, "particlesComments");
	    map.put(Asmm_eufar.lo_comArea, "surfacesComments");
	    map.put(Asmm_eufar.ar_comArea, "measurementComments");
	    map.put(Asmm_eufar.fm_comArea, "manoeuvreComments");
	    map.put(Asmm_eufar.sc_comArea, "satelliteComments");
	    map.put(Asmm_eufar.nf_comArea, "additionalNotes");
		return map;
	}
	

	public static HashMap<HorizontalPanel, String> checkboxName() {
		HashMap<HorizontalPanel, String> map = new HashMap<HorizontalPanel, String>();
	    map.put(Asmm_eufar.sa_satCalval,"sa_satCalval");
		map.put(Asmm_eufar.sa_antPollution,"sa_antPollution");
		map.put(Asmm_eufar.sa_mesoImpacts,"sa_mesoImpacts");
		map.put(Asmm_eufar.sa_microPhysics,"sa_microPhysics");
		map.put(Asmm_eufar.sa_dyNamics,"sa_dyNamics");
		map.put(Asmm_eufar.sa_radProperties,"sa_radProperties");
		map.put(Asmm_eufar.sa_convDynamics,"sa_convDynamics");
		map.put(Asmm_eufar.sa_gazChemistry,"sa_gazChemistry");
		map.put(Asmm_eufar.sa_oxyDants,"sa_oxyDants");
		map.put(Asmm_eufar.sa_orgAnics,"sa_orgAnics");
		map.put(Asmm_eufar.sa_other1,"sa_other1");
		map.put(Asmm_eufar.sa_aeroSol,"sa_aeroSol");
		map.put(Asmm_eufar.sa_cloudImpacts,"sa_cloudImpacts");
		map.put(Asmm_eufar.sa_radImpacts,"sa_radImpacts");
		map.put(Asmm_eufar.sa_radIation,"sa_radIation");
		map.put(Asmm_eufar.sa_atmSpectroscopy,"sa_atmSpectroscopy");
		map.put(Asmm_eufar.sa_surfProperties,"sa_surfProperties");
		map.put(Asmm_eufar.sa_other2,"sa_other2");
		map.put(Asmm_eufar.sa_cloud,"sa_cloud");
		map.put(Asmm_eufar.sa_dynAmics,"sa_dynAmics");
		map.put(Asmm_eufar.gi_polar,"gi_polar");
		map.put(Asmm_eufar.gi_midLatitudes,"gi_midLatitudes");
		map.put(Asmm_eufar.gi_subTropical,"gi_subTropical");
		map.put(Asmm_eufar.gi_tropical,"gi_tropical");
		map.put(Asmm_eufar.gi_maritime,"gi_maritime");
		map.put(Asmm_eufar.gi_continental,"gi_continental");
		map.put(Asmm_eufar.gi_oceanicIslands,"gi_oceanicIslands");
		map.put(Asmm_eufar.gi_other,"gi_other");
		map.put(Asmm_eufar.af_stationary,"af_stationary");
		map.put(Asmm_eufar.af_antiStationary,"af_antiStationary");
		map.put(Asmm_eufar.af_cycloStationary,"af_cycloStationary");
		map.put(Asmm_eufar.af_warmFront,"af_warmFront");
		map.put(Asmm_eufar.af_warmBelt,"af_warmBelt");
		map.put(Asmm_eufar.af_coldFront,"af_coldFront");
		map.put(Asmm_eufar.af_occludedFront,"af_occludedFront");
		map.put(Asmm_eufar.af_warmSector,"af_warmSector");
		map.put(Asmm_eufar.af_airMass,"af_airMass");
		map.put(Asmm_eufar.af_airOutbreack,"af_airOutbreack");
		map.put(Asmm_eufar.af_orographicInfluence,"af_orographicInfluence");
		map.put(Asmm_eufar.af_seabreezeFront,"af_seabreezeFront");
		map.put(Asmm_eufar.af_foldIntrusion,"af_foldIntrusion");
		map.put(Asmm_eufar.af_convergenceLine,"af_convergenceLine");
		map.put(Asmm_eufar.af_easterlyWave,"af_easterlyWave");
		map.put(Asmm_eufar.af_equatorialWave,"af_equatorialWave");
		map.put(Asmm_eufar.af_tropicalCyclone,"af_tropicalCyclone");
		map.put(Asmm_eufar.af_organizedConvection,"af_organizedConvection");
		map.put(Asmm_eufar.ct_waterClouds,"ct_waterClouds");
		map.put(Asmm_eufar.ct_mixedphasedClouds,"ct_mixedphasedClouds");
		map.put(Asmm_eufar.ct_iceClouds,"ct_iceClouds");
		map.put(Asmm_eufar.ct_cirrus,"ct_cirrus");
		map.put(Asmm_eufar.ct_contrails,"ct_contrails");
		map.put(Asmm_eufar.ct_stratocumulus,"ct_stratocumulus");
		map.put(Asmm_eufar.ct_shallowCumulus,"ct_shallowCumulus");
		map.put(Asmm_eufar.ct_cumulusCongestus,"ct_cumulusCongestus");
		map.put(Asmm_eufar.ct_cumulTower,"ct_cumulTower");
		map.put(Asmm_eufar.ct_altoStracumul,"ct_altoStracumul");
		map.put(Asmm_eufar.ct_waveClouds,"ct_waveClouds");
		map.put(Asmm_eufar.ct_statiformClouds,"ct_statiformClouds");
		map.put(Asmm_eufar.ct_freeAbove,"ct_freeAbove");
		map.put(Asmm_eufar.ct_freeBelow,"ct_freeBelow");
		map.put(Asmm_eufar.cp_rain,"cp_rain");
		map.put(Asmm_eufar.cp_drizzle,"cp_drizzle");
		map.put(Asmm_eufar.cp_dropletsLiquid,"cp_dropletsLiquid");
		map.put(Asmm_eufar.cp_pristineCrystals,"cp_pristineCrystals");
		map.put(Asmm_eufar.cp_snowAggregates,"cp_snowAggregates");
		map.put(Asmm_eufar.cp_graupelHail,"cp_graupelHail");
		map.put(Asmm_eufar.cp_saltAerosol,"cp_saltAerosol");
		map.put(Asmm_eufar.cp_continentalAerosol,"cp_continentalAerosol");
		map.put(Asmm_eufar.cp_urbanPlume,"cp_urbanPlume");
		map.put(Asmm_eufar.cp_biomassBurning,"cp_biomassBurning");
		map.put(Asmm_eufar.cp_desertDust,"cp_desertDust");
		map.put(Asmm_eufar.cp_volcanicAsh,"cp_volcanicAsh");
		map.put(Asmm_eufar.lo_ocean,"lo_ocean");
		map.put(Asmm_eufar.lo_semiArid,"lo_semiArid");
		map.put(Asmm_eufar.lo_seaIce,"lo_seaIce");
		map.put(Asmm_eufar.lo_desert,"lo_desert");
		map.put(Asmm_eufar.lo_snow,"lo_snow");
		map.put(Asmm_eufar.lo_urban,"lo_urban");
		map.put(Asmm_eufar.lo_lakeIce,"lo_lakeIce");
		map.put(Asmm_eufar.lo_mountainous,"lo_mountainous");
		map.put(Asmm_eufar.lo_vegetation,"lo_vegetation");
		map.put(Asmm_eufar.lo_hilly,"lo_hilly");
		map.put(Asmm_eufar.lo_forest,"lo_forest");
		map.put(Asmm_eufar.lo_flat,"lo_flat");
		map.put(Asmm_eufar.ar_boundaryLayer,"ar_boundaryLayer");
		map.put(Asmm_eufar.ar_nearSurface,"ar_nearSurface");
		map.put(Asmm_eufar.ar_subCloud,"ar_subCloud");
		map.put(Asmm_eufar.ar_inCloud,"ar_inCloud");
		map.put(Asmm_eufar.ar_lowerTroposphere,"ar_lowerTroposphere");
		map.put(Asmm_eufar.ar_midTroposphere,"ar_midTroposphere");
		map.put(Asmm_eufar.ar_upperTroposphere,"ar_upperTroposphere");
		map.put(Asmm_eufar.ar_lowerstratosphere,"ar_lowerstratosphere");
		map.put(Asmm_eufar.fm_levelRuns,"fm_levelRuns");
		map.put(Asmm_eufar.fm_stacked,"fm_stacked");
		map.put(Asmm_eufar.fm_separated,"fm_separated");
		map.put(Asmm_eufar.fm_racetracks,"fm_racetracks");
		map.put(Asmm_eufar.fm_orbits,"fm_orbits");
		map.put(Asmm_eufar.fm_lagrangianDescents,"fm_lagrangianDescents");
		map.put(Asmm_eufar.fm_ascDescents,"fm_ascDescents");
		map.put(Asmm_eufar.fm_dropsondeDeployed,"fm_dropsondeDeployed");
		map.put(Asmm_eufar.fm_selfCalibration,"fm_selfCalibration");
		map.put(Asmm_eufar.sc_metop,"sc_metop");
		map.put(Asmm_eufar.sc_npoess,"sc_npoess");
		map.put(Asmm_eufar.sc_atrain,"sc_atrain");
		map.put(Asmm_eufar.sc_other,"sc_other");
		map.put(Asmm_eufar.sc_msg,"sc_msg");
		map.put(Asmm_eufar.sc_other2,"sc_other2");
		map.put(Asmm_eufar.sc_modis,"sc_modis");
		map.put(Asmm_eufar.sc_cloudsat,"sc_cloudsat");
		map.put(Asmm_eufar.sc_caliop,"sc_caliop");
		map.put(Asmm_eufar.sc_iasi,"sc_iasi");
		map.put(Asmm_eufar.sc_airs,"sc_airs");
		map.put(Asmm_eufar.sc_cris,"sc_cris");
		map.put(Asmm_eufar.sc_amsuMhs,"sc_amsuMhs");
		return map;
	}

	
	public static HashMap<ListBox, String> listboxName() {
		HashMap<ListBox, String> map = new HashMap<ListBox, String>();
		map.put(Asmm_eufar.fi_operatorText,"operatorText");
		map.put(Asmm_eufar.fi_aircraftText,"aircraftText");
		map.put(Asmm_eufar.geoLocationLst,"localisationText");
		map.put(Asmm_eufar.geoDetailLst,"countryText");
		map.put(Asmm_eufar.ci_roleText,"roleText");
		return map;
	}
	
	
	public static HashMap<DateBox, String> dateboxName() {
		HashMap<DateBox, String> map = new HashMap<DateBox, String>();
		map.put(Asmm_eufar.fi_dateText,"date");
		return map;
	}
	
	
	public static ArrayList<String> locationList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Make a choice...");
		list.add("Continents");
		list.add("Countries");
		list.add("Oceans");
		list.add("Regions");
		return list;
	}

	
	public static ArrayList<String> continentList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Make a choice...");
		list.add("Africa");
		list.add("Antarctica");
		list.add("Asia");
		list.add("Oceania");
		list.add("Europe");
		list.add("North America");
		list.add("South America");
		return list;
	}

	
	public static ArrayList<String> oceanList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Make a choice...");
		list.add("Atlantic Ocean");
		list.add("Arctic Ocean");
		list.add("Indian Ocean");
		list.add("Pacific Ocean");
		list.add("Southern Ocean");
		return list;
	}

	
	public static ArrayList<String> regionList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Make a choice...");
		list.add("Arctic Region");
		list.add("Atlantic Ocean Islands");
		list.add("Central Africa");
		list.add("Central America");
		list.add("Central Europe");
		list.add("Eastern Africa");
		list.add("Eastern Asia");
		list.add("Eastern Europe");
		list.add("Indian Ocean Islands");
		list.add("Middle East");
		list.add("North America");
		list.add("Northern Africa");
		list.add("Northern Europe");
		list.add("Pacific Islands");
		list.add("South America");
		list.add("Southcentral Asia");
		list.add("Southern Asia");
		list.add("Southern Europe");
		list.add("Western Africa");
		list.add("Western Asia");
		list.add("Western Europe");
		return list;
	}

	
	public static ArrayList<String> countryList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Make a choice...");
		list.add("Afghanistan");
		list.add("Albania");
		list.add("Algeria");
		list.add("Amazonia");
		list.add("American Samoa");
		list.add("Amsterdam And St. Paul Islands");
		list.add("Andaman Islands");
		list.add("Andorra");
		list.add("Angola");
		list.add("Anguilla");
		list.add("Antigua And Barbuda");
		list.add("Argentina");
		list.add("Armenia");
		list.add("Aruba");
		list.add("Ascension Island");
		list.add("Australia");
		list.add("Austria");
		list.add("Azerbaijan");
		list.add("Bahamas");
		list.add("Bahrain");
		list.add("Baker Island");
		list.add("Bangladesh");
		list.add("Barbados");
		list.add("Belarus");
		list.add("Belgium");
		list.add("Belize");
		list.add("Benin");
		list.add("Bhutan");
		list.add("Bolivia");
		list.add("Bonaire");
		list.add("Bosnia And Herzegovina");
		list.add("Botswana");
		list.add("Bouvet Island");
		list.add("Brazil");
		list.add("British Isles");
		list.add("Brunei");
		list.add("Bulgaria");
		list.add("Burkina Faso");
		list.add("Burma");
		list.add("Burundi");
		list.add("Cambodia");
		list.add("Cameroon");
		list.add("Canada");
		list.add("Caribbean");
		list.add("Cayman Islands");
		list.add("Central African Republic");
		list.add("Ceuta");
		list.add("Chad");
		list.add("Channel Islands");
		list.add("Chile");
		list.add("China");
		list.add("Christmas Island");
		list.add("Cocos Islands");
		list.add("Colombia");
		list.add("Comoros");
		list.add("Congo, Democratic Republic");
		list.add("Congo, Republic");
		list.add("Cook Islands");
		list.add("Corsica");
		list.add("Costa Rica");
		list.add("Cote D'ivoire");
		list.add("Croatia");
		list.add("Crozet Islands");
		list.add("Cuba");
		list.add("Curacao");
		list.add("Cyprus");
		list.add("Czech Republic");
		list.add("Denmark");
		list.add("Dhekelia");
		list.add("Djibouti");
		list.add("Dominica");
		list.add("Dominican Republic");
		list.add("Ecuador");
		list.add("Egypt");
		list.add("El Salvador");
		list.add("Equatorial Guinea");
		list.add("Eritrea");
		list.add("Estonia");
		list.add("Ethiopia");
		list.add("Faeroe Islands");
		list.add("Falkland Islands");
		list.add("Fiji");
		list.add("Finland");
		list.add("France");
		list.add("French Guiana");
		list.add("French Polynesia");
		list.add("Gabon");
		list.add("Galapagos Islands");
		list.add("Gambia");
		list.add("Gaza Strip");
		list.add("Georgia, Republic");
		list.add("Germany");
		list.add("Ghana");
		list.add("Gibraltar");
		list.add("Gough Island");
		list.add("Greece");
		list.add("Greenland");
		list.add("Grenada");
		list.add("Guadeloupe");
		list.add("Guam");
		list.add("Guatemala");
		list.add("Guinea");
		list.add("Guinea-Bissau");
		list.add("Guyana");
		list.add("Haiti");
		list.add("Hawaii Island");
		list.add("Hawaiian Islands");
		list.add("Honduras");
		list.add("Hong Kong");
		list.add("Howland Island");
		list.add("Hungary");
		list.add("Iceland");
		list.add("India");
		list.add("Indonesia");
		list.add("Iran");
		list.add("Iraq");
		list.add("Ireland");
		list.add("Israel");
		list.add("Italy");
		list.add("Jamaica");
		list.add("Japan");
		list.add("Jarvis Island");
		list.add("Johnston Atoll");
		list.add("Jordan");
		list.add("Kahoolawe");
		list.add("Kauai");
		list.add("Kazakhstan");
		list.add("Kenya");
		list.add("Kerguelen Islands");
		list.add("Kingman Reef");
		list.add("Kiribati");
		list.add("Kosovo");
		list.add("Kuwait");
		list.add("Kyrgyzstan");
		list.add("Laeso");
		list.add("Lake Chad");
		list.add("Lake Malawi");
		list.add("Lake Tanganyika");
		list.add("Lake Victoria");
		list.add("Lanai");
		list.add("Laos");
		list.add("Latvia");
		list.add("Lebanon");
		list.add("Lesotho");
		list.add("Liberia");
		list.add("Libya");
		list.add("Liechtenstein");
		list.add("Lithuania");
		list.add("Luxembourg");
		list.add("Macau");
		list.add("Macedonia");
		list.add("Madagascar");
		list.add("Madeira");
		list.add("Malawi");
		list.add("Malaysia");
		list.add("Maldives");
		list.add("Mali");
		list.add("Malta");
		list.add("Marshall Islands");
		list.add("Martinique");
		list.add("Maui");
		list.add("Mauritania");
		list.add("Mauritius");
		list.add("Melanesia");
		list.add("Mexico");
		list.add("Micronesia");
		list.add("Midway Atoll");
		list.add("Moldova");
		list.add("Molokai");
		list.add("Monaco");
		list.add("Mongolia");
		list.add("Montenegro");
		list.add("Montserrat");
		list.add("Morocco");
		list.add("Mozambique");
		list.add("Namibia");
		list.add("Nauru");
		list.add("Navassa Island");
		list.add("Nepal");
		list.add("Netherlands Antilles");
		list.add("Netherlands");
		list.add("New Caledonia");
		list.add("New Zealand");
		list.add("Nicaragua");
		list.add("Nicobar Islands");
		list.add("Niger");
		list.add("Nigeria");
		list.add("Niihau");
		list.add("Niue");
		list.add("Norfolk Island");
		list.add("North Korea");
		list.add("Northern Mariana Islands");
		list.add("Norway");
		list.add("Oahu");
		list.add("Okinawa");
		list.add("Oman");
		list.add("Pakistan");
		list.add("Palau");
		list.add("Palestine");
		list.add("Palmyra Atoll");
		list.add("Panama");
		list.add("Papua New Guinea");
		list.add("Paraguay");
		list.add("Peru");
		list.add("Philippines");
		list.add("Pitcairn Island");
		list.add("Pitcairn Islands");
		list.add("Poland");
		list.add("Polynesia");
		list.add("Portugal");
		list.add("Puerto Rico");
		list.add("Qatar");
		list.add("Red Sea");
		list.add("Reunion");
		list.add("Romania");
		list.add("Russia");
		list.add("Rwanda");
		list.add("Saba");
		list.add("Sable Island");
		list.add("Samoa");
		list.add("San Marino");
		list.add("Sao Tome And Principe");
		list.add("Sardinia");
		list.add("Saudi Arabia");
		list.add("Scandinavia");
		list.add("Senegal");
		list.add("Serbia");
		list.add("Seychelles");
		list.add("Sicily");
		list.add("Sierra Leone");
		list.add("Singapore");
		list.add("Slovakia");
		list.add("Slovenia");
		list.add("Solomon Islands");
		list.add("Somalia");
		list.add("South Africa");
		list.add("South Georgia Island");
		list.add("South Korea");
		list.add("South Orkney Islands");
		list.add("South Sandwich Islands");
		list.add("Spain");
		list.add("Spratly Islands");
		list.add("Sri Lanka");
		list.add("St Barthelemy");
		list.add("St Eustatius");
		list.add("St Helena");
		list.add("St Kitts And Nevis");
		list.add("St Lucia");
		list.add("St Maarten");
		list.add("St Martin");
		list.add("St Pierre And Miquelon");
		list.add("St Vincent And The Grenadines");
		list.add("Sudan");
		list.add("Suriname");
		list.add("Svalbard And Jan Mayen");
		list.add("Swaziland");
		list.add("Sweden");
		list.add("Switzerland");
		list.add("Syria");
		list.add("Taiwan");
		list.add("Tajikistan");
		list.add("Tanzania");
		list.add("Thailand");
		list.add("Togo");
		list.add("Tokelau");
		list.add("Tonga");
		list.add("Trinidad And Tobago");
		list.add("Tristan Da Cunha");
		list.add("Tunisia");
		list.add("Turkey");
		list.add("Turkmenistan");
		list.add("Turks And Caicos Islands");
		list.add("Tuvalu");
		list.add("Uganda");
		list.add("Ukraine");
		list.add("United Arab Emirates");
		list.add("United Kingdom");
		list.add("United States of America");
		list.add("Uruguay");
		list.add("Uzbekistan");
		list.add("Vanuatu");
		list.add("Vatican City");
		list.add("Venezuela");
		list.add("Vietnam");
		list.add("Virgin Islands");
		list.add("Wake Island");
		list.add("Wallis And Futuna Islands");
		list.add("Yemen");
		list.add("Zambia");
		list.add("Zanzibar");
		list.add("Zimbabwe");
		return list;
	}

	
	public static String[][] operatorsAircraft() {
		String[][] string = {{"Alfred Wegener Institute","BT-67 POLAR 5","AWI","BT-67"},
	        {"CNR - Istituto per i Sistemi Agricoli e Forestali del Mediterraneo","Sky Arrow 650","CNR-ISAFoM","Sky Arrow 650"},
	        {"CNR - Istituto di Metodologie per l'Analisi Ambientale","Partenavia P-68","CNR-IMAA","P-68"},
	        {"Deutsches Zentrum fur Luft- und Raumfahrt","Cessna 208","DLR","Cessna 208"},
	        {"Deutsches Zentrum fur Luft- und Raumfahrt","Dornier DO-228 D-CFFU","DLR","DO-228 D-CFFU"},
	        {"Deutsches Zentrum fur Luft- und Raumfahrt","Dornier DO-228 D-CODE","DLR","DO-228 D-CODE"},
	        {"Deutsches Zentrum fur Luft- und Raumfahrt","Mystere/Falcon 20","DLR","Mystere/Falcon 20"},
	        {"ENVISCOPE","Learjet 35","Enviscope","Learjet 35"},
	        {"ENVISCOPE","Partenavia P-68","Enviscope","P-68"},
	        {"NERC - Facility for Airborne Atmospheric Measurements","BAe-146","FAAM","BAe-146"},
	        {"FUB - Institut fur Weltraumwissenschaften","Cessna 207","FUB-ISS","Cessna 207"},
	        {"Instituto Nacional de Tecnica Aeroespacial","CASA-212 AR","INTA","CASA-212 AR"},
	        {"Instituto Nacional de Tecnica Aeroespacial","CASA-212 RS","INTA","CASA-212 RS"},
	        {"KIT - Institute of Meteorology and Climate Research","Enduro","KIT-IMK-IFU","Enduro"},
	        {"NERC - Airborne Research and Survey Facility","Dornier DO-228","NERC-ARSF","DO-228"},
	        {"NERC - British Antarctic Survey","DHC-6 Twin Otter","NERC-BAS","DHC-6"},
	        {"SAFIRE","ATR-42","SAFIRE","ATR-42"},
	        {"SAFIRE","Mystere/Falcon 20","SAFIRE","Mystere/Falcon 20"},
	        {"SAFIRE","Piper PA23","SAFIRE","PA23"},
	        {"UEDIN - Airborne GeoSciences","HK36TTC ECO Dimona","UEDIN-IAES","HK36TTC ECO Dimona"}};
		return string;
	}
	
	
	public static Image popupImage(final String string) {
		final Image image = new Image("icons/" + string + "_popup_icon.png");
		return image;
	}
	
	
	public static Image smallImage(final String string) {
		final Image image = new Image("icons/" + string + "_icon.png");
		return image;
	}
	
	
	public static HashMap<TextBoxBase, String> correctField() {
		HashMap<TextBoxBase, String> map = new HashMap<TextBoxBase, String>();
		map.put(Asmm_eufar.fi_flightText, "string");
		map.put(Asmm_eufar.fi_campaignText, "string");
		map.put(Asmm_eufar.fi_scientistText, "string");
		map.put(Asmm_eufar.fi_managerText, "string");
		map.put(Asmm_eufar.ci_nameText, "string");
		map.put(Asmm_eufar.ci_emailText, "email");
		return map;
	}
	
	
	public static HashMap<TextBoxBase, Label> requiredField() {
		HashMap<TextBoxBase, Label> map = new HashMap<TextBoxBase, Label>();
		map.put(Asmm_eufar.fi_flightText, Asmm_eufar.fi_flightLabel);
		map.put(Asmm_eufar.fi_campaignText, Asmm_eufar.fi_campaignLabel);
		map.put(Asmm_eufar.fi_scientistText, Asmm_eufar.fi_scientistLabel);
		map.put(Asmm_eufar.fi_managerText, Asmm_eufar.fi_managerLabel);
		map.put(Asmm_eufar.ci_nameText, Asmm_eufar.ci_nameLabel);
		map.put(Asmm_eufar.ci_emailText, Asmm_eufar.ci_emailLabel);
		return map;
	}
	
	
	public static HashMap<DateBox, Label> correctDate() {
		HashMap<DateBox, Label> map = new HashMap<DateBox, Label>();
		map.put(Asmm_eufar.fi_dateText, Asmm_eufar.fi_dateLabel);
		return map;
	}
}
