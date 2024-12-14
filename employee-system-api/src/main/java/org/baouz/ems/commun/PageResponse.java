package org.baouz.ems.commun;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PageResponse<T> {
    private Integer page;
    private Integer size;
    private Long totalElements;
    private Long totalPages;
    private List<T> content;
    private Boolean isFirst;
    private Boolean isLast;
}
