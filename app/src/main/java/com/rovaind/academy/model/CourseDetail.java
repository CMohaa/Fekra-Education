
package com.rovaind.academy.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CourseDetail implements Serializable {

    @SerializedName("videoLession")
    @Expose
    private List<VideoLession> videoLession = null;

    public List<VideoLession> getVideoLession() {
        return videoLession;
    }

    public void setVideoLession(List<VideoLession> videoLession) {
        this.videoLession = videoLession;
    }

}
