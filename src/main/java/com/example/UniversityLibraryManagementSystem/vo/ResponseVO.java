package com.example.UniversityLibraryManagementSystem.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseVO<T> {



    @JsonProperty("timestamp")
    private String timeStamp;


    @JsonProperty("status")
    private int status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("error")
    private String error;

    @JsonProperty("path")
    private String path;

    @JsonProperty("content")
    private List<T> data;

    @JsonProperty("content")
    private List<T> data1;

    @JsonProperty("pageble")
    private PaginatedResponseVOAndCount  pageable;



    public ResponseVO() {

        super();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String formattedTime = sdf.format(new Date(System.currentTimeMillis()));
        this.timeStamp=formattedTime;
        this.data = new ArrayList<>();
        this.status = 200;
        this.message = "success";
    }



   public void addDataList(List<T> data)
   {
       if (data != null|| !data.isEmpty()) {
           this.data.addAll(data);
       }
   }
    public void addDataList1(List<T> data,List<T> data1)
    {
        if (data != null|| !data.isEmpty()) {
            this.data.addAll(data);
        }
    }
    public void addData(T data) {
        if (data != null) {
            this.data.add(data);
        }
    }
}