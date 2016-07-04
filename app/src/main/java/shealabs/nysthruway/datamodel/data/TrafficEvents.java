package shealabs.nysthruway.datamodel.data;

import com.google.android.gms.maps.model.LatLng;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

public class TrafficEvents {

    private String lastUpdateTime;

    private List<Event> eventList = new ArrayList<>();

    public List<Event> getEventList() {
        return eventList;
    }

    public static class Event {
        private String category;
        private String eventId;
        private String updateTime;
        private String orgId;
        private String eventType;
        private float latitude;
        private float longitude;
        private double milePost;
        private String route;
        private String region;
        private String direction;
        private String eventDesc;
        private String expirationDateTime;

        public void setEventType(String eventType) {
            this.eventType = eventType;
        }

        public String getCategory() {
            return category;
        }

        public String getEventId() {
            return eventId;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public String getOrgId() {
            return orgId;
        }

        public String getEventType() {
            return eventType;
        }

        public float getLatitude() {
            return latitude;
        }

        public float getLongitude() {
            return longitude;
        }

        public double getMilePost() {
            return milePost;
        }

        public String getRoute() {
            return route;
        }

        public String getRegion() {
            return region;
        }

        public String getDirection() {
            return direction;
        }

        public String getEventDesc() {
            return eventDesc;
        }

        public String getExpirationDateTime() {
            return expirationDateTime;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public void setEventId(String eventId) {
            this.eventId = eventId;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setOrgId(String orgId) {
            this.orgId = orgId;
        }

        public void setLatitude(float latitude) {
            this.latitude = latitude;
        }

        public void setLongitude(float longitude) {
            this.longitude = longitude;
        }

        public void setMilePost(double milePost) {
            this.milePost = milePost;
        }

        public void setRoute(String route) {
            this.route = route;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public void setEventDesc(String eventDesc) {
            this.eventDesc = eventDesc;
        }

        public void setExpirationDateTime(String expirationDateTime) {
            this.expirationDateTime = expirationDateTime;
        }

        public LatLng getLatLng() {
            return new LatLng(latitude, longitude);
        }
    }
}
