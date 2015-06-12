package com.eufar.asmm.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import static com.google.gwt.query.client.GQuery.$;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.xml.client.DOMException;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;


public class Asmm_eufar implements EntryPoint {
	  
	  // Main window items initialization
	  private MenuBar mainMenu = new MenuBar();
	  private MenuBar aboutMenu = new MenuBar(true);
	  private MenuBar fileMenu = new MenuBar(true);
	  private DockLayoutPanel dockPanel = new DockLayoutPanel(Unit.PX);
	  private DockLayoutPanel subDockPanel = new DockLayoutPanel(Unit.PX);
	  private StackLayoutPanel stackPanel = new StackLayoutPanel(Unit.EM);
	  private String myFileName = new String("");
	  private String creationDate = new String(DateTimeFormat.getFormat("yyyy-MM-dd").format(new Date()));
	  private String revisionDate = new String(DateTimeFormat.getFormat("yyyy-MM-dd").format(new Date()));
	  private String asmmVersion = new String("v0.9.6");
	  private String xmlVersion = new String("v1.0a");
	  
	  
	  // Menu items initialization
	  private String imageNew = "<img src='icons/new_icon_menu.png'> New...</img>";
	  private String imageOpen = "<img src='icons/open_icon_menu.png'> Open...</img>";
	  private String imageSave = "<img src='icons/save_icon_menu.png'> Save...</img>";
	  private String imagePrint = "<img src='icons/print_icon_menu.png'> Print...</img>";
	  private String imageAbout = "<img src='icons/about_icon_menu.png'> ASMM Creator...</img>";
	  private String imageStandard = "<img src='icons/changelog_icon_menu.png'> ASMM XML Standard...</img>";
	  private String imageEufar = "<img src='icons/eufar_icon_menu.png'> EUFAR N7SP (link)</img>";
	  private String imageExit = "<img src='icons/exit_icon_menu.png'> Exit...</img>";
	  
	  
	  // Flight Information items initialization
	  private FlexTable fiGrid = new FlexTable();
	  private ScrollPanel fiScroll = new ScrollPanel(fiGrid);
	  private Label fi_flightLabel = new Label("Flight Number:");
	  private TextBox fi_flightText = new TextBox();
	  private Label fi_dateLabel = new Label("Date (yyyy-mm-dd):");
	  private DateBox fi_dateText = new DateBox();
	  private Label fi_campaignLabel = new Label("Campaign:");
	  private TextBox fi_campaignText = new TextBox();
	  private Label fi_scientistLabel = new Label("Mission Scientist:");
	  private TextBox fi_scientistText = new TextBox();
	  private Label fi_managerLabel = new Label("Flight Manager:");
	  private TextBox fi_managerText = new TextBox();
	  private Label fi_aircraftLabel = new Label("Platform/Aircraft:");
	  private TextBox fi_aircraftText = new TextBox();
	  private Label fi_operatorLabel = new Label("Operator:");
	  private TextBox fi_operatorText = new TextBox();
	  private Label fi_countryLabel = new Label("Country:");
	  private TextBox fi_countryText = new TextBox();
	  
	  
	  // Contact Information items initialization
	  private FlexTable ciGrid = new FlexTable();
	  private ScrollPanel ciScroll = new ScrollPanel(ciGrid);  
	  private Label ci_nameLabel = new Label("Name:");
	  private TextBox ci_nameText = new TextBox();
	  private Label ci_roleLabel = new Label("Role:");
	  private ListBox ci_roleText = new ListBox();
	  private Label ci_emailLabel = new Label("Email:");
	  private TextBox ci_emailText = new TextBox();
	  private ArrayList<String> ci_roleList = new ArrayList<String>();
	  
	  
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
	  private HorizontalPanel horizontalPanel01 = new HorizontalPanel();
	  private HorizontalPanel horizontalPanel02 = new HorizontalPanel();
	  private Label sa_cloudLabel = new Label("Cloud:");
	  private Label sa_layerLabel = new Label("Boundary-layer:");
	  private Label sa_comments = new Label("Comments:");
	  private TreeMap<String, String> scientificMap = new TreeMap<String, String>();
	  private TextArea sa_comArea = new TextArea();
	  private VerticalPanel verticalPanel67 = new VerticalPanel();
	  private TreeMap<String, String> sa_addCatMap = new TreeMap<String, String>();
	  private FlexTable sa_addCatTable = new FlexTable();
	  private ScrollPanel saScroll = new ScrollPanel(verticalPanel10);  
	  
	  
	  // Geographical Information items initialization
	  private VerticalPanel verticalPanel11 = new VerticalPanel();
	  private VerticalPanel verticalPanel12 = new VerticalPanel();
	  private VerticalPanel verticalPanel13 = new VerticalPanel();
	  private VerticalPanel verticalPanel14 = new VerticalPanel();
	  private VerticalPanel verticalPanel15 = new VerticalPanel();
	  private VerticalPanel verticalPanel62 = new VerticalPanel();
	  private VerticalPanel verticalPanel63 = new VerticalPanel();
	  private VerticalPanel verticalPanel64 = new VerticalPanel();
	  private VerticalPanel verticalPanel65 = new VerticalPanel();
	  private VerticalPanel verticalPanel68 = new VerticalPanel();
	  private HorizontalPanel horizontalPanel03 = new HorizontalPanel();
	  private HorizontalPanel horizontalPanel04 = new HorizontalPanel();
	  private HorizontalPanel horizontalPanel05 = new HorizontalPanel();
	  private HorizontalPanel horizontalPanel06 = new HorizontalPanel();
	  private Label gi_boundingLabel = new Label("Geographic Bounding Box:");
	  private Label gi_nsLabel = new Label("North/South Latitude:");
	  private Label gi_weLabel = new Label("West/East Latitude:");
	  private Label gi_mmLabel = new Label("Min/Max Altitude (m):");
	  private Label gi_comLabel = new Label("Comments:");
	  private TextArea gi_comArea = new TextArea();
	  //private PushButton gi_coordButton = new PushButton("Read bounding box information from NetCDF");
	  private Label gi_situationLabel = new Label("Geographic Situation:");
	  private TextBox gi_northText = new TextBox();
	  private TextBox gi_southText = new TextBox();
	  private TextBox gi_westText = new TextBox();
	  private TextBox gi_eastText = new TextBox();
	  private TextBox gi_minText = new TextBox();
	  private TextBox gi_maxText = new TextBox();
	  private TreeMap<String, String> geographicMap = new TreeMap<String, String>();
	  private TreeMap<String, String> gi_addCatMap = new TreeMap<String, String>();
	  private FlexTable gi_addCatTable = new FlexTable();
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
	  private Label af_comLabel = new Label("Comments:");
	  private TextArea af_comArea = new TextArea();
	  private TreeMap<String, String> synopticMap = new TreeMap<String, String>();
	  private TreeMap<String, String> af_addCatMap = new TreeMap<String, String>();
	  private FlexTable af_addCatTable = new FlexTable();
	  private ScrollPanel afScroll = new ScrollPanel(verticalPanel20);
	  
	  
	  // Cloud Types and Forms Sampled During Flight items initialization
	  private VerticalPanel verticalPanel21 = new VerticalPanel();
	  private VerticalPanel verticalPanel22 = new VerticalPanel();
	  private VerticalPanel verticalPanel23 = new VerticalPanel();
	  private VerticalPanel verticalPanel24 = new VerticalPanel();
	  private VerticalPanel verticalPanel25 = new VerticalPanel();
	  private HorizontalPanel horizontalPanel09 = new HorizontalPanel();
	  private HorizontalPanel horizontalPanel10 = new HorizontalPanel();
	  private Label ct_comLabel = new Label("Comments:");
	  private TextArea ct_comArea = new TextArea();
	  private TreeMap<String, String> cloudMap = new TreeMap<String, String>();
	  private TreeMap<String, String> ct_addCatMap = new TreeMap<String, String>();
	  private FlexTable ct_addCatTable = new FlexTable();
	  private VerticalPanel verticalPanel70 = new VerticalPanel();
	  private ScrollPanel ctScroll = new ScrollPanel(verticalPanel25);
	  
	  
	  // Cloud, Precipitation and Aerosol Particles Sampled items initialization
	  private VerticalPanel verticalPanel26 = new VerticalPanel();
	  private VerticalPanel verticalPanel27 = new VerticalPanel();
	  private VerticalPanel verticalPanel28 = new VerticalPanel();
	  private VerticalPanel verticalPanel29 = new VerticalPanel();
	  private VerticalPanel verticalPanel30 = new VerticalPanel();
	  private HorizontalPanel horizontalPanel11 = new HorizontalPanel();
	  private HorizontalPanel horizontalPanel12 = new HorizontalPanel();
	  private Label cp_comLabel = new Label("Comments:");
	  private TextArea cp_comArea = new TextArea();
	  private TreeMap<String, String> cpapMap = new TreeMap<String, String>();
	  private TreeMap<String, String> cp_addCatMap = new TreeMap<String, String>();
	  private FlexTable cp_addCatTable = new FlexTable();
	  private VerticalPanel verticalPanel71 = new VerticalPanel();
	  private ScrollPanel cpScroll = new ScrollPanel(verticalPanel30);
	  
	  
	  // Land or Oceans Surfaces Overflown items initialization
	  private VerticalPanel verticalPanel31 = new VerticalPanel();
	  private VerticalPanel verticalPanel32 = new VerticalPanel();
	  private VerticalPanel verticalPanel33 = new VerticalPanel();
	  private VerticalPanel verticalPanel34 = new VerticalPanel();
	  private VerticalPanel verticalPanel35 = new VerticalPanel();
	  private HorizontalPanel horizontalPanel13 = new HorizontalPanel();
	  private HorizontalPanel horizontalPanel14 = new HorizontalPanel();
	  private Label lo_comLabel = new Label("Comments:");
	  private TextArea lo_comArea = new TextArea();
	  private TreeMap<String, String> surfacesMap = new TreeMap<String, String>();
	  private TreeMap<String, String> lo_addCatMap = new TreeMap<String, String>();
	  private FlexTable lo_addCatTable = new FlexTable();
	  private VerticalPanel verticalPanel72 = new VerticalPanel();
	  private ScrollPanel loScroll = new ScrollPanel(verticalPanel35);
	  
	  
	  // Altitude Range of Measurement items initialization
	  private VerticalPanel verticalPanel36 = new VerticalPanel();
	  private VerticalPanel verticalPanel37 = new VerticalPanel();
	  private VerticalPanel verticalPanel38 = new VerticalPanel();
	  private HorizontalPanel horizontalPanel15 = new HorizontalPanel();
	  private HorizontalPanel horizontalPanel16 = new HorizontalPanel();
	  private Label ar_comLabel = new Label("Comments:");
	  private TextArea ar_comArea = new TextArea();
	  private TreeMap<String, String> measurementMap = new TreeMap<String, String>();
	  private TreeMap<String, String> ar_addCatMap = new TreeMap<String, String>();
	  private FlexTable ar_addCatTable = new FlexTable();
	  private VerticalPanel verticalPanel73 = new VerticalPanel();
	  private ScrollPanel arScroll = new ScrollPanel(verticalPanel38);
	  
	  
	  // Types of Flight Manoeuvre items initialization
	  private VerticalPanel verticalPanel39 = new VerticalPanel();
	  private VerticalPanel verticalPanel40 = new VerticalPanel();
	  private VerticalPanel verticalPanel41 = new VerticalPanel();
	  private HorizontalPanel horizontalPanel17 = new HorizontalPanel();
	  private HorizontalPanel horizontalPanel18 = new HorizontalPanel();
	  private Label fm_comLabel = new Label("Comments:");
	  private TextArea fm_comArea = new TextArea();
	  private TreeMap<String, String> manoeuvreMap = new TreeMap<String, String>();
	  private TreeMap<String, String> fm_addCatMap = new TreeMap<String, String>();
	  private FlexTable fm_addCatTable = new FlexTable();
	  private VerticalPanel verticalPanel74 = new VerticalPanel();
	  private ScrollPanel fmScroll = new ScrollPanel(verticalPanel41);
	  
	  
	  // Satellite Coordination items initialization
	  private VerticalPanel verticalPanel42 = new VerticalPanel();
	  private VerticalPanel verticalPanel43 = new VerticalPanel();
	  private VerticalPanel verticalPanel44 = new VerticalPanel();
	  private VerticalPanel verticalPanel45 = new VerticalPanel();
	  private VerticalPanel verticalPanel46 = new VerticalPanel();
	  private VerticalPanel verticalPanel47 = new VerticalPanel();
	  private HorizontalPanel horizontalPanel19 = new HorizontalPanel();
	  private HorizontalPanel horizontalPanel20 = new HorizontalPanel();
	  private Label sc_polarLabel = new Label("Polar:");
	  private Label sc_geosynchLabel = new Label("Geosynch:");
	  private Label sc_comLabel = new Label("Comments:");
	  private TextArea sc_comArea = new TextArea();
	  private TreeMap<String, String> satelliteMap = new TreeMap<String, String>();
	  private TreeMap<String, String> sc_addCatMap = new TreeMap<String, String>();
	  private FlexTable sc_addCatTable = new FlexTable();
	  private VerticalPanel verticalPanel75 = new VerticalPanel();
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
	  
	  
	  public void onModuleLoad() {
		  	
		  	// Preparation of few objects
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
			geographicMap.put("Mid-Latitudes","midLatitudes");
			geographicMap.put("Sub-Tropical","subTropical");
			geographicMap.put("Tropical","tropical");
			geographicMap.put("Maritime","maritime");
			geographicMap.put("Continental","continental");
			geographicMap.put("Oceanic Islands","oceanicIslands");
			geographicMap.put("Other","other");
			
			synopticMap.put("Stationary","stationary");
			synopticMap.put("Anticyclonic","stationaryAnticyclonic");
			synopticMap.put("Cyclonic","stationaryCyclonic");
			synopticMap.put("Warm Front","warmFront");
			synopticMap.put("Warm conveyor belt","warmConveyorBelt");
			synopticMap.put("Cold Front","coldFront");
			synopticMap.put("Occluded Front","occludedFront");
			synopticMap.put("Warm Sector","warmSector");
			synopticMap.put("Post-cold-frontal air-mass","postColdFrontalAirMass");
			synopticMap.put("Arctic cold-air Outbreak","arcticColdAirOutbreak");
			synopticMap.put("Orographic Influence","orographicInfluence");
			synopticMap.put("Sea-breeze Front","seaBreezeFront");
			synopticMap.put("Stratospheric fold/intrusion","stratosphericFold");
			synopticMap.put("Extended convergence line","extendedConvergenceLine");
			synopticMap.put("Easterly Wave","easterlyWave");
			synopticMap.put("Equatorial Wave","equatorialWave");
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
			cpapMap.put("Continental Aerosol","continentalAerosol");
			cpapMap.put("Urban plume","urbanPlume");
			cpapMap.put("Biomass Burning","biomassBurning");
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
			
	      	
	      	// Commands in the menu bar
		  	Command aboutWindow = new Command() {
		  			public void execute() {aboutWindow();}
			};
			Command aboutStandard = new Command() {
	  			public void execute() {aboutStandard();}
			};
			Command newFile = new Command() {
					public void execute() {newFile();}
			};
			Command openFile = new Command() {
					public void execute() {openFile();}
			};
			Command saveFile = new Command() {
					public void execute() {saveFile();}
			};
			Command printFile = new Command() {
					public void execute() {printFile();}
			};
			Command launchN7SPPage = new Command()  {
					public void execute() {Window.open("http://www.eufar.net/N6SP", "_blank", "");}
			};
			Command exitFile = new Command()  {
				public void execute() {Window.open("http://www.eufar.net", "_self", "");}
			};
			
			
		  	// Menu bar items
			aboutMenu.addItem(new MenuItem(imageAbout,true,aboutWindow));
			aboutMenu.addItem(new MenuItem(imageStandard,true,aboutStandard));
			aboutMenu.addItem(new MenuItem(imageEufar,true,launchN7SPPage));
			fileMenu.addItem(new MenuItem(imageNew,true,newFile));
			fileMenu.addItem(new MenuItem(imageOpen,true,openFile));
			fileMenu.addItem(new MenuItem(imageSave,true,saveFile));
			fileMenu.addItem(new MenuItem(imagePrint,true,printFile));
			fileMenu.addItem(new MenuItem(imageExit,true,exitFile));
			mainMenu.addItem("File", fileMenu);
			mainMenu.addItem("About...", aboutMenu);
			

		    // Assemble Flight Information panel.
		    fiGrid.setWidget(0, 0, fi_flightLabel);
			fiGrid.setWidget(0, 1, fi_flightText);
			fiGrid.setWidget(1, 0, fi_dateLabel);
			fi_dateText.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("yyyy-MM-dd")));
	      	fi_dateText.setValue(new Date());
			fiGrid.setWidget(1, 1, fi_dateText);
			fiGrid.setWidget(2, 0, fi_campaignLabel);
			fiGrid.setWidget(2, 1, fi_campaignText);
			fiGrid.setWidget(3, 0, fi_scientistLabel);
			fiGrid.setWidget(3, 1, fi_scientistText);
			fiGrid.setWidget(4, 0, fi_managerLabel);
			fiGrid.setWidget(4, 1, fi_managerText);
			fiGrid.setWidget(5, 0, fi_aircraftLabel);
			fiGrid.setWidget(5, 1, fi_aircraftText);
			fiGrid.setWidget(6, 0, fi_operatorLabel);
			fiGrid.setWidget(6, 1, fi_operatorText);
			fiGrid.setWidget(7, 0, fi_countryLabel);
			fiGrid.setWidget(7, 1, fi_countryText);
			fi_flightText.setStyleName("fi_textBox");
			fi_campaignText.setStyleName("fi_textBox");
			fi_scientistText.setStyleName("fi_textBox");
			fi_managerText.setStyleName("fi_textBox");
			fi_aircraftText.setStyleName("fi_textBox");
			fi_operatorText.setStyleName("fi_textBox");
			fi_countryText.setStyleName("fi_textBox");
			

			// Assemble Contact Information panel.
			ci_roleList.add("None");
			ci_roleList.add("Mission Scientist");
			ci_roleList.add("Flight Manager");
			ci_roleList.add("Scientist");
			ci_roleList.add("Pilot");
			ci_roleList.add("Other");
		    ciGrid.setWidget(0, 0, ci_nameLabel);
			ciGrid.setWidget(0, 1, ci_nameText);
			ciGrid.setWidget(1, 0, ci_roleLabel);
			ciGrid.setWidget(1, 1, ci_roleText);
			ciGrid.setWidget(2, 0, ci_emailLabel);
			ciGrid.setWidget(2, 1, ci_emailText);
			ci_nameText.setStyleName("fi_textBox");
			ci_emailText.setStyleName("fi_textBox");
			populateListBox(ci_roleText, ci_roleList, 0);
			ci_roleText.setStyleName("ci_textList");
			
		    
			// Assemble Scientific Aims panel.
			CheckBox sa_satCalval = new CheckBox("Satellite Cal/Val");
			CheckBox sa_antPollution = new CheckBox("Anthropogenic pollution");
			CheckBox sa_mesoImpacts = new CheckBox("Mesoscale atmospheric impacts");
			CheckBox sa_microPhysics = new CheckBox("Microphysics");
			sa_microPhysics.setStyleName("sa_checkBox");
			CheckBox sa_dyNamics = new CheckBox("Dynamics (Cloud)");
			sa_dyNamics.setStyleName("sa_checkBox");
			CheckBox sa_radProperties = new CheckBox("Radiative properties");
			sa_radProperties.setStyleName("sa_checkBox");
			CheckBox sa_convDynamics = new CheckBox("Convection dynamics");
			sa_convDynamics.setStyleName("sa_checkBox");
			CheckBox sa_gazChemistry = new CheckBox("Gaz chemistry");
			CheckBox sa_oxyDants = new CheckBox("Oxydants");
			sa_oxyDants.setStyleName("sa_checkBox");
			CheckBox sa_orgAnics = new CheckBox("Organics");
			sa_orgAnics.setStyleName("sa_checkBox");
			CheckBox sa_other1 = new CheckBox("Other (Gaz chemistry)");
			sa_other1.setStyleName("sa_checkBox");
			CheckBox sa_aeroSol = new CheckBox("Aerosol");
			CheckBox sa_cloudImpacts = new CheckBox("Cloud microphysical impacts");
			sa_cloudImpacts.setStyleName("sa_checkBox");
			CheckBox sa_radImpacts = new CheckBox("Radiative properties/impacts");
			sa_radImpacts.setStyleName("sa_checkBox");
			CheckBox sa_radIation = new CheckBox("Radiation");
			CheckBox sa_atmSpectroscopy = new CheckBox("Atmospheric spectroscopy");
			sa_atmSpectroscopy.setStyleName("sa_checkBox");
			CheckBox sa_surfProperties = new CheckBox("Surface properties/retrievals");
			sa_surfProperties.setStyleName("sa_checkBox");
			CheckBox sa_other2 = new CheckBox("Other (Radiation)");
			sa_other2.setStyleName("sa_checkBox");
			CheckBox sa_cloud = new CheckBox("Cloud");
		    sa_cloud.setStyleName("sa_checkBox");
			CheckBox sa_dynAmics = new CheckBox("Dynamics (Boundary-layer)");
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
		    verticalPanel67.add(addCatButton(sa_addCatTable, sa_addCatMap, verticalPanel67));
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
		    gi_boundingLabel.setStyleName("gi_titleText");
		    verticalPanel12.add(gi_nsLabel);
		    gi_nsLabel.getElement().setAttribute("style", "margin-top: 4px !important;");
		    verticalPanel12.add(gi_weLabel);
		    gi_weLabel.getElement().setAttribute("style", "margin-top: 20px !important;");
		    horizontalPanel03.add(verticalPanel12);
		    horizontalPanel03.getElement().setAttribute("style", "margin-left: 40px !important;");
		    verticalPanel13.add(gi_northText);
		    verticalPanel13.add(gi_westText);
		    gi_westText.getElement().setAttribute("style", "margin-top: 10px !important;");
		    horizontalPanel03.add(verticalPanel13);
		    verticalPanel14.add(gi_southText);
		    verticalPanel14.add(gi_eastText);
		    gi_eastText.getElement().setAttribute("style", "margin-top: 10px !important;");
		    horizontalPanel03.add(verticalPanel14);
		    horizontalPanel04.add(gi_mmLabel);
		    gi_mmLabel.getElement().setAttribute("style", "margin-top: 4px !important;");
		    horizontalPanel04.add(gi_minText);
		    horizontalPanel04.add(gi_maxText);
		    verticalPanel15.add(horizontalPanel04);
		    //verticalPanel15.add(gi_coordButton);
		    verticalPanel15.getElement().setAttribute("style", "margin-left: 20px !important;");
		    horizontalPanel03.add(verticalPanel15);
		    verticalPanel11.add(horizontalPanel03);
		    gi_northText.setStyleName("gi_textBox");
		    gi_southText.setStyleName("gi_textBox");
		    gi_westText.setStyleName("gi_textBox");
		    gi_eastText.setStyleName("gi_textBox");
		    gi_minText.setStyleName("gi_textBox");
		    gi_maxText.setStyleName("gi_textBox");
		    //gi_coordButton.getElement().setAttribute("style", "width: 290px !important; height: 18px !important; margin-left: 60px !important;"
		    //		+ "margin-top: 10px !important; font-family: DroidSansFallback !important; font-size: 12px; text-align: center !important;"
		    //		+ "padding-top: 5px");
		    verticalPanel11.add(new HTML("<br />"));
		    verticalPanel11.add(gi_situationLabel);
		    gi_situationLabel.setStyleName("gi_titleText2");
		    CheckBox gi_polar = new CheckBox("Polar");
		    CheckBox gi_midLatitudes = new CheckBox("Mid-Latitudes");
		    CheckBox gi_subTropical = new CheckBox("Sub-Tropical");
		    CheckBox gi_tropical = new CheckBox("Tropical");
		    CheckBox gi_maritime = new CheckBox("Maritime");
		    CheckBox gi_continental = new CheckBox("Continental");
		    CheckBox gi_oceanicIslands = new CheckBox("Oceanic Islands");
		    CheckBox gi_other = new CheckBox("Other");
		    verticalPanel62.setSpacing(10);
		    verticalPanel62.add(gi_polar);
		    verticalPanel62.add(gi_midLatitudes);
		    horizontalPanel05.add(verticalPanel62);
		    horizontalPanel05.getElement().setAttribute("style", "margin-left: 25px !important;");
		    verticalPanel63.setSpacing(10);
		    verticalPanel63.getElement().setAttribute("style", "margin-left: 40px !important;");
		    verticalPanel63.add(gi_subTropical);
		    verticalPanel63.add(gi_tropical);
		    horizontalPanel05.add(verticalPanel63);
		    verticalPanel64.setSpacing(10);
		    verticalPanel64.getElement().setAttribute("style", "margin-left: 40px !important;");
		    verticalPanel64.add(gi_maritime);
		    verticalPanel64.add(gi_continental);
		    horizontalPanel05.add(verticalPanel64);
		    verticalPanel65.setSpacing(10);
		    verticalPanel65.getElement().setAttribute("style", "margin-left: 40px !important;");
		    verticalPanel65.add(gi_oceanicIslands);
		    verticalPanel65.add(gi_other);
		    horizontalPanel05.add(verticalPanel65);
		    verticalPanel11.add(horizontalPanel05);
		    verticalPanel68.add(addCatButton(gi_addCatTable, gi_addCatMap, verticalPanel68));
		    verticalPanel11.add(verticalPanel68);
		    verticalPanel11.add(new HTML("<br />"));
		    horizontalPanel06.add(gi_comLabel);
		    gi_comLabel.setStyleName("gi_titleText2");
		    horizontalPanel06.add(gi_comArea);
		    gi_comArea.setStyleName("sa_textArea");
		    verticalPanel11.add(horizontalPanel06);
		    verticalPanel11.setSpacing(10);
		    
		    
		    // Assemble Atmospheric Synoptic Features panel
		    CheckBox af_stationary = new CheckBox("Stationary");
		    CheckBox af_antiStationary = new CheckBox("Anticyclonic");
		    CheckBox af_cycloStationary = new CheckBox("Cyclonic");
		    CheckBox af_warmFront = new CheckBox("Warm Front");
		    CheckBox af_warmBelt = new CheckBox("Warm conveyor belt");
		    CheckBox af_coldFront = new CheckBox("Cold Front");
		    CheckBox af_occludedFront = new CheckBox("Occluded Front");
		    CheckBox af_warmSector = new CheckBox("Warm Sector");
		    CheckBox af_airMass = new CheckBox("Post-cold-frontal air-mass");
		    CheckBox af_airOutbreack = new CheckBox("Arctic cold-air Outbreak");
		    CheckBox af_orographicInfluence = new CheckBox("Orographic Influence");
		    CheckBox af_seabreezeFront = new CheckBox("Sea-breeze Front");
		    CheckBox af_foldIntrusion = new CheckBox("Stratospheric fold/intrusion");
		    CheckBox af_convergenceLine = new CheckBox("Extended convergence line");
		    CheckBox af_easterlyWave = new CheckBox("Easterly Wave");
		    CheckBox af_equatorialWave = new CheckBox("Equatorial Wave");
		    CheckBox af_tropicalCyclone = new CheckBox("Tropical cyclone");
		    CheckBox af_organizedConvection = new CheckBox("Mesoscale organized convection");
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
		    CheckBox ct_waterClouds = new CheckBox("Water clouds");
		    CheckBox ct_mixedphasedClouds = new CheckBox("Mixed-phase clouds");
		    CheckBox ct_iceClouds = new CheckBox("Ice clouds");
		    CheckBox ct_cirrus = new CheckBox("Cirrus");
		    CheckBox ct_contrails = new CheckBox("Contrails");
		    CheckBox ct_stratocumulus = new CheckBox("Stratocumulus");
		    CheckBox ct_shallowCumulus = new CheckBox("Shallow cumulus");
		    CheckBox ct_cumulusCongestus = new CheckBox("Cumulus congestus");
		    CheckBox ct_cumulTower = new CheckBox("Cumulonimbus/towering cumulus");
		    CheckBox ct_altoStracumul = new CheckBox("Altostratus/altocumulus");
		    CheckBox ct_waveClouds = new CheckBox("Wave clouds");
		    CheckBox ct_statiformClouds = new CheckBox("Deep frontal statiform clouds");
		    CheckBox ct_freeAbove = new CheckBox("Cloud-free above aircraft");
		    CheckBox ct_freeBelow = new CheckBox("Cloud-free below aircraft");
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
		    CheckBox cp_rain = new CheckBox("Rain");
		    CheckBox cp_drizzle = new CheckBox("Drizzle");
		    CheckBox cp_dropletsLiquid = new CheckBox("Droplets (liquid)");
		    CheckBox cp_pristineCrystals = new CheckBox("Pristine ice crystals");
		    CheckBox cp_snowAggregates = new CheckBox("Snow/aggregates");
		    CheckBox cp_graupelHail = new CheckBox("Graupel/hail");
		    CheckBox cp_saltAerosol = new CheckBox("Sea-salt aerosol");
		    CheckBox cp_continentalAerosol = new CheckBox("Continental Aerosol");
		    CheckBox cp_urbanPlume = new CheckBox("Urban plume");
		    CheckBox cp_biomassBurning = new CheckBox("Biomass Burning");
		    CheckBox cp_desertDust = new CheckBox("Desert/mineral dust");
		    CheckBox cp_volcanicAsh = new CheckBox("Volcanic ash");
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
		    CheckBox lo_ocean = new CheckBox("Ocean");
		    CheckBox lo_semiArid = new CheckBox("Semi-arid");
		    CheckBox lo_seaIce = new CheckBox("Sea-ice");
		    CheckBox lo_desert = new CheckBox("Desert");
		    CheckBox lo_snow = new CheckBox("Snow");
		    CheckBox lo_urban = new CheckBox("Urban");
		    CheckBox lo_lakeIce = new CheckBox("Lake-ice");
		    CheckBox lo_mountainous = new CheckBox("Mountainous");
		    CheckBox lo_vegetation = new CheckBox("Vegetation");
		    CheckBox lo_hilly = new CheckBox("Hilly");
		    CheckBox lo_forest = new CheckBox("Forest");
		    CheckBox lo_flat = new CheckBox("Flat");
		    verticalPanel31.add(lo_ocean);
		    verticalPanel31.add(lo_semiArid);
		    verticalPanel31.add(lo_seaIce);
		    verticalPanel31.setSpacing(10);
		    horizontalPanel13.add(verticalPanel31);
		    verticalPanel32.add(lo_desert);
		    lo_desert.getElement().setAttribute("style", "margin-left:70px !important;");
		    verticalPanel32.add(lo_snow);
		    lo_snow.getElement().setAttribute("style", "margin-left:70px !important;");
		    verticalPanel32.add(lo_urban);
		    lo_urban.getElement().setAttribute("style", "margin-left:70px !important;");
		    verticalPanel32.setSpacing(10);
		    horizontalPanel13.add(verticalPanel32);
		    verticalPanel33.add(lo_lakeIce);
		    lo_lakeIce.getElement().setAttribute("style", "margin-left:70px !important;");
		    verticalPanel33.add(lo_mountainous);
		    lo_mountainous.getElement().setAttribute("style", "margin-left:70px !important;");
		    verticalPanel33.add(lo_vegetation);
		    lo_vegetation.getElement().setAttribute("style", "margin-left:70px !important;");
		    verticalPanel33.setSpacing(10);
		    horizontalPanel13.add(verticalPanel33);
		    verticalPanel34.add(lo_hilly);
		    lo_hilly.getElement().setAttribute("style", "margin-left:70px !important;");
		    verticalPanel34.add(lo_forest);
		    lo_forest.getElement().setAttribute("style", "margin-left:70px !important;");
		    verticalPanel34.add(lo_flat);
		    lo_flat.getElement().setAttribute("style", "margin-left:70px !important;");
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
		    
		    
		    // Assemble Altitude Range of Measurement panel
		    CheckBox ar_boundaryLayer = new CheckBox("Boundary-layer");
		    CheckBox ar_nearSurface = new CheckBox("near-surface");
		    CheckBox ar_subCloud = new CheckBox("sub-cloud");
		    CheckBox ar_inCloud = new CheckBox("in-cloud");
		    CheckBox ar_lowerTroposphere = new CheckBox("Lower troposphere");
		    CheckBox ar_midTroposphere = new CheckBox("Mid troposphere");
		    CheckBox ar_upperTroposphere = new CheckBox("Upper troposphere");
		    CheckBox ar_lowerstratosphere = new CheckBox("Lower stratosphere");
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
		    CheckBox fm_levelRuns = new CheckBox("Straight/level runs");
		    CheckBox fm_stacked = new CheckBox("stacked");
		    CheckBox fm_separated = new CheckBox("separated");
		    CheckBox fm_racetracks = new CheckBox("Racetracks");
		    CheckBox fm_orbits = new CheckBox("Orbits");
		    CheckBox fm_lagrangianDescents = new CheckBox("Lagrangian descents");
		    CheckBox fm_ascDescents = new CheckBox("Deep profile ascents/descents");
		    CheckBox fm_dropsondeDeployed = new CheckBox("Dropsonde deployed");
		    CheckBox fm_selfCalibration = new CheckBox("Self-calibration");
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
		    CheckBox sc_metop = new CheckBox("METOP");
		    CheckBox sc_npoess = new CheckBox("NPOESS");
		    CheckBox sc_atrain = new CheckBox("A-train");
		    CheckBox sc_other = new CheckBox("Other (Polar)");
		    CheckBox sc_msg = new CheckBox("MSG");
		    CheckBox sc_other2 = new CheckBox("Other (Geosynch)");
		    CheckBox sc_modis = new CheckBox("MODIS");
		    CheckBox sc_cloudsat = new CheckBox("Cloudsat");
		    CheckBox sc_caliop = new CheckBox("CALIOP");
		    CheckBox sc_iasi = new CheckBox("IASI");
		    CheckBox sc_airs = new CheckBox("AIRS");
		    CheckBox sc_cris = new CheckBox("CriS");
		    CheckBox sc_amsuMhs = new CheckBox("AMSU/MHS");
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

		    
		    // add to StackPanel
		    stackPanel.add(fiScroll,"Flight Information", 2);
		    stackPanel.add(ciScroll,"Contact Information", 2);
		    stackPanel.add(saScroll,"Scientific Aims", 2);
		    stackPanel.add(giScroll,"Geographic Information", 2);
		    stackPanel.add(afScroll,"Atmospheric Synoptic Features", 2);
		    stackPanel.add(ctScroll,"Cloud Types and Forms Sampled During Flight", 2);
		    stackPanel.add(cpScroll,"Cloud, Precipitation and Aerosol Particles Sampled", 2);
		    stackPanel.add(loScroll,"Land or Oceans Surfaces Overflown", 2);
		    stackPanel.add(arScroll,"Altitude Range of Measurement", 2);
		    stackPanel.add(fmScroll,"Types of Flight Manoeuvre", 2);
		    stackPanel.add(scScroll,"Satellite Coordination", 2);
		    stackPanel.add(soScroll,"Supporting Surface-based Observations", 2);
		    stackPanel.add(nfScroll,"Additional Notes on the Flight", 2);

			
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
		    dockPanel.addEast(new HTML("<img src='icons/asmm_shadowr.png' alt='ASMM Creator' width='30px' height='" + screen_height 
		    		+ "' align='left'>Development version of ASMM Creator, online version " + asmmVersion), expandPanel);
		    dockPanel.addWest(new HTML("<img src='icons/asmm_shadowl.png' alt='ASMM Creator' width='30px' height='" + screen_height 
		    		+ "' align='right'>Development version of ASMM Creator, online version " + asmmVersion), expandPanel);
		    dockPanel.setStyleName("dockPanel");
		    subDockPanel.add(stackPanel);
		    dockPanel.add(subDockPanel);
		    RootLayoutPanel rp=RootLayoutPanel.get();
		    rp.add(dockPanel);
	  }
		    
	
	// create a new file by cleaning all widgets
	private void newFile() {
		  	List<TextBox> allTextBox = $("*", subDockPanel).widgets(TextBox.class);
		  	for (int i = 0; i < allTextBox.size(); i++) {
		  			allTextBox.get(i).setText("");
			}
		  	List<TextArea> allTextArea = $("*", subDockPanel).widgets(TextArea.class);
		  	for (int i = 0; i < allTextArea.size(); i++) {
		  			allTextArea.get(i).setText("");
			}
		  	List<CheckBox> allCheckBox = $("*", subDockPanel).widgets(CheckBox.class);
		  	for (int i = 0; i < allCheckBox.size(); i = i + 1) {
		  			allCheckBox.get(i).setValue(false);
			}
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
					verticalPanel67.remove(2);
			}
			gi_addCatMap.clear();
			gi_addCatTable.removeAllRows();
			numWidget = verticalPanel68.getWidgetCount();
			if (numWidget > 1) {
					verticalPanel68.remove(1);
					verticalPanel68.remove(2);
			}
			af_addCatMap.clear();
			af_addCatTable.removeAllRows();
			numWidget = verticalPanel69.getWidgetCount();
			if (numWidget > 1) {
					verticalPanel69.remove(1);
					verticalPanel69.remove(2);
			}
			ct_addCatMap.clear();
			ct_addCatTable.removeAllRows();
			numWidget = verticalPanel70.getWidgetCount();
			if (numWidget > 1) {
					verticalPanel70.remove(1);
					verticalPanel70.remove(2);
			}
			cp_addCatMap.clear();
			cp_addCatTable.removeAllRows();
			numWidget = verticalPanel71.getWidgetCount();
			if (numWidget > 1) {
					verticalPanel71.remove(1);
					verticalPanel71.remove(2);
			}
			lo_addCatMap.clear();
			lo_addCatTable.removeAllRows();
			numWidget = verticalPanel72.getWidgetCount();
			if (numWidget > 1) {
					verticalPanel72.remove(1);
					verticalPanel72.remove(2);
			}
			ar_addCatMap.clear();
			ar_addCatTable.removeAllRows();
			numWidget = verticalPanel73.getWidgetCount();
			if (numWidget > 1) {
					verticalPanel73.remove(1);
					verticalPanel73.remove(2);
			}
			fm_addCatMap.clear();
			fm_addCatTable.removeAllRows();
			numWidget = verticalPanel74.getWidgetCount();
			if (numWidget > 1) {
					verticalPanel74.remove(1);
					verticalPanel74.remove(2);
			}
			sc_addCatMap.clear();
			sc_addCatTable.removeAllRows();
			numWidget = verticalPanel75.getWidgetCount();
			if (numWidget > 1) {
					verticalPanel75.remove(1);
					verticalPanel75.remove(2);
			}	
	  }
	  
	
	  // open an existing xml file
	  private void openFile() {
		  	final DialogBox myUploadDialog = new DialogBox();
			myUploadDialog.setGlassEnabled(true);
			final VerticalPanel vpanel2 = new VerticalPanel();
			myUploadDialog.add(vpanel2);
			final HorizontalPanel hpanel = new HorizontalPanel();
			vpanel2.add(hpanel);
			vpanel2.getElement().setAttribute("style", "margin-left: 5px !important; margin-top: 10px !important; margin-right: 10px !important;");
			Image xImage = new Image("icons/open_icon_popup.png");
		    xImage.setPixelSize(75, 75);
		    hpanel.add(xImage);
		    final VerticalPanel panel = new VerticalPanel();
		    hpanel.add(panel);
		    panel.getElement().setAttribute("style", "margin-right:20px !important;");
			final Label label = new Label("Please, select the file you want to modify");
		    label.getElement().setAttribute("style", "margin-right:20px !important; margin-bottom:30px !important; "
		    		+ "margin-top:10px !important;");
		    panel.add(label);
			final FileUpload myFileUpload = new FileUpload();
			myFileUpload.setName("uploadFormElement");
			myFileUpload.getElement().setId("uploadFormElement");
			myFileUpload.getElement().setId("myFile");
			panel.add(myFileUpload);
			final FormPanel myUploadForm = new FormPanel();
			///////////////////////////////////////////////
			//myUploadForm.setAction(GWT.getHostPageBaseURL() + "/upload"); // for Tomcat7 Server
			myUploadForm.setAction("/upload"); // for Eclipse Dev Mode
			///////////////////////////////////////////////
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
					        		newFile();
					        		myFileName = myFileUpload.getFilename();
					        }        
				    }
			});
			myUploadForm.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
					@Override
					public void onSubmitComplete(SubmitCompleteEvent event) {
							myUploadDialog.hide();
							String ret = event.getResults();
							ret = ret.replaceAll("\t", "").replace("\n", "");
							readXml(ret);
				    }			
			});		
			final Button submitButton = new Button("Ok", new ClickHandler() {			
					@Override
					public void onClick(ClickEvent event) {
							myUploadForm.submit();
					}
			});
			final Button cancelButton = new Button("Cancel", new ClickHandler() {			
					@Override
					public void onClick(ClickEvent event) {
							myUploadDialog.hide();			
					}
			});
			myUploadForm.add(vpanel2);
			HorizontalPanel myHPanel = new HorizontalPanel();
			myHPanel.add(submitButton);
			myHPanel.add(cancelButton);
		    submitButton.getElement().setAttribute("style", "margin-left:40px !important; font-family: DroidSansFallback "
		    		+ "!important; font-weight: bold !important;");
		    cancelButton.getElement().setAttribute("style", "margin-left:65px !important; font-family: DroidSansFallback "
		    		+ "!important; font-weight: bold !important;");
			myHPanel.getElement().setAttribute("style", "margin-top:30px !important; margin-bottom:20px !important;");
			panel.add(myHPanel);
			myUploadDialog.add(myUploadForm);
			myUploadDialog.setSize( "130px", "180px" );
			myUploadDialog.setModal(true);
			myUploadDialog.center();
			myUploadDialog.setStyleName("myUploadBox");
	  }
	  
	  
	  // read the xml code in the opened xml file
	  private void readXml(String stringXml) {
		  	try {
		  			Document doc = XMLParser.parse(stringXml);
		  			creationDate = doc.getElementsByTagName("creationdate").item(0).getFirstChild().getNodeValue();
		  			
		  			
		  			//////////////////////////
		  			/// Flight information ///
		  			//////////////////////////
		  			try {
		  				fi_flightText.setText(doc.getElementsByTagName("flightnumber").item(0).getFirstChild().getNodeValue());
		  			}
		  			catch (Exception ex) {}
			      	fi_dateText.setValue(DateTimeFormat.getFormat("yyyy-MM-dd").parse(
			      			doc.getElementsByTagName("date").item(0).getFirstChild().getNodeValue()));
			      	try {
			      		fi_campaignText.setText(doc.getElementsByTagName("campaign").item(0).getFirstChild().getNodeValue());
			      	}
			      	catch (Exception ex) {}
			      	try {
			      		fi_scientistText.setText(doc.getElementsByTagName("missionscientist").item(0).getFirstChild().getNodeValue());
			      	}
			      	catch (Exception ex) {}
			      	try {
			      		fi_managerText.setText(doc.getElementsByTagName("flightmanager").item(0).getFirstChild().getNodeValue());
			      	}
			      	catch (Exception ex) {}
		  			try {
		  				fi_aircraftText.setText(doc.getElementsByTagName("platform").item(0).getFirstChild().getNodeValue());
		  			}
		  			catch (Exception ex) {}
		  			try {
		  				fi_operatorText.setText(doc.getElementsByTagName("operator").item(0).getFirstChild().getNodeValue());
		  			}
		  			catch (Exception ex) {}
		  			try {
		  				fi_countryText.setText(doc.getElementsByTagName("country").item(0).getFirstChild().getNodeValue());
		  			}
		  			catch (Exception ex) {}
		  			
		  			
		  			
		  			///////////////////////////
					/// Contact information ///
					///////////////////////////
		  			try {
		  				ci_nameText.setText(doc.getElementsByTagName("contactname").item(0).getFirstChild().getNodeValue());
		  			}
		  			catch (Exception ex) {}
		  			int indexToFind = -1;
		  			for (int i=0; i<ci_roleText.getItemCount(); i++) {
			  			    if (ci_roleText.getItemText(i).equals(doc.getElementsByTagName("contactrole").item(0).getFirstChild().getNodeValue())) {
				  			        indexToFind = i;
				  			        break;
			  			    }
		  			}
		  			try {
		  			ci_roleText.setSelectedIndex(indexToFind);
		  			}
		  			catch (Exception ex) {}
		  			try {
		  				ci_emailText.setText(doc.getElementsByTagName("contactemail").item(0).getFirstChild().getNodeValue());
		  			}
		  			catch (Exception ex) {}

		  			///////////////////////
					/// Scientific aims ///
					///////////////////////
		  			NodeList scientificAims = doc.getElementsByTagName("sa_code");
		  			for (int i=0; i< scientificAims.getLength(); i++) {
		  					checkBox(saScroll, scientificMap, scientificAims.item(i).getFirstChild().getNodeValue());
		  			}
		  			try {
		  				sa_comArea.setText(doc.getElementsByTagName("sa_other").item(0).getFirstChild().getNodeValue());
		  			}
		  			catch (Exception ex) {}
		  			NodeList saUser = doc.getElementsByTagName("sa_user");
		  			for (int i = 0; i < saUser.getLength(); i++) {
		  					String userDefined = saUser.item(i).getFirstChild().getNodeValue();
		  					addCat(sa_addCatTable, sa_addCatMap, verticalPanel67, userDefined);
		  			}
		  			

		  			//////////////////////////////
		  			/// Geographic Information ///
		  			//////////////////////////////
		  			gi_northText.setText(doc.getElementsByTagName("northboundlatitude").item(0).getFirstChild().getNodeValue());
		  			gi_southText.setText(doc.getElementsByTagName("southboundlatitude").item(0).getFirstChild().getNodeValue());
		  			gi_westText.setText(doc.getElementsByTagName("westboundlongitude").item(0).getFirstChild().getNodeValue());
		  			gi_eastText.setText(doc.getElementsByTagName("eastboundlongitude").item(0).getFirstChild().getNodeValue());
		  			gi_minText.setText(doc.getElementsByTagName("minaltitude").item(0).getFirstChild().getNodeValue());
		  			gi_maxText.setText(doc.getElementsByTagName("maxaltitude").item(0).getFirstChild().getNodeValue());
		  			NodeList geographicInformation = doc.getElementsByTagName("gr_code");
		  			for (int i=0; i< geographicInformation.getLength(); i++) {
	  						checkBox(giScroll, geographicMap, geographicInformation.item(i).getFirstChild().getNodeValue());
		  			}
		  			try {
		  				gi_comArea.setText(doc.getElementsByTagName("gr_other").item(0).getFirstChild().getNodeValue());
		  			} catch (Exception ex) {}
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
		  			try {
		  				af_comArea.setText(doc.getElementsByTagName("af_other").item(0).getFirstChild().getNodeValue());
		  			} catch (Exception ex) {}
		  			NodeList afUser = doc.getElementsByTagName("af_user");
		  			for (int i = 0; i < afUser.getLength(); i++) {
		  					String userDefined = afUser.item(i).getFirstChild().getNodeValue();
		  					addCat(af_addCatTable, af_addCatMap, verticalPanel69, userDefined);
		  			}
		  			
		  			
					///////////////////////////////////////////////////
					/// Cloud Types and Forms Sampled During Flight ///
					///////////////////////////////////////////////////
		  			NodeList cloudTypes = doc.getElementsByTagName("ct_code");
		  			for (int i=0; i< cloudTypes.getLength(); i++) {
	  						checkBox(ctScroll, cloudMap, cloudTypes.item(i).getFirstChild().getNodeValue());
		  			}
		  			try {
		  				ct_comArea.setText(doc.getElementsByTagName("ct_other").item(0).getFirstChild().getNodeValue());
		  			} catch (Exception ex) {}
		  			NodeList ctUser = doc.getElementsByTagName("ct_user");
		  			for (int i = 0; i < ctUser.getLength(); i++) {
		  					String userDefined = ctUser.item(i).getFirstChild().getNodeValue();
		  					addCat(ct_addCatTable, ct_addCatMap, verticalPanel70, userDefined);
		  			}
		  			
		  			
					//////////////////////////////////////////////////////////
					/// Cloud, Precipitation and Aerosol Particles Sampled ///
					//////////////////////////////////////////////////////////
		  			NodeList cpapTypes = doc.getElementsByTagName("ps_code");
		  			for (int i=0; i< cpapTypes.getLength(); i++) {
	  						checkBox(cpScroll, cpapMap, cpapTypes.item(i).getFirstChild().getNodeValue());
		  			}
		  			try {
		  				cp_comArea.setText(doc.getElementsByTagName("ps_other").item(0).getFirstChild().getNodeValue());
		  			} catch (Exception ex) {}
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
		  			try {
		  				lo_comArea.setText(doc.getElementsByTagName("so_other").item(0).getFirstChild().getNodeValue());
		  			} catch (Exception ex) {}
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
		  			try {
		  				ar_comArea.setText(doc.getElementsByTagName("ar_other").item(0).getFirstChild().getNodeValue());
		  			} catch (Exception ex) {}
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
		  			try {
		  				fm_comArea.setText(doc.getElementsByTagName("ft_other").item(0).getFirstChild().getNodeValue());
		  			} catch (Exception ex) {}
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
		  			try {
		  				sc_comArea.setText(doc.getElementsByTagName("sc_other").item(0).getFirstChild().getNodeValue());
		  			} catch (Exception ex) {}
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
		  			try {
		  				nf_comArea.setText(doc.getElementsByTagName("othercomments").item(0).getFirstChild().getNodeValue());
		  			} catch (Exception ex) {}
		  
		  	} catch (DOMException e) {
		  	    	Window.alert("Could not parse XML document.");
		  	}
	  }
	  
	  
	  // find the dedicated checkbox from the xml code
	  private void checkBox(ScrollPanel scrollPanel, TreeMap<String, String> treeMap, String string) {
		  	List<CheckBox> allCheckBox = $("*", scrollPanel).widgets(CheckBox.class);
			String key = new String();
			for (Entry<String, String> entry : treeMap.entrySet()) {
	            	if (entry.getValue().equals(string)) {key = entry.getKey(); break;}
	        }
			for (int i = 0; i < allCheckBox.size(); i = i + 2) {
					if (allCheckBox.get(i).getText() == key) {allCheckBox.get(i).setValue(true);}
			}
	  }
	  
	  
	  // save an xml file
	  private void saveFile() {
			final DialogBox myUploadDialog = new DialogBox();
			myUploadDialog.setGlassEnabled(true);
			final VerticalPanel vpanel2 = new VerticalPanel();
			final HorizontalPanel hpanel2 = new HorizontalPanel();
			vpanel2.add(hpanel2);
			vpanel2.getElement().setAttribute("style", "margin-left: 5px !important; margin-top: 10px !important; margin-right: 10px !important;");
			Image xImage = new Image("icons/save_icon_popup.png");
		    xImage.setPixelSize(75, 75);
		    hpanel2.add(xImage);
			final VerticalPanel panel = new VerticalPanel();	
			final VerticalPanel vpanel = new VerticalPanel();
			hpanel2.add(vpanel);
			final TextArea xmlTree = new TextArea();
			xmlTree.setText(createXml());
			xmlTree.setName("xmltree");
			panel.add(xmlTree);
			final Label label = new Label("Please, enter a name to save the XML file.");
		    label.getElement().setAttribute("style", "margin-right:20px !important; margin-bottom:30px !important; "
		    		+ "margin-top:10px !important;");
		    vpanel.add(label);
		    final TextBox fileName = new TextBox();
		    fileName.setText(myFileName);
			fileName.setStyleName("gi_textBox");
			fileName.getElement().setAttribute("style", "width:230px !important;");
			vpanel.add(fileName);
		    myFileName = fileName.getText();
		    if (!myFileName.toLowerCase().endsWith(".xml")) {
		    		myFileName = myFileName + ".xml";
		    };
		    final TextBox filebox = new TextBox();
		    filebox.setName("filename");
			panel.add(filebox);
			final FormPanel myForm = new FormPanel();
			/////////////////////////////////////////
			//myForm.setAction(GWT.getHostPageBaseURL() + "/download"); // for Tomcat7 Server
			myForm.setAction("/download"); // for Eclipse Dev Mode
			/////////////////////////////////////////
			myForm.setMethod(FormPanel.METHOD_POST);
			final Button cancelButton = new Button("Cancel/Close", new ClickHandler () {
				@Override
				public void onClick(ClickEvent event) {
						myUploadDialog.hide();			
				}
			});
			final Button submitButton = new Button("Ok", new ClickHandler() {			
					@Override
					public void onClick(ClickEvent event) {
							myFileName = fileName.getText();
						    if (!myFileName.toLowerCase().endsWith(".xml")) {
						    		myFileName = myFileName + ".xml";
						    };
							filebox.setText(myFileName);
							myForm.submit();
					}
			});
			myForm.add(panel);
			myForm.setVisible(false);
			HorizontalPanel myHPanel = new HorizontalPanel();
			myHPanel.add(submitButton);
			myHPanel.add(cancelButton);
			submitButton.getElement().setAttribute("style", "margin-left:115px !important; font-family: DroidSansFallback "
		    		+ "!important; font-weight: bold !important;");
		    cancelButton.getElement().setAttribute("style", "margin-left:45px !important; font-family: DroidSansFallback "
		    		+ "!important; font-weight: bold !important;");
		    myHPanel.getElement().setAttribute("style", "margin-top:30px !important; margin-bottom:20px !important;");
			vpanel.add(myForm);	
			vpanel2.add(myHPanel);
			myUploadDialog.add(vpanel2);	
			myUploadDialog.setSize( "370px", "180px" );
			myUploadDialog.setModal(true);
			myUploadDialog.center();
			myUploadDialog.setStyleName("myUploadBox");	
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
			Element flightCampaign = doc.createElement("asmm:Campaign");
			flightCampaign.appendChild(doc.createTextNode(fi_campaignText.getText()));
			flightInformation.appendChild(flightCampaign);
			Element missionScientist = doc.createElement("asmm:MissionScientist");
			missionScientist.appendChild(doc.createTextNode(fi_scientistText.getText()));
			flightInformation.appendChild(missionScientist);
			Element flightManager = doc.createElement("asmm:FlightManager");
			flightManager.appendChild(doc.createTextNode(fi_managerText.getText()));
			flightInformation.appendChild(flightManager);
			Element flightAircraft = doc.createElement("asmm:Platform");
			flightAircraft.appendChild(doc.createTextNode(fi_aircraftText.getText()));
			flightInformation.appendChild(flightAircraft);			
			Element flightOperator = doc.createElement("asmm:Operator");
			flightOperator.appendChild(doc.createTextNode(fi_operatorText.getText()));
			flightInformation.appendChild(flightOperator);
			Element flightCountry = doc.createElement("asmm:Country");
			flightCountry.appendChild(doc.createTextNode(fi_countryText.getText()));
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
			contactRole.appendChild(doc.createTextNode(ci_roleText.getSelectedItemText()));
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
			  Window.alert("This function is presently non accessible. Please, use the dedicated software on EUFAR website to "
			  			+ "print a PDF report from ASMM Creator xml file.");
			    
			  /*final DialogBox myUploadDialog = new DialogBox();
				myUploadDialog.setGlassEnabled(true);
				final VerticalPanel panel = new VerticalPanel();
				final FormPanel myUploadForm = new FormPanel();
				myUploadForm.setAction("PrintFunction");
				myUploadForm.setEncoding(FormPanel.ENCODING_MULTIPART);
				myUploadForm.setMethod(FormPanel.METHOD_POST);
				final Button submitButton = new Button("Submit", new ClickHandler() {			
						@Override
						public void onClick(ClickEvent event) {
								myUploadForm.submit();
						}
				});
				final Button cancelButton = new Button("Cancel", new ClickHandler() {			
						@Override
						public void onClick(ClickEvent event) {
								myUploadDialog.hide();			
						}
				});
				myUploadForm.add(panel);
				HorizontalPanel myHPanel = new HorizontalPanel();
				myHPanel.add(submitButton);
				submitButton.getElement().setAttribute("style", "margin-left:40px !important;");
				myHPanel.add(cancelButton);
				cancelButton.getElement().setAttribute("style", "margin-left:60px !important;");
				myHPanel.getElement().setAttribute("style", "margin-top:40px !important;");
				panel.add(myHPanel);
				myUploadDialog.add(myUploadForm);
				myUploadDialog.setHTML("<b>" + "Please, select the file you want to parse" + "</b><br/>");
				myUploadDialog.setSize( "80px", "150px" );
				myUploadDialog.setModal(true);
				myUploadDialog.center();
				myUploadDialog.setStyleName("myUploadBox");*/
	  }
 
	  
	  // create a window with text dedicated to ASMM
	  private void aboutWindow() {
		  	final DialogBox infoDialog = new DialogBox();
			infoDialog.setGlassEnabled(true);
			final VerticalPanel vpanel = new VerticalPanel();
			vpanel.getElement().setAttribute("style", "margin-left: 10px !important; margin-top: 20px !important; margin-right: 20px !important;");
			final HorizontalPanel hpanel = new HorizontalPanel();
			Image xImage = new Image("icons/about_icon_popup.png");
		    xImage.setPixelSize(75, 75);
		    hpanel.add(xImage);
			final HTML label = new HTML("The Airborne Science Mission Metadata (ASMM) Creator " + asmmVersion + " online version, was developed "
					+ "by EUFAR using Eclipse 4.4, Google Web "
					+ "Toolkit and Java. XML files generated by this version conform to " + xmlVersion + " of the ASMM XML standard. The "
					+ "opensource reporting "
					+ "engine used for PDF report generation is provided and owned by <a href=http://community.jaspersoft.com/"
					+ "project/jasperreports-library>JasperSoft</a>.<br> <br>For more "
					+ "information, or to submit a bug report, please contact <a href='mailto:xxxxxxxxxxxxx'>xxxxxxxxxxxxx</a> <br><br>"
					+ "The latest version and source code of the ASMM Creator can be found at <a href=http://xxxxxxxxxxxxxxxxxxxxxxxxxx>"
					+ "http://xxxxxxxxxxxxxxxxxxxxxxxxxxx</a>");
			hpanel.add(label);
			label.setStyleName("gwt-Label");
			vpanel.add(hpanel);
			final Button button = new Button("Ok", new ClickHandler() {			
					@Override
					public void onClick(ClickEvent event) {
							infoDialog.hide();
					}
			});
			vpanel.add(button);
			button.getElement().setAttribute("style", "margin-left: 220px !important; font-family: DroidSansFallback !important;"
					+ " font-weight: bold !important; margin-top: 20px !important;");
			infoDialog.add(vpanel);
			infoDialog.setSize( "500px", "270px" );
			infoDialog.setModal(true);
			infoDialog.center();
		    infoDialog.setStyleName("myUploadBox");
		    infoDialog.show();
	  }
	  
	  
	  // create a window with text dedicated to ASMM XML standard
	  private void aboutStandard() {
		  	final DialogBox infoDialog = new DialogBox();
			infoDialog.setGlassEnabled(true);
			final VerticalPanel vpanel = new VerticalPanel();
			vpanel.getElement().setAttribute("style", "margin-left: 10px !important; margin-top: 20px !important; margin-right: 20px !important;");
			final HorizontalPanel hpanel = new HorizontalPanel();
			Image xImage = new Image("icons/changelog_icon_popup.png");
		    xImage.setPixelSize(75, 75);
		    hpanel.add(xImage);
			final HTML label = new HTML("The Airborne Science Mission Metadata (ASMM) standard is intended to unify descriptions of science "
					+ "research flights. This common description will allow users of the airborne science data to search past datasets for "
					+ "specific meteorological conditions, geographical regions, cloud-types encountered, particles sampled, and other "
					+ "parameters not evident from the data itself.<br> <br> For more information, please read the following document: "
					+ "<a href=https://github.com/eufarn7sp/asmm-eufar/blob/master/Documentation/ASMM%20-%20XML%20Implementation%20Rules.pdf>"
					+ "ASMM - XML Implementation Rules.pdf</a>");
			hpanel.add(label);
			label.setStyleName("gwt-Label");
			vpanel.add(hpanel);
			final Button button = new Button("Ok", new ClickHandler() {			
					@Override
					public void onClick(ClickEvent event) {
							infoDialog.hide();
					}
			});
			vpanel.add(button);
			button.getElement().setAttribute("style", "margin-left: 220px !important; font-family: DroidSansFallback !important;"
					+ " font-weight: bold !important; margin-top: 20px !important;");
			infoDialog.add(vpanel);
			infoDialog.setSize( "500px", "240px" );
			infoDialog.setModal(true);
			infoDialog.center();
		    infoDialog.setStyleName("myUploadBox");
		    infoDialog.show();
	  }

	  
	  // add element to a list and a widget
	  private PushButton addListButton(final FlexTable flexTable, final TextBox widget, final ArrayList<String> itemList) {
		  	Image plusImage = new Image("icons/plus_icon_small.png");
			final PushButton addButton = new PushButton(plusImage);
			addButton.setPixelSize(25, 25);
			addButton.setTabIndex(-1);
			addButton.setStyleName("infoButton");
			addButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						    final String widgetText = widget.getText();
						    int row = flexTable.getRowCount();
						    itemList.add(widgetText);
						    widget.setText("");
						    Image xImage = new Image("icons/del_icon_small.png");
						    final PushButton delButton = new PushButton(xImage);
						    delButton.setPixelSize(25, 25);
						    delButton.setStyleName("infoButton");
						    Label label = new Label(widgetText);
						    flexTable.insertRow(row);
						    flexTable.setWidget(row, 0, label);
						    flexTable.setWidget(row, 1, delButton);
						    flexTable.getFlexCellFormatter().setHorizontalAlignment(row, 1, HasHorizontalAlignment.ALIGN_RIGHT);
						    delButton.addClickHandler(new ClickHandler() {
						    		public void onClick(ClickEvent event) {
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
		  	itemList.add(string);
		    Image xImage = new Image("icons/del_icon_small.png");
		    final PushButton delButton = new PushButton(xImage);
		    delButton.setPixelSize(25, 25);
		    delButton.setStyleName("infoButton");
		    Label label = new Label(string);
		    flexTable.insertRow(row);
		    flexTable.setWidget(row, 0, label);
		    flexTable.setWidget(row, 1, delButton);
		    flexTable.getFlexCellFormatter().setHorizontalAlignment(row, 1, HasHorizontalAlignment.ALIGN_RIGHT);
		    delButton.addClickHandler(new ClickHandler() {
		    		public void onClick(ClickEvent event) {
		    				int removedIndex = itemList.indexOf(string);
		    				itemList.remove(removedIndex);
		    				flexTable.removeRow(removedIndex);
		    		}
		    });
	  }
	  
	  
	  // create new checkboxes and an information popup
	  private HorizontalPanel addCatButton(final FlexTable flexTable, final TreeMap<String, String> treeMap, final VerticalPanel verticalPanel) {
		  	final HorizontalPanel hpanel3 = new HorizontalPanel();
		  	final PushButton addButton = new PushButton("Add a new CheckBox");
		  	hpanel3.add(addButton);
		  	addButton.setTabIndex(-1);
		  	addButton.getElement().setAttribute("style", "width: 160px !important; height: 18px !important; margin-left: 420"
		  			+ "px !important; font-family: DroidSansFallback !important; font-size: 12px; text-align: "
		  			+ "center !important; padding-top: 5px; font-weight: bold !important;");
		  	Image xImage = new Image("icons/info_icon_small.png");
		    final PushButton infoButton = new PushButton(xImage);
		    infoButton.setPixelSize(25, 25);
		    infoButton.setStyleName("infoButton");
		  	hpanel3.add(infoButton);
		  	infoButton.addClickHandler(new ClickHandler() {
		    		public void onClick(ClickEvent event) {
		    				final DialogBox infoDialog = new DialogBox();
		    				infoDialog.setGlassEnabled(true);
		    				final VerticalPanel vpanel = new VerticalPanel();
		    				final HorizontalPanel hpanel = new HorizontalPanel();
		    				Image xImage = new Image("icons/info_icon_popup.png");
		    			    xImage.setPixelSize(75, 75);
		    			    hpanel.add(xImage);
		    				final Label label = new Label("Use this button to add a new checkbox. Each activated checkbox is then saved in the "
		    						+ "xml file with the code 'xx_User'. All unactivated checkboxes will not be saved and will be lost.");
		    				hpanel.add(label);
		    				vpanel.add(hpanel);
		    				final Button button = new Button("Ok", new ClickHandler() {			
									@Override
									public void onClick(ClickEvent event) {
											infoDialog.hide();
									}
		    				});
		    				vpanel.add(button);
		    				button.getElement().setAttribute("style", "margin-left: 120px !important; font-family: DroidSansFallback !important;"
		    						+ " font-weight: bold !important; margin-top: 20px !important;");
		    				infoDialog.add(vpanel);
		    				infoDialog.setSize( "300px", "170px" );
		    				infoDialog.setModal(true);
		    				infoDialog.center();
						    infoDialog.setStyleName("myUploadBox");
						    infoDialog.show();
		    		}
		  	});
		  	addButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						    final DialogBox checkSubmit = new DialogBox();
						    checkSubmit.setGlassEnabled(true);
						    final VerticalPanel vpanel = new VerticalPanel();
						    final Label label = new Label("Please, enter a title for the new checkbox.");
						    label.getElement().setAttribute("style", "margin-right:20px !important; margin-bottom:30px !important; "
						    		+ "margin-top:10px !important;");
						    vpanel.add(label);
						    final TextBox textBox = new TextBox();
						    vpanel.add(textBox);
						    textBox.setStyleName("myAddBox");
						    final HorizontalPanel hpanel = new HorizontalPanel();
						    final Button submitButton = new Button("Submit", new ClickHandler() {			
									@Override
									public void onClick(ClickEvent event) {
											if (flexTable.getRowCount() == 0) {
													verticalPanel.add(flexTable);
													flexTable.getElement().setAttribute("style", "margin-left: 40px !important;");
										    		flexTable.insertRow(0);
										    		final Label userLabel = new Label("User-defined:");
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
										    else {
										    		cell = flexTable.getCellCount(row-1);
										    }
										    String stringBox = textBox.getValue();
										    stringBox = stringBox.toLowerCase();
										    StringBuilder b = new StringBuilder(stringBox);
										    int i = 0;
										    do {
										    		if (i == 0) {
										    				  i =  b.indexOf(" ", i) + 1;
										    		}
										    		else {
														      b.replace(i, i + 1, b.substring(i,i + 1).toUpperCase());
														      i =  b.indexOf(" ", i) + 1;
										    		}
										    } while (i > 0 && i < b.length());
										    String stringCode = b.toString();
										    stringCode = stringCode.replaceAll("\\s","");
										    treeMap.put(textBox.getValue(),stringCode);
										    final CheckBox checkBox = new CheckBox(textBox.getValue());
										    final HorizontalPanel hpanel2 = new HorizontalPanel();
 										    hpanel2.add(checkBox);
										    flexTable.setWidget(row - 1, cell, hpanel2);
										    checkSubmit.hide();
									}
						    });
						    final Button cancelButton = new Button("Cancel", new ClickHandler() {			
									@Override
									public void onClick(ClickEvent event) {
											checkSubmit.hide();			
									}
						    });
						    submitButton.getElement().setAttribute("style", "margin-left:40px !important; font-family: DroidSansFallback "
						    		+ "!important; font-weight: bold !important;");
						    cancelButton.getElement().setAttribute("style", "margin-left:45px !important; font-family: DroidSansFallback "
						    		+ "!important; font-weight: bold !important;");
						    hpanel.add(submitButton);
						    hpanel.add(cancelButton);
						    hpanel.getElement().setAttribute("style", "margin-top:40px !important;");
						    vpanel.add(hpanel);
						    checkSubmit.add(vpanel);
						    checkSubmit.setSize( "260px", "170px" );
						    checkSubmit.setModal(true);
						    checkSubmit.center();
						    checkSubmit.setStyleName("myUploadBox");
						    checkSubmit.show();
					}
			});
			return hpanel3;
	  }
	  
	  
	  // see above, but dedicated to the read function
	  private void addCat(final FlexTable flexTable, final TreeMap<String, String> treeMap, final VerticalPanel verticalPanel, final String string) {
			LinkedList<String> linkedList = splitCamelCaseString(string);
			String result = new String("");
			int i = 0;
			for (i = 0; i< linkedList.size(); i++) {
					if (i == 0) {
							result = linkedList.get(i);
							result = result.substring(0, 1).toUpperCase() + result.substring(1);
					}
					else {
					result = result + " " + linkedList.get(i).toLowerCase();
					}
			}
		  	if (flexTable.getRowCount() == 0) {
				verticalPanel.add(flexTable);
				flexTable.getElement().setAttribute("style", "margin-left: 40px !important;");
	    		flexTable.insertRow(0);
	    		final Label userLabel = new Label("User-defined:");
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
		    else {
		    		cell = flexTable.getCellCount(row-1);
		    }
		    treeMap.put(result,string);
		    final CheckBox checkBox = new CheckBox(result);
		    checkBox.setValue(true);
		    final HorizontalPanel hpanel2 = new HorizontalPanel();
		    hpanel2.add(checkBox);
		    flexTable.setWidget(row - 1, cell, hpanel2);
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
					if (c >= 65 && c <= 90) { al.add(i); }
			}
			LinkedList<String> strl = new LinkedList<String>();
			if (al.size() == 1) { strl.add(s); return strl; }
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
							if (k == al.size() - 1) { strl.add(s.substring(curr, s.length())); }
					}
			}
			return strl;
	  }

}


		