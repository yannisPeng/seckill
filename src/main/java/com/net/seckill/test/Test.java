package com.net.seckill.test;

/**
 * Description:
 *
 * @author 10014994
 * @date: 2020/5/11
 */
public class Test {

    public static void main(String[] args) {
        String a = "BusinessException(code=re10150, msg=拆包传入商品为黑码且订单商品id不为0，数据异常, level=, errData=null, errorCodeDefine=UNPACK_BLACK_GOODS_HAVE_OTS_ID, httpStatus=null)";
        String s = a.substring(36,a.length());
        System.out.println(s.split("，")[0]);
    }
}
