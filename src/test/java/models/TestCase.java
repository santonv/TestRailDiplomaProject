package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCase {

    @Expose
    String title;
    String section;
    @Expose(serialize = false)
    @SerializedName("template_id")
    String template;
    @Expose(serialize = false)
    @SerializedName("type_id")
    String type;
    @Expose(serialize = false)
    @SerializedName("priority_id")
    String priority;
    @Expose(serialize = false)
    String estimate;
    @Expose(serialize = false)
    @SerializedName("milestone_id")
    String milestone;
    @Expose(serialize = false)
    @SerializedName("refs")
    String references;
    String automationType;
    String preconditions;
    String steps;
    String expectedResult;
}
