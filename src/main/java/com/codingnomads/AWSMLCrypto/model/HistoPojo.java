package com.codingnomads.AWSMLCrypto.model;

/**
 * created by Jialor Cheung on 12/19/17
 */

public class HistoPojo {

    private String response;
    private Integer type;
    private Boolean aggregated;
    private Data[] data;
    private Long timeTo;
    private Long timeFrom;
    private Boolean firstVolumeInArray;
    private ConversionType conversionType;

    public HistoPojo() {
    }

    public HistoPojo(String response, Integer type, Boolean aggregated, Data[] data, Long timeTo, Long timeFrom, Boolean firstVolumeInArray, ConversionType conversionType) {
        this.response = response;
        this.type = type;
        this.aggregated = aggregated;
        this.data = data;
        this.timeTo = timeTo;
        this.timeFrom = timeFrom;
        this.firstVolumeInArray = firstVolumeInArray;
        this.conversionType = conversionType;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getAggregated() {
        return aggregated;
    }

    public void setAggregated(Boolean aggregated) {
        this.aggregated = aggregated;
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    public Long getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Long timeTo) {
        this.timeTo = timeTo;
    }

    public Long getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Long timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Boolean getFirstVolumeInArray() {
        return firstVolumeInArray;
    }

    public void setFirstVolumeInArray(Boolean firstVolumeInArray) {
        this.firstVolumeInArray = firstVolumeInArray;
    }

    public ConversionType getConversionType() {
        return conversionType;
    }

    public void setConversionType(ConversionType conversionType) {
        this.conversionType = conversionType;
    }
}
