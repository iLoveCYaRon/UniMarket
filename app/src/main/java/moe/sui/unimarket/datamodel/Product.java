package moe.sui.unimarket.datamodel;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import java.io.Serializable;
import java.util.List;

import moe.sui.unimarket.adapter.UniMarketDatabase;

@Table(database = UniMarketDatabase.class)
public class Product implements Serializable {
    /**
     * id : 23
     * name : Album
     * slug : album
     * permalink : https://shop.sui.moe/index.php/product/album/
     * date_created : 2020-04-22T19:01:59
     * date_created_gmt : 2020-04-22T11:01:59
     * date_modified : 2020-04-23T14:48:00
     * date_modified_gmt : 2020-04-23T06:48:00
     * type : simple
     * status : publish
     * featured : false
     * catalog_visibility : visible
     * description : <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sagittis orci ac odio dictum tincidunt. Donec ut metus leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed luctus, dui eu sagittis sodales, nulla nibh sagittis augue, vel porttitor diam enim non metus. Vestibulum aliquam augue neque. Phasellus tincidunt odio eget ullamcorper efficitur. Cras placerat ut turpis pellentesque vulputate. Nam sed consequat tortor. Curabitur finibus sapien dolor. Ut eleifend tellus nec erat pulvinar dignissim. Nam non arcu purus. Vivamus et massa massa.</p>
     * short_description : <p>This is a simple, virtual product.</p>
     * sku : woo-album
     * price : 15
     * regular_price : 15
     * sale_price :
     * date_on_sale_from : null
     * date_on_sale_from_gmt : null
     * date_on_sale_to : null
     * date_on_sale_to_gmt : null
     * price_html : <span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">&yen;</span>15.00</span>
     * on_sale : false
     * purchasable : true
     * total_sales : 0
     * virtual : false
     * downloadable : false
     * downloads : []
     * download_limit : 1
     * download_expiry : 1
     * external_url :
     * button_text :
     * tax_status : taxable
     * tax_class :
     * manage_stock : false
     * stock_quantity : null
     * stock_status : instock
     * backorders : no
     * backorders_allowed : false
     * backordered : false
     * sold_individually : false
     * weight :
     * dimensions : {"length":"","width":"","height":""}
     * shipping_required : true
     * shipping_taxable : true
     * shipping_class :
     * shipping_class_id : 0
     * reviews_allowed : true
     * average_rating : 0.00
     * rating_count : 0
     * related_ids : [24]
     * upsell_ids : []
     * cross_sell_ids : []
     * parent_id : 0
     * purchase_note :
     * categories : [{"id":20,"name":"Music","slug":"music"}]
     * tags : [{"id":30,"name":"MusicTag","slug":"musictag"}]
     * images : [{"id":52,"date_created":"2020-04-23T03:02:12","date_created_gmt":"2020-04-22T11:02:12","date_modified":"2020-04-23T03:02:12","date_modified_gmt":"2020-04-22T11:02:12","src":"https://shop.sui.moe/wp-content/uploads/2020/04/album-1.jpg","name":"album-1.jpg","alt":""}]
     * attributes : [{"id":1,"name":"Color","position":0,"visible":true,"variation":false,"options":["Blue"]},{"id":0,"name":"ManAttr","position":1,"visible":true,"variation":false,"options":["Test"]}]
     * default_attributes : []
     * variations : []
     * grouped_products : []
     * menu_order : 0
     * meta_data : [{"id":225,"key":"_original_id","value":"73"},{"id":552,"key":"_wpcom_is_markdown","value":"1"}]
     * _links : {"self":[{"href":"https://shop.sui.moe/index.php/wp-json/wc/v3/products/23"}],"collection":[{"href":"https://shop.sui.moe/index.php/wp-json/wc/v3/products"}]}
     */

    @PrimaryKey
    private int id;
    @Column
    private String name;
    private String slug;
    private String permalink;
    private String date_created;
    private String date_created_gmt;
    private String date_modified;
    private String date_modified_gmt;
    private String type;
    private String status;
    private boolean featured;
    private String catalog_visibility;
    @Column
    private String description;
    @Column
    private String short_description;
    private String sku;
    @Column
    private String price;
    private String regular_price;
    private String sale_price;
    private Object date_on_sale_from;
    private Object date_on_sale_from_gmt;
    private Object date_on_sale_to;
    private Object date_on_sale_to_gmt;
    private String price_html;
    private boolean on_sale;
    private boolean purchasable;
    private int total_sales;
    private boolean virtual;
    private boolean downloadable;
    private int download_limit;
    private int download_expiry;
    private String external_url;
    private String button_text;
    private String tax_status;
    private String tax_class;
    private boolean manage_stock;
    private Object stock_quantity;
    private String stock_status;
    private String backorders;
    private boolean backorders_allowed;
    private boolean backordered;
    private boolean sold_individually;
    private String weight;
    private DimensionsBean dimensions;
    private boolean shipping_required;
    private boolean shipping_taxable;
    private String shipping_class;
    private int shipping_class_id;
    private boolean reviews_allowed;
    private String average_rating;
    private int rating_count;
    private int parent_id;
    private String purchase_note;
    private int menu_order;
    private LinksBean _links;
    private List<Integer> related_ids;
    private List<CategoriesBean> categories;
    private List<TagsBean> tags;
    private List<ImagesBean> images;
    private List<AttributesBean> attributes;
    private List<MetaDataBean> meta_data;

    @Column
    private String titleImageLink;

    public String getTitleImageLink() {
        return titleImageLink;
    }

    public void setTitleImageLink(String titleImageLink) {
        this.titleImageLink = titleImageLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getDate_created_gmt() {
        return date_created_gmt;
    }

    public void setDate_created_gmt(String date_created_gmt) {
        this.date_created_gmt = date_created_gmt;
    }

    public String getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(String date_modified) {
        this.date_modified = date_modified;
    }

    public String getDate_modified_gmt() {
        return date_modified_gmt;
    }

    public void setDate_modified_gmt(String date_modified_gmt) {
        this.date_modified_gmt = date_modified_gmt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public String getCatalog_visibility() {
        return catalog_visibility;
    }

    public void setCatalog_visibility(String catalog_visibility) {
        this.catalog_visibility = catalog_visibility;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRegular_price() {
        return regular_price;
    }

    public void setRegular_price(String regular_price) {
        this.regular_price = regular_price;
    }

    public String getSale_price() {
        return sale_price;
    }

    public void setSale_price(String sale_price) {
        this.sale_price = sale_price;
    }

    public Object getDate_on_sale_from() {
        return date_on_sale_from;
    }

    public void setDate_on_sale_from(Object date_on_sale_from) {
        this.date_on_sale_from = date_on_sale_from;
    }

    public Object getDate_on_sale_from_gmt() {
        return date_on_sale_from_gmt;
    }

    public void setDate_on_sale_from_gmt(Object date_on_sale_from_gmt) {
        this.date_on_sale_from_gmt = date_on_sale_from_gmt;
    }

    public Object getDate_on_sale_to() {
        return date_on_sale_to;
    }

    public void setDate_on_sale_to(Object date_on_sale_to) {
        this.date_on_sale_to = date_on_sale_to;
    }

    public Object getDate_on_sale_to_gmt() {
        return date_on_sale_to_gmt;
    }

    public void setDate_on_sale_to_gmt(Object date_on_sale_to_gmt) {
        this.date_on_sale_to_gmt = date_on_sale_to_gmt;
    }

    public String getPrice_html() {
        return price_html;
    }

    public void setPrice_html(String price_html) {
        this.price_html = price_html;
    }

    public boolean isOn_sale() {
        return on_sale;
    }

    public void setOn_sale(boolean on_sale) {
        this.on_sale = on_sale;
    }

    public boolean isPurchasable() {
        return purchasable;
    }

    public void setPurchasable(boolean purchasable) {
        this.purchasable = purchasable;
    }

    public int getTotal_sales() {
        return total_sales;
    }

    public void setTotal_sales(int total_sales) {
        this.total_sales = total_sales;
    }

    public boolean isVirtual() {
        return virtual;
    }

    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }

    public boolean isDownloadable() {
        return downloadable;
    }

    public void setDownloadable(boolean downloadable) {
        this.downloadable = downloadable;
    }

    public int getDownload_limit() {
        return download_limit;
    }

    public void setDownload_limit(int download_limit) {
        this.download_limit = download_limit;
    }

    public int getDownload_expiry() {
        return download_expiry;
    }

    public void setDownload_expiry(int download_expiry) {
        this.download_expiry = download_expiry;
    }

    public String getExternal_url() {
        return external_url;
    }

    public void setExternal_url(String external_url) {
        this.external_url = external_url;
    }

    public String getButton_text() {
        return button_text;
    }

    public void setButton_text(String button_text) {
        this.button_text = button_text;
    }

    public String getTax_status() {
        return tax_status;
    }

    public void setTax_status(String tax_status) {
        this.tax_status = tax_status;
    }

    public String getTax_class() {
        return tax_class;
    }

    public void setTax_class(String tax_class) {
        this.tax_class = tax_class;
    }

    public boolean isManage_stock() {
        return manage_stock;
    }

    public void setManage_stock(boolean manage_stock) {
        this.manage_stock = manage_stock;
    }

    public Object getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(Object stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public String getStock_status() {
        return stock_status;
    }

    public void setStock_status(String stock_status) {
        this.stock_status = stock_status;
    }

    public String getBackorders() {
        return backorders;
    }

    public void setBackorders(String backorders) {
        this.backorders = backorders;
    }

    public boolean isBackorders_allowed() {
        return backorders_allowed;
    }

    public void setBackorders_allowed(boolean backorders_allowed) {
        this.backorders_allowed = backorders_allowed;
    }

    public boolean isBackordered() {
        return backordered;
    }

    public void setBackordered(boolean backordered) {
        this.backordered = backordered;
    }

    public boolean isSold_individually() {
        return sold_individually;
    }

    public void setSold_individually(boolean sold_individually) {
        this.sold_individually = sold_individually;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public DimensionsBean getDimensions() {
        return dimensions;
    }

    public void setDimensions(DimensionsBean dimensions) {
        this.dimensions = dimensions;
    }

    public boolean isShipping_required() {
        return shipping_required;
    }

    public void setShipping_required(boolean shipping_required) {
        this.shipping_required = shipping_required;
    }

    public boolean isShipping_taxable() {
        return shipping_taxable;
    }

    public void setShipping_taxable(boolean shipping_taxable) {
        this.shipping_taxable = shipping_taxable;
    }

    public String getShipping_class() {
        return shipping_class;
    }

    public void setShipping_class(String shipping_class) {
        this.shipping_class = shipping_class;
    }

    public int getShipping_class_id() {
        return shipping_class_id;
    }

    public void setShipping_class_id(int shipping_class_id) {
        this.shipping_class_id = shipping_class_id;
    }

    public boolean isReviews_allowed() {
        return reviews_allowed;
    }

    public void setReviews_allowed(boolean reviews_allowed) {
        this.reviews_allowed = reviews_allowed;
    }

    public String getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(String average_rating) {
        this.average_rating = average_rating;
    }

    public int getRating_count() {
        return rating_count;
    }

    public void setRating_count(int rating_count) {
        this.rating_count = rating_count;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getPurchase_note() {
        return purchase_note;
    }

    public void setPurchase_note(String purchase_note) {
        this.purchase_note = purchase_note;
    }

    public int getMenu_order() {
        return menu_order;
    }

    public void setMenu_order(int menu_order) {
        this.menu_order = menu_order;
    }

    public LinksBean get_links() {
        return _links;
    }

    public void set_links(LinksBean _links) {
        this._links = _links;
    }


    public List<Integer> getRelated_ids() {
        return related_ids;
    }

    public void setRelated_ids(List<Integer> related_ids) {
        this.related_ids = related_ids;
    }

    public List<CategoriesBean> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesBean> categories) {
        this.categories = categories;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public List<ImagesBean> getImages() {
        return images;
    }

    public void setImages(List<ImagesBean> images) {
        this.images = images;
    }

    public List<AttributesBean> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributesBean> attributes) {
        this.attributes = attributes;
    }


    public List<MetaDataBean> getMeta_data() {
        return meta_data;
    }

    public void setMeta_data(List<MetaDataBean> meta_data) {
        this.meta_data = meta_data;
    }

    public static class DimensionsBean {
        /**
         * length :
         * width :
         * height :
         */

        private String length;
        private String width;
        private String height;

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }
    }

    public static class LinksBean {
        private List<SelfBean> self;
        private List<CollectionBean> collection;

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

        public static class SelfBean {
            /**
             * href : https://shop.sui.moe/index.php/wp-json/wc/v3/products/23
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
             * href : https://shop.sui.moe/index.php/wp-json/wc/v3/products
             */

            private String href;

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }
    }

    public static class CategoriesBean {
        /**
         * id : 20
         * name : Music
         * slug : music
         */

        private int id;
        private String name;
        private String slug;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }
    }

    public static class TagsBean {
        /**
         * id : 30
         * name : MusicTag
         * slug : musictag
         */

        private int id;
        private String name;
        private String slug;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }
    }

    public static class ImagesBean {
        /**
         * id : 52
         * date_created : 2020-04-23T03:02:12
         * date_created_gmt : 2020-04-22T11:02:12
         * date_modified : 2020-04-23T03:02:12
         * date_modified_gmt : 2020-04-22T11:02:12
         * src : https://shop.sui.moe/wp-content/uploads/2020/04/album-1.jpg
         * name : album-1.jpg
         * alt :
         */

        private int id;
        private String date_created;
        private String date_created_gmt;
        private String date_modified;
        private String date_modified_gmt;
        private String src;
        private String name;
        private String alt;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDate_created() {
            return date_created;
        }

        public void setDate_created(String date_created) {
            this.date_created = date_created;
        }

        public String getDate_created_gmt() {
            return date_created_gmt;
        }

        public void setDate_created_gmt(String date_created_gmt) {
            this.date_created_gmt = date_created_gmt;
        }

        public String getDate_modified() {
            return date_modified;
        }

        public void setDate_modified(String date_modified) {
            this.date_modified = date_modified;
        }

        public String getDate_modified_gmt() {
            return date_modified_gmt;
        }

        public void setDate_modified_gmt(String date_modified_gmt) {
            this.date_modified_gmt = date_modified_gmt;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }
    }

    public static class AttributesBean {
        /**
         * id : 1
         * name : Color
         * position : 0
         * visible : true
         * variation : false
         * options : ["Blue"]
         */

        private int id;
        private String name;
        private int position;
        private boolean visible;
        private boolean variation;
        private List<String> options;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public boolean isVisible() {
            return visible;
        }

        public void setVisible(boolean visible) {
            this.visible = visible;
        }

        public boolean isVariation() {
            return variation;
        }

        public void setVariation(boolean variation) {
            this.variation = variation;
        }

        public List<String> getOptions() {
            return options;
        }

        public void setOptions(List<String> options) {
            this.options = options;
        }
    }

    public static class MetaDataBean {
        /**
         * id : 225
         * key : _original_id
         * value : 73
         */

        private int id;
        private String key;
        private String value;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}