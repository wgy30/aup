package com.wgy.aup.common.utils;

import com.wgy.aup.exception.BaseException;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author wgy
 * @date 2021/11/21 23:49:32
 */
public class DigestUtils {

    /**
     * MessageDigest类：Java.security包的类，提供MD5、SHA等密码安全的报文摘要功能的类。输出一个摘要或散列。
     * 特性：
     *  1、无法通过计算找到两个散列成相同值的报文
     *  2、摘要不反映任何与输入有关的内容
     *  3、使用报文摘要可生成数据唯一且可靠的标识符，有时称为数据的“数字指纹”
     *
     * 方法：
     *  1、getInstance(String)：返货实现指定摘要算法的MessageDigest对象   MD2、MD5、SHA-1、SHA-256、SHA-384、SHA-512
     *  2、update(byte[])：对象调用该方法处理数据
     *  3、digest()：数据被更新后，需调用digest完成hash计算，之后MessageDigest被设置成初始状态
     *  4、reset：重置摘要
     *  5、isEqual(byte[],byte[])：比较两个摘要的相等性
     */

    /**
     * MD5-32位加密
     * @param str
     * @return
     */
    public static String digest32(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(str.getBytes());
            StringBuffer buffer = new StringBuffer();
            for (byte b : bytes) {
                int bt = b&0xff;
                if (bt < 16) {
                    buffer.append(0);
                }
                buffer.append(Integer.toHexString(bt));
            }
            return buffer.toString();
        }catch (NoSuchAlgorithmException ex) {
            throw new BaseException("数据加密失败");
        }
    }

    /**
     * MD5-16位加密
     */

}
