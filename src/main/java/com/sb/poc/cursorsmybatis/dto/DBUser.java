package com.sb.poc.cursorsmybatis.dto;

import lombok.Data;

@Data
public class DBUser {
    private Integer userId;
    private String username;
    private String createdBy;
    private String createdDate;
}
