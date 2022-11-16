package com.sb.poc.cursorsmybatis.dto;

import lombok.Data;
import java.util.List;

@Data
public class PrcParams {
    private String pUsername; //IN
    private List<DBUser> users; //OUT
    private List<CreationTimes> creationTimes; //OUT
}
