package com.rxh.complat.common.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 *
 * @Description: 汉字转拼音工具类
 * @Author Zhang YuHui 
 * @Date 2020/11/26 11:38
 *
 */
public class PinYinUtils {


    /**
     * @Description 中文全拼
     * @author Zhang YuHui
     * @date 2020/11/26 11:38
     *
     * @params text 对应字符串
     * @params split 分隔符,无需分隔传入空
     * @return java.lang.String
     */
    public static String getAllPin(String text, String split)  {
        char[] chars = text.toCharArray();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);


        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (String.valueOf(chars[i]).matches("[\\u4E00-\\u9FA5]+")) {
                String[] strings = new String[0];
                try {
                    strings = PinyinHelper.toHanyuPinyinStringArray(chars[i], format);
                } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                    badHanyuPinyinOutputFormatCombination.printStackTrace();
                }
                if (strings != null) {
                    buffer.append(strings[0]).append(split);
                    continue;
                }
            }
            buffer.append(String.valueOf(chars[i]));
            boolean b = i + 1 >= chars.length;
            if (b || !String.valueOf(chars[i + 1]).matches("[\\u4E00-\\u9FA5]+")) {
                buffer.append(split);
            }
        }
        return buffer.toString();
    }

}
