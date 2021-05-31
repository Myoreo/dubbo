package org.apache.dubbo.demo.bean;

/**
 * @Author : xuaoping
 * @Date: 2020/11/25
 */
public enum GoodsType {
    Book(1), Phone(2);
    int code;

    private GoodsType(int code) {
        this.code = code;
    }
}
