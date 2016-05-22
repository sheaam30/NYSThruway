package shealabs.nysthruway.datamodel;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.Root;

import java.util.Date;
import java.util.List;

@Root(name = "events")
public class TrafficEvents {

    @Element(name = "lastupdatetime")
    private Date lastUpdateTime;

    @ElementArray(name = "event")
    private List<Event> eventList;

    @Root(name = "event")
    static class Event {

        @Element(name = "expirationdatetime")
        private Date expirationDateTime;

        @Element(name = "eventdesc")
        private String eventDesc;

        @Element(name = "direction")
        private String direction;

        @Element(name = "region")
        private String region;

        @Element(name = "route")
        private String route;

        @Element(name = "milepost")
        private double milePost;

        @Element(name = "longitude")
        private float longitude;

        @Element(name = "latitude")
        private float latitude;

        @Element(name = "eventtype")
        private String eventType;

        @Element(name = "orgid")
        private String orgId;

        @Element(name = "updatetime")
        private String updateTime;

        @Element(name = "eventid")
        private String eventId;

        @Element(name = "category")
        private String category;
    }

}
