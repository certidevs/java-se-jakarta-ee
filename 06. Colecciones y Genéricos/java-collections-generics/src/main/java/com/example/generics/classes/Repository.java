package com.example.generics.classes;

public class Repository<T> {
    private T content;
    public T getContent(){
        return content;
    }
    public void setContent(T content){
        this.content = content;
    }
}
