package com.eufar.asmm.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.google.gwt.query.client.GQuery.$;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.UmbrellaException;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Navigator;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
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


public class Asmm_eufar implements EntryPoint {

	public static Logger rootLogger = Logger.getLogger("");
	
	// Main window items initialization
	public static MenuBar mainMenu = new MenuBar();
	private MenuBar aboutMenu = new MenuBar(true);
	private MenuBar fileMenu = new MenuBar(true);
	private MenuBar confMenu = new MenuBar(true);
	private DockLayoutPanel dockPanel = new DockLayoutPanel(Unit.PX);
	public static DockLayoutPanel subDockPanel = new DockLayoutPanel(Unit.PX);
	private StackLayoutPanel stackPanel = new StackLayoutPanel(Unit.PX);
	public static ScrollableTabLayoutPanel tabPanel = new ScrollableTabLayoutPanel(28, Unit.PX);
	public static String myFileName = new String("");
	public static String myPDFName = new String("");
	public static String creationDate = new String(DateTimeFormat.getFormat("yyyy-MM-dd").format(new Date()));
	public static String revisionDate = new String(DateTimeFormat.getFormat("yyyy-MM-dd").format(new Date()));
	public static String asmmVersion = new String("1.0.1 (2015-10-21)");
	public static String gwtVersion = new String("2.7.0");
	public static String eclipseVersion = new String("4.5.0");
	public static String javaVersion = new String("1.7.0");
	public static String jasperVersion = new String("6.1.0");
	public static String xmlVersion = new String("v1.0a");
	public static String titleString = new String("ASMM Creator");
	public static Boolean isModified = new Boolean(false);
	public static Boolean tabLayout = new Boolean(false);
	public static HorizontalPanel horizontalPanel26 = new HorizontalPanel();
	public static HorizontalPanel horizontalPanel27 = new HorizontalPanel();
	public static ArrayList<String> textboxName = Resources.textboxName();
	public static ArrayList<String> checkboxName = Resources.checkboxName();
	public static ArrayList<String> listboxName = Resources.listboxName();
	public static ArrayList<String> dateboxName = Resources.dateboxName();
	public static HashMap<VerticalPanel, String> parentMap = Resources.parentMap();
	
	
	public static String asmmPath = new String(GWT.getHostPageBaseURL()); // for Tomcat7 Server
	//public static String asmmPath = new String(""); // for Eclipse Dev Mode
	

	// Menu items initialization
	private String imageNew = "<img src='icons/new_menu_icon.png'/>";
	private String imageOpen = "<img src='icons/open_menu_icon.png'/>";
	private String imageSave = "<img src='icons/save_menu_icon.png'/>";
	private String imagePrint = "<img src='icons/print_menu_icon.png'/>";
	private String imageAbout = "<img src='icons/about_asmm_menu_icon.png'/>";
	private String imageStandard = "<img src='icons/xml_menu_icon.png'/>";
	private String imageEufar = "<img src='icons/eufar_menu_icon.png'/>";
	private String imageExit = "<img src='icons/exit_menu_icon.png'/>";
	private String imageConf = "<img src='icons/preferences_menu_icon.png'/>";
	private String imageLog = "<img src='icons/changelog_menu_icon.png'/>";
	private String imageReload = "<img src='icons/reload_menu_icon.png'/>";


	// Flight Information items initialization
	public static FlexTable fiGrid = new FlexTable();
	private HorizontalPanel horizontalPanel30 = new HorizontalPanel();
	public static ScrollPanel fiScroll = new ScrollPanel(fiGrid);
	public static DateBox fi_dateText = new DateBox();
	public static TextBox fi_flightText = new TextBox();
	public static TextBox fi_campaignText = new TextBox();
	public static TextBox fi_scientistText = new TextBox();
	public static TextBox fi_managerText = new TextBox();
	public static TextBox fi_otherOpsText = new TextBox();
	public static TextBox fi_otherAiText = new TextBox();
	private Label fi_flightLabel = new Label("Flight number:");
	private Label fi_dateLabel = new Label("Date:");
	private Label fi_campaignLabel = new Label("Project acronym:");
	private Label fi_scientistLabel = new Label("Mission scientist:");
	private Label fi_managerLabel = new Label("Flight manager:");
	private Label fi_aircraftLabel = new Label("Platform/Aircraft:");
	private Label fi_operatorLabel = new Label("Operator:");
	private Label fi_countryLabel = new Label("Location:");
	public static Image fi_operatorImage = Resources.smallImage("fwdarrow");
	public static Image fi_aircraftImage = Resources.smallImage("fwdarrow");
	private Image geoFollowImage = Resources.smallImage("fwdarrow");
	public static ListBox fi_operatorText = new ListBox();
	public static ListBox fi_aircraftText = new ListBox();
	public static ListBox geoLocationLst = new ListBox();
	public static ListBox geoDetailLst = new ListBox();
	public static ArrayList<String> countryList = Resources.countryList();
	public static ArrayList<String> continentList = Resources.continentList();
	public static ArrayList<String> oceanList = Resources.oceanList();
	public static ArrayList<String> regionList = Resources.regionList();
	public static ArrayList<String> locationList = Resources.locationList();
	public static ArrayList<String> operatorList = Resources.operatorList();
	public static ArrayList<String> aircraftList = Resources.aircraftList();
	public static String[][] operatorsAircraft = Resources.operatorsAircraft();


	// Contact Information items initialization
	public static FlexTable ciGrid = new FlexTable();
	public static ScrollPanel ciScroll = new ScrollPanel(ciGrid);
	public static TextBox ci_nameText = new TextBox();
	public static TextBox ci_emailText = new TextBox();
	public static ListBox ci_roleText = new ListBox();
	private Label ci_nameLabel = new Label("Name:");
	private Label ci_roleLabel = new Label("Role:");
	private Label ci_emailLabel = new Label("Email:");
	private ArrayList<String> roleList = Resources.roleList();
	

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
	public static VerticalPanel verticalPanel10 = new VerticalPanel();
	public static VerticalPanel verticalPanel67 = new VerticalPanel();
	private HorizontalPanel horizontalPanel01 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel02 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel31 = new HorizontalPanel();
	private Label sa_cloudLabel = new Label("Cloud:");
	private Label sa_layerLabel = new Label("Boundary-layer:");
	private Label sa_comments = new Label("Comments:");
	public static TreeMap<String, String> scientificMap = Resources.scientificMap();
	public static TextArea sa_comArea = new TextArea();
	public static TreeMap<String, String> sa_addCatMap = new TreeMap<String, String>();
	public static FlexTable sa_addCatTable = new FlexTable();
	private HorizontalPanel sa_satCalval = Elements.checkBox("Satellite Cal/Val");
	private HorizontalPanel sa_antPollution = Elements.checkBox("Anthropogenic pollution");
	private HorizontalPanel sa_mesoImpacts = Elements.checkBox("Mesoscale atmospheric impacts");
	private HorizontalPanel sa_microPhysics = Elements.checkBox("Microphysics");
	private HorizontalPanel sa_dyNamics = Elements.checkBox("Dynamics (Cloud)");
	private HorizontalPanel sa_radProperties = Elements.checkBox("Radiative properties");
	private HorizontalPanel sa_convDynamics = Elements.checkBox("Convection dynamics");
	private HorizontalPanel sa_gazChemistry = Elements.checkBox("Gaz chemistry");
	private HorizontalPanel sa_oxyDants = Elements.checkBox("Oxydants");
	private HorizontalPanel sa_orgAnics = Elements.checkBox("Organics");
	private HorizontalPanel sa_other1 = Elements.checkBox("Other (Gaz chemistry)");
	private HorizontalPanel sa_aeroSol = Elements.checkBox("Aerosol");
	private HorizontalPanel sa_cloudImpacts = Elements.checkBox("Cloud microphysical impacts");
	private HorizontalPanel sa_radImpacts = Elements.checkBox("Radiative properties/impacts");
	private HorizontalPanel sa_radIation = Elements.checkBox("Radiation");
	private HorizontalPanel sa_atmSpectroscopy = Elements.checkBox("Atmospheric spectroscopy");
	private HorizontalPanel sa_surfProperties = Elements.checkBox("Surface properties/retrievals");
	private HorizontalPanel sa_other2 = Elements.checkBox("Other (Radiation)");
	private HorizontalPanel sa_cloud = Elements.checkBox("Cloud");
	private HorizontalPanel sa_dynAmics = Elements.checkBox("Dynamics (Boundary-layer)");
	public static ScrollPanel saScroll = new ScrollPanel(verticalPanel10);  


	// Geographical Information items initialization
	public static VerticalPanel verticalPanel11 = new VerticalPanel();
	private VerticalPanel verticalPanel15 = new VerticalPanel();
	private VerticalPanel verticalPanel62 = new VerticalPanel();
	private VerticalPanel verticalPanel63 = new VerticalPanel();
	private VerticalPanel verticalPanel64 = new VerticalPanel();
	private VerticalPanel verticalPanel65 = new VerticalPanel();
	public static VerticalPanel verticalPanel68 = new VerticalPanel();
	private HorizontalPanel horizontalPanel03 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel05 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel06 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel40 = new HorizontalPanel();
	private Label gi_boundingLabel = new Label("Geographic bounding box:");
	private Label gi_nsLabel = new Label("North/South latitudes:");
	private Label gi_weLabel = new Label("West/East longitudes:");
	private Label gi_mmLabel = new Label("Min/Max altitudes (m):");
	private Label gi_comLabel = new Label("Comments:");
	private Label gi_situationLabel = new Label("Geographic situation:");
	public static TextArea gi_comArea = new TextArea();
	public static TextBox gi_northText = new TextBox();
	public static TextBox gi_southText = new TextBox();
	public static TextBox gi_westText = new TextBox();
	public static TextBox gi_eastText = new TextBox();
	public static TextBox gi_minText = new TextBox();
	public static TextBox gi_maxText = new TextBox();
	public static TreeMap<String, String> geographicMap = Resources.geographicMap();
	public static TreeMap<String, String> gi_addCatMap = new TreeMap<String, String>();
	public static FlexTable gi_addCatTable = new FlexTable();
	private FlexTable gi_boundTable = new FlexTable();
	private HorizontalPanel gi_polar = Elements.checkBox("Polar");
	private HorizontalPanel gi_midLatitudes = Elements.checkBox("Mid-latitudes");
	private HorizontalPanel gi_subTropical = Elements.checkBox("Sub-tropical");
	private HorizontalPanel gi_tropical = Elements.checkBox("Tropical");
	private HorizontalPanel gi_maritime = Elements.checkBox("Maritime");
	private HorizontalPanel gi_continental = Elements.checkBox("Continental");
	private HorizontalPanel gi_oceanicIslands = Elements.checkBox("Oceanic islands");
	private HorizontalPanel gi_other = Elements.checkBox("Other");
	public static ScrollPanel giScroll = new ScrollPanel(verticalPanel11);


	// Atmospheric Synoptic Features items initialization
	private VerticalPanel verticalPanel16 = new VerticalPanel();
	private VerticalPanel verticalPanel17 = new VerticalPanel();
	private VerticalPanel verticalPanel18 = new VerticalPanel();
	private VerticalPanel verticalPanel19 = new VerticalPanel();
	public static VerticalPanel verticalPanel20 = new VerticalPanel();
	public static VerticalPanel verticalPanel69 = new VerticalPanel();
	private HorizontalPanel horizontalPanel07 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel08 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel41 = new HorizontalPanel();
	private Label af_comLabel = new Label("Comments:");
	public static TextArea af_comArea = new TextArea();
	public static TreeMap<String, String> synopticMap = Resources.synopticMap();
	public static TreeMap<String, String> af_addCatMap = new TreeMap<String, String>();
	public static FlexTable af_addCatTable = new FlexTable();
	private HorizontalPanel af_stationary = Elements.checkBox("Stationary");
	private HorizontalPanel af_antiStationary = Elements.checkBox("Anticyclonic");
	private HorizontalPanel af_cycloStationary = Elements.checkBox("Cyclonic");
	private HorizontalPanel af_warmFront = Elements.checkBox("Warm front");
	private HorizontalPanel af_warmBelt = Elements.checkBox("Warm conveyor belt");
	private HorizontalPanel af_coldFront = Elements.checkBox("Cold front");
	private HorizontalPanel af_occludedFront = Elements.checkBox("Occluded front");
	private HorizontalPanel af_warmSector = Elements.checkBox("Warm sector");
	private HorizontalPanel af_airMass = Elements.checkBox("Post-cold-frontal air-mass");
	private HorizontalPanel af_airOutbreack = Elements.checkBox("Arctic cold-air outbreak");
	private HorizontalPanel af_orographicInfluence = Elements.checkBox("Orographic influence");
	private HorizontalPanel af_seabreezeFront = Elements.checkBox("Sea-breeze front");
	private HorizontalPanel af_foldIntrusion = Elements.checkBox("Stratospheric fold/intrusion");
	private HorizontalPanel af_convergenceLine = Elements.checkBox("Extended convergence line");
	private HorizontalPanel af_easterlyWave = Elements.checkBox("Easterly wave");
	private HorizontalPanel af_equatorialWave = Elements.checkBox("Equatorial wave");
	private HorizontalPanel af_tropicalCyclone = Elements.checkBox("Tropical cyclone");
	private HorizontalPanel af_organizedConvection = Elements.checkBox("Mesoscale organized convection");
	public static ScrollPanel afScroll = new ScrollPanel(verticalPanel20);


	// Cloud Types and Forms Sampled During Flight items initialization
	private VerticalPanel verticalPanel21 = new VerticalPanel();
	private VerticalPanel verticalPanel22 = new VerticalPanel();
	private VerticalPanel verticalPanel23 = new VerticalPanel();
	private VerticalPanel verticalPanel24 = new VerticalPanel();
	public static VerticalPanel verticalPanel25 = new VerticalPanel();
	public static VerticalPanel verticalPanel70 = new VerticalPanel();
	private HorizontalPanel horizontalPanel09 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel10 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel42 = new HorizontalPanel();
	private Label ct_comLabel = new Label("Comments:");
	public static TextArea ct_comArea = new TextArea();
	public static TreeMap<String, String> cloudMap = Resources.cloudMap();
	public static TreeMap<String, String> ct_addCatMap = new TreeMap<String, String>();
	public static FlexTable ct_addCatTable = new FlexTable();
	private HorizontalPanel ct_waterClouds = Elements.checkBox("Water clouds");
	private HorizontalPanel ct_mixedphasedClouds = Elements.checkBox("Mixed-phase clouds");
	private HorizontalPanel ct_iceClouds = Elements.checkBox("Ice clouds");
	private HorizontalPanel ct_cirrus = Elements.checkBox("Cirrus");
	private HorizontalPanel ct_contrails = Elements.checkBox("Contrails");
	private HorizontalPanel ct_stratocumulus = Elements.checkBox("Stratocumulus");
	private HorizontalPanel ct_shallowCumulus = Elements.checkBox("Shallow cumulus");
	private HorizontalPanel ct_cumulusCongestus = Elements.checkBox("Cumulus congestus");
	private HorizontalPanel ct_cumulTower = Elements.checkBox("Cumulonimbus/towering cumulus");
	private HorizontalPanel ct_altoStracumul = Elements.checkBox("Altostratus/altocumulus");
	private HorizontalPanel ct_waveClouds = Elements.checkBox("Wave clouds");
	private HorizontalPanel ct_statiformClouds = Elements.checkBox("Deep frontal statiform clouds");
	private HorizontalPanel ct_freeAbove = Elements.checkBox("Cloud-free above aircraft");
	private HorizontalPanel ct_freeBelow = Elements.checkBox("Cloud-free below aircraft");
	public static ScrollPanel ctScroll = new ScrollPanel(verticalPanel25);


	// Cloud, Precipitation and Aerosol Particles Sampled items initialization
	private VerticalPanel verticalPanel26 = new VerticalPanel();
	private VerticalPanel verticalPanel27 = new VerticalPanel();
	private VerticalPanel verticalPanel28 = new VerticalPanel();
	private VerticalPanel verticalPanel29 = new VerticalPanel();
	public static VerticalPanel verticalPanel30 = new VerticalPanel();
	public static VerticalPanel verticalPanel71 = new VerticalPanel();
	private HorizontalPanel horizontalPanel11 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel12 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel43 = new HorizontalPanel();
	private Label cp_comLabel = new Label("Comments:");
	public static TextArea cp_comArea = new TextArea();
	public static TreeMap<String, String> cpapMap = Resources.cpapMap();
	public static TreeMap<String, String> cp_addCatMap = new TreeMap<String, String>();
	public static FlexTable cp_addCatTable = new FlexTable();
	private HorizontalPanel cp_rain = Elements.checkBox("Rain");
	private HorizontalPanel cp_drizzle = Elements.checkBox("Drizzle");
	private HorizontalPanel cp_dropletsLiquid = Elements.checkBox("Droplets (liquid)");
	private HorizontalPanel cp_pristineCrystals = Elements.checkBox("Pristine ice crystals");
	private HorizontalPanel cp_snowAggregates = Elements.checkBox("Snow/aggregates");
	private HorizontalPanel cp_graupelHail = Elements.checkBox("Graupel/hail");
	private HorizontalPanel cp_saltAerosol = Elements.checkBox("Sea-salt aerosol");
	private HorizontalPanel cp_continentalAerosol = Elements.checkBox("Continental aerosol");
	private HorizontalPanel cp_urbanPlume = Elements.checkBox("Urban plume");
	private HorizontalPanel cp_biomassBurning = Elements.checkBox("Biomass burning");
	private HorizontalPanel cp_desertDust = Elements.checkBox("Desert/mineral dust");
	private HorizontalPanel cp_volcanicAsh = Elements.checkBox("Volcanic ash");
	public static ScrollPanel cpScroll = new ScrollPanel(verticalPanel30);


	// Land or Oceans Surfaces Overflown items initialization
	private VerticalPanel verticalPanel31 = new VerticalPanel();
	private VerticalPanel verticalPanel32 = new VerticalPanel();
	private VerticalPanel verticalPanel33 = new VerticalPanel();
	private VerticalPanel verticalPanel34 = new VerticalPanel();
	public static VerticalPanel verticalPanel35 = new VerticalPanel();
	public static VerticalPanel verticalPanel72 = new VerticalPanel();
	private HorizontalPanel horizontalPanel13 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel14 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel44 = new HorizontalPanel();
	private Label lo_comLabel = new Label("Comments:");
	public static TextArea lo_comArea = new TextArea();
	public static TreeMap<String, String> surfacesMap = Resources.surfacesMap();
	public static TreeMap<String, String> lo_addCatMap = new TreeMap<String, String>();
	public static FlexTable lo_addCatTable = new FlexTable();
	private HorizontalPanel lo_ocean = Elements.checkBox("Ocean");
	private HorizontalPanel lo_semiArid = Elements.checkBox("Semi-arid");
	private HorizontalPanel lo_seaIce = Elements.checkBox("Sea-ice");
	private HorizontalPanel lo_desert = Elements.checkBox("Desert");
	private HorizontalPanel lo_snow = Elements.checkBox("Snow");
	private HorizontalPanel lo_urban = Elements.checkBox("Urban");
	private HorizontalPanel lo_lakeIce = Elements.checkBox("Lake-ice");
	private HorizontalPanel lo_mountainous = Elements.checkBox("Mountainous");
	private HorizontalPanel lo_vegetation = Elements.checkBox("Vegetation");
	private HorizontalPanel lo_hilly = Elements.checkBox("Hilly");
	private HorizontalPanel lo_forest = Elements.checkBox("Forest");
	private HorizontalPanel lo_flat = Elements.checkBox("Flat");
	public static ScrollPanel loScroll = new ScrollPanel(verticalPanel35);


	// Altitude Range of Measurement items initialization
	private VerticalPanel verticalPanel36 = new VerticalPanel();
	private VerticalPanel verticalPanel37 = new VerticalPanel();
	public static VerticalPanel verticalPanel38 = new VerticalPanel();
	public static VerticalPanel verticalPanel73 = new VerticalPanel();
	private VerticalPanel verticalPanel79 = new VerticalPanel();
	private HorizontalPanel horizontalPanel15 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel16 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel45 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel48 = new HorizontalPanel();
	private Label ar_comLabel = new Label("Comments:");
	public static TextArea ar_comArea = new TextArea();
	public static TreeMap<String, String> measurementMap = Resources.measurementMap();
	public static TreeMap<String, String> ar_addCatMap = new TreeMap<String, String>();
	public static FlexTable ar_addCatTable = new FlexTable();
	private HorizontalPanel ar_boundaryLayer = Elements.checkBox("Boundary-layer");
	private HorizontalPanel ar_nearSurface = Elements.checkBox("near-surface");
	private HorizontalPanel ar_subCloud = Elements.checkBox("sub-cloud");
	private HorizontalPanel ar_inCloud = Elements.checkBox("in-cloud");
	private HorizontalPanel ar_lowerTroposphere = Elements.checkBox("Lower troposphere");
	private HorizontalPanel ar_midTroposphere = Elements.checkBox("Mid troposphere");
	private HorizontalPanel ar_upperTroposphere = Elements.checkBox("Upper troposphere");
	private HorizontalPanel ar_lowerstratosphere = Elements.checkBox("Lower stratosphere");
	public static ScrollPanel arScroll = new ScrollPanel(verticalPanel38);


	// Types of Flight Manoeuvre items initialization
	private VerticalPanel verticalPanel39 = new VerticalPanel();
	private VerticalPanel verticalPanel40 = new VerticalPanel();
	public static VerticalPanel verticalPanel41 = new VerticalPanel();
	public static VerticalPanel verticalPanel74 = new VerticalPanel();
	private VerticalPanel verticalPanel77= new VerticalPanel();
	private VerticalPanel verticalPanel78= new VerticalPanel();
	private HorizontalPanel horizontalPanel17 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel18 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel46 = new HorizontalPanel();
	private Label fm_comLabel = new Label("Comments:");
	public static TextArea fm_comArea = new TextArea();
	public static TreeMap<String, String> manoeuvreMap = Resources.manoeuvreMap();
	public static TreeMap<String, String> fm_addCatMap = new TreeMap<String, String>();
	public static FlexTable fm_addCatTable = new FlexTable();
	private HorizontalPanel fm_levelRuns = Elements.checkBox("Straight/level runs");
	private HorizontalPanel fm_stacked = Elements.checkBox("stacked");
	private HorizontalPanel fm_separated = Elements.checkBox("separated");
	private HorizontalPanel fm_racetracks = Elements.checkBox("Racetracks");
	private HorizontalPanel fm_orbits = Elements.checkBox("Orbits");
	private HorizontalPanel fm_lagrangianDescents = Elements.checkBox("Lagrangian descents");
	private HorizontalPanel fm_ascDescents = Elements.checkBox("Deep profile ascents/descents");
	private HorizontalPanel fm_dropsondeDeployed = Elements.checkBox("Dropsonde deployed");
	private HorizontalPanel fm_selfCalibration = Elements.checkBox("Self-calibration");
	public static ScrollPanel fmScroll = new ScrollPanel(verticalPanel41);


	// Satellite Coordination items initialization
	private VerticalPanel verticalPanel42 = new VerticalPanel();
	private VerticalPanel verticalPanel43 = new VerticalPanel();
	private VerticalPanel verticalPanel44 = new VerticalPanel();
	private VerticalPanel verticalPanel45 = new VerticalPanel();
	public static VerticalPanel verticalPanel47 = new VerticalPanel();
	public static VerticalPanel verticalPanel75 = new VerticalPanel();
	private HorizontalPanel horizontalPanel19 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel20 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel47 = new HorizontalPanel();
	private Label sc_polarLabel = new Label("Polar:");
	private Label sc_geosynchLabel = new Label("Geosynch:");
	private Label sc_comLabel = new Label("Comments:");
	public static TextArea sc_comArea = new TextArea();
	public static TreeMap<String, String> satelliteMap = Resources.satelliteMap();
	public static TreeMap<String, String> sc_addCatMap = new TreeMap<String, String>();
	public static FlexTable sc_addCatTable = new FlexTable();
	private HorizontalPanel sc_metop = Elements.checkBox("METOP");
	private HorizontalPanel sc_npoess = Elements.checkBox("NPOESS");
	private HorizontalPanel sc_atrain = Elements.checkBox("A-train");
	private HorizontalPanel sc_other = Elements.checkBox("Other (Polar)");
	private HorizontalPanel sc_msg = Elements.checkBox("MSG");
	private HorizontalPanel sc_other2 = Elements.checkBox("Other (Geosynch)");
	private HorizontalPanel sc_modis = Elements.checkBox("MODIS");
	private HorizontalPanel sc_cloudsat = Elements.checkBox("Cloudsat");
	private HorizontalPanel sc_caliop = Elements.checkBox("CALIOP");
	private HorizontalPanel sc_iasi = Elements.checkBox("IASI");
	private HorizontalPanel sc_airs = Elements.checkBox("AIRS");
	private HorizontalPanel sc_cris = Elements.checkBox("CriS");
	private HorizontalPanel sc_amsuMhs = Elements.checkBox("AMSU/MHS");
	public static ScrollPanel scScroll = new ScrollPanel(verticalPanel47);


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
	public static VerticalPanel verticalPanel61 = new VerticalPanel();
	private HorizontalPanel horizontalPanel21 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel22 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel23 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel24 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel25 = new HorizontalPanel();
	private Label so_groundSitesLabel = new Label("Ground Sites:");
	private Label so_armSitesLabel = new Label("ARM Sites:");
	private Label so_researchVesselsLabel = new Label("Research Vessels:");
	private Label so_mobileSitesLabel = new Label("ARM Mobile Sites:");
	public static ArrayList<String> so_groundSitesList = new ArrayList<String>();
	public static  FlexTable so_groundSitesTable = new FlexTable();
	public static  ArrayList<String> so_researchVesselsList = new ArrayList<String>();
	public static  FlexTable so_researchVesselsTable = new FlexTable();
	public static  ArrayList<String> so_armSitesList = new ArrayList<String>();
	public static  FlexTable so_armSitesTable = new FlexTable();
	public static  ArrayList<String> so_mobileSitesList = new ArrayList<String>();
	public static  FlexTable so_mobileSitesTable = new FlexTable();
	public static  TextBox so_groundSitesBox = new TextBox();
	public static  TextBox so_armSitesBox = new TextBox();
	public static  TextBox so_researchVesselsBox = new TextBox();
	public static  TextBox so_mobileSitesBox = new TextBox();
	public static ScrollPanel soScroll = new ScrollPanel(verticalPanel61);


	// Additional Notes on the Flight items initialization
	public static VerticalPanel verticalPanel66 = new VerticalPanel();
	public static TextArea nf_comArea = new TextArea();
	public static ScrollPanel nfScroll = new ScrollPanel(verticalPanel66);
	
	
	// Images to pdf
	public static VerticalPanel verticalPanel76 = new VerticalPanel();
	private HorizontalPanel horizontalPanel28 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel29 = new HorizontalPanel();
	public static ScrollPanel ipScroll = new ScrollPanel(verticalPanel76);
	private PushButton addButton = new PushButton("Add a new Image");
	private PushButton urlButton = new PushButton("Add a new Image (URL)");
	public static FlexTable imageTab = new FlexTable();
	public static ArrayList<String> imageCaption = new ArrayList<String>();
	public static ArrayList<String> imagePath = new ArrayList<String>();
	private Label informationLab = new Label("Use the following buttons to add images (JPG, PNG, BMP) to the PDF file. The number of images "
			+ "is limited to 10, and the size of each image cannot exceed 5 MB. All images will be included in the PDF report but not in the "
			+ "XML file.");
	final Label imageLab = new Label("Image");
	final Label captionLab= new Label("Caption");
	

	public void onModuleLoad() {
		GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
			public void onUncaughtException(Throwable e) {
				Throwable unwrapped = unwrap(e);
				rootLogger.log(Level.SEVERE, "An uncaught exception occured: ", unwrapped);
			}
		});
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				onModuleLoad2();
			}
		});
	}
	
				
	private void onModuleLoad2() {
		rootLogger.log(Level.INFO, "***************************************************************");
		rootLogger.log(Level.INFO, "ASMM has started on: " + Navigator.getUserAgent());
		rootLogger.log(Level.INFO, "PATH: " + asmmPath);

		
		// Commands in the menu bar
		Command aboutWindow = new Command() {
			public void execute() {
				PopupMessages.aboutWindow();
			}
		};
		Command aboutStandard = new Command() {
			public void execute() {
				PopupMessages.aboutStandard();
			}
		};
		Command newFile = new Command() {
			public void execute() {
			PopupMessages.newFile();
			}
		};
		Command openFile = new Command() {
			public void execute() {
			PopupMessages.openFile();
			}
		};
		Command saveFile = new Command() {
			public void execute() {
			PopupMessages.saveFile("");
			}
		};
		Command printFile = new Command() {
			public void execute() {
			PopupMessages.printFile();
			}
		};
		Command launchN7SPPage = new Command()  {
			public void execute() {
				Window.open("http://www.eufar.net/N6SP", "_blank", "");
			}
		};
		Command exitFile = new Command()  {
			public void execute() {
				Window.open("http://www.eufar.net", "_self", "");
			}
		};
		Command confLayout = new Command() {
			public void execute() {
				PopupMessages.layoutPanel();
			}
		};
		Command displayChangelog = new Command() {
			public void execute() {
				PopupMessages.changelogPanel();
			}
		};
		Command reload = new Command() {
			public void execute() {
				GuiModification.reloadGUI();
			}
		};


		// Menu bar items
		aboutMenu.addItem(new MenuItem(imageAbout,true,aboutWindow));
		aboutMenu.addItem(new MenuItem(imageStandard,true,aboutStandard));
		aboutMenu.addItem(new MenuItem(imageEufar,true,launchN7SPPage));
		aboutMenu.addSeparator();
		aboutMenu.addItem(new MenuItem(imageLog,true,displayChangelog));
		fileMenu.addItem(new MenuItem(imageNew,true,newFile));
		fileMenu.addItem(new MenuItem(imageOpen,true,openFile));
		fileMenu.addItem(new MenuItem(imageSave,true,saveFile));
		fileMenu.addItem(new MenuItem(imagePrint,true,printFile));
		fileMenu.addItem(new MenuItem(imageExit,true,exitFile));
		confMenu.addItem(new MenuItem(imageConf,true,confLayout));
		confMenu.addItem(new MenuItem(imageReload,true,reload));
		mainMenu.addItem("File", fileMenu);
		mainMenu.addItem("GUI", confMenu);
		mainMenu.addItem("About", aboutMenu);
		rootLogger.log(Level.INFO, "Menu initialized");


		// Assemble Flight Information panel
		Utilities.populateListBox(fi_operatorText, operatorList, 0);
		Utilities.populateListBox(geoLocationLst, locationList, 0);
		horizontalPanel26.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel27.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel30.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel26.add(fi_operatorText);
		horizontalPanel27.add(fi_aircraftText);
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
		horizontalPanel30.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel30.add(geoLocationLst);
		horizontalPanel30.add(geoFollowImage);
		fiGrid.setWidget(7, 1, horizontalPanel30);
		fiGrid.setWidget(7, 2, geoDetailLst);
		fi_aircraftText.setEnabled(false);
		geoDetailLst.setEnabled(false);
		fi_operatorImage.setStyleName("fi_image");
		fi_aircraftImage.setStyleName("fi_image");
		fi_otherOpsText.setStyleName("fi_textBox");
		fi_otherAiText.setStyleName("fi_textBox");
		geoLocationLst.setStyleName("geoTextList");
		geoDetailLst.setStyleName("geoTextList");
		geoFollowImage.setStyleName("fi_image");
		fi_flightText.setStyleName("fi_textBox");
		fi_campaignText.setStyleName("fi_textBox");
		fi_scientistText.setStyleName("fi_textBox");
		fi_managerText.setStyleName("fi_textBox");
		fi_aircraftText.setStyleName("fi_textList2");
		fi_operatorText.setStyleName("fi_textList2");
		fi_operatorText.setName("operatorText");
		geoLocationLst.setName("localisationText");
		geoDetailLst.setName("countryText");
		fi_aircraftText.setName("aircraftText");
		fi_operatorText.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				GuiModification.aircraftSelection(fi_operatorText.getSelectedItemText());
			}
		});
		geoLocationLst.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				Utilities.geoLocationSet(geoLocationLst.getSelectedIndex());
			}
		});
		rootLogger.log(Level.INFO, "Flight Information panel initialized");


		// Assemble Contact Information panel
		Utilities.populateListBox(ci_roleText, roleList, 0);
		ci_roleText.setName("roleText");
		ciGrid.setWidget(0, 0, ci_nameLabel);
		ciGrid.setWidget(0, 1, ci_nameText);
		ciGrid.setWidget(1, 0, ci_roleLabel);
		ciGrid.setWidget(1, 1, ci_roleText);
		ciGrid.setWidget(2, 0, ci_emailLabel);
		ciGrid.setWidget(2, 1, ci_emailText);
		ci_nameText.setStyleName("fi_textBox");
		ci_emailText.setStyleName("fi_textBox");
		ci_roleText.setStyleName("ci_textList");
		rootLogger.log(Level.INFO, "Contact Information panel initialized");


		// Assemble Scientific Aims panel.
		verticalPanel01.setSpacing(10);
		verticalPanel01.add(sa_satCalval);
		verticalPanel01.add(sa_antPollution);
		verticalPanel01.add(sa_mesoImpacts);
		verticalPanel02.setSpacing(10);
		verticalPanel02.add(sa_cloudLabel);
		verticalPanel02.add(sa_microPhysics);
		verticalPanel02.add(sa_dyNamics);
		verticalPanel02.add(sa_radProperties);
		verticalPanel02.add(sa_convDynamics);
		verticalPanel03.add(verticalPanel01);
		verticalPanel03.add(verticalPanel02);
		verticalPanel04.setSpacing(10);
		verticalPanel04.add(sa_gazChemistry);
		verticalPanel04.add(sa_oxyDants);
		verticalPanel04.add(sa_orgAnics);
		verticalPanel04.add(sa_other1);
		verticalPanel05.setSpacing(10);
		verticalPanel05.add( sa_aeroSol);
		verticalPanel05.add(sa_cloudImpacts);
		verticalPanel05.add(sa_radImpacts);
		verticalPanel06.add(verticalPanel04);
		verticalPanel06.add(verticalPanel05);
		verticalPanel07.setSpacing(10);
		verticalPanel07.add(sa_radIation);
		verticalPanel07.add(sa_atmSpectroscopy);
		verticalPanel07.add(sa_surfProperties);
		verticalPanel07.add(sa_other2);
		verticalPanel08.setSpacing(10);
		verticalPanel08.add(sa_layerLabel);
		verticalPanel08.add(sa_cloud);
		verticalPanel08.add(sa_dynAmics);
		verticalPanel09.add(verticalPanel07);
		verticalPanel09.add(verticalPanel08);
		horizontalPanel01.add(verticalPanel03);
		horizontalPanel01.add(verticalPanel06);
		horizontalPanel01.add(verticalPanel09);
		verticalPanel10.add(horizontalPanel01);
		verticalPanel10.add(new HTML("<br>"));
		horizontalPanel31.add(GuiModification.addCatButton(sa_addCatTable, sa_addCatMap, verticalPanel67));
		horizontalPanel31.add(Elements.addInfoButton("newCheckBox"));
		verticalPanel67.add(horizontalPanel31);
		verticalPanel10.add(verticalPanel67);
		verticalPanel10.add(new HTML("<br>"));
		verticalPanel10.add(new HTML("<br>"));
		horizontalPanel02.add(sa_comments);
		horizontalPanel02.add(sa_comArea);
		verticalPanel10.add(horizontalPanel02);
		verticalPanel08.setStyleName("sa_verticalPanel");
		sa_cloudLabel.setStyleName("gi_titleText2");
		verticalPanel02.setStyleName("sa_verticalPanel");
		verticalPanel04.setStyleName("sa_verticalPanel");
		verticalPanel05.setStyleName("sa_verticalPanel");
		verticalPanel07.setStyleName("sa_verticalPanel");
		sa_layerLabel.setStyleName("gi_titleText2");
		sa_comments.setStyleName("gi_titleText");
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
		sa_comArea.setStyleName("sa_textArea");
		verticalPanel01.getElement().setAttribute("style", "margin-top: 20px !important; margin-left: 20px !important;");
		verticalPanel02.getElement().setAttribute("style", "margin-top: 0px !important; height: 110px !important; width: 300px !important;");
		verticalPanel04.getElement().setAttribute("style", "height: 110px !important; width: 300px !important;");
		verticalPanel05.getElement().setAttribute("style", "margin-top:20px !important; height: 110px !important; width: 300px !important;");
		verticalPanel07.getElement().setAttribute("style", "height: 110px !important; width: 300px !important;");
		verticalPanel08.getElement().setAttribute("style", "margin-top:20px !important; height: 110px !important; width: 300px !important;");
		verticalPanel06.getElement().setAttribute("style", "margin-left: 55px !important;");
		verticalPanel09.getElement().setAttribute("style", "margin-left: 55px !important;");
		rootLogger.log(Level.INFO, "Scientific Aims panel initialized");


		// Assemble Geographic Information panel.
		verticalPanel11.add(gi_boundingLabel);
		gi_boundTable.setCellSpacing(10);
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
		verticalPanel11.add(new HTML("<br>"));
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
		horizontalPanel40.add(GuiModification.addCatButton(gi_addCatTable, gi_addCatMap, verticalPanel68));
		horizontalPanel40.add(Elements.addInfoButton("newCheckBox"));
		verticalPanel68.add(horizontalPanel40);
		verticalPanel11.add(verticalPanel68);
		verticalPanel11.add(new HTML("<br />"));
		horizontalPanel06.add(gi_comLabel);
		horizontalPanel06.add(gi_comArea);
		verticalPanel11.add(horizontalPanel06);
		verticalPanel11.setSpacing(10);
		gi_boundingLabel.setStyleName("gi_titleText");
		gi_northText.setStyleName("gi_textBox");
		gi_southText.setStyleName("gi_textBox");
		gi_westText.setStyleName("gi_textBox2");
		gi_eastText.setStyleName("gi_textBox2");
		gi_minText.setStyleName("gi_textBox");
		gi_maxText.setStyleName("gi_textBox");
		gi_boundTable.setStyleName("gi_boundTab");
		gi_situationLabel.setStyleName("gi_titleText2");
		gi_comLabel.setStyleName("gi_titleText2");
		gi_comArea.setStyleName("sa_textArea");
		horizontalPanel03.getElement().setAttribute("style", "margin-left: 40px !important;");
		verticalPanel15.getElement().setAttribute("style", "margin-left: 20px !important;");
		horizontalPanel05.getElement().setAttribute("style", "margin-left: 40px !important;");
		verticalPanel63.getElement().setAttribute("style", "margin-left: 150px !important;");
		verticalPanel64.getElement().setAttribute("style", "margin-left: 150px !important;");
		verticalPanel65.getElement().setAttribute("style", "margin-left: 150px !important;");
		gi_mmLabel.getElement().setAttribute("style", "margin-left: 210px !important;");
		
		rootLogger.log(Level.INFO, "Geographic Information panel initialized");


		// Assemble Atmospheric Synoptic Features panel
		verticalPanel16.add(af_stationary);
		verticalPanel16.add(af_antiStationary);
		verticalPanel16.add(af_cycloStationary);
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
		horizontalPanel07.add(verticalPanel17);
		verticalPanel18.add(af_orographicInfluence);
		verticalPanel18.add(af_seabreezeFront);
		verticalPanel18.add(af_foldIntrusion);
		verticalPanel18.add(af_convergenceLine);
		verticalPanel18.setSpacing(10);
		horizontalPanel07.add(verticalPanel18);
		verticalPanel19.add(af_easterlyWave);
		verticalPanel19.add(af_equatorialWave);
		verticalPanel19.add(af_tropicalCyclone);
		verticalPanel19.add(af_organizedConvection);
		verticalPanel19.setSpacing(10);
		horizontalPanel07.add(verticalPanel19);
		verticalPanel20.add(horizontalPanel07);
		verticalPanel20.add(new HTML("<br>"));
		horizontalPanel41.add(GuiModification.addCatButton(af_addCatTable, af_addCatMap, verticalPanel69));
		horizontalPanel41.add(Elements.addInfoButton("newCheckBox"));
		verticalPanel69.add(horizontalPanel41);
		verticalPanel20.add(verticalPanel69);
		verticalPanel20.add(new HTML("<br>"));
		horizontalPanel08.add(af_comLabel);
		horizontalPanel08.add(af_comArea);
		verticalPanel20.add(horizontalPanel08);
		af_antiStationary.setStyleName("sa_checkBox");
		af_cycloStationary.setStyleName("sa_checkBox");
		af_comLabel.setStyleName("gi_titleText2");
		af_comArea.setStyleName("sa_textArea");
		verticalPanel17.getElement().setAttribute("style", "margin-left: 50px !important;");
		verticalPanel18.getElement().setAttribute("style", "margin-left: 50px !important;");
		verticalPanel19.getElement().setAttribute("style", "margin-left: 50px !important;");
		rootLogger.log(Level.INFO, "Atmospheric Synoptic Features panel initialized");


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
		horizontalPanel09.add(verticalPanel22);
		verticalPanel23.add(ct_cumulTower);
		verticalPanel23.add(ct_altoStracumul);
		verticalPanel23.add(ct_waveClouds);
		verticalPanel23.setSpacing(10);
		horizontalPanel09.add(verticalPanel23);
		verticalPanel24.add(ct_statiformClouds);
		verticalPanel24.add(ct_freeAbove);
		verticalPanel24.add(ct_freeBelow);
		verticalPanel24.setSpacing(10);
		horizontalPanel09.add(verticalPanel24);
		verticalPanel25.add(horizontalPanel09);
		verticalPanel25.add(new HTML("<br>"));
		horizontalPanel42.add(GuiModification.addCatButton(ct_addCatTable, ct_addCatMap, verticalPanel70));
		horizontalPanel42.add(Elements.addInfoButton("newCheckBox"));
		verticalPanel70.add(horizontalPanel42);
		verticalPanel25.add(verticalPanel70);
		verticalPanel25.add(new HTML("<br>"));
		horizontalPanel10.add(ct_comLabel);
		horizontalPanel10.add(ct_comArea);
		verticalPanel25.add(horizontalPanel10);
		ct_comLabel.setStyleName("gi_titleText2");
		ct_comArea.setStyleName("sa_textArea");
		verticalPanel22.getElement().setAttribute("style", "margin-left: 60px !important;");
		verticalPanel23.getElement().setAttribute("style", "margin-left: 60px !important;");
		verticalPanel24.getElement().setAttribute("style", "margin-left: 60px !important;");
		rootLogger.log(Level.INFO, "Cloud Types and Forms Sampled During Flight panel initialized");


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
		horizontalPanel11.add(verticalPanel27);
		verticalPanel28.add(cp_saltAerosol);
		verticalPanel28.add(cp_continentalAerosol);
		verticalPanel28.add(cp_urbanPlume);
		verticalPanel28.setSpacing(10);
		horizontalPanel11.add(verticalPanel28);
		verticalPanel29.add(cp_biomassBurning);
		verticalPanel29.add(cp_desertDust);
		verticalPanel29.add(cp_volcanicAsh);
		verticalPanel29.setSpacing(10);
		horizontalPanel11.add(verticalPanel29);
		verticalPanel30.add(horizontalPanel11);
		verticalPanel30.add(new HTML("<br>"));
		horizontalPanel43.add(GuiModification.addCatButton(cp_addCatTable, cp_addCatMap, verticalPanel71));
		horizontalPanel43.add(Elements.addInfoButton("newCheckBox"));
		verticalPanel71.add(horizontalPanel43);
		verticalPanel30.add(verticalPanel71);
		verticalPanel30.add(new HTML("<br>"));
		horizontalPanel12.add(cp_comLabel);
		horizontalPanel12.add(cp_comArea);
		verticalPanel30.add(horizontalPanel12);
		cp_comLabel.setStyleName("gi_titleText2");
		cp_comArea.setStyleName("sa_textArea");
		verticalPanel27.getElement().setAttribute("style", "margin-left: 115px !important;");
		verticalPanel28.getElement().setAttribute("style", "margin-left: 115px !important;");
		verticalPanel29.getElement().setAttribute("style", "margin-left: 115px !important;");
		rootLogger.log(Level.INFO, "Cloud, Precipitation and Aerosol Particles Sampled panel initialized");


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
		verticalPanel35.add(new HTML("<br>"));
		horizontalPanel44.add(GuiModification.addCatButton(lo_addCatTable, lo_addCatMap, verticalPanel72));
		horizontalPanel44.add(Elements.addInfoButton("newCheckBox"));
		verticalPanel72.add(horizontalPanel44);
		verticalPanel35.add(verticalPanel72);
		verticalPanel35.add(new HTML("<br>"));
		horizontalPanel14.add(lo_comLabel);
		horizontalPanel14.add(lo_comArea);
		verticalPanel35.add(horizontalPanel14);
		lo_comLabel.setStyleName("gi_titleText2");
		lo_comArea.setStyleName("sa_textArea");
		verticalPanel32.getElement().setAttribute("style", "margin-left:190px !important;");
		verticalPanel33.getElement().setAttribute("style", "margin-left:190px !important;");
		verticalPanel34.getElement().setAttribute("style", "margin-left:190px !important;");
		rootLogger.log(Level.INFO, "Land or Oceans Surfaces Overflown panel initialized");


		// Assemble Altitude Range of Measurement panel
		verticalPanel36.add(ar_boundaryLayer);
		horizontalPanel48.add(ar_subCloud);
		horizontalPanel48.add(ar_nearSurface);
		verticalPanel36.add(horizontalPanel48);
		verticalPanel36.add(ar_inCloud);
		verticalPanel36.setSpacing(10);
		horizontalPanel15.add(verticalPanel36);
		verticalPanel37.add(ar_upperTroposphere);
		verticalPanel37.add(ar_midTroposphere);
		verticalPanel37.setSpacing(10);
		horizontalPanel15.add(verticalPanel37);
		verticalPanel79.add(ar_lowerTroposphere);
		verticalPanel79.add(ar_lowerstratosphere);
		verticalPanel79.setSpacing(10);
		horizontalPanel15.add(verticalPanel79);
		verticalPanel38.add(horizontalPanel15);
		verticalPanel38.add(new HTML("<br>"));
		horizontalPanel45.add(GuiModification.addCatButton(ar_addCatTable, ar_addCatMap, verticalPanel73));
		horizontalPanel45.add(Elements.addInfoButton("newCheckBox"));
		verticalPanel73.add(horizontalPanel45);
		verticalPanel38.add(verticalPanel73);
		verticalPanel38.add(new HTML("<br>"));
		horizontalPanel16.add(ar_comLabel);
		horizontalPanel16.add(ar_comArea);
		verticalPanel38.add(horizontalPanel16);
		ar_inCloud.setStyleName("sa_checkBox");
		ar_subCloud.setStyleName("sa_checkBox");
		ar_nearSurface.setStyleName("sa_checkBox2");
		ar_comLabel.setStyleName("gi_titleText2");
		ar_comArea.setStyleName("sa_textArea");
		verticalPanel37.getElement().setAttribute("style", "margin-left:200px !important;");
		verticalPanel79.getElement().setAttribute("style", "margin-left:200px !important;");
		rootLogger.log(Level.INFO, "Altitude Range of Measurement panel initialized");


		// Assemble Types of Flight Manoeuvre panel
		verticalPanel39.add(fm_levelRuns);
		verticalPanel39.add(fm_stacked);
		verticalPanel39.add(fm_separated);
		verticalPanel39.setSpacing(10);
		horizontalPanel17.add(verticalPanel39);
		verticalPanel40.add(fm_racetracks);
		verticalPanel40.add(fm_orbits);
		verticalPanel40.setSpacing(10);
		horizontalPanel17.add(verticalPanel40);
		verticalPanel77.add(fm_lagrangianDescents);
		verticalPanel77.add(fm_ascDescents);
		verticalPanel77.setSpacing(10);
		horizontalPanel17.add(verticalPanel77);
		verticalPanel78.add(fm_dropsondeDeployed);
		verticalPanel78.add(fm_selfCalibration);
		verticalPanel78.setSpacing(10);
		horizontalPanel17.add(verticalPanel78);
		verticalPanel41.add(horizontalPanel17);
		horizontalPanel46.add(GuiModification.addCatButton(fm_addCatTable, fm_addCatMap, verticalPanel74));
		horizontalPanel46.add(Elements.addInfoButton("newCheckBox"));
		verticalPanel74.add(horizontalPanel46);
		verticalPanel41.add(verticalPanel74);
		verticalPanel41.add(new HTML("<br>"));
		horizontalPanel18.add(fm_comLabel);
		horizontalPanel18.add(fm_comArea);
		verticalPanel41.add(horizontalPanel18);
		fm_separated.setStyleName("sa_checkBox");
		fm_stacked.setStyleName("sa_checkBox");
		fm_comLabel.setStyleName("gi_titleText2");
		fm_comArea.setStyleName("sa_textArea");
		verticalPanel40.getElement().setAttribute("style", "margin-left:105px !important;");
		verticalPanel77.getElement().setAttribute("style", "margin-left:105px !important;");
		verticalPanel78.getElement().setAttribute("style", "margin-left:105px !important;");
		rootLogger.log(Level.INFO, "Types of Flight Manoeuvre panel initialized");


		// Assemble Satellite Coordination panel
		verticalPanel42.add(sc_polarLabel);
		verticalPanel42.add(sc_atrain);
		verticalPanel42.add(sc_metop);
		verticalPanel42.add(sc_npoess);
		verticalPanel42.add(sc_other);
		verticalPanel42.setSpacing(10);
		horizontalPanel19.add(verticalPanel42);
		verticalPanel43.add(sc_geosynchLabel);
		verticalPanel43.add(sc_msg);
		verticalPanel43.add(sc_other2);
		verticalPanel43.setSpacing(10);
		horizontalPanel19.add(verticalPanel43);
		verticalPanel44.add(sc_airs);
		verticalPanel44.add(sc_amsuMhs);
		verticalPanel44.add(sc_caliop);
		verticalPanel44.add(sc_cloudsat);
		verticalPanel44.setSpacing(10);
		horizontalPanel19.add(verticalPanel44);
		verticalPanel45.add(sc_cris);
		verticalPanel45.add(sc_iasi);
		verticalPanel45.add(sc_modis);
		verticalPanel45.setSpacing(10);
		horizontalPanel19.add(verticalPanel45);
		verticalPanel47.add(horizontalPanel19);
		verticalPanel47.add(new HTML("<br>"));
		horizontalPanel47.add(GuiModification.addCatButton(sc_addCatTable, sc_addCatMap, verticalPanel75));
		horizontalPanel47.add(Elements.addInfoButton("newCheckBox"));
		verticalPanel75.add(horizontalPanel47);
		verticalPanel47.add(verticalPanel75);
		verticalPanel47.add(new HTML("<br>"));
		horizontalPanel20.add(sc_comLabel);
		horizontalPanel20.add(sc_comArea);
		verticalPanel47.add(horizontalPanel20);
		sc_other2.setStyleName("sa_checkBox");
		verticalPanel43.setStyleName("sa_verticalPanel");
		sc_msg.setStyleName("sa_checkBox");
		sc_geosynchLabel.setStyleName("gi_titleText2");
		sc_other.setStyleName("sa_checkBox");
		sc_polarLabel.setStyleName("gi_titleText2");
		sc_metop.setStyleName("sa_checkBox");
		sc_npoess.setStyleName("sa_checkBox");
		sc_atrain.setStyleName("sa_checkBox");
		verticalPanel42.setStyleName("sa_verticalPanel");
		sc_comLabel.setStyleName("gi_titleText2");
		sc_comArea.setStyleName("sa_textArea");
		verticalPanel42.getElement().setAttribute("style", "width: 200px !important;");
		verticalPanel43.getElement().setAttribute("style", "width: 220px !important; margin-left: 120px !important;");
		verticalPanel44.getElement().setAttribute("style", "margin-left:120px !important; margin-top: 20px !important;");
		verticalPanel45.getElement().setAttribute("style", "margin-left:120px !important; margin-top: 20px !important;");
		rootLogger.log(Level.INFO, "Satellite Coordination panel initialized");


		// Assemble Supporting Surface-based Observations panel
		horizontalPanel21.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel21.add(so_groundSitesLabel);
		horizontalPanel21.add(so_groundSitesBox);
		horizontalPanel21.add(Utilities.addListButton(so_groundSitesTable, so_groundSitesBox, so_groundSitesList));
		verticalPanel48.add(horizontalPanel21);
		verticalPanel49.add(so_groundSitesTable);
		verticalPanel48.add(verticalPanel49);
		so_groundSitesTable.getColumnFormatter().setWidth(1, "40px");
		verticalPanel50.add(verticalPanel48);
		horizontalPanel22.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel22.add(so_researchVesselsLabel);
		horizontalPanel22.add(so_researchVesselsBox);
		horizontalPanel22.add(Utilities.addListButton(so_researchVesselsTable, so_researchVesselsBox, so_researchVesselsList));
		verticalPanel51.add(horizontalPanel22);
		verticalPanel52.add(so_researchVesselsTable);
		verticalPanel51.add(verticalPanel52);
		so_researchVesselsTable.getColumnFormatter().setWidth(1, "40px");
		verticalPanel50.add(verticalPanel51);
		horizontalPanel23.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel23.add(so_armSitesLabel);
		horizontalPanel23.add(so_armSitesBox);
		horizontalPanel23.add(Utilities.addListButton(so_armSitesTable, so_armSitesBox, so_armSitesList));
		verticalPanel53.add(horizontalPanel23);
		verticalPanel54.add(so_armSitesTable);
		verticalPanel53.add(verticalPanel54);
		so_armSitesTable.getColumnFormatter().setWidth(1, "40px");
		verticalPanel55.add(verticalPanel53);
		horizontalPanel24.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel24.add(so_mobileSitesLabel);
		horizontalPanel24.add(so_mobileSitesBox);
		horizontalPanel24.add(Utilities.addListButton(so_mobileSitesTable, so_mobileSitesBox, so_mobileSitesList));
		verticalPanel56.add(horizontalPanel24);
		verticalPanel57.add(so_mobileSitesTable);
		verticalPanel56.add(verticalPanel57);
		so_mobileSitesTable.getColumnFormatter().setWidth(1, "40px");
		verticalPanel55.add(verticalPanel56);
		horizontalPanel25.add(verticalPanel50);
		horizontalPanel25.add(verticalPanel55);
		verticalPanel61.add(horizontalPanel25);
		verticalPanel51.getElement().setAttribute("style", "margin-top:30px !important;");
		verticalPanel50.getElement().setAttribute("style", "margin-left:80px !important;");
		so_researchVesselsTable.setStyleName("flexTable");
		so_groundSitesBox.setStyleName("so_textBox");
		verticalPanel49.setStyleName("so_verticalPanel");
		so_groundSitesTable.setStyleName("flexTable");
		so_researchVesselsBox.setStyleName("so_textBox");
		verticalPanel52.setStyleName("so_verticalPanel");
		so_armSitesBox.setStyleName("so_textBox");
		verticalPanel54.setStyleName("so_verticalPanel");
		so_armSitesTable.setStyleName("flexTable");
		so_mobileSitesBox.setStyleName("so_textBox");
		verticalPanel57.setStyleName("so_verticalPanel");
		so_mobileSitesTable.setStyleName("flexTable");
		so_groundSitesBox.setName("groundsite1");
		so_researchVesselsBox.setName("groundsite2");
		so_armSitesBox.setName("groundsite3");
		so_mobileSitesBox.setName("groundsite4");
		verticalPanel48.getElement().setAttribute("style", "margin-top:10px !important;");
		verticalPanel53.getElement().setAttribute("style", "margin-top:10px !important;");
		verticalPanel55.getElement().setAttribute("style", "margin-left:160px !important;");
		verticalPanel56.getElement().setAttribute("style", "margin-top:30px !important;");
		rootLogger.log(Level.INFO, "Supporting Surface-based Observations panel initialized");
		

		// Assemble Additional Notes on the Flight panel
		verticalPanel66.add(nf_comArea);
		nf_comArea.setStyleName("sa_textArea");
		nf_comArea.getElement().setAttribute("style", "margin-top: 20px; width: 1016px;");
		rootLogger.log(Level.INFO, "Additional Notes on the Flight panel initialized...");
		
		
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
					PopupMessages.uploadImage();
				}
			});
		urlButton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					PopupMessages.uploadImageURL();
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
		rootLogger.log(Level.INFO, "Image Uploading panel initialized");
		
		
		// Screen size detection
		int screenHeight = Utilities.getScreenHeight();
		int screenWidth = Utilities.getScreenWidth();
		float ratio = (float) screenWidth / screenHeight;
		if (screenHeight < 1050 & ratio > 1.5 & ratio < 1.8) {
			GuiModification.changeLayout();
		} 
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
			stackPanel.addSelectionHandler(new SelectionHandler<Integer>() {
				@Override
				public void onSelection(SelectionEvent<Integer> event) {
					int selectedWidgetIndex = stackPanel.getVisibleIndex();
					rootLogger.log(Level.INFO, "Selected tab index: " + Integer.toString(selectedWidgetIndex));
					
				}
			});
			
			
			// Associate the Main panel with the HTML host page.
			int screen_width = Window.getClientWidth();
			int screen_height = Window.getClientHeight();
			int expandPanel = 0;
			expandPanel = (screen_width - 1166)/2;
			if (expandPanel < 0) {
				expandPanel = 0;
			}
			subDockPanel.addNorth(new HTML("<img src='icons/asmm_top.jpg' alt='ASMM Creator' height='80px' width='1166px'>"), 80);
			subDockPanel.addNorth(mainMenu, 30);
			dockPanel.addEast(new HTML("<img src='icons/asmm_shadowr.png' alt='ASMM Creator' width='30px' height='" + screen_height + "' align='left'"
					+ ">"), expandPanel);
			dockPanel.addWest(new HTML("<img src='icons/asmm_shadowl.png' alt='ASMM Creator' width='30px' height='" + screen_height + "' align='right"
					+ "'>"), expandPanel);
			dockPanel.setStyleName("dockPanel");
			subDockPanel.add(stackPanel);
			dockPanel.add(subDockPanel);
			RootLayoutPanel.get().add(dockPanel);
		}
		rootLogger.log(Level.INFO, "Main panel initialized");

		
		// Associate textboxes with an eventHandler
		List<TextBoxBase> allTextBox = $("*", subDockPanel).widgets(TextBoxBase.class);
		for (int i = 0; i < allTextBox.size(); i++) {
			allTextBox.get(i).addChangeHandler(new ChangeHandler() {
				@Override
				public void onChange(ChangeEvent event) {
					Utilities.docIsModified();
				}
			});
		}


		// Associate checkboxes with an eventHandler
		List<CheckBox> allCheckBoxes = $("*", subDockPanel).widgets(CheckBox.class);
		for (int i = 0; i < allCheckBoxes.size(); i++) {
			allCheckBoxes.get(i).addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					Utilities.docIsModified();
				}
			});
		}


		// Associate listboxes with an evenHandler
		List<ListBox> allListBoxes = $("*", subDockPanel).widgets(ListBox.class);
		for (int i = 0; i < allListBoxes.size(); i++) {
			allListBoxes.get(i).addChangeHandler(new ChangeHandler() {
				@Override
				public void onChange(ChangeEvent event) {
					Utilities.docIsModified();
				}
			});
		}


		// Associate dateboxes with an eventHandler
		List<DateBox> allDateBoxes = $("*", subDockPanel).widgets(DateBox.class);
		for (int i = 0; i < allDateBoxes.size(); i++) {
			allDateBoxes.get(i).addValueChangeHandler(new ValueChangeHandler<Date>() {
				@Override
				public void onValueChange(ValueChangeEvent<Date> event) {
					Utilities.docIsModified();
				}
			});
		}
		rootLogger.log(Level.INFO, "ASMM GUI fully initialized...");
		
		
		// Internet Explorer warning
		if (Navigator.getUserAgent().toLowerCase().contains("msie") || Navigator.getUserAgent().toLowerCase().contains("trident")) {
			rootLogger.log(Level.INFO, "IE detected.");
			PopupMessages.explorerPanel();
		}
		
		
		// question before exiting if the document has been modified
		Window.addWindowClosingHandler(new Window.ClosingHandler() {
			public void onWindowClosing(Window.ClosingEvent closingEvent) {
				if (isModified) {
					closingEvent.setMessage("Are you sure?");
				}
			}
		});
	}	
		
	
	// error catch
	public Throwable unwrap(Throwable e) {
		if(e instanceof UmbrellaException) {
			UmbrellaException ue = (UmbrellaException) e;
			if(ue.getCauses().size() == 1) {
				return unwrap(ue.getCauses().iterator().next());
			}
		}
		return e;
	}
}
