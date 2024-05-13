package com.sunny.lms.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.*;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

/***
 *
 * @author SUNNY
 * @description 短信工具类
 * date  2023-03-09 11:07:16
 */
public class SmsUtils {

    public static void sendSms(String phone,String code){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "", "");

        IAcsClient client = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();
        request.setSignName("sunny");
        request.setTemplateCode("SMS_257860840");
        request.setPhoneNumbers(phone);
        request.setTemplateParam("{\"code\":\""+code+"\"}");

        System.out.println("阿里云短信服务response信息:");

        try {
            SendSmsResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
    }

}

