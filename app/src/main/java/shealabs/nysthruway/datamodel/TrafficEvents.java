package shealabs.nysthruway.datamodel;


import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "events")
public class TrafficEvents {

    @Element(name = "lastupdatetime")
    private String lastUpdateTime;

    @ElementList(entry = "event", inline = true)
    private List<Event> eventList;

    @Root(name = "event")
    static class Event {

        @Attribute(name = "category")
        private String category;

        @Attribute(name = "eventid")
        private String eventId;

        @Attribute(name = "updatetime")
        private String updateTime;

        @Attribute(name = "orgid")
        private String orgId;

        @Attribute(name = "eventtype")
        private String eventType;

        @Attribute(name = "latitude")
        private float latitude;

        @Attribute(name = "longitude")
        private float longitude;

        @Attribute(name = "milepost")
        private double milePost;

        @Attribute(name = "route")
        private String route;

        @Attribute(name = "region")
        private String region;

        @Attribute(name = "direction")
        private String direction;

        @Attribute(name = "eventdesc")
        private String eventDesc;

        @Attribute(name = "expirationdatetime")
        private String expirationDateTime;
    }
}
