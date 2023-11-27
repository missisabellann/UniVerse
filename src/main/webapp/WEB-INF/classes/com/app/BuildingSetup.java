package com.app;

import com.data_access.BuildingDataAccessObject;
import com.entity.building.BuildingFactory;
import com.entity.event.EventFactory;
import com.interface_adapter.open_building.OpenBuildingController;
import com.interface_adapter.open_building.OpenBuildingPresenter;
import com.use_case.open_building.OpenBuildingDataAccessInterface;
import com.use_case.open_building.OpenBuildingInputBoundary;
import com.use_case.open_building.OpenBuildingInteractor;
import com.use_case.open_building.OpenBuildingOutputBoundary;
import com.view.Building.BuildingInfoServlet;

public class BuildingSetup {
    public static OpenBuildingController setup(BuildingInfoServlet buildingInfoServlet) {
        OpenBuildingOutputBoundary presenter = new OpenBuildingPresenter(buildingInfoServlet);

        BuildingFactory buildingFactory = new BuildingFactory();
        EventFactory eventFactory = new EventFactory();
        String buildingPath = "C:\\Users\\evan_\\Documents\\UofT\\year2\\csc207\\IdeaProjects\\UniVerse\\external-data\\buildings.json";
        String eventPath = "C:\\Users\\evan_\\Documents\\UofT\\year2\\csc207\\IdeaProjects\\UniVerse\\src\\main\\webapp\\js\\events.js";
        OpenBuildingDataAccessInterface dataAccess = new BuildingDataAccessObject(buildingPath,eventPath, buildingFactory, eventFactory);

        OpenBuildingInputBoundary interactor = new OpenBuildingInteractor(dataAccess, presenter);
        return new OpenBuildingController(interactor);
    }
}
