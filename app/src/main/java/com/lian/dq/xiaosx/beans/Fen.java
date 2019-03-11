package com.lian.dq.xiaosx.beans;

import java.util.List;

public class Fen {


    private List<ClassifyBean> classify;

    public List<ClassifyBean> getClassify() {
        return classify;
    }

    public void setClassify(List<ClassifyBean> classify) {
        this.classify = classify;
    }

    public static class ClassifyBean {
        /**
         * classify_title : 推荐
         * classify_type : 2
         */

        private String classify_title;
        private String classify_type;

        public String getClassify_title() {
            return classify_title;
        }

        public void setClassify_title(String classify_title) {
            this.classify_title = classify_title;
        }

        public String getClassify_type() {
            return classify_type;
        }

        public void setClassify_type(String classify_type) {
            this.classify_type = classify_type;
        }
    }
}
