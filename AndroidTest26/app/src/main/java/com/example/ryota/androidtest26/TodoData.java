package com.example.ryota.androidtest26;

class TodoData {
    private String todo_id;
    private String todo_title;
    private String todo_contents;
    private String limit_date;

    public String getTodo_id() {
        return this.todo_id;
    }

    public void setTodo_id(String todo_id) {
        this.todo_id = todo_id;
    }

    public String getTodo_title() {
        return this.todo_title;
    }

    public void setTodo_title(String todo_title) {
        this.todo_title = todo_title;
    }

    public String getTodo_contents() {
        return this.todo_contents;
    }

    public void setTodo_contents(String todo_contents) {
        this.todo_contents = todo_contents;
    }

    public String getLimit_date() {
        return this.limit_date;
    }

    public void setLimit_date(String limit_date) {
        this.limit_date = limit_date;
    }

}
