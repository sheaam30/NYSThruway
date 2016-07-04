package shealabs.nysthruway.datamodel.response;


import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "events")
public class TrafficEventsResponse {

    @Element(name = "lastupdatetime")
    public String lastUpdateTime;

    @ElementList(entry = "event", inline = true)
    public List<Event> eventList;

    @Root(name = "event")
    public static class Event {

        @Attribute(name = "category")
        public String category;

        @Attribute(name = "eventid")
        public String eventId;

        @Attribute(name = "updatetime")
        public String updateTime;

        @Attribute(name = "orgid")
        public String orgId;

        @Attribute(name = "eventtype")
        public String eventType;

        @Attribute(name = "latitude")
        public float latitude;

        @Attribute(name = "longitude")
        public float longitude;

        @Attribute(name = "milepost")
        public double milePost;

        @Attribute(name = "route")
        public String route;

        @Attribute(name = "region")
        public String region;

        @Attribute(name = "direction")
        public String direction;

        @Attribute(name = "eventdesc")
        public String eventDesc;

        @Attribute(name = "expirationdatetime")
        public String expirationDateTime;
    }
}
