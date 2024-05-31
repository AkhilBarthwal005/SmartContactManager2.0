package com.scm.helper;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Alert {
    private String message;
    private String type="green";
}
