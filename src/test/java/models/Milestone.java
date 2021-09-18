package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Milestone {
    String name;
    String references;
    String parent;
    String description;
    String startDate;
    String endDate;
}
