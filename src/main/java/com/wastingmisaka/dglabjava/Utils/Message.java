package com.wastingmisaka.dglabjava.Utils;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @JSONField(name = "type")
    private String type;

    @JSONField(name="message")
    private String message;

    @JSONField(name="clientId")
    private String clientId;

    @JSONField(name="targetId")
    private String targetId;


}
