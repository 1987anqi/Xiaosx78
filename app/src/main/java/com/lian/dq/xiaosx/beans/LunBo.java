package com.lian.dq.xiaosx.beans;

import java.util.List;

public class LunBo {

    private List<BannerListBean> banner_list;

    public List<BannerListBean> getBanner_list() {
        return banner_list;
    }

    public void setBanner_list(List<BannerListBean> banner_list) {
        this.banner_list = banner_list;
    }

    public static class BannerListBean {
        /**
         * banner_date : banner第一张图
         * banner_url : http://106.13.63.54:8080/sys/image/b.jpg
         * banner_content : Handler机制几个关键的对象了，Looper、MessageQueue、Message
         */

        private String banner_date;
        private String banner_url;
        private String banner_content;

        public String getBanner_date() {
            return banner_date;
        }

        public void setBanner_date(String banner_date) {
            this.banner_date = banner_date;
        }

        public String getBanner_url() {
            return banner_url;
        }

        public void setBanner_url(String banner_url) {
            this.banner_url = banner_url;
        }

        public String getBanner_content() {
            return banner_content;
        }

        public void setBanner_content(String banner_content) {
            this.banner_content = banner_content;
        }
    }
}
