package com.bigsong.testdemo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 * http://202.108.16.229/cntv/resource/cltv2/channel.jsp?nodeId=442&uuid=147028889447637&clientId=&userId=26
 */
public class ChannelJsonEntity {

    private String resultCode;
    private String resultMsg;
    private String systemTime;
    private String updateTime;
    private List<ChannelBean> fixChannel;
    private List<ChannelBean> commonChannel;
    private List<ChannelBean> otherChannel;

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

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public List<ChannelBean> getFixChannel() {
        return fixChannel;
    }

    public void setFixChannel(List<ChannelBean> fixChannel) {
        this.fixChannel = fixChannel;
    }

    public List<ChannelBean> getCommonChannel() {
        return commonChannel;
    }

    public void setCommonChannel(List<ChannelBean> commonChannel) {
        this.commonChannel = commonChannel;
    }

    public List<ChannelBean> getOtherChannel() {
        return otherChannel;
    }

    public void setOtherChannel(List<ChannelBean> otherChannel) {
        this.otherChannel = otherChannel;
    }


}
