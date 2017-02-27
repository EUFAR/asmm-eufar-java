package com.eufar.asmm.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.google.gwt.query.client.GQuery.$;

import com.eufar.asmm.client.ScrollableTabLayoutPanel;
import com.eufar.asmm.client.Materials.Resources;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.UmbrellaException;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Navigator;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.datepicker.client.DateBox;


public class Asmm_eufar implements EntryPoint {

	public static Logger rootLogger = Logger.getLogger("");
	
	// Main window items initialization
	public static MenuBar mainMenu = new MenuBar();
	private MenuBar aboutMenu = new MenuBar(true);
	private MenuBar fileMenu = new MenuBar(true);
	private MenuBar asmmMenu = new MenuBar(true);
	public static DockLayoutPanel subDockPanel = new DockLayoutPanel(Unit.PX);
	public static ScrollableTabLayoutPanel tabPanel = new ScrollableTabLayoutPanel(42, Unit.PX);
	public static String myFileName = new String("");
	public static String myPDFName = new String("");
	public static String creationDate = new String(DateTimeFormat.getFormat("yyyy-MM-dd").format(new Date()));
	public static String revisionDate = new String(DateTimeFormat.getFormat("yyyy-MM-dd").format(new Date()));
	public static String asmmVersion = new String("1.2.6 (2017-24-02)");
	public static String gwtVersion = new String("2.7.0");
	public static String eclipseVersion = new String("4.6.1");
	public static String javaVersion = new String("1.8");
	public static String jasperVersion = new String("6.3.1");
	public static String xmlVersion = new String("v1.0a");
	public static String titleString = new String("ASMM Creator");
	public static Boolean isModified = new Boolean(false);
	private ArrayList<TextBoxBase> requiredField = Materials.requiredTextboxLst();
	private ArrayList<TextBoxBase> nonrequiredField = Materials.nonrequiredTextboxLst();
	private ArrayList<ListBox> requiredListbox = Materials.requiredListboxLst();
	private ArrayList<String> correctField = Materials.correctTextboxLst();
	private ArrayList<String> correctField2 = Materials.correctTextboxLst2();
	public static String asmmPath = new String("");
	private VerticalPanel verticalPanel101 = new VerticalPanel();
	private HorizontalPanel horizontalPanel90 = new HorizontalPanel();
	private String imageASMM = "<i class='fa fa-bars' aria-hidden='true' style='color: white; font-size: 1.7em;'></i>";
	private int clouds_heading_width = 3840;
	private int clouds_heading_height = 322;
	private int screen_width = Utilities.getScreenWidth();
	private int menu_width = screen_width / 10;
	private float ratio = (float) clouds_heading_height / clouds_heading_width;
	private float new_clouds_heading_height = screen_width * ratio;
	public static Resources resources = GWT.create(Materials.Resources.class);
	public static ArrayList<HorizontalPanel> newCheckboxLst = new ArrayList<HorizontalPanel>();
	public static ArrayList<String> newCheckboxNameLst = new ArrayList<String>();
	
	
	// Header items
	private HorizontalPanel horizontalPanel87 = new HorizontalPanel();
	private Label hdTitleLab = new Label("European Facility For Airborne Research");
	

	// Footer items
	private HorizontalPanel horizontalPanel112 = new HorizontalPanel();
	private HorizontalPanelOver horizontalPanel113 = new HorizontalPanelOver();
	private HorizontalPanelOver horizontalPanel114 = new HorizontalPanelOver();
	private HorizontalPanelOver horizontalPanel115 = new HorizontalPanelOver();
	private InlineHTML centerHtml = new InlineHTML("<i class='fa fa-home fa-lg' aria-hidden='true' style='"
			+ "color:#616265;"
			+ "padding: 8px 8px 8px 8px;"
			+ "'></i>");
	private InlineHTML centerHtml2 = new InlineHTML("<i class='fa fa-home fa-lg' aria-hidden='true' style='"
			+ "color:#F9A12A;"
			+ "padding: 8px 8px 8px 8px;"
			+ "'></i>");
	private InlineHTML leftHtml = new InlineHTML("<i class='fa fa-arrow-left fa-lg' aria-hidden='true' style='"
			+ "color:#616265;"
			+ "padding: 8px 8px 8px 8px;"
			+ "'></i>");
	private InlineHTML leftHtml2 = new InlineHTML("<i class='fa fa-arrow-left fa-lg' aria-hidden='true' style='"
			+ "color:#F9A12A;"
			+ "padding: 8px 8px 8px 8px;"
			+ "'></i>");
	private InlineHTML rightHtml = new InlineHTML("<i class='fa fa-arrow-right fa-lg' aria-hidden='true' style='"
			+ "color:#616265;"
			+ "padding: 8px 8px 8px 8px;"
			+ "'></i>");
	private InlineHTML rightHtml2 = new InlineHTML("<i class='fa fa-arrow-right fa-lg' aria-hidden='true' style='"
			+ "color:#F9A12A;"
			+ "padding: 8px 8px 8px 8px;"
			+ "'></i>");
	private Label centerLabel = new Label("BACK TO HOME");
	private Label leftLabel = new Label("PREVIOUS");
	private Label rightLabel = new Label("NEXT");
	
	
	// Flight Information items initialization
	public static FlexTable fiGrid = new FlexTable();
	private HorizontalPanel horizontalPanel30 = new HorizontalPanel();
	public static HorizontalPanel horizontalPanel26 = new HorizontalPanel();
	public static HorizontalPanel horizontalPanel27 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel49 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel50 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel75 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel76 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel77 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel78 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel79 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel80 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel81 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel82 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel91 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel92 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel93 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel94 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel95 = new HorizontalPanel();
	public static VerticalPanel verticalPanel58 = new VerticalPanel();
	public static VerticalPanel verticalPanel59 = new VerticalPanel();
	private Label fi_mainLab = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label fi_mainLab2 = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label fi_pathLab = new Label(">");
	private Label fi_pathLab2 = new Label("Flight and Contact Information");
	public static ScrollPanel fiScroll = new ScrollPanel(verticalPanel58);
	public static DateBox fi_dateText = new DateBox();
	public static TextBox fi_flightText = new TextBox();
	public static TextBox fi_campaignText = new TextBox();
	public static TextBox fi_scientistText = new TextBox();
	public static TextBox fi_managerText = new TextBox();
	public static TextBox fi_otherOpsText = new TextBox();
	public static TextBox fi_otherAiText = new TextBox();
	private Label fi_starLab01 = new Label("*");
	private Label fi_starLab02 = new Label("*");
	private Label fi_starLab03 = new Label("*");
	private Label fi_starLab04 = new Label("*");
	private Label fi_starLab05 = new Label("*");
	private Label fi_starLab06 = new Label("*");
	private Label fi_starLab07 = new Label("*");
	private Label fi_starLab08 = new Label("*");
	private Label fi_flightInfo = new Label("Flight Information");
	public static Label fi_flightLabel = new Label("Flight identifier");
	public static Label fi_dateLabel = new Label("Date");
	public static Label fi_campaignLabel = new Label("Project acronym");
	public static Label fi_scientistLabel = new Label("Mission scientist");
	public static Label fi_managerLabel = new Label("Flight manager");
	private Label fi_aircraftLabel = new Label("Platform/Aircraft");
	private Label fi_operatorLabel = new Label("Operator");
	private Label fi_countryLabel = new Label("Location");
	public static Image fi_operatorImage = new Image(Asmm_eufar.resources.forward().getSafeUri());
	public static Image fi_aircraftImage = new Image(Asmm_eufar.resources.forward().getSafeUri());
	private Image geoFollowImage = new Image(Asmm_eufar.resources.forward().getSafeUri());
	public static ListBox fi_operatorText = new ListBox();
	public static ListBox fi_aircraftText = new ListBox();
	public static ListBox geoLocationLst = new ListBox();
	public static ListBox geoDetailLst = new ListBox();
	public static ArrayList<String> countryList = Materials.countryList();
	public static ArrayList<String> continentList = Materials.continentList();
	public static ArrayList<String> oceanList = Materials.oceanList();
	public static ArrayList<String> regionList = Materials.regionList();
	public static ArrayList<String> locationList = Materials.locationList();
	public static ArrayList<String> operatorList = Materials.operatorList();
	public static ArrayList<String> aircraftList = Materials.aircraftList();
	public static String[][] operatorsAircraft = Materials.operatorsAircraft();
	public static SimplePanel fi_infoButton01 = Elements.addInfoButton("PROJECTACRONYM");
	public static SimplePanel fi_infoButton02 = Elements.addInfoButton("DATE");
	public static SimplePanel fi_infoButton03 = Elements.addInfoButton("FLIGHTIDENTIFIER");
	public static SimplePanel fi_infoButton04 = Elements.addInfoButton("MISSIONSCIENTIST");
	public static SimplePanel fi_infoButton05 = Elements.addInfoButton("FLIGHTMANAGER");
	public static SimplePanel fi_infoButton06 = Elements.addInfoButton("OPERATOR");
	public static SimplePanel fi_infoButton07 = Elements.addInfoButton("LOCATION");


	// Contact Information items initialization
	private HorizontalPanel horizontalPanel83 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel84 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel85 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel96 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel97 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel98 = new HorizontalPanel();
	public static FlexTable ciGrid = new FlexTable();
	public static TextBox ci_nameText = new TextBox();
	public static TextBox ci_emailText = new TextBox();
	public static ListBox ci_roleText = new ListBox();
	private Label ci_starLab01 = new Label("*");
	private Label ci_starLab02 = new Label("*");
	private Label ci_starLab03 = new Label("*");
	private Label ci_contactInfo = new Label("Contact Information");
	public static Label ci_nameLabel = new Label("Name");
	private Label ci_roleLabel = new Label("Role");
	public static Label ci_emailLabel = new Label("Email");
	private ArrayList<String> roleList = Materials.roleList();
	public static SimplePanel ci_infoButton01 = Elements.addInfoButton("CONTACTNAME");
	public static SimplePanel ci_infoButton02 = Elements.addInfoButton("CONTACTROLE");
	public static SimplePanel ci_infoButton03 = Elements.addInfoButton("CONTACTEMAIL");
	

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
	private HorizontalPanel horizontalPanel51 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel52 = new HorizontalPanel();
	public static VerticalPanel verticalPanel60 = new VerticalPanel();
	private Label sa_mainLab = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label sa_mainLab2 = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label sa_pathLab = new Label(">");
	private Label sa_pathLab2 = new Label("Scientific Aims");
	private Label sa_cloudLabel = new Label("Cloud");
	private Label sa_layerLabel = new Label("Boundary-layer");
	private Label sa_comments = new Label("Comments");
	public static TextArea sa_comArea = new TextArea();
	public static TreeMap<String, String> sa_addCatMap = new TreeMap<String, String>();
	public static FlexTable sa_addCatTable = new FlexTable();
	public static HorizontalPanel sa_satCalval = Elements.checkBox("Satellite Cal/Val","sa_satCalval");
	public static HorizontalPanel sa_antPollution = Elements.checkBox("Anthropogenic pollution","sa_antPollution");
	public static HorizontalPanel sa_mesoImpacts = Elements.checkBox("Mesoscale atmospheric impacts","sa_mesoImpacts");
	public static HorizontalPanel sa_microPhysics = Elements.checkBox("Microphysics","sa_microPhysics");
	public static HorizontalPanel sa_dyNamics = Elements.checkBox("Dynamics (Cloud)","sa_dyNamics");
	public static HorizontalPanel sa_radProperties = Elements.checkBox("Radiative properties","sa_radProperties");
	public static HorizontalPanel sa_convDynamics = Elements.checkBox("Convection dynamics","sa_convDynamics");
	public static HorizontalPanel sa_gazChemistry = Elements.checkBox("Gas chemistry","sa_gazChemistry");
	public static HorizontalPanel sa_oxyDants = Elements.checkBox("Oxydants","sa_oxyDants");
	public static HorizontalPanel sa_orgAnics = Elements.checkBox("Organics","sa_orgAnics");
	public static HorizontalPanel sa_other1 = Elements.checkBox("Other (Gas chemistry)","sa_other1");
	public static HorizontalPanel sa_aeroSol = Elements.checkBox("Aerosol","sa_aeroSol");
	public static HorizontalPanel sa_cloudImpacts = Elements.checkBox("Cloud microphysical impacts","sa_cloudImpacts");
	public static HorizontalPanel sa_radImpacts = Elements.checkBox("Radiative properties/impacts","sa_radImpacts");
	public static HorizontalPanel sa_radIation = Elements.checkBox("Radiation","sa_radIation");
	public static HorizontalPanel sa_atmSpectroscopy = Elements.checkBox("Atmospheric spectroscopy","sa_atmSpectroscopy");
	public static HorizontalPanel sa_surfProperties = Elements.checkBox("Surface properties/retrievals","sa_surfProperties");
	public static HorizontalPanel sa_other2 = Elements.checkBox("Other (Radiation)","sa_other2");
	public static HorizontalPanel sa_cloud = Elements.checkBox("Cloud","sa_cloud");
	public static HorizontalPanel sa_dynAmics = Elements.checkBox("Dynamics (Boundary-layer)","sa_dynAmics");
	public static ScrollPanel saScroll = new ScrollPanel(verticalPanel60);  
	public static SimplePanel sa_infoButton01 = Elements.addInfoButton("CHECKBOXES");
	public static SimplePanel sa_infoButton02 = Elements.addInfoButton("COMMENTS");


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
	private HorizontalPanel horizontalPanel53 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel54 = new HorizontalPanel();
	public static VerticalPanel verticalPanel80 = new VerticalPanel();
	private Label gi_mainLab = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label gi_mainLab2 = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label gi_pathLab = new Label(">");
	private Label gi_pathLab2 = new Label("Geographic Information");
	private Label gi_boundingLabel = new Label("Geographic bounding box");
	private Label gi_nsLabel = new Label("North/South latitudes");
	private Label gi_weLabel = new Label("West/East longitudes");
	public static Label gi_mmLabel = new Label("Min/Max altitudes (m)");
	private Label gi_comLabel = new Label("Comments");
	private Label gi_situationLabel = new Label("Geographic situation");
	public static TextArea gi_comArea = new TextArea();
	public static TextBox gi_northText = new TextBox();
	public static TextBox gi_southText = new TextBox();
	public static TextBox gi_westText = new TextBox();
	public static TextBox gi_eastText = new TextBox();
	public static TextBox gi_minText = new TextBox();
	public static TextBox gi_maxText = new TextBox();
	public static TreeMap<String, String> gi_addCatMap = new TreeMap<String, String>();
	public static FlexTable gi_addCatTable = new FlexTable();
	private FlexTable gi_boundTable = new FlexTable();
	public static SimplePanel gi_infoButtonSN = Elements.addInfoButton("infoSouthNorth");
	public static SimplePanel gi_infoButtonWE = Elements.addInfoButton("infoWestEast");
	public static SimplePanel gi_infoButtonMM = Elements.addInfoButton("infoMinMax");
	public static SimplePanel gi_infoButton01 = Elements.addInfoButton("CHECKBOXES");
	public static SimplePanel gi_infoButton02 = Elements.addInfoButton("COMMENTS");
	public static HorizontalPanel gi_polar = Elements.checkBox("Polar","gi_polar");
	public static HorizontalPanel gi_midLatitudes = Elements.checkBox("Mid-latitudes","gi_midLatitudes");
	public static HorizontalPanel gi_subTropical = Elements.checkBox("Sub-tropical","gi_subTropical");
	public static HorizontalPanel gi_tropical = Elements.checkBox("Tropical","gi_tropical");
	public static HorizontalPanel gi_maritime = Elements.checkBox("Maritime","gi_maritime");
	public static HorizontalPanel gi_continental = Elements.checkBox("Continental","gi_continental");
	public static HorizontalPanel gi_oceanicIslands = Elements.checkBox("Oceanic islands","gi_oceanicIslands");
	public static HorizontalPanel gi_other = Elements.checkBox("Other","gi_other");
	public static ScrollPanel giScroll = new ScrollPanel(verticalPanel80);


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
	private HorizontalPanel horizontalPanel55 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel56 = new HorizontalPanel();
	public static VerticalPanel verticalPanel81 = new VerticalPanel();
	private Label af_mainLab = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label af_mainLab2 = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label af_pathLab = new Label(">");
	private Label af_pathLab2 = new Label("Atmospheric Synoptic Features");
	private Label af_comLabel = new Label("Comments");
	public static TextArea af_comArea = new TextArea();
	public static TreeMap<String, String> af_addCatMap = new TreeMap<String, String>();
	public static FlexTable af_addCatTable = new FlexTable();
	public static HorizontalPanel af_stationary = Elements.checkBox("Stationary","af_stationary");
	public static HorizontalPanel af_antiStationary = Elements.checkBox("anticyclonic","af_antiStationary");
	public static HorizontalPanel af_cycloStationary = Elements.checkBox("cyclonic","af_cycloStationary");
	public static HorizontalPanel af_warmFront = Elements.checkBox("Warm front","af_warmFront");
	public static HorizontalPanel af_warmBelt = Elements.checkBox("Warm conveyor belt","af_warmBelt");
	public static HorizontalPanel af_coldFront = Elements.checkBox("Cold front","af_coldFront");
	public static HorizontalPanel af_occludedFront = Elements.checkBox("Occluded front","af_occludedFront");
	public static HorizontalPanel af_warmSector = Elements.checkBox("Warm sector","af_warmSector");
	public static HorizontalPanel af_airMass = Elements.checkBox("Post-cold-frontal air-mass","af_airMass");
	public static HorizontalPanel af_airOutbreack = Elements.checkBox("Arctic cold-air outbreak","af_airOutbreack");
	public static HorizontalPanel af_orographicInfluence = Elements.checkBox("Orographic influence","af_orographicInfluence");
	public static HorizontalPanel af_seabreezeFront = Elements.checkBox("Sea-breeze front","af_seabreezeFront");
	public static HorizontalPanel af_foldIntrusion = Elements.checkBox("Stratospheric fold/intrusion","af_foldIntrusion");
	public static HorizontalPanel af_convergenceLine = Elements.checkBox("Extended convergence line","af_convergenceLine");
	public static HorizontalPanel af_easterlyWave = Elements.checkBox("Easterly wave","af_easterlyWave");
	public static HorizontalPanel af_equatorialWave = Elements.checkBox("Equatorial wave","af_equatorialWave");
	public static HorizontalPanel af_tropicalCyclone = Elements.checkBox("Tropical cyclone","af_tropicalCyclone");
	public static HorizontalPanel af_organizedConvection = Elements.checkBox("Mesoscale organized convection","af_organizedConvection");
	public static ScrollPanel afScroll = new ScrollPanel(verticalPanel81);
	public static SimplePanel af_infoButton01 = Elements.addInfoButton("CHECKBOXES");
	public static SimplePanel af_infoButton02 = Elements.addInfoButton("COMMENTS");


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
	private HorizontalPanel horizontalPanel57 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel58 = new HorizontalPanel();
	public static VerticalPanel verticalPanel82 = new VerticalPanel();
	private Label ct_mainLab = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label ct_mainLab2 = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label ct_pathLab = new Label(">");
	private Label ct_pathLab2 = new Label("Cloud Types and Forms Sampled During Flight");
	private Label ct_comLabel = new Label("Comments");
	public static TextArea ct_comArea = new TextArea();
	public static TreeMap<String, String> ct_addCatMap = new TreeMap<String, String>();
	public static FlexTable ct_addCatTable = new FlexTable();
	public static HorizontalPanel ct_waterClouds = Elements.checkBox("Water clouds","ct_waterClouds");
	public static HorizontalPanel ct_mixedphasedClouds = Elements.checkBox("Mixed-phase clouds","ct_mixedphasedClouds");
	public static HorizontalPanel ct_iceClouds = Elements.checkBox("Ice clouds","ct_iceClouds");
	public static HorizontalPanel ct_cirrus = Elements.checkBox("Cirrus","ct_cirrus");
	public static HorizontalPanel ct_contrails = Elements.checkBox("Contrails","ct_contrails");
	public static HorizontalPanel ct_stratocumulus = Elements.checkBox("Stratocumulus","ct_stratocumulus");
	public static HorizontalPanel ct_shallowCumulus = Elements.checkBox("Shallow cumulus","ct_shallowCumulus");
	public static HorizontalPanel ct_cumulusCongestus = Elements.checkBox("Cumulus congestus","ct_cumulusCongestus");
	public static HorizontalPanel ct_cumulTower = Elements.checkBox("Cumulonimbus/towering cumulus","ct_cumulTower");
	public static HorizontalPanel ct_altoStracumul = Elements.checkBox("Altostratus/altocumulus","ct_altoStracumul");
	public static HorizontalPanel ct_waveClouds = Elements.checkBox("Wave clouds","ct_waveClouds");
	public static HorizontalPanel ct_statiformClouds = Elements.checkBox("Deep frontal statiform clouds","ct_statiformClouds");
	public static HorizontalPanel ct_freeAbove = Elements.checkBox("Cloud-free above aircraft","ct_freeAbove");
	public static HorizontalPanel ct_freeBelow = Elements.checkBox("Cloud-free below aircraft","ct_freeBelow");
	public static ScrollPanel ctScroll = new ScrollPanel(verticalPanel82);
	public static SimplePanel ct_infoButton01 = Elements.addInfoButton("CHECKBOXES");
	public static SimplePanel ct_infoButton02 = Elements.addInfoButton("COMMENTS");
	

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
	private HorizontalPanel horizontalPanel59 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel60 = new HorizontalPanel();
	public static VerticalPanel verticalPanel83 = new VerticalPanel();
	private Label cp_mainLab = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label cp_mainLab2 = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label cp_pathLab = new Label(">");
	private Label cp_pathLab2 = new Label("Cloud, Precipitation and Aerosol Particles Sampled");
	private Label cp_comLabel = new Label("Comments");
	public static TextArea cp_comArea = new TextArea();
	public static TreeMap<String, String> cp_addCatMap = new TreeMap<String, String>();
	public static FlexTable cp_addCatTable = new FlexTable();
	public static HorizontalPanel cp_rain = Elements.checkBox("Rain","cp_rain");
	public static HorizontalPanel cp_drizzle = Elements.checkBox("Drizzle","cp_drizzle");
	public static HorizontalPanel cp_dropletsLiquid = Elements.checkBox("Droplets (liquid)","cp_dropletsLiquid");
	public static HorizontalPanel cp_pristineCrystals = Elements.checkBox("Pristine ice crystals","cp_pristineCrystals");
	public static HorizontalPanel cp_snowAggregates = Elements.checkBox("Snow/aggregates","cp_snowAggregates");
	public static HorizontalPanel cp_graupelHail = Elements.checkBox("Graupel/hail","cp_graupelHail");
	public static HorizontalPanel cp_saltAerosol = Elements.checkBox("Sea-salt aerosol","cp_saltAerosol");
	public static HorizontalPanel cp_continentalAerosol = Elements.checkBox("Continental aerosol","cp_continentalAerosol");
	public static HorizontalPanel cp_urbanPlume = Elements.checkBox("Urban plume","cp_urbanPlume");
	public static HorizontalPanel cp_biomassBurning = Elements.checkBox("Biomass burning","cp_biomassBurning");
	public static HorizontalPanel cp_desertDust = Elements.checkBox("Desert/mineral dust","cp_desertDust");
	public static HorizontalPanel cp_volcanicAsh = Elements.checkBox("Volcanic ash","cp_volcanicAsh");
	public static ScrollPanel cpScroll = new ScrollPanel(verticalPanel83);
	public static SimplePanel cp_infoButton01 = Elements.addInfoButton("CHECKBOXES");
	public static SimplePanel cp_infoButton02 = Elements.addInfoButton("COMMENTS");


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
	private HorizontalPanel horizontalPanel61 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel62 = new HorizontalPanel();
	public static VerticalPanel verticalPanel84 = new VerticalPanel();
	private Label lo_mainLab = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label lo_mainLab2 = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label lo_pathLab = new Label(">");
	private Label lo_pathLab2 = new Label("Land or Oceans Surfaces Overflown");
	private Label lo_comLabel = new Label("Comments");
	public static TextArea lo_comArea = new TextArea();
	public static TreeMap<String, String> lo_addCatMap = new TreeMap<String, String>();
	public static FlexTable lo_addCatTable = new FlexTable();
	public static HorizontalPanel lo_ocean = Elements.checkBox("Ocean","lo_ocean");
	public static HorizontalPanel lo_semiArid = Elements.checkBox("Semi-arid","lo_semiArid");
	public static HorizontalPanel lo_seaIce = Elements.checkBox("Sea-ice","lo_seaIce");
	public static HorizontalPanel lo_desert = Elements.checkBox("Desert","lo_desert");
	public static HorizontalPanel lo_snow = Elements.checkBox("Snow","lo_snow");
	public static HorizontalPanel lo_urban = Elements.checkBox("Urban","lo_urban");
	public static HorizontalPanel lo_lakeIce = Elements.checkBox("Lake-ice","lo_lakeIce");
	public static HorizontalPanel lo_mountainous = Elements.checkBox("Mountainous","lo_mountainous");
	public static HorizontalPanel lo_vegetation = Elements.checkBox("Vegetation","lo_vegetation");
	public static HorizontalPanel lo_hilly = Elements.checkBox("Hilly","lo_hilly");
	public static HorizontalPanel lo_forest = Elements.checkBox("Forest","lo_forest");
	public static HorizontalPanel lo_flat = Elements.checkBox("Flat","lo_flat");
	public static ScrollPanel loScroll = new ScrollPanel(verticalPanel84);
	public static SimplePanel lo_infoButton01 = Elements.addInfoButton("CHECKBOXES");
	public static SimplePanel lo_infoButton02 = Elements.addInfoButton("COMMENTS");


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
	private HorizontalPanel horizontalPanel63 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel64 = new HorizontalPanel();
	public static VerticalPanel verticalPanel85 = new VerticalPanel();
	private Label ar_mainLab = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label ar_mainLab2 = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label ar_pathLab = new Label(">");
	private Label ar_pathLab2 = new Label("Altitude Range of Measurement");
	private Label ar_comLabel = new Label("Comments");
	public static TextArea ar_comArea = new TextArea();
	public static TreeMap<String, String> ar_addCatMap = new TreeMap<String, String>();
	public static FlexTable ar_addCatTable = new FlexTable();
	public static HorizontalPanel ar_boundaryLayer = Elements.checkBox("Boundary-layer","ar_boundaryLayer");
	public static HorizontalPanel ar_nearSurface = Elements.checkBox("near-surface","ar_nearSurface");
	public static HorizontalPanel ar_subCloud = Elements.checkBox("sub-cloud","ar_subCloud");
	public static HorizontalPanel ar_inCloud = Elements.checkBox("in-cloud","ar_inCloud");
	public static HorizontalPanel ar_lowerTroposphere = Elements.checkBox("Lower troposphere","ar_lowerTroposphere");
	public static HorizontalPanel ar_midTroposphere = Elements.checkBox("Mid troposphere","ar_midTroposphere");
	public static HorizontalPanel ar_upperTroposphere = Elements.checkBox("Upper troposphere","ar_upperTroposphere");
	public static HorizontalPanel ar_lowerstratosphere = Elements.checkBox("Lower stratosphere","ar_lowerstratosphere");
	public static ScrollPanel arScroll = new ScrollPanel(verticalPanel85);
	public static SimplePanel ar_infoButton01 = Elements.addInfoButton("CHECKBOXES");
	public static SimplePanel ar_infoButton02 = Elements.addInfoButton("COMMENTS");


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
	private HorizontalPanel horizontalPanel65 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel66 = new HorizontalPanel();
	public static VerticalPanel verticalPanel86 = new VerticalPanel();
	private Label fm_mainLab = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label fm_mainLab2 = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label fm_pathLab = new Label(">");
	private Label fm_pathLab2 = new Label("Types of Flight Manoeuvre");
	private Label fm_comLabel = new Label("Comments");
	public static TextArea fm_comArea = new TextArea();
	public static TreeMap<String, String> fm_addCatMap = new TreeMap<String, String>();
	public static FlexTable fm_addCatTable = new FlexTable();
	public static HorizontalPanel fm_levelRuns = Elements.checkBox("Straight/level runs","fm_levelRuns");
	public static HorizontalPanel fm_stacked = Elements.checkBox("stacked","fm_stacked");
	public static HorizontalPanel fm_separated = Elements.checkBox("separated","fm_separated");
	public static HorizontalPanel fm_racetracks = Elements.checkBox("Racetracks","fm_racetracks");
	public static HorizontalPanel fm_orbits = Elements.checkBox("Orbits","fm_orbits");
	public static HorizontalPanel fm_lagrangianDescents = Elements.checkBox("Lagrangian descents","fm_lagrangianDescents");
	public static HorizontalPanel fm_ascDescents = Elements.checkBox("Deep profile ascents/descents","fm_ascDescents");
	public static HorizontalPanel fm_dropsondeDeployed = Elements.checkBox("Dropsonde deployed","fm_dropsondeDeployed");
	public static HorizontalPanel fm_selfCalibration = Elements.checkBox("Self-calibration","fm_selfCalibration");
	public static ScrollPanel fmScroll = new ScrollPanel(verticalPanel86);
	public static SimplePanel fm_infoButton01 = Elements.addInfoButton("CHECKBOXES");
	public static SimplePanel fm_infoButton02 = Elements.addInfoButton("COMMENTS");


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
	private HorizontalPanel horizontalPanel67 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel68 = new HorizontalPanel();
	public static VerticalPanel verticalPanel87 = new VerticalPanel();
	private Label sc_mainLab = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label sc_mainLab2 = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label sc_pathLab = new Label(">");
	private Label sc_pathLab2 = new Label("Satellite Coordination");
	private Label sc_polarLabel = new Label("Polar");
	private Label sc_geosynchLabel = new Label("Geosynch");
	private Label sc_comLabel = new Label("Comments");
	public static TextArea sc_comArea = new TextArea();
	public static TreeMap<String, String> sc_addCatMap = new TreeMap<String, String>();
	public static FlexTable sc_addCatTable = new FlexTable();
	public static HorizontalPanel sc_metop = Elements.checkBox("METOP","sc_metop");
	public static HorizontalPanel sc_npoess = Elements.checkBox("NPOESS","sc_npoess");
	public static HorizontalPanel sc_atrain = Elements.checkBox("A-train","sc_atrain");
	public static HorizontalPanel sc_other = Elements.checkBox("Other (Polar)","sc_other");
	public static HorizontalPanel sc_msg = Elements.checkBox("MSG","sc_msg");
	public static HorizontalPanel sc_other2 = Elements.checkBox("Other (Geosynch)","sc_other2");
	public static HorizontalPanel sc_modis = Elements.checkBox("MODIS","sc_modis");
	public static HorizontalPanel sc_cloudsat = Elements.checkBox("Cloudsat","sc_cloudsat");
	public static HorizontalPanel sc_caliop = Elements.checkBox("CALIOP","sc_caliop");
	public static HorizontalPanel sc_iasi = Elements.checkBox("IASI","sc_iasi");
	public static HorizontalPanel sc_airs = Elements.checkBox("AIRS","sc_airs");
	public static HorizontalPanel sc_cris = Elements.checkBox("CriS","sc_cris");
	public static HorizontalPanel sc_amsuMhs = Elements.checkBox("AMSU/MHS","sc_amsuMhs");
	public static ScrollPanel scScroll = new ScrollPanel(verticalPanel87);
	public static SimplePanel sc_infoButton01 = Elements.addInfoButton("CHECKBOXES");
	public static SimplePanel sc_infoButton02 = Elements.addInfoButton("COMMENTS");


	// Supporting Surface-based Observations items initialization
	private VerticalPanel verticalPanel48 = new VerticalPanel();
	private ScrollPanel verticalPanel49 = new ScrollPanel();
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
	private HorizontalPanel horizontalPanel69 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel70 = new HorizontalPanel();
	public static VerticalPanel verticalPanel88 = new VerticalPanel();
	private Label so_mainLab = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label so_mainLab2 = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label so_pathLab = new Label(">");
	private Label so_pathLab2 = new Label("Supporting Surface-based Observations");
	private Label so_groundSitesLabel = new Label("Ground Sites");
	private Label so_armSitesLabel = new Label("ARM Sites");
	private Label so_researchVesselsLabel = new Label("Research Vessels");
	private Label so_mobileSitesLabel = new Label("ARM Mobile Sites");
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
	public static ScrollPanel soScroll = new ScrollPanel(verticalPanel88);
	public static SimplePanel so_infoButton01 = Elements.addInfoButton("SURFACEOBSERVATIONS");


	// Additional Notes on the Flight items initialization
	public static VerticalPanel verticalPanel66 = new VerticalPanel();
	private HorizontalPanel horizontalPanel71 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel72 = new HorizontalPanel();
	public static VerticalPanel verticalPanel89 = new VerticalPanel();
	private Label nf_mainLab = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label nf_mainLab2 = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label nf_pathLab = new Label(">");
	private Label nf_pathLab2 = new Label("Additional Notes on the Flight");
	public static TextArea nf_comArea = new TextArea();
	public static ScrollPanel nfScroll = new ScrollPanel(verticalPanel89);
	
	
	// Images to pdf
	public static VerticalPanel verticalPanel76 = new VerticalPanel();
	private HorizontalPanel horizontalPanel28 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel29 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel73 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel74 = new HorizontalPanel();
	public static VerticalPanel verticalPanel90 = new VerticalPanel();
	private Label im_mainLab = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label im_mainLab2 = new Label("AIRBORNE SCIENCE MISSION METADATA");
	private Label im_pathLab = new Label(">");
	private Label im_pathLab2 = new Label("Images included in the PDF report");
	public static ScrollPanel ipScroll = new ScrollPanel(verticalPanel90);
	private Label addButton = new Label("Add a new Image");
	private Label urlButton = new Label("Add a new Image (URL)");
	public static FlexTable imageTab = new FlexTable();
	public static ArrayList<String> imageCaption = new ArrayList<String>();
	public static ArrayList<String> imagePath = new ArrayList<String>();
	private Label informationLab = new Label("Use the following buttons to add images (JPG, PNG, BMP) to the PDF file. The number of images "
			+ "is limited to 10, and the size of each image cannot exceed 5 MB. All images will be included in the PDF report but not in the "
			+ "XML file.");
	public static Label imageLab = new Label("Image");
	public static Label captionLab= new Label("Caption");
	

	// On module load
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
		if (GWT.getHostPageBaseURL() != "http://127.0.0.1:8888/") {
			asmmPath = GWT.getHostPageBaseURL();
		}
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
				newFile();
			}
		};
		
		
		Command openFile = new Command() {
			public void execute() {
				openFile();
			}
		};
		
		
		Command saveFile = new Command() {
			public void execute() {
				runCheck("");
			}
		};
		
		
		Command printFile = new Command() {
			public void execute() {
			PopupMessages.printFile();
			}
		};
		
		
		Command launchHelpPage = new Command()  {
			public void execute() {
				Window.open("http://www.eufar.net/cms/airborne-science-mission-metadata-help/", "_blank", "");
			}
		};
		
		
		Command launchN7SPPage = new Command()  {
			public void execute() {
				Window.open("http://www.eufar.net/cms/standards-and-protocols/", "_blank", "");
			}
		};
		
		
		Command exitFile = new Command()  {
			public void execute() {
				Window.open("http://www.eufar.net", "_self", "");
			}
		};
		
		
		Command displayChangelog = new Command() {
			public void execute() {
				PopupMessages.changelogPanel();
			}
		};
		
		
		Command goFlight = new Command() {
			public void execute() {
				tabPanel.selectTab(0);
			}
		};
		
		Command goAims = new Command() {
			public void execute() {
				tabPanel.selectTab(1);
			}
		};
		
		Command goInformation = new Command() {
			public void execute() {
				tabPanel.selectTab(2);
			}
		};
		
		Command goFeatures = new Command() {
			public void execute() {
				tabPanel.selectTab(3);
			}
		};
		
		Command goForms = new Command() {
			public void execute() {
				tabPanel.selectTab(4);
			}
		};
		
		Command goParticles = new Command() {
			public void execute() {
				tabPanel.selectTab(5);
			}
		};
		
		Command goSurfaces = new Command() {
			public void execute() {
				tabPanel.selectTab(6);
			}
		};
		
		Command goMeasurement = new Command() {
			public void execute() {
				tabPanel.selectTab(7);
			}
		};
		
		Command goManoeuvre = new Command() {
			public void execute() {
				tabPanel.selectTab(8);
			}
		};
		
		Command goCoordination = new Command() {
			public void execute() {
				tabPanel.selectTab(9);
			}
		};
		
		Command goObservations = new Command() {
			public void execute() {
				tabPanel.selectTab(10);
			}
		};
		
		Command goNotes = new Command() {
			public void execute() {
				tabPanel.selectTab(11);
			}
		};
		
		Command goPdf = new Command() {
			public void execute() {
				tabPanel.selectTab(12);
			}
		};
		

		// Assemble the header
		horizontalPanel87.add(hdTitleLab);
		horizontalPanel87.setStyleName("headerHorizontalPanel");
		horizontalPanel87.getElement().setAttribute("style", "background-position: " + screen_width/6 + "px;");
		hdTitleLab.setStyleName("headerTextLabel");
		
		
		// Assemble the footer
		horizontalPanel112.add(horizontalPanel113);
		horizontalPanel112.add(horizontalPanel114);
		horizontalPanel112.add(horizontalPanel115);
		horizontalPanel113.add(leftHtml);
		horizontalPanel113.add(leftLabel);
		horizontalPanel114.add(centerHtml);
		horizontalPanel114.add(centerLabel);
		horizontalPanel115.add(rightHtml);
		horizontalPanel115.add(rightLabel);
		horizontalPanel113.setStyleName("footerLeft");
		horizontalPanel114.setStyleName("footerCenter");
		horizontalPanel115.setStyleName("footerRight");
		horizontalPanel113.getElement().setAttribute("style", "margin-left: " + menu_width + "px !important;");
		horizontalPanel114.getElement().setAttribute("style", "margin-left: 460px !important;");
		horizontalPanel115.getElement().setAttribute("style", "margin-left: 490px !important;");
		leftLabel.setStyleName("footerLeftLabel");
		rightLabel.setStyleName("footerRightLabel");
		centerLabel.setStyleName("footerCenterLabel");
		horizontalPanel113.addMouseOverHandler(new MouseOverHandler() {
			public void onMouseOver(MouseOverEvent event) {
				leftLabel.getElement().setAttribute("style", "color: #F9A12A;");
			    horizontalPanel113.getElement().setAttribute("style", "cursor: pointer; !important; "
			    		+ "margin-left: " + menu_width + "px !important;");
			    horizontalPanel113.remove(0);
			    horizontalPanel113.insert(leftHtml2, 0);
			}
		});
		horizontalPanel113.addMouseOutHandler(new MouseOutHandler() {
			public void onMouseOut(MouseOutEvent event) {
				leftLabel.getElement().setAttribute("style", "color: #616265;");
				horizontalPanel113.remove(0);
				horizontalPanel113.insert(leftHtml, 0);
			}
		});
		horizontalPanel113.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				navigateTab(-1);
			}
		});
		horizontalPanel114.addMouseOverHandler(new MouseOverHandler() {
			public void onMouseOver(MouseOverEvent event) {
				centerLabel.getElement().setAttribute("style", "color: #F9A12A;");
				horizontalPanel114.getElement().setAttribute("style", "cursor: pointer; margin-left: 460px !important;");
				horizontalPanel114.remove(0);
				horizontalPanel114.insert(centerHtml2, 0);
			}
		});
		horizontalPanel114.addMouseOutHandler(new MouseOutHandler() {
			public void onMouseOut(MouseOutEvent event) {
				centerLabel.getElement().setAttribute("style", "color: #616265;");
				horizontalPanel114.remove(0);
				horizontalPanel114.insert(centerHtml, 0);
			}
		});
		horizontalPanel114.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				tabPanel.selectTab(0);
			}
		});
		horizontalPanel115.addMouseOverHandler(new MouseOverHandler() {
			public void onMouseOver(MouseOverEvent event) {
				rightLabel.getElement().setAttribute("style", "color: #F9A12A;");
				horizontalPanel115.getElement().setAttribute("style", "cursor: pointer; margin-left: 490px !important;");
				horizontalPanel115.remove(0);
				horizontalPanel115.insert(rightHtml2, 0);
			}
		});
		horizontalPanel115.addMouseOutHandler(new MouseOutHandler() {
			public void onMouseOut(MouseOutEvent event) {
				rightLabel.getElement().setAttribute("style", "color: #616265;");
				horizontalPanel115.remove(0);
				horizontalPanel115.insert(rightHtml, 0);
			}
		});
		horizontalPanel115.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				navigateTab(1);
			}
		});
		

		// Menu bar items
		mainMenu.addItem(new MenuItem(imageASMM,true,asmmMenu));
		asmmMenu.addItem("Flight and Contact Information", goFlight);
		asmmMenu.addItem("Scientific Aims", goAims);
		asmmMenu.addItem("Geographic Information", goInformation);
		asmmMenu.addItem("Atmospheric Synoptic Features", goFeatures);
		asmmMenu.addItem("Cloud Types and Forms Sampled During Flight", goForms);
		asmmMenu.addItem("Cloud, Precipitation and Aerosol Particles Sampled", goParticles);
		asmmMenu.addItem("Land or Oceans Surfaces Overflown", goSurfaces);
		asmmMenu.addItem("Altitude Range of Measurement", goMeasurement);
		asmmMenu.addItem("Types of Flight Manoeuvre", goManoeuvre);
		asmmMenu.addItem("Satellite Coordination", goCoordination);
		asmmMenu.addItem("Supporting Surface-based Observations", goObservations);
		asmmMenu.addItem("Additional Notes on the Flight", goNotes);
		asmmMenu.addItem("Images included in the PDF report", goPdf);
		asmmMenu.addSeparator();
		asmmMenu.addItem("File", fileMenu);
		asmmMenu.addItem("About", aboutMenu);
		asmmMenu.addItem("Help", launchHelpPage);
		aboutMenu.addItem("ASMM Creator",aboutWindow);
		aboutMenu.addItem("ASMM XML standard",aboutStandard);
		aboutMenu.addItem("EUFAR N7SP",launchN7SPPage);
		aboutMenu.addSeparator();
		aboutMenu.addItem("Changelog",displayChangelog);
		fileMenu.addItem("New",newFile);
		fileMenu.addItem("Open",openFile);
		fileMenu.addItem("Save",saveFile);
		fileMenu.addItem("Print",printFile);
		fileMenu.addItem("Exit",exitFile);
		mainMenu.getElement().setAttribute("style", "padding-left: " + (menu_width - 70) + "px !important;");
		

		// Assemble Flight Information panel
		horizontalPanel49.add(fi_mainLab);
		horizontalPanel49.add(fi_pathLab);
		horizontalPanel49.add(fi_pathLab2);
		horizontalPanel50.add(new HTML("<hr  style=\"width:1200px;height:10px;background:#c0c0c0;border:0px;\" />"));
		verticalPanel58.add(fi_mainLab2);
		verticalPanel58.add(horizontalPanel49);
		verticalPanel58.add(horizontalPanel50);
		verticalPanel58.add(verticalPanel59);
		verticalPanel59.add(fi_flightInfo);
		verticalPanel59.add(fiGrid);
		verticalPanel59.add(new HTML("<hr  style=\"width:1150px;height:10px;background:#0098d9;border:0px;margin-top:30px;"
				+ "margin-bottom:30px;\" />"));
		verticalPanel59.add(ci_contactInfo);
		verticalPanel59.add(ciGrid);
		Utilities.populateListBox(fi_operatorText, operatorList, 0);
		Utilities.populateListBox(geoLocationLst, locationList, 0);
		horizontalPanel26.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel27.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel30.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel26.add(fi_operatorText);
		horizontalPanel26.add(fi_operatorImage);
		horizontalPanel26.add(fi_otherOpsText);
		horizontalPanel26.add(fi_infoButton06);
		horizontalPanel27.add(fi_aircraftText);
		horizontalPanel27.add(fi_aircraftImage);
		horizontalPanel27.add(fi_otherAiText);
		fi_operatorImage.setVisible(false);
		fi_otherOpsText.setVisible(false);
		fi_aircraftImage.setVisible(false);
		fi_otherAiText.setVisible(false);
		horizontalPanel75.add(fi_campaignLabel);
		horizontalPanel75.add(fi_starLab01);
		horizontalPanel76.add(fi_dateLabel);
		horizontalPanel76.add(fi_starLab02);
		horizontalPanel77.add(fi_flightLabel);
		horizontalPanel77.add(fi_starLab03);
		horizontalPanel78.add(fi_scientistLabel);
		horizontalPanel78.add(fi_starLab04);
		horizontalPanel79.add(fi_managerLabel);
		horizontalPanel79.add(fi_starLab05);
		horizontalPanel80.add(fi_operatorLabel);
		horizontalPanel80.add(fi_starLab06);
		horizontalPanel81.add(fi_aircraftLabel);
		horizontalPanel81.add(fi_starLab07);
		horizontalPanel82.add(fi_countryLabel);
		horizontalPanel82.add(fi_starLab08);
		horizontalPanel91.add(fi_campaignText);
		horizontalPanel91.add(fi_infoButton01);
		horizontalPanel92.add(fi_dateText);
		horizontalPanel92.add(fi_infoButton02);
		horizontalPanel93.add(fi_flightText);
		horizontalPanel93.add(fi_infoButton03);
		horizontalPanel94.add(fi_scientistText);
		horizontalPanel94.add(fi_infoButton04);
		horizontalPanel95.add(fi_managerText);
		horizontalPanel95.add(fi_infoButton05);
		horizontalPanel30.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel30.add(geoLocationLst);
		horizontalPanel30.add(geoFollowImage);
		horizontalPanel30.add(geoDetailLst);
		horizontalPanel30.add(fi_infoButton07);
		fi_dateText.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("yyyy-MM-dd")));
		fi_dateText.setValue(new Date());
		fiGrid.setWidget(0, 0, horizontalPanel75);
		fiGrid.setWidget(0, 1, horizontalPanel91);
		fiGrid.setWidget(1, 0, horizontalPanel76);
		fiGrid.setWidget(1, 1, horizontalPanel92);
		fiGrid.setWidget(2, 0, horizontalPanel77);
		fiGrid.setWidget(2, 1, horizontalPanel93);
		fiGrid.setWidget(3, 0, horizontalPanel78);
		fiGrid.setWidget(3, 1, horizontalPanel94);
		fiGrid.setWidget(4, 0, horizontalPanel79);
		fiGrid.setWidget(4, 1, horizontalPanel95);
		fiGrid.setWidget(5, 0, horizontalPanel80);
		fiGrid.setWidget(5, 1, horizontalPanel26);
		fiGrid.setWidget(6, 0, horizontalPanel81);
		fiGrid.setWidget(6, 1, horizontalPanel27);
		fiGrid.setWidget(7, 0, horizontalPanel82);
		fiGrid.setWidget(7, 1, horizontalPanel30);
		FlexCellFormatter fi_cellFormatter = fiGrid.getFlexCellFormatter();
		fi_cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		fi_cellFormatter.setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		fi_cellFormatter.setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		fi_cellFormatter.setHorizontalAlignment(3, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		fi_cellFormatter.setHorizontalAlignment(4, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		fi_cellFormatter.setHorizontalAlignment(5, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		fi_cellFormatter.setHorizontalAlignment(6, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		fi_cellFormatter.setHorizontalAlignment(7, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		fi_aircraftText.setEnabled(false);
		geoDetailLst.setEnabled(false);
		fi_campaignText.setName("flightCampaign");
		fi_dateText.getTextBox().setName("date");
		fi_flightText.setName("flightNumber");
		fi_scientistText.setName("flightScientist");
		fi_managerText.setName("flightManager");
		fi_operatorText.setName("operatorText");
		fi_aircraftText.setName("aircraftText");
		geoDetailLst.setName("countryText");
		fi_starLab01.setStyleName("fi_starLabel");
		fi_starLab02.setStyleName("fi_starLabel");
		fi_starLab03.setStyleName("fi_starLabel");
		fi_starLab04.setStyleName("fi_starLabel");
		fi_starLab05.setStyleName("fi_starLabel");
		fi_starLab06.setStyleName("fi_starLabel");
		fi_starLab07.setStyleName("fi_starLabel");
		fi_starLab08.setStyleName("fi_starLabel");
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
		fi_aircraftText.setName("aircraftText");
		fiGrid.setStyleName("fi_grid");
		ciGrid.setStyleName("ci_grid");
		fi_dateText.setStyleName("fi_dateBox");
		fi_flightInfo.setStyleName("fi_textLabelTitle");
		fi_campaignLabel.setStyleName("fi_textLabel");
		fi_dateLabel.setStyleName("fi_textLabel");
		fi_flightLabel.setStyleName("fi_textLabel");
		fi_scientistLabel.setStyleName("fi_textLabel");
		fi_managerLabel.setStyleName("fi_textLabel");
		fi_operatorLabel.setStyleName("fi_textLabel");
		fi_aircraftLabel.setStyleName("fi_textLabel");
		fi_countryLabel.setStyleName("fi_textLabel");
		verticalPanel58.getElement().setAttribute("style", 
				"margin-top: " + (new_clouds_heading_height - 31) + "px !important;");
		fiScroll.getElement().setAttribute("style", 
				"background-image: url(icons/eufar_heading_clouds.jpg) !important; "
				+ "background-repeat: no-repeat !important;" 
				+ "background-size: " + screen_width + "px " + new_clouds_heading_height + "px !important;"
				+ "background-position: -" + menu_width + "px 0px !important;"
				+ "overflow: auto !important;");
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
		fi_mainLab.setStyleName("fi_mainText");
		fi_mainLab2.setStyleName("fi_mainText2");
		fi_pathLab.setStyleName("fi_pathText");
		fi_pathLab2.setStyleName("fi_pathText2");
		horizontalPanel50.setStyleName("fi_line");
		verticalPanel59.setStyleName("fi_verticalPanel");
		rootLogger.log(Level.INFO, "Flight Information panel initialized");


		// Assemble Contact Information panel
		horizontalPanel83.add(ci_nameLabel);
		horizontalPanel83.add(ci_starLab01);
		horizontalPanel84.add(ci_roleLabel);
		horizontalPanel84.add(ci_starLab02);
		horizontalPanel85.add(ci_emailLabel);
		horizontalPanel85.add(ci_starLab03);
		horizontalPanel96.add(ci_nameText);
		horizontalPanel96.add(ci_infoButton01);
		horizontalPanel97.add(ci_roleText);
		horizontalPanel97.add(ci_infoButton02);
		horizontalPanel98.add(ci_emailText);
		horizontalPanel98.add(ci_infoButton03);
		Utilities.populateListBox(ci_roleText, roleList, 0);
		ci_roleText.setName("roleText");
		ciGrid.setWidget(0, 0, horizontalPanel83);
		ciGrid.setWidget(0, 1, horizontalPanel96);
		ciGrid.setWidget(1, 0, horizontalPanel84);
		ciGrid.setWidget(1, 1, horizontalPanel97);
		ciGrid.setWidget(2, 0, horizontalPanel85);
		ciGrid.setWidget(2, 1, horizontalPanel98);
		FlexCellFormatter ci_cellFormatter = ciGrid.getFlexCellFormatter();
		ci_cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		ci_cellFormatter.setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		ci_cellFormatter.setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		ci_nameText.setName("contactName");
		ci_emailText.setName("contactEmail");
		ci_roleText.setName("roleText");
		ci_starLab01.setStyleName("fi_starLabel");
		ci_starLab02.setStyleName("fi_starLabel");
		ci_starLab03.setStyleName("fi_starLabel");
		ci_nameText.setStyleName("fi_textBox");
		ci_emailText.setStyleName("fi_textBox");
		ci_roleText.setStyleName("ci_textList");
		ci_nameLabel.setStyleName("fi_textLabel");
		ci_roleLabel.setStyleName("fi_textLabel");
		ci_emailLabel.setStyleName("fi_textLabel");
		ci_contactInfo.setStyleName("fi_textLabelTitle");
		rootLogger.log(Level.INFO, "Contact Information panel initialized");


		// Assemble Scientific Aims panel.
		verticalPanel60.add(sa_mainLab2);
		horizontalPanel51.add(sa_mainLab);
		horizontalPanel51.add(sa_pathLab);
		horizontalPanel51.add(sa_pathLab2);
		horizontalPanel52.add(new HTML("<hr  style=\"width:1200px;height:10px;background:#c0c0c0;border:0px;\" />"));
		verticalPanel60.add(horizontalPanel51);
		verticalPanel60.add(horizontalPanel52);
		verticalPanel60.add(verticalPanel10);
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
		verticalPanel05.add(sa_aeroSol);
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
		horizontalPanel01.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel01.add(verticalPanel03);
		horizontalPanel01.add(verticalPanel06);
		horizontalPanel01.add(verticalPanel09);
		horizontalPanel01.add(sa_infoButton01);
		verticalPanel10.add(horizontalPanel01);
		verticalPanel10.add(new HTML("<br>"));
		Label sa_addCatButton = GuiModification.addCatButton(sa_addCatTable, sa_addCatMap, verticalPanel67);
		horizontalPanel31.add(sa_addCatButton);
		SimplePanel sa_infoButton = Elements.addInfoButton("newCheckBox");
		sa_infoButton.getElement().setAttribute("style", "margin-top: 1px !important;");
		horizontalPanel31.add(sa_infoButton);
		verticalPanel67.add(horizontalPanel31);
		verticalPanel10.add(verticalPanel67);
		verticalPanel10.add(new HTML("<br>"));
		verticalPanel10.add(new HTML("<br>"));
		horizontalPanel02.add(sa_comments);
		horizontalPanel02.add(sa_comArea);
		horizontalPanel02.add(sa_infoButton02);
		verticalPanel10.add(horizontalPanel02);
		sa_comArea.setName("scientificComments");
		sa_gazChemistry.setStyleName("sa_checkBox3");
		sa_radIation.setStyleName("sa_checkBox3");
		sa_aeroSol.setStyleName("sa_checkBox3");
		sa_satCalval.setStyleName("sa_checkBox3");
		sa_antPollution.setStyleName("sa_checkBox3");
		sa_mesoImpacts.setStyleName("sa_checkBox3");
		verticalPanel08.setStyleName("sa_verticalPanel");
		sa_cloudLabel.setStyleName("gi_titleText2");
		verticalPanel02.setStyleName("sa_verticalPanel");
		verticalPanel04.setStyleName("sa_verticalPanel");
		verticalPanel05.setStyleName("sa_verticalPanel");
		verticalPanel07.setStyleName("sa_verticalPanel");
		sa_layerLabel.setStyleName("gi_titleText2");
		sa_comments.setStyleName("af_titleText");
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
		sa_mainLab.setStyleName("fi_mainText");
		sa_mainLab2.setStyleName("fi_mainText2");
		sa_pathLab.setStyleName("fi_pathText");
		sa_pathLab2.setStyleName("fi_pathText2");
		horizontalPanel52.setStyleName("fi_line");
		verticalPanel10.setStyleName("sa_verticalPanel2");
		verticalPanel60.getElement().setAttribute("style", 
				"margin-top: " + (new_clouds_heading_height - 31) + "px !important;");
		saScroll.getElement().setAttribute("style", 
				"background-image: url(icons/eufar_heading_clouds.jpg) !important; "
				+ "background-repeat: no-repeat !important;" 
				+ "background-size: " + screen_width + "px " + new_clouds_heading_height + "px !important;"
				+ "background-position: -" + menu_width + "px 0px !important;"
				+ "overflow: auto !important;");
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
		horizontalPanel53.add(gi_mainLab);
		horizontalPanel53.add(gi_pathLab);
		horizontalPanel53.add(gi_pathLab2);
		horizontalPanel54.add(new HTML("<hr  style=\"width:1200px;height:10px;background:#c0c0c0;border:0px;\" />"));
		verticalPanel80.add(gi_mainLab2);
		verticalPanel80.add(horizontalPanel53);
		verticalPanel80.add(horizontalPanel54);
		verticalPanel80.add(verticalPanel11);
		verticalPanel11.add(gi_boundingLabel);
		gi_boundTable.setCellSpacing(10);
		gi_boundTable.setWidget(0, 0, gi_nsLabel);
		gi_boundTable.setWidget(0, 1, gi_northText);
		gi_boundTable.setWidget(0, 2, gi_southText);
		gi_boundTable.setWidget(0, 3, gi_infoButtonSN);
		gi_boundTable.setWidget(0, 4, gi_mmLabel);
		gi_boundTable.setWidget(0, 5, gi_minText);
		gi_boundTable.setWidget(0, 6, gi_maxText);
		gi_boundTable.setWidget(0, 7, gi_infoButtonMM);
		gi_boundTable.setWidget(1, 0, gi_weLabel);
		gi_boundTable.setWidget(1, 1, gi_westText);
		gi_boundTable.setWidget(1, 2, gi_eastText);
		gi_boundTable.setWidget(1, 3, gi_infoButtonWE);
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
		horizontalPanel05.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel05.add(gi_infoButton01);
		verticalPanel11.add(horizontalPanel05);
		horizontalPanel40.add(GuiModification.addCatButton(gi_addCatTable, gi_addCatMap, verticalPanel68));
		SimplePanel gi_infoButton = Elements.addInfoButton("newCheckBox");
		gi_infoButton.getElement().setAttribute("style", "margin-top: 1px !important;");
		horizontalPanel40.add(gi_infoButton);
		verticalPanel68.add(horizontalPanel40);
		verticalPanel11.add(verticalPanel68);
		verticalPanel11.add(new HTML("<br />"));
		horizontalPanel06.add(gi_comLabel);
		horizontalPanel06.add(gi_comArea);
		horizontalPanel06.add(gi_infoButton02);
		verticalPanel11.add(horizontalPanel06);
		verticalPanel11.setSpacing(10);
		gi_northText.setName("northBound");
		gi_southText.setName("southBound");
		gi_minText.setName("minAltitude");
		gi_maxText.setName("maxAltitude");
		gi_westText.setName("westBound");
		gi_eastText.setName("eastBound");
		gi_comArea.setName("geographicComments");
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
		gi_polar.setStyleName("gi_checkBox");
		gi_midLatitudes.setStyleName("gi_checkBox");
		gi_subTropical.setStyleName("gi_checkBox");
		gi_tropical.setStyleName("gi_checkBox");
		gi_maritime.setStyleName("gi_checkBox");
		gi_continental.setStyleName("gi_checkBox");
		gi_oceanicIslands.setStyleName("gi_checkBox");
		gi_other.setStyleName("gi_checkBox");
		gi_nsLabel.setStyleName("gi_textLabel");
		gi_mmLabel.setStyleName("gi_textLabel");
		gi_weLabel.setStyleName("gi_textLabel");
		gi_mainLab.setStyleName("fi_mainText");
		gi_mainLab2.setStyleName("fi_mainText2");
		gi_pathLab.setStyleName("fi_pathText");
		gi_pathLab2.setStyleName("fi_pathText2");
		horizontalPanel54.setStyleName("fi_line");
		verticalPanel11.setStyleName("gi_verticalPanel");
		verticalPanel80.getElement().setAttribute("style", 
				"margin-top: " + (new_clouds_heading_height - 31) + "px !important;");
		giScroll.getElement().setAttribute("style", 
				"background-image: url(icons/eufar_heading_clouds.jpg) !important; "
				+ "background-repeat: no-repeat !important;" 
				+ "background-size: " + screen_width + "px " + new_clouds_heading_height + "px !important;"
				+ "background-position: -" + menu_width + "px 0px !important;"
				+ "overflow: auto !important;");
		horizontalPanel03.getElement().setAttribute("style", "margin-left: 40px !important;");
		verticalPanel15.getElement().setAttribute("style", "margin-left: 20px !important;");
		horizontalPanel05.getElement().setAttribute("style", "margin-left: 40px !important;");
		verticalPanel63.getElement().setAttribute("style", "margin-left: 150px !important;");
		verticalPanel64.getElement().setAttribute("style", "margin-left: 150px !important;");
		verticalPanel65.getElement().setAttribute("style", "margin-left: 150px !important;");
		gi_mmLabel.getElement().setAttribute("style", "margin-left: 210px !important;");
		gi_infoButtonSN.getElement().setAttribute("style", "margin-left: 0px !important;");
		gi_infoButtonWE.getElement().setAttribute("style", "margin-left: 0px !important;");
		gi_infoButtonMM.getElement().setAttribute("style", "margin-left: 0px !important;");
		rootLogger.log(Level.INFO, "Geographic Information panel initialized");


		// Assemble Atmospheric Synoptic Features panel
		horizontalPanel55.add(af_mainLab);
		horizontalPanel55.add(af_pathLab);
		horizontalPanel55.add(af_pathLab2);
		horizontalPanel56.add(new HTML("<hr  style=\"width:1200px;height:10px;background:#c0c0c0;border:0px;\" />"));
		verticalPanel81.add(af_mainLab2);
		verticalPanel81.add(horizontalPanel55);
		verticalPanel81.add(horizontalPanel56);
		verticalPanel81.add(verticalPanel20);
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
		verticalPanel17.add(af_airOutbreack);
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
		horizontalPanel07.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel07.add(af_infoButton01);
		verticalPanel20.add(horizontalPanel07);
		verticalPanel20.add(new HTML("<br>"));
		horizontalPanel41.add(GuiModification.addCatButton(af_addCatTable, af_addCatMap, verticalPanel69));
		SimplePanel af_infoButton = Elements.addInfoButton("newCheckBox");
		af_infoButton.getElement().setAttribute("style", "margin-top: 1px !important;");
		horizontalPanel41.add(af_infoButton);
		verticalPanel69.add(horizontalPanel41);
		verticalPanel20.add(verticalPanel69);
		verticalPanel20.add(new HTML("<br>"));
		horizontalPanel08.add(af_comLabel);
		horizontalPanel08.add(af_comArea);
		horizontalPanel08.add(af_infoButton02);
		verticalPanel20.add(horizontalPanel08);
		af_comArea.setName("atmosphericComments");
		af_comLabel.setStyleName("af_titleText");
		af_comArea.setStyleName("sa_textArea");
		af_stationary.setStyleName("af_checkBox");
		af_antiStationary.setStyleName("af_checkBox");
		af_antiStationary.getElement().setAttribute("style", "margin-left: 40px !important;");
		af_cycloStationary.setStyleName("af_checkBox");
		af_cycloStationary.getElement().setAttribute("style", "margin-left: 40px !important;");
		af_warmFront.setStyleName("af_checkBox");
		af_warmBelt.setStyleName("af_checkBox");
		af_coldFront.setStyleName("af_checkBox");
		af_occludedFront.setStyleName("af_checkBox");
		af_warmSector.setStyleName("af_checkBox");
		af_airMass.setStyleName("af_checkBox");
		af_airOutbreack.setStyleName("af_checkBox");
		af_orographicInfluence.setStyleName("af_checkBox");
		af_seabreezeFront.setStyleName("af_checkBox");
		af_foldIntrusion.setStyleName("af_checkBox");
		af_convergenceLine.setStyleName("af_checkBox");
		af_easterlyWave.setStyleName("af_checkBox");
		af_equatorialWave.setStyleName("af_checkBox");
		af_tropicalCyclone.setStyleName("af_checkBox");
		af_organizedConvection.setStyleName("af_checkBox");
		af_mainLab.setStyleName("fi_mainText");
		af_mainLab2.setStyleName("fi_mainText2");
		af_pathLab.setStyleName("fi_pathText");
		af_pathLab2.setStyleName("fi_pathText2");
		horizontalPanel56.setStyleName("fi_line");
		verticalPanel20.setStyleName("af_verticalPanel");
		verticalPanel81.getElement().setAttribute("style", 
				"margin-top: " + (new_clouds_heading_height - 31) + "px !important;");
		afScroll.getElement().setAttribute("style", 
				"background-image: url(icons/eufar_heading_clouds.jpg) !important; "
				+ "background-repeat: no-repeat !important;" 
				+ "background-size: " + screen_width + "px " + new_clouds_heading_height + "px !important;"
				+ "background-position: -" + menu_width + "px 0px !important;"
				+ "overflow: auto !important;");
		verticalPanel17.getElement().setAttribute("style", "margin-left: 50px !important;");
		verticalPanel18.getElement().setAttribute("style", "margin-left: 50px !important;");
		verticalPanel19.getElement().setAttribute("style", "margin-left: 50px !important;");
		rootLogger.log(Level.INFO, "Atmospheric Synoptic Features panel initialized");


		// Assemble Cloud Types and Forms Sampled During Flight panel
		horizontalPanel57.add(ct_mainLab);
		horizontalPanel57.add(ct_pathLab);
		horizontalPanel57.add(ct_pathLab2);
		horizontalPanel58.add(new HTML("<hr  style=\"width:1200px;height:10px;background:#c0c0c0;border:0px;\" />"));
		verticalPanel82.add(ct_mainLab2);
		verticalPanel82.add(horizontalPanel57);
		verticalPanel82.add(horizontalPanel58);
		verticalPanel82.add(verticalPanel25);
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
		horizontalPanel09.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel09.add(ct_infoButton01);
		verticalPanel25.add(horizontalPanel09);
		verticalPanel25.add(new HTML("<br>"));
		horizontalPanel42.add(GuiModification.addCatButton(ct_addCatTable, ct_addCatMap, verticalPanel70));
		SimplePanel ct_infoButton = Elements.addInfoButton("newCheckBox");
		ct_infoButton.getElement().setAttribute("style", "margin-top: 1px !important;");
		horizontalPanel42.add(ct_infoButton);
		verticalPanel70.add(horizontalPanel42);
		verticalPanel25.add(verticalPanel70);
		verticalPanel25.add(new HTML("<br>"));
		horizontalPanel10.add(ct_comLabel);
		horizontalPanel10.add(ct_comArea);
		horizontalPanel10.add(ct_infoButton02);
		verticalPanel25.add(horizontalPanel10);
		ct_comArea.setName("typesComments");
		ct_comLabel.setStyleName("ct_titleText");
		ct_comArea.setStyleName("sa_textArea");
		ct_waterClouds.setStyleName("ct_checkBox");
		ct_mixedphasedClouds.setStyleName("ct_checkBox");
		ct_iceClouds.setStyleName("ct_checkBox");
		ct_cirrus.setStyleName("ct_checkBox");
		ct_contrails.setStyleName("ct_checkBox");
		ct_stratocumulus.setStyleName("ct_checkBox");
		ct_shallowCumulus.setStyleName("ct_checkBox");
		ct_cumulusCongestus.setStyleName("ct_checkBox");
		ct_cumulTower.setStyleName("ct_checkBox");
		ct_altoStracumul.setStyleName("ct_checkBox");
		ct_waveClouds.setStyleName("ct_checkBox");
		ct_statiformClouds.setStyleName("ct_checkBox");
		ct_freeAbove.setStyleName("ct_checkBox");
		ct_freeBelow.setStyleName("ct_checkBox");
		ct_mainLab.setStyleName("fi_mainText");
		ct_mainLab2.setStyleName("fi_mainText2");
		ct_pathLab.setStyleName("fi_pathText");
		ct_pathLab2.setStyleName("fi_pathText2");
		horizontalPanel58.setStyleName("fi_line");
		verticalPanel25.setStyleName("af_verticalPanel");
		verticalPanel82.getElement().setAttribute("style", 
				"margin-top: " + (new_clouds_heading_height - 31) + "px !important;");
		ctScroll.getElement().setAttribute("style", 
				"background-image: url(icons/eufar_heading_clouds.jpg) !important; "
				+ "background-repeat: no-repeat !important;" 
				+ "background-size: " + screen_width + "px " + new_clouds_heading_height + "px !important;"
				+ "background-position: -" + menu_width + "px 0px !important;"
				+ "overflow: auto !important;");
		verticalPanel22.getElement().setAttribute("style", "margin-left: 60px !important;");
		verticalPanel23.getElement().setAttribute("style", "margin-left: 60px !important;");
		verticalPanel24.getElement().setAttribute("style", "margin-left: 60px !important;");
		rootLogger.log(Level.INFO, "Cloud Types and Forms Sampled During Flight panel initialized");


		// Assemble Cloud, Precipitation and Aerosol Particles Sampled panel
		horizontalPanel59.add(cp_mainLab);
		horizontalPanel59.add(cp_pathLab);
		horizontalPanel59.add(cp_pathLab2);
		horizontalPanel60.add(new HTML("<hr  style=\"width:1200px;height:10px;background:#c0c0c0;border:0px;\" />"));
		verticalPanel83.add(cp_mainLab2);
		verticalPanel83.add(horizontalPanel59);
		verticalPanel83.add(horizontalPanel60);
		verticalPanel83.add(verticalPanel30);
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
		horizontalPanel11.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel11.add(cp_infoButton01);
		verticalPanel30.add(horizontalPanel11);
		verticalPanel30.add(new HTML("<br>"));
		horizontalPanel43.add(GuiModification.addCatButton(cp_addCatTable, cp_addCatMap, verticalPanel71));
		SimplePanel cp_infoButton = Elements.addInfoButton("newCheckBox");
		cp_infoButton.getElement().setAttribute("style", "margin-top: 1px !important;");
		horizontalPanel43.add(cp_infoButton);
		verticalPanel71.add(horizontalPanel43);
		verticalPanel30.add(verticalPanel71);
		verticalPanel30.add(new HTML("<br>"));
		horizontalPanel12.add(cp_comLabel);
		horizontalPanel12.add(cp_comArea);
		horizontalPanel12.add(cp_infoButton02);
		verticalPanel30.add(horizontalPanel12);
		cp_comArea.setName("particlesComments");
		cp_comLabel.setStyleName("cp_titleText");
		cp_comArea.setStyleName("sa_textArea");
		cp_rain.setStyleName("ct_checkBox");
		cp_drizzle.setStyleName("ct_checkBox");
		cp_dropletsLiquid.setStyleName("ct_checkBox");
		cp_pristineCrystals.setStyleName("ct_checkBox");
		cp_snowAggregates.setStyleName("ct_checkBox");
		cp_graupelHail.setStyleName("ct_checkBox");
		cp_saltAerosol.setStyleName("ct_checkBox");
		cp_continentalAerosol.setStyleName("ct_checkBox");
		cp_urbanPlume.setStyleName("ct_checkBox");
		cp_biomassBurning.setStyleName("ct_checkBox");
		cp_desertDust.setStyleName("ct_checkBox");
		cp_volcanicAsh.setStyleName("ct_checkBox");
		cp_mainLab.setStyleName("fi_mainText");
		cp_mainLab2.setStyleName("fi_mainText2");
		cp_pathLab.setStyleName("fi_pathText");
		cp_pathLab2.setStyleName("fi_pathText2");
		horizontalPanel60.setStyleName("fi_line");
		verticalPanel30.setStyleName("af_verticalPanel");
		verticalPanel83.getElement().setAttribute("style", 
				"margin-top: " + (new_clouds_heading_height - 31) + "px !important;");
		cpScroll.getElement().setAttribute("style", 
				"background-image: url(icons/eufar_heading_clouds.jpg) !important; "
				+ "background-repeat: no-repeat !important;" 
				+ "background-size: " + screen_width + "px " + new_clouds_heading_height + "px !important;"
				+ "background-position: -" + menu_width + "px 0px !important;"
				+ "overflow: auto !important;");
		verticalPanel27.getElement().setAttribute("style", "margin-left: 115px !important;");
		verticalPanel28.getElement().setAttribute("style", "margin-left: 115px !important;");
		verticalPanel29.getElement().setAttribute("style", "margin-left: 115px !important;");
		rootLogger.log(Level.INFO, "Cloud, Precipitation and Aerosol Particles Sampled panel initialized");


		// Assemble Land or Oceans Surfaces Overflown panel
		horizontalPanel61.add(lo_mainLab);
		horizontalPanel61.add(lo_pathLab);
		horizontalPanel61.add(lo_pathLab2);
		horizontalPanel62.add(new HTML("<hr  style=\"width:1200px;height:10px;background:#c0c0c0;border:0px;\" />"));
		verticalPanel84.add(lo_mainLab2);
		verticalPanel84.add(horizontalPanel61);
		verticalPanel84.add(horizontalPanel62);
		verticalPanel84.add(verticalPanel35);
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
		horizontalPanel13.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel13.add(lo_infoButton01);
		verticalPanel35.add(horizontalPanel13);
		verticalPanel35.add(new HTML("<br>"));
		horizontalPanel44.add(GuiModification.addCatButton(lo_addCatTable, lo_addCatMap, verticalPanel72));
		SimplePanel lo_infoButton = Elements.addInfoButton("newCheckBox");
		lo_infoButton.getElement().setAttribute("style", "margin-top: 1px !important;");
		horizontalPanel44.add(lo_infoButton);
		verticalPanel72.add(horizontalPanel44);
		verticalPanel35.add(verticalPanel72);
		verticalPanel35.add(new HTML("<br>"));
		horizontalPanel14.add(lo_comLabel);
		horizontalPanel14.add(lo_comArea);
		horizontalPanel14.add(lo_infoButton02);
		verticalPanel35.add(horizontalPanel14);
		lo_comArea.setName("surfacesComments");
		lo_comLabel.setStyleName("lo_titleText");
		lo_comArea.setStyleName("sa_textArea");
		lo_ocean.setStyleName("lo_checkBox");
		lo_semiArid.setStyleName("lo_checkBox");
		lo_seaIce.setStyleName("lo_checkBox");
		lo_desert.setStyleName("lo_checkBox");
		lo_snow.setStyleName("lo_checkBox");
		lo_urban.setStyleName("lo_checkBox");
		lo_lakeIce.setStyleName("lo_checkBox");
		lo_forest.setStyleName("lo_checkBox");
		lo_vegetation.setStyleName("lo_checkBox");
		lo_mountainous.setStyleName("lo_checkBox");
		lo_hilly.setStyleName("lo_checkBox");
		lo_flat.setStyleName("lo_checkBox");
		lo_mainLab.setStyleName("fi_mainText");
		lo_mainLab2.setStyleName("fi_mainText2");
		lo_pathLab.setStyleName("fi_pathText");
		lo_pathLab2.setStyleName("fi_pathText2");
		horizontalPanel62.setStyleName("fi_line");
		verticalPanel35.setStyleName("af_verticalPanel");
		verticalPanel84.getElement().setAttribute("style", 
				"margin-top: " + (new_clouds_heading_height - 31) + "px !important;");
		loScroll.getElement().setAttribute("style", 
				"background-image: url(icons/eufar_heading_clouds.jpg) !important; "
				+ "background-repeat: no-repeat !important;" 
				+ "background-size: " + screen_width + "px " + new_clouds_heading_height + "px !important;"
				+ "background-position: -" + menu_width + "px 0px !important;"
				+ "overflow: auto !important;");
		verticalPanel32.getElement().setAttribute("style", "margin-left:190px !important;");
		verticalPanel33.getElement().setAttribute("style", "margin-left:190px !important;");
		verticalPanel34.getElement().setAttribute("style", "margin-left:190px !important;");
		rootLogger.log(Level.INFO, "Land or Oceans Surfaces Overflown panel initialized");


		// Assemble Altitude Range of Measurement panel
		horizontalPanel63.add(ar_mainLab);
		horizontalPanel63.add(ar_pathLab);
		horizontalPanel63.add(ar_pathLab2);
		horizontalPanel64.add(new HTML("<hr  style=\"width:1200px;height:10px;background:#c0c0c0;border:0px;\" />"));
		verticalPanel85.add(ar_mainLab2);
		verticalPanel85.add(horizontalPanel63);
		verticalPanel85.add(horizontalPanel64);
		verticalPanel85.add(verticalPanel38);
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
		horizontalPanel15.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel15.add(ar_infoButton01);
		verticalPanel38.add(horizontalPanel15);
		verticalPanel38.add(new HTML("<br>"));
		horizontalPanel45.add(GuiModification.addCatButton(ar_addCatTable, ar_addCatMap, verticalPanel73));
		SimplePanel ar_infoButton = Elements.addInfoButton("newCheckBox");
		ar_infoButton.getElement().setAttribute("style", "margin-top: 1px !important;");
		horizontalPanel45.add(ar_infoButton);
		verticalPanel73.add(horizontalPanel45);
		verticalPanel38.add(verticalPanel73);
		verticalPanel38.add(new HTML("<br>"));
		horizontalPanel16.add(ar_comLabel);
		horizontalPanel16.add(ar_comArea);
		horizontalPanel16.add(ar_infoButton02);
		verticalPanel38.add(horizontalPanel16);
		ar_comArea.setName("measurementComments");
		ar_inCloud.setStyleName("sa_checkBox");
		ar_subCloud.setStyleName("sa_checkBox");
		ar_nearSurface.setStyleName("sa_checkBox2");
		ar_comLabel.setStyleName("ar_titleText");
		ar_comArea.setStyleName("sa_textArea");
		ar_boundaryLayer.setStyleName("ar_checkBox");
		ar_upperTroposphere.setStyleName("ar_checkBox");
		ar_midTroposphere.setStyleName("ar_checkBox");
		ar_lowerTroposphere.setStyleName("ar_checkBox");
		ar_lowerstratosphere.setStyleName("ar_checkBox");
		ar_mainLab.setStyleName("fi_mainText");
		ar_mainLab2.setStyleName("fi_mainText2");
		ar_pathLab.setStyleName("fi_pathText");
		ar_pathLab2.setStyleName("fi_pathText2");
		horizontalPanel64.setStyleName("fi_line");
		verticalPanel38.setStyleName("af_verticalPanel");
		verticalPanel85.getElement().setAttribute("style", 
				"margin-top: " + (new_clouds_heading_height - 31) + "px !important;");
		arScroll.getElement().setAttribute("style", 
				"background-image: url(icons/eufar_heading_clouds.jpg) !important; "
				+ "background-repeat: no-repeat !important;" 
				+ "background-size: " + screen_width + "px " + new_clouds_heading_height + "px !important;"
				+ "background-position: -" + menu_width + "px 0px !important;"
				+ "overflow: auto !important;");
		verticalPanel37.getElement().setAttribute("style", "margin-left:200px !important;");
		verticalPanel79.getElement().setAttribute("style", "margin-left:200px !important;");
		rootLogger.log(Level.INFO, "Altitude Range of Measurement panel initialized");


		// Assemble Types of Flight Manoeuvre panel
		horizontalPanel65.add(fm_mainLab);
		horizontalPanel65.add(fm_pathLab);
		horizontalPanel65.add(fm_pathLab2);
		horizontalPanel66.add(new HTML("<hr  style=\"width:1200px;height:10px;background:#c0c0c0;border:0px;\" />"));
		verticalPanel86.add(fm_mainLab2);
		verticalPanel86.add(horizontalPanel65);
		verticalPanel86.add(horizontalPanel66);
		verticalPanel86.add(verticalPanel41);
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
		horizontalPanel17.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel17.add(fm_infoButton01);
		verticalPanel41.add(horizontalPanel17);
		horizontalPanel46.add(GuiModification.addCatButton(fm_addCatTable, fm_addCatMap, verticalPanel74));
		SimplePanel fm_infoButton = Elements.addInfoButton("newCheckBox");
		fm_infoButton.getElement().setAttribute("style", "margin-top: 1px !important;");
		horizontalPanel46.add(fm_infoButton);
		verticalPanel74.add(horizontalPanel46);
		verticalPanel41.add(verticalPanel74);
		verticalPanel41.add(new HTML("<br>"));
		horizontalPanel18.add(fm_comLabel);
		horizontalPanel18.add(fm_comArea);
		horizontalPanel18.add(fm_infoButton02);
		verticalPanel41.add(horizontalPanel18);
		fm_comArea.setName("manoeuvreComments");
		fm_separated.setStyleName("sa_checkBox");
		fm_stacked.setStyleName("sa_checkBox");
		fm_comLabel.setStyleName("fm_titleText");
		fm_comArea.setStyleName("sa_textArea");
		fm_levelRuns.setStyleName("fm_checkBox");
		fm_racetracks.setStyleName("fm_checkBox");
		fm_orbits.setStyleName("fm_checkBox");
		fm_lagrangianDescents.setStyleName("fm_checkBox");
		fm_ascDescents.setStyleName("fm_checkBox");
		fm_dropsondeDeployed.setStyleName("fm_checkBox");
		fm_selfCalibration.setStyleName("fm_checkBox");
		fm_mainLab.setStyleName("fi_mainText");
		fm_mainLab2.setStyleName("fi_mainText2");
		fm_pathLab.setStyleName("fi_pathText");
		fm_pathLab2.setStyleName("fi_pathText2");
		horizontalPanel66.setStyleName("fi_line");
		verticalPanel41.setStyleName("af_verticalPanel");
		verticalPanel86.getElement().setAttribute("style", 
				"margin-top: " + (new_clouds_heading_height - 31) + "px !important;");
		fmScroll.getElement().setAttribute("style", 
				"background-image: url(icons/eufar_heading_clouds.jpg) !important; "
				+ "background-repeat: no-repeat !important;" 
				+ "background-size: " + screen_width + "px " + new_clouds_heading_height + "px !important;"
				+ "background-position: -" + menu_width + "px 0px !important;"
				+ "overflow: auto !important;");
		verticalPanel40.getElement().setAttribute("style", "margin-left:105px !important;");
		verticalPanel77.getElement().setAttribute("style", "margin-left:105px !important;");
		verticalPanel78.getElement().setAttribute("style", "margin-left:105px !important;");
		rootLogger.log(Level.INFO, "Types of Flight Manoeuvre panel initialized");


		// Assemble Satellite Coordination panel
		horizontalPanel67.add(sc_mainLab);
		horizontalPanel67.add(sc_pathLab);
		horizontalPanel67.add(sc_pathLab2);
		horizontalPanel68.add(new HTML("<hr  style=\"width:1200px;height:10px;background:#c0c0c0;border:0px;\" />"));
		verticalPanel87.add(sc_mainLab2);
		verticalPanel87.add(horizontalPanel67);
		verticalPanel87.add(horizontalPanel68);
		verticalPanel87.add(verticalPanel47);
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
		horizontalPanel19.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel19.add(sc_infoButton01);
		verticalPanel47.add(horizontalPanel19);
		verticalPanel47.add(new HTML("<br>"));
		horizontalPanel47.add(GuiModification.addCatButton(sc_addCatTable, sc_addCatMap, verticalPanel75));
		SimplePanel sc_infoButton = Elements.addInfoButton("newCheckBox");
		sc_infoButton.getElement().setAttribute("style", "margin-top: 1px !important;");
		horizontalPanel47.add(sc_infoButton);
		verticalPanel75.add(horizontalPanel47);
		verticalPanel47.add(verticalPanel75);
		verticalPanel47.add(new HTML("<br>"));
		horizontalPanel20.add(sc_comLabel);
		horizontalPanel20.add(sc_comArea);
		horizontalPanel20.add(sc_infoButton02);
		verticalPanel47.add(horizontalPanel20);
		sc_comArea.setName("satelliteComments");
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
		sc_comLabel.setStyleName("sc_titleText");
		sc_comArea.setStyleName("sa_textArea");
		sc_airs.setStyleName("sc_checkBox");
		sc_amsuMhs.setStyleName("sc_checkBox");
		sc_caliop.setStyleName("sc_checkBox");
		sc_cloudsat.setStyleName("sc_checkBox");
		sc_cris.setStyleName("sc_checkBox");
		sc_iasi.setStyleName("sc_checkBox");
		sc_modis.setStyleName("sc_checkBox");
		sc_mainLab.setStyleName("fi_mainText");
		sc_mainLab2.setStyleName("fi_mainText2");
		sc_pathLab.setStyleName("fi_pathText");
		sc_pathLab2.setStyleName("fi_pathText2");
		horizontalPanel68.setStyleName("fi_line");
		verticalPanel47.setStyleName("af_verticalPanel");
		verticalPanel87.getElement().setAttribute("style", 
				"margin-top: " + (new_clouds_heading_height - 31) + "px !important;");
		scScroll.getElement().setAttribute("style", 
				"background-image: url(icons/eufar_heading_clouds.jpg) !important; "
				+ "background-repeat: no-repeat !important;" 
				+ "background-size: " + screen_width + "px " + new_clouds_heading_height + "px !important;"
				+ "background-position: -" + menu_width + "px 0px !important;"
				+ "overflow: auto !important;");
		verticalPanel42.getElement().setAttribute("style", "width: 200px !important;");
		verticalPanel43.getElement().setAttribute("style", "width: 220px !important; margin-left: 120px !important;");
		verticalPanel44.getElement().setAttribute("style", "margin-left:120px !important; margin-top: 20px !important;");
		verticalPanel45.getElement().setAttribute("style", "margin-left:120px !important; margin-top: 20px !important;");
		rootLogger.log(Level.INFO, "Satellite Coordination panel initialized");


		// Assemble Supporting Surface-based Observations panel
		horizontalPanel69.add(so_mainLab);
		horizontalPanel69.add(so_pathLab);
		horizontalPanel69.add(so_pathLab2);
		horizontalPanel70.add(new HTML("<hr  style=\"width:1200px;height:10px;background:#c0c0c0;border:0px;\" />"));
		verticalPanel88.add(so_mainLab2);
		verticalPanel88.add(horizontalPanel69);
		verticalPanel88.add(horizontalPanel70);
		verticalPanel88.add(verticalPanel61);
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
		horizontalPanel25.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel25.add(so_infoButton01);
		so_infoButton01.getElement().setAttribute("style", "margin-left: 70px !important;");
		verticalPanel61.add(horizontalPanel25);
		verticalPanel51.getElement().setAttribute("style", "margin-top:30px !important;");
		verticalPanel50.getElement().setAttribute("style", "margin-left:150px !important;");
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
		so_armSitesLabel.setStyleName("so_textLabel");
		so_mobileSitesLabel.setStyleName("so_textLabel");
		so_groundSitesLabel.setStyleName("so_textLabel");
		so_researchVesselsLabel.setStyleName("so_textLabel");
		so_mainLab.setStyleName("fi_mainText");
		so_mainLab2.setStyleName("fi_mainText2");
		so_pathLab.setStyleName("fi_pathText");
		so_pathLab2.setStyleName("fi_pathText2");
		horizontalPanel70.setStyleName("fi_line");
		verticalPanel61.setStyleName("af_verticalPanel");
		verticalPanel88.getElement().setAttribute("style", 
				"margin-top: " + (new_clouds_heading_height - 31) + "px !important;");
		soScroll.getElement().setAttribute("style", 
				"background-image: url(icons/eufar_heading_clouds.jpg) !important; "
				+ "background-repeat: no-repeat !important;" 
				+ "background-size: " + screen_width + "px " + new_clouds_heading_height + "px !important;"
				+ "background-position: -" + menu_width + "px 0px !important;"
				+ "overflow: auto !important;");
		verticalPanel48.getElement().setAttribute("style", "margin-top:10px !important;");
		verticalPanel53.getElement().setAttribute("style", "margin-top:10px !important;");
		verticalPanel55.getElement().setAttribute("style", "margin-left:160px !important;");
		verticalPanel56.getElement().setAttribute("style", "margin-top:30px !important;");
		horizontalPanel21.getElement().setAttribute("style", "margin-left:63px !important;");
		horizontalPanel22.getElement().setAttribute("style", "margin-left:40px !important;");
		horizontalPanel23.getElement().setAttribute("style", "margin-left:80px !important;");
		horizontalPanel24.getElement().setAttribute("style", "margin-left:36px !important;");
		rootLogger.log(Level.INFO, "Supporting Surface-based Observations panel initialized");
		

		// Assemble Additional Notes on the Flight panel
		horizontalPanel71.add(nf_mainLab);
		horizontalPanel71.add(nf_pathLab);
		horizontalPanel71.add(nf_pathLab2);
		horizontalPanel72.add(new HTML("<hr  style=\"width:1200px;height:10px;background:#c0c0c0;border:0px;\" />"));
		verticalPanel89.add(nf_mainLab2);
		verticalPanel89.add(horizontalPanel71);
		verticalPanel89.add(horizontalPanel72);
		verticalPanel89.add(verticalPanel66);
		verticalPanel66.add(nf_comArea);
		nf_comArea.setName("additionalNotes");
		nf_comArea.setStyleName("sa_textArea");
		nf_mainLab.setStyleName("fi_mainText");
		nf_mainLab2.setStyleName("fi_mainText2");
		nf_pathLab.setStyleName("fi_pathText");
		nf_pathLab2.setStyleName("fi_pathText2");
		horizontalPanel72.setStyleName("fi_line");
		verticalPanel66.setStyleName("af_verticalPanel");
		verticalPanel89.getElement().setAttribute("style", 
				"margin-top: " + (new_clouds_heading_height - 31) + "px !important;");
		nfScroll.getElement().setAttribute("style", 
				"background-image: url(icons/eufar_heading_clouds.jpg) !important; "
				+ "background-repeat: no-repeat !important;" 
				+ "background-size: " + screen_width + "px " + new_clouds_heading_height + "px !important;"
				+ "background-position: -" + menu_width + "px 0px !important;"
				+ "overflow: auto !important;");
		nf_comArea.getElement().setAttribute("style", "margin-top: 20px; width: 1016px;");
		rootLogger.log(Level.INFO, "Additional Notes on the Flight panel initialized...");
		
		
		// Assemble Image Uploading
		horizontalPanel73.add(im_mainLab);
		horizontalPanel73.add(im_pathLab);
		horizontalPanel73.add(im_pathLab2);
		horizontalPanel74.add(new HTML("<hr  style=\"width:1200px;height:10px;background:#c0c0c0;border:0px;\" />"));
		verticalPanel90.add(im_mainLab2);
		verticalPanel90.add(horizontalPanel73);
		verticalPanel90.add(horizontalPanel74);
		verticalPanel90.add(verticalPanel76);
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
		addButton.setStyleName("im_imageButton");
		urlButton.setStyleName("im_urlButton");
		informationLab.setStyleName("im_textLabel");
		imageLab.setStyleName("im_imageTextLabel");
		captionLab.setStyleName("im_captionTextLabel");
		imageLab.setVisible(false);
		captionLab.setVisible(false);
		imageTab.getElement().setAttribute("style", "margin-top: 10px !important; margin-left: 20px! important");
		im_mainLab.setStyleName("fi_mainText");
		im_mainLab2.setStyleName("fi_mainText2");
		im_pathLab.setStyleName("fi_pathText");
		im_pathLab2.setStyleName("fi_pathText2");
		horizontalPanel74.setStyleName("fi_line");
		verticalPanel76.setStyleName("af_verticalPanel");
		verticalPanel90.getElement().setAttribute("style", 
				"margin-top: " + (new_clouds_heading_height - 31) + "px !important;");
		ipScroll.getElement().setAttribute("style", 
				"background-image: url(icons/eufar_heading_clouds.jpg) !important; "
				+ "background-repeat: no-repeat !important;" 
				+ "background-size: " + screen_width + "px " + new_clouds_heading_height + "px !important;"
				+ "background-position: -" + menu_width + "px 0px !important;"
				+ "overflow: auto !important;");
		rootLogger.log(Level.INFO, "Image Uploading panel initialized");
		
		
		// Screen size detection
		tabPanel.add(Asmm_eufar.fiScroll,"Flight and Contact Information");
		tabPanel.add(Asmm_eufar.saScroll,"Scientific Aims");
		tabPanel.add(Asmm_eufar.giScroll,"Geographic Information");
		tabPanel.add(Asmm_eufar.afScroll,"Atmospheric Synoptic Features");
		tabPanel.add(Asmm_eufar.ctScroll,"Cloud Types and Forms Sampled During Flight");
		tabPanel.add(Asmm_eufar.cpScroll,"Cloud, Precipitation and Aerosol Particles Sampled");
		tabPanel.add(Asmm_eufar.loScroll,"Land or Oceans Surfaces Overflown");
	    tabPanel.add(Asmm_eufar.arScroll,"Altitude Range of Measurement");
		tabPanel.add(Asmm_eufar.fmScroll,"Types of Flight Manoeuvre");
		tabPanel.add(Asmm_eufar.scScroll,"Satellite Coordination");
		tabPanel.add(Asmm_eufar.soScroll,"Supporting Surface-based Observations");
		tabPanel.add(Asmm_eufar.nfScroll,"Additional Notes on the Flight");
		tabPanel.add(Asmm_eufar.ipScroll,"Images included in the PDF report");
		verticalPanel101.add(mainMenu);
		verticalPanel101.add(horizontalPanel90);
		horizontalPanel90.getElement().setAttribute("style", "height: " + (new_clouds_heading_height) + "px;" +
				  "background-image: url(icons/eufar_heading_clouds.jpg); background-repeat: no-repeat;" + 
				  "background-size: " + screen_width + "px " + new_clouds_heading_height + "px; background-position: "+ 
				  "left top; width: " + menu_width + "px;");
		subDockPanel.addNorth(horizontalPanel87, 80);
		subDockPanel.addSouth(horizontalPanel112, 40);
		subDockPanel.addWest(verticalPanel101, menu_width);
		subDockPanel.add(tabPanel);
		subDockPanel.getElement().setAttribute("style", "background: rgb(238,238,238) !important;");
		RootLayoutPanel rp=RootLayoutPanel.get();
		rp.clear();
		rp.add(Asmm_eufar.subDockPanel);
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
	
	
	// new panel with click and mouse over events
	class HorizontalPanelOver extends HorizontalPanel {
		public HorizontalPanelOver() {
			super();
		}
		public HandlerRegistration addMouseOverHandler(MouseOverHandler handlerOver) {
			return addDomHandler(handlerOver, MouseOverEvent.getType());
		}
		public HandlerRegistration addMouseOutHandler(MouseOutHandler handlerOut) {
			return addDomHandler(handlerOut, MouseOutEvent.getType());
		}
		public HandlerRegistration addClickHandler(ClickHandler handler) {
			return addDomHandler(handler, ClickEvent.getType());
		}
	}
	
	
	// functions to navigate between tabs
	private void navigateTab(final int direction) {
		int selected_tab = tabPanel.getSelectedIndex();
		int new_tab = selected_tab + direction;
		if (new_tab < 0) {
			new_tab = 12;
		} else if (new_tab > 12) {
			new_tab = 0;
		}
		tabPanel.selectTab(new_tab);
	}
	
	
	// check if all fields have been filled in before saving it
	private void runCheck(final String string) {
		rootLogger.log(Level.INFO, "Check of all fields in progress...");
		int notCompleted = 0;
		int widgetIndex = -1;
		Widget parent;
		Utilities.runCheckDefault();
		if (fi_dateText.getValue().after(new Date())) {
			notCompleted++;
			parent = fi_dateText.getParent();
			while (!(parent instanceof ScrollPanel)) {
				parent = parent.getParent();
			}
			widgetIndex = tabPanel.getWidgetIndex(parent);
			tabPanel.getTabWidget(widgetIndex).getElement().setAttribute("style","color: #241CED !important;");
			fi_dateText.getElement().setAttribute("style","border-color: #241CED !important;");
		}
		for (int i = 0; i < requiredField.size(); i++) {
			if (requiredField.get(i).isVisible()) {
				if (requiredField.get(i).getText() == "") {
					parent = requiredField.get(i).getParent();
					while (!(parent instanceof ScrollPanel)) {
						parent = parent.getParent();
					}
					widgetIndex = tabPanel.getWidgetIndex(parent);
					tabPanel.getTabWidget(widgetIndex).getElement().setAttribute("style","color: #ED1C24 !important;");
					notCompleted++;
					requiredField.get(i).getElement().setAttribute("style","border-color: #ED1C24 !important;");
				} else {
					if (!runCorrect(requiredField.get(i), correctField.get(i))) {
						parent = requiredField.get(i).getParent();
						while (!(parent instanceof ScrollPanel)) {
							parent = parent.getParent();
						}
						widgetIndex = tabPanel.getWidgetIndex(parent);
						if (tabPanel.getTabWidget(widgetIndex).getElement().getStyle().getColor() != "rgb(237, 28, 36)") {
							tabPanel.getTabWidget(widgetIndex).getElement().setAttribute("style","color: rgb(0,0,200) !important;");
						}
						notCompleted++;
					}
				}
			}
		}
		for (int i = 0; i < nonrequiredField.size(); i++) {
			if (nonrequiredField.get(i).getText() != "") {
				if (!runCorrect(nonrequiredField.get(i), correctField2.get(i))) {
					parent = nonrequiredField.get(i).getParent();
					while (!(parent instanceof ScrollPanel)) {
						parent = parent.getParent();
					}
					widgetIndex = tabPanel.getWidgetIndex(parent);
					if (tabPanel.getTabWidget(widgetIndex).getElement().getStyle().getColor() != "rgb(237, 28, 36)") {
						tabPanel.getTabWidget(widgetIndex).getElement().setAttribute("style","color: rgb(0,0,200) !important;");
					}
					notCompleted++;
				}
			}
		}
		for (int i = 0; i < requiredListbox.size(); i++) {
			if (requiredListbox.get(i).getSelectedItemText() == "Make a choice...") {
				tabPanel.getTabWidget(0).getElement().setAttribute("style","color: #ED1C24 !important;");
				requiredListbox.get(i).getElement().setAttribute("style","border-color: #ED1C24 !important;");
				notCompleted++;
			}
		}
		rootLogger.log(Level.INFO, "Check of all fields finished.");
		if (notCompleted > 0) {
			PopupMessages.notcompletePanel(string);
		} else {
			PopupMessages.saveFile(string);
		}
	}
	
	
	// check if all TextBoxes have been correctly filled in before saving it - 2
	private static boolean runCorrect(final TextBoxBase textBox, final String string) {
		Asmm_eufar.rootLogger.log(Level.INFO, "Check of text in textbox in progress...");
		boolean result = true;
			switch (string) {
				case "number":
					if (!textBox.getText().matches("^[-+]?\\d+(\\.\\d+)?$")) {
						textBox.getElement().setAttribute("style","border-color: rgb(0,0,200) !important;");
						result = false;
					}
					break;
				case "string":
					if (textBox.getText().matches("^[-+]?\\d+(\\.\\d+)?$")) {
						textBox.getElement().setAttribute("style","border-color: rgb(0,0,200) !important;");
						result = false;
					}
					break;
				case "email":
					if (!textBox.getText().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
						textBox.getElement().setAttribute("style","border-color: rgb(0,0,200) !important;");
						result = false;
					}
					break;
			}
		rootLogger.log(Level.INFO, "Check of text in textbox finished.");
		return result;
	}
	
	
	// create a new file by cleaning all widgets
	private void newFile() {
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
			final Image image = new Image(Asmm_eufar.resources.warningPopup().getSafeUri());
			image.setSize("68px", "68px");
			saveButton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					infoDialog.hide();
					runCheck("clear");;
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
			horizontalPanel01.add(image);
			verticalPanel02.add(label);
			verticalPanel02.add(label2);
			horizontalPanel01.add(verticalPanel02);
			verticalPanel01.add(horizontalPanel01);
			horizontalPanel02.add(saveButton);
			horizontalPanel02.add(cancelButton);
			horizontalPanel02.add(createButton);
			verticalPanel01.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			verticalPanel01.add(horizontalPanel02);
			infoDialog.add(verticalPanel01);
			infoDialog.setStyleName("newFilePanel");
			label.setStyleName("newFileText");
			label2.setStyleName("newFileText2");
			saveButton.addStyleName("newFileButton");
			cancelButton.addStyleName("newFileButton2");
			createButton.addStyleName("newFileButton3");
			infoDialog.setSize("350px","50px");
			infoDialog.setModal(true);
			infoDialog.center();
			infoDialog.show();
		} else {
			Utilities.clearFields();
		}
	}
	
	
	// open an existing xml file - 1
	private void openFile() {
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
			final Button openButton = new Button("Open without saving");
			final Image image = new Image(Asmm_eufar.resources.warningPopup().getSafeUri());
			image.setSize("68px", "68px");
			saveButton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					infoDialog.hide();
					runCheck("open");
				}
			});
			cancelButton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					infoDialog.hide();
				}
			});
			openButton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					infoDialog.hide();
					PopupMessages.openAction();
				}
			});
			infoDialog.setGlassEnabled(true);
			horizontalPanel01.add(image);
			verticalPanel02.add(label);
			verticalPanel02.add(label2);
			horizontalPanel01.add(verticalPanel02);
			verticalPanel01.add(horizontalPanel01);
			horizontalPanel02.add(saveButton);
			horizontalPanel02.add(cancelButton);
			horizontalPanel02.add(openButton);
			verticalPanel01.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			verticalPanel01.add(horizontalPanel02);
			infoDialog.add(verticalPanel01);
			infoDialog.setStyleName("newFilePanel");
			label.setStyleName("newFileText");
			label2.setStyleName("newFileText2");
			saveButton.addStyleName("newFileButton");
			cancelButton.addStyleName("newFileButton2");
			openButton.addStyleName("newFileButton3");
			infoDialog.setSize("350px","50px");
			infoDialog.setModal(true);
			infoDialog.center();
			infoDialog.show();
		} else {
			PopupMessages.openAction();
		}
	}
}
