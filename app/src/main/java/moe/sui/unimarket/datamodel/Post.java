package moe.sui.unimarket.datamodel;

import com.google.gson.Gson;

import java.util.List;

public class Post {
    /**
     * id : 1
     * date : 2020-04-16T12:36:19
     * date_gmt : 2020-04-16T04:36:19
     * modified : 2020-04-16T12:36:19
     * slug : hello-world
     * status : publish
     * type : post
     * link : https://wp.sui.moe/index.php/2020/04/16/hello-world/
     * title : {"rendered":"世界，您好！"}
     * content : {"rendered":"\n<p>欢迎使用WordPress。这是您的第一篇文章。编辑或删除它，然后开始写作吧！<\/p>\n","protected":false}
     * excerpt : {"rendered":"<p>欢迎使用WordPress。这是您的第一篇文章。编辑或删除它，然后开始写作吧！<\/p>\n","protected":false}
     * author : 1
     * featured_media : 0
     * comment_status : open
     * ping_status : open
     * sticky : false
     * template :
     * format : standard
     * categories : [1]
     * tags : []
     */

    public static final String[] postKey = new String[]{"id", "date", "date_gmt", "slug", "title", "status", "content"};

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getDate_gmt() {
        return date_gmt;
    }

    public String getModified() {
        return modified;
    }

    public String getSlug() {
        return slug;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getLink() {
        return link;
    }

    public TitleBean getTitle() {
        return title;
    }

    public ContentBean getContent() {
        return content;
    }

    public ExcerptBean getExcerpt() {
        return excerpt;
    }

    public int getAuthor() {
        return author;
    }

    public int getFeatured_media() {
        return featured_media;
    }

    public String getComment_status() {
        return comment_status;
    }

    public String getPing_status() {
        return ping_status;
    }

    public boolean isSticky() {
        return sticky;
    }

    public String getTemplate() {
        return template;
    }

    public String getFormat() {
        return format;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public List<Integer> getTags() {
        return tags;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDate_gmt(String date_gmt) {
        this.date_gmt = date_gmt;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setTitle(TitleBean title) {
        this.title = title;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public void setExcerpt(ExcerptBean excerpt) {
        this.excerpt = excerpt;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public void setFeatured_media(int featured_media) {
        this.featured_media = featured_media;
    }

    public void setComment_status(String comment_status) {
        this.comment_status = comment_status;
    }

    public void setPing_status(String ping_status) {
        this.ping_status = ping_status;
    }

    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }

    public void setTags(List<Integer> tags) {
        this.tags = tags;
    }

    private int id;
    private String date;
    private String date_gmt;
    private String modified;
    private String slug;
    private String status;
    private String type;
    private String link;
    private TitleBean title;
    private ContentBean content;
    private ExcerptBean excerpt;
    private int author;
    private int featured_media;
    private String comment_status;
    private String ping_status;
    private boolean sticky;
    private String template;
    private String format;
    private java.util.List<Integer> categories;
    private java.util.List<Integer> tags;

    public class ContentBean {
        /**
         * rendered :
         <p>欢迎使用WordPress。这是您的第一篇文章。编辑或删除它，然后开始写作吧！</p>
         * protected : false
         */

        private String rendered;
        @com.google.gson.annotations.SerializedName("protected")
        private boolean protectedX;

        public String getRendered() {
            return rendered;
        }

        public void setRendered(String rendered) {
            this.rendered = rendered;
        }

        public boolean isProtectedX() {
            return protectedX;
        }

        public void setProtectedX(boolean protectedX) {
            this.protectedX = protectedX;
        }
    }

    public class TitleBean {
        /**
         * rendered : 世界，您好！
         */

        private String rendered;

        public String getRendered() {
            return rendered;
        }

        public void setRendered(String rendered) {
            this.rendered = rendered;
        }
    }

    public class ExcerptBean {
        /**
         * rendered : <p>欢迎使用WordPress。这是您的第一篇文章。编辑或删除它，然后开始写作吧！</p>
         * protected : false
         */

        private String rendered;
        @com.google.gson.annotations.SerializedName("protected")
        private boolean protectedX;

        public String getRendered() {
            return rendered;
        }

        public void setRendered(String rendered) {
            this.rendered = rendered;
        }

        public boolean isProtectedX() {
            return protectedX;
        }

        public void setProtectedX(boolean protectedX) {
            this.protectedX = protectedX;
        }
    }
}
