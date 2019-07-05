package com.yzy.netty.handle3;

/**
 * @author yzy
 * @classname PersonProtocol
 * @description TODO
 * @create 2019-07-05 9:56
 */
public class PersonProtocol {

    private int length;

    private byte[] content;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
