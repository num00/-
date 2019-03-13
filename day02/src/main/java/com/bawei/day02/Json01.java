package com.bawei.day02;

import java.util.ArrayList;

/**
 * @Author：魏恒炜
 * @E-mail：
 * @Date：2019/3/13 19:13
 * @Description：描述信息
 */
public class Json01 {
    private String code;
    private String msg;
    private ArrayList<data> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<data> getData() {
        return data;
    }

    public void setData(ArrayList<data> data) {
        this.data = data;
    }

    public static class  data{
        private String book_cover;
        private String bookname;
        private String class_name;
        private String book_info;

        public String getBook_cover() {
            return book_cover;
        }

        public void setBook_cover(String book_cover) {
            this.book_cover = book_cover;
        }

        public String getBookname() {
            return bookname;
        }

        public void setBookname(String bookname) {
            this.bookname = bookname;
        }

        public String getClass_name() {
            return class_name;
        }

        public void setClass_name(String class_name) {
            this.class_name = class_name;
        }

        public String getBook_info() {
            return book_info;
        }

        public void setBook_info(String book_info) {
            this.book_info = book_info;
        }
    }

}
