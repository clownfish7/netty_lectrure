package com.yzy.jh;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.apache.commons.codec.digest.Md5Crypt;
import sun.security.provider.MD5;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author yzy
 * @classname F200
 * @description TODO
 * @create 2019-11-04 17:16
 */
public class F200 {
    private int logicChannel;
    private int enableFaceCheck;
    private int enableFaceComparison;
    private int enableFaceUpload;
    private int faceComparisonConfidence;
    private int alarmPromptingMode;
    private int faceCheckResultPromptVolume;
    private String faceCheckResultContent;
    private int faceCheckBeginSpeed;
    private int faceCheckEndSpeed;
    private int faceCheckTriggerStrategy;
    private int faceCheckTimeInterval;
    private int faceCheckDistanceInterval;
    private int enableTakePicUpload;
    private int takePicUploadLogicChannel;
    private int picResolutionRatio;
    private int enableTakeVedioUpload;
    private int takeVedioUploadLogicChannel;
    private int alarmTakeVedioTime;
    private int vedioResolutionRatio;

    public int getLogicChannel() {
        return logicChannel;
    }

    public void setLogicChannel(int logicChannel) {
        this.logicChannel = logicChannel;
    }

    public int getEnableFaceCheck() {
        return enableFaceCheck;
    }

    public void setEnableFaceCheck(int enableFaceCheck) {
        this.enableFaceCheck = enableFaceCheck;
    }

    public int getEnableFaceComparison() {
        return enableFaceComparison;
    }

    public void setEnableFaceComparison(int enableFaceComparison) {
        this.enableFaceComparison = enableFaceComparison;
    }

    public int getEnableFaceUpload() {
        return enableFaceUpload;
    }

    public void setEnableFaceUpload(int enableFaceUpload) {
        this.enableFaceUpload = enableFaceUpload;
    }

    public int getFaceComparisonConfidence() {
        return faceComparisonConfidence;
    }

    public void setFaceComparisonConfidence(int faceComparisonConfidence) {
        this.faceComparisonConfidence = faceComparisonConfidence;
    }

    public int getAlarmPromptingMode() {
        return alarmPromptingMode;
    }

    public void setAlarmPromptingMode(int alarmPromptingMode) {
        this.alarmPromptingMode = alarmPromptingMode;
    }

    public int getFaceCheckResultPromptVolume() {
        return faceCheckResultPromptVolume;
    }

    public void setFaceCheckResultPromptVolume(int faceCheckResultPromptVolume) {
        this.faceCheckResultPromptVolume = faceCheckResultPromptVolume;
    }

    public String getFaceCheckResultContent() {
        return faceCheckResultContent;
    }

    public void setFaceCheckResultContent(String faceCheckResultContent) {
        this.faceCheckResultContent = faceCheckResultContent;
    }

    public int getFaceCheckBeginSpeed() {
        return faceCheckBeginSpeed;
    }

    public void setFaceCheckBeginSpeed(int faceCheckBeginSpeed) {
        this.faceCheckBeginSpeed = faceCheckBeginSpeed;
    }

    public int getFaceCheckEndSpeed() {
        return faceCheckEndSpeed;
    }

    public void setFaceCheckEndSpeed(int faceCheckEndSpeed) {
        this.faceCheckEndSpeed = faceCheckEndSpeed;
    }

    public int getFaceCheckTriggerStrategy() {
        return faceCheckTriggerStrategy;
    }

    public void setFaceCheckTriggerStrategy(int faceCheckTriggerStrategy) {
        this.faceCheckTriggerStrategy = faceCheckTriggerStrategy;
    }

    public int getFaceCheckTimeInterval() {
        return faceCheckTimeInterval;
    }

    public void setFaceCheckTimeInterval(int faceCheckTimeInterval) {
        this.faceCheckTimeInterval = faceCheckTimeInterval;
    }

    public int getFaceCheckDistanceInterval() {
        return faceCheckDistanceInterval;
    }

    public void setFaceCheckDistanceInterval(int faceCheckDistanceInterval) {
        this.faceCheckDistanceInterval = faceCheckDistanceInterval;
    }

    public int getEnableTakePicUpload() {
        return enableTakePicUpload;
    }

    public void setEnableTakePicUpload(int enableTakePicUpload) {
        this.enableTakePicUpload = enableTakePicUpload;
    }

    public int getTakePicUploadLogicChannel() {
        return takePicUploadLogicChannel;
    }

    public void setTakePicUploadLogicChannel(int takePicUploadLogicChannel) {
        this.takePicUploadLogicChannel = takePicUploadLogicChannel;
    }

    public int getPicResolutionRatio() {
        return picResolutionRatio;
    }

    public void setPicResolutionRatio(int picResolutionRatio) {
        this.picResolutionRatio = picResolutionRatio;
    }

    public int getEnableTakeVedioUpload() {
        return enableTakeVedioUpload;
    }

    public void setEnableTakeVedioUpload(int enableTakeVedioUpload) {
        this.enableTakeVedioUpload = enableTakeVedioUpload;
    }

    public int getTakeVedioUploadLogicChannel() {
        return takeVedioUploadLogicChannel;
    }

    public void setTakeVedioUploadLogicChannel(int takeVedioUploadLogicChannel) {
        this.takeVedioUploadLogicChannel = takeVedioUploadLogicChannel;
    }

    public int getAlarmTakeVedioTime() {
        return alarmTakeVedioTime;
    }

    public void setAlarmTakeVedioTime(int alarmTakeVedioTime) {
        this.alarmTakeVedioTime = alarmTakeVedioTime;
    }

    public int getVedioResolutionRatio() {
        return vedioResolutionRatio;
    }

    public void setVedioResolutionRatio(int vedioResolutionRatio) {
        this.vedioResolutionRatio = vedioResolutionRatio;
    }

    public String encode() {
        byte[] faceCheckContentBytes = faceCheckResultContent.getBytes(Charset.forName("gbk"));
        int length = 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + faceCheckContentBytes.length + 1 + 1 + 1 + 2 + 2 + 1 + 4 + 1 + 1 + 4 + 1 + 1 + 4;
        ByteBuf byteBuf = Unpooled.buffer(length);
        byteBuf.writeByte(logicChannel);
        byteBuf.writeByte(enableFaceCheck);
        byteBuf.writeByte(enableFaceComparison);
        byteBuf.writeByte(enableFaceUpload);
        byteBuf.writeByte(faceComparisonConfidence);
        byteBuf.writeByte(alarmPromptingMode);
        byteBuf.writeByte(faceCheckResultPromptVolume);
        byteBuf.writeByte(faceCheckContentBytes.length);
        byteBuf.writeBytes(faceCheckContentBytes);
        byteBuf.writeByte(faceCheckBeginSpeed);
        byteBuf.writeByte(faceCheckEndSpeed);
        byteBuf.writeByte(faceCheckTriggerStrategy);
        byteBuf.writeBytes(ByteUtil.int2WORD(faceCheckTimeInterval));
        byteBuf.writeBytes(ByteUtil.int2WORD(faceCheckDistanceInterval));
        byteBuf.writeByte(enableTakePicUpload);
        byteBuf.writeBytes(ByteUtil.int2DWORD(takePicUploadLogicChannel));
        byteBuf.writeByte(picResolutionRatio);
        byteBuf.writeByte(enableTakeVedioUpload);
        byteBuf.writeBytes(ByteUtil.int2DWORD(takeVedioUploadLogicChannel));
        byteBuf.writeByte(alarmTakeVedioTime);
        byteBuf.writeByte(vedioResolutionRatio);
        byteBuf.writeByte(0);
        byteBuf.writeByte(0);
        byteBuf.writeByte(0);
        byteBuf.writeByte(0);

        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);
        return getCode(bytes);
    }

    public String encode2() {
        byte[] faceCheckContentBytes = faceCheckResultContent.getBytes(Charset.forName("gbk"));
        int length = 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + faceCheckContentBytes.length + 1 + 1 + 1 + 2 + 2 + 1 + 4 + 1 + 1 + 4 + 1 + 1 + 4;
        ByteBuffer byteBuffer = ByteBuffer.allocate(length);
        byteBuffer.put((byte) logicChannel);
        byteBuffer.put((byte) enableFaceCheck);
        byteBuffer.put((byte) enableFaceComparison);
        byteBuffer.put((byte) enableFaceUpload);
        byteBuffer.put((byte) faceComparisonConfidence);
        byteBuffer.put((byte) alarmPromptingMode);
        byteBuffer.put((byte)faceCheckResultPromptVolume);
        byteBuffer.put((byte)faceCheckContentBytes.length);
        byteBuffer.put(faceCheckContentBytes);
        byteBuffer.put((byte)faceCheckBeginSpeed);
        byteBuffer.put((byte)faceCheckEndSpeed);
        byteBuffer.put((byte)faceCheckTriggerStrategy);
        byteBuffer.putShort((short) faceCheckTimeInterval);
        byteBuffer.putShort((short) faceCheckDistanceInterval);
        byteBuffer.put((byte)enableTakePicUpload);
        byteBuffer.putInt(takePicUploadLogicChannel);
        byteBuffer.put((byte)picResolutionRatio);
        byteBuffer.put((byte)enableTakeVedioUpload);
        byteBuffer.putInt(takeVedioUploadLogicChannel);
        byteBuffer.put((byte)alarmTakeVedioTime);
        byteBuffer.put((byte)vedioResolutionRatio);
        byteBuffer.putInt(0);

        byte[] bytes = new byte[length];
        byteBuffer.flip();
        byteBuffer.get(bytes);
        return getCode(bytes);
    }

    public String getCode(byte[] bytes) {
        return new String(Base64.getEncoder().encode(bytes));
    }

}
