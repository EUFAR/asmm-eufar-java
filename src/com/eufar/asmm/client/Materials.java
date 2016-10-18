package com.eufar.asmm.client;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Materials {
	
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
	
	
	public static HashMap<HorizontalPanel, String> scientificMap() {
		HashMap<HorizontalPanel, String> map = new HashMap<HorizontalPanel, String>();
		map.put(Asmm_eufar.sa_satCalval, "Satellite Cal/Val");
		map.put(Asmm_eufar.sa_antPollution, "Anthropogenic pollution");
		map.put(Asmm_eufar.sa_mesoImpacts, "Mesoscale atmospheric impacts");
		map.put(Asmm_eufar.sa_microPhysics, "Microphysics (Cloud)");
		map.put(Asmm_eufar.sa_dyNamics, "Dynamics (Cloud)");
		map.put(Asmm_eufar.sa_radProperties, "Radiative properties (Cloud)");
		map.put(Asmm_eufar.sa_convDynamics, "Convection dynamics (Cloud)");
		map.put(Asmm_eufar.sa_gazChemistry, "Gas chemistry");
		map.put(Asmm_eufar.sa_oxyDants, "Oxydants (Gas chemistry)");
		map.put(Asmm_eufar.sa_orgAnics, "Organics (Gas chemistry)");
		map.put(Asmm_eufar.sa_other1, "Other (Gas chemistry)");
		map.put(Asmm_eufar.sa_aeroSol, "Aerosol");
		map.put(Asmm_eufar.sa_cloudImpacts, "Cloud microphysical impacts (Aerosol)");
		map.put(Asmm_eufar.sa_radImpacts, "Radiative properties/impacts (Aerosol)");
		map.put(Asmm_eufar.sa_radIation,"Radiation");
		map.put(Asmm_eufar.sa_atmSpectroscopy, "Atmospheric spectroscopy (Radiation)");
		map.put(Asmm_eufar.sa_surfProperties, "Surface properties/retrievals (Radiation)");
		map.put(Asmm_eufar.sa_other2, "Other (Radiation)");
		map.put(Asmm_eufar.sa_cloud, "Cloud (Boundary-layer)");
		map.put(Asmm_eufar.sa_dynAmics, "Dynamics (Boundary-layer)");
		return map;
	}

	
	public static HashMap<HorizontalPanel, String> geographicMap() {
		HashMap<HorizontalPanel, String> map = new HashMap<HorizontalPanel, String>();
		map.put(Asmm_eufar.gi_polar,"Polar");
		map.put(Asmm_eufar.gi_midLatitudes,"Mid-latitudes");
		map.put(Asmm_eufar.gi_subTropical,"Sub-tropical");
		map.put(Asmm_eufar.gi_tropical,"Tropical");
		map.put(Asmm_eufar.gi_maritime,"Maritime");
		map.put(Asmm_eufar.gi_continental,"Continental");
		map.put(Asmm_eufar.gi_oceanicIslands,"Oceanic islands");
		map.put(Asmm_eufar.gi_other,"Other (Geographical region)");
		return map;
	}
	
	
	public static HashMap<HorizontalPanel, String> synopticMap() {
		HashMap<HorizontalPanel, String> map = new HashMap<HorizontalPanel, String>();
		map.put(Asmm_eufar.af_stationary,"Stationary");
		map.put(Asmm_eufar.af_antiStationary,"Stationary anticyclonic");
		map.put(Asmm_eufar.af_cycloStationary,"Stationary cyclonic");
		map.put(Asmm_eufar.af_warmFront,"Warm front");
		map.put(Asmm_eufar.af_warmBelt,"Warm conveyor belt");
		map.put(Asmm_eufar.af_coldFront,"Cold front");
		map.put(Asmm_eufar.af_occludedFront,"Occluded front");
		map.put(Asmm_eufar.af_warmSector,"Warm sector");
		map.put(Asmm_eufar.af_airMass,"Post-cold-frontal air-mass");
		map.put(Asmm_eufar.af_airOutbreack,"Arctic cold-air outbreak");
		map.put(Asmm_eufar.af_orographicInfluence,"Orographic influence");
		map.put(Asmm_eufar.af_seabreezeFront,"Sea-breeze front");
		map.put(Asmm_eufar.af_foldIntrusion,"Stratospheric fold/intrusion");
		map.put(Asmm_eufar.af_convergenceLine,"Extended convergence line");
		map.put(Asmm_eufar.af_easterlyWave,"Easterly wave");
		map.put(Asmm_eufar.af_equatorialWave,"Equatorial wave");
		map.put(Asmm_eufar.af_tropicalCyclone,"Tropical cyclone");
		map.put(Asmm_eufar.af_organizedConvection,"Mesoscale organized convection");
		return map;
	}
	
	
	public static HashMap<HorizontalPanel, String> cloudMap() {
		HashMap<HorizontalPanel, String> map = new HashMap<HorizontalPanel, String>();
		map.put(Asmm_eufar.ct_waterClouds,"Water clouds");
		map.put(Asmm_eufar.ct_mixedphasedClouds,"Mixed-phase clouds");
		map.put(Asmm_eufar.ct_iceClouds,"Ice clouds");
		map.put(Asmm_eufar.ct_cirrus,"Cirrus");
		map.put(Asmm_eufar.ct_contrails,"Contrails");
		map.put(Asmm_eufar.ct_stratocumulus,"Stratocumulus");
		map.put(Asmm_eufar.ct_shallowCumulus,"Shallow cumulus");
		map.put(Asmm_eufar.ct_cumulusCongestus,"Cumulus congestus");
		map.put(Asmm_eufar.ct_cumulTower,"Cumulonimbus/towering cumulus");
		map.put(Asmm_eufar.ct_altoStracumul,"Altostratus/altocumulus");
		map.put(Asmm_eufar.ct_waveClouds,"Wave clouds");
		map.put(Asmm_eufar.ct_statiformClouds,"Deep frontal statiform clouds");
		map.put(Asmm_eufar.ct_freeAbove,"Cloud-free above aircraft");
		map.put(Asmm_eufar.ct_freeBelow,"Cloud-free below aircraft");
		return map;
	}
	
	
	public static HashMap<HorizontalPanel, String> cpapMap() {
		HashMap<HorizontalPanel, String> map = new HashMap<HorizontalPanel, String>();
		map.put(Asmm_eufar.cp_rain,"Rain");
		map.put(Asmm_eufar.cp_drizzle,"Drizzle");
		map.put(Asmm_eufar.cp_dropletsLiquid,"Droplets (Liquid)");
		map.put(Asmm_eufar.cp_pristineCrystals,"Pristine ice crystals");
		map.put(Asmm_eufar.cp_snowAggregates,"Snow/aggregates");
		map.put(Asmm_eufar.cp_graupelHail,"Graupel/hail");
		map.put(Asmm_eufar.cp_saltAerosol,"Sea-salt aerosol");
		map.put(Asmm_eufar.cp_continentalAerosol,"Continental aerosol");
		map.put(Asmm_eufar.cp_urbanPlume,"Urban plume");
		map.put(Asmm_eufar.cp_biomassBurning,"Biomass burning");
		map.put(Asmm_eufar.cp_desertDust,"Desert/mineral dust");
		map.put(Asmm_eufar.cp_volcanicAsh,"Volcanic ash");
		return map;
	}
	
	
	public static HashMap<HorizontalPanel, String> surfacesMap() {
		HashMap<HorizontalPanel, String> map = new HashMap<HorizontalPanel, String>();
		map.put(Asmm_eufar.lo_ocean,"Ocean");
		map.put(Asmm_eufar.lo_semiArid,"Semi-arid");
		map.put(Asmm_eufar.lo_seaIce,"Sea-ice");
		map.put(Asmm_eufar.lo_desert,"Desert");
		map.put(Asmm_eufar.lo_snow,"Snow");
		map.put(Asmm_eufar.lo_urban,"Urban");
		map.put(Asmm_eufar.lo_lakeIce,"Lake-ice");
		map.put(Asmm_eufar.lo_mountainous,"Mountainous");
		map.put(Asmm_eufar.lo_vegetation,"Vegetation");
		map.put(Asmm_eufar.lo_hilly,"Hilly");
		map.put(Asmm_eufar.lo_forest,"Forest");
		map.put(Asmm_eufar.lo_flat,"Flat");
		return map;
	}
	
	
	public static HashMap<HorizontalPanel, String> measurementMap() {
		HashMap<HorizontalPanel, String> map = new HashMap<HorizontalPanel, String>();
		map.put(Asmm_eufar.ar_boundaryLayer,"Boundary-layer");
		map.put(Asmm_eufar.ar_nearSurface,"Near-surface (Boundary-layer)");
		map.put(Asmm_eufar.ar_subCloud,"Sub-cloud (Boundary-layer)");
		map.put(Asmm_eufar.ar_inCloud,"In-cloud (Boundary-layer)");
		map.put(Asmm_eufar.ar_lowerTroposphere,"Lower troposphere");
		map.put(Asmm_eufar.ar_midTroposphere,"Mid troposphere");
		map.put(Asmm_eufar.ar_upperTroposphere,"Upper troposphere");
		map.put(Asmm_eufar.ar_lowerstratosphere,"Lower stratosphere");
		return map;
	}
	
	
	public static HashMap<HorizontalPanel, String> manoeuvreMap() {
		HashMap<HorizontalPanel, String> map = new HashMap<HorizontalPanel, String>();
		map.put(Asmm_eufar.fm_levelRuns,"Straight/level runs");
		map.put(Asmm_eufar.fm_stacked,"Stacked (Straight/level runs)");
		map.put(Asmm_eufar.fm_separated,"Separated (Straight/level runs)");
		map.put(Asmm_eufar.fm_racetracks,"Racetracks");
		map.put(Asmm_eufar.fm_orbits,"Orbits");
		map.put(Asmm_eufar.fm_lagrangianDescents,"Lagrangian descents");
		map.put(Asmm_eufar.fm_ascDescents,"Deep profile ascents/descents");
		map.put(Asmm_eufar.fm_dropsondeDeployed,"Dropsonde deployed");
		map.put(Asmm_eufar.fm_selfCalibration,"Self-calibration");
		return map;
	}
	
	
	public static HashMap<HorizontalPanel, String> satelliteMap() {
		HashMap<HorizontalPanel, String> map = new HashMap<HorizontalPanel, String>();
		map.put(Asmm_eufar.sc_metop,"METOP (Polar)");
		map.put(Asmm_eufar.sc_npoess,"NPOESS (Polar)");
		map.put(Asmm_eufar.sc_atrain,"A-train (Polar)");
		map.put(Asmm_eufar.sc_other,"Other (Polar)");
		map.put(Asmm_eufar.sc_msg,"MSG (Geosynch)");
		map.put(Asmm_eufar.sc_other2,"Other (Geosynch)");
		map.put(Asmm_eufar.sc_modis,"MODIS");
		map.put(Asmm_eufar.sc_cloudsat,"Cloudsat");
		map.put(Asmm_eufar.sc_caliop,"CALIOP");
		map.put(Asmm_eufar.sc_iasi,"IASI");
		map.put(Asmm_eufar.sc_airs,"AIRS");
		map.put(Asmm_eufar.sc_cris,"CriS");
		map.put(Asmm_eufar.sc_amsuMhs,"AMSU/MHS");
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
	
	
	public static ArrayList<TextBoxBase> textboxLst() {
		ArrayList<TextBoxBase> list = new ArrayList<TextBoxBase>();
		list.add(Asmm_eufar.fi_campaignText);
		list.add(Asmm_eufar.fi_flightText);
		list.add(Asmm_eufar.fi_scientistText);
		list.add(Asmm_eufar.fi_managerText);
		list.add(Asmm_eufar.ci_nameText);
		list.add(Asmm_eufar.ci_emailText);
		list.add(Asmm_eufar.sa_comArea);
		list.add(Asmm_eufar.gi_northText);
		list.add(Asmm_eufar.gi_southText);
		list.add(Asmm_eufar.gi_minText);
		list.add(Asmm_eufar.gi_maxText);
		list.add(Asmm_eufar.gi_westText);
		list.add(Asmm_eufar.gi_eastText);
		list.add(Asmm_eufar.gi_comArea);
		list.add(Asmm_eufar.af_comArea);
		list.add(Asmm_eufar.ct_comArea);
		list.add(Asmm_eufar.cp_comArea);
		list.add(Asmm_eufar.lo_comArea);
		list.add(Asmm_eufar.ar_comArea);
		list.add(Asmm_eufar.fm_comArea);
		list.add(Asmm_eufar.sc_comArea);
		list.add(Asmm_eufar.nf_comArea);
		return list;
	}
	
	
	public static ArrayList<ListBox> listboxLst() {
		ArrayList<ListBox> list = new ArrayList<ListBox>();
		list.add(Asmm_eufar.fi_operatorText);
		list.add(Asmm_eufar.fi_aircraftText);
		list.add(Asmm_eufar.geoDetailLst);
		list.add(Asmm_eufar.ci_roleText);		
		return list;
	}
	
	
	public static ArrayList<HorizontalPanel> checkboxLst() {
        ArrayList<HorizontalPanel> list = new ArrayList<HorizontalPanel>();
        list.add(Asmm_eufar.sa_satCalval);
        list.add(Asmm_eufar.sa_antPollution);
        list.add(Asmm_eufar.sa_mesoImpacts);
        list.add(Asmm_eufar.sa_microPhysics);
        list.add(Asmm_eufar.sa_dyNamics);
        list.add(Asmm_eufar.sa_radProperties);
        list.add(Asmm_eufar.sa_convDynamics);
        list.add(Asmm_eufar.sa_gazChemistry);
        list.add(Asmm_eufar.sa_oxyDants);
        list.add(Asmm_eufar.sa_orgAnics);
        list.add(Asmm_eufar.sa_other1);
        list.add(Asmm_eufar.sa_aeroSol);
        list.add(Asmm_eufar.sa_cloudImpacts);
        list.add(Asmm_eufar.sa_radImpacts);
        list.add(Asmm_eufar.sa_radIation);
        list.add(Asmm_eufar.sa_atmSpectroscopy);
        list.add(Asmm_eufar.sa_surfProperties);
        list.add(Asmm_eufar.sa_other2);
        list.add(Asmm_eufar.sa_cloud);
        list.add(Asmm_eufar.sa_dynAmics);
        list.add(Asmm_eufar.gi_polar);
        list.add(Asmm_eufar.gi_midLatitudes);
        list.add(Asmm_eufar.gi_subTropical);
        list.add(Asmm_eufar.gi_tropical);
        list.add(Asmm_eufar.gi_maritime);
        list.add(Asmm_eufar.gi_continental);
        list.add(Asmm_eufar.gi_oceanicIslands);
        list.add(Asmm_eufar.gi_other);
        list.add(Asmm_eufar.af_stationary);
        list.add(Asmm_eufar.af_antiStationary);
        list.add(Asmm_eufar.af_cycloStationary);
        list.add(Asmm_eufar.af_warmFront);
        list.add(Asmm_eufar.af_warmBelt);
        list.add(Asmm_eufar.af_coldFront);
        list.add(Asmm_eufar.af_occludedFront);
        list.add(Asmm_eufar.af_warmSector);
        list.add(Asmm_eufar.af_airMass);
        list.add(Asmm_eufar.af_airOutbreack);
        list.add(Asmm_eufar.af_orographicInfluence);
        list.add(Asmm_eufar.af_seabreezeFront);
        list.add(Asmm_eufar.af_foldIntrusion);
        list.add(Asmm_eufar.af_convergenceLine);
        list.add(Asmm_eufar.af_easterlyWave);
        list.add(Asmm_eufar.af_equatorialWave);
        list.add(Asmm_eufar.af_tropicalCyclone);
        list.add(Asmm_eufar.af_organizedConvection);
        list.add(Asmm_eufar.ct_waterClouds);
        list.add(Asmm_eufar.ct_mixedphasedClouds);
        list.add(Asmm_eufar.ct_iceClouds);
        list.add(Asmm_eufar.ct_cirrus);
        list.add(Asmm_eufar.ct_contrails);
        list.add(Asmm_eufar.ct_stratocumulus);
        list.add(Asmm_eufar.ct_shallowCumulus);
        list.add(Asmm_eufar.ct_cumulusCongestus);
        list.add(Asmm_eufar.ct_cumulTower);
        list.add(Asmm_eufar.ct_altoStracumul);
        list.add(Asmm_eufar.ct_waveClouds);
        list.add(Asmm_eufar.ct_statiformClouds);
        list.add(Asmm_eufar.ct_freeAbove);
        list.add(Asmm_eufar.ct_freeBelow);
        list.add(Asmm_eufar.cp_rain);
        list.add(Asmm_eufar.cp_drizzle);
        list.add(Asmm_eufar.cp_dropletsLiquid);
        list.add(Asmm_eufar.cp_pristineCrystals);
        list.add(Asmm_eufar.cp_snowAggregates);
        list.add(Asmm_eufar.cp_graupelHail);
        list.add(Asmm_eufar.cp_saltAerosol);
        list.add(Asmm_eufar.cp_continentalAerosol);
        list.add(Asmm_eufar.cp_urbanPlume);
        list.add(Asmm_eufar.cp_biomassBurning);
        list.add(Asmm_eufar.cp_desertDust);
        list.add(Asmm_eufar.cp_volcanicAsh);
        list.add(Asmm_eufar.lo_ocean);
        list.add(Asmm_eufar.lo_semiArid);
        list.add(Asmm_eufar.lo_seaIce);
        list.add(Asmm_eufar.lo_desert);
        list.add(Asmm_eufar.lo_snow);
        list.add(Asmm_eufar.lo_urban);
        list.add(Asmm_eufar.lo_lakeIce);
        list.add(Asmm_eufar.lo_mountainous);
        list.add(Asmm_eufar.lo_vegetation);
        list.add(Asmm_eufar.lo_hilly);
        list.add(Asmm_eufar.lo_forest);
        list.add(Asmm_eufar.lo_flat);
        list.add(Asmm_eufar.ar_boundaryLayer);
        list.add(Asmm_eufar.ar_nearSurface);
        list.add(Asmm_eufar.ar_subCloud);
        list.add(Asmm_eufar.ar_inCloud);
        list.add(Asmm_eufar.ar_lowerTroposphere);
        list.add(Asmm_eufar.ar_midTroposphere);
        list.add(Asmm_eufar.ar_upperTroposphere);
        list.add(Asmm_eufar.ar_lowerstratosphere);
        list.add(Asmm_eufar.fm_levelRuns);
        list.add(Asmm_eufar.fm_stacked);
        list.add(Asmm_eufar.fm_separated);
        list.add(Asmm_eufar.fm_racetracks);
        list.add(Asmm_eufar.fm_orbits);
        list.add(Asmm_eufar.fm_lagrangianDescents);
        list.add(Asmm_eufar.fm_ascDescents);
        list.add(Asmm_eufar.fm_dropsondeDeployed);
        list.add(Asmm_eufar.fm_selfCalibration);
        list.add(Asmm_eufar.sc_metop);
        list.add(Asmm_eufar.sc_npoess);
        list.add(Asmm_eufar.sc_atrain);
        list.add(Asmm_eufar.sc_other);
        list.add(Asmm_eufar.sc_msg);
        list.add(Asmm_eufar.sc_other2);
        list.add(Asmm_eufar.sc_modis);
        list.add(Asmm_eufar.sc_cloudsat);
        list.add(Asmm_eufar.sc_caliop);
        list.add(Asmm_eufar.sc_iasi);
        list.add(Asmm_eufar.sc_airs);
        list.add(Asmm_eufar.sc_cris);
        list.add(Asmm_eufar.sc_amsuMhs);
        return list;
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
	
	
	public static ArrayList<TextBoxBase> requiredTextboxLst() {
		ArrayList<TextBoxBase> list = new ArrayList<TextBoxBase>();
		list.add(Asmm_eufar.fi_flightText);
		list.add(Asmm_eufar.fi_campaignText);
		list.add(Asmm_eufar.fi_scientistText);
		list.add(Asmm_eufar.fi_managerText);
		list.add(Asmm_eufar.fi_otherOpsText);
		list.add(Asmm_eufar.fi_otherAiText);
		list.add(Asmm_eufar.ci_nameText);
		list.add(Asmm_eufar.ci_emailText);
		return list;
	}
	
	
	public static ArrayList<String> correctTextboxLst() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("string");
		list.add("string");
		list.add("string");
		list.add("string");
		list.add("string");
		list.add("string");
		list.add("string");
		list.add("email");
		return list;
	}
	
	
	public static ArrayList<ListBox> requiredListboxLst() {
		ArrayList<ListBox> list = new ArrayList<ListBox>();
		list.add(Asmm_eufar.fi_operatorText);
		list.add(Asmm_eufar.fi_aircraftText);
		list.add(Asmm_eufar.geoLocationLst);
		list.add(Asmm_eufar.geoDetailLst);
		list.add(Asmm_eufar.ci_roleText);
		return list;
	}
	
	
	public static interface Resources extends ClientBundle {
        @Source("images/menu_tab_arrow_v3.png")
        ImageResource menu();
        
        @Source("images/info_icon.svg")
    	@MimeType("image/svg+xml")
    	DataResource info();
        
        @Source("images/fwd_tab_arrow_v3.svg")
    	@MimeType("image/svg+xml")
    	DataResource next();
        
        @Source("images/bwd_tab_arrow_v3.svg")
    	@MimeType("image/svg+xml")
    	DataResource back();
        
        @Source("images/plus_icon.svg")
        @MimeType("image/svg+xml")
        DataResource plus();
        
        @Source("images/del_icon.svg")
        @MimeType("image/svg+xml")
        DataResource delete();
        
        @Source("images/fwdarrow_icon.svg")
        @MimeType("image/svg+xml")
        DataResource forward();
        
        @Source("images/about_popup_icon.svg")
        @MimeType("image/svg+xml")
        DataResource aboutPopup();

        @Source("images/info_popup_icon.svg")
        @MimeType("image/svg+xml")
        DataResource infoPopup();

        @Source("images/save_popup_icon.svg")
        @MimeType("image/svg+xml")
        DataResource savePopup();
        
        @Source("images/changelog_popup_icon.svg")
        @MimeType("image/svg+xml")
        DataResource changelogPopup();
        
        @Source("images/xml_popup_icon.svg")
        @MimeType("image/svg+xml")
        DataResource xmlPopup();
        
        @Source("images/open_popup_icon.svg")
        @MimeType("image/svg+xml")
        DataResource openPopup();
        
        @Source("images/warning_popup_icon.svg")
        @MimeType("image/svg+xml")
        DataResource warningPopup();
        
        @Source("images/print_popup_icon.svg")
        @MimeType("image/svg+xml")
        DataResource printPopup();
        
        @Source("images/open_image_popup_icon.svg")
        @MimeType("image/svg+xml")
        DataResource imagePopup();
    }
	
	
	
}
