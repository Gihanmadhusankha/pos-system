package com.projects.pos.system.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerNameRequestByQueryDTO {

    private String name;
    private String nic;

}
