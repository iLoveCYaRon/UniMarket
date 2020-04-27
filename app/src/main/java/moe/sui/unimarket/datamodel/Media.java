package moe.sui.unimarket.datamodel;

import java.util.List;

public class Media {
    /**
     * id : 80
     * date : 2020-04-26T18:54:27
     * date_gmt : 2020-04-26T10:54:27
     * guid : {"rendered":"http://shop.sui.moe/wp-content/uploads/2020/04/timg1.jpg"}
     * modified : 2020-04-26T18:54:27
     * modified_gmt : 2020-04-26T10:54:27
     * slug : timg1
     * status : inherit
     * type : attachment
     * link : https://shop.sui.moe/index.php/2020/04/26/%e6%9c%ac%e6%98%af%e6%97%a0%e6%84%8f%e7%a9%bf%e5%a0%82%e9%a3%8e-%e5%81%8f%e5%81%8f%e5%ad%a4%e6%8d%ae%e5%bc%95%e5%b1%b1%e6%b4%aa/timg1/
     * title : {"rendered":"timg[1]"}
     * author : 1
     * comment_status : open
     * ping_status : closed
     * template :
     * meta : []
     * description : {"rendered":"<p class=\"attachment\"><a href='https://shop.sui.moe/wp-content/uploads/2020/04/timg1.jpg'><img width=\"300\" height=\"166\" src=\"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-300x166.jpg\" class=\"attachment-medium size-medium\" alt=\"\" srcset=\"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-300x166.jpg 300w, https://shop.sui.moe/wp-content/uploads/2020/04/timg1-416x231.jpg 416w, https://shop.sui.moe/wp-content/uploads/2020/04/timg1.jpg 658w\" sizes=\"(max-width: 300px) 100vw, 300px\" /><\/a><\/p>\n"}
     * caption : {"rendered":""}
     * alt_text :
     * media_type : image
     * mime_type : image/jpeg
     * media_details : {"width":658,"height":365,"file":"2020/04/timg1.jpg","sizes":{"medium":{"file":"timg1-300x166.jpg","width":300,"height":166,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-300x166.jpg"},"thumbnail":{"file":"timg1-150x150.jpg","width":150,"height":150,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-150x150.jpg"},"woocommerce_thumbnail":{"file":"timg1-324x324.jpg","width":324,"height":324,"uncropped":false,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-324x324.jpg"},"woocommerce_single":{"file":"timg1-416x231.jpg","width":416,"height":231,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-416x231.jpg"},"woocommerce_gallery_thumbnail":{"file":"timg1-100x100.jpg","width":100,"height":100,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-100x100.jpg"},"shop_catalog":{"file":"timg1-324x324.jpg","width":324,"height":324,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-324x324.jpg"},"shop_single":{"file":"timg1-416x231.jpg","width":416,"height":231,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-416x231.jpg"},"shop_thumbnail":{"file":"timg1-100x100.jpg","width":100,"height":100,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-100x100.jpg"},"full":{"file":"timg1.jpg","width":658,"height":365,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1.jpg"}},"image_meta":{"aperture":"0","credit":"","camera":"","caption":"","created_timestamp":"0","copyright":"","focal_length":"0","iso":"0","shutter_speed":"0","title":"","orientation":"0","keywords":[]}}
     * post : 79
     * source_url : https://shop.sui.moe/wp-content/uploads/2020/04/timg1.jpg
     * _links : {"self":[{"href":"https://shop.sui.moe/index.php/wp-json/wp/v2/media/80"}],"collection":[{"href":"https://shop.sui.moe/index.php/wp-json/wp/v2/media"}],"about":[{"href":"https://shop.sui.moe/index.php/wp-json/wp/v2/types/attachment"}],"author":[{"embeddable":true,"href":"https://shop.sui.moe/index.php/wp-json/wp/v2/users/1"}],"replies":[{"embeddable":true,"href":"https://shop.sui.moe/index.php/wp-json/wp/v2/comments?post=80"}]}
     */

    private int id;
    private String date;
    private String date_gmt;
    private GuidBean guid;
    private String modified;
    private String modified_gmt;
    private String slug;
    private String status;
    private String type;
    private String link;
    private TitleBean title;
    private int author;
    private String comment_status;
    private String ping_status;
    private String template;
    private DescriptionBean description;
    private CaptionBean caption;
    private String alt_text;
    private String media_type;
    private String mime_type;
    private MediaDetailsBean media_details;
    private int post;
    private String source_url;
    private LinksBean _links;
    private List<?> meta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate_gmt() {
        return date_gmt;
    }

    public void setDate_gmt(String date_gmt) {
        this.date_gmt = date_gmt;
    }

    public GuidBean getGuid() {
        return guid;
    }

    public void setGuid(GuidBean guid) {
        this.guid = guid;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getModified_gmt() {
        return modified_gmt;
    }

    public void setModified_gmt(String modified_gmt) {
        this.modified_gmt = modified_gmt;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public TitleBean getTitle() {
        return title;
    }

    public void setTitle(TitleBean title) {
        this.title = title;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getComment_status() {
        return comment_status;
    }

    public void setComment_status(String comment_status) {
        this.comment_status = comment_status;
    }

    public String getPing_status() {
        return ping_status;
    }

    public void setPing_status(String ping_status) {
        this.ping_status = ping_status;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public DescriptionBean getDescription() {
        return description;
    }

    public void setDescription(DescriptionBean description) {
        this.description = description;
    }

    public CaptionBean getCaption() {
        return caption;
    }

    public void setCaption(CaptionBean caption) {
        this.caption = caption;
    }

    public String getAlt_text() {
        return alt_text;
    }

    public void setAlt_text(String alt_text) {
        this.alt_text = alt_text;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public String getMime_type() {
        return mime_type;
    }

    public void setMime_type(String mime_type) {
        this.mime_type = mime_type;
    }

    public MediaDetailsBean getMedia_details() {
        return media_details;
    }

    public void setMedia_details(MediaDetailsBean media_details) {
        this.media_details = media_details;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public LinksBean get_links() {
        return _links;
    }

    public void set_links(LinksBean _links) {
        this._links = _links;
    }

    public List<?> getMeta() {
        return meta;
    }

    public void setMeta(List<?> meta) {
        this.meta = meta;
    }

    public static class GuidBean {
        /**
         * rendered : http://shop.sui.moe/wp-content/uploads/2020/04/timg1.jpg
         */

        private String rendered;

        public String getRendered() {
            return rendered;
        }

        public void setRendered(String rendered) {
            this.rendered = rendered;
        }
    }

    public static class TitleBean {
        /**
         * rendered : timg[1]
         */

        private String rendered;

        public String getRendered() {
            return rendered;
        }

        public void setRendered(String rendered) {
            this.rendered = rendered;
        }
    }

    public static class DescriptionBean {
        /**
         * rendered : <p class="attachment"><a href='https://shop.sui.moe/wp-content/uploads/2020/04/timg1.jpg'><img width="300" height="166" src="https://shop.sui.moe/wp-content/uploads/2020/04/timg1-300x166.jpg" class="attachment-medium size-medium" alt="" srcset="https://shop.sui.moe/wp-content/uploads/2020/04/timg1-300x166.jpg 300w, https://shop.sui.moe/wp-content/uploads/2020/04/timg1-416x231.jpg 416w, https://shop.sui.moe/wp-content/uploads/2020/04/timg1.jpg 658w" sizes="(max-width: 300px) 100vw, 300px" /></a></p>

         */

        private String rendered;

        public String getRendered() {
            return rendered;
        }

        public void setRendered(String rendered) {
            this.rendered = rendered;
        }
    }

    public static class CaptionBean {
        /**
         * rendered :
         */

        private String rendered;

        public String getRendered() {
            return rendered;
        }

        public void setRendered(String rendered) {
            this.rendered = rendered;
        }
    }

    public static class MediaDetailsBean {
        /**
         * width : 658
         * height : 365
         * file : 2020/04/timg1.jpg
         * sizes : {"medium":{"file":"timg1-300x166.jpg","width":300,"height":166,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-300x166.jpg"},"thumbnail":{"file":"timg1-150x150.jpg","width":150,"height":150,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-150x150.jpg"},"woocommerce_thumbnail":{"file":"timg1-324x324.jpg","width":324,"height":324,"uncropped":false,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-324x324.jpg"},"woocommerce_single":{"file":"timg1-416x231.jpg","width":416,"height":231,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-416x231.jpg"},"woocommerce_gallery_thumbnail":{"file":"timg1-100x100.jpg","width":100,"height":100,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-100x100.jpg"},"shop_catalog":{"file":"timg1-324x324.jpg","width":324,"height":324,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-324x324.jpg"},"shop_single":{"file":"timg1-416x231.jpg","width":416,"height":231,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-416x231.jpg"},"shop_thumbnail":{"file":"timg1-100x100.jpg","width":100,"height":100,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-100x100.jpg"},"full":{"file":"timg1.jpg","width":658,"height":365,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1.jpg"}}
         * image_meta : {"aperture":"0","credit":"","camera":"","caption":"","created_timestamp":"0","copyright":"","focal_length":"0","iso":"0","shutter_speed":"0","title":"","orientation":"0","keywords":[]}
         */

        private int width;
        private int height;
        private String file;
        private SizesBean sizes;
        private ImageMetaBean image_meta;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public SizesBean getSizes() {
            return sizes;
        }

        public void setSizes(SizesBean sizes) {
            this.sizes = sizes;
        }

        public ImageMetaBean getImage_meta() {
            return image_meta;
        }

        public void setImage_meta(ImageMetaBean image_meta) {
            this.image_meta = image_meta;
        }

        public static class SizesBean {
            /**
             * medium : {"file":"timg1-300x166.jpg","width":300,"height":166,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-300x166.jpg"}
             * thumbnail : {"file":"timg1-150x150.jpg","width":150,"height":150,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-150x150.jpg"}
             * woocommerce_thumbnail : {"file":"timg1-324x324.jpg","width":324,"height":324,"uncropped":false,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-324x324.jpg"}
             * woocommerce_single : {"file":"timg1-416x231.jpg","width":416,"height":231,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-416x231.jpg"}
             * woocommerce_gallery_thumbnail : {"file":"timg1-100x100.jpg","width":100,"height":100,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-100x100.jpg"}
             * shop_catalog : {"file":"timg1-324x324.jpg","width":324,"height":324,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-324x324.jpg"}
             * shop_single : {"file":"timg1-416x231.jpg","width":416,"height":231,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-416x231.jpg"}
             * shop_thumbnail : {"file":"timg1-100x100.jpg","width":100,"height":100,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1-100x100.jpg"}
             * full : {"file":"timg1.jpg","width":658,"height":365,"mime_type":"image/jpeg","source_url":"https://shop.sui.moe/wp-content/uploads/2020/04/timg1.jpg"}
             */

            private MediumBean medium;
            private ThumbnailBean thumbnail;
            private WoocommerceThumbnailBean woocommerce_thumbnail;
            private WoocommerceSingleBean woocommerce_single;
            private WoocommerceGalleryThumbnailBean woocommerce_gallery_thumbnail;
            private ShopCatalogBean shop_catalog;
            private ShopSingleBean shop_single;
            private ShopThumbnailBean shop_thumbnail;
            private FullBean full;

            public MediumBean getMedium() {
                return medium;
            }

            public void setMedium(MediumBean medium) {
                this.medium = medium;
            }

            public ThumbnailBean getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(ThumbnailBean thumbnail) {
                this.thumbnail = thumbnail;
            }

            public WoocommerceThumbnailBean getWoocommerce_thumbnail() {
                return woocommerce_thumbnail;
            }

            public void setWoocommerce_thumbnail(WoocommerceThumbnailBean woocommerce_thumbnail) {
                this.woocommerce_thumbnail = woocommerce_thumbnail;
            }

            public WoocommerceSingleBean getWoocommerce_single() {
                return woocommerce_single;
            }

            public void setWoocommerce_single(WoocommerceSingleBean woocommerce_single) {
                this.woocommerce_single = woocommerce_single;
            }

            public WoocommerceGalleryThumbnailBean getWoocommerce_gallery_thumbnail() {
                return woocommerce_gallery_thumbnail;
            }

            public void setWoocommerce_gallery_thumbnail(WoocommerceGalleryThumbnailBean woocommerce_gallery_thumbnail) {
                this.woocommerce_gallery_thumbnail = woocommerce_gallery_thumbnail;
            }

            public ShopCatalogBean getShop_catalog() {
                return shop_catalog;
            }

            public void setShop_catalog(ShopCatalogBean shop_catalog) {
                this.shop_catalog = shop_catalog;
            }

            public ShopSingleBean getShop_single() {
                return shop_single;
            }

            public void setShop_single(ShopSingleBean shop_single) {
                this.shop_single = shop_single;
            }

            public ShopThumbnailBean getShop_thumbnail() {
                return shop_thumbnail;
            }

            public void setShop_thumbnail(ShopThumbnailBean shop_thumbnail) {
                this.shop_thumbnail = shop_thumbnail;
            }

            public FullBean getFull() {
                return full;
            }

            public void setFull(FullBean full) {
                this.full = full;
            }

            public static class MediumBean {
                /**
                 * file : timg1-300x166.jpg
                 * width : 300
                 * height : 166
                 * mime_type : image/jpeg
                 * source_url : https://shop.sui.moe/wp-content/uploads/2020/04/timg1-300x166.jpg
                 */

                private String file;
                private int width;
                private int height;
                private String mime_type;
                private String source_url;

                public String getFile() {
                    return file;
                }

                public void setFile(String file) {
                    this.file = file;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public String getMime_type() {
                    return mime_type;
                }

                public void setMime_type(String mime_type) {
                    this.mime_type = mime_type;
                }

                public String getSource_url() {
                    return source_url;
                }

                public void setSource_url(String source_url) {
                    this.source_url = source_url;
                }
            }

            public static class ThumbnailBean {
                /**
                 * file : timg1-150x150.jpg
                 * width : 150
                 * height : 150
                 * mime_type : image/jpeg
                 * source_url : https://shop.sui.moe/wp-content/uploads/2020/04/timg1-150x150.jpg
                 */

                private String file;
                private int width;
                private int height;
                private String mime_type;
                private String source_url;

                public String getFile() {
                    return file;
                }

                public void setFile(String file) {
                    this.file = file;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public String getMime_type() {
                    return mime_type;
                }

                public void setMime_type(String mime_type) {
                    this.mime_type = mime_type;
                }

                public String getSource_url() {
                    return source_url;
                }

                public void setSource_url(String source_url) {
                    this.source_url = source_url;
                }
            }

            public static class WoocommerceThumbnailBean {
                /**
                 * file : timg1-324x324.jpg
                 * width : 324
                 * height : 324
                 * uncropped : false
                 * mime_type : image/jpeg
                 * source_url : https://shop.sui.moe/wp-content/uploads/2020/04/timg1-324x324.jpg
                 */

                private String file;
                private int width;
                private int height;
                private boolean uncropped;
                private String mime_type;
                private String source_url;

                public String getFile() {
                    return file;
                }

                public void setFile(String file) {
                    this.file = file;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public boolean isUncropped() {
                    return uncropped;
                }

                public void setUncropped(boolean uncropped) {
                    this.uncropped = uncropped;
                }

                public String getMime_type() {
                    return mime_type;
                }

                public void setMime_type(String mime_type) {
                    this.mime_type = mime_type;
                }

                public String getSource_url() {
                    return source_url;
                }

                public void setSource_url(String source_url) {
                    this.source_url = source_url;
                }
            }

            public static class WoocommerceSingleBean {
                /**
                 * file : timg1-416x231.jpg
                 * width : 416
                 * height : 231
                 * mime_type : image/jpeg
                 * source_url : https://shop.sui.moe/wp-content/uploads/2020/04/timg1-416x231.jpg
                 */

                private String file;
                private int width;
                private int height;
                private String mime_type;
                private String source_url;

                public String getFile() {
                    return file;
                }

                public void setFile(String file) {
                    this.file = file;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public String getMime_type() {
                    return mime_type;
                }

                public void setMime_type(String mime_type) {
                    this.mime_type = mime_type;
                }

                public String getSource_url() {
                    return source_url;
                }

                public void setSource_url(String source_url) {
                    this.source_url = source_url;
                }
            }

            public static class WoocommerceGalleryThumbnailBean {
                /**
                 * file : timg1-100x100.jpg
                 * width : 100
                 * height : 100
                 * mime_type : image/jpeg
                 * source_url : https://shop.sui.moe/wp-content/uploads/2020/04/timg1-100x100.jpg
                 */

                private String file;
                private int width;
                private int height;
                private String mime_type;
                private String source_url;

                public String getFile() {
                    return file;
                }

                public void setFile(String file) {
                    this.file = file;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public String getMime_type() {
                    return mime_type;
                }

                public void setMime_type(String mime_type) {
                    this.mime_type = mime_type;
                }

                public String getSource_url() {
                    return source_url;
                }

                public void setSource_url(String source_url) {
                    this.source_url = source_url;
                }
            }

            public static class ShopCatalogBean {
                /**
                 * file : timg1-324x324.jpg
                 * width : 324
                 * height : 324
                 * mime_type : image/jpeg
                 * source_url : https://shop.sui.moe/wp-content/uploads/2020/04/timg1-324x324.jpg
                 */

                private String file;
                private int width;
                private int height;
                private String mime_type;
                private String source_url;

                public String getFile() {
                    return file;
                }

                public void setFile(String file) {
                    this.file = file;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public String getMime_type() {
                    return mime_type;
                }

                public void setMime_type(String mime_type) {
                    this.mime_type = mime_type;
                }

                public String getSource_url() {
                    return source_url;
                }

                public void setSource_url(String source_url) {
                    this.source_url = source_url;
                }
            }

            public static class ShopSingleBean {
                /**
                 * file : timg1-416x231.jpg
                 * width : 416
                 * height : 231
                 * mime_type : image/jpeg
                 * source_url : https://shop.sui.moe/wp-content/uploads/2020/04/timg1-416x231.jpg
                 */

                private String file;
                private int width;
                private int height;
                private String mime_type;
                private String source_url;

                public String getFile() {
                    return file;
                }

                public void setFile(String file) {
                    this.file = file;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public String getMime_type() {
                    return mime_type;
                }

                public void setMime_type(String mime_type) {
                    this.mime_type = mime_type;
                }

                public String getSource_url() {
                    return source_url;
                }

                public void setSource_url(String source_url) {
                    this.source_url = source_url;
                }
            }

            public static class ShopThumbnailBean {
                /**
                 * file : timg1-100x100.jpg
                 * width : 100
                 * height : 100
                 * mime_type : image/jpeg
                 * source_url : https://shop.sui.moe/wp-content/uploads/2020/04/timg1-100x100.jpg
                 */

                private String file;
                private int width;
                private int height;
                private String mime_type;
                private String source_url;

                public String getFile() {
                    return file;
                }

                public void setFile(String file) {
                    this.file = file;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public String getMime_type() {
                    return mime_type;
                }

                public void setMime_type(String mime_type) {
                    this.mime_type = mime_type;
                }

                public String getSource_url() {
                    return source_url;
                }

                public void setSource_url(String source_url) {
                    this.source_url = source_url;
                }
            }

            public static class FullBean {
                /**
                 * file : timg1.jpg
                 * width : 658
                 * height : 365
                 * mime_type : image/jpeg
                 * source_url : https://shop.sui.moe/wp-content/uploads/2020/04/timg1.jpg
                 */

                private String file;
                private int width;
                private int height;
                private String mime_type;
                private String source_url;

                public String getFile() {
                    return file;
                }

                public void setFile(String file) {
                    this.file = file;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public String getMime_type() {
                    return mime_type;
                }

                public void setMime_type(String mime_type) {
                    this.mime_type = mime_type;
                }

                public String getSource_url() {
                    return source_url;
                }

                public void setSource_url(String source_url) {
                    this.source_url = source_url;
                }
            }
        }

        public static class ImageMetaBean {
            /**
             * aperture : 0
             * credit :
             * camera :
             * caption :
             * created_timestamp : 0
             * copyright :
             * focal_length : 0
             * iso : 0
             * shutter_speed : 0
             * title :
             * orientation : 0
             * keywords : []
             */

            private String aperture;
            private String credit;
            private String camera;
            private String caption;
            private String created_timestamp;
            private String copyright;
            private String focal_length;
            private String iso;
            private String shutter_speed;
            private String title;
            private String orientation;
            private List<?> keywords;

            public String getAperture() {
                return aperture;
            }

            public void setAperture(String aperture) {
                this.aperture = aperture;
            }

            public String getCredit() {
                return credit;
            }

            public void setCredit(String credit) {
                this.credit = credit;
            }

            public String getCamera() {
                return camera;
            }

            public void setCamera(String camera) {
                this.camera = camera;
            }

            public String getCaption() {
                return caption;
            }

            public void setCaption(String caption) {
                this.caption = caption;
            }

            public String getCreated_timestamp() {
                return created_timestamp;
            }

            public void setCreated_timestamp(String created_timestamp) {
                this.created_timestamp = created_timestamp;
            }

            public String getCopyright() {
                return copyright;
            }

            public void setCopyright(String copyright) {
                this.copyright = copyright;
            }

            public String getFocal_length() {
                return focal_length;
            }

            public void setFocal_length(String focal_length) {
                this.focal_length = focal_length;
            }

            public String getIso() {
                return iso;
            }

            public void setIso(String iso) {
                this.iso = iso;
            }

            public String getShutter_speed() {
                return shutter_speed;
            }

            public void setShutter_speed(String shutter_speed) {
                this.shutter_speed = shutter_speed;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getOrientation() {
                return orientation;
            }

            public void setOrientation(String orientation) {
                this.orientation = orientation;
            }

            public List<?> getKeywords() {
                return keywords;
            }

            public void setKeywords(List<?> keywords) {
                this.keywords = keywords;
            }
        }
    }

    public static class LinksBean {
        private List<SelfBean> self;
        private List<CollectionBean> collection;
        private List<AboutBean> about;
        private List<AuthorBean> author;
        private List<RepliesBean> replies;

        public List<SelfBean> getSelf() {
            return self;
        }

        public void setSelf(List<SelfBean> self) {
            this.self = self;
        }

        public List<CollectionBean> getCollection() {
            return collection;
        }

        public void setCollection(List<CollectionBean> collection) {
            this.collection = collection;
        }

        public List<AboutBean> getAbout() {
            return about;
        }

        public void setAbout(List<AboutBean> about) {
            this.about = about;
        }

        public List<AuthorBean> getAuthor() {
            return author;
        }

        public void setAuthor(List<AuthorBean> author) {
            this.author = author;
        }

        public List<RepliesBean> getReplies() {
            return replies;
        }

        public void setReplies(List<RepliesBean> replies) {
            this.replies = replies;
        }

        public static class SelfBean {
            /**
             * href : https://shop.sui.moe/index.php/wp-json/wp/v2/media/80
             */

            private String href;

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        public static class CollectionBean {
            /**
             * href : https://shop.sui.moe/index.php/wp-json/wp/v2/media
             */

            private String href;

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        public static class AboutBean {
            /**
             * href : https://shop.sui.moe/index.php/wp-json/wp/v2/types/attachment
             */

            private String href;

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        public static class AuthorBean {
            /**
             * embeddable : true
             * href : https://shop.sui.moe/index.php/wp-json/wp/v2/users/1
             */

            private boolean embeddable;
            private String href;

            public boolean isEmbeddable() {
                return embeddable;
            }

            public void setEmbeddable(boolean embeddable) {
                this.embeddable = embeddable;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        public static class RepliesBean {
            /**
             * embeddable : true
             * href : https://shop.sui.moe/index.php/wp-json/wp/v2/comments?post=80
             */

            private boolean embeddable;
            private String href;

            public boolean isEmbeddable() {
                return embeddable;
            }

            public void setEmbeddable(boolean embeddable) {
                this.embeddable = embeddable;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }
    }
}
