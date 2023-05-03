package com.example.coursemgmt_backend.util;

import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CustomPage<T> {

    private int currentPage;
    private int pageSize;
    private int totalPages;
    private long totalItems;
    private List<T> data;


//    public CustomPage(int currentPage, int pageSize, int totalPages, long totalItems, List<T> data) {
//        this.currentPage = currentPage;
//        this.pageSize = pageSize;
//        this.totalPages = totalPages;
//        this.totalItems = totalItems;
//        this.data = data;
//    }
//
//
//    public int getCurrentPage() {
//        return currentPage;
//    }
//
//    public void setCurrentPage(int currentPage) {
//        this.currentPage = currentPage;
//    }
//
//    public int getPageSize() {
//        return pageSize;
//    }
//
//    public void setPageSize(int pageSize) {
//        this.pageSize = pageSize;
//    }
//
//    public int getTotalPages() {
//        return totalPages;
//    }
//
//    public void setTotalPages(int totalPages) {
//        this.totalPages = totalPages;
//    }
//
//    public long getTotalItems() {
//        return totalItems;
//    }
//
//    public void setTotalItems(long totalItems) {
//        this.totalItems = totalItems;
//    }
//
//    public List<T> getData() {
//        return data;
//    }
//
//    public void setData(List<T> data) {
//        this.data = data;
//    }
}
