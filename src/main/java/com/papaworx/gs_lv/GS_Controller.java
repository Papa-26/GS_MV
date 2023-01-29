package com.papaworx.gs_lv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.InvalidPreferencesFormatException;
import java.util.prefs.Preferences;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
//import utilities.About;

/**
 * LayoutController for JavaFX GUI
 * manage the communication between <code>Main</code> and the GUI.
 *
 * @see <a href="https://github.com/G-String-Legacy/G_String/blob/main/workbench/GS_L/src/view/rootLayout.fxml">view.rootLayoutController</a>
 * @author ralph
 * @version %v..%
 *
 */
public class GS_Controller {
    /**
     * main application of project
     */
    private com.papaworx.gs_lv.GS_Application myMain;

    /**
     * application logger
     */
    private Logger logger;

    /**
     * application preferences
     */
    private Preferences prefs;
    /**
     * primary container of FXML object (GS_view)
     */
    public BorderPane bpScreen;

    /**
     * location current data directory
     */
    private String homeDir = null;

    @FXML
    private MenuItem mnuExit;
    @FXML
    private MenuItem mnuActionFresh;
    @FXML
    private MenuItem mnuActionStartOver;
    @FXML
    private MenuItem mnuSimulate;
    @FXML
    private MenuItem mnuResimulate;
    @FXML
    private MenuItem mnuSetup;
    @FXML
    private MenuItem mnuPreferences;
    @FXML
    private MenuItem mnuCHelp;
    @FXML
    private MenuItem mnuIntro;
    @FXML
    private MenuItem mnuAbout;
    @FXML
    private MenuItem mnuUHelp;
    @FXML
    private MenuItem mnuAboutB;
    @FXML
    private MenuItem mnuStart;
    @FXML
    private MenuItem mnuSaveAll;
    @FXML
    private MenuItem mnuChangePrefs;
    @FXML
    private MenuItem mnuLoadPrefs;
    @FXML
    private MenuItem mnuSavePrefs;
    @FXML
    private MenuItem mnuReplicate;
    @FXML
    private MenuItem mnuReReplicate;
    @FXML
    private Button btnStepUp;
    @FXML
    private Label lblStep;
    @FXML
    private Menu mnuAction;

    @FXML
    void typedBS(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            lblStep.setText(event.getText() + " typed.");
        }
    }

    /**
     * initialize rootLayoutController at program start.
     */
    public void initialize() {
        mnuExit.setOnAction((event) -> {
            respond();
        });/*
        btnStepUp.setOnAction((event) -> myMain.stepUp());
        mnuActionStartOver.setOnAction((event) -> {
            myMain.startOver();
        });
        mnuCHelp.setOnAction((event) -> {
            myMain.helpSwitch("help");
        });
        mnuIntro.setOnAction((event) -> {
            myMain.helpSwitch("intro");
        });
        mnuUHelp.setOnAction((event) -> {
            displayResource("/resources/urGENOVA_manual.pdf");
        });
        mnuSimulate.setOnAction((event) -> {
            myMain.Simulate();
        });
        mnuResimulate.setOnAction((event) -> {
            myMain.Resimulate();
        });
        mnuSetup.setOnAction((event) -> {
            myMain.doSetup();
        });
        mnuChangePrefs.setOnAction((event) -> {
            myMain.switchChangePreferences(true);
        });
        mnuLoadPrefs.setOnAction((event) -> {
            loadPreferences();
        });
        mnuSavePrefs.setOnAction((event) -> {
            savePreferences();
        });
        mnuAbout.setOnAction((event) -> {
            about();
        });
        mnuAboutB.setOnAction((event) -> {
            aboutB();
        });
        mnuStart.setOnAction((event) -> {
            myMain.freshStart();
        });
        mnuSaveAll.setOnAction((event) -> {
            myMain.saveAll();
        });
        mnuReplicate.setOnAction((event) -> {
            myMain.replicate();
        });
        mnuReReplicate.setOnAction((event) -> {
            myMain.replicateAgain();
        });
        lblStep.setAlignment(Pos.CENTER);
        lblStep.setText("Step 0");
        mnuActionFresh.setOnAction((event) -> {
            myMain.startFresh();
        });*/
    }

    /**
     * method to set class variables from GS_Application
     * @param _main pointer to GS_Application
     * @param _logger pointer to system logger
     * @param _prefs pointer to system preferences
     */
    void setMainApp(com.papaworx.gs_lv.GS_Application _main, Logger _logger, Preferences _prefs){
        myMain = _main;
        logger = _logger;
        prefs = _prefs;
    }

    /**
     * switch between select action and stepping
     *
     * @param b  boolean switch  on/off
     */
    public void buttonsEnabled(boolean b) {
        btnStepUp.setDisable(!b);
        mnuActionFresh.setDisable(b);
        mnuActionStartOver.setDisable(b);
    }

    /**
     * exit program
     */
    private void respond() {
        System.exit(0);
    }

}