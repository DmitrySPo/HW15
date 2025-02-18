package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private Current current;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public static class Current {
        private float temp_c;
        private Condition condition;

        public float getTemp_c() {
            return temp_c;
        }

        public void setTemp_c(float temp_c) {
            this.temp_c = temp_c;
        }

        public Condition getCondition() {
            return condition;
        }

        public void setCondition(Condition condition) {
            this.condition = condition;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Condition {
            private String text;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }
}