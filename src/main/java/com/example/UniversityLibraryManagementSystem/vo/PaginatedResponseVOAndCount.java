package com.example.UniversityLibraryManagementSystem.vo;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Setter
@ToString
@AllArgsConstructor
public class PaginatedResponseVOAndCount<T> {
    private long pageNumber;
    private long pageSize;
    private SortVO sort;
    private long totalElement;
    private boolean last;
    private boolean fist;
    private long number;
    private long numberOfElement;
    private boolean  empty;
    public void addList(long pageNumber,long pageSize,SortVO sort,long totalElement,boolean last,boolean fist,long number,long numberOfElement,boolean empty )
    {
        this.pageNumber=pageNumber;
        this.pageSize=pageSize;
        this.sort=sort;
        this.totalElement=totalElement;
        this.last=last;
        this.fist=fist;
        this.number=number;
        this.numberOfElement=numberOfElement;
        this.empty=empty;
    }

}
