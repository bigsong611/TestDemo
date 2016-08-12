package com.bigsong.testdemo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
public class NewJsonEntity {

    private String resultCode;
    private String resultMsg;
    private String systemTime;
    private String nodeId;
    private String channelName;
    private String type;
    private List<NewBean> posterList;
    private List<ClassifyListBean> classifyList;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(String systemTime) {
        this.systemTime = systemTime;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<NewBean> getPosterList() {
        return posterList;
    }

    public void setPosterList(List<NewBean> posterList) {
        this.posterList = posterList;
    }

    public List<ClassifyListBean> getClassifyList() {
        return classifyList;
    }

    public void setClassifyList(List<ClassifyListBean> classifyList) {
        this.classifyList = classifyList;
    }
    

    public static class ClassifyListBean {
        private String name;
        private String moreType;
        private String moreURL;
        private String lookType;
        private List<NewBean> recommnedList;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMoreType() {
            return moreType;
        }

        public void setMoreType(String moreType) {
            this.moreType = moreType;
        }

        public String getMoreURL() {
            return moreURL;
        }

        public void setMoreURL(String moreURL) {
            this.moreURL = moreURL;
        }

        public String getLookType() {
            return lookType;
        }

        public void setLookType(String lookType) {
            this.lookType = lookType;
        }

        public List<NewBean> getRecommnedList() {
            return recommnedList;
        }

        public void setRecommnedList(List<NewBean> recommnedList) {
            this.recommnedList = recommnedList;
        }

    }
}
