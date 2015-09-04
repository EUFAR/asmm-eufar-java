package com.eufar.asmm.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

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
		map.put("Satellite Cal/Val", "satelliteCalVal");
		map.put("Anthropogenic pollution", "anthroPollution");
		map.put("Mesoscale atmospheric impacts", "mesoscaleImpacts");
		map.put("Microphysics", "cloudMicrophysics");
		map.put("Dynamics (Cloud)", "cloudDynamics");
		map.put("Radiative properties", "cloudRadiative");
		map.put("Convection dynamics", "cloudConvection");
		map.put("Gaz chemistry", "gasChem");
		map.put("Oxydants", "gasChemOxidants");
		map.put("Organics", "gasChemOrganics");
		map.put("Other (Gaz chemistry)", "gasChemOther");
		map.put("Aerosol", "aerosol");
		map.put("Cloud microphysical impacts", "aerosolMicrophysical");
		map.put("Radiative properties/impacts", "aerosolRadiative");
		map.put("Radiation","radiation");
		map.put("Atmospheric spectroscopy", "radiationAtmosSpectroscopy");
		map.put("Surface properties/retrievals", "radiationSurfProperties");
		map.put("Other (Radiation)", "radiationOther");
		map.put("Cloud", "blCloud");
		map.put("Dynamics (Boundary-layer)", "blDynamics");
		return map;
	}

	
	public static TreeMap<String, String> geographicMap() {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("Polar","polar");
		map.put("Mid-latitudes","midLatitudes");
		map.put("Sub-tropical","subTropical");
		map.put("Tropical","tropical");
		map.put("Maritime","maritime");
		map.put("Continental","continental");
		map.put("Oceanic islands","oceanicIslands");
		map.put("Other","other");
		return map;
	}
	
	
	public static TreeMap<String, String> synopticMap() {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("Stationary","stationary");
		map.put("Anticyclonic","stationaryAnticyclonic");
		map.put("Cyclonic","stationaryCyclonic");
		map.put("Warm front","warmFront");
		map.put("Warm conveyor belt","warmConveyorBelt");
		map.put("Cold front","coldFront");
		map.put("Occluded front","occludedFront");
		map.put("Warm sector","warmSector");
		map.put("Post-cold-frontal air-mass","postColdFrontalAirMass");
		map.put("Arctic cold-air outbreak","arcticColdAirOutbreak");
		map.put("Orographic influence","orographicInfluence");
		map.put("Sea-breeze front","seaBreezeFront");
		map.put("Stratospheric fold/intrusion","stratosphericFold");
		map.put("Extended convergence line","extendedConvergenceLine");
		map.put("Easterly wave","easterlyWave");
		map.put("Equatorial wave","equatorialWave");
		map.put("Tropical cyclone","tropycalCyclone");
		map.put("Mesoscale organized convection","mesoscaleOrganizedConvection");
		return map;
	}
	
	
	public static TreeMap<String, String> cloudMap() {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("Water clouds","waterClouds");
		map.put("Mixed-phase clouds","mixedPhaseClouds");
		map.put("Ice clouds","iceClouds");
		map.put("Cirrus","cirrus");
		map.put("Contrails","contrails");
		map.put("Stratocumulus","stratocumulus");
		map.put("Shallow cumulus","shallowCumulus");
		map.put("Cumulus congestus","cumulusCongestus");
		map.put("Cumulonimbus/towering cumulus","cumulonimbusToweringCumulus");
		map.put("Altostratus/altocumulus","altostratusAltocumulus");
		map.put("Wave clouds","waveClouds");
		map.put("Deep frontal statiform clouds","deepFrontalStratiformClouds");
		map.put("Cloud-free above aircraft","cloudFreeAboveAircraft");
		map.put("Cloud-free below aircraft","cloudFreeBelowAircraft");
		return map;
	}

	
	public static TreeMap<String, String> cpapMap() {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("Rain","rain");
		map.put("Drizzle","drizzle");
		map.put("Droplets (liquid)","droplets");
		map.put("Pristine ice crystals","pristineIceCrystals");
		map.put("Snow/aggregates","snowOrAggregates");
		map.put("Graupel/hail","graupelOrHail");
		map.put("Sea-salt aerosol","seaSaltAerosol");
		map.put("Continental aerosol","continentalAerosol");
		map.put("Urban plume","urbanPlume");
		map.put("Biomass burning","biomassBurning");
		map.put("Desert/mineral dust","desertOrMineralDust");
		map.put("Volcanic ash","volcanicAsh");
		return map;
	}

	
	public static TreeMap<String, String> surfacesMap() {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("Ocean","ocean");
		map.put("Semi-arid","semiArid");
		map.put("Sea-ice","seaIce");
		map.put("Desert","desert");
		map.put("Snow","snow");
		map.put("Urban","urban");
		map.put("Lake-ice","lakeIce");
		map.put("Mountainous","mountainous");
		map.put("Vegetation","vegetation");
		map.put("Hilly","hilly");
		map.put("Forest","forest");
		map.put("Flat","flat");
		return map;
	}

	
	public static TreeMap<String, String> measurementMap() {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("Boundary-layer","boundaryLayer");
		map.put("near-surface","blNearSurface");
		map.put("sub-cloud","blSubCloud");
		map.put("in-cloud","blInCloud");
		map.put("Lower troposphere","lowerTroposphere");
		map.put("Mid troposphere","midTroposphere");
		map.put("Upper troposphere","upperTroposphere");
		map.put("Lower stratosphere","lowerStratosphere");
		return map;
	}

	
	public static TreeMap<String, String> manoeuvreMap() {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("Straight/level runs","straightLevelRuns");
		map.put("stacked","stackedStraightLevelRuns");
		map.put("separated","separatedStraightLevelRuns");
		map.put("Racetracks","racetracks");
		map.put("Orbits","orbits");
		map.put("Lagrangian descents","lagrangianDescents");
		map.put("Deep profile ascents/descents","deepProfileAscentDescents");
		map.put("Dropsonde deployed","dropsondeDeployed");
		map.put("Self-calibration","selfCalibration");
		return map;
	}
	
	
	public static TreeMap<String, String> satelliteMap() {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("METOP","polarMetop");
		map.put("NPOESS","polarNpoess");
		map.put("A-train","polarAtrain");
		map.put("Other (Polar)","polarOther");
		map.put("MSG","geosynchMsg");
		map.put("Other (Geosynch)","geosynchOther");
		map.put("MODIS","modis");
		map.put("Cloudsat","cloudsat");
		map.put("CALIOP","caliop");
		map.put("IASI","iasi");
		map.put("AIRS","airs");
		map.put("CriS","cris");
		map.put("AMSU/MHS","amsuMhs");
		return map;
	}
	
	
	public static ArrayList<String> roleList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Make a choice...");
		list.add("Mission Scientist");
		list.add("Flight Manager");
		list.add("Scientist");
		list.add("Pilot");
		list.add("Other");
		return list;
	}
	
	public static ArrayList<String> operatorList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Make a choice...");
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
		list.add("Other");
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
	
	
	public static ArrayList<String> textboxName() {
		ArrayList<String> list = new ArrayList<String>();
	    list.add("flightNumber");
	    list.add("flightCampaign");
	    list.add("flightScientist");
	    list.add("flightManager");
	    list.add("contactName");
	    list.add("contactEmail");
	    list.add("scientificComments");
	    list.add("northBound");
	    list.add("southBound");
	    list.add("minAltitude");
	    list.add("maxAltitude");
	    list.add("westBound");
	    list.add("eastBound");
	    list.add("geographicComments");
	    list.add("atmosphericComments");
	    list.add("typesComments");
	    list.add("particlesComments");
	    list.add("surfacesComments");
	    list.add("measurementComments");
	    list.add("manoeuvreComments");
	    list.add("satelliteComments");
	    list.add("groundsite1");
	    list.add("groundsite2");
	    list.add("groundsite3");
	    list.add("groundsite4");
	    list.add("additionalNotes");
    	return list;
    }
    
	
	public static ArrayList<String> checkboxName() {
		ArrayList<String> list = new ArrayList<String>();
	    list.add("sa_satCalval");
		list.add("sa_antPollution");
		list.add("sa_mesoImpacts");
		list.add("sa_microPhysics");
		list.add("sa_dyNamics");
		list.add("sa_radProperties");
		list.add("sa_convDynamics");
		list.add("sa_gazChemistry");
		list.add("sa_oxyDants");
		list.add("sa_orgAnics");
		list.add("sa_other1");
		list.add("sa_aeroSol");
		list.add("sa_cloudImpacts");
		list.add("sa_radImpacts");
		list.add("sa_radIation");
		list.add("sa_atmSpectroscopy");
		list.add("sa_surfProperties");
		list.add("sa_other2");
		list.add("sa_cloud");
		list.add("sa_dynAmics");
		list.add("gi_polar");
		list.add("gi_midLatitudes");
		list.add("gi_subTropical");
		list.add("gi_tropical");
		list.add("gi_maritime");
		list.add("gi_continental");
		list.add("gi_oceanicIslands");
		list.add("gi_other");
		list.add("af_stationary");
		list.add("af_antiStationary");
		list.add("af_cycloStationary");
		list.add("af_warmFront");
		list.add("af_warmBelt");
		list.add("af_coldFront");
		list.add("af_occludedFront");
		list.add("af_warmSector");
		list.add("af_airMass");
		list.add("af_airOutbreack");
		list.add("af_orographicInfluence");
		list.add("af_seabreezeFront");
		list.add("af_foldIntrusion");
		list.add("af_convergenceLine");
		list.add("af_easterlyWave");
		list.add("af_equatorialWave");
		list.add("af_tropicalCyclone");
		list.add("af_organizedConvection");
		list.add("ct_waterClouds");
		list.add("ct_mixedphasedClouds");
		list.add("ct_iceClouds");
		list.add("ct_cirrus");
		list.add("ct_contrails");
		list.add("ct_stratocumulus");
		list.add("ct_shallowCumulus");
		list.add("ct_cumulusCongestus");
		list.add("ct_cumulTower");
		list.add("ct_altoStracumul");
		list.add("ct_waveClouds");
		list.add("ct_statiformClouds");
		list.add("ct_freeAbove");
		list.add("ct_freeBelow");
		list.add("cp_rain");
		list.add("cp_drizzle");
		list.add("cp_dropletsLiquid");
		list.add("cp_pristineCrystals");
		list.add("cp_snowAggregates");
		list.add("cp_graupelHail");
		list.add("cp_saltAerosol");
		list.add("cp_continentalAerosol");
		list.add("cp_urbanPlume");
		list.add("cp_biomassBurning");
		list.add("cp_desertDust");
		list.add("cp_volcanicAsh");
		list.add("lo_ocean");
		list.add("lo_semiArid");
		list.add("lo_seaIce");
		list.add("lo_desert");
		list.add("lo_snow");
		list.add("lo_urban");
		list.add("lo_lakeIce");
		list.add("lo_mountainous");
		list.add("lo_vegetation");
		list.add("lo_hilly");
		list.add("lo_forest");
		list.add("lo_flat");
		list.add("ar_boundaryLayer");
		list.add("ar_nearSurface");
		list.add("ar_subCloud");
		list.add("ar_inCloud");
		list.add("ar_lowerTroposphere");
		list.add("ar_midTroposphere");
		list.add("ar_upperTroposphere");
		list.add("ar_lowerstratosphere");
		list.add("fm_levelRuns");
		list.add("fm_stacked");
		list.add("fm_separated");
		list.add("fm_racetracks");
		list.add("fm_orbits");
		list.add("fm_lagrangianDescents");
		list.add("fm_ascDescents");
		list.add("fm_dropsondeDeployed");
		list.add("fm_selfCalibration");
		list.add("sc_metop");
		list.add("sc_npoess");
		list.add("sc_atrain");
		list.add("sc_other");
		list.add("sc_msg");
		list.add("sc_other2");
		list.add("sc_modis");
		list.add("sc_cloudsat");
		list.add("sc_caliop");
		list.add("sc_iasi");
		list.add("sc_airs");
		list.add("sc_cris");
		list.add("sc_amsuMhs");
		return list;
	}
	
	
	public static ArrayList<String> listboxName() {
		ArrayList<String> list = new ArrayList<String>();
	
		list.add("operatorText");
		list.add("aircraftText");
		list.add("localisationText");
		list.add("countryText");
		list.add("roleText");
		return list;
	}
	
	
	public static ArrayList<String> dateboxName() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("date");
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
	
	
	public static Image popupImage(final String string) {
		final Image image = new Image("icons/" + string + "_popup_icon.png");
		return image;
	}
	
	
	public static Image smallImage(final String string) {
		final Image image = new Image("icons/" + string + "_icon.png");
		return image;
	}
}
