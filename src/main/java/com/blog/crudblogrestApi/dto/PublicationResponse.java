package com.blog.crudblogrestApi.dto;

import java.util.List;

public class PublicationResponse {

    private List<PublicationDTO> content;
    private int page;
    private int size;
    private long totalPublications;
    private int TotalPages;
    private boolean last;

    public PublicationResponse() {
    }

    public List<PublicationDTO> getContent() {
        return content;
    }

    public void setContent(List<PublicationDTO> content) {
        this.content = content;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotalPublications() {
        return totalPublications;
    }

    public void setTotalPublications(long totalPublications) {
        this.totalPublications = totalPublications;
    }

    public int getTotalPages() {
        return TotalPages;
    }

    public void setTotalPages(int totalPages) {
        TotalPages = totalPages;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }
}
