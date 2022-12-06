package com.citynow.residentinformationmanagement.entity;

import java.util.List;
import lombok.Data;

@Data
public class ResidentCard {

  private boolean active;
  private Project project;

  @Data
  public static class Project {

    private String id;
    private Range range;

    @Data
    public static class Range {

      private Building building;
      private Floor floor;
      private Apartment apartment;

      @Data
      public static class Building {

        private String id;
        private List<Control> controls;

        @Data
        public static class Control {

          private String identityCard;
          private String checkType;
          private String checkTime;
        }
      }

      @Data
      public static class Floor {

        private String id;
        private List<Control> controls;

        @Data
        public static class Control {

          private String identityCard;
          private String checkType;
          private String checkTime;
        }
      }

      @Data
      public static class Apartment {

        private String id;
        private List<Control> controls;

        @Data
        public static class Control {

          private String identityCard;
          private String checkType;
          private String checkTime;
        }
      }
    }
  }
}
