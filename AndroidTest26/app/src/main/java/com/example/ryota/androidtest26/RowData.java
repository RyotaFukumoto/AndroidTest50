package com.example.ryota.androidtest26;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class RowData {
    public String getCreated() {
        return this.created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return this.modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public int getDelete_flg() {
        return this.delete_flg;
    }

    public void setDelete_flg(int delete_flg) {
        this.delete_flg = delete_flg;
    }

    private int todoID;
    private String title;
    private String content;
    private String created;
    private String modified;
    private String limit;
    private int delete_flg;

    RowData(int todoID, String title, String content, String limit) {
        this.todoID = todoID;
        this.title = title;
        this.content = content;
        this.limit = dateFormat(limit);


    }

    public int getTodoID() {
        return this.todoID;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getLimit() {
        return this.limit;
    }

    public void setTodoID(int todoID) {
        this.todoID = todoID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLimit(String limit) {
        this.limit = dateFormat(limit);
    }

    private String dateFormat(String dateStr){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(dateStr);
        return df.format(date);
    }
}
