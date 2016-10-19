package com.bdwuzhou.ximalaya.Bean;

import java.util.List;

/**
 * Created by BDwuzhou on 2016/10/18.
 */

public class FocusImages {

    private int ret;
    private String title;
    private List<ListBean> list;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "FocusImages{" +
                "ret=" + ret +
                ", title='" + title + '\'' +
                ", list=" + list +
                '}';
    }

    public static class ListBean {
        @Override
        public String toString() {
            return "ListBean{" +
                    "id=" + id +
                    ", shortTitle='" + shortTitle + '\'' +
                    ", longTitle='" + longTitle + '\'' +
                    ", pic='" + pic + '\'' +
                    ", type=" + type +
                    ", uid=" + uid +
                    ", albumId=" + albumId +
                    ", isShare=" + isShare +
                    ", is_External_url=" + is_External_url +
                    '}';
        }

        private int id;
        private String shortTitle;
        private String longTitle;
        private String pic;
        private int type;
        private int uid;
        private int albumId;
        private boolean isShare;
        private boolean is_External_url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getShortTitle() {
            return shortTitle;
        }

        public void setShortTitle(String shortTitle) {
            this.shortTitle = shortTitle;
        }

        public String getLongTitle() {
            return longTitle;
        }

        public void setLongTitle(String longTitle) {
            this.longTitle = longTitle;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getAlbumId() {
            return albumId;
        }

        public void setAlbumId(int albumId) {
            this.albumId = albumId;
        }

        public boolean isIsShare() {
            return isShare;
        }

        public void setIsShare(boolean isShare) {
            this.isShare = isShare;
        }

        public boolean isIs_External_url() {
            return is_External_url;
        }

        public void setIs_External_url(boolean is_External_url) {
            this.is_External_url = is_External_url;
        }
    }
}
