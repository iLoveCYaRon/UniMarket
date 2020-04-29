package moe.sui.unimarket.datamodel;

import java.util.List;

public class ProductTag {

    /**
     * id : 52
     * name : BDCT
     * slug : bdct
     * description :
     * count : 2
     * _links : {"self":[{"href":"https://shop.sui.moe/index.php/wp-json/wc/v3/products/tags/52"}],"collection":[{"href":"https://shop.sui.moe/index.php/wp-json/wc/v3/products/tags"}]}
     */

    private int id;
    private String name;
    private String slug;
    private String description;
    private int count;
    private LinksBean _links;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LinksBean get_links() {
        return _links;
    }

    public void set_links(LinksBean _links) {
        this._links = _links;
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
             * href : https://shop.sui.moe/index.php/wp-json/wc/v3/products/tags/52
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
             * href : https://shop.sui.moe/index.php/wp-json/wc/v3/products/tags
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
}
