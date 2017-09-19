package com.eufar.asmm.client;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SuggestBox;
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
	
	
	public static HashMap<HorizontalPanel, String> scientificMapOld() {
		HashMap<HorizontalPanel, String> map = new HashMap<HorizontalPanel, String>();
		map.put(Asmm_eufar.sa_satCalval, "satelliteCalVal");
		map.put(Asmm_eufar.sa_antPollution, "anthroPollution");
		map.put(Asmm_eufar.sa_mesoImpacts, "mesoscaleImpacts");
		map.put(Asmm_eufar.sa_microPhysics, "cloudMicrophysics");
		map.put(Asmm_eufar.sa_dyNamics, "cloudDynamics");
		map.put(Asmm_eufar.sa_radProperties, "cloudRadiative");
		map.put(Asmm_eufar.sa_convDynamics, "cloudConvection");
		map.put(Asmm_eufar.sa_gazChemistry, "gasChem");
		map.put(Asmm_eufar.sa_oxyDants, "gasChemOrganics");
		map.put(Asmm_eufar.sa_orgAnics, "gasChemOxidants");
		map.put(Asmm_eufar.sa_other1, "gasChemOther");
		map.put(Asmm_eufar.sa_aeroSol, "aerosol");
		map.put(Asmm_eufar.sa_cloudImpacts, "aerosolMicrophysical");
		map.put(Asmm_eufar.sa_radImpacts, "aerosolRadiative");
		map.put(Asmm_eufar.sa_radIation,"radiation");
		map.put(Asmm_eufar.sa_atmSpectroscopy, "radiationAtmosSpectroscopy");
		map.put(Asmm_eufar.sa_surfProperties, "radiationSurfProperties");
		map.put(Asmm_eufar.sa_other2, "radiationOther");
		map.put(Asmm_eufar.sa_cloud, "blCloud");
		map.put(Asmm_eufar.sa_dynAmics, "blDynamics");
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
	
	
	public static HashMap<HorizontalPanel, String> geographicMapOld() {
		HashMap<HorizontalPanel, String> map = new HashMap<HorizontalPanel, String>();
		map.put(Asmm_eufar.gi_polar,"polar");
		map.put(Asmm_eufar.gi_midLatitudes,"midLatitudes");
		map.put(Asmm_eufar.gi_subTropical,"subTropical");
		map.put(Asmm_eufar.gi_tropical,"tropical");
		map.put(Asmm_eufar.gi_maritime,"maritime");
		map.put(Asmm_eufar.gi_continental,"continental");
		map.put(Asmm_eufar.gi_oceanicIslands,"oceanicIslands");
		map.put(Asmm_eufar.gi_other,"other");
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
	
	
	public static HashMap<HorizontalPanel, String> synopticMapOld() {
		HashMap<HorizontalPanel, String> map = new HashMap<HorizontalPanel, String>();
		map.put(Asmm_eufar.af_stationary,"stationary");
		map.put(Asmm_eufar.af_antiStationary,"stationaryAnticyclonic");
		map.put(Asmm_eufar.af_cycloStationary,"stationaryCyclonic");
		map.put(Asmm_eufar.af_warmFront,"warmFront");
		map.put(Asmm_eufar.af_warmBelt,"warmConveyorBelt");
		map.put(Asmm_eufar.af_coldFront,"coldFront");
		map.put(Asmm_eufar.af_occludedFront,"occludedFront");
		map.put(Asmm_eufar.af_warmSector,"warmSector");
		map.put(Asmm_eufar.af_airMass,"postColdFrontalAirMass");
		map.put(Asmm_eufar.af_airOutbreack,"arcticColdAirOutbreak");
		map.put(Asmm_eufar.af_orographicInfluence,"orographicInfluence");
		map.put(Asmm_eufar.af_seabreezeFront,"seaBreezeFront");
		map.put(Asmm_eufar.af_foldIntrusion,"stratosphericFold");
		map.put(Asmm_eufar.af_convergenceLine,"extendedConvergenceLine");
		map.put(Asmm_eufar.af_easterlyWave,"easterlyWave");
		map.put(Asmm_eufar.af_equatorialWave,"equatorialWave");
		map.put(Asmm_eufar.af_tropicalCyclone,"tropycalCyclone");
		map.put(Asmm_eufar.af_organizedConvection,"mesoscaleOrganizedConvection");
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
		map.put(Asmm_eufar.ct_statiformClouds,"Deep frontal stratiform clouds");
		map.put(Asmm_eufar.ct_freeAbove,"Cloud-free above aircraft");
		map.put(Asmm_eufar.ct_freeBelow,"Cloud-free below aircraft");
		return map;
	}
	
	
	public static HashMap<HorizontalPanel, String> cloudMapOld() {
		HashMap<HorizontalPanel, String> map = new HashMap<HorizontalPanel, String>();
		map.put(Asmm_eufar.ct_waterClouds,"waterClouds");
		map.put(Asmm_eufar.ct_mixedphasedClouds,"mixedPhaseClouds");
		map.put(Asmm_eufar.ct_iceClouds,"iceClouds");
		map.put(Asmm_eufar.ct_cirrus,"cirrus");
		map.put(Asmm_eufar.ct_contrails,"contrails");
		map.put(Asmm_eufar.ct_stratocumulus,"stratocumulus");
		map.put(Asmm_eufar.ct_shallowCumulus,"shallowCumulus");
		map.put(Asmm_eufar.ct_cumulusCongestus,"cumulusCongestus");
		map.put(Asmm_eufar.ct_cumulTower,"cumulonimbusToweringCumulus");
		map.put(Asmm_eufar.ct_altoStracumul,"altostratusAltocumulus");
		map.put(Asmm_eufar.ct_waveClouds,"waveClouds");
		map.put(Asmm_eufar.ct_statiformClouds,"deepFrontalStratiformClouds");
		map.put(Asmm_eufar.ct_freeAbove,"cloudFreeAboveAircraft");
		map.put(Asmm_eufar.ct_freeBelow,"cloudFreeBelowAircraft");
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
	
	
	public static HashMap<HorizontalPanel, String> cpapMapOld() {
		HashMap<HorizontalPanel, String> map = new HashMap<HorizontalPanel, String>();
		map.put(Asmm_eufar.cp_rain,"rain");
		map.put(Asmm_eufar.cp_drizzle,"drizzle");
		map.put(Asmm_eufar.cp_dropletsLiquid,"droplets");
		map.put(Asmm_eufar.cp_pristineCrystals,"pristineIceCrystals");
		map.put(Asmm_eufar.cp_snowAggregates,"snowOrAggregates");
		map.put(Asmm_eufar.cp_graupelHail,"graupelOrHail");
		map.put(Asmm_eufar.cp_saltAerosol,"seaSaltAerosol");
		map.put(Asmm_eufar.cp_continentalAerosol,"continentalAerosol");
		map.put(Asmm_eufar.cp_urbanPlume,"urbanPlume");
		map.put(Asmm_eufar.cp_biomassBurning,"biomassBurning");
		map.put(Asmm_eufar.cp_desertDust,"desertOrMineralDust");
		map.put(Asmm_eufar.cp_volcanicAsh,"volcanicAsh");
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
	
	
	public static HashMap<HorizontalPanel, String> surfacesMapOld() {
		HashMap<HorizontalPanel, String> map = new HashMap<HorizontalPanel, String>();
		map.put(Asmm_eufar.lo_ocean,"ocean");
		map.put(Asmm_eufar.lo_semiArid,"semiArid");
		map.put(Asmm_eufar.lo_seaIce,"seaIce");
		map.put(Asmm_eufar.lo_desert,"desert");
		map.put(Asmm_eufar.lo_snow,"snow");
		map.put(Asmm_eufar.lo_urban,"urban");
		map.put(Asmm_eufar.lo_lakeIce,"lakeIce");
		map.put(Asmm_eufar.lo_mountainous,"mountainous");
		map.put(Asmm_eufar.lo_vegetation,"vegetation");
		map.put(Asmm_eufar.lo_hilly,"hilly");
		map.put(Asmm_eufar.lo_forest,"forest");
		map.put(Asmm_eufar.lo_flat,"flat");
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
	
	
	public static HashMap<HorizontalPanel, String> measurementMapOld() {
		HashMap<HorizontalPanel, String> map = new HashMap<HorizontalPanel, String>();
		map.put(Asmm_eufar.ar_boundaryLayer,"boundaryLayer");
		map.put(Asmm_eufar.ar_nearSurface,"blNearSurface");
		map.put(Asmm_eufar.ar_subCloud,"blSubCloud");
		map.put(Asmm_eufar.ar_inCloud,"blInCloud");
		map.put(Asmm_eufar.ar_lowerTroposphere,"lowerTroposphere");
		map.put(Asmm_eufar.ar_midTroposphere,"midTroposphere");
		map.put(Asmm_eufar.ar_upperTroposphere,"upperTroposphere");
		map.put(Asmm_eufar.ar_lowerstratosphere,"lowerStratosphere");
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
	
	
	public static HashMap<HorizontalPanel, String> manoeuvreMapOld() {
		HashMap<HorizontalPanel, String> map = new HashMap<HorizontalPanel, String>();
		map.put(Asmm_eufar.fm_levelRuns,"straightLevelRuns");
		map.put(Asmm_eufar.fm_stacked,"stackedStraightLevelRuns");
		map.put(Asmm_eufar.fm_separated,"separatedStraightLevelRuns");
		map.put(Asmm_eufar.fm_racetracks,"racetracks");
		map.put(Asmm_eufar.fm_orbits,"orbits");
		map.put(Asmm_eufar.fm_lagrangianDescents,"lagrangianDescents");
		map.put(Asmm_eufar.fm_ascDescents,"deepProfileAscentDescents");
		map.put(Asmm_eufar.fm_dropsondeDeployed,"dropsondeDeployed");
		map.put(Asmm_eufar.fm_selfCalibration,"selfCalibration");
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
	
	
	public static HashMap<HorizontalPanel, String> satelliteMapOld() {
		HashMap<HorizontalPanel, String> map = new HashMap<HorizontalPanel, String>();
		map.put(Asmm_eufar.sc_metop,"polarMetop");
		map.put(Asmm_eufar.sc_npoess,"polarNpoess");
		map.put(Asmm_eufar.sc_atrain,"polarAtrain");
		map.put(Asmm_eufar.sc_other,"polarOther");
		map.put(Asmm_eufar.sc_msg,"geosynchMsg");
		map.put(Asmm_eufar.sc_other2,"geosynchOther");
		map.put(Asmm_eufar.sc_modis,"modis");
		map.put(Asmm_eufar.sc_cloudsat,"cloudsat");
		map.put(Asmm_eufar.sc_caliop,"caliop");
		map.put(Asmm_eufar.sc_iasi,"iasi");
		map.put(Asmm_eufar.sc_airs,"airs");
		map.put(Asmm_eufar.sc_cris,"cris");
		map.put(Asmm_eufar.sc_amsuMhs,"amsuMhs");
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
	
	
	public static ArrayList<SuggestBox> suggestboxLst() {
		ArrayList<SuggestBox> list = new ArrayList<SuggestBox>();
		list.add(Asmm_eufar.fi_campaignText);
		return list;
	}
	
	
	public static ArrayList<TextBoxBase> textboxLst() {
		ArrayList<TextBoxBase> list = new ArrayList<TextBoxBase>();
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
	
	
	public static HashMap<String, String> countryCodeList() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Afghanistan","AF");
		map.put("Aland Islands","AX");
		map.put("Albania","AL");
		map.put("Algeria","DZ");
		map.put("American Samoa","AS");
		map.put("Andorra","AD");
		map.put("Angola","AO");
		map.put("Anguilla","AI");
		map.put("Antarctica","AQ");
		map.put("Antigua And Barbuda","AG");
		map.put("Argentina","AR");
		map.put("Armenia","AM");
		map.put("Aruba","AW");
		map.put("Australia","AU");
		map.put("Austria","AT");
		map.put("Azerbaijan","AZ");
		map.put("Bahamas","BS");
		map.put("Bahrain","BH");
		map.put("Bangladesh","BD");
		map.put("Barbados","BB");
		map.put("Belarus","BY");
		map.put("Belgium","BE");
		map.put("Belize","BZ");
		map.put("Benin","BJ");
		map.put("Bermuda","BM");
		map.put("Bhutan","BT");
		map.put("Bolivia","BO");
		map.put("Bonaire","BQ");
		map.put("Bosnia And Herzegovina","BA");
		map.put("Botswana","BW");
		map.put("Bouvet Island","BV");
		map.put("Brazil","BR");
		map.put("British Indian Ocean Territory","IO");
		map.put("Brunei","BN");
		map.put("Bulgaria","BG");
		map.put("Burkina Faso","BF");
		map.put("Burundi","BI");
		map.put("Cabo Verde","CV");
		map.put("Cambodia","KH");
		map.put("Cameroon","CM");
		map.put("Canada","CA");
		map.put("Cayman Islands","KY");
		map.put("Central African Republic","CF");
		map.put("Chad","TD");
		map.put("Chile","CL");
		map.put("China","CN");
		map.put("Christmas Island","CX");
		map.put("Cocos Islands","CC");
		map.put("Colombia","CO");
		map.put("Comoros","KM");
		map.put("Congo, Democratic Republic","CD");
		map.put("Congo, Republic","CG");
		map.put("Cook Islands","CK");
		map.put("Costa Rica","CR");
		map.put("Cote d'Ivoire","CI");
		map.put("Croatia","HR");
		map.put("Cuba","CU");
		map.put("Curacao","CW");
		map.put("Cyprus","CY");
		map.put("Czech Republic","CZ");
		map.put("Denmark","DK");
		map.put("Djibouti","DJ");
		map.put("Dominica","DM");
		map.put("Dominican Republic","DO");
		map.put("Ecuador","EC");
		map.put("Egypt","EG");
		map.put("El Salvador","SV");
		map.put("Equatorial Guinea","GQ");
		map.put("Eritrea","ER");
		map.put("Estonia","EE");
		map.put("Ethiopia","ET");
		map.put("Falkland Islands","KF");
		map.put("Faroe Islands","FO");
		map.put("Fiji","FJ");
		map.put("Finland","FI");
		map.put("France","FR");
		map.put("French Guiana","GF");
		map.put("French Polynesia","PF");
		map.put("French Southern Territories","TF");
		map.put("Gabon","GA");
		map.put("Gambia","GM");
		map.put("Georgia, Republic","GE");
		map.put("Germany","DE");
		map.put("Ghana","GH");
		map.put("Gibraltar","GI");
		map.put("Greece","GR");
		map.put("Greenland","GL");
		map.put("Grenada","GD");
		map.put("Guadeloupe","GP");
		map.put("Guam","GU");
		map.put("Guatemala","GT");
		map.put("Guernsey","GG");
		map.put("Guinea","GN");
		map.put("Guinea-Bissau","GW");
		map.put("Guyana","GY");
		map.put("Haiti","HT");
		map.put("Heard Island and McDonald","HM");
		map.put("Holy See","VA");
		map.put("Honduras","HN");
		map.put("Hong Kong","HK");
		map.put("Hungary","HU");
		map.put("Iceland","IS");
		map.put("India","IN");
		map.put("Indonesia","ID");
		map.put("Iran","IR");
		map.put("Iraq","IQ");
		map.put("Ireland","IE");
		map.put("Isle of Man","IM");
		map.put("Israel","IL");
		map.put("Italy","IT");
		map.put("Jamaica","JM");
		map.put("Japan","JP");
		map.put("Jersey","JE");
		map.put("Jordan","JO");
		map.put("Kazakhstan","KZ");
		map.put("Kenya","KE");
		map.put("Kiribati","KI");
		map.put("Korea (the Democratic People's Republic of)","KP");
		map.put("Korea (the Republic of)","KR");
		map.put("Kuwait","KW");
		map.put("Kyrgyzstan","KG");
		map.put("Lao People's Democratic Republic (the)","LA");
		map.put("Latvia","LV");
		map.put("Lebanon","LB");
		map.put("Lesotho","LS");
		map.put("Liberia","LR");
		map.put("Libya","LY");
		map.put("Liechtenstein","LI");
		map.put("Lithuania","LT");
		map.put("Luxembourg","LU");
		map.put("Macao","MO");
		map.put("Macedonia","MK");
		map.put("Madagascar","MG");
		map.put("Malawi","MW");
		map.put("Malaysia","MY");
		map.put("Maldives","MV");
		map.put("Mali","ML");
		map.put("Malta","MT");
		map.put("Marshall Islands","MH");
		map.put("Martinique","MQ");
		map.put("Mauritania","MR");
		map.put("Mauritius","MU");
		map.put("Mayotte","YT");
		map.put("Mexico","MX");
		map.put("Micronesia","FM");
		map.put("Moldova","MD");
		map.put("Monaco","MC");
		map.put("Mongolia","MN");
		map.put("Montenegro","ME");
		map.put("Montserrat","MS");
		map.put("Morocco","MA");
		map.put("Mozambique","MZ");
		map.put("Myanmar","MM");
		map.put("Namibia","NA");
		map.put("Nauru","NR");
		map.put("Nepal","NP");
		map.put("Netherlands","NL");
		map.put("New Caledonia","NC");
		map.put("New Zealand","NZ");
		map.put("Nicaragua","NI");
		map.put("Niger","NE");
		map.put("Nigeria","NG");
		map.put("Niue","NU");
		map.put("Norfolk Island","NF");
		map.put("Northern Mariana Islands","MP");
		map.put("Norway","NO");
		map.put("Oman","OM");
		map.put("Pakistan","PK");
		map.put("Palau","PW");
		map.put("Palestine","PS");
		map.put("Panama","PA");
		map.put("Papua New Guinea","PG");
		map.put("Paraguay","PY");
		map.put("Peru","PE");
		map.put("Philippines","PH");
		map.put("Pitcairn","PN");
		map.put("Poland","PL");
		map.put("Portugal","PT");
		map.put("Puerto Rico","PR");
		map.put("Qatar","QA");
		map.put("Reunion","RE");
		map.put("Romania","RO");
		map.put("Russia","RU");
		map.put("Rwanda","RW");
		map.put("Saint Helena, Ascension and Tristan da Cunha","SH");
		map.put("Saint Kitts and Nevis","KN");
		map.put("Saint Lucia","LC");
		map.put("Saint Martin","MF");
		map.put("Saint Pierre and Miquelon","PM");
		map.put("Saint Vincent and the Grenadines","VC");
		map.put("Samoa","WS");
		map.put("San Marino","SM");
		map.put("Sao Tome And Principe","ST");
		map.put("Saudi Arabia","SA");
		map.put("Senegal","SN");
		map.put("Serbia","RS");
		map.put("Seychelles","SC");
		map.put("Sierra Leone","SL");
		map.put("Singapore","SG");
		map.put("Sint Maarten","SX");
		map.put("Slovakia","SK");
		map.put("Slovenia","SI");
		map.put("Solomon Islands","SB");
		map.put("Somalia","SO");
		map.put("South Africa","ZA");
		map.put("South Georgia and the South Sandwich Island","GS");
		map.put("South Sudan","SS");
		map.put("Spain","ES");
		map.put("Sri Lanka","LK");
		map.put("Sudan","SD");
		map.put("Suriname","SR");
		map.put("Svalbard And Jan Mayen","SJ");
		map.put("Swaziland","SZ");
		map.put("Sweden","SE");
		map.put("Switzerland","CH");
		map.put("Syria","SY");
		map.put("Taiwan","TW");
		map.put("Tajikistan","TJ");
		map.put("Tanzania","TZ");
		map.put("Thailand","TH");
		map.put("Timor-Leste","TL");
		map.put("Togo","TG");
		map.put("Tokelau","TK");
		map.put("Tonga","TO");
		map.put("Trinidad And Tobago","TT");
		map.put("Tunisia","TN");
		map.put("Turkey","TR");
		map.put("Turkmenistan","TM");
		map.put("Turks And Caicos Islands","TC");
		map.put("Tuvalu","TV");
		map.put("Uganda","UG");
		map.put("Ukraine","UA");
		map.put("United Arab Emirates","AE");
		map.put("United Kingdom","GB");
		map.put("United States Minor Outlying Islands","UM");
		map.put("United States of America","US");
		map.put("Uruguay","UY");
		map.put("Uzbekistan","UZ");
		map.put("Vanuatu","VU");
		map.put("Venezuela","VE");
		map.put("Vietnam","VN");
		map.put("Virgin Islands (British)","VG");
		map.put("Virgin Islands (U.S.)","VI");
		map.put("Wallis And Futuna","WF");
		map.put("Western Sahara","EH");
		map.put("Yemen","YE");
		map.put("Zambia","ZM");
		map.put("Zimbabwe","ZW");
		return map;
	}

	
	public static String[][] newOperatorsAircraft() {
		String[][] string = {{"AWI","Basler Turbo Conversions, BT-67","C-GAWI","DE"},
				{"CNR-ISAFoM","3I / Magnaghi Aeronautica, Sky Arrow 650 TCNS","I-AMMO","IT"},
				{"CNR-IMAA","Partenavia / Vulcanair, P-68 Observer 2","I-OBPC","IT"},
				{"CzechGlobe","Cessna Aircraft Company, C-208 B Grand Caravan","OK-CZG","CZ"},
				{"DLR","Cessna Aircraft Company, C-208 B Grand Caravan","D-FDLR","DE"},
				{"DLR","Dornier Flugzeugwerke, Do 228 - 212","D-CFFU","DE"},
				{"DLR","Dornier Flugzeugwerke, Do 228 - 101","D-CODE","DE"},
				{"DLR","Dassault Aviation, Mystere / Falcon 20 E-5","D-CMET","DE"},
				{"Enviscope","Partenavia / Vulcanair, P-68B","D-GERY","DE"},
				{"Enviscope","Learjet / Bombardier Aerospace, 35A","D-CGFD","DE"},
				{"FAAM","BAE Systems, BAe146-301","G-LUXE","GB"},
				{"FUB","Cessna Aircraft Company, T207A Turbo Skywagon","D-EAFU","DE"},
				{"INTA","Construcciones Aeronauticas S.A, C-212-200","EC-DTV","ES"},
				{"INTA","Construcciones Aeronauticas S.A, C-212-200","EC-DUQ","ES"},
				{"KIT, IMK-IFU","Ultraleichtflug Schmidtler, Enduro","D-MIFU","DE"},
				{"NERC","De Havilland Canada, DHC-6 Twin Otter","VP-FAZ","GB"},
				{"NERC","De Havilland Canada, DHC-6 Twin Otter","VP-FBL","GB"},
				{"SAFIRE","ATR, ATR42-320","F-HMTO","FR"},
				{"SAFIRE","Piper Aircraft, PA23-250 Aztec","F-BLEB","FR"},
				{"SAFIRE","Dassault Aviation, Mystere / Falcon 20 GF","F-GBTM","FR"},
				{"UEDIN","Diamond Aircraft, HK36 TTC ECO Dimona","G-GEOS","GB"}};
		return string;
	}
	
	
	public static ArrayList<SuggestBox> requiredSuggestboxLst() {
		ArrayList<SuggestBox> list = new ArrayList<SuggestBox>();
		list.add(Asmm_eufar.fi_campaignText);
		return list;
	}
	
	
	public static ArrayList<TextBoxBase> requiredTextboxLst() {
		ArrayList<TextBoxBase> list = new ArrayList<TextBoxBase>();
		list.add(Asmm_eufar.fi_flightText);
		list.add(Asmm_eufar.fi_scientistText);
		list.add(Asmm_eufar.fi_managerText);
		list.add(Asmm_eufar.fi_otherOpsText);
		list.add(Asmm_eufar.fi_otherAiText);
		list.add(Asmm_eufar.fi_otherManText);
		list.add(Asmm_eufar.fi_otherRegText);
		list.add(Asmm_eufar.ci_nameText);
		list.add(Asmm_eufar.ci_emailText);
		return list;
	}
	
	
	public static ArrayList<TextBoxBase> nonrequiredTextboxLst() {
		ArrayList<TextBoxBase> list = new ArrayList<TextBoxBase>();
		list.add(Asmm_eufar.gi_northText);
		list.add(Asmm_eufar.gi_southText);
		list.add(Asmm_eufar.gi_eastText);
		list.add(Asmm_eufar.gi_westText);
		list.add(Asmm_eufar.gi_minText);
		list.add(Asmm_eufar.gi_maxText);
		return list;
	}
	
	
	public static ArrayList<String> correctSuggestboxLst() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("string");
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
		list.add("string");
		list.add("email");
		return list;
	}
	
	
	public static ArrayList<String> correctTextboxLst2() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("number");
		list.add("number");
		list.add("number");
		list.add("number");
		list.add("number");
		list.add("number");
		return list;
	}
	
	
	public static ArrayList<ListBox> requiredListboxLst() {
		ArrayList<ListBox> list = new ArrayList<ListBox>();
		list.add(Asmm_eufar.fi_operatorText);
		list.add(Asmm_eufar.fi_aircraftText);
		list.add(Asmm_eufar.fi_otherCntText);
		list.add(Asmm_eufar.geoLocationLst);
		list.add(Asmm_eufar.geoDetailLst);
		list.add(Asmm_eufar.ci_roleText);
		return list;
	}
	
	
	public static HashMap<String, Integer> coordinateLst() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("°n", 2);
		map.put("°e", 2);
		map.put("°N", 2);
		map.put("°E", 2);
		map.put("n", 1);
		map.put("e", 1);
		map.put("m", 1);
		map.put("N", 1);
		map.put("E", 1);
		map.put("M", 1);
		map.put("°s", -2);
		map.put("°w", -2);
		map.put("°S", -2);
		map.put("°W", -2);
		map.put("s", -1);
		map.put("w", -1);
		map.put("S", -1);
		map.put("W", -1);
		map.put("°", 0);
		return map;
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
