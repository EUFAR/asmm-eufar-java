package com.eufar.asmm.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import static com.google.gwt.query.client.GQuery.$;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
//import com.google.gwt.logging.client.SimpleRemoteLogHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.xml.client.DOMException;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;


public class Asmm_eufar implements EntryPoint {

	//private static Logger rootLogger = Logger.getLogger("");
	
	
	// Main window items initialization
	private MenuBar mainMenu = new MenuBar();
	private MenuBar aboutMenu = new MenuBar(true);
	private MenuBar fileMenu = new MenuBar(true);
	private MenuBar confMenu = new MenuBar(true);
	private DockLayoutPanel dockPanel = new DockLayoutPanel(Unit.PX);
	private DockLayoutPanel subDockPanel = new DockLayoutPanel(Unit.PX);
	private StackLayoutPanel stackPanel = new StackLayoutPanel(Unit.PX);
	private ScrollableTabLayoutPanel tabPanel = new ScrollableTabLayoutPanel(30, Unit.PX);
	private String myFileName = new String("");
	private String myPDFName = new String("");
	private String creationDate = new String(DateTimeFormat.getFormat("yyyy-MM-dd").format(new Date()));
	private String revisionDate = new String(DateTimeFormat.getFormat("yyyy-MM-dd").format(new Date()));
	private String asmmVersion = new String("0.9.8");
	private String xmlVersion = new String("v1.0a");
	private String titleString = new String("ASMM Creator");
	private Boolean isModified = new Boolean(false);
	private Boolean tabLayout = new Boolean(false);
	private HorizontalPanel horizontalPanel26 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel27 = new HorizontalPanel();
	private ArrayList<String> textboxName = new ArrayList<String>();
	private ArrayList<String> checkboxName = new ArrayList<String>();
	private ArrayList<String> listboxName = new ArrayList<String>();
	private ArrayList<String> dateboxName = new ArrayList<String>();
	private HashMap<VerticalPanel, String> parentMap = new HashMap<VerticalPanel, String>();
	
	String asmmPath = new String(GWT.getHostPageBaseURL()); // for Tomcat7 Server
	//String asmmPath = new String(""); // for Eclipse Dev Mode
	

	// Menu items initialization
	private String imageNew = "<img src='icons/new_icon_menu.png'> New...</img>";
	private String imageOpen = "<img src='icons/open_icon_menu.png'> Open...</img>";
	private String imageSave = "<img src='icons/save_icon_menu.png'> Save...</img>";
	private String imagePrint = "<img src='icons/print_icon_menu.png'> Print...</img>";
	private String imageAbout = "<img src='icons/about_icon_menu.png'> ASMM Creator...</img>";
	private String imageStandard = "<img src='icons/changelog_icon_menu.png'> ASMM XML Standard...</img>";
	private String imageEufar = "<img src='icons/eufar_icon_menu.png'> EUFAR N7SP...</img>";
	private String imageExit = "<img src='icons/exit_icon_menu.png'> Exit...</img>";
	private String imageConf = "<img src='icons/preferences_icon.png'> Horizontal Layout...</img>";


	// Flight Information items initialization
	private FlexTable fiGrid = new FlexTable();
	private HorizontalPanel horizontalPanel30 = new HorizontalPanel();
	private ScrollPanel fiScroll = new ScrollPanel(fiGrid);
	private DateBox fi_dateText = new DateBox();
	private TextBox fi_flightText = new TextBox();
	private TextBox fi_campaignText = new TextBox();
	private TextBox fi_scientistText = new TextBox();
	private TextBox fi_managerText = new TextBox();
	private TextBox fi_otherOpsText = new TextBox();
	private TextBox fi_otherAiText = new TextBox();
	private Label fi_flightLabel = new Label("Flight number:");
	private Label fi_dateLabel = new Label("Date (yyyy-mm-dd):");
	private Label fi_campaignLabel = new Label("Project acronym:");
	private Label fi_scientistLabel = new Label("Mission scientist:");
	private Label fi_managerLabel = new Label("Flight manager:");
	private Label fi_aircraftLabel = new Label("Platform/Aircraft:");
	private Label fi_operatorLabel = new Label("Operator:");
	private Label fi_countryLabel = new Label("Country:");
	private Image fi_operatorImage = new Image("icons/fwd_arrow.png");
	private Image fi_aircraftImage = new Image("icons/fwd_arrow.png");
	private Image geoFollowImage = new Image("icons/fwd_arrow.png");
	private ListBox fi_countryText = new ListBox();
	private ListBox fi_operatorText = new ListBox();
	private ListBox fi_aircraftText = new ListBox();
	private ListBox geoLocationLst = new ListBox();
	private ListBox geoDetailLst = new ListBox();
	private ArrayList<String> countryList = new ArrayList<String>();
	private ArrayList<String> continentList = new ArrayList<String>();
	private ArrayList<String> oceanList = new ArrayList<String>();
	private ArrayList<String> regionList = new ArrayList<String>();
	private ArrayList<String> locationList = new ArrayList<String>();
	private ArrayList<String> operatorList = new ArrayList<String>();
	private ArrayList<String> aircraftList = new ArrayList<String>();
	private String[][] operatorsAircraft = {
			{"Alfred Wegener Institute","BT-67 POLAR 5","AWI","BT-67"},
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


	// Contact Information items initialization
	private FlexTable ciGrid = new FlexTable();
	private ScrollPanel ciScroll = new ScrollPanel(ciGrid);
	private TextBox ci_nameText = new TextBox();
	private TextBox ci_emailText = new TextBox();
	private ListBox ci_roleText = new ListBox();
	private Label ci_nameLabel = new Label("Name:");
	private Label ci_roleLabel = new Label("Role:");
	private Label ci_emailLabel = new Label("Email:");
	private ArrayList<String> roleList = new ArrayList<String>();
	

	// Scientific Aims items initialization
	private VerticalPanel verticalPanel01 = new VerticalPanel();
	private VerticalPanel verticalPanel02 = new VerticalPanel();
	private VerticalPanel verticalPanel03 = new VerticalPanel();
	private VerticalPanel verticalPanel04 = new VerticalPanel();
	private VerticalPanel verticalPanel05 = new VerticalPanel();
	private VerticalPanel verticalPanel06 = new VerticalPanel();
	private VerticalPanel verticalPanel07 = new VerticalPanel();
	private VerticalPanel verticalPanel08 = new VerticalPanel();
	private VerticalPanel verticalPanel09 = new VerticalPanel();
	private VerticalPanel verticalPanel10 = new VerticalPanel();
	private VerticalPanel verticalPanel67 = new VerticalPanel();
	private HorizontalPanel horizontalPanel01 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel02 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel31 = new HorizontalPanel();
	private Label sa_cloudLabel = new Label("Cloud:");
	private Label sa_layerLabel = new Label("Boundary-layer:");
	private Label sa_comments = new Label("Comments:");
	private TreeMap<String, String> scientificMap = new TreeMap<String, String>();
	private TextArea sa_comArea = new TextArea();
	private TreeMap<String, String> sa_addCatMap = new TreeMap<String, String>();
	private FlexTable sa_addCatTable = new FlexTable();
	private CheckBox sa_satCalval = new CheckBox("Satellite Cal/Val");
	private CheckBox sa_antPollution = new CheckBox("Anthropogenic pollution");
	private CheckBox sa_mesoImpacts = new CheckBox("Mesoscale atmospheric impacts");
	private CheckBox sa_microPhysics = new CheckBox("Microphysics");
	private CheckBox sa_dyNamics = new CheckBox("Dynamics (Cloud)");
	private CheckBox sa_radProperties = new CheckBox("Radiative properties");
	private CheckBox sa_convDynamics = new CheckBox("Convection dynamics");
	private CheckBox sa_gazChemistry = new CheckBox("Gaz chemistry");
	private CheckBox sa_oxyDants = new CheckBox("Oxydants");
	private CheckBox sa_orgAnics = new CheckBox("Organics");
	private CheckBox sa_other1 = new CheckBox("Other (Gaz chemistry)");
	private CheckBox sa_aeroSol = new CheckBox("Aerosol");
	private CheckBox sa_cloudImpacts = new CheckBox("Cloud microphysical impacts");
	private CheckBox sa_radImpacts = new CheckBox("Radiative properties/impacts");
	private CheckBox sa_radIation = new CheckBox("Radiation");
	private CheckBox sa_atmSpectroscopy = new CheckBox("Atmospheric spectroscopy");
	private CheckBox sa_surfProperties = new CheckBox("Surface properties/retrievals");
	private CheckBox sa_other2 = new CheckBox("Other (Radiation)");
	private CheckBox sa_cloud = new CheckBox("Cloud");
	private CheckBox sa_dynAmics = new CheckBox("Dynamics (Boundary-layer)");
	private ScrollPanel saScroll = new ScrollPanel(verticalPanel10);  


	// Geographical Information items initialization
	private VerticalPanel verticalPanel11 = new VerticalPanel();
	private VerticalPanel verticalPanel15 = new VerticalPanel();
	private VerticalPanel verticalPanel62 = new VerticalPanel();
	private VerticalPanel verticalPanel63 = new VerticalPanel();
	private VerticalPanel verticalPanel64 = new VerticalPanel();
	private VerticalPanel verticalPanel65 = new VerticalPanel();
	private VerticalPanel verticalPanel68 = new VerticalPanel();
	private HorizontalPanel horizontalPanel03 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel05 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel06 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel32 = new HorizontalPanel();
	private Label gi_boundingLabel = new Label("Geographic Bounding Box:");
	private Label gi_nsLabel = new Label("North/South latitudes:");
	private Label gi_weLabel = new Label("West/East longitudes:");
	private Label gi_mmLabel = new Label("Min/Max altitudes (m):");
	private Label gi_comLabel = new Label("Comments:");
	private Label gi_situationLabel = new Label("Geographic Situation:");
	private TextArea gi_comArea = new TextArea();
	private TextBox gi_northText = new TextBox();
	private TextBox gi_southText = new TextBox();
	private TextBox gi_westText = new TextBox();
	private TextBox gi_eastText = new TextBox();
	private TextBox gi_minText = new TextBox();
	private TextBox gi_maxText = new TextBox();
	private TreeMap<String, String> geographicMap = new TreeMap<String, String>();
	private TreeMap<String, String> gi_addCatMap = new TreeMap<String, String>();
	private FlexTable gi_addCatTable = new FlexTable();
	private FlexTable gi_boundTable = new FlexTable();
	private CheckBox gi_polar = new CheckBox("Polar");
	private CheckBox gi_midLatitudes = new CheckBox("Mid-latitudes");
	private CheckBox gi_subTropical = new CheckBox("Sub-tropical");
	private CheckBox gi_tropical = new CheckBox("Tropical");
	private CheckBox gi_maritime = new CheckBox("Maritime");
	private CheckBox gi_continental = new CheckBox("Continental");
	private CheckBox gi_oceanicIslands = new CheckBox("Oceanic islands");
	private CheckBox gi_other = new CheckBox("Other");
	private ScrollPanel giScroll = new ScrollPanel(verticalPanel11);


	// Atmospheric Synoptic Features items initialization
	private VerticalPanel verticalPanel16 = new VerticalPanel();
	private VerticalPanel verticalPanel17 = new VerticalPanel();
	private VerticalPanel verticalPanel18 = new VerticalPanel();
	private VerticalPanel verticalPanel19 = new VerticalPanel();
	private VerticalPanel verticalPanel20 = new VerticalPanel();
	private VerticalPanel verticalPanel69 = new VerticalPanel();
	private HorizontalPanel horizontalPanel07 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel08 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel33 = new HorizontalPanel();
	private Label af_comLabel = new Label("Comments:");
	private TextArea af_comArea = new TextArea();
	private TreeMap<String, String> synopticMap = new TreeMap<String, String>();
	private TreeMap<String, String> af_addCatMap = new TreeMap<String, String>();
	private FlexTable af_addCatTable = new FlexTable();
	private CheckBox af_stationary = new CheckBox("Stationary");
	private CheckBox af_antiStationary = new CheckBox("Anticyclonic");
	private CheckBox af_cycloStationary = new CheckBox("Cyclonic");
	private CheckBox af_warmFront = new CheckBox("Warm front");
	private CheckBox af_warmBelt = new CheckBox("Warm conveyor belt");
	private CheckBox af_coldFront = new CheckBox("Cold front");
	private CheckBox af_occludedFront = new CheckBox("Occluded front");
	private CheckBox af_warmSector = new CheckBox("Warm sector");
	private CheckBox af_airMass = new CheckBox("Post-cold-frontal air-mass");
	private CheckBox af_airOutbreack = new CheckBox("Arctic cold-air outbreak");
	private CheckBox af_orographicInfluence = new CheckBox("Orographic influence");
	private CheckBox af_seabreezeFront = new CheckBox("Sea-breeze front");
	private CheckBox af_foldIntrusion = new CheckBox("Stratospheric fold/intrusion");
	private CheckBox af_convergenceLine = new CheckBox("Extended convergence line");
	private CheckBox af_easterlyWave = new CheckBox("Easterly wave");
	private CheckBox af_equatorialWave = new CheckBox("Equatorial wave");
	private CheckBox af_tropicalCyclone = new CheckBox("Tropical cyclone");
	private CheckBox af_organizedConvection = new CheckBox("Mesoscale organized convection");
	private ScrollPanel afScroll = new ScrollPanel(verticalPanel20);


	// Cloud Types and Forms Sampled During Flight items initialization
	private VerticalPanel verticalPanel21 = new VerticalPanel();
	private VerticalPanel verticalPanel22 = new VerticalPanel();
	private VerticalPanel verticalPanel23 = new VerticalPanel();
	private VerticalPanel verticalPanel24 = new VerticalPanel();
	private VerticalPanel verticalPanel25 = new VerticalPanel();
	private VerticalPanel verticalPanel70 = new VerticalPanel();
	private HorizontalPanel horizontalPanel09 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel10 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel34 = new HorizontalPanel();
	private Label ct_comLabel = new Label("Comments:");
	private TextArea ct_comArea = new TextArea();
	private TreeMap<String, String> cloudMap = new TreeMap<String, String>();
	private TreeMap<String, String> ct_addCatMap = new TreeMap<String, String>();
	private FlexTable ct_addCatTable = new FlexTable();
	private CheckBox ct_waterClouds = new CheckBox("Water clouds");
	private CheckBox ct_mixedphasedClouds = new CheckBox("Mixed-phase clouds");
	private CheckBox ct_iceClouds = new CheckBox("Ice clouds");
	private CheckBox ct_cirrus = new CheckBox("Cirrus");
	private CheckBox ct_contrails = new CheckBox("Contrails");
	private CheckBox ct_stratocumulus = new CheckBox("Stratocumulus");
	private CheckBox ct_shallowCumulus = new CheckBox("Shallow cumulus");
	private CheckBox ct_cumulusCongestus = new CheckBox("Cumulus congestus");
	private CheckBox ct_cumulTower = new CheckBox("Cumulonimbus/towering cumulus");
	private CheckBox ct_altoStracumul = new CheckBox("Altostratus/altocumulus");
	private CheckBox ct_waveClouds = new CheckBox("Wave clouds");
	private CheckBox ct_statiformClouds = new CheckBox("Deep frontal statiform clouds");
	private CheckBox ct_freeAbove = new CheckBox("Cloud-free above aircraft");
	private CheckBox ct_freeBelow = new CheckBox("Cloud-free below aircraft");
	private ScrollPanel ctScroll = new ScrollPanel(verticalPanel25);


	// Cloud, Precipitation and Aerosol Particles Sampled items initialization
	private VerticalPanel verticalPanel26 = new VerticalPanel();
	private VerticalPanel verticalPanel27 = new VerticalPanel();
	private VerticalPanel verticalPanel28 = new VerticalPanel();
	private VerticalPanel verticalPanel29 = new VerticalPanel();
	private VerticalPanel verticalPanel30 = new VerticalPanel();
	private VerticalPanel verticalPanel71 = new VerticalPanel();
	private HorizontalPanel horizontalPanel11 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel12 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel35 = new HorizontalPanel();
	private Label cp_comLabel = new Label("Comments:");
	private TextArea cp_comArea = new TextArea();
	private TreeMap<String, String> cpapMap = new TreeMap<String, String>();
	private TreeMap<String, String> cp_addCatMap = new TreeMap<String, String>();
	private FlexTable cp_addCatTable = new FlexTable();
	private CheckBox cp_rain = new CheckBox("Rain");
	private CheckBox cp_drizzle = new CheckBox("Drizzle");
	private CheckBox cp_dropletsLiquid = new CheckBox("Droplets (liquid)");
	private CheckBox cp_pristineCrystals = new CheckBox("Pristine ice crystals");
	private CheckBox cp_snowAggregates = new CheckBox("Snow/aggregates");
	private CheckBox cp_graupelHail = new CheckBox("Graupel/hail");
	private CheckBox cp_saltAerosol = new CheckBox("Sea-salt aerosol");
	private CheckBox cp_continentalAerosol = new CheckBox("Continental aerosol");
	private CheckBox cp_urbanPlume = new CheckBox("Urban plume");
	private CheckBox cp_biomassBurning = new CheckBox("Biomass burning");
	private CheckBox cp_desertDust = new CheckBox("Desert/mineral dust");
	private CheckBox cp_volcanicAsh = new CheckBox("Volcanic ash");
	private ScrollPanel cpScroll = new ScrollPanel(verticalPanel30);


	// Land or Oceans Surfaces Overflown items initialization
	private VerticalPanel verticalPanel31 = new VerticalPanel();
	private VerticalPanel verticalPanel32 = new VerticalPanel();
	private VerticalPanel verticalPanel33 = new VerticalPanel();
	private VerticalPanel verticalPanel34 = new VerticalPanel();
	private VerticalPanel verticalPanel35 = new VerticalPanel();
	private VerticalPanel verticalPanel72 = new VerticalPanel();
	private HorizontalPanel horizontalPanel13 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel14 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel36 = new HorizontalPanel();
	private Label lo_comLabel = new Label("Comments:");
	private TextArea lo_comArea = new TextArea();
	private TreeMap<String, String> surfacesMap = new TreeMap<String, String>();
	private TreeMap<String, String> lo_addCatMap = new TreeMap<String, String>();
	private FlexTable lo_addCatTable = new FlexTable();
	private CheckBox lo_ocean = new CheckBox("Ocean");
	private CheckBox lo_semiArid = new CheckBox("Semi-arid");
	private CheckBox lo_seaIce = new CheckBox("Sea-ice");
	private CheckBox lo_desert = new CheckBox("Desert");
	private CheckBox lo_snow = new CheckBox("Snow");
	private CheckBox lo_urban = new CheckBox("Urban");
	private CheckBox lo_lakeIce = new CheckBox("Lake-ice");
	private CheckBox lo_mountainous = new CheckBox("Mountainous");
	private CheckBox lo_vegetation = new CheckBox("Vegetation");
	private CheckBox lo_hilly = new CheckBox("Hilly");
	private CheckBox lo_forest = new CheckBox("Forest");
	private CheckBox lo_flat = new CheckBox("Flat");
	private ScrollPanel loScroll = new ScrollPanel(verticalPanel35);


	// Altitude Range of Measurement items initialization
	private VerticalPanel verticalPanel36 = new VerticalPanel();
	private VerticalPanel verticalPanel37 = new VerticalPanel();
	private VerticalPanel verticalPanel38 = new VerticalPanel();
	private VerticalPanel verticalPanel73 = new VerticalPanel();
	private HorizontalPanel horizontalPanel15 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel16 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel37 = new HorizontalPanel();
	private Label ar_comLabel = new Label("Comments:");
	private TextArea ar_comArea = new TextArea();
	private TreeMap<String, String> measurementMap = new TreeMap<String, String>();
	private TreeMap<String, String> ar_addCatMap = new TreeMap<String, String>();
	private FlexTable ar_addCatTable = new FlexTable();
	private CheckBox ar_boundaryLayer = new CheckBox("Boundary-layer");
	private CheckBox ar_nearSurface = new CheckBox("near-surface");
	private CheckBox ar_subCloud = new CheckBox("sub-cloud");
	private CheckBox ar_inCloud = new CheckBox("in-cloud");
	private CheckBox ar_lowerTroposphere = new CheckBox("Lower troposphere");
	private CheckBox ar_midTroposphere = new CheckBox("Mid troposphere");
	private CheckBox ar_upperTroposphere = new CheckBox("Upper troposphere");
	private CheckBox ar_lowerstratosphere = new CheckBox("Lower stratosphere");
	private ScrollPanel arScroll = new ScrollPanel(verticalPanel38);


	// Types of Flight Manoeuvre items initialization
	private VerticalPanel verticalPanel39 = new VerticalPanel();
	private VerticalPanel verticalPanel40 = new VerticalPanel();
	private VerticalPanel verticalPanel41 = new VerticalPanel();
	private VerticalPanel verticalPanel74 = new VerticalPanel();
	private HorizontalPanel horizontalPanel17 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel18 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel38 = new HorizontalPanel();
	private Label fm_comLabel = new Label("Comments:");
	private TextArea fm_comArea = new TextArea();
	private TreeMap<String, String> manoeuvreMap = new TreeMap<String, String>();
	private TreeMap<String, String> fm_addCatMap = new TreeMap<String, String>();
	private FlexTable fm_addCatTable = new FlexTable();
	private CheckBox fm_levelRuns = new CheckBox("Straight/level runs");
	private CheckBox fm_stacked = new CheckBox("stacked");
	private CheckBox fm_separated = new CheckBox("separated");
	private CheckBox fm_racetracks = new CheckBox("Racetracks");
	private CheckBox fm_orbits = new CheckBox("Orbits");
	private CheckBox fm_lagrangianDescents = new CheckBox("Lagrangian descents");
	private CheckBox fm_ascDescents = new CheckBox("Deep profile ascents/descents");
	private CheckBox fm_dropsondeDeployed = new CheckBox("Dropsonde deployed");
	private CheckBox fm_selfCalibration = new CheckBox("Self-calibration");
	private ScrollPanel fmScroll = new ScrollPanel(verticalPanel41);


	// Satellite Coordination items initialization
	private VerticalPanel verticalPanel42 = new VerticalPanel();
	private VerticalPanel verticalPanel43 = new VerticalPanel();
	private VerticalPanel verticalPanel44 = new VerticalPanel();
	private VerticalPanel verticalPanel45 = new VerticalPanel();
	private VerticalPanel verticalPanel46 = new VerticalPanel();
	private VerticalPanel verticalPanel47 = new VerticalPanel();
	private VerticalPanel verticalPanel75 = new VerticalPanel();
	private HorizontalPanel horizontalPanel19 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel20 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel39 = new HorizontalPanel();
	private Label sc_polarLabel = new Label("Polar:");
	private Label sc_geosynchLabel = new Label("Geosynch:");
	private Label sc_comLabel = new Label("Comments:");
	private TextArea sc_comArea = new TextArea();
	private TreeMap<String, String> satelliteMap = new TreeMap<String, String>();
	private TreeMap<String, String> sc_addCatMap = new TreeMap<String, String>();
	private FlexTable sc_addCatTable = new FlexTable();
	private CheckBox sc_metop = new CheckBox("METOP");
	private CheckBox sc_npoess = new CheckBox("NPOESS");
	private CheckBox sc_atrain = new CheckBox("A-train");
	private CheckBox sc_other = new CheckBox("Other (Polar)");
	private CheckBox sc_msg = new CheckBox("MSG");
	private CheckBox sc_other2 = new CheckBox("Other (Geosynch)");
	private CheckBox sc_modis = new CheckBox("MODIS");
	private CheckBox sc_cloudsat = new CheckBox("Cloudsat");
	private CheckBox sc_caliop = new CheckBox("CALIOP");
	private CheckBox sc_iasi = new CheckBox("IASI");
	private CheckBox sc_airs = new CheckBox("AIRS");
	private CheckBox sc_cris = new CheckBox("CriS");
	private CheckBox sc_amsuMhs = new CheckBox("AMSU/MHS");
	private ScrollPanel scScroll = new ScrollPanel(verticalPanel47);


	// Supporting Surface-based Observations items initialization
	private VerticalPanel verticalPanel48 = new VerticalPanel();
	private VerticalPanel verticalPanel49 = new VerticalPanel();
	private VerticalPanel verticalPanel50 = new VerticalPanel();
	private VerticalPanel verticalPanel51 = new VerticalPanel();
	private VerticalPanel verticalPanel52 = new VerticalPanel();
	private VerticalPanel verticalPanel53 = new VerticalPanel();
	private VerticalPanel verticalPanel54 = new VerticalPanel();
	private VerticalPanel verticalPanel55 = new VerticalPanel();
	private VerticalPanel verticalPanel56 = new VerticalPanel();
	private VerticalPanel verticalPanel57 = new VerticalPanel();
	private VerticalPanel verticalPanel61 = new VerticalPanel();
	private HorizontalPanel horizontalPanel21 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel22 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel23 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel24 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel25 = new HorizontalPanel();
	private Label so_groundSitesLabel = new Label("Ground Sites:");
	private Label so_armSitesLabel = new Label("ARM Sites:");
	private Label so_researchVesselsLabel = new Label("Research Vessels:");
	private Label so_mobileSitesLabel = new Label("ARM Mobile Sites:");
	private ArrayList<String> so_groundSitesList = new ArrayList<String>();
	private FlexTable so_groundSitesTable = new FlexTable();
	private ArrayList<String> so_researchVesselsList = new ArrayList<String>();
	private FlexTable so_researchVesselsTable = new FlexTable();
	private ArrayList<String> so_armSitesList = new ArrayList<String>();
	private FlexTable so_armSitesTable = new FlexTable();
	private ArrayList<String> so_mobileSitesList = new ArrayList<String>();
	private FlexTable so_mobileSitesTable = new FlexTable();
	private TextBox so_groundSitesBox = new TextBox();
	private TextBox so_armSitesBox = new TextBox();
	private TextBox so_researchVesselsBox = new TextBox();
	private TextBox so_mobileSitesBox = new TextBox();
	private ScrollPanel soScroll = new ScrollPanel(verticalPanel61);


	// Additional Notes on the Flight items initialization
	private VerticalPanel verticalPanel66 = new VerticalPanel();
	private TextArea nf_comArea = new TextArea();
	private ScrollPanel nfScroll = new ScrollPanel(verticalPanel66);
	
	
	// Images to pdf
	private VerticalPanel verticalPanel76 = new VerticalPanel();
	private HorizontalPanel horizontalPanel28 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel29 = new HorizontalPanel();
	private ScrollPanel ipScroll = new ScrollPanel(verticalPanel76);
	private PushButton addButton = new PushButton("Add a new Image");
	private PushButton urlButton = new PushButton("Add a new Image (URL)");
	private FlexTable imageTab = new FlexTable();
	private ArrayList<String> imageCaption = new ArrayList<String>();
	private ArrayList<String> imagePath = new ArrayList<String>();
	private Label informationLab = new Label("Use the following buttons to add images (JPG, PNG, BMP) to the PDF file. The number of images is "
			+ "limited to 10, and the weight of each image can't be greater than 5 MBytes. All images will be included in the PDF report but "
			+ "not in the XML file.");
	final Label imageLab = new Label("Image");
	final Label captionLab= new Label("Caption");
	

	public void onModuleLoad() {
		
		// Preparation of few objects
		parentMap.put(verticalPanel67,"SA");
		parentMap.put(verticalPanel68,"GI");
		parentMap.put(verticalPanel69,"AF");
		parentMap.put(verticalPanel70,"CT");
		parentMap.put(verticalPanel71,"CP");
		parentMap.put(verticalPanel72,"LO");
		parentMap.put(verticalPanel73,"AR");
		parentMap.put(verticalPanel74,"FM");
		parentMap.put(verticalPanel75,"SC");
		
		scientificMap.put("Satellite Cal/Val", "satelliteCalVal");
		scientificMap.put("Anthropogenic pollution", "anthroPollution");
		scientificMap.put("Mesoscale atmospheric impacts", "mesoscaleImpacts");
		scientificMap.put("Microphysics", "cloudMicrophysics");
		scientificMap.put("Dynamics (Cloud)", "cloudDynamics");
		scientificMap.put("Radiative properties", "cloudRadiative");
		scientificMap.put("Convection dynamics", "cloudConvection");
		scientificMap.put("Gaz chemistry", "gasChem");
		scientificMap.put("Oxydants", "gasChemOxidants");
		scientificMap.put("Organics", "gasChemOrganics");
		scientificMap.put("Other (Gaz chemistry)", "gasChemOther");
		scientificMap.put("Aerosol", "aerosol");
		scientificMap.put("Cloud microphysical impacts", "aerosolMicrophysical");
		scientificMap.put("Radiative properties/impacts", "aerosolRadiative");
		scientificMap.put("Radiation","radiation");
		scientificMap.put("Atmospheric spectroscopy", "radiationAtmosSpectroscopy");
		scientificMap.put("Surface properties/retrievals", "radiationSurfProperties");
		scientificMap.put("Other (Radiation)", "radiationOther");
		scientificMap.put("Cloud", "blCloud");
		scientificMap.put("Dynamics (Boundary-layer)", "blDynamics");

		geographicMap.put("Polar","polar");
		geographicMap.put("Mid-latitudes","midLatitudes");
		geographicMap.put("Sub-tropical","subTropical");
		geographicMap.put("Tropical","tropical");
		geographicMap.put("Maritime","maritime");
		geographicMap.put("Continental","continental");
		geographicMap.put("Oceanic islands","oceanicIslands");
		geographicMap.put("Other","other");

		synopticMap.put("Stationary","stationary");
		synopticMap.put("Anticyclonic","stationaryAnticyclonic");
		synopticMap.put("Cyclonic","stationaryCyclonic");
		synopticMap.put("Warm front","warmFront");
		synopticMap.put("Warm conveyor belt","warmConveyorBelt");
		synopticMap.put("Cold front","coldFront");
		synopticMap.put("Occluded front","occludedFront");
		synopticMap.put("Warm sector","warmSector");
		synopticMap.put("Post-cold-frontal air-mass","postColdFrontalAirMass");
		synopticMap.put("Arctic cold-air outbreak","arcticColdAirOutbreak");
		synopticMap.put("Orographic influence","orographicInfluence");
		synopticMap.put("Sea-breeze front","seaBreezeFront");
		synopticMap.put("Stratospheric fold/intrusion","stratosphericFold");
		synopticMap.put("Extended convergence line","extendedConvergenceLine");
		synopticMap.put("Easterly wave","easterlyWave");
		synopticMap.put("Equatorial wave","equatorialWave");
		synopticMap.put("Tropical cyclone","tropycalCyclone");
		synopticMap.put("Mesoscale organized convection","mesoscaleOrganizedConvection");

		cloudMap.put("Water clouds","waterClouds");
		cloudMap.put("Mixed-phase clouds","mixedPhaseClouds");
		cloudMap.put("Ice clouds","iceClouds");
		cloudMap.put("Cirrus","cirrus");
		cloudMap.put("Contrails","contrails");
		cloudMap.put("Stratocumulus","stratocumulus");
		cloudMap.put("Shallow cumulus","shallowCumulus");
		cloudMap.put("Cumulus congestus","cumulusCongestus");
		cloudMap.put("Cumulonimbus/towering cumulus","cumulonimbusToweringCumulus");
		cloudMap.put("Altostratus/altocumulus","altostratusAltocumulus");
		cloudMap.put("Wave clouds","waveClouds");
		cloudMap.put("Deep frontal statiform clouds","deepFrontalStratiformClouds");
		cloudMap.put("Cloud-free above aircraft","cloudFreeAboveAircraft");
		cloudMap.put("Cloud-free below aircraft","cloudFreeBelowAircraft");

		cpapMap.put("Rain","rain");
		cpapMap.put("Drizzle","drizzle");
		cpapMap.put("Droplets (liquid)","droplets");
		cpapMap.put("Pristine ice crystals","pristineIceCrystals");
		cpapMap.put("Snow/aggregates","snowOrAggregates");
		cpapMap.put("Graupel/hail","graupelOrHail");
		cpapMap.put("Sea-salt aerosol","seaSaltAerosol");
		cpapMap.put("Continental aerosol","continentalAerosol");
		cpapMap.put("Urban plume","urbanPlume");
		cpapMap.put("Biomass burning","biomassBurning");
		cpapMap.put("Desert/mineral dust","desertOrMineralDust");
		cpapMap.put("Volcanic ash","volcanicAsh");

		surfacesMap.put("Ocean","ocean");
		surfacesMap.put("Semi-arid","semiArid");
		surfacesMap.put("Sea-ice","seaIce");
		surfacesMap.put("Desert","desert");
		surfacesMap.put("Snow","snow");
		surfacesMap.put("Urban","urban");
		surfacesMap.put("Lake-ice","lakeIce");
		surfacesMap.put("Mountainous","mountainous");
		surfacesMap.put("Vegetation","vegetation");
		surfacesMap.put("Hilly","hilly");
		surfacesMap.put("Forest","forest");
		surfacesMap.put("Flat","flat");

		measurementMap.put("Boundary-layer","boundaryLayer");
		measurementMap.put("near-surface","blNearSurface");
		measurementMap.put("sub-cloud","blSubCloud");
		measurementMap.put("in-cloud","blInCloud");
		measurementMap.put("Lower troposphere","lowerTroposphere");
		measurementMap.put("Mid troposphere","midTroposphere");
		measurementMap.put("Upper troposphere","upperTroposphere");
		measurementMap.put("Lower stratosphere","lowerStratosphere");

		manoeuvreMap.put("Straight/level runs","straightLevelRuns");
		manoeuvreMap.put("stacked","stackedStraightLevelRuns");
		manoeuvreMap.put("separated","separatedStraightLevelRuns");
		manoeuvreMap.put("Racetracks","racetracks");
		manoeuvreMap.put("Orbits","orbits");
		manoeuvreMap.put("Lagrangian descents","lagrangianDescents");
		manoeuvreMap.put("Deep profile ascents/descents","deepProfileAscentDescents");
		manoeuvreMap.put("Dropsonde deployed","dropsondeDeployed");
		manoeuvreMap.put("Self-calibration","selfCalibration");

		satelliteMap.put("METOP","polarMetop");
		satelliteMap.put("NPOESS","polarNpoess");
		satelliteMap.put("A-train","polarAtrain");
		satelliteMap.put("Other (Polar)","polarOther");
		satelliteMap.put("MSG","geosynchMsg");
		satelliteMap.put("Other (Geosynch)","geosynchOther");
		satelliteMap.put("MODIS","modis");
		satelliteMap.put("Cloudsat","cloudsat");
		satelliteMap.put("CALIOP","caliop");
		satelliteMap.put("IASI","iasi");
		satelliteMap.put("AIRS","airs");
		satelliteMap.put("CriS","cris");
		satelliteMap.put("AMSU/MHS","amsuMhs");
		
		locationList.add("Do your choice...");
		locationList.add("Continents");
		locationList.add("Countries");
		locationList.add("Oceans");
		locationList.add("Regions");

		continentList.add("Do your choice...");
		continentList.add("Africa");
		continentList.add("Antarctica");
		continentList.add("Asia");
		continentList.add("Oceania");
		continentList.add("Europe");
		continentList.add("North America");
		continentList.add("South America");

		oceanList.add("Do your choice...");
		oceanList.add("Atlantic Ocean");
		oceanList.add("Arctic Ocean");
		oceanList.add("Indian Ocean");
		oceanList.add("Pacific Ocean");
		oceanList.add("Southern Ocean");

		regionList.add("Do your choice...");
		regionList.add("Arctic Region");
		regionList.add("Atlantic Ocean Islands");
		regionList.add("Central Africa");
		regionList.add("Central America");
		regionList.add("Central Europe");
		regionList.add("Eastern Africa");
		regionList.add("Eastern Asia");
		regionList.add("Eastern Europe");
		regionList.add("Indian Ocean Islands");
		regionList.add("Middle East");
		regionList.add("North America");
		regionList.add("Northern Africa");
		regionList.add("Northern Europe");
		regionList.add("Pacific Islands");
		regionList.add("South America");
		regionList.add("Southcentral Asia");
		regionList.add("Southern Asia");
		regionList.add("Southern Europe");
		regionList.add("Western Africa");
		regionList.add("Western Asia");
		regionList.add("Western Europe");
		
		countryList.add("Do your choice...");
		countryList.add("Afghanistan");
		countryList.add("Albania");
		countryList.add("Algeria");
		countryList.add("Amazonia");
		countryList.add("American Samoa");
		countryList.add("Amsterdam And St. Paul Islands");
		countryList.add("Andaman Islands");
		countryList.add("Andorra");
		countryList.add("Angola");
		countryList.add("Anguilla");
		countryList.add("Antigua And Barbuda");
		countryList.add("Argentina");
		countryList.add("Armenia");
		countryList.add("Aruba");
		countryList.add("Ascension Island");
		countryList.add("Australia");
		countryList.add("Austria");
		countryList.add("Azerbaijan");
		countryList.add("Bahamas");
		countryList.add("Bahrain");
		countryList.add("Baker Island");
		countryList.add("Bangladesh");
		countryList.add("Barbados");
		countryList.add("Belarus");
		countryList.add("Belgium");
		countryList.add("Belize");
		countryList.add("Benin");
		countryList.add("Bhutan");
		countryList.add("Bolivia");
		countryList.add("Bonaire");
		countryList.add("Bosnia And Herzegovina");
		countryList.add("Botswana");
		countryList.add("Bouvet Island");
		countryList.add("Brazil");
		countryList.add("British Isles");
		countryList.add("Brunei");
		countryList.add("Bulgaria");
		countryList.add("Burkina Faso");
		countryList.add("Burma");
		countryList.add("Burundi");
		countryList.add("Cambodia");
		countryList.add("Cameroon");
		countryList.add("Canada");
		countryList.add("Caribbean");
		countryList.add("Cayman Islands");
		countryList.add("Central African Republic");
		countryList.add("Ceuta");
		countryList.add("Chad");
		countryList.add("Channel Islands");
		countryList.add("Chile");
		countryList.add("China");
		countryList.add("Christmas Island");
		countryList.add("Cocos Islands");
		countryList.add("Colombia");
		countryList.add("Comoros");
		countryList.add("Congo, Democratic Republic");
		countryList.add("Congo, Republic");
		countryList.add("Cook Islands");
		countryList.add("Corsica");
		countryList.add("Costa Rica");
		countryList.add("Cote D'ivoire");
		countryList.add("Croatia");
		countryList.add("Crozet Islands");
		countryList.add("Cuba");
		countryList.add("Curacao");
		countryList.add("Cyprus");
		countryList.add("Czech Republic");
		countryList.add("Denmark");
		countryList.add("Dhekelia");
		countryList.add("Djibouti");
		countryList.add("Dominica");
		countryList.add("Dominican Republic");
		countryList.add("Ecuador");
		countryList.add("Egypt");
		countryList.add("El Salvador");
		countryList.add("Equatorial Guinea");
		countryList.add("Eritrea");
		countryList.add("Estonia");
		countryList.add("Ethiopia");
		countryList.add("Faeroe Islands");
		countryList.add("Falkland Islands");
		countryList.add("Fiji");
		countryList.add("Finland");
		countryList.add("France");
		countryList.add("French Guiana");
		countryList.add("French Polynesia");
		countryList.add("Gabon");
		countryList.add("Galapagos Islands");
		countryList.add("Gambia");
		countryList.add("Gaza Strip");
		countryList.add("Georgia, Republic");
		countryList.add("Germany");
		countryList.add("Ghana");
		countryList.add("Gibraltar");
		countryList.add("Gough Island");
		countryList.add("Greece");
		countryList.add("Greenland");
		countryList.add("Grenada");
		countryList.add("Guadeloupe");
		countryList.add("Guam");
		countryList.add("Guatemala");
		countryList.add("Guinea");
		countryList.add("Guinea-Bissau");
		countryList.add("Guyana");
		countryList.add("Haiti");
		countryList.add("Hawaii Island");
		countryList.add("Hawaiian Islands");
		countryList.add("Honduras");
		countryList.add("Hong Kong");
		countryList.add("Howland Island");
		countryList.add("Hungary");
		countryList.add("Iceland");
		countryList.add("India");
		countryList.add("Indonesia");
		countryList.add("Iran");
		countryList.add("Iraq");
		countryList.add("Ireland");
		countryList.add("Israel");
		countryList.add("Italy");
		countryList.add("Jamaica");
		countryList.add("Japan");
		countryList.add("Jarvis Island");
		countryList.add("Johnston Atoll");
		countryList.add("Jordan");
		countryList.add("Kahoolawe");
		countryList.add("Kauai");
		countryList.add("Kazakhstan");
		countryList.add("Kenya");
		countryList.add("Kerguelen Islands");
		countryList.add("Kingman Reef");
		countryList.add("Kiribati");
		countryList.add("Kosovo");
		countryList.add("Kuwait");
		countryList.add("Kyrgyzstan");
		countryList.add("Laeso");
		countryList.add("Lake Chad");
		countryList.add("Lake Malawi");
		countryList.add("Lake Tanganyika");
		countryList.add("Lake Victoria");
		countryList.add("Lanai");
		countryList.add("Laos");
		countryList.add("Latvia");
		countryList.add("Lebanon");
		countryList.add("Lesotho");
		countryList.add("Liberia");
		countryList.add("Libya");
		countryList.add("Liechtenstein");
		countryList.add("Lithuania");
		countryList.add("Luxembourg");
		countryList.add("Macau");
		countryList.add("Macedonia");
		countryList.add("Madagascar");
		countryList.add("Madeira");
		countryList.add("Malawi");
		countryList.add("Malaysia");
		countryList.add("Maldives");
		countryList.add("Mali");
		countryList.add("Malta");
		countryList.add("Marshall Islands");
		countryList.add("Martinique");
		countryList.add("Maui");
		countryList.add("Mauritania");
		countryList.add("Mauritius");
		countryList.add("Melanesia");
		countryList.add("Mexico");
		countryList.add("Micronesia");
		countryList.add("Midway Atoll");
		countryList.add("Moldova");
		countryList.add("Molokai");
		countryList.add("Monaco");
		countryList.add("Mongolia");
		countryList.add("Montenegro");
		countryList.add("Montserrat");
		countryList.add("Morocco");
		countryList.add("Mozambique");
		countryList.add("Namibia");
		countryList.add("Nauru");
		countryList.add("Navassa Island");
		countryList.add("Nepal");
		countryList.add("Netherlands Antilles");
		countryList.add("Netherlands");
		countryList.add("New Caledonia");
		countryList.add("New Zealand");
		countryList.add("Nicaragua");
		countryList.add("Nicobar Islands");
		countryList.add("Niger");
		countryList.add("Nigeria");
		countryList.add("Niihau");
		countryList.add("Niue");
		countryList.add("Norfolk Island");
		countryList.add("North Korea");
		countryList.add("Northern Mariana Islands");
		countryList.add("Norway");
		countryList.add("Oahu");
		countryList.add("Okinawa");
		countryList.add("Oman");
		countryList.add("Pakistan");
		countryList.add("Palau");
		countryList.add("Palestine");
		countryList.add("Palmyra Atoll");
		countryList.add("Panama");
		countryList.add("Papua New Guinea");
		countryList.add("Paraguay");
		countryList.add("Peru");
		countryList.add("Philippines");
		countryList.add("Pitcairn Island");
		countryList.add("Pitcairn Islands");
		countryList.add("Poland");
		countryList.add("Polynesia");
		countryList.add("Portugal");
		countryList.add("Puerto Rico");
		countryList.add("Qatar");
		countryList.add("Red Sea");
		countryList.add("Reunion");
		countryList.add("Romania");
		countryList.add("Russia");
		countryList.add("Rwanda");
		countryList.add("Saba");
		countryList.add("Sable Island");
		countryList.add("Samoa");
		countryList.add("San Marino");
		countryList.add("Sao Tome And Principe");
		countryList.add("Sardinia");
		countryList.add("Saudi Arabia");
		countryList.add("Scandinavia");
		countryList.add("Senegal");
		countryList.add("Serbia");
		countryList.add("Seychelles");
		countryList.add("Sicily");
		countryList.add("Sierra Leone");
		countryList.add("Singapore");
		countryList.add("Slovakia");
		countryList.add("Slovenia");
		countryList.add("Solomon Islands");
		countryList.add("Somalia");
		countryList.add("South Africa");
		countryList.add("South Georgia Island");
		countryList.add("South Korea");
		countryList.add("South Orkney Islands");
		countryList.add("South Sandwich Islands");
		countryList.add("Spain");
		countryList.add("Spratly Islands");
		countryList.add("Sri Lanka");
		countryList.add("St Barthelemy");
		countryList.add("St Eustatius");
		countryList.add("St Helena");
		countryList.add("St Kitts And Nevis");
		countryList.add("St Lucia");
		countryList.add("St Maarten");
		countryList.add("St Martin");
		countryList.add("St Pierre And Miquelon");
		countryList.add("St Vincent And The Grenadines");
		countryList.add("Sudan");
		countryList.add("Suriname");
		countryList.add("Svalbard And Jan Mayen");
		countryList.add("Swaziland");
		countryList.add("Sweden");
		countryList.add("Switzerland");
		countryList.add("Syria");
		countryList.add("Taiwan");
		countryList.add("Tajikistan");
		countryList.add("Tanzania");
		countryList.add("Thailand");
		countryList.add("Togo");
		countryList.add("Tokelau");
		countryList.add("Tonga");
		countryList.add("Trinidad And Tobago");
		countryList.add("Tristan Da Cunha");
		countryList.add("Tunisia");
		countryList.add("Turkey");
		countryList.add("Turkmenistan");
		countryList.add("Turks And Caicos Islands");
		countryList.add("Tuvalu");
		countryList.add("Uganda");
		countryList.add("Ukraine");
		countryList.add("United Arab Emirates");
		countryList.add("United Kingdom");
		countryList.add("United States of America");
		countryList.add("Uruguay");
		countryList.add("Uzbekistan");
		countryList.add("Vanuatu");
		countryList.add("Vatican City");
		countryList.add("Venezuela");
		countryList.add("Vietnam");
		countryList.add("Virgin Islands");
		countryList.add("Wake Island");
		countryList.add("Wallis And Futuna Islands");
		countryList.add("Yemen");
		countryList.add("Zambia");
		countryList.add("Zanzibar");
		countryList.add("Zimbabwe");
		
		roleList.add("Do your choice...");
		roleList.add("Mission Scientist");
		roleList.add("Flight Manager");
		roleList.add("Scientist");
		roleList.add("Pilot");
		roleList.add("Other");
		
		operatorList.add("Do your choice...");
		operatorList.add("Alfred Wegener Institute");
        operatorList.add("CNR - Istituto per i Sistemi Agricoli e Forestali del Mediterraneo");
        operatorList.add("CNR - Istituto di Metodologie per l'Analisi Ambientale");
        operatorList.add("Deutsches Zentrum fur Luft- und Raumfahrt");
        operatorList.add("ENVISCOPE");
        operatorList.add("NERC - Facility for Airborne Atmospheric Measurements");
        operatorList.add("FUB - Institut fur Weltraumwissenschaften");
        operatorList.add("Instituto Nacional de Tecnica Aeroespacial");
        operatorList.add("KIT - Institute of Meteorology and Climate Research");
        operatorList.add("NERC - Airborne Research and Survey Facility");
        operatorList.add("NERC - British Antarctic Survey");
        operatorList.add("SAFIRE");
        operatorList.add("UEDIN - Airborne GeoSciences");
        operatorList.add("Other");
		
		aircraftList.add("BT-67 POLAR 5");
        aircraftList.add("Sky Arrow 650");
        aircraftList.add("Partenavia P-68");
        aircraftList.add("Cessna 208");
        aircraftList.add("Dornier DO-228 D-CFFU");
        aircraftList.add("Dornier DO-228 D-CODE");
        aircraftList.add("Mystere/Falcon 20");
        aircraftList.add("Learjet 35");
        aircraftList.add("BAe-146");
        aircraftList.add("Cessna 207");
        aircraftList.add("CASA-212 AR");
        aircraftList.add("CASA-212 RS");
        aircraftList.add("Enduro");
        aircraftList.add("Dornier DO-228");
        aircraftList.add("DHC-6 Twin Otter");
        aircraftList.add("ATR-42");
        aircraftList.add("Piper PA23");
        aircraftList.add("HK36TTC ECO Dimona");
		
        textboxName.add("flightNumber");
        textboxName.add("flightCampaign");
        textboxName.add("flightScientist");
        textboxName.add("flightManager");
        textboxName.add("contactName");
        textboxName.add("contactEmail");
        textboxName.add("scientificComments");
        textboxName.add("northBound");
        textboxName.add("southBound");
        textboxName.add("minAltitude");
        textboxName.add("maxAltitude");
        textboxName.add("westBound");
        textboxName.add("eastBound");
        textboxName.add("geographicComments");
        textboxName.add("atmosphericComments");
        textboxName.add("typesComments");
        textboxName.add("particlesComments");
        textboxName.add("surfacesComments");
        textboxName.add("measurementComments");
        textboxName.add("manoeuvreComments");
        textboxName.add("satelliteComments");
        textboxName.add("groundsite1");
        textboxName.add("groundsite2");
        textboxName.add("groundsite3");
        textboxName.add("groundsite4");
        textboxName.add("additionalNotes");
        
        checkboxName.add("sa_satCalval");
    	checkboxName.add("sa_antPollution");
    	checkboxName.add("sa_mesoImpacts");
    	checkboxName.add("sa_microPhysics");
    	checkboxName.add("sa_dyNamics");
    	checkboxName.add("sa_radProperties");
    	checkboxName.add("sa_convDynamics");
    	checkboxName.add("sa_gazChemistry");
    	checkboxName.add("sa_oxyDants");
    	checkboxName.add("sa_orgAnics");
    	checkboxName.add("sa_other1");
    	checkboxName.add("sa_aeroSol");
    	checkboxName.add("sa_cloudImpacts");
    	checkboxName.add("sa_radImpacts");
    	checkboxName.add("sa_radIation");
    	checkboxName.add("sa_atmSpectroscopy");
    	checkboxName.add("sa_surfProperties");
    	checkboxName.add("sa_other2");
    	checkboxName.add("sa_cloud");
    	checkboxName.add("sa_dynAmics");
    	checkboxName.add("gi_polar");
    	checkboxName.add("gi_midLatitudes");
    	checkboxName.add("gi_subTropical");
    	checkboxName.add("gi_tropical");
    	checkboxName.add("gi_maritime");
    	checkboxName.add("gi_continental");
    	checkboxName.add("gi_oceanicIslands");
    	checkboxName.add("gi_other");
    	checkboxName.add("af_stationary");
    	checkboxName.add("af_antiStationary");
    	checkboxName.add("af_cycloStationary");
    	checkboxName.add("af_warmFront");
    	checkboxName.add("af_warmBelt");
    	checkboxName.add("af_coldFront");
    	checkboxName.add("af_occludedFront");
    	checkboxName.add("af_warmSector");
    	checkboxName.add("af_airMass");
    	checkboxName.add("af_airOutbreack");
    	checkboxName.add("af_orographicInfluence");
    	checkboxName.add("af_seabreezeFront");
    	checkboxName.add("af_foldIntrusion");
    	checkboxName.add("af_convergenceLine");
    	checkboxName.add("af_easterlyWave");
    	checkboxName.add("af_equatorialWave");
    	checkboxName.add("af_tropicalCyclone");
    	checkboxName.add("af_organizedConvection");
    	checkboxName.add("ct_waterClouds");
    	checkboxName.add("ct_mixedphasedClouds");
    	checkboxName.add("ct_iceClouds");
    	checkboxName.add("ct_cirrus");
    	checkboxName.add("ct_contrails");
    	checkboxName.add("ct_stratocumulus");
    	checkboxName.add("ct_shallowCumulus");
    	checkboxName.add("ct_cumulusCongestus");
    	checkboxName.add("ct_cumulTower");
    	checkboxName.add("ct_altoStracumul");
    	checkboxName.add("ct_waveClouds");
    	checkboxName.add("ct_statiformClouds");
    	checkboxName.add("ct_freeAbove");
    	checkboxName.add("ct_freeBelow");
    	checkboxName.add("cp_rain");
    	checkboxName.add("cp_drizzle");
    	checkboxName.add("cp_dropletsLiquid");
    	checkboxName.add("cp_pristineCrystals");
    	checkboxName.add("cp_snowAggregates");
    	checkboxName.add("cp_graupelHail");
    	checkboxName.add("cp_saltAerosol");
    	checkboxName.add("cp_continentalAerosol");
    	checkboxName.add("cp_urbanPlume");
    	checkboxName.add("cp_biomassBurning");
    	checkboxName.add("cp_desertDust");
    	checkboxName.add("cp_volcanicAsh");
    	checkboxName.add("lo_ocean");
    	checkboxName.add("lo_semiArid");
    	checkboxName.add("lo_seaIce");
    	checkboxName.add("lo_desert");
    	checkboxName.add("lo_snow");
    	checkboxName.add("lo_urban");
    	checkboxName.add("lo_lakeIce");
    	checkboxName.add("lo_mountainous");
    	checkboxName.add("lo_vegetation");
    	checkboxName.add("lo_hilly");
    	checkboxName.add("lo_forest");
    	checkboxName.add("lo_flat");
    	checkboxName.add("ar_boundaryLayer");
    	checkboxName.add("ar_nearSurface");
    	checkboxName.add("ar_subCloud");
    	checkboxName.add("ar_inCloud");
    	checkboxName.add("ar_lowerTroposphere");
    	checkboxName.add("ar_midTroposphere");
    	checkboxName.add("ar_upperTroposphere");
    	checkboxName.add("ar_lowerstratosphere");
    	checkboxName.add("fm_levelRuns");
    	checkboxName.add("fm_stacked");
    	checkboxName.add("fm_separated");
    	checkboxName.add("fm_racetracks");
    	checkboxName.add("fm_orbits");
    	checkboxName.add("fm_lagrangianDescents");
    	checkboxName.add("fm_ascDescents");
    	checkboxName.add("fm_dropsondeDeployed");
    	checkboxName.add("fm_selfCalibration");
    	checkboxName.add("sc_metop");
    	checkboxName.add("sc_npoess");
    	checkboxName.add("sc_atrain");
    	checkboxName.add("sc_other");
    	checkboxName.add("sc_msg");
    	checkboxName.add("sc_other2");
    	checkboxName.add("sc_modis");
    	checkboxName.add("sc_cloudsat");
    	checkboxName.add("sc_caliop");
    	checkboxName.add("sc_iasi");
    	checkboxName.add("sc_airs");
    	checkboxName.add("sc_cris");
    	checkboxName.add("sc_amsuMhs");
    	
    	listboxName.add("operatorText");
    	listboxName.add("aircraftText");
    	listboxName.add("localisationText");
    	listboxName.add("countryText");
    	listboxName.add("roleText");
    	
    	dateboxName.add("date");
    	
        
		// Commands in the menu bar
		Command aboutWindow = new Command() {public void execute() {aboutWindow();}};
		Command aboutStandard = new Command() {public void execute() {aboutStandard();}};
		Command newFile = new Command() {public void execute() {newFile();}};
		Command openFile = new Command() {public void execute() {openFile();}};
		Command saveFile = new Command() {public void execute() {saveFile("");}};
		Command printFile = new Command() {public void execute() {printFile();}};
		Command launchN7SPPage = new Command()  {public void execute() {Window.open("http://www.eufar.net/N6SP", "_blank", "");}};
		Command exitFile = new Command()  {public void execute() {Window.open("http://www.eufar.net", "_self", "");}};
		Command confLayout = new Command() {public void execute() {layoutPopup();}};


		// Menu bar items
		aboutMenu.addItem(new MenuItem(imageAbout,true,aboutWindow));
		aboutMenu.addItem(new MenuItem(imageStandard,true,aboutStandard));
		aboutMenu.addItem(new MenuItem(imageEufar,true,launchN7SPPage));
		fileMenu.addItem(new MenuItem(imageNew,true,newFile));
		fileMenu.addItem(new MenuItem(imageOpen,true,openFile));
		fileMenu.addItem(new MenuItem(imageSave,true,saveFile));
		fileMenu.addItem(new MenuItem(imagePrint,true,printFile));
		fileMenu.addItem(new MenuItem(imageExit,true,exitFile));
		confMenu.addItem(new MenuItem(imageConf,true,confLayout));
		mainMenu.addItem("File", fileMenu);
		mainMenu.addItem("Layout", confMenu);
		mainMenu.addItem("About", aboutMenu);


		// Assemble Flight Information panel.
		populateListBox(fi_countryText, countryList, 0);
		populateListBox(fi_operatorText, operatorList, 0);
		populateListBox(geoLocationLst, locationList, 0);
		horizontalPanel26.add(fi_operatorText);
		fi_operatorImage.setStyleName("fi_image");
		fi_aircraftImage.setStyleName("fi_image");
		fi_otherOpsText.setStyleName("fi_textBox");
		fi_otherAiText.setStyleName("fi_textBox");
		horizontalPanel27.add(fi_aircraftText);
		fi_aircraftText.setEnabled(false);
		fiGrid.setWidget(0, 0, fi_campaignLabel);
		fiGrid.setWidget(0, 1, fi_campaignText);
		fiGrid.setWidget(1, 0, fi_dateLabel);
		fi_dateText.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("yyyy-MM-dd")));
		fi_dateText.setValue(new Date());
		fiGrid.setWidget(1, 1, fi_dateText);
		fiGrid.setWidget(2, 0, fi_flightLabel);
		fiGrid.setWidget(2, 1, fi_flightText);
		fiGrid.setWidget(3, 0, fi_scientistLabel);
		fiGrid.setWidget(3, 1, fi_scientistText);
		fiGrid.setWidget(4, 0, fi_managerLabel);
		fiGrid.setWidget(4, 1, fi_managerText);
		fiGrid.setWidget(5, 0, fi_operatorLabel);
		fiGrid.setWidget(5, 1, horizontalPanel26);
		fiGrid.setWidget(6, 0, fi_aircraftLabel);
		fiGrid.setWidget(6, 1, horizontalPanel27);
		fiGrid.setWidget(7, 0, fi_countryLabel);
		horizontalPanel30.add(geoLocationLst);
		horizontalPanel30.add(geoFollowImage);
		fiGrid.setWidget(7, 1, horizontalPanel30);
		fiGrid.setWidget(7, 2, geoDetailLst);
		fi_countryLabel.getElement().setAttribute("style", "margin-bottom: 10px !important;");
		geoLocationLst.setStyleName("geoTextList");
		geoDetailLst.setStyleName("geoTextList");
		geoDetailLst.setEnabled(false);
		geoFollowImage.setStyleName("fi_image");
		fi_flightText.setStyleName("fi_textBox");
		fi_campaignText.setStyleName("fi_textBox");
		fi_scientistText.setStyleName("fi_textBox");
		fi_managerText.setStyleName("fi_textBox");
		fi_aircraftText.setStyleName("fi_textList2");
		fi_operatorText.setStyleName("fi_textList2");
		fi_operatorText.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {aircraftSelection(fi_operatorText.getSelectedItemText());}
		});
		geoLocationLst.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {geoLocationSet(geoLocationLst.getSelectedIndex());}
		});


		// Assemble Contact Information panel.
		populateListBox(ci_roleText, roleList, 0);
		ciGrid.setWidget(0, 0, ci_nameLabel);
		ciGrid.setWidget(0, 1, ci_nameText);
		ciGrid.setWidget(1, 0, ci_roleLabel);
		ciGrid.setWidget(1, 1, ci_roleText);
		ciGrid.setWidget(2, 0, ci_emailLabel);
		ciGrid.setWidget(2, 1, ci_emailText);
		ci_nameText.setStyleName("fi_textBox");
		ci_emailText.setStyleName("fi_textBox");
		ci_roleText.setStyleName("ci_textList");


		// Assemble Scientific Aims panel.
		sa_microPhysics.setStyleName("sa_checkBox");
		sa_dyNamics.setStyleName("sa_checkBox");
		sa_radProperties.setStyleName("sa_checkBox");
		sa_convDynamics.setStyleName("sa_checkBox");
		sa_oxyDants.setStyleName("sa_checkBox");
		sa_orgAnics.setStyleName("sa_checkBox");
		sa_other1.setStyleName("sa_checkBox");
		sa_cloudImpacts.setStyleName("sa_checkBox");
		sa_radImpacts.setStyleName("sa_checkBox");
		sa_atmSpectroscopy.setStyleName("sa_checkBox");
		sa_surfProperties.setStyleName("sa_checkBox");
		sa_other2.setStyleName("sa_checkBox");
		sa_cloud.setStyleName("sa_checkBox");
		sa_dynAmics.setStyleName("sa_checkBox");
		verticalPanel01.setSpacing(10);
		verticalPanel01.add(sa_satCalval);
		verticalPanel01.add(sa_antPollution);
		verticalPanel01.add(sa_mesoImpacts);
		verticalPanel01.getElement().setAttribute("style", "margin-top: 20px !important; margin-left: 20px !important;");
		verticalPanel02.setSpacing(10);
		verticalPanel02.add(sa_cloudLabel);
		sa_cloudLabel.setStyleName("gi_titleText2");
		verticalPanel02.add(sa_microPhysics);
		verticalPanel02.add(sa_dyNamics);
		verticalPanel02.add(sa_radProperties);
		verticalPanel02.add(sa_convDynamics);
		verticalPanel02.setStyleName("sa_verticalPanel");
		verticalPanel02.getElement().setAttribute("style", "margin-top: 0px !important; height: 110px !important; width: 300px !important;");
		verticalPanel03.add(verticalPanel01);
		verticalPanel03.add(verticalPanel02);
		verticalPanel04.setSpacing(10);
		verticalPanel04.add(sa_gazChemistry);
		verticalPanel04.add(sa_oxyDants);
		verticalPanel04.add(sa_orgAnics);
		verticalPanel04.add(sa_other1);
		verticalPanel04.setStyleName("sa_verticalPanel");
		verticalPanel04.getElement().setAttribute("style", "height: 110px !important; width: 300px !important;");
		verticalPanel05.setSpacing(10);
		verticalPanel05.add( sa_aeroSol);
		verticalPanel05.add(sa_cloudImpacts);
		verticalPanel05.add(sa_radImpacts);
		verticalPanel05.setStyleName("sa_verticalPanel");
		verticalPanel05.getElement().setAttribute("style", "margin-top:20px !important; height: 110px !important; width: 300px !important;");
		verticalPanel06.add(verticalPanel04);
		verticalPanel06.add(verticalPanel05);
		verticalPanel07.setSpacing(10);
		verticalPanel07.add(sa_radIation);
		verticalPanel07.add(sa_atmSpectroscopy);
		verticalPanel07.add(sa_surfProperties);
		verticalPanel07.add(sa_other2);
		verticalPanel07.setStyleName("sa_verticalPanel");
		verticalPanel07.getElement().setAttribute("style", "height: 110px !important; width: 300px !important;");
		verticalPanel08.setSpacing(10);
		verticalPanel08.add(sa_layerLabel);
		sa_layerLabel.setStyleName("gi_titleText2");
		verticalPanel08.add(sa_cloud);
		verticalPanel08.add(sa_dynAmics);
		verticalPanel08.setStyleName("sa_verticalPanel");
		verticalPanel08.getElement().setAttribute("style", "margin-top:20px !important; height: 110px !important; width: 300px !important;");
		verticalPanel09.add(verticalPanel07);
		verticalPanel09.add(verticalPanel08);
		horizontalPanel01.add(verticalPanel03);
		horizontalPanel01.add(verticalPanel06);
		horizontalPanel01.add(verticalPanel09);
		verticalPanel10.add(horizontalPanel01);
		verticalPanel10.add(new HTML("<br />"));
		horizontalPanel31.add(addCatButton(sa_addCatTable, sa_addCatMap, verticalPanel67));
		horizontalPanel31.add(addInfoButton());
		verticalPanel67.add(horizontalPanel31);
		verticalPanel10.add(verticalPanel67);
		verticalPanel10.add(new HTML("<br />"));
		verticalPanel10.add(new HTML("<br />"));
		horizontalPanel02.add(sa_comments);
		sa_comments.setStyleName("gi_titleText");
		horizontalPanel02.add(sa_comArea);
		sa_comArea.setStyleName("sa_textArea");
		verticalPanel10.add(horizontalPanel02);


		// Assemble Geographic Information panel.
		verticalPanel11.add(gi_boundingLabel);
		gi_boundTable.setWidget(0, 0, gi_nsLabel);
		gi_boundTable.setWidget(0, 1, gi_northText);
		gi_boundTable.setWidget(0, 2, gi_southText);
		gi_boundTable.setWidget(0, 3, gi_mmLabel);
		gi_boundTable.setWidget(0, 4, gi_minText);
		gi_boundTable.setWidget(0, 5, gi_maxText);
		gi_boundTable.setWidget(1, 0, gi_weLabel);
		gi_boundTable.setWidget(1, 1, gi_westText);
		gi_boundTable.setWidget(1, 2, gi_eastText);
		verticalPanel11.add(gi_boundTable);
		verticalPanel11.add(new HTML("<br />"));
		verticalPanel11.add(gi_situationLabel);
		verticalPanel62.setSpacing(10);
		verticalPanel62.add(gi_polar);
		verticalPanel62.add(gi_midLatitudes);
		horizontalPanel05.add(verticalPanel62);
		verticalPanel63.setSpacing(10);
		verticalPanel63.add(gi_subTropical);
		verticalPanel63.add(gi_tropical);
		horizontalPanel05.add(verticalPanel63);
		verticalPanel64.setSpacing(10);
		verticalPanel64.add(gi_maritime);
		verticalPanel64.add(gi_continental);
		horizontalPanel05.add(verticalPanel64);
		verticalPanel65.setSpacing(10);
		verticalPanel65.add(gi_oceanicIslands);
		verticalPanel65.add(gi_other);
		horizontalPanel05.add(verticalPanel65);
		verticalPanel11.add(horizontalPanel05);
		verticalPanel68.add(addCatButton(gi_addCatTable, gi_addCatMap, verticalPanel68));
		verticalPanel11.add(verticalPanel68);
		verticalPanel11.add(new HTML("<br />"));
		horizontalPanel06.add(gi_comLabel);
		horizontalPanel06.add(gi_comArea);
		verticalPanel11.add(horizontalPanel06);
		verticalPanel11.setSpacing(10);
		gi_boundingLabel.setStyleName("gi_titleText");
		horizontalPanel03.getElement().setAttribute("style", "margin-left: 40px !important;");
		verticalPanel15.getElement().setAttribute("style", "margin-left: 20px !important;");
		gi_northText.setStyleName("gi_textBox");
		gi_southText.setStyleName("gi_textBox");
		gi_westText.setStyleName("gi_textBox2");
		gi_eastText.setStyleName("gi_textBox2");
		gi_minText.setStyleName("gi_textBox");
		gi_maxText.setStyleName("gi_textBox");
		gi_boundTable.setStyleName("gi_boundTab");
		gi_situationLabel.setStyleName("gi_titleText2");
		horizontalPanel05.getElement().setAttribute("style", "margin-left: 25px !important;");
		verticalPanel63.getElement().setAttribute("style", "margin-left: 40px !important;");
		verticalPanel64.getElement().setAttribute("style", "margin-left: 40px !important;");
		verticalPanel65.getElement().setAttribute("style", "margin-left: 40px !important;");
		gi_comLabel.setStyleName("gi_titleText2");
		gi_comArea.setStyleName("sa_textArea");


		// Assemble Atmospheric Synoptic Features panel
		verticalPanel16.add(af_stationary);
		verticalPanel16.add(af_antiStationary);
		af_antiStationary.setStyleName("sa_checkBox");
		verticalPanel16.add(af_cycloStationary);
		af_cycloStationary.setStyleName("sa_checkBox");
		verticalPanel16.add(af_warmFront);
		verticalPanel16.add(af_warmBelt);
		verticalPanel16.setSpacing(10);
		horizontalPanel07.add(verticalPanel16);
		verticalPanel17.add(af_coldFront);
		verticalPanel17.add(af_occludedFront);
		verticalPanel17.add(af_warmSector);
		verticalPanel17.add(af_airMass);
		verticalPanel17.add(af_airOutbreack );
		verticalPanel17.setSpacing(10);
		verticalPanel17.getElement().setAttribute("style", "margin-left: 40px !important;");
		horizontalPanel07.add(verticalPanel17);
		verticalPanel18.add(af_orographicInfluence);
		verticalPanel18.add(af_seabreezeFront);
		verticalPanel18.add(af_foldIntrusion);
		verticalPanel18.add(af_convergenceLine);
		verticalPanel18.setSpacing(10);
		verticalPanel18.getElement().setAttribute("style", "margin-left: 40px !important;");
		horizontalPanel07.add(verticalPanel18);
		verticalPanel19.add(af_easterlyWave);
		verticalPanel19.add(af_equatorialWave);
		verticalPanel19.add(af_tropicalCyclone);
		verticalPanel19.add(af_organizedConvection);
		verticalPanel19.setSpacing(10);
		verticalPanel19.getElement().setAttribute("style", "margin-left: 40px !important;");
		horizontalPanel07.add(verticalPanel19);
		verticalPanel20.add(horizontalPanel07);
		verticalPanel20.add(new HTML("<br />"));
		verticalPanel69.add(addCatButton(af_addCatTable, af_addCatMap, verticalPanel69));
		verticalPanel20.add(verticalPanel69);
		verticalPanel20.add(new HTML("<br />"));
		horizontalPanel08.add(af_comLabel);
		af_comLabel.setStyleName("gi_titleText2");
		horizontalPanel08.add(af_comArea);
		af_comArea.setStyleName("sa_textArea");
		verticalPanel20.add(horizontalPanel08);


		// Assemble Cloud Types and Forms Sampled During Flight panel
		verticalPanel21.add(ct_waterClouds);
		verticalPanel21.add(ct_mixedphasedClouds);
		verticalPanel21.add(ct_iceClouds);
		verticalPanel21.add(ct_cirrus);
		verticalPanel21.setSpacing(10);
		horizontalPanel09.add(verticalPanel21);
		verticalPanel22.add(ct_contrails);
		verticalPanel22.add(ct_stratocumulus);
		verticalPanel22.add(ct_shallowCumulus);
		verticalPanel22.add(ct_cumulusCongestus);
		verticalPanel22.setSpacing(10);
		verticalPanel22.getElement().setAttribute("style", "margin-left: 40px !important;");
		horizontalPanel09.add(verticalPanel22);
		verticalPanel23.add(ct_cumulTower);
		verticalPanel23.add(ct_altoStracumul);
		verticalPanel23.add(ct_waveClouds);
		verticalPanel23.setSpacing(10);
		verticalPanel23.getElement().setAttribute("style", "margin-left: 40px !important;");
		horizontalPanel09.add(verticalPanel23);
		verticalPanel24.add(ct_statiformClouds);
		verticalPanel24.add(ct_freeAbove);
		verticalPanel24.add(ct_freeBelow);
		verticalPanel24.setSpacing(10);
		verticalPanel24.getElement().setAttribute("style", "margin-left: 40px !important;");
		horizontalPanel09.add(verticalPanel24);
		verticalPanel25.add(horizontalPanel09);
		verticalPanel25.add(new HTML("<br />"));
		verticalPanel70.add(addCatButton(ct_addCatTable, ct_addCatMap, verticalPanel70));
		verticalPanel25.add(verticalPanel70);
		verticalPanel25.add(new HTML("<br />"));
		horizontalPanel10.add(ct_comLabel);
		ct_comLabel.setStyleName("gi_titleText2");
		horizontalPanel10.add(ct_comArea);
		ct_comArea.setStyleName("sa_textArea");
		verticalPanel25.add(horizontalPanel10);


		// Assemble Cloud, Precipitation and Aerosol Particles Sampled panel
		verticalPanel26.add(cp_rain);
		verticalPanel26.add(cp_drizzle);
		verticalPanel26.add(cp_dropletsLiquid);
		verticalPanel26.setSpacing(10);
		horizontalPanel11.add(verticalPanel26);
		verticalPanel27.add(cp_pristineCrystals);
		verticalPanel27.add(cp_snowAggregates);
		verticalPanel27.add(cp_graupelHail);
		verticalPanel27.setSpacing(10);
		verticalPanel27.getElement().setAttribute("style", "margin-left: 40px !important;");
		horizontalPanel11.add(verticalPanel27);
		verticalPanel28.add(cp_saltAerosol);
		verticalPanel28.add(cp_continentalAerosol);
		verticalPanel28.add(cp_urbanPlume);
		verticalPanel28.setSpacing(10);
		verticalPanel28.getElement().setAttribute("style", "margin-left: 60px !important;");
		horizontalPanel11.add(verticalPanel28);
		verticalPanel29.add(cp_biomassBurning);
		verticalPanel29.add(cp_desertDust);
		verticalPanel29.add(cp_volcanicAsh);
		verticalPanel29.setSpacing(10);
		verticalPanel29.getElement().setAttribute("style", "margin-left: 50px !important;");
		horizontalPanel11.add(verticalPanel29);
		verticalPanel30.add(horizontalPanel11);
		verticalPanel30.add(new HTML("<br />"));
		verticalPanel71.add(addCatButton(cp_addCatTable, cp_addCatMap, verticalPanel71));
		verticalPanel30.add(verticalPanel71);
		verticalPanel30.add(new HTML("<br />"));
		horizontalPanel12.add(cp_comLabel);
		cp_comLabel.setStyleName("gi_titleText2");
		horizontalPanel12.add(cp_comArea);
		cp_comArea.setStyleName("sa_textArea");
		verticalPanel30.add(horizontalPanel12);


		// Assemble Land or Oceans Surfaces Overflown panel
		verticalPanel31.add(lo_ocean);
		verticalPanel31.add(lo_semiArid);
		verticalPanel31.add(lo_seaIce);
		verticalPanel31.setSpacing(10);
		horizontalPanel13.add(verticalPanel31);
		verticalPanel32.add(lo_desert);
		verticalPanel32.add(lo_snow);
		verticalPanel32.add(lo_urban);
		verticalPanel32.setSpacing(10);
		horizontalPanel13.add(verticalPanel32);
		verticalPanel33.add(lo_lakeIce);
		verticalPanel33.add(lo_forest);
		verticalPanel33.add(lo_vegetation);
		verticalPanel33.setSpacing(10);
		horizontalPanel13.add(verticalPanel33);
		verticalPanel34.add(lo_mountainous);
		verticalPanel34.add(lo_hilly);
		verticalPanel34.add(lo_flat);
		verticalPanel34.setSpacing(10);
		horizontalPanel13.add(verticalPanel34);
		verticalPanel35.add(horizontalPanel13);
		verticalPanel35.add(new HTML("<br />"));
		verticalPanel72.add(addCatButton(lo_addCatTable, lo_addCatMap, verticalPanel72));
		verticalPanel35.add(verticalPanel72);
		verticalPanel35.add(new HTML("<br />"));
		horizontalPanel14.add(lo_comLabel);
		lo_comLabel.setStyleName("gi_titleText2");
		horizontalPanel14.add(lo_comArea);
		lo_comArea.setStyleName("sa_textArea");
		verticalPanel35.add(horizontalPanel14);
		lo_desert.getElement().setAttribute("style", "margin-left:70px !important;");
		lo_snow.getElement().setAttribute("style", "margin-left:70px !important;");
		lo_urban.getElement().setAttribute("style", "margin-left:70px !important;");
		lo_lakeIce.getElement().setAttribute("style", "margin-left:70px !important;");
		lo_mountainous.getElement().setAttribute("style", "margin-left:70px !important;");
		lo_vegetation.getElement().setAttribute("style", "margin-left:70px !important;");
		lo_hilly.getElement().setAttribute("style", "margin-left:70px !important;");
		lo_forest.getElement().setAttribute("style", "margin-left:70px !important;");
		lo_flat.getElement().setAttribute("style", "margin-left:70px !important;");


		// Assemble Altitude Range of Measurement panel
		verticalPanel36.add(ar_boundaryLayer);
		verticalPanel36.add(ar_nearSurface);
		ar_nearSurface.setStyleName("sa_checkBox");
		verticalPanel36.add(ar_subCloud);
		ar_subCloud.setStyleName("sa_checkBox");
		verticalPanel36.add(ar_inCloud);
		ar_inCloud.setStyleName("sa_checkBox");
		verticalPanel36.setSpacing(10);
		horizontalPanel15.add(verticalPanel36);
		verticalPanel37.add(ar_lowerTroposphere);
		ar_lowerTroposphere.getElement().setAttribute("style", "margin-left:100px !important;");
		verticalPanel37.add(ar_midTroposphere);
		ar_midTroposphere.getElement().setAttribute("style", "margin-left:100px !important;");
		verticalPanel37.add(ar_upperTroposphere);
		ar_upperTroposphere.getElement().setAttribute("style", "margin-left:100px !important;");
		verticalPanel37.add(ar_lowerstratosphere);
		ar_lowerstratosphere.getElement().setAttribute("style", "margin-left:100px !important;");
		verticalPanel37.setSpacing(10);
		horizontalPanel15.add(verticalPanel37);
		verticalPanel38.add(horizontalPanel15);
		verticalPanel38.add(new HTML("<br />"));
		verticalPanel73.add(addCatButton(ar_addCatTable, ar_addCatMap, verticalPanel73));
		verticalPanel38.add(verticalPanel73);
		verticalPanel38.add(new HTML("<br />"));
		horizontalPanel16.add(ar_comLabel);
		ar_comLabel.setStyleName("gi_titleText2");
		horizontalPanel16.add(ar_comArea);
		ar_comArea.setStyleName("sa_textArea");
		verticalPanel38.add(horizontalPanel16);


		// Assemble Types of Flight Manoeuvre panel
		verticalPanel39.add(fm_levelRuns);
		verticalPanel39.add(fm_stacked);
		fm_stacked.setStyleName("sa_checkBox");
		verticalPanel39.add(fm_separated);
		fm_separated.setStyleName("sa_checkBox");
		verticalPanel39.add(fm_racetracks);
		verticalPanel39.add(fm_orbits);
		verticalPanel39.setSpacing(10);
		horizontalPanel17.add(verticalPanel39);
		verticalPanel40.add(fm_lagrangianDescents);
		fm_lagrangianDescents.getElement().setAttribute("style", "margin-left:100px !important;");
		verticalPanel40.add(fm_ascDescents);
		fm_ascDescents.getElement().setAttribute("style", "margin-left:100px !important;");
		verticalPanel40.add(fm_dropsondeDeployed);
		fm_dropsondeDeployed.getElement().setAttribute("style", "margin-left:100px !important;");
		verticalPanel40.add(fm_selfCalibration);
		fm_selfCalibration.getElement().setAttribute("style", "margin-left:100px !important;");
		verticalPanel40.setSpacing(10);
		horizontalPanel17.add(verticalPanel40);
		verticalPanel41.add(horizontalPanel17);
		verticalPanel74.add(addCatButton(fm_addCatTable, fm_addCatMap, verticalPanel74));
		verticalPanel41.add(verticalPanel74);
		verticalPanel41.add(new HTML("<br />"));
		horizontalPanel18.add(fm_comLabel);
		fm_comLabel.setStyleName("gi_titleText2");
		horizontalPanel18.add(fm_comArea);
		fm_comArea.setStyleName("sa_textArea");
		verticalPanel41.add(horizontalPanel18);


		// Assemble Satellite Coordination panel
		verticalPanel42.add(sc_polarLabel);
		sc_polarLabel.setStyleName("gi_titleText2");
		verticalPanel42.add(sc_metop);
		sc_metop.setStyleName("sa_checkBox");
		verticalPanel42.add(sc_npoess);
		sc_npoess.setStyleName("sa_checkBox");
		verticalPanel42.add(sc_atrain);
		sc_atrain.setStyleName("sa_checkBox");
		verticalPanel42.add(sc_other);
		sc_other.setStyleName("sa_checkBox");
		verticalPanel42.setSpacing(10);
		verticalPanel42.setStyleName("sa_verticalPanel");
		verticalPanel42.getElement().setAttribute("style", "width: 200px !important;");
		horizontalPanel19.add(verticalPanel42);
		verticalPanel43.add(sc_geosynchLabel);
		sc_geosynchLabel.setStyleName("gi_titleText2");
		verticalPanel43.add(sc_msg);
		sc_msg.setStyleName("sa_checkBox");
		verticalPanel43.add(sc_other2);
		sc_other2.setStyleName("sa_checkBox");
		verticalPanel43.setSpacing(10);
		verticalPanel43.setStyleName("sa_verticalPanel");
		verticalPanel43.getElement().setAttribute("style", "width: 220px !important;");
		verticalPanel45.add(verticalPanel43);
		verticalPanel44.add(sc_modis);
		verticalPanel44.add(sc_cloudsat);
		verticalPanel44.setSpacing(10);
		verticalPanel44.getElement().setAttribute("style", "margin-left:10px !important;");
		verticalPanel45.add(verticalPanel44);
		verticalPanel45.getElement().setAttribute("style", "margin-left:10px !important;");
		horizontalPanel19.add(verticalPanel45);
		verticalPanel46.add(sc_caliop);
		verticalPanel46.add(sc_iasi);
		verticalPanel46.add(sc_airs);
		verticalPanel46.add(sc_cris);
		verticalPanel46.add(sc_amsuMhs);
		verticalPanel46.setSpacing(10);
		verticalPanel46.getElement().setAttribute("style", "margin-left:20px !important; margin-top: 20px !important;");
		horizontalPanel19.add(verticalPanel46);
		verticalPanel47.add(horizontalPanel19);
		verticalPanel47.add(new HTML("<br />"));
		verticalPanel75.add(addCatButton(sc_addCatTable, sc_addCatMap, verticalPanel75));
		verticalPanel47.add(verticalPanel75);
		verticalPanel47.add(new HTML("<br />"));
		horizontalPanel20.add(sc_comLabel);
		sc_comLabel.setStyleName("gi_titleText2");
		horizontalPanel20.add(sc_comArea);
		sc_comArea.setStyleName("sa_textArea");
		verticalPanel47.add(horizontalPanel20);


		// Assemble Supporting Surface-based Observations panel
		horizontalPanel21.add(so_groundSitesLabel);
		horizontalPanel21.add(so_groundSitesBox);
		so_groundSitesBox.setStyleName("so_textBox");
		horizontalPanel21.add(addListButton(so_groundSitesTable, so_groundSitesBox, so_groundSitesList));
		verticalPanel48.add(horizontalPanel21);
		verticalPanel49.add(so_groundSitesTable);
		verticalPanel49.setStyleName("so_verticalPanel");
		verticalPanel48.add(verticalPanel49);
		so_groundSitesTable.getColumnFormatter().setWidth(1, "40px");
		so_groundSitesTable.setStyleName("flexTable");
		verticalPanel48.getElement().setAttribute("style", "margin-top:10px !important;");
		verticalPanel50.add(verticalPanel48);
		horizontalPanel22.add(so_researchVesselsLabel);
		horizontalPanel22.add(so_researchVesselsBox);
		so_researchVesselsBox.setStyleName("so_textBox");
		horizontalPanel22.add(addListButton(so_researchVesselsTable, so_researchVesselsBox, so_researchVesselsList));
		verticalPanel51.add(horizontalPanel22);
		verticalPanel52.add(so_researchVesselsTable);
		verticalPanel52.setStyleName("so_verticalPanel");
		verticalPanel51.add(verticalPanel52);
		so_researchVesselsTable.getColumnFormatter().setWidth(1, "40px");
		so_researchVesselsTable.setStyleName("flexTable");
		verticalPanel50.add(verticalPanel51);
		verticalPanel51.getElement().setAttribute("style", "margin-top:30px !important;");
		verticalPanel50.getElement().setAttribute("style", "margin-left:80px !important;");
		horizontalPanel23.add(so_armSitesLabel);
		horizontalPanel23.add(so_armSitesBox);
		so_armSitesBox.setStyleName("so_textBox");
		horizontalPanel23.add(addListButton(so_armSitesTable, so_armSitesBox, so_armSitesList));
		verticalPanel53.add(horizontalPanel23);
		verticalPanel54.add(so_armSitesTable);
		verticalPanel54.setStyleName("so_verticalPanel");
		verticalPanel53.add(verticalPanel54);
		so_armSitesTable.getColumnFormatter().setWidth(1, "40px");
		so_armSitesTable.setStyleName("flexTable");
		verticalPanel55.add(verticalPanel53);
		verticalPanel53.getElement().setAttribute("style", "margin-top:10px !important;");
		horizontalPanel24.add(so_mobileSitesLabel);
		horizontalPanel24.add(so_mobileSitesBox);
		so_mobileSitesBox.setStyleName("so_textBox");
		horizontalPanel24.add(addListButton(so_mobileSitesTable, so_mobileSitesBox, so_mobileSitesList));
		verticalPanel56.add(horizontalPanel24);
		verticalPanel57.add(so_mobileSitesTable);
		verticalPanel57.setStyleName("so_verticalPanel");
		verticalPanel56.add(verticalPanel57);
		so_mobileSitesTable.getColumnFormatter().setWidth(1, "40px");
		so_mobileSitesTable.setStyleName("flexTable");
		verticalPanel55.add(verticalPanel56);
		verticalPanel55.getElement().setAttribute("style", "margin-left:160px !important;");
		verticalPanel56.getElement().setAttribute("style", "margin-top:30px !important;");
		horizontalPanel25.add(verticalPanel50);
		horizontalPanel25.add(verticalPanel55);
		verticalPanel61.add(horizontalPanel25);
		


		// Assemble Additional Notes on the Flight panel
		verticalPanel66.add(nf_comArea);
		nf_comArea.setStyleName("sa_textArea");
		nf_comArea.getElement().setAttribute("style", "margin-top: 20px; width: 1016px;");
		
		
		// Assemble Image Uploading
		verticalPanel76.add(informationLab);
		horizontalPanel28.add(addButton);
		horizontalPanel28.add(urlButton);
		horizontalPanel29.add(imageLab);
		horizontalPanel29.add(captionLab);
		verticalPanel76.add(horizontalPanel28);
		verticalPanel76.add(horizontalPanel29);
		verticalPanel76.add(imageTab);
		addButton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					uploadImage();
				}
			});
		urlButton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					uploadImageURL();
				}
			});
		addButton.getElement().setAttribute("style", "width: 160px !important; height: 18px !important; margin-left: 20px !important; "
				+ "font-family: DroidSansFallback !important; font-size: 12px; text-align: center !important; padding-top: 5px; font-weight: "
				+ "bold !important;");
		urlButton.getElement().setAttribute("style", "width: 180px !important; height: 18px !important; margin-left: 40px !important; "
				+ "font-family: DroidSansFallback !important; font-size: 12px; text-align: center !important; padding-top: 5px; font-weight: "
				+ "bold !important;");
		informationLab.getElement().setAttribute("style","margin-top: 10px !important; margin-bottom: 10px !important; margin-right: 20px "
				+ "!important;");
		imageLab.getElement().setAttribute("style", "text-decoration: underline !important; font-weight: bold !important; margin-left: "
				+ "100px !important; margin-top: 10px !important;");
		captionLab.getElement().setAttribute("style", "text-decoration: underline !important; font-weight: bold !important; margin-left: "
				+ "170px !important; margin-top: 10px !important;");
		imageTab.getElement().setAttribute("style", "margin-top: 10px !important; margin-left: 20px! important");
		int screenHeight = getScreenHeight();
		int screenWidth = getScreenWidth();
		float ratio = (float) screenWidth / screenHeight;
		if (screenHeight < 1050 & ratio > 1.5 & ratio < 1.8) {changeLayout();} 
		else {
		
			// add to StackPanel
			stackPanel.add(fiScroll,"Flight Information", 25);
			stackPanel.add(ciScroll,"Contact Information", 25);
			stackPanel.add(saScroll,"Scientific Aims", 25);
			stackPanel.add(giScroll,"Geographic Information", 25);
			stackPanel.add(afScroll,"Atmospheric Synoptic Features", 25);
			stackPanel.add(ctScroll,"Cloud Types and Forms Sampled During Flight", 25);
			stackPanel.add(cpScroll,"Cloud, Precipitation and Aerosol Particles Sampled", 25);
			stackPanel.add(loScroll,"Land or Oceans Surfaces Overflown", 25);
			stackPanel.add(arScroll,"Altitude Range of Measurement", 25);
			stackPanel.add(fmScroll,"Types of Flight Manoeuvre", 25);
			stackPanel.add(scScroll,"Satellite Coordination", 25);
			stackPanel.add(soScroll,"Supporting Surface-based Observations", 25);
			stackPanel.add(nfScroll,"Additional Notes on the Flight", 25);
			stackPanel.add(ipScroll,"Images included in the PDF report", 25);
			
			
			// Associate the Main panel with the HTML host page.
			int screen_width = Window.getClientWidth();
			int screen_height = Window.getClientHeight();
			int expandPanel = 0;
			expandPanel = (screen_width - 1166)/2;
			if (expandPanel < 0) {expandPanel = 0;}
			subDockPanel.addNorth(new HTML("<img src='icons/asmm_top.jpg' alt='ASMM Creator' height='80px' width='1166px'>"), 80);
			subDockPanel.addNorth(mainMenu, 30);
			dockPanel.addEast(new HTML("<img src='icons/asmm_shadowr.png' alt='ASMM Creator' width='30px' height='" + screen_height + "' align='left'"
					+ ">Development version of ASMM Creator, online version " + asmmVersion), expandPanel);
			dockPanel.addWest(new HTML("<img src='icons/asmm_shadowl.png' alt='ASMM Creator' width='30px' height='" + screen_height + "' align='right"
					+ "'>Development version of ASMM Creator, online version " + asmmVersion), expandPanel);
			dockPanel.setStyleName("dockPanel");
			subDockPanel.add(stackPanel);
			dockPanel.add(subDockPanel);
			RootLayoutPanel rp=RootLayoutPanel.get();
			rp.add(dockPanel);
		}

		
		// Associate textboxes with an eventHandler
		List<TextBoxBase> allTextBox = $("*", subDockPanel).widgets(TextBoxBase.class);
		for (int i = 0; i < allTextBox.size(); i++) {
			allTextBox.get(i).addChangeHandler(new ChangeHandler() {
				@Override
				public void onChange(ChangeEvent event) {docIsModified();}
			});
		}


		// Associate checkboxes with an eventHandler
		List<CheckBox> allCheckBoxes = $("*", subDockPanel).widgets(CheckBox.class);
		for (int i = 0; i < allCheckBoxes.size(); i++) {
			allCheckBoxes.get(i).addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {docIsModified();}
			});
		}


		// Associate listboxes with an evenHandler
		List<ListBox> allListBoxes = $("*", subDockPanel).widgets(ListBox.class);
		for (int i = 0; i < allListBoxes.size(); i++) {
			allListBoxes.get(i).addChangeHandler(new ChangeHandler() {
				@Override
				public void onChange(ChangeEvent event) {docIsModified();}
			});
		}


		// Associate dateboxes with an eventHandler
		List<DateBox> allDateBoxes = $("*", subDockPanel).widgets(DateBox.class);
		for (int i = 0; i < allDateBoxes.size(); i++) {
			allDateBoxes.get(i).addValueChangeHandler(new ValueChangeHandler<Date>() {
				@Override
				public void onValueChange(ValueChangeEvent<Date> event) {docIsModified();}
			});
		}
		
		
		 //rootLogger.addHandler(new SimpleRemoteLogHandler());
		
	}


	// create a new file by cleaning all widgets
	private void newFile() {
		if (isModified) {
			final DialogBox infoDialog = new DialogBox();
			final VerticalPanel verticalPanel01 = new VerticalPanel();
			final VerticalPanel verticalPanel02 = new VerticalPanel();
			final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
			final HorizontalPanel horizontalPanel02 = new HorizontalPanel();
			final Image image = new Image("icons/warning_icon_popup.png");
			final Label label = new Label("The actual document has been modified. Changes will be lost if the document is not saved.");
			final Label label2 = new Label("Do you want to save your changes ?");
			final Button saveButton = new Button("Save", new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					infoDialog.hide();
					saveFile("open");
				}
			});
			final Button cancelButton = new Button("Cancel", new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {infoDialog.hide();}
			});
			final Button createButton = new Button("Clear without saving", new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					infoDialog.hide();
					clearFields();
				}
			});
			infoDialog.setGlassEnabled(true);
			verticalPanel01.getElement().setAttribute("style", "margin-left: 10px !important; margin-top: 10px !important; margin-right: 10px !important;");
			horizontalPanel01.add(image);
			verticalPanel02.add(label);
			verticalPanel02.add(label2);
			horizontalPanel01.add(verticalPanel02);
			verticalPanel01.add(horizontalPanel01);
			horizontalPanel02.add(saveButton);
			horizontalPanel02.add(cancelButton);
			horizontalPanel02.add(createButton);
			verticalPanel01.add(horizontalPanel02);
			label2.getElement().setAttribute("style", "margin-top: 20px !important; margin-bottom: 20px !important; text-decoration: "
					+ "underline !important; font-weight: bold !important;");
			saveButton.getElement().setAttribute("style", "margin-left: 20px !important; font-family: DroidSansFallback !important; font-weight: "
					+ "bold !important; margin-top: 10px !important;");
			cancelButton.getElement().setAttribute("style", "margin-left: 40px !important; font-family: DroidSansFallback !important;"
					+ " font-weight: bold !important; margin-top: 10px !important;");
			createButton.getElement().setAttribute("style", "margin-left: 20px !important; font-family: DroidSansFallback !important;"
					+ " font-weight: bold !important; margin-top: 10px !important; height: 30px !important; width: 180px !important");
			infoDialog.add(verticalPanel01);
			infoDialog.setSize( "130px", "180px" );
			infoDialog.setModal(true);
			infoDialog.center();
			infoDialog.setStyleName("myUploadBox");
			infoDialog.show();
		} else {clearFields();}
	}
	

	// clear all fields
	private void clearFields() {
		List<TextBox> allTextBox = $("*", subDockPanel).widgets(TextBox.class);
		List<TextArea> allTextArea = $("*", subDockPanel).widgets(TextArea.class);
		List<CheckBox> allCheckBox = $("*", subDockPanel).widgets(CheckBox.class);
		for (int i = 0; i < allTextBox.size(); i++) {allTextBox.get(i).setText("");}
		for (int i = 0; i < allTextArea.size(); i++) {allTextArea.get(i).setText("");}
		for (int i = 0; i < allCheckBox.size(); i = i + 1) {allCheckBox.get(i).setValue(false);}
		fi_dateText.setValue(new Date());
		ci_roleText.setSelectedIndex(0);
		so_groundSitesList.clear();
		so_groundSitesTable.removeAllRows();
		so_researchVesselsList.clear();
		so_researchVesselsTable.removeAllRows();
		so_armSitesList.clear();
		so_armSitesTable.removeAllRows();
		so_mobileSitesList.clear();
		so_mobileSitesTable.removeAllRows();
		sa_addCatMap.clear();
		sa_addCatTable.removeAllRows();
		int numWidget = verticalPanel67.getWidgetCount();
		if (numWidget > 1) {
			verticalPanel67.remove(1);
			verticalPanel67.remove(1);
		}
		gi_addCatMap.clear();
		gi_addCatTable.removeAllRows();
		numWidget = verticalPanel68.getWidgetCount();
		if (numWidget > 1) {
			verticalPanel68.remove(1);
			verticalPanel68.remove(1);
		}
		af_addCatMap.clear();
		af_addCatTable.removeAllRows();
		numWidget = verticalPanel69.getWidgetCount();
		if (numWidget > 1) {
			verticalPanel69.remove(1);
			verticalPanel69.remove(1);
		}
		ct_addCatMap.clear();
		ct_addCatTable.removeAllRows();
		numWidget = verticalPanel70.getWidgetCount();
		if (numWidget > 1) {
			verticalPanel70.remove(1);
			verticalPanel70.remove(1);
		}
		cp_addCatMap.clear();
		cp_addCatTable.removeAllRows();
		numWidget = verticalPanel71.getWidgetCount();
		if (numWidget > 1) {
			verticalPanel71.remove(1);
			verticalPanel71.remove(1);
		}
		lo_addCatMap.clear();
		lo_addCatTable.removeAllRows();
		numWidget = verticalPanel72.getWidgetCount();
		if (numWidget > 1) {
			verticalPanel72.remove(1);
			verticalPanel72.remove(1);
		}
		ar_addCatMap.clear();
		ar_addCatTable.removeAllRows();
		numWidget = verticalPanel73.getWidgetCount();
		if (numWidget > 1) {
			verticalPanel73.remove(1);
			verticalPanel73.remove(1);
		}
		fm_addCatMap.clear();
		fm_addCatTable.removeAllRows();
		numWidget = verticalPanel74.getWidgetCount();
		if (numWidget > 1) {
			verticalPanel74.remove(1);
			verticalPanel74.remove(1);
		}
		sc_addCatMap.clear();
		sc_addCatTable.removeAllRows();
		numWidget = verticalPanel75.getWidgetCount();
		if (numWidget > 1) {
			verticalPanel75.remove(1);
			verticalPanel75.remove(1);
		}
		fi_operatorText.setSelectedIndex(0);
		fi_aircraftText.clear();
		fi_aircraftText.setEnabled(false);
		if (horizontalPanel26.getWidgetCount() > 1) {
			horizontalPanel26.remove(1);
			horizontalPanel27.remove(1);
			fiGrid.remove(fi_otherOpsText);
			fiGrid.remove(fi_otherAiText);
		}
		imageTab.removeAllRows();
		imageCaption.clear();
		imagePath.clear();
		docNotModified();
	}


	// open an existing xml file - 1
	private void openFile() {
		if (isModified) {
			final DialogBox infoDialog = new DialogBox();
			final VerticalPanel verticalPanel01 = new VerticalPanel();
			final VerticalPanel verticalPanel02 = new VerticalPanel();
			final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
			final HorizontalPanel horizontalPanel02 = new HorizontalPanel();
			final Image image = new Image("icons/warning_icon_popup.png");
			final Label label = new Label("The actual document has been modified. Changes will be lost if the document is not saved.");
			final Label label2 = new Label("Do you want to save your changes ?");
			final Button saveButton = new Button("Save", new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					infoDialog.hide();
					saveFile("open");
				}
			});
			final Button cancelButton = new Button("Cancel", new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {infoDialog.hide();}
			});
			final Button createButton = new Button("Open without saving", new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					infoDialog.hide();
					openAction();
				}
			});
			infoDialog.setGlassEnabled(true);
			verticalPanel01.getElement().setAttribute("style", "margin-left: 10px !important; margin-top: 10px !important; margin-right: 10px !important;");
			horizontalPanel01.add(image);
			verticalPanel02.add(label);
			verticalPanel02.add(label2);
			horizontalPanel01.add(verticalPanel02);
			verticalPanel01.add(horizontalPanel01);
			horizontalPanel02.add(createButton);
			horizontalPanel02.add(cancelButton);
			horizontalPanel02.add(saveButton);
			verticalPanel01.add(horizontalPanel02);
			label2.getElement().setAttribute("style", "margin-top: 20px !important; margin-bottom: 20px !important; text-decoration: "
					+ "underline !important; font-weight: bold !important;");
			saveButton.getElement().setAttribute("style", "margin-left: 20px !important; font-family: DroidSansFallback !important; font-weight: "
					+ "bold !important; margin-top: 10px !important;");
			cancelButton.getElement().setAttribute("style", "margin-left: 40px !important; font-family: DroidSansFallback !important;"
					+ " font-weight: bold !important; margin-top: 10px !important;");
			createButton.getElement().setAttribute("style", "margin-left: 20px !important; font-family: DroidSansFallback !important;"
					+ " font-weight: bold !important; margin-top: 10px !important; height: 30px !important; width: 180px !important");
			infoDialog.add(verticalPanel01);
			infoDialog.setSize( "130px", "180px" );
			infoDialog.setModal(true);
			infoDialog.center();
			infoDialog.setStyleName("myUploadBox");
			infoDialog.show();
		} else {openAction();}
	}
	

	// open an existing xml file - 1
	private void openAction() {
		final DialogBox myOpenDialog = new DialogBox();
		final FileUpload myFileUpload = new FileUpload();
		final FormPanel myUploadForm = new FormPanel();
		final VerticalPanel verticalPanel01 = new VerticalPanel();
		final VerticalPanel verticalPanel02 = new VerticalPanel();
		final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
		final HorizontalPanel horizontalPanel02 = new HorizontalPanel();
		final Image image = new Image("icons/open_icon_popup.png");
		final Label label = new Label("Please, select the file you want to open.");
		final Button submitButton = new Button("Open", new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {myUploadForm.submit();}
		});
		final Button cancelButton = new Button("Cancel/Close", new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {myOpenDialog.hide();}
		});
		myOpenDialog.setGlassEnabled(true);
		myOpenDialog.add(verticalPanel02);
		verticalPanel02.add(horizontalPanel01);
		verticalPanel02.getElement().setAttribute("style", "margin-left: 5px !important; margin-top: 10px !important; margin-right: 10px "
				+ "!important;");
		horizontalPanel01.add(image);
		horizontalPanel01.add(verticalPanel01);
		verticalPanel01.getElement().setAttribute("style", "margin-right:20px !important;");
		label.getElement().setAttribute("style", "margin-right:20px !important; margin-bottom:30px !important; margin-top:10px !important;");
		verticalPanel01.add(label);
		myFileUpload.setName("uploadFormElement");
		myFileUpload.getElement().setId("uploadFormElement");
		myFileUpload.getElement().setId("myFile");
		myFileUpload.getElement().setAttribute("style", "margin-left:20px !important;");
		verticalPanel01.add(myFileUpload);
		myUploadForm.setAction(asmmPath + "/upload");
		myUploadForm.setEncoding(FormPanel.ENCODING_MULTIPART);
		myUploadForm.setMethod(FormPanel.METHOD_POST);
		myUploadForm.addSubmitHandler(new FormPanel.SubmitHandler() {
			@Override
			public void onSubmit(SubmitEvent event) {
				if (myFileUpload.getFilename().length() == 0) {
					Window.alert("Please, select a file.");
					event.cancel();
				}		 
				else {
					clearFields();
					myFileName = myFileUpload.getFilename();
				}        
			}
		});
		myUploadForm.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
			@Override
			public void onSubmitComplete(SubmitCompleteEvent event) {
				myOpenDialog.hide();
				String ret = event.getResults();
				ret = ret.replaceAll("\t", "").replace("\n", "");
				readXml(ret);
			}			
		});		
		myUploadForm.add(verticalPanel02);
		horizontalPanel02.add(submitButton);
		horizontalPanel02.add(cancelButton);
		submitButton.getElement().setAttribute("style", "margin-left:20px !important; font-family: DroidSansFallback !important; font-weight: "
				+ "bold !important;");
		cancelButton.getElement().setAttribute("style", "margin-left:75px !important; font-family: DroidSansFallback !important; font-weight: "
				+ "bold !important;");
		horizontalPanel02.getElement().setAttribute("style", "margin-top:30px !important; margin-bottom:20px !important;");
		verticalPanel01.add(horizontalPanel02);
		myOpenDialog.add(myUploadForm);
		myOpenDialog.setSize( "130px", "180px" );
		myOpenDialog.setModal(true);
		myOpenDialog.center();
		myOpenDialog.setStyleName("myUploadBox");
	}


	// read the xml code in the opened xml file
	private void readXml(String stringXml) {
		try {
			Document doc = XMLParser.parse(stringXml);
			creationDate = doc.getElementsByTagName("creationdate").item(0).getFirstChild().getNodeValue();


			//////////////////////////
			/// Flight information ///
			//////////////////////////
			try {fi_flightText.setText(doc.getElementsByTagName("flightnumber").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			fi_dateText.setValue(DateTimeFormat.getFormat("yyyy-MM-dd").parse(doc.getElementsByTagName("date").item(0).getFirstChild().
					getNodeValue()));
			try {fi_campaignText.setText(doc.getElementsByTagName("projectacronym").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			try {fi_scientistText.setText(doc.getElementsByTagName("missionscientist").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			try {fi_managerText.setText(doc.getElementsByTagName("flightmanager").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			int l = 0;
			int k = 0;
			String operator = "";
			String aircraft = "";
			try {
				operator = doc.getElementsByTagName("operator").item(0).getFirstChild().getNodeValue();
				for (int i = 0; i < operatorsAircraft.length; i++) {
					if (operator == operatorsAircraft[i][2]) {
						l = 1;
						for (int j = 0; j < operatorList.size(); j++) {
							if (operatorsAircraft[i][0] == operatorList.get(j)) {
								fi_operatorText.setSelectedIndex(j);
								aircraftSelection(operatorsAircraft[j][0]);
								break;
							}
						}
					}
				}
				if (l == 0) {
					fi_operatorText.setSelectedIndex(14);
					aircraftSelection(fi_operatorText.getSelectedItemText());
					fi_otherOpsText.setText(operator);
				}
			}
			catch (Exception ex) {}
			try {
				aircraft = doc.getElementsByTagName("platform").item(0).getFirstChild().getNodeValue();
				for (int i = 0; i < operatorsAircraft.length; i++) {
					if (aircraft == operatorsAircraft[i][3]) {
						k = 1;
						if (fi_aircraftText.getSelectedItemText() == operatorsAircraft[i][1]) {
							break;
						} else if (fi_aircraftText.getSelectedItemText() == "Do your choice...") {
							for (int j = 0; j < fi_aircraftText.getItemCount(); j++) {
								if (operatorsAircraft[i][1] == fi_aircraftText.getItemText(j)) {
									fi_aircraftText.setSelectedIndex(j);
									break;
								}
							}
						}
					}
				}
				if (l == 0) {
					fi_otherAiText.setText(aircraft);
				} else if (l == 1 & k == 0) {
					String tmp = fi_operatorText.getSelectedItemText();
					fi_operatorText.setSelectedIndex(14);
					aircraftSelection(fi_operatorText.getSelectedItemText());
					fi_otherOpsText.setText(tmp);
					fi_otherAiText.setText(aircraft);
				}
			}
			catch (Exception ex) {}
			int indexToFind = -1;
			try {
				String description = doc.getElementsByTagName("localisation").item(0).getFirstChild().getNodeValue();
				for (int i = 0; i < continentList.size(); i++) {
					if (description == continentList.get(i)) {
						geoLocationSet(1);
						geoDetailLst.setSelectedIndex(i);
						geoLocationLst.setSelectedIndex(1);
						break;
					}
				}
				for (int i = 0; i < countryList.size(); i++) {
					if (description == countryList.get(i)) {
						geoLocationSet(2);
						geoDetailLst.setSelectedIndex(i);
						geoLocationLst.setSelectedIndex(2);
						break;
					}
				}
				for (int i = 0; i < oceanList.size(); i++) {
					if (description == oceanList.get(i)) {
						geoLocationSet(3);
						geoDetailLst.setSelectedIndex(i);
						geoLocationLst.setSelectedIndex(3);
						break;
					}
				}
				for (int i = 0; i < regionList.size(); i++) {
					if (description == regionList.get(i)) {
						geoLocationSet(4);
						geoDetailLst.setSelectedIndex(i);
						geoLocationLst.setSelectedIndex(4);
						break;
					}
				}			
			}
			catch (Exception ex) {}


			///////////////////////////
			/// Contact information ///
			///////////////////////////
			try {ci_nameText.setText(doc.getElementsByTagName("contactname").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			indexToFind = -1;
			for (int i=0; i<ci_roleText.getItemCount(); i++) {
				if (ci_roleText.getItemText(i).equals(doc.getElementsByTagName("contactrole").item(0).getFirstChild().getNodeValue())) {
					indexToFind = i;
					break;
				}
			}
			try {ci_roleText.setSelectedIndex(indexToFind);}
			catch (Exception ex) {}
			try {ci_emailText.setText(doc.getElementsByTagName("contactemail").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}

			
			///////////////////////
			/// Scientific aims ///
			///////////////////////
			NodeList scientificAims = doc.getElementsByTagName("sa_code");
			for (int i=0; i< scientificAims.getLength(); i++) {
				checkBox(saScroll, scientificMap, scientificAims.item(i).getFirstChild().getNodeValue());
			}
			try {sa_comArea.setText(doc.getElementsByTagName("sa_other").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			NodeList saUser = doc.getElementsByTagName("sa_user");
			for (int i = 0; i < saUser.getLength(); i++) {
				String userDefined = saUser.item(i).getFirstChild().getNodeValue();
				addCat(sa_addCatTable, sa_addCatMap, verticalPanel67, userDefined);
			}


			//////////////////////////////
			/// Geographic Information ///
			//////////////////////////////
			try {gi_northText.setText(doc.getElementsByTagName("northboundlatitude").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			try {gi_southText.setText(doc.getElementsByTagName("southboundlatitude").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			try {gi_westText.setText(doc.getElementsByTagName("westboundlongitude").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			try {gi_eastText.setText(doc.getElementsByTagName("eastboundlongitude").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			try {gi_minText.setText(doc.getElementsByTagName("minaltitude").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			try {gi_maxText.setText(doc.getElementsByTagName("maxaltitude").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			NodeList geographicInformation = doc.getElementsByTagName("gr_code");
			for (int i=0; i< geographicInformation.getLength(); i++) {
				checkBox(giScroll, geographicMap, geographicInformation.item(i).getFirstChild().getNodeValue());
			}
			try {gi_comArea.setText(doc.getElementsByTagName("gr_other").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			NodeList giUser = doc.getElementsByTagName("gr_user");
			for (int i = 0; i < giUser.getLength(); i++) {
				String userDefined = giUser.item(i).getFirstChild().getNodeValue();
				addCat(gi_addCatTable, gi_addCatMap, verticalPanel68, userDefined);
			}


			/////////////////////////////////////
			/// Atmospheric Synoptic Features ///
			/////////////////////////////////////
			NodeList atmosphericFeatures = doc.getElementsByTagName("af_code");
			for (int i=0; i< atmosphericFeatures.getLength(); i++) {
				checkBox(afScroll, synopticMap, atmosphericFeatures.item(i).getFirstChild().getNodeValue());
			}
			try {af_comArea.setText(doc.getElementsByTagName("af_other").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			NodeList afUser = doc.getElementsByTagName("af_user");
			for (int i = 0; i < afUser.getLength(); i++) {
				String userDefined = afUser.item(i).getFirstChild().getNodeValue();
				addCat(af_addCatTable, af_addCatMap, verticalPanel69, userDefined);
			}


			///////////////////////////////////////////////////
			/// Cloud Types and Forms Sampled During Flight ///
			///////////////////////////////////////////////////
			NodeList cloudTypes = doc.getElementsByTagName("ct_code");
			for (int i=0; i< cloudTypes.getLength(); i++) {checkBox(ctScroll, cloudMap, cloudTypes.item(i).getFirstChild().getNodeValue());}
			try {ct_comArea.setText(doc.getElementsByTagName("ct_other").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			NodeList ctUser = doc.getElementsByTagName("ct_user");
			for (int i = 0; i < ctUser.getLength(); i++) {
				String userDefined = ctUser.item(i).getFirstChild().getNodeValue();
				addCat(ct_addCatTable, ct_addCatMap, verticalPanel70, userDefined);
			}


			//////////////////////////////////////////////////////////
			/// Cloud, Precipitation and Aerosol Particles Sampled ///
			//////////////////////////////////////////////////////////
			NodeList cpapTypes = doc.getElementsByTagName("ps_code");
			for (int i=0; i< cpapTypes.getLength(); i++) {checkBox(cpScroll, cpapMap, cpapTypes.item(i).getFirstChild().getNodeValue());}
			try {cp_comArea.setText(doc.getElementsByTagName("ps_other").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			NodeList cpUser = doc.getElementsByTagName("ps_user");
			for (int i = 0; i < cpUser.getLength(); i++) {
				String userDefined = cpUser.item(i).getFirstChild().getNodeValue();
				addCat(cp_addCatTable, cp_addCatMap, verticalPanel71, userDefined);
			}


			/////////////////////////////////////////
			/// Land or Oceans Surfaces Overflown ///
			/////////////////////////////////////////
			NodeList surfacesOverflown = doc.getElementsByTagName("so_code");
			for (int i=0; i< surfacesOverflown.getLength(); i++) {
				checkBox(loScroll, surfacesMap, surfacesOverflown.item(i).getFirstChild().getNodeValue());
			}
			try {lo_comArea.setText(doc.getElementsByTagName("so_other").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			NodeList loUser = doc.getElementsByTagName("so_user");
			for (int i = 0; i < loUser.getLength(); i++) {
				String userDefined = loUser.item(i).getFirstChild().getNodeValue();
				addCat(lo_addCatTable, lo_addCatMap, verticalPanel72, userDefined);
			}


			/////////////////////////////////////
			/// Altitude Range of Measurement ///
			/////////////////////////////////////
			NodeList rangeMeasurement = doc.getElementsByTagName("ar_code");
			for (int i=0; i< rangeMeasurement.getLength(); i++) {
				checkBox(arScroll, measurementMap, rangeMeasurement.item(i).getFirstChild().getNodeValue());
			}
			try {ar_comArea.setText(doc.getElementsByTagName("ar_other").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			NodeList arUser = doc.getElementsByTagName("ar_user");
			for (int i = 0; i < arUser.getLength(); i++) {
				String userDefined = arUser.item(i).getFirstChild().getNodeValue();
				addCat(ar_addCatTable, ar_addCatMap, verticalPanel73, userDefined);
			}


			/////////////////////////////////
			/// Types of Flight Manoeuvre ///
			/////////////////////////////////
			NodeList flightManoeuvre = doc.getElementsByTagName("ft_code");
			for (int i=0; i< flightManoeuvre.getLength(); i++) {
				checkBox(fmScroll, manoeuvreMap, flightManoeuvre.item(i).getFirstChild().getNodeValue());
			}
			try {fm_comArea.setText(doc.getElementsByTagName("ft_other").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			NodeList fmUser = doc.getElementsByTagName("ft_user");
			for (int i = 0; i < fmUser.getLength(); i++) {
				String userDefined = fmUser.item(i).getFirstChild().getNodeValue();
				addCat(fm_addCatTable, fm_addCatMap, verticalPanel74, userDefined);
			}


			//////////////////////////////
			/// Satellite Coordination ///
			//////////////////////////////
			NodeList satelliteCoordination = doc.getElementsByTagName("sc_code");
			for (int i=0; i< satelliteCoordination.getLength(); i++) {
				checkBox(scScroll, satelliteMap, satelliteCoordination.item(i).getFirstChild().getNodeValue());
			}
			try {sc_comArea.setText(doc.getElementsByTagName("sc_other").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}
			NodeList scUser = doc.getElementsByTagName("sc_user");
			for (int i = 0; i < scUser.getLength(); i++) {
				String userDefined = scUser.item(i).getFirstChild().getNodeValue();
				addCat(sc_addCatTable, sc_addCatMap, verticalPanel75, userDefined);
			}


			/////////////////////////////////////////////
			/// Supporting Surface-based Observations ///
			/////////////////////////////////////////////
			NodeList groundSites = doc.getElementsByTagName("groundsite");
			for (int i=0; i< groundSites.getLength(); i++) {
				String string = groundSites.item(i).getFirstChild().getNodeValue();
				addList(so_groundSitesTable, string, so_groundSitesList);
			}
			NodeList researchVessels = doc.getElementsByTagName("researchvessel");
			for (int i=0; i< researchVessels.getLength(); i++) {
				String string = researchVessels.item(i).getFirstChild().getNodeValue();
				addList(so_researchVesselsTable, string, so_researchVesselsList);
			}
			NodeList armSites = doc.getElementsByTagName("armsite");
			for (int i=0; i< armSites.getLength(); i++) {
				String string = armSites.item(i).getFirstChild().getNodeValue();
				addList(so_armSitesTable, string, so_armSitesList);
			}
			NodeList mobileSites = doc.getElementsByTagName("armmobile");
			for (int i=0; i< mobileSites.getLength(); i++) {
				String string = mobileSites.item(i).getFirstChild().getNodeValue();
				addList(so_mobileSitesTable, string, so_mobileSitesList);
			}


			//////////////////////////////////////
			/// Additional Notes on the Flight ///
			//////////////////////////////////////
			try {nf_comArea.setText(doc.getElementsByTagName("othercomments").item(0).getFirstChild().getNodeValue());}
			catch (Exception ex) {}

		} catch (DOMException e) {Window.alert("Could not parse XML document.");}
	}


	// find the dedicated checkbox from the xml code
	private void checkBox(ScrollPanel scrollPanel, TreeMap<String, String> treeMap, String string) {
		List<CheckBox> allCheckBox = $("*", scrollPanel).widgets(CheckBox.class);
		String key = new String();
		for (Entry<String, String> entry : treeMap.entrySet()) {if (entry.getValue().equals(string)) {key = entry.getKey(); break;}}
		for (int i = 0; i < allCheckBox.size(); i = i + 2) {if (allCheckBox.get(i).getText() == key) {allCheckBox.get(i).setValue(true);}}
	}


	// save an xml file
	private void saveFile(final String string) {
		final DialogBox mySaveDialog = new DialogBox();
		final VerticalPanel verticalPanel01 = new VerticalPanel();	
		final VerticalPanel verticalPanel02 = new VerticalPanel();
		final VerticalPanel verticalPanel03 = new VerticalPanel();
		final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
		final HorizontalPanel horizontalPanel02 = new HorizontalPanel();
		final Image image = new Image("icons/save_icon_popup.png");
		final TextArea xmlTree = new TextArea();
		final Label label = new Label("Please, enter a name to save the XML file.");
		final TextBox fileName = new TextBox();
		final TextBox filebox = new TextBox();
		final FormPanel myForm = new FormPanel();
		final Button cancelButton = new Button("Cancel/Close", new ClickHandler () {
			@Override
			public void onClick(ClickEvent event) {
				mySaveDialog.hide();
				if (string == "open") {
					openAction();
				}
			}
		});
		final Button submitButton = new Button("Save", new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				myFileName = fileName.getText();
				if (!myFileName.toLowerCase().endsWith(".xml")) {myFileName = myFileName + ".xml";};
				filebox.setText(myFileName);
				myForm.submit();
				docNotModified();
				if (string == "clear") {clearFields();}
			}
		});
		fileName.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					myFileName = fileName.getText();
					if (!myFileName.toLowerCase().endsWith(".xml")) {myFileName = myFileName + ".xml";};
					filebox.setText(myFileName);
					myForm.submit();
					docNotModified();
					if (string == "clear") {clearFields();}
				}
			}
		});
		mySaveDialog.setGlassEnabled(true);
		verticalPanel03.add(horizontalPanel02);
		verticalPanel03.getElement().setAttribute("style", "margin-left: 5px !important; margin-top: 10px !important; margin-right: 10px "
				+ "!important;");
		horizontalPanel02.add(image);
		horizontalPanel02.add(verticalPanel02);
		xmlTree.setText(createXml());
		xmlTree.setName("xmltree");
		verticalPanel01.add(xmlTree);
		label.getElement().setAttribute("style", "margin-right:20px !important; margin-bottom:30px !important; margin-top:10px !important;");
		verticalPanel02.add(label);
		fileName.setText(myFileName);
		fileName.setStyleName("gi_textBox");
		fileName.getElement().setAttribute("style", "width:230px !important;");
		verticalPanel02.add(fileName);
		myFileName = fileName.getText();
		if (!myFileName.toLowerCase().endsWith(".xml")) {myFileName = myFileName + ".xml";};
		filebox.setName("filename");
		verticalPanel01.add(filebox);
		myForm.setAction(asmmPath + "/download");
		myForm.setMethod(FormPanel.METHOD_POST);
		myForm.add(verticalPanel01);
		myForm.setVisible(false);
		horizontalPanel01.add(submitButton);
		horizontalPanel01.add(cancelButton);
		submitButton.getElement().setAttribute("style", "margin-left:95px !important; font-family: DroidSansFallback !important; font-weight: "
				+ "bold !important;");
		cancelButton.getElement().setAttribute("style", "margin-left:70px !important; font-family: DroidSansFallback !important; font-weight: "
				+ "bold !important;");
		horizontalPanel01.getElement().setAttribute("style", "margin-top:30px !important; margin-bottom:20px !important;");
		verticalPanel02.add(myForm);	
		verticalPanel03.add(horizontalPanel01);
		mySaveDialog.add(verticalPanel03);	
		mySaveDialog.setSize( "370px", "180px" );
		mySaveDialog.setModal(true);
		mySaveDialog.center();
		mySaveDialog.setStyleName("myUploadBox");	
		fileName.setFocus(true);
	}


	// create a string composed of xml code
	private String createXml() {

		String xmlString = null;
		Document doc = XMLParser.createDocument();
		Element rootElement = doc.createElement("asmm:MissionMetadata");
		rootElement.setAttribute("xmlns:asmm","http://www.eufar.net/ASMM");
		Element xcreationDate = doc.createElement("asmm:CreationDate");
		xcreationDate.appendChild(doc.createTextNode(creationDate));
		rootElement.appendChild(xcreationDate);
		Element xrevisionDate = doc.createElement("asmm:RevisionDate");
		xrevisionDate.appendChild(doc.createTextNode(revisionDate));
		rootElement.appendChild(xrevisionDate);


		//////////////////////////
		/// Flight information ///
		//////////////////////////
		Element flightInformation = doc.createElement("asmm:FlightInformation");
		Element flightNumber = doc.createElement("asmm:FlightNumber");
		flightNumber.appendChild(doc.createTextNode(fi_flightText.getText()));
		flightInformation.appendChild(flightNumber);
		Element flightDate = doc.createElement("asmm:Date");
		String value = new String(DateTimeFormat.getFormat("yyyy-MM-dd").format(fi_dateText.getValue()));
		flightDate.appendChild(doc.createTextNode(value));
		flightInformation.appendChild(flightDate);
		Element flightCampaign = doc.createElement("asmm:ProjectAcronym");
		flightCampaign.appendChild(doc.createTextNode(fi_campaignText.getText()));
		flightInformation.appendChild(flightCampaign);
		Element missionScientist = doc.createElement("asmm:MissionScientist");
		missionScientist.appendChild(doc.createTextNode(fi_scientistText.getText()));
		flightInformation.appendChild(missionScientist);
		Element flightManager = doc.createElement("asmm:FlightManager");
		flightManager.appendChild(doc.createTextNode(fi_managerText.getText()));
		flightInformation.appendChild(flightManager);
		if (horizontalPanel26.getWidgetCount() > 1) {
			Element flightAircraft = doc.createElement("asmm:Platform");
			flightAircraft.appendChild(doc.createTextNode(fi_otherAiText.getText()));
			flightInformation.appendChild(flightAircraft);			
			Element flightOperator = doc.createElement("asmm:Operator");
			flightOperator.appendChild(doc.createTextNode(fi_otherOpsText.getText()));
			flightInformation.appendChild(flightOperator);
		} else {
			if (fi_operatorText.getSelectedItemText() == "Do your choice...") {
				Element flightAircraft = doc.createElement("asmm:Platform");
				flightAircraft.appendChild(doc.createTextNode(""));
				flightInformation.appendChild(flightAircraft);			
				Element flightOperator = doc.createElement("asmm:Operator");
				flightOperator.appendChild(doc.createTextNode(""));
				flightInformation.appendChild(flightOperator);
			} else {
				int k = 0;
				int j = 0;
				for (int i = 0; i < operatorsAircraft.length; i++) {
					if (fi_aircraftText.getSelectedItemText() == operatorsAircraft[i][1]) {
						k = 1;
						Element flightAircraft = doc.createElement("asmm:Platform");
						flightAircraft.appendChild(doc.createTextNode(operatorsAircraft[i][3]));
						flightInformation.appendChild(flightAircraft);
						break;
					}
				}
				for (int i = 0; i < operatorsAircraft.length; i++) {
					if (fi_operatorText.getSelectedItemText() == operatorsAircraft[i][0]) {
						j = 1;
						Element flightOperator = doc.createElement("asmm:Operator");
						flightOperator.appendChild(doc.createTextNode(operatorsAircraft[i][2]));
						flightInformation.appendChild(flightOperator);
						break;
					}
				}
				if (k == 0) {
					Element flightAircraft = doc.createElement("asmm:Platform");
					flightAircraft.appendChild(doc.createTextNode(""));
					flightInformation.appendChild(flightAircraft);
				}
				if (j == 0) {
					Element flightOperator = doc.createElement("asmm:Operator");
					flightOperator.appendChild(doc.createTextNode(""));
					flightInformation.appendChild(flightOperator);
				}
				
			}
			
		}
		Element flightCountry = doc.createElement("asmm:Localisation");
		if (geoDetailLst.getSelectedItemText() != null) {
			flightCountry.appendChild(doc.createTextNode(geoDetailLst.getSelectedItemText()));
		} else {
			flightCountry.appendChild(doc.createTextNode(""));
		}
		flightInformation.appendChild(flightCountry);
		rootElement.appendChild(flightInformation);


		///////////////////////////
		/// Contact information ///
		///////////////////////////
		Element contactInformation = doc.createElement("asmm:ContactInfo");
		Element contactName = doc.createElement("asmm:ContactName");
		contactName.appendChild(doc.createTextNode(ci_nameText.getText()));
		contactInformation.appendChild(contactName);
		Element contactRole = doc.createElement("asmm:ContactRole");
		if (ci_roleText.getSelectedItemText() == "Do your choice...") {
			contactRole.appendChild(doc.createTextNode(""));
		} else {
			contactRole.appendChild(doc.createTextNode(ci_roleText.getSelectedItemText()));
		}
		contactInformation.appendChild(contactRole);
		Element contactEmail = doc.createElement("asmm:ContactEmail");
		contactEmail.appendChild(doc.createTextNode(ci_emailText.getText()));
		contactInformation.appendChild(contactEmail);
		rootElement.appendChild(contactInformation);


		///////////////////////
		/// Scientific aims ///
		///////////////////////
		Element scientificAims = doc.createElement("asmm:ScientificAims");
		List<CheckBox> allCheckBox = $("*", saScroll).widgets(CheckBox.class);
		for (int i = 0; i < allCheckBox.size(); i = i + 2) {
			if (allCheckBox.get(i).getValue()) {
				String stringCode = scientificMap.get(allCheckBox.get(i).getText());
				if (stringCode == null) {
					stringCode = sa_addCatMap.get(allCheckBox.get(i).getText());
					Element saCode = doc.createElement("asmm:SA_User");
					saCode.appendChild(doc.createTextNode(stringCode));
					scientificAims.appendChild(saCode);
				}
				else {
					Element saCode = doc.createElement("asmm:SA_Code");
					saCode.appendChild(doc.createTextNode(stringCode));
					scientificAims.appendChild(saCode);
				}
			}
		}
		Element saComments = doc.createElement("asmm:SA_Other");
		saComments.appendChild(doc.createTextNode(sa_comArea.getText()));
		scientificAims.appendChild(saComments);
		rootElement.appendChild(scientificAims);


		////////////////////////////////
		/// Geographical Information ///
		////////////////////////////////
		Element geographicalInformation = doc.createElement("asmm:GeographicalRegion");
		Element boundingBox = doc.createElement("asmm:GeographicBoundingBox");
		Element westBound = doc.createElement("asmm:westBoundLongitude");
		westBound.appendChild(doc.createTextNode(gi_westText.getText()));
		boundingBox.appendChild(westBound);
		Element eastBound = doc.createElement("asmm:eastBoundLongitude");
		eastBound.appendChild(doc.createTextNode(gi_eastText.getText()));
		boundingBox.appendChild(eastBound);
		Element northBound = doc.createElement("asmm:northBoundLatitude");
		northBound.appendChild(doc.createTextNode(gi_northText.getText()));
		boundingBox.appendChild(northBound);
		Element southBound = doc.createElement("asmm:southBoundLatitude");
		southBound.appendChild(doc.createTextNode(gi_southText.getText()));
		boundingBox.appendChild(southBound);
		Element minBound = doc.createElement("asmm:minAltitude");
		minBound.appendChild(doc.createTextNode(gi_minText.getText()));
		boundingBox.appendChild(minBound);
		Element maxBound = doc.createElement("asmm:maxAltitude");
		maxBound.appendChild(doc.createTextNode(gi_maxText.getText()));
		boundingBox.appendChild(maxBound);
		geographicalInformation.appendChild(boundingBox);
		allCheckBox = $("*", giScroll).widgets(CheckBox.class);
		for (int i = 0; i < allCheckBox.size(); i = i + 2) {
			if (allCheckBox.get(i).getValue()) {
				String stringCode = geographicMap.get(allCheckBox.get(i).getText());
				if (stringCode == null) {
					stringCode = gi_addCatMap.get(allCheckBox.get(i).getText());
					Element code = doc.createElement("asmm:GR_User");
					code.appendChild(doc.createTextNode(stringCode));
					geographicalInformation.appendChild(code);
				}
				else {
					Element giCode = doc.createElement("asmm:GR_Code");
					giCode.appendChild(doc.createTextNode(stringCode));
					geographicalInformation.appendChild(giCode);
				}
			}
		}
		Element giComments = doc.createElement("asmm:GR_Other");
		giComments.appendChild(doc.createTextNode(gi_comArea.getText()));
		geographicalInformation.appendChild(giComments);
		rootElement.appendChild(geographicalInformation);


		/////////////////////////////////////
		/// Atmospheric Synoptic Features ///
		/////////////////////////////////////
		Element atmosphericFeatures = doc.createElement("asmm:AtmosFeatures");
		allCheckBox = $("*", afScroll).widgets(CheckBox.class);
		for (int i = 0; i < allCheckBox.size(); i = i + 2) {
			if (allCheckBox.get(i).getValue()) {
				String stringCode = synopticMap.get(allCheckBox.get(i).getText());
				if (stringCode == null) {
					stringCode = af_addCatMap.get(allCheckBox.get(i).getText());
					Element code = doc.createElement("asmm:AF_User");
					code.appendChild(doc.createTextNode(stringCode));
					atmosphericFeatures.appendChild(code);
				}
				else {
					Element afCode = doc.createElement("asmm:AF_Code");
					afCode.appendChild(doc.createTextNode(synopticMap.get(allCheckBox.get(i).getText())));
					atmosphericFeatures.appendChild(afCode);
				}
			}
		}
		Element afComments = doc.createElement("asmm:AF_Other");
		afComments.appendChild(doc.createTextNode(af_comArea.getText()));
		atmosphericFeatures.appendChild(afComments);
		rootElement.appendChild(atmosphericFeatures);


		///////////////////////////////////////////////////
		/// Cloud Types and Forms Sampled During Flight ///
		///////////////////////////////////////////////////
		Element cloudTypes = doc.createElement("asmm:CloudTypes");
		allCheckBox = $("*", ctScroll).widgets(CheckBox.class);
		for (int i = 0; i < allCheckBox.size(); i = i + 2) {
			if (allCheckBox.get(i).getValue()) {
				String stringCode = cloudMap.get(allCheckBox.get(i).getText());
				if (stringCode == null) {
					stringCode = ct_addCatMap.get(allCheckBox.get(i).getText());
					Element code = doc.createElement("asmm:CT_User");
					code.appendChild(doc.createTextNode(stringCode));
					cloudTypes.appendChild(code);
				}
				else {
					Element ctCode = doc.createElement("asmm:CT_Code");
					ctCode.appendChild(doc.createTextNode(cloudMap.get(allCheckBox.get(i).getText())));
					cloudTypes.appendChild(ctCode);
				}
			}
		}
		Element ctComments = doc.createElement("asmm:CT_Other");
		ctComments.appendChild(doc.createTextNode(ct_comArea.getText()));
		cloudTypes.appendChild(ctComments);
		rootElement.appendChild(cloudTypes);


		//////////////////////////////////////////////////////////
		/// Cloud, Precipitation and Aerosol Particles Sampled ///
		//////////////////////////////////////////////////////////
		Element cpapTypes = doc.createElement("asmm:ParticlesSampled");
		allCheckBox = $("*", cpScroll).widgets(CheckBox.class);
		for (int i = 0; i < allCheckBox.size(); i = i + 2) {
			if (allCheckBox.get(i).getValue()) {
				String stringCode = cpapMap.get(allCheckBox.get(i).getText());
				if (stringCode == null) {
					stringCode = cp_addCatMap.get(allCheckBox.get(i).getText());
					Element code = doc.createElement("asmm:PS_User");
					code.appendChild(doc.createTextNode(stringCode));
					cpapTypes.appendChild(code);
				}
				else {
					Element cpCode = doc.createElement("asmm:PS_Code");
					cpCode.appendChild(doc.createTextNode(cpapMap.get(allCheckBox.get(i).getText())));
					cpapTypes.appendChild(cpCode);
				}
			}
		}
		Element cpComments = doc.createElement("asmm:PS_Other");
		cpComments.appendChild(doc.createTextNode(cp_comArea.getText()));
		cpapTypes.appendChild(cpComments);
		rootElement.appendChild(cpapTypes);


		/////////////////////////////////////////
		/// Land or Oceans Surfaces Overflown ///
		/////////////////////////////////////////
		Element surfacesOverflown = doc.createElement("asmm:SurfacesOverflown");
		allCheckBox = $("*", loScroll).widgets(CheckBox.class);
		for (int i = 0; i < allCheckBox.size(); i = i + 2) {
			if (allCheckBox.get(i).getValue()) {
				String stringCode = surfacesMap.get(allCheckBox.get(i).getText());
				if (stringCode == null) {
					stringCode = lo_addCatMap.get(allCheckBox.get(i).getText());
					Element code = doc.createElement("asmm:SO_User");
					code.appendChild(doc.createTextNode(stringCode));
					surfacesOverflown.appendChild(code);
				}
				else {
					Element soCode = doc.createElement("asmm:SO_Code");
					soCode.appendChild(doc.createTextNode(surfacesMap.get(allCheckBox.get(i).getText())));
					surfacesOverflown.appendChild(soCode);
				}
			}
		}
		Element soComments = doc.createElement("asmm:SO_Other");
		soComments.appendChild(doc.createTextNode(lo_comArea.getText()));
		surfacesOverflown.appendChild(soComments);
		rootElement.appendChild(surfacesOverflown);


		/////////////////////////////////////
		/// Altitude Range of Measurement ///
		/////////////////////////////////////
		Element rangeMeasurement = doc.createElement("asmm:AltitudeRanges");
		allCheckBox = $("*", arScroll).widgets(CheckBox.class);
		for (int i = 0; i < allCheckBox.size(); i = i + 2) {
			if (allCheckBox.get(i).getValue()) {
				String stringCode = measurementMap.get(allCheckBox.get(i).getText());
				if (stringCode == null) {
					stringCode = ar_addCatMap.get(allCheckBox.get(i).getText());
					Element code = doc.createElement("asmm:AR_User");
					code.appendChild(doc.createTextNode(stringCode));
					rangeMeasurement.appendChild(code);
				}
				else {
					Element arCode = doc.createElement("asmm:AR_Code");
					arCode.appendChild(doc.createTextNode(measurementMap.get(allCheckBox.get(i).getText())));
					rangeMeasurement.appendChild(arCode);
				}
			}
		}
		Element arComments = doc.createElement("asmm:AR_Other");
		arComments.appendChild(doc.createTextNode(ar_comArea.getText()));
		rangeMeasurement.appendChild(arComments);
		rootElement.appendChild(rangeMeasurement);


		/////////////////////////////////
		/// Types of Flight Manoeuvre ///
		/////////////////////////////////
		Element flightManoeuvre = doc.createElement("asmm:FlightTypes");
		allCheckBox = $("*", fmScroll).widgets(CheckBox.class);
		for (int i = 0; i < allCheckBox.size(); i = i + 2) {
			if (allCheckBox.get(i).getValue()) {
				String stringCode = manoeuvreMap.get(allCheckBox.get(i).getText());
				if (stringCode == null) {
					stringCode = fm_addCatMap.get(allCheckBox.get(i).getText());
					Element code = doc.createElement("asmm:FT_User");
					code.appendChild(doc.createTextNode(stringCode));
					flightManoeuvre.appendChild(code);
				}
				else {
					Element fmCode = doc.createElement("asmm:FT_Code");
					fmCode.appendChild(doc.createTextNode(manoeuvreMap.get(allCheckBox.get(i).getText())));
					flightManoeuvre.appendChild(fmCode);
				}
			}
		}
		Element fmComments = doc.createElement("asmm:FT_Other");
		fmComments.appendChild(doc.createTextNode(fm_comArea.getText()));
		flightManoeuvre.appendChild(fmComments);
		rootElement.appendChild(flightManoeuvre);


		//////////////////////////////
		/// Satellite Coordination ///
		//////////////////////////////
		Element satelliteCoordination = doc.createElement("asmm:SatelliteCoordination");
		allCheckBox = $("*", scScroll).widgets(CheckBox.class);
		for (int i = 0; i < allCheckBox.size(); i = i + 2) {
			if (allCheckBox.get(i).getValue()) {
				String stringCode = satelliteMap.get(allCheckBox.get(i).getText());
				if (stringCode == null) {
					stringCode = sc_addCatMap.get(allCheckBox.get(i).getText());
					Element code = doc.createElement("asmm:SC_User");
					code.appendChild(doc.createTextNode(stringCode));
					satelliteCoordination.appendChild(code);
				}
				else {
					Element scCode = doc.createElement("asmm:SC_Code");
					scCode.appendChild(doc.createTextNode(satelliteMap.get(allCheckBox.get(i).getText())));
					satelliteCoordination.appendChild(scCode);
				}
			}
		}
		Element scComments = doc.createElement("asmm:SC_Other");
		scComments.appendChild(doc.createTextNode(sc_comArea.getText()));
		satelliteCoordination.appendChild(scComments);
		rootElement.appendChild(satelliteCoordination);


		/////////////////////////////////////////////
		/// Supporting Surface-based Observations ///
		/////////////////////////////////////////////
		Element surfaceObservations = doc.createElement("asmm:SurfaceObs");
		for (int i = 0; i < so_groundSitesList.size(); i++) {
			Element item1 = doc.createElement("asmm:GroundSite");
			item1.appendChild(doc.createTextNode(so_groundSitesList.get(i)));
			surfaceObservations.appendChild(item1);
		}
		for (int i = 0; i < so_researchVesselsList.size(); i++) {
			Element item2 = doc.createElement("asmm:ResearchVessel");
			item2.appendChild(doc.createTextNode(so_researchVesselsList.get(i)));
			surfaceObservations.appendChild(item2);
		}
		for (int i = 0; i < so_armSitesList.size(); i++) {
			Element item3 = doc.createElement("asmm:ArmSite");
			item3.appendChild(doc.createTextNode(so_armSitesList.get(i)));
			surfaceObservations.appendChild(item3);
		}
		for (int i = 0; i < so_mobileSitesList.size(); i++) {
			Element item4 = doc.createElement("asmm:ArmMobile");
			item4.appendChild(doc.createTextNode(so_mobileSitesList.get(i)));
			surfaceObservations.appendChild(item4);
		}
		rootElement.appendChild(surfaceObservations);


		//////////////////////////////////////
		/// Additional Notes on the Flight ///
		//////////////////////////////////////
		Element additionalNotes = doc.createElement("asmm:OtherComments");
		additionalNotes.appendChild(doc.createTextNode(nf_comArea.getText()));
		rootElement.appendChild(additionalNotes);


		doc.appendChild(rootElement);
		xmlString = "<?xml version='1.0' encoding='UTF-8'?>" + doc.toString();
		return xmlString;
	}


	// print a report based on user inputs
	private void printFile() {
		final DialogBox mySaveDialog = new DialogBox();
		final VerticalPanel verticalPanel01 = new VerticalPanel();	
		final VerticalPanel verticalPanel02 = new VerticalPanel();
		final VerticalPanel verticalPanel03 = new VerticalPanel();
		final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
		final HorizontalPanel horizontalPanel02 = new HorizontalPanel();
		final Image image = new Image("icons/print_icon_popup.png");
		final HTML label = new HTML("Please, enter a name to save the PDF file.<br>Depending on your network connexion and on the uploaded "
				+ "image(s), size and/or number, the download of the PDF report may take some time.");
		final TextBox fileName = new TextBox();
		final TextBox filebox = new TextBox();
		final FormPanel myForm = new FormPanel();
		final Button cancelButton = new Button("Cancel/Close", new ClickHandler () {
			@Override
			public void onClick(ClickEvent event) {
				mySaveDialog.hide();
			}
		});
		final Button submitButton = new Button("Print", new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				verticalPanel01.clear();
				verticalPanel01.add(filebox);
				createPrint(verticalPanel01);
				myPDFName = fileName.getText();
				if (!myPDFName.toLowerCase().endsWith(".pdf")) {myPDFName = myPDFName + ".pdf";};
				filebox.setText(myPDFName);
				myForm.submit();
				docNotModified();
			}
		});
		fileName.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					verticalPanel01.clear();
					verticalPanel01.add(filebox);
					createPrint(verticalPanel01);
					myPDFName = fileName.getText();
					if (!myPDFName.toLowerCase().endsWith(".pdf")) {myPDFName = myPDFName + ".pdf";};
					filebox.setText(myPDFName);
					myForm.submit();
					docNotModified();
				}
			}
		});
		filebox.setName("filename");
		mySaveDialog.setGlassEnabled(true);
		verticalPanel03.add(horizontalPanel02);
		verticalPanel03.getElement().setAttribute("style", "margin-left: 5px !important; margin-top: 10px !important; margin-right: 10px "
				+ "!important;");
		horizontalPanel02.add(image);
		horizontalPanel02.add(verticalPanel02);
		label.setStyleName("gwt-Label");
		label.getElement().setAttribute("style", "margin-right:20px !important; margin-bottom:30px !important; margin-top:10px !important;");
		verticalPanel02.add(label);
		fileName.setStyleName("gi_textBox");
		fileName.getElement().setAttribute("style", "width:230px !important; margin-left: 20px !important;");
		verticalPanel02.add(fileName);
		myPDFName = fileName.getText();
		if (!myPDFName.toLowerCase().endsWith(".pdf")) {myPDFName = myPDFName + ".pdf";};
		myForm.setAction(asmmPath + "/print");
		myForm.setMethod(FormPanel.METHOD_POST);
		myForm.add(verticalPanel01);
		myForm.setVisible(false);
		horizontalPanel01.add(submitButton);
		horizontalPanel01.add(cancelButton);
		submitButton.getElement().setAttribute("style", "margin-left:95px !important; font-family: DroidSansFallback !important; font-weight: "
				+ "bold !important;");
		cancelButton.getElement().setAttribute("style", "margin-left:65px !important; font-family: DroidSansFallback !important; font-weight: "
				+ "bold !important;");
		horizontalPanel01.getElement().setAttribute("style", "margin-top:30px !important; margin-bottom:20px !important;");
		verticalPanel02.add(myForm);	
		verticalPanel03.add(horizontalPanel01);
		mySaveDialog.add(verticalPanel03);	
		mySaveDialog.setSize( "370px", "180px" );
		mySaveDialog.setModal(true);
		mySaveDialog.center();
		mySaveDialog.setStyleName("myUploadBox");
		fileName.setFocus(true);
	}


	// create a window with text dedicated to ASMM
	private void aboutWindow() {
		final DialogBox aboutDialog = new DialogBox();
		final VerticalPanel verticalPanel01 = new VerticalPanel();
		final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
		final Image image = new Image("icons/about_icon_popup.png");
		final HTML label = new HTML("The Airborne Science Mission Metadata (ASMM) Creator " + asmmVersion + " online version, was developed by "
				+ "EUFAR using Eclipse 4.4, Google Web Toolkit and Java. XML files generated by this version conform to " + xmlVersion + " of "
				+ "the ASMM XML standard. The opensource reporting engine used for PDF report generation is provided and owned by <a href=http:"
				+ "//community.jaspersoft.com/project/jasperreports-library><span style=\" text-decoration: underline; color:#0000ff;\">Jasper"
				+ "Soft</a>.<br> <br>For more information, or to submit a bug report, please contact <a href='mailto:olivier.henry.at.meteo.fr'>"
				+ "<span style=\" text-decoration: underline; color:#0000ff;\">olivier.henry.at.meteo.fr</a>.<br><br>The latest offline version "
				+ "and source code of the ASMM Creator can be found at <a href=https://github.com/eufarn7sp/asmm-eufar-java><span style=\" text-"
				+ "decoration: underline; color:#0000ff;\">https://github.com/eufarn7sp/asmm-eufar-java</a>.");
		final Button button = new Button("Ok", new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {aboutDialog.hide();}
		});
		aboutDialog.setGlassEnabled(true);
		verticalPanel01.getElement().setAttribute("style", "margin-left: 10px !important; margin-top: 20px !important; margin-right: 20px "
				+ "!important;");
		horizontalPanel01.add(image);
		horizontalPanel01.add(label);
		label.setStyleName("gwt-Label");
		verticalPanel01.add(horizontalPanel01);
		verticalPanel01.add(button);
		button.getElement().setAttribute("style", "margin-left: 220px !important; font-family: DroidSansFallback !important; font-weight: bold "
				+ "!important; margin-top: 20px !important;");
		aboutDialog.add(verticalPanel01);
		aboutDialog.setSize( "500px", "270px" );
		aboutDialog.setModal(true);
		aboutDialog.center();
		aboutDialog.setStyleName("myUploadBox");
		aboutDialog.show();
	}


	// create a window with text dedicated to ASMM XML standard
	private void aboutStandard() {
		final DialogBox aboutDialog = new DialogBox();
		final VerticalPanel verticalPanel01 = new VerticalPanel();
		final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
		final Image image = new Image("icons/changelog_icon_popup.png");
		final HTML label = new HTML("The Airborne Science Mission Metadata (ASMM) standard is intended to unify descriptions of science research "
				+ "flights. This common description will allow users of the airborne science data to search past datasets for specific meteoro"
				+ "logical conditions, geographical regions, cloud-types encountered, particles sampled, and other parameters not evident from "
				+ "the data itself.<br><br> For more information, please read the following document: <a href=https://github.com/eufarn7sp/asmm"
				+ "-eufar/blob/master/Documentation/ASMM%20-%20XML%20Implementation%20Rules.pdf><span style=\" text-decoration: underline; color"
				+ ":#0000ff;\">ASMM - XML Implementation Rules.pdf</a>");
		final Button button = new Button("Ok", new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {aboutDialog.hide();}
		});
		aboutDialog.setGlassEnabled(true);
		verticalPanel01.getElement().setAttribute("style", "margin-left: 10px !important; margin-top: 20px !important; margin-right: 20px "
				+ "!important;");
		horizontalPanel01.add(image);
		horizontalPanel01.add(label);
		label.setStyleName("gwt-Label");
		verticalPanel01.add(horizontalPanel01);
		verticalPanel01.add(button);
		button.getElement().setAttribute("style", "margin-left: 220px !important; font-family: DroidSansFallback !important; font-weight: bold "
				+ "!important; margin-top: 20px !important;");
		aboutDialog.add(verticalPanel01);
		aboutDialog.setSize( "500px", "240px" );
		aboutDialog.setModal(true);
		aboutDialog.center();
		aboutDialog.setStyleName("myUploadBox");
		aboutDialog.show();
	}


	// add element to a list and a widget
	private PushButton addListButton(final FlexTable flexTable, final TextBox widget, final ArrayList<String> itemList) {
		final Image image = new Image("icons/plus_icon_small.png");
		final PushButton addButton = new PushButton(image);
		widget.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					if (widget.getText() == "") {
						return;
					}
					docIsModified();
					final String widgetText = widget.getText();
					int row = flexTable.getRowCount();
					final Image image = new Image("icons/del_icon_small.png");
					final PushButton delButton = new PushButton(image);
					final Label label = new Label(widgetText);
					itemList.add(widgetText);
					widget.setText("");
					delButton.setPixelSize(25, 25);
					delButton.setStyleName("infoButton");
					flexTable.insertRow(row);
					flexTable.setWidget(row, 0, label);
					flexTable.setWidget(row, 1, delButton);
					flexTable.getFlexCellFormatter().setHorizontalAlignment(row, 1, HasHorizontalAlignment.ALIGN_RIGHT);
					delButton.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							docIsModified();
							int removedIndex = itemList.indexOf(widgetText);
							itemList.remove(removedIndex);
							flexTable.removeRow(removedIndex);
						}
					});
				}
			}
		});
		addButton.setPixelSize(25, 25);
		addButton.setTabIndex(-1);
		addButton.setStyleName("infoButton");
		addButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (widget.getText() == "") {
					return;
				}
				docIsModified();
				final String widgetText = widget.getText();
				int row = flexTable.getRowCount();
				final Image image = new Image("icons/del_icon_small.png");
				final PushButton delButton = new PushButton(image);
				final Label label = new Label(widgetText);
				itemList.add(widgetText);
				widget.setText("");
				delButton.setPixelSize(25, 25);
				delButton.setStyleName("infoButton");
				flexTable.insertRow(row);
				flexTable.setWidget(row, 0, label);
				flexTable.setWidget(row, 1, delButton);
				flexTable.getFlexCellFormatter().setHorizontalAlignment(row, 1, HasHorizontalAlignment.ALIGN_RIGHT);
				delButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						docIsModified();
						int removedIndex = itemList.indexOf(widgetText);
						itemList.remove(removedIndex);
						flexTable.removeRow(removedIndex);
					}
				});
			}
		});
		return addButton;
	}


	// see above, but dedicated to the read function
	private void addList(final FlexTable flexTable, final String string, final ArrayList<String> itemList) {
		int row = flexTable.getRowCount();
		final Image image = new Image("icons/del_icon_small.png");
		final PushButton delButton = new PushButton(image);
		final Label label = new Label(string);
		itemList.add(string);
		delButton.setPixelSize(25, 25);
		delButton.setStyleName("infoButton");
		flexTable.insertRow(row);
		flexTable.setWidget(row, 0, label);
		flexTable.setWidget(row, 1, delButton);
		flexTable.getFlexCellFormatter().setHorizontalAlignment(row, 1, HasHorizontalAlignment.ALIGN_RIGHT);
		delButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				docIsModified();
				int removedIndex = itemList.indexOf(string);
				itemList.remove(removedIndex);
				flexTable.removeRow(removedIndex);
			}
		});
	}


	// create new checkboxes and an information popup
	private PushButton addCatButton(final FlexTable flexTable, final TreeMap<String, String> treeMap, final VerticalPanel verticalPanel) {
		final PushButton addButton = new PushButton("Add a new CheckBox");
		addButton.setTabIndex(-1);
		addButton.getElement().setAttribute("style", "width: 160px !important; height: 18px !important; margin-left: 420px !important; "
				+ "font-family: DroidSansFallback !important; font-size: 12px; text-align: center !important; padding-top: 5px; font-weight: "
				+ "bold !important;");
		addButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (treeMap.size() == 12) {
					final DialogBox infoDialog = new DialogBox();
					final VerticalPanel verticalPanel02 = new VerticalPanel();
					final HorizontalPanel horizontalPanel03 = new HorizontalPanel();
					final Label label02 = new Label("You can't create more than 12 checkboxes per section in ASMM Creator Online.");
					final Button button = new Button("Ok", new ClickHandler() {			
						@Override
						public void onClick(ClickEvent event) {infoDialog.hide();}
					});
					final Image image = new Image("icons/warning_icon_popup.png");
					infoDialog.setGlassEnabled(true);
					horizontalPanel03.add(image);
					horizontalPanel03.add(label02);
					verticalPanel02.add(horizontalPanel03);
					verticalPanel02.add(button);
					button.getElement().setAttribute("style", "margin-left: 120px !important; font-family: DroidSansFallback !important; font-weight:"
							+ " bold !important; margin-top: 20px !important;");
					infoDialog.add(verticalPanel02);
					infoDialog.setSize( "300px", "170px" );
					infoDialog.setModal(true);
					infoDialog.center();
					infoDialog.setStyleName("myUploadBox");
					infoDialog.show();
					return;
				}
				final DialogBox checkboxDialog = new DialogBox();
				final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
				final Label label01 = new Label("Please, enter a title for the new checkbox.");
				final VerticalPanel verticalPanel01 = new VerticalPanel();
				final TextBox textBox = new TextBox();
				final HorizontalPanel horizontalPanel02 = new HorizontalPanel();
				checkboxDialog.setGlassEnabled(true);
				label01.getElement().setAttribute("style", "margin-right:20px !important; margin-bottom:30px !important; margin-top:10px !important;");
				verticalPanel01.add(label01);
				verticalPanel01.add(textBox);
				textBox.setStyleName("myAddBox");
				textBox.addKeyDownHandler(new KeyDownHandler() {
					public void onKeyDown(KeyDownEvent event) {
						if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
							String value = treeMap.get(textBox.getText());
							if (value != null || textBox.getText() == "") {
								checkboxDialog.hide();
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
							}
							else {cell = flexTable.getCellCount(row-1);}
							String stringBox = textBox.getText();
							stringBox = stringBox.toLowerCase();
							final StringBuilder b = new StringBuilder(stringBox);
							int i = 0;
							do {
								if (i == 0) {i =  b.indexOf(" ", i) + 1;}
								else {
									b.replace(i, i + 1, b.substring(i,i + 1).toUpperCase());
									i =  b.indexOf(" ", i) + 1;
								}
							} while (i > 0 && i < b.length());
							String stringCode = b.toString();
							stringCode = stringCode.replaceAll("\\s","");
							treeMap.put(textBox.getText(),stringCode);
							final CheckBox checkBox = new CheckBox();
							checkBox.setText(textBox.getText());
							String parent = parentMap.get(verticalPanel);
							checkBox.setName(parent + "UD" + Integer.toString(row) + Integer.toString(cell) + textBox.getValue());
							checkBox.addClickHandler(new ClickHandler() {
								@Override
								public void onClick(ClickEvent event) {docIsModified();}
							});
							horizontalPanel02.add(checkBox);
							flexTable.setWidget(row - 1, cell, horizontalPanel02);
							checkboxDialog.hide();
						}
					}
				});
				final Button submitButton = new Button("Submit", new ClickHandler() {
					public void onClick(ClickEvent event) {
						String value = treeMap.get(textBox.getText());
						if (value != null || textBox.getText() == "") {
							checkboxDialog.hide();
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
						}
						else {cell = flexTable.getCellCount(row-1);}
						String stringBox = textBox.getValue();
						stringBox = stringBox.toLowerCase();
						final StringBuilder b = new StringBuilder(stringBox);
						int i = 0;
						do {
							if (i == 0) {i =  b.indexOf(" ", i) + 1;}
							else {
								b.replace(i, i + 1, b.substring(i,i + 1).toUpperCase());
								i =  b.indexOf(" ", i) + 1;
							}
						} while (i > 0 && i < b.length());
						String stringCode = b.toString();
						stringCode = stringCode.replaceAll("\\s","");
						treeMap.put(textBox.getValue(),stringCode);
						final CheckBox checkBox = new CheckBox();
						checkBox.setText(textBox.getValue());
						String parent = parentMap.get(verticalPanel);
						checkBox.setName(parent + "UD" + Integer.toString(row) + Integer.toString(cell) + textBox.getValue());
						checkBox.addClickHandler(new ClickHandler() {
							@Override
							public void onClick(ClickEvent event) {docIsModified();}
						});
						horizontalPanel02.add(checkBox);
						flexTable.setWidget(row - 1, cell, horizontalPanel02);
						checkboxDialog.hide();
					}
				});
				final Button cancelButton = new Button("Cancel", new ClickHandler() {
					public void onClick(ClickEvent event) {checkboxDialog.hide();}
				});
				submitButton.getElement().setAttribute("style", "margin-left:40px !important; font-family: DroidSansFallback !important; "
						+ "font-weight: bold !important;");
				cancelButton.getElement().setAttribute("style", "margin-left:45px !important; font-family: DroidSansFallback !important; "
						+ "font-weight: bold !important;");
				horizontalPanel01.add(submitButton);
				horizontalPanel01.add(cancelButton);
				horizontalPanel01.getElement().setAttribute("style", "margin-top:40px !important;");
				verticalPanel01.add(horizontalPanel01);
				checkboxDialog.add(verticalPanel01);
				checkboxDialog.setSize( "260px", "170px" );
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
	private void addCat(final FlexTable flexTable, final TreeMap<String, String> treeMap, final VerticalPanel verticalPanel, final String string) {
		final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
		final Label userLabel = new Label("User-defined:");
		final CheckBox checkBox = new CheckBox();
		checkBox.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {docIsModified();}
		});
		LinkedList<String> linkedList = splitCamelCaseString(string);
		String result = new String("");
		int i = 0;
		for (i = 0; i< linkedList.size(); i++) {
			if (i == 0) {
				result = linkedList.get(i);
				result = result.substring(0, 1).toUpperCase() + result.substring(1);
			}
			else {result = result + " " + linkedList.get(i).toLowerCase();}
		}
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
		}
		else {cell = flexTable.getCellCount(row-1);}
		treeMap.put(result,string);
		checkBox.setText(result);
		String parent = parentMap.get(verticalPanel);
		checkBox.setName(parent + "UD" + Integer.toString(row) + Integer.toString(cell) + result);
		checkBox.setValue(true);
		horizontalPanel01.add(checkBox);
		flexTable.setWidget(row - 1, cell, horizontalPanel01);
	}


	// add different entries to a ListBox
	private void populateListBox(ListBox listBox, ArrayList<String> list, int defaultItem) {
		for (int i=0; i<list.size(); i++) { listBox.addItem(list.get(i)); }
		listBox.setItemSelected(defaultItem, true);
	}


	// prepare the text of a checkbox to be saved in an xml file
	private static LinkedList<String> splitCamelCaseString(String s) {
		char[] cArray = s.toCharArray();
		LinkedList<Integer> al = new LinkedList<Integer>();
		al.add(0);
		for (int i = 1; i < cArray.length; i++) {
			char c = cArray[i];
			if (c >= 65 && c <= 90) {al.add(i);}
		}
		LinkedList<String> strl = new LinkedList<String>();
		if (al.size() == 1) {strl.add(s); return strl;}
		int prev = 0;
		int curr = 0;
		int begin = 0;
		for (int k = 1; k < al.size(); k++) {
			curr = al.get(k);
			if(curr == s.length() - 1){ }
			if (curr == prev + 1 && curr != s.length() - 1) {
				prev = curr;
			} else if(curr == prev + 1 &&  curr == s.length() - 1){
				strl.add(s.substring(begin, curr+1));
			}else {
				strl.add(s.substring(prev, curr));
				prev = curr;
				begin = curr;
				if (k == al.size() - 1) {strl.add(s.substring(curr, s.length()));}
			}
		}
		return strl;
	}
	
	
	/// modify the window title to add " - modified"
	private void docIsModified() {
		isModified = true;
		if (!titleString.contains("modified")) {titleString = titleString + " - modified";}
		Window.setTitle(titleString);
	}


	/// modify the window title to remove " - modified"
	private void docNotModified() {
		isModified = false;
		if (titleString.contains("modified")) {titleString = titleString.substring(0, 12);}
		Window.setTitle(titleString);
	}
	
	
	// aircraft selection
	private void aircraftSelection(final String string) {
		if (string == "Do your choice...") {
			fi_aircraftText.clear();
			fi_aircraftText.setEnabled(false);
			if (horizontalPanel26.getWidgetCount() > 1) {
				horizontalPanel26.remove(1);
				horizontalPanel27.remove(1);
				fiGrid.remove(fi_otherOpsText);
				fiGrid.remove(fi_otherAiText);
			}
		} else if (string == "Other") {
			horizontalPanel26.add(fi_operatorImage);
			horizontalPanel27.add(fi_aircraftImage);
			fi_aircraftText.clear();
			fi_aircraftText.setEnabled(true);
			fi_aircraftText.addItem("Other");
			fiGrid.setWidget(5, 2, fi_otherOpsText);
			fiGrid.setWidget(6, 2, fi_otherAiText);
		} else {
			if (horizontalPanel26.getWidgetCount() > 1) {
				horizontalPanel26.remove(1);
				horizontalPanel27.remove(1);
				fiGrid.remove(fi_otherOpsText);
				fiGrid.remove(fi_otherAiText);
			}
			fi_aircraftText.setEnabled(true);
			fi_aircraftText.clear();
			fi_aircraftText.addItem("Do your choice...");
			for (int i = 0; i < operatorsAircraft.length; i++) {
				if (fi_operatorText.getSelectedItemText() == operatorsAircraft[i][0]) {
					fi_aircraftText.addItem(operatorsAircraft[i][1]);
				}
			}
			if (fi_aircraftText.getItemCount() < 3) {
				fi_aircraftText.removeItem(0);
			}
		}
	}
	
	
	private void createPrint(final VerticalPanel verticalPanel) {
		List<TextBoxBase> allTextBox = $("*", subDockPanel).widgets(TextBoxBase.class);
		for (int i = 0; i < allTextBox.size(); i++) {
				TextBox textBox = new TextBox();
				textBox.setText(allTextBox.get(i).getText());
				textBox.setName(textboxName.get(i).toString());
				verticalPanel.add(textBox);
		}
		List<ListBox> allListBox = $("*", subDockPanel).widgets(ListBox.class);
		for (int i = 0; i < allListBox.size(); i++) {
			TextBox textBox = new TextBox();
			if (allListBox.get(i).getSelectedItemText() == "Do your choice...") {
				textBox.setText("");
			} else {
				textBox.setText(allListBox.get(i).getSelectedItemText());
			}
			textBox.setName(listboxName.get(i).toString());
			verticalPanel.add(textBox);
		}
		List<DateBox> allDateBox = $("*", subDockPanel).widgets(DateBox.class);
		for (int i = 0; i < allDateBox.size(); i++) {
			TextBox textBox = new TextBox();
			textBox.setText(DateTimeFormat.getFormat("yyyy-MM-dd").format(allDateBox.get(i).getValue()));
			textBox.setName(dateboxName.get(i).toString());
			verticalPanel.add(textBox);
		}
		List<CheckBox> allCheckBox = $("*", subDockPanel).widgets(CheckBox.class);
		int j = 0;
		for (int i = 0; i < allCheckBox.size(); i = i + 2) {
			TextBox textBox = new TextBox();
			if (allCheckBox.get(i).getName() == "") {
				if (allCheckBox.get(i).getValue() == true) {
					textBox.setText("icons/checkbox_checked.png");
				} else
					textBox.setText("icons/checkbox_unchecked.png");
				textBox.setName(checkboxName.get(j).toString());
				j++;
				verticalPanel.add(textBox);
			} else {
				if (allCheckBox.get(i).getValue() == true) {
					String name = allCheckBox.get(i).getName();
					textBox.setText("icons/checkbox_checked.png*" + name.substring(6));
					textBox.setName(name.substring(0, 6));
					verticalPanel.add(textBox);
				}
			}
		}
		if (so_groundSitesList.isEmpty() == false) {
			TextBox textBox = new TextBox();
			textBox.setName("groundSites");
			String string = new String();
			for (int i = 0; i < so_groundSitesList.size(); i++) {
				if (i == 0){
					string = so_groundSitesList.get(i).toString();
				} else {
					string = string + "<br>" + so_groundSitesList.get(i).toString();
				}
			}
			textBox.setText(string);
			verticalPanel.add(textBox);
		}
		if (so_armSitesList.isEmpty() == false) {
			TextBox textBox = new TextBox();
			textBox.setName("armSites");
			String string = new String();
			for (int i = 0; i < so_armSitesList.size(); i++) {
				if (i == 0){
					string = so_armSitesList.get(i).toString();
				} else {
					string = string + "<br>" + so_armSitesList.get(i).toString();
				}
			}
			textBox.setText(string);
			verticalPanel.add(textBox);
		}
		if (so_researchVesselsList.isEmpty() == false) {
			TextBox textBox = new TextBox();
			textBox.setName("researchVessels");
			String string = new String();
			for (int i = 0; i < so_researchVesselsList.size(); i++) {
				if (i == 0){
					string = so_researchVesselsList.get(i).toString();
				} else {
					string = string + "<br>" + so_researchVesselsList.get(i).toString();
				}
			}
			textBox.setText(string);
			verticalPanel.add(textBox);
		}
		if (so_mobileSitesList.isEmpty() == false) {
			TextBox textBox = new TextBox();
			textBox.setName("mobileSites");
			String string = new String();
			for (int i = 0; i < so_mobileSitesList.size(); i++) {
				if (i == 0){
					string = so_mobileSitesList.get(i).toString();
				} else {
					string = string + "<br>" + so_mobileSitesList.get(i).toString();
				}
			}
			textBox.setText(string);
			verticalPanel.add(textBox);
		}
		if (imagePath.isEmpty() == false) {
			for (int i = 0; i < imagePath.size(); i++) {
				TextBox textBox = new TextBox();
				textBox.setName("image" + Integer.toString(i));
				textBox.setText(imagePath.get(i) + "*" + imageCaption.get(i));
				verticalPanel.add(textBox);
			}
		}
	}
	
	
	// open an image to include in PDF report
	private void uploadImage() {
		if (imagePath.size() < 11) {
			final DialogBox myOpenDialog = new DialogBox();
			final FileUpload myFileUpload = new FileUpload();
			final FormPanel myUploadForm = new FormPanel();
			final VerticalPanel verticalPanel01 = new VerticalPanel();
			final VerticalPanel verticalPanel02 = new VerticalPanel();
			final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
			final HorizontalPanel horizontalPanel02 = new HorizontalPanel();
			final Image image = new Image("icons/open_image_icon_popup.png");
			final Label label = new Label("Please, select the image you want to upload.");
			final Label label2 = new Label("Caption (optional):");
			final TextBox legendeBox = new TextBox();
			legendeBox.setStyleName("au_textBox");
			final Button submitButton = new Button("Upload", new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {myUploadForm.submit();}
			});
			final Button cancelButton = new Button("Cancel/Close", new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {myOpenDialog.hide();}
			});
			myOpenDialog.setGlassEnabled(true);
			myOpenDialog.add(verticalPanel02);
			verticalPanel02.add(horizontalPanel01);
			verticalPanel02.getElement().setAttribute("style", "margin-left: 5px !important; margin-top: 10px !important; margin-right: 10px "
					+ "!important;");
			horizontalPanel01.add(image);
			horizontalPanel01.add(verticalPanel01);
			verticalPanel01.getElement().setAttribute("style", "margin-right:20px !important;");
			label.getElement().setAttribute("style", "margin-right:20px !important; margin-bottom:10px !important; margin-top:10px !important;");
			verticalPanel01.add(label);
			myFileUpload.setName("uploadFormElement");
			myFileUpload.getElement().setId("uploadFormElement");
			myFileUpload.getElement().setId("myFile");
			myFileUpload.getElement().setAttribute("style", "margin-left:20px !important;");
			verticalPanel01.add(myFileUpload);
			verticalPanel01.add(label2);
			verticalPanel01.add(legendeBox);
			myUploadForm.setAction(asmmPath + "/image");
			myUploadForm.setEncoding(FormPanel.ENCODING_MULTIPART);
			myUploadForm.setMethod(FormPanel.METHOD_POST);
			myUploadForm.addSubmitHandler(new FormPanel.SubmitHandler() {
				@Override
				public void onSubmit(SubmitEvent event) {
					if (myFileUpload.getFilename().length() == 0) {
						Window.alert("Please, select a file.");
						event.cancel();
					}		       
				}
			});
			myUploadForm.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
				@Override
				public void onSubmitComplete(SubmitCompleteEvent event) {
					final String captionText = new String(legendeBox.getText());
					myOpenDialog.hide();
					String ret = event.getResults();
					imagePath.add("tmp/" + ret);
					int row = imageTab.getRowCount();
					final Image image1 = new Image("icons/del_icon_small.png");
					final Image image2 = new Image("tmp/" + ret);
					final PushButton delButton = new PushButton(image1);
					final Label label = new Label(captionText);
					image2.addLoadHandler(new LoadHandler() {
						public void onLoad(LoadEvent event) {
							int height = image2.getHeight();
							int width = image2.getWidth();
							float sizeRatio = (float) width / height;
							int newWidth = 200;
							int newHeight = (int) (newWidth / sizeRatio);
							image2.setSize("200px", Float.toString(newHeight) + "px");
						}
					});
					imageCaption.add(captionText);
					delButton.setPixelSize(25, 25);
					delButton.setStyleName("infoButton");
					label.getElement().setAttribute("style", "width: 200px !important;");
					imageTab.insertRow(row);
					imageTab.setWidget(row, 0, image2);
					imageTab.setWidget(row, 1, label);
					imageTab.setWidget(row, 2, delButton);
					imageTab.getFlexCellFormatter().setHorizontalAlignment(row, 1, HasHorizontalAlignment.ALIGN_RIGHT);
					delButton.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							int removedIndex = imageCaption.indexOf(captionText);
							imageCaption.remove(removedIndex);
							imagePath.remove(removedIndex);
							imageTab.removeRow(removedIndex);
						}
					});
				}
			});		
			myUploadForm.add(verticalPanel02);
			horizontalPanel02.add(submitButton);
			horizontalPanel02.add(cancelButton);
			label2.getElement().setAttribute("style", "margin-top:10px !important; text-decoration: underline !important; font-weight: "
					+ "bold !important; margin-bottom: 10px !important");
			submitButton.getElement().setAttribute("style", "margin-left:20px !important; font-family: DroidSansFallback !important; font-weight: "
					+ "bold !important;");
			cancelButton.getElement().setAttribute("style", "margin-left:73px !important; font-family: DroidSansFallback !important; font-weight: "
					+ "bold !important;");
			horizontalPanel02.getElement().setAttribute("style", "margin-top:30px !important; margin-bottom:20px !important;");
			verticalPanel01.add(horizontalPanel02);
			myOpenDialog.add(myUploadForm);
			myOpenDialog.setSize( "130px", "180px" );
			myOpenDialog.setModal(true);
			myOpenDialog.center();
			myOpenDialog.setStyleName("myUploadBox");
		} else {Window.alert("You can't upload more than 10 images");}
	}
	
	
	// open an image to include in PDF report (URL)
	private void uploadImageURL() {
		if (imagePath.size() < 11) {
			final DialogBox myOpenDialog = new DialogBox();
			final VerticalPanel verticalPanel01 = new VerticalPanel();
			final VerticalPanel verticalPanel02 = new VerticalPanel();
			final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
			final HorizontalPanel horizontalPanel02 = new HorizontalPanel();
			final Image image = new Image("icons/open_image_	icon_popup.png");
			final Label label = new Label("Please, enter the URL of the image you want to upload.");
			final Label label2 = new Label("URL:");
			final Label label3 = new Label("Caption (optional):");
			final TextBox legendeBox = new TextBox();
			legendeBox.setStyleName("au_textBox");
			final TextBox textBox = new TextBox();
			final Button submitButton = new Button("Upload", new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					final String captionText = new String(legendeBox.getText());
					String string = new String(textBox.getText());
					imagePath.add(string);
					myOpenDialog.hide();
					int row = imageTab.getRowCount();
					final Image image1 = new Image("icons/del_icon_small.png");
					final Image image2 = new Image(string);
					final PushButton delButton = new PushButton(image1);
					final Label label = new Label(captionText);
					image2.addLoadHandler(new LoadHandler() {
						public void onLoad(LoadEvent event) {
							int height = image2.getHeight();
							int width = image2.getWidth();
							float sizeRatio = (float) width / height;
							int newWidth = 200;
							int newHeight = (int) (newWidth / sizeRatio);
							image2.setSize("200px", Float.toString(newHeight) + "px");
						}
					});
					imageCaption.add(captionText);
					delButton.setPixelSize(25, 25);
					delButton.setStyleName("infoButton");
					imageTab.insertRow(row);
					imageTab.setWidget(row, 0, image2);
					imageTab.setWidget(row, 1, label);
					imageTab.setWidget(row, 2, delButton);
					imageTab.getFlexCellFormatter().setHorizontalAlignment(row, 1, HasHorizontalAlignment.ALIGN_RIGHT);
					delButton.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							int removedIndex = imageCaption.indexOf(captionText);
							imageCaption.remove(removedIndex);
							imagePath.remove(removedIndex);
							imageTab.removeRow(removedIndex);
						}
					});
				}
			});
			final Button cancelButton = new Button("Cancel/Close", new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {myOpenDialog.hide();}
			});
			myOpenDialog.setGlassEnabled(true);
			myOpenDialog.add(verticalPanel02);
			verticalPanel02.add(horizontalPanel01);
			verticalPanel02.getElement().setAttribute("style", "margin-left: 5px !important; margin-top: 10px !important; margin-right: 10px "
					+ "!important;");
			horizontalPanel01.add(image);
			horizontalPanel01.add(verticalPanel01);
			verticalPanel01.getElement().setAttribute("style", "margin-right:20px !important;");
			label.getElement().setAttribute("style", "margin-right:20px !important; margin-bottom:10px !important; margin-top:10px !important;");
			verticalPanel01.add(label);
			verticalPanel01.add(label2);
			verticalPanel01.add(textBox);
			verticalPanel01.add(label3);
			verticalPanel01.add(legendeBox);
			textBox.setStyleName("au_textBox");
			horizontalPanel02.add(submitButton);
			horizontalPanel02.add(cancelButton);
			label2.getElement().setAttribute("style", "text-decoration: underline !important; font-weight: bold !important; margin-bottom: 10px "
					+ "!important");
			label3.getElement().setAttribute("style", "margin-top:10px !important; text-decoration: underline !important; font-weight: "
					+ "bold !important; margin-bottom: 10px !important");
			submitButton.getElement().setAttribute("style", "margin-left:20px !important; font-family: DroidSansFallback !important; font-weight: "
					+ "bold !important;");
			cancelButton.getElement().setAttribute("style", "margin-left:73px !important; font-family: DroidSansFallback !important; font-weight: "
					+ "bold !important;");
			horizontalPanel02.getElement().setAttribute("style", "margin-top:30px !important; margin-bottom:20px !important;");
			verticalPanel01.add(horizontalPanel02);
			myOpenDialog.setSize( "350px", "180px" );
			myOpenDialog.setModal(true);
			myOpenDialog.center();
			myOpenDialog.setStyleName("myUploadBox");
		} else {Window.alert("You can't upload more than 10 images");}
	}
		
	
	// localisation selection
	private void geoLocationSet(final int index) {
		if (index == 0) {
			geoDetailLst.clear();
			geoDetailLst.setEnabled(false);
		}
		else {
			geoDetailLst.clear();
			geoDetailLst.setEnabled(true);
			if (index == 1) {populateListBox(geoDetailLst, continentList, 0);}
			else if (index == 2) {populateListBox(geoDetailLst, countryList, 0);}
			else if (index == 3) {populateListBox(geoDetailLst, oceanList, 0);}
			else if (index == 4) {populateListBox(geoDetailLst, regionList, 0);}
		}
	}
	
	
	// popup to change layout 
	private void layoutPopup() {
		if (!tabLayout) {
			final DialogBox myOpenDialog = new DialogBox();
			final VerticalPanel verticalPanel01 = new VerticalPanel();
			final VerticalPanel verticalPanel02 = new VerticalPanel();
			final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
			final HorizontalPanel horizontalPanel02 = new HorizontalPanel();
			final Image image = new Image("icons/preferences_icon_popup.png");
			final Label label = new Label("You have the possibility to change the global layout to a browser-like horizontal layout. Once the new "
					+ "layout is selected, you have to reload ASMM to switch back to the original layout.");
			final Button submitButton = new Button("Ok", new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					myOpenDialog.hide();
					changeLayout();}
			});
			final Button cancelButton = new Button("Cancel", new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {myOpenDialog.hide();}
			});
			myOpenDialog.setGlassEnabled(true);
			myOpenDialog.add(verticalPanel02);
			verticalPanel02.add(horizontalPanel01);
			verticalPanel02.getElement().setAttribute("style", "margin-left: 10px !important; margin-top: 10px !important; margin-right: 10px "
					+ "!important;");
			horizontalPanel01.add(image);
			horizontalPanel01.add(verticalPanel01);
			verticalPanel01.add(label);
			horizontalPanel02.add(submitButton);
			horizontalPanel02.add(cancelButton);
			submitButton.getElement().setAttribute("style", "margin-left:20px !important; font-family: DroidSansFallback !important; font-weight: "
					+ "bold !important;");
			cancelButton.getElement().setAttribute("style", "margin-left:120px !important; font-family: DroidSansFallback !important; font-weight: "
					+ "bold !important;");
			horizontalPanel02.getElement().setAttribute("style", "margin-top:30px !important; margin-bottom:20px !important;");
			verticalPanel01.add(horizontalPanel02);
			myOpenDialog.setSize("350px", "130px");
			myOpenDialog.setModal(true);
			myOpenDialog.center();
			myOpenDialog.setStyleName("myUploadBox");	
		}
	}
		
	
	// change layout
	private void changeLayout() {
		if (!tabLayout) {		
			tabPanel.clear();
			tabPanel.add(fiScroll,"Flight Information");
			tabPanel.add(ciScroll,"Contact Information");
			tabPanel.add(saScroll,"Scientific Aims");
			tabPanel.add(giScroll,"Geographic Information");
			tabPanel.add(afScroll,"Atmospheric Synoptic Features");
			tabPanel.add(ctScroll,"Cloud Types and Forms Sampled During Flight");
			tabPanel.add(cpScroll,"Cloud, Precipitation and Aerosol Particles Sampled");
			tabPanel.add(loScroll,"Land or Oceans Surfaces Overflown");
			tabPanel.add(arScroll,"Altitude Range of Measurement");
			tabPanel.add(fmScroll,"Types of Flight Manoeuvre");
			tabPanel.add(scScroll,"Satellite Coordination");
			tabPanel.add(soScroll,"Supporting Surface-based Observations");
			tabPanel.add(nfScroll,"Additional Notes on the Flight");
			tabPanel.add(ipScroll,"Images included in the PDF report");
			float ratio = 1166/80;
			int screen_width = Window.getClientWidth();
			float band_height = (float) screen_width/ratio;
			subDockPanel.clear();
			subDockPanel.addNorth(new HTML("<img src='icons/asmm_top.jpg' alt='ASMM Creator' height='" + Float.toString(band_height) + 
					"px' width='" + Integer.toString(screen_width) + "px'>"), band_height);
			subDockPanel.addNorth(mainMenu, 30);
			subDockPanel.add(tabPanel);
			RootLayoutPanel rp=RootLayoutPanel.get();
			rp.clear();
			rp.add(subDockPanel);
			tabLayout = true;
		} 
	}
	
	
	// obtain screen width
	private native int getScreenWidth()/*-{
    	return screen.width;
	}-*/;
	
	
	// obtain screen height
	private native int getScreenHeight()/*-{
		return screen.height;
	}-*/;
	
	
	/// create all the Info buttons in the different tabs
	private PushButton addInfoButton() {
		final Image image = new Image("icons/info_icon_small.png");
		final PushButton infoButton = new PushButton(image);
		infoButton.setPixelSize(25, 25);
		infoButton.setStyleName("infoButton");
		infoButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				final DialogBox infoDialog = new DialogBox();
				final VerticalPanel verticalPanel01 = new VerticalPanel();
				final HorizontalPanel horizontalPanel01 = new HorizontalPanel();
				final Label label02 = new Label("Use this button to add a new checkbox. Each activated checkbox is then saved in the xml file with the "
						+ "code 'xx_User'. All unactivated checkboxes will not be saved and will be lost. As the PDF report generator is limited to 12 "
						+ "checkboxes per section, you can't create more than 12 checkboxes per section in ASMM Creator Online.");
				final Button button = new Button("Ok", new ClickHandler() {			
					@Override
					public void onClick(ClickEvent event) {infoDialog.hide();}
				});
				final Image image = new Image("icons/info_icon_popup.png");
				infoDialog.setGlassEnabled(true);
				horizontalPanel01.add(image);
				horizontalPanel01.add(label02);
				verticalPanel01.add(horizontalPanel01);
				verticalPanel01.add(button);
				button.getElement().setAttribute("style", "margin-left: 120px !important; font-family: DroidSansFallback !important; font-weight:"
						+ " bold !important; margin-top: 20px !important;");
				infoDialog.add(verticalPanel01);
				infoDialog.setSize( "300px", "170px" );
				infoDialog.setModal(true);
				infoDialog.center();
				infoDialog.setStyleName("myUploadBox");
				infoDialog.show();
			}
		});
		return infoButton;
	}
	
}
