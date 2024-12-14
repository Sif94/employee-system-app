package org.baouz.ems.common;

import java.util.List;

public class PageResponse<T> {
    private Integer page;
    private Integer size;
    private Long totalElements;
    private Long totalPages;
    private List<T> content;
    private Boolean isFirst;
    private Boolean isLast;

    public PageResponse(Integer page, Integer size, Long totalElements, Long totalPages, List<T> content, Boolean isFirst, Boolean isLast) {
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.content = content;
        this.isFirst = isFirst;
        this.isLast = isLast;
    }

    public PageResponse() {
    }

    public static <T> PageResponseBuilder<T> builder() {
        return new PageResponseBuilder<T>();
    }

    public Integer getPage() {
        return this.page;
    }

    public Integer getSize() {
        return this.size;
    }

    public Long getTotalElements() {
        return this.totalElements;
    }

    public Long getTotalPages() {
        return this.totalPages;
    }

    public List<T> getContent() {
        return this.content;
    }

    public Boolean getIsFirst() {
        return this.isFirst;
    }

    public Boolean getIsLast() {
        return this.isLast;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public void setIsFirst(Boolean isFirst) {
        this.isFirst = isFirst;
    }

    public void setIsLast(Boolean isLast) {
        this.isLast = isLast;
    }

    public static class PageResponseBuilder<T> {
        private Integer page;
        private Integer size;
        private Long totalElements;
        private Long totalPages;
        private List<T> content;
        private Boolean isFirst;
        private Boolean isLast;

        PageResponseBuilder() {
        }

        public PageResponseBuilder<T> page(Integer page) {
            this.page = page;
            return this;
        }

        public PageResponseBuilder<T> size(Integer size) {
            this.size = size;
            return this;
        }

        public PageResponseBuilder<T> totalElements(Long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public PageResponseBuilder<T> totalPages(Long totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public PageResponseBuilder<T> content(List<T> content) {
            this.content = content;
            return this;
        }

        public PageResponseBuilder<T> isFirst(Boolean isFirst) {
            this.isFirst = isFirst;
            return this;
        }

        public PageResponseBuilder<T> isLast(Boolean isLast) {
            this.isLast = isLast;
            return this;
        }

        public PageResponse<T> build() {
            return new PageResponse<T>(this.page, this.size, this.totalElements, this.totalPages, this.content, this.isFirst, this.isLast);
        }

        public String toString() {
            return "PageResponse.PageResponseBuilder(page=" + this.page + ", size=" + this.size + ", totalElements=" + this.totalElements + ", totalPages=" + this.totalPages + ", content=" + this.content + ", isFirst=" + this.isFirst + ", isLast=" + this.isLast + ")";
        }
    }
}
