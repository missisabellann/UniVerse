package src.classes.com.data_access;

import com.data_access.*;
import com.entity.building.BuildingBuilder;
import com.entity.event.Event;
import com.entity.event.EventBuilder;
import com.entity.review.ReviewBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.classes.com.entity.GetEntitiesTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuildingDataAccessTest {
    private GetEntitiesTest entities;
    @BeforeEach
    void setUp() {
//        EventDataAccessObject dao = new EventDataAccessObject();
        entities = new GetEntitiesTest();
        entities.init();
    }

    @Test
    void getByBuildingCode() {
        FileUserDataAccessObject userDao = new FileUserDataAccessObject();
        BuildingReviewDataAccessObject RDAO = new BuildingReviewDataAccessObject(Path.path + "external-data/buildingreviews.json", new ReviewBuilder(), userDao);
        BuildingDataAccessObject BDAO = new BuildingDataAccessObject(Path.path + "external-data/buildings.json", Path.path + "external-data/events.json",new BuildingBuilder(), new EventBuilder(), RDAO);
        Assertions.assertEquals("Hart House", BDAO.getBuilding("HH").getName());
    }
}